package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class AbstractMessageLite$Builder$LimitedInputStream
  extends FilterInputStream
{
  private int limit;
  
  AbstractMessageLite$Builder$LimitedInputStream(InputStream in, int limit)
  {
    super(in);
    this.limit = limit;
  }
  
  public int available()
    throws IOException
  {
    return Math.min(super.available(), limit);
  }
  
  public int read()
    throws IOException
  {
    if (limit <= 0) {
      return -1;
    }
    int result = super.read();
    if (result >= 0) {
      limit -= 1;
    }
    return result;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (limit <= 0) {
      return -1;
    }
    len = Math.min(len, limit);
    int result = super.read(b, off, len);
    if (result >= 0) {
      limit -= result;
    }
    return result;
  }
  
  public long skip(long n)
    throws IOException
  {
    long result = super.skip(Math.min(n, limit));
    if (result >= 0L) {
      limit = ((int)(limit - result));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.AbstractMessageLite.Builder.LimitedInputStream
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */