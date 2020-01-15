package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class RepeatableInputStream
  extends SdkInputStream
{
  private static final Log log = LogFactory.getLog(RepeatableInputStream.class);
  private InputStream is;
  private int bufferSize;
  private int bufferOffset;
  private long bytesReadPastMark;
  private byte[] buffer;
  private boolean hasWarnedBufferOverflow;
  
  public RepeatableInputStream(InputStream inputStream, int bufferSize)
  {
    if (inputStream == null) {
      throw new IllegalArgumentException("InputStream cannot be null");
    }
    is = inputStream;
    this.bufferSize = bufferSize;
    buffer = new byte[this.bufferSize];
    if (log.isDebugEnabled()) {
      log.debug("Underlying input stream will be repeatable up to " + buffer.length + " bytes");
    }
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    if (bytesReadPastMark <= bufferSize)
    {
      if (log.isDebugEnabled()) {
        log.debug("Reset after reading " + bytesReadPastMark + " bytes.");
      }
      bufferOffset = 0;
    }
    else
    {
      throw new IOException("Input stream cannot be reset as " + bytesReadPastMark + " bytes have been written, exceeding the available buffer size of " + bufferSize);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    if (log.isDebugEnabled()) {
      log.debug("Input stream marked at " + bytesReadPastMark + " bytes");
    }
    if ((bytesReadPastMark <= bufferSize) && (buffer != null))
    {
      byte[] newBuffer = new byte[bufferSize];
      System.arraycopy(buffer, bufferOffset, newBuffer, 0, (int)(bytesReadPastMark - bufferOffset));
      buffer = newBuffer;
      bytesReadPastMark -= bufferOffset;
      bufferOffset = 0;
    }
    else
    {
      bufferOffset = 0;
      bytesReadPastMark = 0L;
      buffer = new byte[bufferSize];
    }
  }
  
  public int available()
    throws IOException
  {
    abortIfNeeded();
    return is.available();
  }
  
  public void close()
    throws IOException
  {
    is.close();
    abortIfNeeded();
  }
  
  public int read(byte[] out, int outOffset, int outLength)
    throws IOException
  {
    abortIfNeeded();
    if ((bufferOffset < bytesReadPastMark) && (buffer != null))
    {
      int bytesFromBuffer = outLength;
      if (bufferOffset + bytesFromBuffer > bytesReadPastMark) {
        bytesFromBuffer = (int)bytesReadPastMark - bufferOffset;
      }
      System.arraycopy(buffer, bufferOffset, out, outOffset, bytesFromBuffer);
      bufferOffset += bytesFromBuffer;
      return bytesFromBuffer;
    }
    int count = is.read(out, outOffset, outLength);
    if (count <= 0) {
      return count;
    }
    if (bytesReadPastMark + count <= bufferSize)
    {
      System.arraycopy(out, outOffset, buffer, (int)bytesReadPastMark, count);
      bufferOffset += count;
    }
    else
    {
      if (!hasWarnedBufferOverflow)
      {
        if (log.isDebugEnabled()) {
          log.debug("Buffer size " + bufferSize + " has been exceeded and the input stream will not be repeatable until the next mark. Freeing buffer memory");
        }
        hasWarnedBufferOverflow = true;
      }
      buffer = null;
    }
    bytesReadPastMark += count;
    
    return count;
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    byte[] tmp = new byte[1];
    int count = read(tmp);
    if (count != -1)
    {
      int unsignedByte = tmp[0] & 0xFF;
      return unsignedByte;
    }
    return count;
  }
  
  public InputStream getWrappedInputStream()
  {
    return is;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.RepeatableInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */