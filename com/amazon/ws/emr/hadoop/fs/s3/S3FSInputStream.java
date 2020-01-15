package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys;
import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException;
import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.CanUnbuffer;
import org.apache.hadoop.fs.FSInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3FSInputStream
  extends FSInputStream
  implements CanUnbuffer
{
  private static final Logger LOG = LoggerFactory.getLogger(S3FSInputStream.class);
  private InputStreamWithInfo in;
  private AmazonS3Lite s3;
  private long lastReadPos = 0L;
  private long nextReadPos = 0L;
  private EntityStore entityStore;
  private String bucketName;
  private boolean throwOnInconsistency;
  private Configuration conf;
  private final boolean lazySeek;
  private long readRetryInterval;
  private final InputStreamWithInfoFactory inputStreamWithInfoFactory;
  private final AtomicBoolean shouldTryInitialTimeout;
  
  public S3FSInputStream(@NonNull String bucketName, @NonNull String key, @NonNull AmazonS3Lite s3, @NonNull EntityStore entityStore, boolean throwOnInconsistency, @NonNull Configuration conf, @NonNull InputStreamWithInfoFactory inputStreamWithInfoFactory)
    throws ConsistencyException, IOException
  {
    if (bucketName == null) {
      throw new NullPointerException("bucketName");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (entityStore == null) {
      throw new NullPointerException("entityStore");
    }
    if (conf == null) {
      throw new NullPointerException("conf");
    }
    if (inputStreamWithInfoFactory == null) {
      throw new NullPointerException("inputStreamWithInfoFactory");
    }
    this.bucketName = bucketName;
    this.s3 = s3;
    this.entityStore = entityStore;
    this.throwOnInconsistency = throwOnInconsistency;
    this.conf = conf;
    lazySeek = ConfigurationUtils.isLazySeekEnabled(conf);
    
    readRetryInterval = (ConfigurationUtils.getConsistencyRetryPeriodSeconds(conf) * 1000);
    shouldTryInitialTimeout = new AtomicBoolean(true);
    this.inputStreamWithInfoFactory = inputStreamWithInfoFactory;
    open(key, 0L);
  }
  
  private void open(String key, long byteStartRange)
    throws ConsistencyException, IOException
  {
    Preconditions.checkArgument(byteStartRange >= 0L, "Cannot seek to a negative position");
    try
    {
      long plaintextLength = CSEUtils.getPlaintextLength(s3, bucketName, key, null, conf);
      LOG.debug("Stream for key '{}' seeking to position '{}'", key, Long.valueOf(byteStartRange));
      in = inputStreamWithInfoFactory.create(bucketName, key, byteStartRange, plaintextLength, shouldTryInitialTimeout
        .get());
    }
    catch (AmazonServiceException e)
    {
      if (e.getStatusCode() == 404)
      {
        Entity entity = entityStore.retrieve(ItemKeys.toItemKey(bucketName, key));
        if (entity != null)
        {
          EmrFsStore.MetadataFile metadataFile = EmrFsStore.MetadataFile.parseFrom(entity.getPayload());
          if (metadataFile.getState() != EmrFsStore.MetadataFile.State.DELETED)
          {
            String errorMessage = String.format("Unable to get object '%s/%s' from s3", new Object[] { bucketName, key });
            throw new ConsistencyException(errorMessage, e, Collections.singletonList(EmrFsUtils.getPathForS3Object(bucketName, key)));
          }
        }
        throw new FileNotFoundException(String.format("File '%s/%s' has been deleted in both metadata and s3", new Object[] { bucketName, key }));
      }
      throw new IOException(e);
    }
    long plaintextLength;
    lastReadPos = byteStartRange;
    nextReadPos = byteStartRange;
  }
  
  public synchronized int read()
    throws IOException
  {
    throw new UnsupportedOperationException("Single byte read() not implemented");
  }
  
  private void advance(int amount)
  {
    lastReadPos += amount;
    nextReadPos += amount;
  }
  
  public synchronized int read(byte[] b, int off, int len)
    throws IOException
  {
    Preconditions.checkNotNull(b, "byte array 'b' is required");
    if ((off < 0) || (len < 0) || (len > b.length - off)) {
      throw new IndexOutOfBoundsException();
    }
    if (len == 0) {
      return 0;
    }
    if (atEndOfStreamIfKnown()) {
      return -1;
    }
    int numRetries = 5;
    int result = -1;
    
    Exception lastException = null;
    for (int attempt = 0; attempt < 5; attempt++)
    {
      try
      {
        if (attempt <= 0)
        {
          if (lazySeek) {
            seekStream();
          }
        }
        else {
          reopenStream();
        }
        result = in.read(b, off, len);
        if (result > 0)
        {
          advance(result);
          break;
        }
        if (in.shouldBreakReadRetry(nextReadPos)) {
          break;
        }
        LOG.warn(generateUnexpectedEndOfStreamMsg());
      }
      catch (FileNotFoundException fnfe)
      {
        LOG.info("Encountered an exception while reading '{}', file not present", in
          .getKey(), fnfe);
        throw new FileNotFoundException("File not present on S3");
      }
      catch (AmazonClientException|IOException e)
      {
        shouldTryInitialTimeout.set(false);
        lastException = e;
        if (attempt >= 4)
        {
          LOG.info("Encountered exception while reading '{}', max retries exceeded.", in
            .getKey(), e);
        }
        else
        {
          LOG.info("Encountered exception while reading '{}', will retry by attempting to reopen stream.", in
            .getKey(), e);
          long retryInterval = EmrFsUtils.calculateRetryInterval(
            ConfigurationUtils.getRetryPolicyType(conf), readRetryInterval, attempt);
          LOG.debug("Back off {} ms for retrying open stream while reading due to s3 GET-After-PUT consistency issue. For best practice please see https://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html#ConsistencyModel", 
          
            Long.valueOf(retryInterval));
          EmrFsUtils.sleep(retryInterval);
        }
      }
      if (attempt >= 4)
      {
        LOG.error("Unable to recover reading from stream");
        throw new IOException(generateUnexpectedEndOfStreamMsg(), lastException);
      }
    }
    return result;
  }
  
  private String generateUnexpectedEndOfStreamMsg()
  {
    StringBuilder messageBuilder = new StringBuilder("Unexpected end of stream pos=" + lastReadPos);
    if (in.isSelect()) {
      messageBuilder.append(", byteScanned=" + in.getSelectByteScanned());
    }
    messageBuilder.append(", contentLength=" + in.getContentLength());
    return messageBuilder.toString();
  }
  
  public void close()
    throws IOException
  {
    in.close();
  }
  
  private synchronized void reopenStream()
    throws IOException
  {
    in.close();
    retrieveInputStreamWithInfo(nextReadPos);
    lastReadPos = nextReadPos;
  }
  
  private void retrieveInputStreamWithInfo(long pos)
    throws IOException
  {
    Preconditions.checkNotNull(in, "Requires last InputStreamWithInfo");
    if (atEndOfStreamIfKnown(pos)) {
      return;
    }
    try
    {
      open(in.getKey(), pos);
    }
    catch (ConsistencyException e)
    {
      if (throwOnInconsistency) {
        throw e;
      }
      LOG.warn(e.getMessage(), e);
      throw new FileNotFoundException(e.getMessage());
    }
  }
  
  private boolean atEndOfStreamIfKnown()
  {
    return atEndOfStreamIfKnown(nextReadPos);
  }
  
  private boolean atEndOfStreamIfKnown(long pos)
  {
    return in.atEndOfStreamIfKnown(pos);
  }
  
  private void throwPositionOutOfBoundsException(long pos)
    throws EOFException
  {
    throw new EOFException(String.format("Invalid position: %d, exceeds the bounds of the stream: [0, %d]", new Object[] {
      Long.valueOf(pos), Long.valueOf(in.getContentLength()) }));
  }
  
  public synchronized void seek(long pos)
    throws IOException
  {
    if ((pos < 0L) || (pos > in.getContentLength())) {
      throwPositionOutOfBoundsException(pos);
    }
    nextReadPos = pos;
    if (!lazySeek) {
      seekStream();
    }
  }
  
  synchronized void seekStream()
    throws IOException
  {
    if ((lastReadPos == nextReadPos) && (!in.wasClosedSuccessfully())) {
      return;
    }
    reopenStream();
  }
  
  public synchronized long getPos()
    throws IOException
  {
    return nextReadPos;
  }
  
  public boolean seekToNewSource(long targetPos)
    throws IOException
  {
    return false;
  }
  
  public void unbuffer()
  {
    try
    {
      in.close();
    }
    catch (IOException e)
    {
      LOG.warn("Exception while trying to unbuffer input stream: ", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3FSInputStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */