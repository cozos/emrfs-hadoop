package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class ByteStreams$LimitedInputStream
  extends FilterInputStream
{
  private long left;
  private long mark = -1L;
  
  ByteStreams$LimitedInputStream(InputStream in, long limit)
  {
    super(in);
    Preconditions.checkNotNull(in);
    Preconditions.checkArgument(limit >= 0L, "limit must be non-negative");
    left = limit;
  }
  
  public int available()
    throws IOException
  {
    return (int)Math.min(in.available(), left);
  }
  
  public synchronized void mark(int readLimit)
  {
    in.mark(readLimit);
    mark = left;
  }
  
  public int read()
    throws IOException
  {
    if (left == 0L) {
      return -1;
    }
    int result = in.read();
    if (result != -1) {
      left -= 1L;
    }
    return result;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (left == 0L) {
      return -1;
    }
    len = (int)Math.min(len, left);
    int result = in.read(b, off, len);
    if (result != -1) {
      left -= result;
    }
    return result;
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
    left = mark;
  }
  
  public long skip(long n)
    throws IOException
  {
    n = Math.min(n, left);
    long skipped = in.skip(n);
    left -= skipped;
    return skipped;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteStreams.LimitedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */