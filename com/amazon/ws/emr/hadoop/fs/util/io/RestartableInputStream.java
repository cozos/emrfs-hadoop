package com.amazon.ws.emr.hadoop.fs.util.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.ClosedInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.ProxyInputStream;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public final class RestartableInputStream
  extends ProxyInputStream
{
  private final InputStream originalIn;
  private boolean isReleased;
  private boolean isAtStart = true;
  private boolean isMarkAtStart = true;
  
  public RestartableInputStream(InputStream in)
  {
    this(in, -1);
  }
  
  public RestartableInputStream(InputStream in, int readLimitForMark)
  {
    super(in);
    originalIn = in;
    if (originalIn.markSupported())
    {
      Preconditions.checkArgument(readLimitForMark > 0, "Must specify read limit for mark supported input streams");
      
      originalIn.mark(readLimitForMark);
    }
  }
  
  public void restart()
    throws IOException
  {
    checkIfNotReleased();
    
    boolean wasCloseCalled = wasCloseCalled();
    try
    {
      if (wasCloseCalled) {
        in = originalIn;
      }
      if (isAtStart) {
        return;
      }
      if (!markSupported()) {
        throw new IOException("Cannot restart the stream as mark-and-reset was not supported");
      }
      if (!isMarkAtStart) {
        throw new IOException("Cannot restart the stream as caller marked the stream passed the initial starting position.");
      }
      reset();
    }
    catch (Exception e)
    {
      if (wasCloseCalled) {
        close();
      }
      throw e;
    }
  }
  
  public void release()
    throws IOException
  {
    isReleased = true;
    originalIn.close();
  }
  
  protected void beforeRead(int bytesToRead)
    throws IOException
  {
    checkIfOpen();
  }
  
  protected void afterRead(int bytesRead)
    throws IOException
  {
    advance(bytesRead);
  }
  
  public long skip(long ln)
    throws IOException
  {
    checkIfOpen();
    long bytesSkipped = super.skip(ln);
    advance(bytesSkipped);
    return bytesSkipped;
  }
  
  public int available()
    throws IOException
  {
    checkIfOpen();
    return super.available();
  }
  
  public void close()
  {
    in = ClosedInputStream.CLOSED_INPUT_STREAM;
  }
  
  public synchronized void mark(int readLimit)
  {
    if (wasCloseCalled()) {
      return;
    }
    super.mark(readLimit);
    isMarkAtStart = isAtStart;
  }
  
  public synchronized void reset()
    throws IOException
  {
    checkIfOpen();
    super.reset();
    isAtStart = isMarkAtStart;
  }
  
  private void advance(long amount)
  {
    if (amount > 0L) {
      isAtStart = false;
    }
  }
  
  private boolean wasCloseCalled()
  {
    return in instanceof ClosedInputStream;
  }
  
  private void checkIfOpen()
    throws IOException
  {
    checkIfNotReleased();
    if (wasCloseCalled()) {
      throw new IOException("Stream must be open or restarted");
    }
  }
  
  private void checkIfNotReleased()
    throws IOException
  {
    if (isReleased) {
      throw new IOException("Stream was released");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.io.RestartableInputStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */