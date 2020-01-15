package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream
  extends InputStream
{
  protected final ByteBuffer _b;
  
  public ByteBufferBackedInputStream(ByteBuffer buf)
  {
    _b = buf;
  }
  
  public int available()
  {
    return _b.remaining();
  }
  
  public int read()
    throws IOException
  {
    return _b.hasRemaining() ? _b.get() & 0xFF : -1;
  }
  
  public int read(byte[] bytes, int off, int len)
    throws IOException
  {
    if (!_b.hasRemaining()) {
      return -1;
    }
    len = Math.min(len, _b.remaining());
    _b.get(bytes, off, len);
    return len;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */