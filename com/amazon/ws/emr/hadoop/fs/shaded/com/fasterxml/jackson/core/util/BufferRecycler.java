package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

public class BufferRecycler
{
  public static final int BYTE_READ_IO_BUFFER = 0;
  public static final int BYTE_WRITE_ENCODING_BUFFER = 1;
  public static final int BYTE_WRITE_CONCAT_BUFFER = 2;
  public static final int BYTE_BASE64_CODEC_BUFFER = 3;
  public static final int CHAR_TOKEN_BUFFER = 0;
  public static final int CHAR_CONCAT_BUFFER = 1;
  public static final int CHAR_TEXT_BUFFER = 2;
  public static final int CHAR_NAME_COPY_BUFFER = 3;
  private static final int[] BYTE_BUFFER_LENGTHS = { 8000, 8000, 2000, 2000 };
  private static final int[] CHAR_BUFFER_LENGTHS = { 4000, 4000, 200, 200 };
  protected final byte[][] _byteBuffers;
  protected final char[][] _charBuffers;
  
  public BufferRecycler()
  {
    this(4, 4);
  }
  
  protected BufferRecycler(int bbCount, int cbCount)
  {
    _byteBuffers = new byte[bbCount][];
    _charBuffers = new char[cbCount][];
  }
  
  public final byte[] allocByteBuffer(int ix)
  {
    return allocByteBuffer(ix, 0);
  }
  
  public byte[] allocByteBuffer(int ix, int minSize)
  {
    int DEF_SIZE = byteBufferLength(ix);
    if (minSize < DEF_SIZE) {
      minSize = DEF_SIZE;
    }
    byte[] buffer = _byteBuffers[ix];
    if ((buffer == null) || (buffer.length < minSize)) {
      buffer = balloc(minSize);
    } else {
      _byteBuffers[ix] = null;
    }
    return buffer;
  }
  
  public final void releaseByteBuffer(int ix, byte[] buffer)
  {
    _byteBuffers[ix] = buffer;
  }
  
  public final char[] allocCharBuffer(int ix)
  {
    return allocCharBuffer(ix, 0);
  }
  
  public char[] allocCharBuffer(int ix, int minSize)
  {
    int DEF_SIZE = charBufferLength(ix);
    if (minSize < DEF_SIZE) {
      minSize = DEF_SIZE;
    }
    char[] buffer = _charBuffers[ix];
    if ((buffer == null) || (buffer.length < minSize)) {
      buffer = calloc(minSize);
    } else {
      _charBuffers[ix] = null;
    }
    return buffer;
  }
  
  public void releaseCharBuffer(int ix, char[] buffer)
  {
    _charBuffers[ix] = buffer;
  }
  
  protected int byteBufferLength(int ix)
  {
    return BYTE_BUFFER_LENGTHS[ix];
  }
  
  protected int charBufferLength(int ix)
  {
    return CHAR_BUFFER_LENGTHS[ix];
  }
  
  protected byte[] balloc(int size)
  {
    return new byte[size];
  }
  
  protected char[] calloc(int size)
  {
    return new char[size];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.BufferRecycler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */