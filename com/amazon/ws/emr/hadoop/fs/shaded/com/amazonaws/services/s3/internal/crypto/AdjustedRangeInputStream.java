package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class AdjustedRangeInputStream
  extends SdkInputStream
{
  private InputStream decryptedContents;
  private long virtualAvailable;
  private boolean closed;
  
  public AdjustedRangeInputStream(InputStream objectContents, long rangeBeginning, long rangeEnd)
    throws IOException
  {
    decryptedContents = objectContents;
    closed = false;
    initializeForRead(rangeBeginning, rangeEnd);
  }
  
  private void initializeForRead(long rangeBeginning, long rangeEnd)
    throws IOException
  {
    int numBytesToSkip;
    int numBytesToSkip;
    if (rangeBeginning < 16L)
    {
      numBytesToSkip = (int)rangeBeginning;
    }
    else
    {
      int offsetIntoBlock = (int)(rangeBeginning % 16L);
      numBytesToSkip = 16 + offsetIntoBlock;
    }
    if (numBytesToSkip != 0) {
      while (numBytesToSkip > 0)
      {
        decryptedContents.read();
        numBytesToSkip--;
      }
    }
    virtualAvailable = (rangeEnd - rangeBeginning + 1L);
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    int result;
    int result;
    if (virtualAvailable <= 0L) {
      result = -1;
    } else {
      result = decryptedContents.read();
    }
    if (result != -1)
    {
      virtualAvailable -= 1L;
    }
    else
    {
      virtualAvailable = 0L;
      close();
    }
    return result;
  }
  
  public int read(byte[] buffer, int offset, int length)
    throws IOException
  {
    abortIfNeeded();
    int numBytesRead;
    int numBytesRead;
    if (virtualAvailable <= 0L)
    {
      numBytesRead = -1;
    }
    else
    {
      if (length > virtualAvailable) {
        length = virtualAvailable < 2147483647L ? (int)virtualAvailable : Integer.MAX_VALUE;
      }
      numBytesRead = decryptedContents.read(buffer, offset, length);
    }
    if (numBytesRead != -1)
    {
      virtualAvailable -= numBytesRead;
    }
    else
    {
      virtualAvailable = 0L;
      close();
    }
    return numBytesRead;
  }
  
  public int available()
    throws IOException
  {
    abortIfNeeded();
    int available = decryptedContents.available();
    if (available < virtualAvailable) {
      return available;
    }
    return (int)virtualAvailable;
  }
  
  public void close()
    throws IOException
  {
    if (!closed)
    {
      closed = true;
      if (virtualAvailable == 0L) {
        IOUtils.drainInputStream(decryptedContents);
      }
      decryptedContents.close();
    }
    abortIfNeeded();
  }
  
  protected InputStream getWrappedInputStream()
  {
    return decryptedContents;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.AdjustedRangeInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */