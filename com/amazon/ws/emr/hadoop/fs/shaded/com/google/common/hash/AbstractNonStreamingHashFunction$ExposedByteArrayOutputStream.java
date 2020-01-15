package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.ByteArrayOutputStream;

final class AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream
  extends ByteArrayOutputStream
{
  AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(int expectedInputSize)
  {
    super(expectedInputSize);
  }
  
  byte[] byteArray()
  {
    return buf;
  }
  
  int length()
  {
    return count;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */