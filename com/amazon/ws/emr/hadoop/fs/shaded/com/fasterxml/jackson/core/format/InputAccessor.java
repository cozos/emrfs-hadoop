package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public abstract interface InputAccessor
{
  public abstract boolean hasMoreBytes()
    throws IOException;
  
  public abstract byte nextByte()
    throws IOException;
  
  public abstract void reset();
  
  public static class Std
    implements InputAccessor
  {
    protected final InputStream _in;
    protected final byte[] _buffer;
    protected final int _bufferedStart;
    protected int _bufferedEnd;
    protected int _ptr;
    
    public Std(InputStream in, byte[] buffer)
    {
      _in = in;
      _buffer = buffer;
      _bufferedStart = 0;
      _ptr = 0;
      _bufferedEnd = 0;
    }
    
    public Std(byte[] inputDocument)
    {
      _in = null;
      _buffer = inputDocument;
      
      _bufferedStart = 0;
      _bufferedEnd = inputDocument.length;
    }
    
    public Std(byte[] inputDocument, int start, int len)
    {
      _in = null;
      _buffer = inputDocument;
      _ptr = start;
      _bufferedStart = start;
      _bufferedEnd = (start + len);
    }
    
    public boolean hasMoreBytes()
      throws IOException
    {
      if (_ptr < _bufferedEnd) {
        return true;
      }
      if (_in == null) {
        return false;
      }
      int amount = _buffer.length - _ptr;
      if (amount < 1) {
        return false;
      }
      int count = _in.read(_buffer, _ptr, amount);
      if (count <= 0) {
        return false;
      }
      _bufferedEnd += count;
      return true;
    }
    
    public byte nextByte()
      throws IOException
    {
      if ((_ptr >= _bufferedEnd) && 
        (!hasMoreBytes())) {
        throw new EOFException("Failed auto-detect: could not read more than " + _ptr + " bytes (max buffer size: " + _buffer.length + ")");
      }
      return _buffer[(_ptr++)];
    }
    
    public void reset()
    {
      _ptr = _bufferedStart;
    }
    
    public DataFormatMatcher createMatcher(JsonFactory match, MatchStrength matchStrength)
    {
      return new DataFormatMatcher(_in, _buffer, _bufferedStart, _bufferedEnd - _bufferedStart, match, matchStrength);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */