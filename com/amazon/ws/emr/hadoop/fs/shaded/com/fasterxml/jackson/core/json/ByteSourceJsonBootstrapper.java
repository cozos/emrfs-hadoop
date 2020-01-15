package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonEncoding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.MergedStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.UTF32Reader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class ByteSourceJsonBootstrapper
{
  static final byte UTF8_BOM_1 = -17;
  static final byte UTF8_BOM_2 = -69;
  static final byte UTF8_BOM_3 = -65;
  protected final IOContext _context;
  protected final InputStream _in;
  protected final byte[] _inputBuffer;
  private int _inputPtr;
  private int _inputEnd;
  private final boolean _bufferRecyclable;
  protected int _inputProcessed;
  protected boolean _bigEndian = true;
  protected int _bytesPerChar = 0;
  
  public ByteSourceJsonBootstrapper(IOContext ctxt, InputStream in)
  {
    _context = ctxt;
    _in = in;
    _inputBuffer = ctxt.allocReadIOBuffer();
    _inputEnd = (_inputPtr = 0);
    _inputProcessed = 0;
    _bufferRecyclable = true;
  }
  
  public ByteSourceJsonBootstrapper(IOContext ctxt, byte[] inputBuffer, int inputStart, int inputLen)
  {
    _context = ctxt;
    _in = null;
    _inputBuffer = inputBuffer;
    _inputPtr = inputStart;
    _inputEnd = (inputStart + inputLen);
    
    _inputProcessed = (-inputStart);
    _bufferRecyclable = false;
  }
  
  public JsonEncoding detectEncoding()
    throws IOException
  {
    boolean foundEncoding = false;
    if (ensureLoaded(4))
    {
      int quad = _inputBuffer[_inputPtr] << 24 | (_inputBuffer[(_inputPtr + 1)] & 0xFF) << 16 | (_inputBuffer[(_inputPtr + 2)] & 0xFF) << 8 | _inputBuffer[(_inputPtr + 3)] & 0xFF;
      if (handleBOM(quad)) {
        foundEncoding = true;
      } else if (checkUTF32(quad)) {
        foundEncoding = true;
      } else if (checkUTF16(quad >>> 16)) {
        foundEncoding = true;
      }
    }
    else if (ensureLoaded(2))
    {
      int i16 = (_inputBuffer[_inputPtr] & 0xFF) << 8 | _inputBuffer[(_inputPtr + 1)] & 0xFF;
      if (checkUTF16(i16)) {
        foundEncoding = true;
      }
    }
    JsonEncoding enc;
    JsonEncoding enc;
    if (!foundEncoding) {
      enc = JsonEncoding.UTF8;
    } else {
      switch (_bytesPerChar)
      {
      case 1: 
        enc = JsonEncoding.UTF8;
        break;
      case 2: 
        enc = _bigEndian ? JsonEncoding.UTF16_BE : JsonEncoding.UTF16_LE;
        break;
      case 4: 
        enc = _bigEndian ? JsonEncoding.UTF32_BE : JsonEncoding.UTF32_LE;
        break;
      case 3: 
      default: 
        throw new RuntimeException("Internal error");
      }
    }
    _context.setEncoding(enc);
    return enc;
  }
  
  public Reader constructReader()
    throws IOException
  {
    JsonEncoding enc = _context.getEncoding();
    switch (enc.bits())
    {
    case 8: 
    case 16: 
      InputStream in = _in;
      if (in == null) {
        in = new ByteArrayInputStream(_inputBuffer, _inputPtr, _inputEnd);
      } else if (_inputPtr < _inputEnd) {
        in = new MergedStream(_context, in, _inputBuffer, _inputPtr, _inputEnd);
      }
      return new InputStreamReader(in, enc.getJavaName());
    case 32: 
      return new UTF32Reader(_context, _in, _inputBuffer, _inputPtr, _inputEnd, _context.getEncoding().isBigEndian());
    }
    throw new RuntimeException("Internal error");
  }
  
  public JsonParser constructParser(int parserFeatures, ObjectCodec codec, ByteQuadsCanonicalizer rootByteSymbols, CharsToNameCanonicalizer rootCharSymbols, int factoryFeatures)
    throws IOException
  {
    JsonEncoding enc = detectEncoding();
    if (enc == JsonEncoding.UTF8) {
      if (JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(factoryFeatures))
      {
        ByteQuadsCanonicalizer can = rootByteSymbols.makeChild(factoryFeatures);
        return new UTF8StreamJsonParser(_context, parserFeatures, _in, codec, can, _inputBuffer, _inputPtr, _inputEnd, _bufferRecyclable);
      }
    }
    return new ReaderBasedJsonParser(_context, parserFeatures, constructReader(), codec, rootCharSymbols.makeChild(factoryFeatures));
  }
  
  public static MatchStrength hasJSONFormat(InputAccessor acc)
    throws IOException
  {
    if (!acc.hasMoreBytes()) {
      return MatchStrength.INCONCLUSIVE;
    }
    byte b = acc.nextByte();
    if (b == -17)
    {
      if (!acc.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (acc.nextByte() != -69) {
        return MatchStrength.NO_MATCH;
      }
      if (!acc.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (acc.nextByte() != -65) {
        return MatchStrength.NO_MATCH;
      }
      if (!acc.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      b = acc.nextByte();
    }
    int ch = skipSpace(acc, b);
    if (ch < 0) {
      return MatchStrength.INCONCLUSIVE;
    }
    if (ch == 123)
    {
      ch = skipSpace(acc);
      if (ch < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      if ((ch == 34) || (ch == 125)) {
        return MatchStrength.SOLID_MATCH;
      }
      return MatchStrength.NO_MATCH;
    }
    if (ch == 91)
    {
      ch = skipSpace(acc);
      if (ch < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      if ((ch == 93) || (ch == 91)) {
        return MatchStrength.SOLID_MATCH;
      }
      return MatchStrength.SOLID_MATCH;
    }
    MatchStrength strength = MatchStrength.WEAK_MATCH;
    if (ch == 34) {
      return strength;
    }
    if ((ch <= 57) && (ch >= 48)) {
      return strength;
    }
    if (ch == 45)
    {
      ch = skipSpace(acc);
      if (ch < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      return (ch <= 57) && (ch >= 48) ? strength : MatchStrength.NO_MATCH;
    }
    if (ch == 110) {
      return tryMatch(acc, "ull", strength);
    }
    if (ch == 116) {
      return tryMatch(acc, "rue", strength);
    }
    if (ch == 102) {
      return tryMatch(acc, "alse", strength);
    }
    return MatchStrength.NO_MATCH;
  }
  
  private static MatchStrength tryMatch(InputAccessor acc, String matchStr, MatchStrength fullMatchStrength)
    throws IOException
  {
    int i = 0;
    for (int len = matchStr.length(); i < len; i++)
    {
      if (!acc.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (acc.nextByte() != matchStr.charAt(i)) {
        return MatchStrength.NO_MATCH;
      }
    }
    return fullMatchStrength;
  }
  
  private static int skipSpace(InputAccessor acc)
    throws IOException
  {
    if (!acc.hasMoreBytes()) {
      return -1;
    }
    return skipSpace(acc, acc.nextByte());
  }
  
  private static int skipSpace(InputAccessor acc, byte b)
    throws IOException
  {
    for (;;)
    {
      int ch = b & 0xFF;
      if ((ch != 32) && (ch != 13) && (ch != 10) && (ch != 9)) {
        return ch;
      }
      if (!acc.hasMoreBytes()) {
        return -1;
      }
      b = acc.nextByte();
      ch = b & 0xFF;
    }
  }
  
  private boolean handleBOM(int quad)
    throws IOException
  {
    switch (quad)
    {
    case 65279: 
      _bigEndian = true;
      _inputPtr += 4;
      _bytesPerChar = 4;
      return true;
    case -131072: 
      _inputPtr += 4;
      _bytesPerChar = 4;
      _bigEndian = false;
      return true;
    case 65534: 
      reportWeirdUCS4("2143");
    case -16842752: 
      reportWeirdUCS4("3412");
    }
    int msw = quad >>> 16;
    if (msw == 65279)
    {
      _inputPtr += 2;
      _bytesPerChar = 2;
      _bigEndian = true;
      return true;
    }
    if (msw == 65534)
    {
      _inputPtr += 2;
      _bytesPerChar = 2;
      _bigEndian = false;
      return true;
    }
    if (quad >>> 8 == 15711167)
    {
      _inputPtr += 3;
      _bytesPerChar = 1;
      _bigEndian = true;
      return true;
    }
    return false;
  }
  
  private boolean checkUTF32(int quad)
    throws IOException
  {
    if (quad >> 8 == 0) {
      _bigEndian = true;
    } else if ((quad & 0xFFFFFF) == 0) {
      _bigEndian = false;
    } else if ((quad & 0xFF00FFFF) == 0) {
      reportWeirdUCS4("3412");
    } else if ((quad & 0xFFFF00FF) == 0) {
      reportWeirdUCS4("2143");
    } else {
      return false;
    }
    _bytesPerChar = 4;
    return true;
  }
  
  private boolean checkUTF16(int i16)
  {
    if ((i16 & 0xFF00) == 0) {
      _bigEndian = true;
    } else if ((i16 & 0xFF) == 0) {
      _bigEndian = false;
    } else {
      return false;
    }
    _bytesPerChar = 2;
    return true;
  }
  
  private void reportWeirdUCS4(String type)
    throws IOException
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + type + ") detected");
  }
  
  protected boolean ensureLoaded(int minimum)
    throws IOException
  {
    int gotten = _inputEnd - _inputPtr;
    while (gotten < minimum)
    {
      int count;
      int count;
      if (_in == null) {
        count = -1;
      } else {
        count = _in.read(_inputBuffer, _inputEnd, _inputBuffer.length - _inputEnd);
      }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */