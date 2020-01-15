package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectories;
import com.amazon.ws.emr.hadoop.fs.files.TemporaryFiles;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ObjectCreationEvent;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ObjectCreationEvent.ObjectCreationEventBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.SinglePartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadConstraint;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlan;
import com.amazon.ws.emr.hadoop.fs.s3n.ProgressableResettableBufferedFileInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.common.Abortable;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3FSOutputStream
  extends OutputStream
  implements Abortable
{
  private static final Logger LOG = LoggerFactory.getLogger(S3FSOutputStream.class);
  private OutputStream localFileStream;
  private Path localPath;
  private MessageDigest digest;
  private long contentLength;
  private long currentPartLength;
  private boolean isClosed = false;
  private MultipartUploadManager multipartUpload = null;
  private final AmazonS3Lite s3;
  private final String uniqueFileId = UUID.randomUUID().toString();
  private final String bucketName;
  private final String key;
  private final long PART_SIZE_DEFAULT = 134217728L;
  private long partSize;
  private final Progressable progress;
  private final Configuration configuration;
  private final ListeningExecutorService executorService;
  private final UploadPlan uploadPlan;
  private final ProgressListener progressListener;
  private final String serverSideEncryptionAlgorithm;
  private final String serverSideEncryptionKmsKeyId;
  private final S3ObjectRequestFactory s3ObjectRequestFactory;
  private final ExecutorService progressExecutor;
  private final int INTERNAL_BUFFER_SIZE = 524288;
  private final ByteBuffer internalBuffer;
  private final long S3_MIN_PART_SIZE = 5242880L;
  private final TemporaryDirectories temporaryDirectories;
  private final TemporaryFiles temporaryFiles;
  
  public S3FSOutputStream(AmazonS3Lite s3, UploadPlan uploadPlan, String serverSideEncryptionAlgorithm, String serverSideEncryptionKmsKeyId, ListeningExecutorService executorService, Progressable progressable, Configuration configuration, TemporaryDirectories temporaryDirectories)
  {
    Preconditions.checkArgument(uploadPlan.getConstraint() != UploadConstraint.SINGLE_PART_UPLOAD, "S3FSOutputStream cannot be used when constrained to single part uploads");
    
    this.uploadPlan = uploadPlan;
    bucketName = uploadPlan.getBucket();
    key = uploadPlan.getKey();
    progress = progressable;
    this.configuration = configuration;
    this.s3 = s3;
    this.serverSideEncryptionAlgorithm = serverSideEncryptionAlgorithm;
    this.serverSideEncryptionKmsKeyId = serverSideEncryptionKmsKeyId;
    
    s3ObjectRequestFactory = new S3ObjectRequestFactory(configuration, serverSideEncryptionKmsKeyId);
    
    partSize = configuration.getLong("fs.s3n.multipart.uploads.split.size", 134217728L);
    if (partSize < 5242880L)
    {
      LOG.warn("fs.s3n.multipart.uploads.split.size = {} is too small, setting to min {}", Long.valueOf(partSize), Long.valueOf(5242880L));
      partSize = 5242880L;
    }
    this.executorService = executorService;
    internalBuffer = ByteBuffer.allocate(524288);
    
    progressExecutor = new ThreadPoolExecutor(1, 3, 20L, TimeUnit.SECONDS, new LinkedBlockingDeque(100), new ThreadFactory()
    
      new ThreadPoolExecutor.DiscardOldestPolicy
      {
        private int threadCount = 1;
        
        public Thread newThread(Runnable r)
        {
          Thread thread = new Thread(r);
          thread.setName("progress-reporter" + threadCount++);
          thread.setDaemon(true);
          return thread;
        }
      }, new ThreadPoolExecutor.DiscardOldestPolicy());
    
    ProgressListener progressListener = null;
    if (progress != null)
    {
      progressListener = new ProgressListener()
      {
        public void progressChanged(ProgressEvent progressEvent)
        {
          progressExecutor.submit(new Runnable()
          {
            public void run()
            {
              progress.progress();
            }
          });
        }
      };
      progressListener.progressChanged(null);
    }
    this.progressListener = progressListener;
    this.temporaryDirectories = temporaryDirectories;
    temporaryFiles = new TemporaryFiles(temporaryDirectories);
  }
  
  public void abort()
    throws IOException
  {}
  
  public synchronized void flush()
    throws IOException
  {
    if (internalBuffer.position() > 0)
    {
      LOG.debug("flushing the internal buffer.");
      writeInternal(internalBuffer.array(), 0, internalBuffer.position());
      internalBuffer.clear();
    }
  }
  
  public void write(int b)
    throws IOException
  {
    write(new byte[] { (byte)b }, 0, 1);
  }
  
  public void write(byte[] b)
    throws IOException
  {
    write(b, 0, b.length);
  }
  
  public void close()
    throws IOException
  {
    if (isClosed) {
      return;
    }
    isClosed = true;
    try
    {
      doClose();
    }
    catch (IOException|RuntimeException e)
    {
      releaseResourcesIfNeededThenRethrow(e);
    }
    finally
    {
      temporaryDirectories.close();
    }
    LOG.debug("Closed {}:{}", bucketName, key);
  }
  
  private void doClose()
    throws IOException
  {
    LOG.debug("Closing {}:{}", bucketName, key);
    flush();
    if (localFileStream == null) {
      startNewTempFile();
    }
    localFileStream.close();
    if (constrainedToMultipartUpload()) {
      ensureMultipartUploadIsInitiated();
    }
    if (multipartUpload != null) {
      finishMultipartUpload();
    } else {
      uploadSingleCompleteFile();
    }
  }
  
  private void releaseResourcesIfNeededThenRethrow(Exception thrown)
    throws IOException
  {
    closeLocalFileStreamIfNotNull(thrown);
    abortMultipartUploadIfInProgress(thrown);
    rethrowAsIsOrWrapped(thrown);
  }
  
  private void closeLocalFileStreamIfNotNull(Exception thrown)
  {
    if (localFileStream != null) {
      closeLocalFileStreamOnFailure(thrown);
    }
  }
  
  private void closeLocalFileStreamOnFailure(Exception thrown)
  {
    try
    {
      localFileStream.close();
    }
    catch (IOException|RuntimeException closeException)
    {
      LOG.error("Error closing local file output stream at {}", localPath, closeException);
      thrown.addSuppressed(closeException);
    }
  }
  
  private void abortMultipartUploadIfInProgress(Exception thrown)
  {
    if (isMultipartUploadInProgress()) {
      abortMultipartUploadOnFailure(thrown);
    }
  }
  
  private boolean isMultipartUploadInProgress()
  {
    return (multipartUpload != null) && (multipartUpload.isInProgress());
  }
  
  private void abortMultipartUploadOnFailure(Exception thrown)
  {
    try
    {
      multipartUpload.abort();
    }
    catch (IOException|RuntimeException abortException)
    {
      LOG.error("Error aborting multipart upload for bucket '{}' key '{}'", new Object[] { bucketName, key, abortException });
      
      thrown.addSuppressed(abortException);
    }
  }
  
  private void finishMultipartUpload()
    throws IOException
  {
    if (shouldUploadFinalPartBeforeCommitting()) {
      uploadFinalPartBeforeCommitting();
    }
    multipartUpload.commit();
  }
  
  private boolean shouldUploadFinalPartBeforeCommitting()
  {
    boolean hasRemainingBytesToUpload = currentPartLength > 0L;
    
    boolean needsEmptyPartUploaded = contentLength == 0L;
    return (hasRemainingBytesToUpload) || (needsEmptyPartUploaded);
  }
  
  private void uploadFinalPartBeforeCommitting()
    throws IOException
  {
    if (contentLength < partSize) {
      uploadOnlyPartSynchronously();
    } else {
      uploadPartAsynchronously();
    }
  }
  
  public synchronized void write(byte[] b, int off, int len)
    throws IOException
  {
    if (len > internalBuffer.remaining())
    {
      writeInternal(internalBuffer.array(), 0, internalBuffer.position());
      internalBuffer.clear();
      if (len > internalBuffer.remaining()) {
        writeInternal(b, off, len);
      } else {
        internalBuffer.put(b, off, len);
      }
    }
    else
    {
      internalBuffer.put(b, off, len);
    }
  }
  
  private void writeInternal(byte[] b, int off, int len)
    throws IOException
  {
    while (len > 0)
    {
      if (progressListener != null) {
        progressListener.progressChanged(null);
      }
      long useLen = len;
      if (useLen + currentPartLength > partSize) {
        useLen = partSize - currentPartLength;
      }
      if (useLen > 0L)
      {
        if (localFileStream == null) {
          startNewTempFile();
        }
        localFileStream.write(b, off, (int)useLen);
        currentPartLength += useLen;
        contentLength += useLen;
        off = (int)(off + useLen);
        len = (int)(len - useLen);
      }
      if (currentPartLength >= partSize) {
        uploadPartAsynchronously();
      }
    }
  }
  
  private boolean constrainedToMultipartUpload()
  {
    return uploadPlan.getConstraint() == UploadConstraint.MULTIPART_UPLOAD;
  }
  
  private void ensureMultipartUploadIsInitiated()
    throws IOException
  {
    if (multipartUpload == null)
    {
      multipartUpload = buildMultipartUploadManager();
      multipartUpload.start();
    }
  }
  
  @VisibleForTesting
  MultipartUploadManager buildMultipartUploadManager()
  {
    return 
    
      new MultipartUploadManager.Builder().withUploadPlan(uploadPlan).withUploadId(uniqueFileId).withServerSideEncryptionAlgorithm(serverSideEncryptionAlgorithm).withServerSideKmsKeyId(serverSideEncryptionKmsKeyId).withS3(s3).withExecutorService(executorService).withProgressable(progress).withConf(configuration).withMaxPartSize(partSize).withTemporaryFiles(temporaryFiles).build();
  }
  
  private void uploadPartAsynchronously()
    throws IOException
  {
    ensureMultipartUploadIsInitiated();
    localFileStream.close();
    multipartUpload.addPartAsynchronously(localPath);
    resetLocalFileReferences();
  }
  
  private void uploadOnlyPartSynchronously()
    throws IOException
  {
    ensureMultipartUploadIsInitiated();
    localFileStream.close();
    multipartUpload.addOnlyPartSynchronously(localPath);
    resetLocalFileReferences();
  }
  
  private void startNewTempFile()
    throws IOException
  {
    currentPartLength = 0L;
    localPath = createTemporaryFile();
    try
    {
      digest = MessageDigest.getInstance("MD5");
      
      localFileStream = new BufferedOutputStream(new DigestOutputStream(createLocalFileStream(), digest));
    }
    catch (NoSuchAlgorithmException e)
    {
      LOG.warn("Cannot load MD5 digest algorithm, skipping message integrity check.", e);
      localFileStream = new BufferedOutputStream(createLocalFileStream());
    }
    LOG.debug("Started new temp file with path {}", localPath.toAbsolutePath());
  }
  
  @VisibleForTesting
  Path createTemporaryFile()
    throws IOException
  {
    return temporaryFiles.create();
  }
  
  @VisibleForTesting
  OutputStream createLocalFileStream()
    throws FileNotFoundException
  {
    return new FileOutputStream(localPath.toFile());
  }
  
  private void uploadSingleCompleteFile()
    throws IOException
  {
    try
    {
      InputStream inputStream = new ProgressableResettableBufferedFileInputStream(localPath.toFile(), null);Throwable localThrowable3 = null;
      try
      {
        uploadPlan.getSinglePartDispatcher().create(newObjectCreationEvent(inputStream));
      }
      catch (Throwable localThrowable1)
      {
        localThrowable3 = localThrowable1;throw localThrowable1;
      }
      finally
      {
        if (inputStream != null) {
          if (localThrowable3 != null) {
            try
            {
              inputStream.close();
            }
            catch (Throwable localThrowable2)
            {
              localThrowable3.addSuppressed(localThrowable2);
            }
          } else {
            inputStream.close();
          }
        }
      }
    }
    finally
    {
      temporaryFiles.delete(localPath);
      resetLocalFileReferences();
    }
  }
  
  private ObjectCreationEvent newObjectCreationEvent(InputStream inputStream)
    throws IOException
  {
    ObjectCreationEvent.ObjectCreationEventBuilder eventBuilder = ObjectCreationEvent.builder().bucket(bucketName).key(key).contentStream(inputStream).contentLength(Files.size(localPath)).serverSideEncryptionAlgorithm(serverSideEncryptionAlgorithm).progressListener(progressListener).extraUploadMetadata(uploadPlan.getExtraUploadMetadata());
    if (digest != null) {
      eventBuilder.contentMD5(new String(Base64.encodeBase64(digest.digest())));
    }
    return eventBuilder.build();
  }
  
  private void resetLocalFileReferences()
  {
    localPath = null;
    localFileStream = null;
    currentPartLength = 0L;
  }
  
  private static void rethrowAsIsOrWrapped(Exception thrown)
    throws IOException
  {
    Throwables.propagateIfPossible(thrown, IOException.class);
    throw new RuntimeException(thrown);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3FSOutputStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */