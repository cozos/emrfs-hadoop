package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import java.io.IOException;
import java.io.InputStream;

@SdkInternalApi
public final class S3AbortableInputStream
  extends SdkFilterInputStream
{
  private static final Log LOG = LogFactory.getLog(S3AbortableInputStream.class);
  private final HttpRequestBase httpRequest;
  private final long contentLength;
  private long bytesRead;
  private long markedBytes;
  private boolean eofReached = false;
  
  public S3AbortableInputStream(InputStream in, HttpRequestBase httpRequest, long contentLength)
  {
    super(in);
    this.httpRequest = httpRequest;
    this.contentLength = contentLength;
  }
  
  public void abort()
  {
    super.abort();
    if (httpRequest != null) {
      httpRequest.abort();
    }
    IOUtils.closeQuietly(in, null);
  }
  
  public int available()
    throws IOException
  {
    int estimate = super.available();
    return estimate == 0 ? 1 : estimate;
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int value = super.read();
      eofReached = (value == -1);
      if (!eofReached) {
        bytesRead += 1L;
      }
      return value;
    }
    catch (Exception e)
    {
      return onException(e);
    }
  }
  
  public int read(byte[] b)
    throws IOException
  {
    return read(b, 0, b.length);
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    try
    {
      int value = super.read(b, off, len);
      eofReached = (value == -1);
      if (!eofReached) {
        bytesRead += value;
      }
      return value;
    }
    catch (Exception e)
    {
      return onException(e);
    }
  }
  
  public synchronized void mark(int readlimit)
  {
    super.mark(readlimit);
    markedBytes = bytesRead;
  }
  
  public synchronized void reset()
    throws IOException
  {
    super.reset();
    bytesRead = markedBytes;
    eofReached = false;
  }
  
  public synchronized long skip(long n)
    throws IOException
  {
    try
    {
      long skipped = super.skip(n);
      if (skipped > 0L) {
        bytesRead += skipped;
      }
      return skipped;
    }
    catch (Exception e)
    {
      return onException(e);
    }
  }
  
  public void close()
    throws IOException
  {
    if ((_readAllBytes()) || (isAborted()))
    {
      super.close();
    }
    else
    {
      LOG.warn("Not all bytes were read from the S3ObjectInputStream, aborting HTTP connection. This is likely an error and may result in sub-optimal behavior. Request only the bytes you need via a ranged GET or drain the input stream after use.");
      if (httpRequest != null) {
        httpRequest.abort();
      }
      IOUtils.closeQuietly(in, null);
    }
  }
  
  @SdkTestInternalApi
  long getBytesRead()
  {
    return bytesRead;
  }
  
  @SdkTestInternalApi
  boolean isEofReached()
  {
    return eofReached;
  }
  
  private int onException(Exception e)
    throws IOException
  {
    eofReached = true;
    if ((e instanceof IOException)) {
      throw ((IOException)e);
    }
    if ((e instanceof RuntimeException)) {
      throw ((RuntimeException)e);
    }
    throw Throwables.failure(e);
  }
  
  private boolean _readAllBytes()
  {
    return (bytesRead >= contentLength) || (eofReached);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3AbortableInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */