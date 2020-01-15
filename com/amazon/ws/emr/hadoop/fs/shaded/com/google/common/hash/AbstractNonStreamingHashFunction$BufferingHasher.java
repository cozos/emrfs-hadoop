package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.IOException;

final class AbstractNonStreamingHashFunction$BufferingHasher
  extends AbstractHasher
{
  final AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream stream;
  static final int BOTTOM_BYTE = 255;
  
  AbstractNonStreamingHashFunction$BufferingHasher(AbstractNonStreamingHashFunction paramAbstractNonStreamingHashFunction, int expectedInputSize)
  {
    stream = new AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream(expectedInputSize);
  }
  
  public Hasher putByte(byte b)
  {
    stream.write(b);
    return this;
  }
  
  public Hasher putBytes(byte[] bytes)
  {
    try
    {
      stream.write(bytes);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    return this;
  }
  
  public Hasher putBytes(byte[] bytes, int off, int len)
  {
    stream.write(bytes, off, len);
    return this;
  }
  
  public Hasher putShort(short s)
  {
    stream.write(s & 0xFF);
    stream.write(s >>> 8 & 0xFF);
    return this;
  }
  
  public Hasher putInt(int i)
  {
    stream.write(i & 0xFF);
    stream.write(i >>> 8 & 0xFF);
    stream.write(i >>> 16 & 0xFF);
    stream.write(i >>> 24 & 0xFF);
    return this;
  }
  
  public Hasher putLong(long l)
  {
    for (int i = 0; i < 64; i += 8) {
      stream.write((byte)(int)(l >>> i & 0xFF));
    }
    return this;
  }
  
  public Hasher putChar(char c)
  {
    stream.write(c & 0xFF);
    stream.write(c >>> '\b' & 0xFF);
    return this;
  }
  
  public <T> Hasher putObject(T instance, Funnel<? super T> funnel)
  {
    funnel.funnel(instance, this);
    return this;
  }
  
  public HashCode hash()
  {
    return this$0.hashBytes(stream.byteArray(), 0, stream.length());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.AbstractNonStreamingHashFunction.BufferingHasher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */