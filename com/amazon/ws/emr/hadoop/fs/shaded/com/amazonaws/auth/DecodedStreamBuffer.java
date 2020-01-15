package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

class DecodedStreamBuffer
{
  private static final Log log = LogFactory.getLog(DecodedStreamBuffer.class);
  private byte[] bufferArray;
  private int maxBufferSize;
  private int byteBuffered;
  private int pos = -1;
  private boolean bufferSizeOverflow;
  
  public DecodedStreamBuffer(int maxBufferSize)
  {
    bufferArray = new byte[maxBufferSize];
    this.maxBufferSize = maxBufferSize;
  }
  
  public void buffer(byte read)
  {
    pos = -1;
    if (byteBuffered >= maxBufferSize)
    {
      if (log.isDebugEnabled()) {
        log.debug("Buffer size " + maxBufferSize + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
      }
      bufferSizeOverflow = true;
    }
    else
    {
      bufferArray[(byteBuffered++)] = read;
    }
  }
  
  public void buffer(byte[] src, int srcPos, int length)
  {
    pos = -1;
    if (byteBuffered + length > maxBufferSize)
    {
      if (log.isDebugEnabled()) {
        log.debug("Buffer size " + maxBufferSize + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
      }
      bufferSizeOverflow = true;
    }
    else
    {
      System.arraycopy(src, srcPos, bufferArray, byteBuffered, length);
      byteBuffered += length;
    }
  }
  
  public boolean hasNext()
  {
    return (pos != -1) && (pos < byteBuffered);
  }
  
  public byte next()
  {
    return bufferArray[(pos++)];
  }
  
  public void startReadBuffer()
  {
    if (bufferSizeOverflow) {
      throw new SdkClientException("The input stream is not repeatable since the buffer size " + maxBufferSize + " has been exceeded.");
    }
    pos = 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DecodedStreamBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */