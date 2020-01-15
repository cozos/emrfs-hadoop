package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Encryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.FileLocks;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.Mimetypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.RequestCopyUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectTagging;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.FileLockException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyCallable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileDownloadImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileTransferMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileUploadImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PreparedDownloadContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignUrlDownloadCallable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignedUrlDownloadImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferManagerUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferProgressUpdatingListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferStateChangeListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadCallable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class TransferManager
{
  private final AmazonS3 s3;
  private TransferManagerConfiguration configuration;
  private final ExecutorService executorService;
  private final ScheduledExecutorService timedThreadPool = new ScheduledThreadPoolExecutor(1, daemonThreadFactory);
  private static final Log log = LogFactory.getLog(TransferManager.class);
  private final boolean shutDownThreadPools;
  private final boolean isImmutable;
  
  @Deprecated
  public TransferManager()
  {
    this(new AmazonS3Client(new DefaultAWSCredentialsProviderChain()));
  }
  
  @Deprecated
  public TransferManager(AWSCredentialsProvider credentialsProvider)
  {
    this(new AmazonS3Client(credentialsProvider));
  }
  
  @Deprecated
  public TransferManager(AWSCredentials credentials)
  {
    this(new AmazonS3Client(credentials));
  }
  
  @Deprecated
  public TransferManager(AmazonS3 s3)
  {
    this(s3, TransferManagerUtils.createDefaultExecutorService());
  }
  
  @Deprecated
  public TransferManager(AmazonS3 s3, ExecutorService executorService)
  {
    this(s3, executorService, true);
  }
  
  @Deprecated
  public TransferManager(AmazonS3 s3, ExecutorService executorService, boolean shutDownThreadPools)
  {
    this.s3 = s3;
    this.executorService = executorService;
    configuration = new TransferManagerConfiguration();
    this.shutDownThreadPools = shutDownThreadPools;
    isImmutable = false;
  }
  
  @SdkInternalApi
  TransferManager(TransferManagerParams params)
  {
    s3 = params.getS3Client();
    executorService = params.getExecutorService();
    configuration = params.getConfiguration();
    shutDownThreadPools = params.getShutDownThreadPools().booleanValue();
    isImmutable = true;
  }
  
  protected TransferManager(TransferManagerBuilder builder)
  {
    this(builder.getParams());
  }
  
  @Deprecated
  public void setConfiguration(TransferManagerConfiguration configuration)
  {
    checkMutability();
    this.configuration = configuration;
  }
  
  public TransferManagerConfiguration getConfiguration()
  {
    return configuration;
  }
  
  public AmazonS3 getAmazonS3Client()
  {
    return s3;
  }
  
  public Upload upload(String bucketName, String key, InputStream input, ObjectMetadata objectMetadata)
    throws AmazonServiceException, AmazonClientException
  {
    return upload(new PutObjectRequest(bucketName, key, input, objectMetadata));
  }
  
  public Upload upload(String bucketName, String key, File file)
    throws AmazonServiceException, AmazonClientException
  {
    return upload(new PutObjectRequest(bucketName, key, file));
  }
  
  public Upload upload(PutObjectRequest putObjectRequest)
    throws AmazonServiceException, AmazonClientException
  {
    return doUpload(putObjectRequest, null, null, null);
  }
  
  public Upload upload(PutObjectRequest putObjectRequest, S3ProgressListener progressListener)
    throws AmazonServiceException, AmazonClientException
  {
    return doUpload(putObjectRequest, null, progressListener, null);
  }
  
  private Upload doUpload(PutObjectRequest putObjectRequest, TransferStateChangeListener stateListener, S3ProgressListener progressListener, PersistableUpload persistableUpload)
    throws AmazonServiceException, AmazonClientException
  {
    appendSingleObjectUserAgent(putObjectRequest);
    
    String multipartUploadId = persistableUpload != null ? persistableUpload.getMultipartUploadId() : null;
    if (putObjectRequest.getMetadata() == null) {
      putObjectRequest.setMetadata(new ObjectMetadata());
    }
    ObjectMetadata metadata = putObjectRequest.getMetadata();
    
    File file = TransferManagerUtils.getRequestFile(putObjectRequest);
    if (file != null)
    {
      metadata.setContentLength(file.length());
      if (metadata.getContentType() == null) {
        metadata.setContentType(Mimetypes.getInstance().getMimetype(file));
      }
    }
    else if (multipartUploadId != null)
    {
      throw new IllegalArgumentException("Unable to resume the upload. No file specified.");
    }
    String description = "Uploading to " + putObjectRequest.getBucketName() + "/" + putObjectRequest.getKey();
    TransferProgress transferProgress = new TransferProgress();
    transferProgress.setTotalBytesToTransfer(
      TransferManagerUtils.getContentLength(putObjectRequest));
    
    S3ProgressListenerChain listenerChain = new S3ProgressListenerChain(new ProgressListener[] { new TransferProgressUpdatingListener(transferProgress), putObjectRequest.getGeneralProgressListener(), progressListener });
    
    putObjectRequest.setGeneralProgressListener(listenerChain);
    
    UploadImpl upload = new UploadImpl(description, transferProgress, listenerChain, stateListener);
    
    UploadCallable uploadCallable = new UploadCallable(this, executorService, upload, putObjectRequest, listenerChain, multipartUploadId, transferProgress);
    
    UploadMonitor watcher = UploadMonitor.create(this, upload, executorService, uploadCallable, putObjectRequest, listenerChain);
    
    upload.setMonitor(watcher);
    
    return upload;
  }
  
  public Download download(String bucket, String key, File file)
  {
    return download(bucket, key, file, 0L);
  }
  
  public Download download(String bucket, String key, File file, long timeoutMillis)
  {
    return download(new GetObjectRequest(bucket, key), file, timeoutMillis);
  }
  
  public Download download(GetObjectRequest getObjectRequest, File file)
  {
    return download(getObjectRequest, file, 0L);
  }
  
  public Download download(GetObjectRequest getObjectRequest, File file, long timeoutMillis)
  {
    return doDownload(getObjectRequest, file, null, null, false, timeoutMillis, null);
  }
  
  public Download download(GetObjectRequest getObjectRequest, File file, S3ProgressListener progressListener)
  {
    return doDownload(getObjectRequest, file, null, progressListener, false, 0L, null);
  }
  
  public Download download(GetObjectRequest getObjectRequest, File file, S3ProgressListener progressListener, long timeoutMillis)
  {
    return doDownload(getObjectRequest, file, null, progressListener, false, timeoutMillis, null);
  }
  
  public Download download(GetObjectRequest getObjectRequest, File file, S3ProgressListener progressListener, long timeoutMillis, boolean resumeOnRetry)
  {
    return doDownload(getObjectRequest, file, null, progressListener, false, timeoutMillis, null, 0L, resumeOnRetry, 
      Long.valueOf(0L));
  }
  
  private Download doDownload(GetObjectRequest getObjectRequest, File file, TransferStateChangeListener stateListener, S3ProgressListener s3progressListener, boolean resumeExistingDownload, long timeoutMillis, PersistableDownload persistableDownload)
  {
    long lastModifiedTimeRecordedDuringPause = 0L;
    Integer lastFullyDownloadedPartNumber = null;
    Long lastFullyDownloadedFilePosition = null;
    if (persistableDownload != null)
    {
      lastModifiedTimeRecordedDuringPause = persistableDownload.getlastModifiedTime().longValue();
      lastFullyDownloadedPartNumber = persistableDownload.getLastFullyDownloadedPartNumber();
      lastFullyDownloadedFilePosition = persistableDownload.getLastFullyDownloadedFilePosition();
    }
    return doDownload(getObjectRequest, file, stateListener, s3progressListener, resumeExistingDownload, timeoutMillis, lastFullyDownloadedPartNumber, lastModifiedTimeRecordedDuringPause, false, lastFullyDownloadedFilePosition);
  }
  
  private Download doDownload(GetObjectRequest getObjectRequest, File file, TransferStateChangeListener stateListener, S3ProgressListener s3progressListener, boolean resumeExistingDownload, long timeoutMillis, Integer lastFullyDownloadedPart, long lastModifiedTimeRecordedDuringPause, boolean resumeOnRetry, Long lastFullyDownloadedPartPosition)
  {
    PreparedDownloadContext prepared = prepareDownload(getObjectRequest, file, stateListener, s3progressListener, resumeExistingDownload, timeoutMillis, lastFullyDownloadedPart, lastModifiedTimeRecordedDuringPause, resumeOnRetry, lastFullyDownloadedPartPosition);
    
    return submitDownload(prepared);
  }
  
  private PreparedDownloadContext prepareDownload(GetObjectRequest getObjectRequest, File file, TransferStateChangeListener stateListener, S3ProgressListener s3progressListener, boolean resumeExistingDownload, long timeoutMillis, Integer lastFullyDownloadedPart, long lastModifiedTimeRecordedDuringPause, boolean resumeOnRetry, Long lastFullyDownloadedPartPosition)
  {
    assertParameterNotNull(getObjectRequest, "A valid GetObjectRequest must be provided to initiate download");
    
    assertParameterNotNull(file, "A valid file must be provided to download into");
    
    appendSingleObjectUserAgent(getObjectRequest);
    String description = "Downloading from " + getObjectRequest.getBucketName() + "/" + getObjectRequest.getKey();
    
    TransferProgress transferProgress = new TransferProgress();
    
    S3ProgressListenerChain listenerChain = new S3ProgressListenerChain(new ProgressListener[] { new TransferProgressUpdatingListener(transferProgress), getObjectRequest.getGeneralProgressListener(), s3progressListener });
    
    getObjectRequest
      .setGeneralProgressListener(new ProgressListenerChain(new TransferCompletionFilter(), new ProgressListener[] { listenerChain }));
    
    GetObjectMetadataRequest getObjectMetadataRequest = RequestCopyUtils.createGetObjectMetadataRequestFrom(getObjectRequest);
    ObjectMetadata objectMetadata = s3.getObjectMetadata(getObjectMetadataRequest);
    
    long lastModifiedTime = objectMetadata.getLastModified().getTime();
    
    long startingByte = 0L;
    
    long[] range = getObjectRequest.getRange();
    long lastByte;
    long lastByte;
    if ((range != null) && (range.length == 2))
    {
      startingByte = range[0];
      lastByte = range[1];
    }
    else
    {
      lastByte = objectMetadata.getContentLength() - 1L;
    }
    long origStartingByte = startingByte;
    
    boolean isDownloadParallel = (!configuration.isDisableParallelDownloads()) && (TransferManagerUtils.isDownloadParallelizable(s3, getObjectRequest, ServiceUtils.getPartCount(getObjectRequest, s3)));
    
    DownloadImpl download = new DownloadImpl(description, transferProgress, listenerChain, null, stateListener, getObjectRequest, file, objectMetadata, isDownloadParallel);
    
    long totalBytesToDownload = lastByte - startingByte + 1L;
    transferProgress.setTotalBytesToTransfer(totalBytesToDownload);
    if ((totalBytesToDownload > 0L) && (!isDownloadParallel)) {
      getObjectRequest.withRange(startingByte, lastByte);
    }
    long fileLength = -1L;
    if (resumeExistingDownload)
    {
      if (isS3ObjectModifiedSincePause(lastModifiedTime, lastModifiedTimeRecordedDuringPause)) {
        throw new AmazonClientException("The requested object in bucket " + getObjectRequest.getBucketName() + " with key " + getObjectRequest.getKey() + " is modified on Amazon S3 since the last pause.");
      }
      getObjectRequest.setUnmodifiedSinceConstraint(new Date(lastModifiedTime));
      if (!isDownloadParallel)
      {
        if (!FileLocks.lock(file)) {
          throw new FileLockException("Fail to lock " + file + " for resume download");
        }
        try
        {
          if (file.exists())
          {
            fileLength = file.length();
            startingByte += fileLength;
            getObjectRequest.setRange(startingByte, lastByte);
            transferProgress.updateProgress(Math.min(fileLength, totalBytesToDownload));
            totalBytesToDownload = lastByte - startingByte + 1L;
            if (log.isDebugEnabled()) {
              log.debug("Resume download: totalBytesToDownload=" + totalBytesToDownload + ", origStartingByte=" + origStartingByte + ", startingByte=" + startingByte + ", lastByte=" + lastByte + ", numberOfBytesRead=" + fileLength + ", file: " + file);
            }
          }
        }
        finally
        {
          FileLocks.unlock(file);
        }
      }
    }
    if (totalBytesToDownload < 0L) {
      throw new IllegalArgumentException("Unable to determine the range for download operation.");
    }
    CountDownLatch latch = new CountDownLatch(1);
    
    DownloadCallable downloadCallable = new DownloadCallable(s3, latch, getObjectRequest, resumeExistingDownload, download, file, origStartingByte, fileLength, timeoutMillis, timedThreadPool, executorService, lastFullyDownloadedPart, isDownloadParallel, resumeOnRetry).withLastFullyMergedPartPosition(lastFullyDownloadedPartPosition);
    
    return new PreparedDownloadContext(download, downloadCallable, latch);
  }
  
  private DownloadImpl submitDownload(PreparedDownloadContext preparedDownloadContext)
  {
    Future<?> future = executorService.submit(preparedDownloadContext.getCallable());
    DownloadImpl transfer = preparedDownloadContext.getTransfer();
    transfer.setMonitor(new DownloadMonitor(transfer, future));
    preparedDownloadContext.getLatch().countDown();
    return transfer;
  }
  
  private boolean isS3ObjectModifiedSincePause(long lastModifiedTimeRecordedDuringResume, long lastModifiedTimeRecordedDuringPause)
  {
    return lastModifiedTimeRecordedDuringResume != lastModifiedTimeRecordedDuringPause;
  }
  
  public PresignedUrlDownload download(PresignedUrlDownloadRequest request, File destFile)
  {
    return download(request, destFile, new PresignedUrlDownloadConfig());
  }
  
  public PresignedUrlDownload download(PresignedUrlDownloadRequest request, File destFile, PresignedUrlDownloadConfig downloadContext)
  {
    assertParameterNotNull(request, "A valid PresignedUrlDownloadRequest must be provided to initiate download");
    
    assertParameterNotNull(destFile, "A valid file must be provided to download into");
    
    assertParameterNotNull(downloadContext, "A valid PresignedUrlDownloadContext must be provided");
    
    appendSingleObjectUserAgent(request);
    String description = "Downloading from the given presigned url: " + request.getPresignedUrl();
    
    TransferProgress transferProgress = new TransferProgress();
    
    S3ProgressListenerChain listenerChain = new S3ProgressListenerChain(new ProgressListener[] { new TransferProgressUpdatingListener(transferProgress), request.getGeneralProgressListener(), downloadContext.getS3progressListener() });
    request.setGeneralProgressListener(new ProgressListenerChain(new TransferCompletionFilter(), new ProgressListener[] { listenerChain }));
    
    Long startByte = Long.valueOf(0L);
    Long endByte = null;
    
    long[] range = request.getRange();
    if ((range != null) && (range.length == 2))
    {
      startByte = Long.valueOf(range[0]);
      endByte = Long.valueOf(range[1]);
    }
    else
    {
      ObjectMetadata objectMetadata = getObjectMetadataUsingRange(request);
      if (objectMetadata != null)
      {
        Long contentLength = TransferManagerUtils.getContentLengthFromContentRange(objectMetadata);
        endByte = contentLength != null ? Long.valueOf(contentLength.longValue() - 1L) : null;
      }
    }
    long perRequestDownloadSize = downloadContext.getDownloadSizePerRequest();
    boolean isDownloadParallel = isDownloadParallel(request, startByte, endByte, perRequestDownloadSize);
    
    PresignedUrlDownloadImpl download = new PresignedUrlDownloadImpl(description, transferProgress, listenerChain, request);
    if ((startByte != null) && (endByte != null)) {
      transferProgress.setTotalBytesToTransfer(endByte.longValue() - startByte.longValue() + 1L);
    }
    CountDownLatch latch = new CountDownLatch(1);
    Future<?> future = executorService.submit(new PresignUrlDownloadCallable(executorService, destFile, latch, download, isDownloadParallel, timedThreadPool, downloadContext
    
      .getTimeoutMillis(), s3, request, perRequestDownloadSize, startByte, endByte, downloadContext
      .isResumeOnRetry()));
    
    download.setMonitor(new DownloadMonitor(download, future));
    latch.countDown();
    return download;
  }
  
  private ObjectMetadata getObjectMetadataUsingRange(PresignedUrlDownloadRequest request)
  {
    PresignedUrlDownloadRequest copy = request.clone();
    S3Object s3Object = null;
    try
    {
      s3Object = s3.download(copy.withRange(0L, 0L)).getS3Object();
      
      return s3Object.getObjectMetadata();
    }
    catch (AmazonS3Exception exception)
    {
      S3ObjectInputStream objectContent;
      if ((exception.getStatusCode() == 416) && ("InvalidRange".equals(exception.getErrorCode())))
      {
        S3ObjectInputStream objectContent;
        return null;
      }
      throw exception;
    }
    finally
    {
      if (s3Object != null)
      {
        S3ObjectInputStream objectContent = s3Object.getObjectContent();
        IOUtils.drainInputStream(objectContent);
        IOUtils.closeQuietly(objectContent, log);
      }
    }
  }
  
  private boolean isDownloadParallel(PresignedUrlDownloadRequest request, Long startByte, Long endByte, long partialObjectMaxSize)
  {
    if ((!configuration.isDisableParallelDownloads()) && (!(s3 instanceof AmazonS3Encryption))) {
      if ((request.getRange() != null) || (startByte == null) || (endByte == null)) {}
    }
    return 
    
      endByte.longValue() - startByte.longValue() + 1L > partialObjectMaxSize;
  }
  
  public MultipleFileDownload downloadDirectory(String bucketName, String keyPrefix, File destinationDirectory)
  {
    return downloadDirectory(bucketName, keyPrefix, destinationDirectory, false);
  }
  
  public MultipleFileDownload downloadDirectory(String bucketName, String keyPrefix, File destinationDirectory, KeyFilter filter)
  {
    return downloadDirectory(bucketName, keyPrefix, destinationDirectory, false, filter);
  }
  
  public MultipleFileDownload downloadDirectory(String bucketName, String keyPrefix, File destinationDirectory, boolean resumeOnRetry)
  {
    return downloadDirectory(bucketName, keyPrefix, destinationDirectory, resumeOnRetry, null);
  }
  
  public MultipleFileDownload downloadDirectory(String bucketName, String keyPrefix, File destinationDirectory, boolean resumeOnRetry, KeyFilter filter)
  {
    if (keyPrefix == null) {
      keyPrefix = "";
    }
    if (filter == null) {
      filter = KeyFilter.INCLUDE_ALL;
    }
    List<S3ObjectSummary> objectSummaries = new LinkedList();
    Stack<String> commonPrefixes = new Stack();
    commonPrefixes.add(keyPrefix);
    long totalSize = 0L;
    do
    {
      String prefix = (String)commonPrefixes.pop();
      ObjectListing listObjectsResponse = null;
      do
      {
        ListObjectsRequest listObjectsRequest;
        if (listObjectsResponse == null)
        {
          listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName).withDelimiter("/").withPrefix(prefix);
          listObjectsResponse = s3.listObjects(listObjectsRequest);
        }
        else
        {
          listObjectsResponse = s3.listNextBatchOfObjects(listObjectsResponse);
        }
        for (S3ObjectSummary s : listObjectsResponse.getObjectSummaries()) {
          if (!filter.shouldInclude(s))
          {
            log.debug("Skipping " + s.getKey() + " as it does not match filter.");
          }
          else
          {
            if (leavesRoot(destinationDirectory, s.getKey())) {
              throw new RuntimeException("Cannot download key " + s.getKey() + ", its relative path resolves outside the parent directory.");
            }
            if ((!s.getKey().equals(prefix)) && 
              (!listObjectsResponse.getCommonPrefixes().contains(s.getKey() + "/")))
            {
              objectSummaries.add(s);
              totalSize += s.getSize();
            }
            else
            {
              log.debug("Skipping download for object " + s.getKey() + " since it is also a virtual directory");
            }
          }
        }
        commonPrefixes.addAll(listObjectsResponse.getCommonPrefixes());
      } while (listObjectsResponse.isTruncated());
    } while (!commonPrefixes.isEmpty());
    ProgressListenerChain additionalListeners = new ProgressListenerChain(new ProgressListener[0]);
    
    TransferProgress transferProgress = new TransferProgress();
    transferProgress.setTotalBytesToTransfer(totalSize);
    
    ProgressListener listener = new MultipleFileTransferProgressUpdatingListener(transferProgress, additionalListeners);
    
    List<DownloadImpl> downloads = new ArrayList();
    
    List<PreparedDownloadContext> preparedDownloadContexts = new ArrayList();
    
    String description = "Downloading from " + bucketName + "/" + keyPrefix;
    MultipleFileDownloadImpl multipleFileDownload = new MultipleFileDownloadImpl(description, transferProgress, additionalListeners, keyPrefix, bucketName, downloads);
    
    multipleFileDownload.setMonitor(new MultipleFileTransferMonitor(multipleFileDownload, downloads));
    
    CountDownLatch latch = new CountDownLatch(1);
    MultipleFileTransferStateChangeListener transferListener = new MultipleFileTransferStateChangeListener(latch, multipleFileDownload);
    if (objectSummaries.isEmpty())
    {
      multipleFileDownload.setState(Transfer.TransferState.Completed);
      return multipleFileDownload;
    }
    for (S3ObjectSummary summary : objectSummaries)
    {
      File f = new File(destinationDirectory, summary.getKey());
      File parentFile = f.getParentFile();
      if ((!parentFile.exists()) && (!parentFile.mkdirs())) {
        throw new RuntimeException("Couldn't create parent directories for " + f.getAbsolutePath());
      }
      GetObjectRequest req = (GetObjectRequest)new GetObjectRequest(summary.getBucketName(), summary.getKey()).withGeneralProgressListener(listener);
      
      PreparedDownloadContext ctx = prepareDownload(req, f, transferListener, null, false, 0L, null, 0L, resumeOnRetry, null);
      
      preparedDownloadContexts.add(ctx);
    }
    try
    {
      for (??? = preparedDownloadContexts.iterator(); ???.hasNext();)
      {
        ctx = (PreparedDownloadContext)???.next();
        downloads.add(submitDownload(ctx));
      }
    }
    catch (Throwable t)
    {
      PreparedDownloadContext ctx;
      for (DownloadImpl d : downloads) {
        try
        {
          d.getMonitor().getFuture().cancel(true);
        }
        catch (Throwable cancelErr)
        {
          log.warn("DownloadImpl could not be aborted", cancelErr);
        }
      }
      throw new SdkClientException(t);
    }
    latch.countDown();
    return multipleFileDownload;
  }
  
  private boolean leavesRoot(File localBaseDirectory, String key)
  {
    try
    {
      return !new File(localBaseDirectory, key).getCanonicalPath().startsWith(localBaseDirectory.getCanonicalPath());
    }
    catch (IOException e)
    {
      throw new RuntimeException("Unable to canonicalize paths", e);
    }
  }
  
  public MultipleFileUpload uploadDirectory(String bucketName, String virtualDirectoryKeyPrefix, File directory, boolean includeSubdirectories)
  {
    return uploadDirectory(bucketName, virtualDirectoryKeyPrefix, directory, includeSubdirectories, null);
  }
  
  public MultipleFileUpload uploadDirectory(String bucketName, String virtualDirectoryKeyPrefix, File directory, boolean includeSubdirectories, ObjectMetadataProvider metadataProvider)
  {
    return uploadDirectory(bucketName, virtualDirectoryKeyPrefix, directory, includeSubdirectories, metadataProvider, null);
  }
  
  public MultipleFileUpload uploadDirectory(String bucketName, String virtualDirectoryKeyPrefix, File directory, boolean includeSubdirectories, ObjectMetadataProvider metadataProvider, ObjectTaggingProvider taggingProvider)
  {
    return uploadDirectory(bucketName, virtualDirectoryKeyPrefix, directory, includeSubdirectories, metadataProvider, taggingProvider, null);
  }
  
  public MultipleFileUpload uploadDirectory(String bucketName, String virtualDirectoryKeyPrefix, File directory, boolean includeSubdirectories, ObjectMetadataProvider metadataProvider, ObjectTaggingProvider taggingProvider, ObjectCannedAclProvider cannedAclProvider)
  {
    if ((directory == null) || (!directory.exists()) || (!directory.isDirectory())) {
      throw new IllegalArgumentException("Must provide a directory to upload");
    }
    List<File> files = new LinkedList();
    listFiles(directory, files, includeSubdirectories);
    
    return uploadFileList(bucketName, virtualDirectoryKeyPrefix, directory, files, metadataProvider, taggingProvider, cannedAclProvider);
  }
  
  public MultipleFileUpload uploadFileList(String bucketName, String virtualDirectoryKeyPrefix, File directory, List<File> files)
  {
    return uploadFileList(bucketName, virtualDirectoryKeyPrefix, directory, files, null);
  }
  
  public MultipleFileUpload uploadFileList(String bucketName, String virtualDirectoryKeyPrefix, File directory, List<File> files, ObjectMetadataProvider metadataProvider)
  {
    return uploadFileList(bucketName, virtualDirectoryKeyPrefix, directory, files, metadataProvider, null);
  }
  
  public MultipleFileUpload uploadFileList(String bucketName, String virtualDirectoryKeyPrefix, File directory, List<File> files, ObjectMetadataProvider metadataProvider, ObjectTaggingProvider taggingProvider)
  {
    return uploadFileList(bucketName, virtualDirectoryKeyPrefix, directory, files, metadataProvider, taggingProvider, null);
  }
  
  public MultipleFileUpload uploadFileList(String bucketName, String virtualDirectoryKeyPrefix, File directory, List<File> files, ObjectMetadataProvider metadataProvider, ObjectTaggingProvider taggingProvider, ObjectCannedAclProvider cannedAclProvider)
  {
    if ((directory == null) || (!directory.exists()) || (!directory.isDirectory())) {
      throw new IllegalArgumentException("Must provide a common base directory for uploaded files");
    }
    if ((virtualDirectoryKeyPrefix == null) || (virtualDirectoryKeyPrefix.length() == 0)) {
      virtualDirectoryKeyPrefix = "";
    } else if (!virtualDirectoryKeyPrefix.endsWith("/")) {
      virtualDirectoryKeyPrefix = virtualDirectoryKeyPrefix + "/";
    }
    ProgressListenerChain additionalListeners = new ProgressListenerChain(new ProgressListener[0]);
    TransferProgress progress = new TransferProgress();
    
    ProgressListener listener = new MultipleFileTransferProgressUpdatingListener(progress, additionalListeners);
    
    List<UploadImpl> uploads = new LinkedList();
    MultipleFileUploadImpl multipleFileUpload = new MultipleFileUploadImpl("Uploading etc", progress, additionalListeners, virtualDirectoryKeyPrefix, bucketName, uploads);
    multipleFileUpload.setMonitor(new MultipleFileTransferMonitor(multipleFileUpload, uploads));
    CountDownLatch latch = new CountDownLatch(1);
    MultipleFileTransferStateChangeListener transferListener = new MultipleFileTransferStateChangeListener(latch, multipleFileUpload);
    if ((files == null) || (files.isEmpty()))
    {
      multipleFileUpload.setState(Transfer.TransferState.Completed);
    }
    else
    {
      int startingPosition = directory.getAbsolutePath().length();
      if (!directory.getAbsolutePath().endsWith(File.separator)) {
        startingPosition++;
      }
      long totalSize = 0L;
      for (File f : files) {
        if (f.isFile())
        {
          totalSize += f.length();
          
          String key = f.getAbsolutePath().substring(startingPosition).replaceAll("\\\\", "/");
          
          UploadContext uploadContext = new UploadContext(f, bucketName, key);
          ObjectMetadata metadata = new ObjectMetadata();
          CannedAccessControlList cannedAcl = null;
          ObjectTagging objectTagging = null;
          if (metadataProvider != null) {
            metadataProvider.provideObjectMetadata(f, metadata);
          }
          if (taggingProvider != null) {
            objectTagging = taggingProvider.provideObjectTags(uploadContext);
          }
          if (cannedAclProvider != null) {
            cannedAcl = cannedAclProvider.provideObjectCannedAcl(f);
          }
          uploads.add((UploadImpl)doUpload(
          
            (PutObjectRequest)new PutObjectRequest(bucketName, virtualDirectoryKeyPrefix + key, f).withMetadata(metadata).withTagging(objectTagging).withCannedAcl(cannedAcl).withGeneralProgressListener(listener), transferListener, null, null));
        }
      }
      progress.setTotalBytesToTransfer(totalSize);
    }
    latch.countDown();
    return multipleFileUpload;
  }
  
  private void listFiles(File dir, List<File> results, boolean includeSubDirectories)
  {
    File[] found = dir.listFiles();
    if (found != null) {
      for (File f : found) {
        if (f.isDirectory())
        {
          if (includeSubDirectories) {
            listFiles(f, results, includeSubDirectories);
          }
        }
        else {
          results.add(f);
        }
      }
    }
  }
  
  public void abortMultipartUploads(String bucketName, Date date)
    throws AmazonServiceException, AmazonClientException
  {
    MultipartUploadListing uploadListing = s3.listMultipartUploads((ListMultipartUploadsRequest)appendSingleObjectUserAgent(new ListMultipartUploadsRequest(bucketName)));
    do
    {
      for (MultipartUpload upload : uploadListing.getMultipartUploads()) {
        if (upload.getInitiated().compareTo(date) < 0) {
          s3.abortMultipartUpload((AbortMultipartUploadRequest)appendSingleObjectUserAgent(new AbortMultipartUploadRequest(bucketName, upload
            .getKey(), upload.getUploadId())));
        }
      }
      ListMultipartUploadsRequest request = new ListMultipartUploadsRequest(bucketName).withUploadIdMarker(uploadListing.getNextUploadIdMarker()).withKeyMarker(uploadListing.getNextKeyMarker());
      uploadListing = s3.listMultipartUploads((ListMultipartUploadsRequest)appendSingleObjectUserAgent(request));
    } while (uploadListing.isTruncated());
  }
  
  public void shutdownNow()
  {
    shutdownNow(true);
  }
  
  public void shutdownNow(boolean shutDownS3Client)
  {
    if (shutDownThreadPools)
    {
      executorService.shutdownNow();
      timedThreadPool.shutdownNow();
    }
    if (shutDownS3Client) {
      s3.shutdown();
    }
  }
  
  private void shutdownThreadPools()
  {
    if (shutDownThreadPools)
    {
      executorService.shutdown();
      timedThreadPool.shutdown();
    }
  }
  
  public static <X extends AmazonWebServiceRequest> X appendSingleObjectUserAgent(X request)
  {
    request.getRequestClientOptions().appendUserAgent(USER_AGENT);
    return request;
  }
  
  public static <X extends AmazonWebServiceRequest> X appendMultipartUserAgent(X request)
  {
    request.getRequestClientOptions().appendUserAgent(USER_AGENT_MULTIPART);
    return request;
  }
  
  private static final String USER_AGENT = TransferManager.class.getName() + "/" + VersionInfoUtils.getVersion();
  private static final String USER_AGENT_MULTIPART = TransferManager.class.getName() + "_multipart/" + VersionInfoUtils.getVersion();
  private static final String DEFAULT_DELIMITER = "/";
  private static final ThreadFactory daemonThreadFactory = new ThreadFactory()
  {
    final AtomicInteger threadCount = new AtomicInteger(0);
    
    public Thread newThread(Runnable r)
    {
      int threadNumber = threadCount.incrementAndGet();
      Thread thread = new Thread(r);
      thread.setDaemon(true);
      thread.setName("S3TransferManagerTimedThread-" + threadNumber);
      return thread;
    }
  };
  
  public Copy copy(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey)
    throws AmazonServiceException, AmazonClientException
  {
    return copy(new CopyObjectRequest(sourceBucketName, sourceKey, destinationBucketName, destinationKey));
  }
  
  public Copy copy(CopyObjectRequest copyObjectRequest)
  {
    return copy(copyObjectRequest, null);
  }
  
  public Copy copy(CopyObjectRequest copyObjectRequest, TransferStateChangeListener stateChangeListener)
    throws AmazonServiceException, AmazonClientException
  {
    return copy(copyObjectRequest, s3, stateChangeListener);
  }
  
  public Copy copy(CopyObjectRequest copyObjectRequest, AmazonS3 srcS3, TransferStateChangeListener stateChangeListener)
    throws AmazonServiceException, AmazonClientException
  {
    appendSingleObjectUserAgent(copyObjectRequest);
    
    assertParameterNotNull(copyObjectRequest.getSourceBucketName(), "The source bucket name must be specified when a copy request is initiated.");
    
    assertParameterNotNull(copyObjectRequest.getSourceKey(), "The source object key must be specified when a copy request is initiated.");
    
    assertParameterNotNull(copyObjectRequest.getDestinationBucketName(), "The destination bucket name must be specified when a copy request is initiated.");
    
    assertParameterNotNull(copyObjectRequest.getDestinationKey(), "The destination object key must be specified when a copy request is initiated.");
    
    assertParameterNotNull(srcS3, "The srcS3 parameter is mandatory");
    
    String description = "Copying object from " + copyObjectRequest.getSourceBucketName() + "/" + copyObjectRequest.getSourceKey() + " to " + copyObjectRequest.getDestinationBucketName() + "/" + copyObjectRequest.getDestinationKey();
    
    GetObjectMetadataRequest getObjectMetadataRequest = new GetObjectMetadataRequest(copyObjectRequest.getSourceBucketName(), copyObjectRequest.getSourceKey()).withSSECustomerKey(copyObjectRequest.getSourceSSECustomerKey()).withRequesterPays(copyObjectRequest.isRequesterPays()).withVersionId(copyObjectRequest.getSourceVersionId());
    
    ObjectMetadata metadata = srcS3.getObjectMetadata(getObjectMetadataRequest);
    
    TransferProgress transferProgress = new TransferProgress();
    transferProgress.setTotalBytesToTransfer(metadata.getContentLength());
    
    ProgressListenerChain listenerChain = new ProgressListenerChain(new ProgressListener[] { new TransferProgressUpdatingListener(transferProgress) });
    
    CopyImpl copy = new CopyImpl(description, transferProgress, listenerChain, stateChangeListener);
    
    CopyCallable copyCallable = new CopyCallable(this, executorService, copy, copyObjectRequest, metadata, listenerChain);
    
    CopyMonitor watcher = CopyMonitor.create(this, copy, executorService, copyCallable, copyObjectRequest, listenerChain);
    
    copy.setMonitor(watcher);
    return copy;
  }
  
  public Upload resumeUpload(PersistableUpload persistableUpload)
  {
    assertParameterNotNull(persistableUpload, "PauseUpload is mandatory to resume a upload.");
    
    configuration.setMinimumUploadPartSize(persistableUpload.getPartSize());
    configuration.setMultipartUploadThreshold(persistableUpload
      .getMutlipartUploadThreshold());
    return doUpload(new PutObjectRequest(persistableUpload.getBucketName(), persistableUpload
      .getKey(), new File(persistableUpload.getFile())), null, null, persistableUpload);
  }
  
  public Download resumeDownload(PersistableDownload persistableDownload)
  {
    assertParameterNotNull(persistableDownload, "PausedDownload is mandatory to resume a download.");
    
    GetObjectRequest request = new GetObjectRequest(persistableDownload.getBucketName(), persistableDownload.getKey(), persistableDownload.getVersionId());
    if ((persistableDownload.getRange() != null) && 
      (persistableDownload.getRange().length == 2))
    {
      long[] range = persistableDownload.getRange();
      request.setRange(range[0], range[1]);
    }
    request.setRequesterPays(persistableDownload.isRequesterPays());
    request.setResponseHeaders(persistableDownload.getResponseHeaders());
    
    return doDownload(request, new File(persistableDownload.getFile()), null, null, true, 0L, persistableDownload);
  }
  
  private void assertParameterNotNull(Object parameterValue, String errorMessage)
  {
    if (parameterValue == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    shutdownThreadPools();
  }
  
  private void checkMutability()
  {
    if (isImmutable) {
      throw new UnsupportedOperationException("TransferManager is immutable when created with the builder.");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */