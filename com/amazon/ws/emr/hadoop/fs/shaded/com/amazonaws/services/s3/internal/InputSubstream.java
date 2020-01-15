package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputSubstream
  extends SdkFilterInputStream
{
  private static final int MAX_SKIPS = 100;
  private long currentPosition;
  private final long requestedOffset;
  private final long requestedLength;
  private final boolean closeSourceStream;
  private long markedPosition = 0L;
  
  public InputSubstream(InputStream in, long offset, long length, boolean closeSourceStream)
  {
    super(in);
    
    currentPosition = 0L;
    requestedLength = length;
    requestedOffset = offset;
    this.closeSourceStream = closeSourceStream;
  }
  
  public int read()
    throws IOException
  {
    byte[] b = new byte[1];
    int bytesRead = read(b, 0, 1);
    if (bytesRead == -1) {
      return bytesRead;
    }
    return b[0];
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int count = 0;
    while (currentPosition < requestedOffset)
    {
      long skippedBytes = super.skip(requestedOffset - currentPosition);
      if (skippedBytes == 0L)
      {
        count++;
        if (count > 100) {
          throw new SdkClientException("Unable to position the currentPosition from " + currentPosition + " to " + requestedOffset);
        }
      }
      currentPosition += skippedBytes;
    }
    long bytesRemaining = requestedLength + requestedOffset - currentPosition;
    if (bytesRemaining <= 0L) {
      return -1;
    }
    len = (int)Math.min(len, bytesRemaining);
    int bytesRead = super.read(b, off, len);
    currentPosition += bytesRead;
    
    return bytesRead;
  }
  
  public synchronized void mark(int readlimit)
  {
    markedPosition = currentPosition;
    super.mark(readlimit);
  }
  
  public synchronized void reset()
    throws IOException
  {
    currentPosition = markedPosition;
    super.reset();
  }
  
  public void close()
    throws IOException
  {
    if (closeSourceStream) {
      super.close();
    }
  }
  
  public int available()
    throws IOException
  {
    long bytesRemaining;
    long bytesRemaining;
    if (currentPosition < requestedOffset) {
      bytesRemaining = requestedLength;
    } else {
      bytesRemaining = requestedLength + requestedOffset - currentPosition;
    }
    return (int)Math.min(bytesRemaining, super.available());
  }
  
  InputStream getWrappedInputStream()
  {
    return in;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.InputSubstream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */