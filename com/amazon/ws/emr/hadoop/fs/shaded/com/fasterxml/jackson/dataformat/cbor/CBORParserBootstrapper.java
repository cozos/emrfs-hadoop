package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.io.IOException;
import java.io.InputStream;

public class CBORParserBootstrapper
{
  protected final IOContext _context;
  protected final InputStream _in;
  protected final byte[] _inputBuffer;
  protected int _inputPtr;
  protected int _inputEnd;
  protected final boolean _bufferRecyclable;
  protected int _inputProcessed;
  
  public CBORParserBootstrapper(IOContext ctxt, InputStream in)
  {
    _context = ctxt;
    _in = in;
    _inputBuffer = ctxt.allocReadIOBuffer();
    _inputEnd = (_inputPtr = 0);
    _inputProcessed = 0;
    _bufferRecyclable = true;
  }
  
  public CBORParserBootstrapper(IOContext ctxt, byte[] inputBuffer, int inputStart, int inputLen)
  {
    _context = ctxt;
    _in = null;
    _inputBuffer = inputBuffer;
    _inputPtr = inputStart;
    _inputEnd = (inputStart + inputLen);
    
    _inputProcessed = (-inputStart);
    _bufferRecyclable = false;
  }
  
  public CBORParser constructParser(int factoryFeatures, int generalParserFeatures, int formatFeatures, ObjectCodec codec, ByteQuadsCanonicalizer rootByteSymbols)
    throws IOException, JsonParseException
  {
    ByteQuadsCanonicalizer can = rootByteSymbols.makeChild(factoryFeatures);
    
    ensureLoaded(1);
    CBORParser p = new CBORParser(_context, generalParserFeatures, formatFeatures, codec, can, _in, _inputBuffer, _inputPtr, _inputEnd, _bufferRecyclable);
    if (_inputPtr < _inputEnd) {}
    return p;
  }
  
  public static MatchStrength hasCBORFormat(InputAccessor acc)
    throws IOException
  {
    if (!acc.hasMoreBytes()) {
      return MatchStrength.INCONCLUSIVE;
    }
    byte b = acc.nextByte();
    if (b == -65)
    {
      if (acc.hasMoreBytes())
      {
        b = acc.nextByte();
        if (b == -1) {
          return MatchStrength.SOLID_MATCH;
        }
        if (CBORConstants.hasMajorType(3, b)) {
          return MatchStrength.SOLID_MATCH;
        }
        return MatchStrength.INCONCLUSIVE;
      }
    }
    else if (b == -97)
    {
      if (acc.hasMoreBytes())
      {
        b = acc.nextByte();
        if (b == -1) {
          return MatchStrength.SOLID_MATCH;
        }
        return MatchStrength.WEAK_MATCH;
      }
    }
    else
    {
      if (CBORConstants.hasMajorType(6, b))
      {
        if ((b == -39) && 
          (acc.hasMoreBytes()))
        {
          b = acc.nextByte();
          if ((b == -39) && 
            (acc.hasMoreBytes()))
          {
            b = acc.nextByte();
            if (b == -9) {
              return MatchStrength.FULL_MATCH;
            }
          }
        }
        return MatchStrength.WEAK_MATCH;
      }
      if (CBORConstants.hasMajorType(7, b))
      {
        if ((b == -12) || (b == -11) || (b == -10)) {
          return MatchStrength.SOLID_MATCH;
        }
        return MatchStrength.NO_MATCH;
      }
    }
    return MatchStrength.INCONCLUSIVE;
  }
  
  protected boolean ensureLoaded(int minimum)
    throws IOException
  {
    if (_in == null) {
      return false;
    }
    int gotten = _inputEnd - _inputPtr;
    while (gotten < minimum)
    {
      int count = _in.read(_inputBuffer, _inputEnd, _inputBuffer.length - _inputEnd);
      if (count < 1) {
        return false;
      }
      _inputEnd += count;
      gotten += count;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORParserBootstrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */