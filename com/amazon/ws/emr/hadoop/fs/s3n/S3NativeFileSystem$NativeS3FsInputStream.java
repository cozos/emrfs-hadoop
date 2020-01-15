package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.CanUnbuffer;
import org.apache.hadoop.fs.FSInputStream;
import org.apache.hadoop.fs.FileSystem.Statistics;
import org.slf4j.Logger;

class S3NativeFileSystem$NativeS3FsInputStream
  extends FSInputStream
  implements CanUnbuffer
{
  private InputStreamWithInfo inputStreamWithInfo;
  private long lastReadPos = 0L;
  private long nextReadPos = 0L;
  private final boolean lazySeek;
  private long readRetryInterval;
  private final AtomicBoolean shouldTryInitialTimeout;
  
  public S3NativeFileSystem$NativeS3FsInputStream(S3NativeFileSystem paramS3NativeFileSystem, InputStreamWithInfo inputStreamWithInfo)
    throws IOException
  {
    this.inputStreamWithInfo = inputStreamWithInfo;
    lazySeek = ConfigurationUtils.isLazySeekEnabled(paramS3NativeFileSystem.getConf());
    
    readRetryInterval = (ConfigurationUtils.getRetryPeriodSeconds(paramS3NativeFileSystem.getConf()) * 1000);
    shouldTryInitialTimeout = new AtomicBoolean(true);
  }
  
  public synchronized int read()
    throws IOException
  {
    throw new UnsupportedOperationException("Single byte read() not implemented");
  }
  
  public synchronized int read(byte[] bytes, int off, int len)
    throws IOException
  {
    Preconditions.checkNotNull(bytes, "byte array 'bytes' is required");
    if ((off < 0) || (len < 0) || (len > bytes.length - off)) {
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
        result = inputStreamWithInfo.read(bytes, off, len);
        if (result > 0)
        {
          advance(result);
          break;
        }
        if (inputStreamWithInfo.shouldBreakReadRetry(nextReadPos)) {
          break;
        }
        S3NativeFileSystem.LOG.info(generateUnexpectedEndOfStreamMsg());
      }
      catch (FileNotFoundException fnfe)
      {
        S3NativeFileSystem.LOG.info("Encountered an exception while reading '{}', file not present", inputStreamWithInfo
          .getKey(), fnfe);
        throw new FileNotFoundException("File not present on S3");
      }
      catch (AmazonClientException|IOException e)
      {
        shouldTryInitialTimeout.set(false);
        if (attempt >= 4)
        {
          S3NativeFileSystem.LOG.info("Encountered an exception while reading '{}', max retries exceeded.", inputStreamWithInfo
            .getKey(), e);
        }
        else
        {
          S3NativeFileSystem.LOG.info("Encountered an exception while reading '{}', will retry by attempting to reopen stream.", inputStreamWithInfo
            .getKey(), e);
          long retryInterval = EmrFsUtils.calculateRetryInterval(
            ConfigurationUtils.getRetryPolicyType(this$0.getConf()), readRetryInterval, attempt);
          S3NativeFileSystem.LOG.debug("Back off {} ms for retrying open stream while reading due to s3 GET-After-PUT consistency issue. For best practice please see https://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html#ConsistencyModel", 
          
            Long.valueOf(retryInterval));
          EmrFsUtils.sleep(retryInterval);
        }
      }
      if (attempt >= 4)
      {
        S3NativeFileSystem.LOG.error("Unable to recover reading from stream");
        
        throw new IOException(generateUnexpectedEndOfStreamMsg());
      }
    }
    return result;
  }
  
  private String generateUnexpectedEndOfStreamMsg()
  {
    StringBuilder messageBuilder = new StringBuilder("Unexpected end of stream pos=" + lastReadPos);
    if (inputStreamWithInfo.isSelect()) {
      messageBuilder.append(", byteScanned=" + inputStreamWithInfo.getSelectByteScanned());
    }
    messageBuilder.append(", contentLength=" + inputStreamWithInfo.getContentLength());
    return messageBuilder.toString();
  }
  
  private void advance(int amount)
  {
    lastReadPos += amount;
    nextReadPos += amount;
    if (S3NativeFileSystem.access$000(this$0) != null) {
      S3NativeFileSystem.access$100(this$0).incrementBytesRead(amount);
    }
  }
  
  public void close()
    throws IOException
  {
    inputStreamWithInfo.close();
  }
  
  private void retrieveInputStreamWithInfo(long pos)
    throws IOException
  {
    if (pos > inputStreamWithInfo.getContentLength()) {
      throwPositionOutOfBoundsException(pos);
    }
    if (atEndOfStreamIfKnown(pos)) {
      return;
    }
    if (S3NativeFileSystem.LOG.isDebugEnabled()) {
      S3NativeFileSystem.LOG.debug("Stream for key '{}' seeking to position '{}'", inputStreamWithInfo
        .getKey(), Long.valueOf(pos));
    }
    if (inputStreamWithInfo.isSelect()) {
      inputStreamWithInfo = this$0.store.retrieveSelectObjectContentInputStreamWithInfo(inputStreamWithInfo
        .getKey(), 
        (Configuration)inputStreamWithInfo.getSelectOptions().get(), pos);
    } else {
      inputStreamWithInfo = this$0.store.retrieveInputStreamWithInfo(inputStreamWithInfo
        .getKey(), pos, shouldTryInitialTimeout
        
        .get());
    }
  }
  
  private boolean atEndOfStreamIfKnown()
  {
    return atEndOfStreamIfKnown(nextReadPos);
  }
  
  private boolean atEndOfStreamIfKnown(long pos)
  {
    return inputStreamWithInfo.atEndOfStreamIfKnown(pos);
  }
  
  private String throwPositionOutOfBoundsException(long pos)
    throws EOFException
  {
    throw new EOFException(String.format("Invalid position: %d, exceeds the bounds of the stream: [0, %d]", new Object[] {
      Long.valueOf(pos), Long.valueOf(inputStreamWithInfo.getContentLength()) }));
  }
  
  public synchronized void seek(long pos)
    throws IOException
  {
    if ((pos < 0L) || (pos > inputStreamWithInfo.getContentLength())) {
      throwPositionOutOfBoundsException(pos);
    }
    nextReadPos = pos;
    if (!lazySeek) {
      seekStream();
    }
  }
  
  private synchronized void seekStream()
    throws IOException
  {
    if ((lastReadPos == nextReadPos) && (!inputStreamWithInfo.wasClosedSuccessfully())) {
      return;
    }
    reopenStream();
  }
  
  private synchronized void reopenStream()
    throws IOException
  {
    inputStreamWithInfo.close();
    retrieveInputStreamWithInfo(nextReadPos);
    lastReadPos = nextReadPos;
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
      inputStreamWithInfo.close();
    }
    catch (IOException e)
    {
      S3NativeFileSystem.LOG.warn("Exception while trying to unbuffer input stream: ", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.S3NativeFileSystem.NativeS3FsInputStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */