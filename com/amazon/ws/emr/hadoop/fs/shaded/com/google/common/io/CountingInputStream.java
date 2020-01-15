package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

@Beta
public final class CountingInputStream
  extends FilterInputStream
{
  private long count;
  private long mark = -1L;
  
  public CountingInputStream(@Nullable InputStream in)
  {
    super(in);
  }
  
  public long getCount()
  {
    return count;
  }
  
  public int read()
    throws IOException
  {
    int result = in.read();
    if (result != -1) {
      count += 1L;
    }
    return result;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int result = in.read(b, off, len);
    if (result != -1) {
      count += result;
    }
    return result;
  }
  
  public long skip(long n)
    throws IOException
  {
    long result = in.skip(n);
    count += result;
    return result;
  }
  
  public synchronized void mark(int readlimit)
  {
    in.mark(readlimit);
    mark = count;
  }
  
  public synchronized void reset()
    throws IOException
  {
    if (!in.markSupported()) {
      throw new IOException("Mark not supported");
    }
    if (mark == -1L) {
      throw new IOException("Mark not set");
    }
    in.reset();
    count = mark;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CountingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */