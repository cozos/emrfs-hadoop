package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

public final class MergedStream
  extends InputStream
{
  private final IOContext _ctxt;
  private final InputStream _in;
  private byte[] _b;
  private int _ptr;
  private final int _end;
  
  public MergedStream(IOContext ctxt, InputStream in, byte[] buf, int start, int end)
  {
    _ctxt = ctxt;
    _in = in;
    _b = buf;
    _ptr = start;
    _end = end;
  }
  
  public int available()
    throws IOException
  {
    if (_b != null) {
      return _end - _ptr;
    }
    return _in.available();
  }
  
  public void close()
    throws IOException
  {
    _free();
    _in.close();
  }
  
  public void mark(int readlimit)
  {
    if (_b == null) {
      _in.mark(readlimit);
    }
  }
  
  public boolean markSupported()
  {
    return (_b == null) && (_in.markSupported());
  }
  
  public int read()
    throws IOException
  {
    if (_b != null)
    {
      int c = _b[(_ptr++)] & 0xFF;
      if (_ptr >= _end) {
        _free();
      }
      return c;
    }
    return _in.read();
  }
  
  public int read(byte[] b)
    throws IOException
  {
    return read(b, 0, b.length);
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (_b != null)
    {
      int avail = _end - _ptr;
      if (len > avail) {
        len = avail;
      }
      System.arraycopy(_b, _ptr, b, off, len);
      _ptr += len;
      if (_ptr >= _end) {
        _free();
      }
      return len;
    }
    return _in.read(b, off, len);
  }
  
  public void reset()
    throws IOException
  {
    if (_b == null) {
      _in.reset();
    }
  }
  
  public long skip(long n)
    throws IOException
  {
    long count = 0L;
    if (_b != null)
    {
      int amount = _end - _ptr;
      if (amount > n)
      {
        _ptr += (int)n;
        return n;
      }
      _free();
      count += amount;
      n -= amount;
    }
    if (n > 0L) {
      count += _in.skip(n);
    }
    return count;
  }
  
  private void _free()
  {
    byte[] buf = _b;
    if (buf != null)
    {
      _b = null;
      if (_ctxt != null) {
        _ctxt.releaseReadIOBuffer(buf);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.MergedStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */