package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.ByteArrayOutputStream;

final class ByteStreams$FastByteArrayOutputStream
  extends ByteArrayOutputStream
{
  void writeTo(byte[] b, int off)
  {
    System.arraycopy(buf, 0, b, off, count);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteStreams.FastByteArrayOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */