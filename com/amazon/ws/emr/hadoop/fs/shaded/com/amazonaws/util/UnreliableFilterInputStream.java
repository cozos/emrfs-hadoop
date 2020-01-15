package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UnreliableFilterInputStream
  extends FilterInputStream
{
  private int maxNumErrors = 1;
  private int currNumErrors;
  private int bytesReadBeforeException = 100;
  private int marked;
  private int position;
  private final boolean isFakeIOException;
  private int resetCount;
  private int resetIntervalBeforeException;
  
  public UnreliableFilterInputStream(InputStream in, boolean isFakeIOException)
  {
    super(in);
    this.isFakeIOException = isFakeIOException;
  }
  
  public int read()
    throws IOException
  {
    int read = super.read();
    if (read != -1) {
      position += 1;
    }
    triggerError();
    return read;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    triggerError();
    int read = super.read(b, off, len);
    position += read;
    triggerError();
    return read;
  }
  
  public void mark(int readlimit)
  {
    super.mark(readlimit);
    marked = position;
  }
  
  public void reset()
    throws IOException
  {
    resetCount += 1;
    super.reset();
    position = marked;
  }
  
  private void triggerError()
    throws FakeIOException
  {
    if (currNumErrors >= maxNumErrors) {
      return;
    }
    if (position >= bytesReadBeforeException)
    {
      if ((resetIntervalBeforeException > 0) && (resetCount % resetIntervalBeforeException != resetIntervalBeforeException - 1)) {
        return;
      }
      currNumErrors += 1;
      if (isFakeIOException) {
        throw new FakeIOException("Fake IO error " + currNumErrors + " on UnreliableFileInputStream: " + this);
      }
      throw new RuntimeException("Injected runtime error " + currNumErrors + " on UnreliableFileInputStream: " + this);
    }
  }
  
  public int getCurrNumErrors()
  {
    return currNumErrors;
  }
  
  public int getMaxNumErrors()
  {
    return maxNumErrors;
  }
  
  public UnreliableFilterInputStream withMaxNumErrors(int maxNumErrors)
  {
    this.maxNumErrors = maxNumErrors;
    return this;
  }
  
  public UnreliableFilterInputStream withBytesReadBeforeException(int bytesReadBeforeException)
  {
    this.bytesReadBeforeException = bytesReadBeforeException;
    return this;
  }
  
  public int getBytesReadBeforeException()
  {
    return bytesReadBeforeException;
  }
  
  public UnreliableFilterInputStream withResetIntervalBeforeException(int resetIntervalBeforeException)
  {
    this.resetIntervalBeforeException = resetIntervalBeforeException;
    return this;
  }
  
  public int getResetIntervalBeforeException()
  {
    return resetIntervalBeforeException;
  }
  
  public int getMarked()
  {
    return marked;
  }
  
  public int getPosition()
  {
    return position;
  }
  
  public boolean isFakeIOException()
  {
    return isFakeIOException;
  }
  
  public int getResetCount()
  {
    return resetCount;
  }
  
  public String toString()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.UnreliableFilterInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */