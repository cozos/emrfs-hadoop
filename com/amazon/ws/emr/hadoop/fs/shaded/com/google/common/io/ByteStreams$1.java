package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.OutputStream;

final class ByteStreams$1
  extends OutputStream
{
  public void write(int b) {}
  
  public void write(byte[] b)
  {
    Preconditions.checkNotNull(b);
  }
  
  public void write(byte[] b, int off, int len)
  {
    Preconditions.checkNotNull(b);
  }
  
  public String toString()
  {
    return "ByteStreams.nullOutputStream()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteStreams.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */