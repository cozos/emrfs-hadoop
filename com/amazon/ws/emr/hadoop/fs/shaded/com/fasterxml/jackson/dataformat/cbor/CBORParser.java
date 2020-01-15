package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.DupDetector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class CBORParser
  extends ParserMinimalBase
{
  private static final byte[] NO_BYTES = new byte[0];
  
  public static enum Feature
    implements FormatFeature
  {
    final boolean _defaultState;
    final int _mask;
    
    public static int collectDefaults()
    {
      int flags = 0;
      for (Feature f : values()) {
        if (f.enabledByDefault()) {
          flags |= f.getMask();
        }
      }
      return flags;
    }
    
    private Feature(boolean defaultState)
    {
      _defaultState = defaultState;
      _mask = (1 << ordinal());
    }
    
    public boolean enabledByDefault()
    {
      return _defaultState;
    }
    
    public int getMask()
    {
      return _mask;
    }
    
    public boolean enabledIn(int flags)
    {
      return (flags & _mask) != 0;
    }
  }
  
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private static final int[] NO_INTS = new int[0];
  private static final int[] UTF8_UNIT_CODES = CBORConstants.sUtf8UnitLengths;
  private static final double MATH_POW_2_10 = Math.pow(2.0D, 10.0D);
  private static final double MATH_POW_2_NEG14 = Math.pow(2.0D, -14.0D);
  protected ObjectCodec _objectCodec;
  protected final IOContext _ioContext;
  protected boolean _closed;
  protected int _inputPtr = 0;
  protected int _inputEnd = 0;
  protected long _currInputProcessed = 0L;
  protected int _currInputRow = 1;
  protected int _currInputRowStart = 0;
  protected long _tokenInputTotal = 0L;
  protected int _tokenInputRow = 1;
  protected int _tokenInputCol = 0;
  protected CBORReadContext _parsingContext;
  protected final TextBuffer _textBuffer;
  protected char[] _nameCopyBuffer = null;
  protected boolean _nameCopied = false;
  protected ByteArrayBuilder _byteArrayBuilder = null;
  protected byte[] _binaryValue;
  protected int _tagValue = -1;
  protected InputStream _inputStream;
  protected byte[] _inputBuffer;
  protected boolean _bufferRecyclable;
  protected boolean _tokenIncomplete = false;
  protected int _typeByte;
  private int _chunkLeft;
  private int _chunkEnd;
  protected final ByteQuadsCanonicalizer _symbols;
  protected int[] _quadBuffer = NO_INTS;
  protected int _quad1;
  protected int _quad2;
  protected int _quad3;
  protected static final int NR_UNKNOWN = 0;
  protected static final int NR_INT = 1;
  protected static final int NR_LONG = 2;
  protected static final int NR_BIGINT = 4;
  protected static final int NR_FLOAT = 8;
  protected static final int NR_DOUBLE = 16;
  protected static final int NR_BIGDECIMAL = 32;
  static final BigInteger BI_MIN_INT = BigInteger.valueOf(-2147483648L);
  static final BigInteger BI_MAX_INT = BigInteger.valueOf(2147483647L);
  static final BigInteger BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
  static final BigInteger BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
  static final BigDecimal BD_MIN_LONG = new BigDecimal(BI_MIN_LONG);
  static final BigDecimal BD_MAX_LONG = new BigDecimal(BI_MAX_LONG);
  static final BigDecimal BD_MIN_INT = new BigDecimal(BI_MIN_INT);
  static final BigDecimal BD_MAX_INT = new BigDecimal(BI_MAX_INT);
  static final long MIN_INT_L = -2147483648L;
  static final long MAX_INT_L = 2147483647L;
  static final double MIN_LONG_D = -9.223372036854776E18D;
  static final double MAX_LONG_D = 9.223372036854776E18D;
  static final double MIN_INT_D = -2.147483648E9D;
  static final double MAX_INT_D = 2.147483647E9D;
  protected static final int INT_0 = 48;
  protected static final int INT_9 = 57;
  protected static final int INT_MINUS = 45;
  protected static final int INT_PLUS = 43;
  protected static final char CHAR_NULL = '\000';
  protected int _numTypesValid = 0;
  protected int _numberInt;
  protected long _numberLong;
  protected float _numberFloat;
  protected double _numberDouble;
  protected BigInteger _numberBigInt;
  protected BigDecimal _numberBigDecimal;
  
  public CBORParser(IOContext ctxt, int parserFeatures, int cborFeatures, ObjectCodec codec, ByteQuadsCanonicalizer sym, InputStream in, byte[] inputBuffer, int start, int end, boolean bufferRecyclable)
  {
    super(parserFeatures);
    _ioContext = ctxt;
    _objectCodec = codec;
    _symbols = sym;
    
    _inputStream = in;
    _inputBuffer = inputBuffer;
    _inputPtr = start;
    _inputEnd = end;
    _bufferRecyclable = bufferRecyclable;
    _textBuffer = ctxt.constructTextBuffer();
    DupDetector dups = JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(parserFeatures) ? DupDetector.rootDetector(this) : null;
    
    _parsingContext = CBORReadContext.createRootContext(dups);
    
    _tokenInputRow = -1;
    _tokenInputCol = -1;
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public void setCodec(ObjectCodec c)
  {
    _objectCodec = c;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public int getFormatFeatures()
  {
    return 0;
  }
  
  public int getCurrentTag()
  {
    return _tagValue;
  }
  
  public int releaseBuffered(OutputStream out)
    throws IOException
  {
    int count = _inputEnd - _inputPtr;
    if (count < 1) {
      return 0;
    }
    int origPtr = _inputPtr;
    out.write(_inputBuffer, origPtr, count);
    return count;
  }
  
  public Object getInputSource()
  {
    return _inputStream;
  }
  
  public JsonLocation getTokenLocation()
  {
    return new JsonLocation(_ioContext.getSourceReference(), _tokenInputTotal, -1L, -1, (int)_tokenInputTotal);
  }
  
  public JsonLocation getCurrentLocation()
  {
    long offset = _currInputProcessed + _inputPtr;
    return new JsonLocation(_ioContext.getSourceReference(), offset, -1L, -1, (int)offset);
  }
  
  public String getCurrentName()
    throws IOException
  {
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY))
    {
      CBORReadContext parent = _parsingContext.getParent();
      return parent.getCurrentName();
    }
    return _parsingContext.getCurrentName();
  }
  
  public void overrideCurrentName(String name)
  {
    CBORReadContext ctxt = _parsingContext;
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
      ctxt = ctxt.getParent();
    }
    try
    {
      ctxt.setCurrentName(name);
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public void close()
    throws IOException
  {
    if (!_closed)
    {
      _closed = true;
      _symbols.release();
      try
      {
        _closeInput();
      }
      finally
      {
        _releaseBuffers();
      }
    }
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public CBORReadContext getParsingContext()
  {
    return _parsingContext;
  }
  
  public boolean hasTextCharacters()
  {
    if (_currToken == JsonToken.VALUE_STRING) {
      return _textBuffer.hasTextAsCharacters();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return _nameCopied;
    }
    return false;
  }
  
  protected void _releaseBuffers()
    throws IOException
  {
    if (_bufferRecyclable)
    {
      byte[] buf = _inputBuffer;
      if (buf != null)
      {
        _inputBuffer = null;
        _ioContext.releaseReadIOBuffer(buf);
      }
    }
    _textBuffer.releaseBuffers();
    char[] buf = _nameCopyBuffer;
    if (buf != null)
    {
      _nameCopyBuffer = null;
      _ioContext.releaseNameCopyBuffer(buf);
    }
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    _numTypesValid = 0;
    if (_tokenIncomplete) {
      _skipIncomplete();
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr);
    
    _binaryValue = null;
    if (_parsingContext.inObject())
    {
      if (_currToken != JsonToken.FIELD_NAME)
      {
        _tagValue = -1;
        if (!_parsingContext.expectMoreValues())
        {
          _parsingContext = _parsingContext.getParent();
          return _currToken = JsonToken.END_OBJECT;
        }
        return _currToken = _decodeFieldName();
      }
    }
    else if (!_parsingContext.expectMoreValues())
    {
      _tagValue = -1;
      _parsingContext = _parsingContext.getParent();
      return _currToken = JsonToken.END_ARRAY;
    }
    if ((_inputPtr >= _inputEnd) && 
      (!loadMore())) {
      return _handleCBOREOF();
    }
    int ch = _inputBuffer[(_inputPtr++)];
    int type = ch >> 5 & 0x7;
    if (type == 6)
    {
      _tagValue = Integer.valueOf(_decodeTag(ch & 0x1F)).intValue();
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        return _handleCBOREOF();
      }
      ch = _inputBuffer[(_inputPtr++)];
      type = ch >> 5 & 0x7;
    }
    else
    {
      _tagValue = -1;
    }
    int lowBits = ch & 0x1F;
    switch (type)
    {
    case 0: 
      _numTypesValid = 1;
      if (lowBits <= 23) {
        _numberInt = lowBits;
      } else {
        switch (lowBits - 24)
        {
        case 0: 
          _numberInt = _decode8Bits();
          break;
        case 1: 
          _numberInt = _decode16Bits();
          break;
        case 2: 
          _numberInt = _decode32Bits();
          break;
        case 3: 
          _numberLong = _decode64Bits();
          _numTypesValid = 2;
          break;
        default: 
          _invalidToken(ch);
        }
      }
      return _currToken = JsonToken.VALUE_NUMBER_INT;
    case 1: 
      _numTypesValid = 1;
      if (lowBits <= 23) {
        _numberInt = (-lowBits - 1);
      } else {
        switch (lowBits - 24)
        {
        case 0: 
          _numberInt = (-_decode8Bits() - 1);
          break;
        case 1: 
          _numberInt = (-_decode16Bits() - 1);
          break;
        case 2: 
          _numberInt = (-_decode32Bits() - 1);
          break;
        case 3: 
          _numberLong = (-_decode64Bits() - 1L);
          _numTypesValid = 2;
          break;
        default: 
          _invalidToken(ch);
        }
      }
      return _currToken = JsonToken.VALUE_NUMBER_INT;
    case 2: 
      _typeByte = ch;
      _tokenIncomplete = true;
      return _currToken = JsonToken.VALUE_EMBEDDED_OBJECT;
    case 3: 
      _typeByte = ch;
      _tokenIncomplete = true;
      return _currToken = JsonToken.VALUE_STRING;
    case 4: 
      _currToken = JsonToken.START_ARRAY;
      
      int len = _decodeExplicitLength(lowBits);
      _parsingContext = _parsingContext.createChildArrayContext(len);
      
      return _currToken;
    case 5: 
      _currToken = JsonToken.START_OBJECT;
      
      int len = _decodeExplicitLength(lowBits);
      _parsingContext = _parsingContext.createChildObjectContext(len);
      
      return _currToken;
    case 6: 
      _reportError("Multiple tags not allowed per value (first tag: " + _tagValue + ")");
    }
    switch (lowBits)
    {
    case 20: 
      return _currToken = JsonToken.VALUE_FALSE;
    case 21: 
      return _currToken = JsonToken.VALUE_TRUE;
    case 22: 
      return _currToken = JsonToken.VALUE_NULL;
    case 25: 
      _numberFloat = _decodeHalfSizeFloat();
      _numTypesValid = 8;
      
      return _currToken = JsonToken.VALUE_NUMBER_FLOAT;
    case 26: 
      _numberFloat = Float.intBitsToFloat(_decode32Bits());
      _numTypesValid = 8;
      
      return _currToken = JsonToken.VALUE_NUMBER_FLOAT;
    case 27: 
      _numberDouble = Double.longBitsToDouble(_decode64Bits());
      _numTypesValid = 16;
      return _currToken = JsonToken.VALUE_NUMBER_FLOAT;
    case 31: 
      if ((_parsingContext.inArray()) && 
        (!_parsingContext.hasExpectedLength()))
      {
        _parsingContext = _parsingContext.getParent();
        return _currToken = JsonToken.END_ARRAY;
      }
      _reportUnexpectedBreak();
    }
    _invalidToken(ch);
    
    return null;
  }
  
  protected JsonToken _handleCBOREOF()
    throws IOException
  {
    _tagValue = -1;
    close();
    return _currToken = null;
  }
  
  protected String _numberToName(int ch, boolean neg)
    throws IOException
  {
    int lowBits = ch & 0x1F;
    int i;
    int i;
    if (lowBits <= 23) {
      i = lowBits;
    } else {
      switch (lowBits)
      {
      case 24: 
        i = _decode8Bits();
        break;
      case 25: 
        i = _decode16Bits();
        break;
      case 26: 
        i = _decode32Bits();
        break;
      case 27: 
        long l = _decode64Bits();
        if (neg) {
          l = -l - 1L;
        }
        return String.valueOf(l);
      default: 
        throw _constructError("Invalid length indicator for ints (" + lowBits + "), token 0x" + Integer.toHexString(ch));
      }
    }
    if (neg) {
      i = -i - 1;
    }
    return String.valueOf(1);
  }
  
  protected void _invalidToken(int ch)
    throws JsonParseException
  {
    ch &= 0xFF;
    if (ch == 255) {
      throw _constructError("Mismatched BREAK byte (0xFF): encountered where value expected");
    }
    throw _constructError("Invalid CBOR value token (first byte): 0x" + Integer.toHexString(ch));
  }
  
  public boolean nextFieldName(SerializableString str)
    throws IOException
  {
    if ((_parsingContext.inObject()) && (_currToken != JsonToken.FIELD_NAME))
    {
      _numTypesValid = 0;
      if (_tokenIncomplete) {
        _skipIncomplete();
      }
      _tokenInputTotal = (_currInputProcessed + _inputPtr);
      _binaryValue = null;
      _tagValue = -1;
      if (!_parsingContext.expectMoreValues())
      {
        _parsingContext = _parsingContext.getParent();
        _currToken = JsonToken.END_OBJECT;
        return false;
      }
      byte[] nameBytes = str.asQuotedUTF8();
      int byteLen = nameBytes.length;
      
      int ptr = _inputPtr;
      if (ptr + byteLen + 1 < _inputEnd)
      {
        int ch = _inputBuffer[(ptr++)];
        if ((ch >> 5 & 0x7) == 3)
        {
          int lenMarker = ch & 0x1F;
          if (lenMarker <= 24)
          {
            if (lenMarker == 23) {
              lenMarker = _inputBuffer[(ptr++)] & 0xFF;
            }
            if (lenMarker == byteLen)
            {
              int i = 0;
              for (;;)
              {
                if (i == lenMarker)
                {
                  _inputPtr = (ptr + i);
                  _parsingContext.setCurrentName(str.getValue());
                  _currToken = JsonToken.FIELD_NAME;
                  return true;
                }
                if (nameBytes[i] != _inputBuffer[(ptr + i)]) {
                  break;
                }
                i++;
              }
            }
          }
        }
      }
    }
    return (nextToken() == JsonToken.FIELD_NAME) && (str.getValue().equals(getCurrentName()));
  }
  
  public String nextFieldName()
    throws IOException
  {
    if ((_parsingContext.inObject()) && (_currToken != JsonToken.FIELD_NAME))
    {
      _numTypesValid = 0;
      if (_tokenIncomplete) {
        _skipIncomplete();
      }
      _tokenInputTotal = (_currInputProcessed + _inputPtr);
      _binaryValue = null;
      _tagValue = -1;
      if (!_parsingContext.expectMoreValues())
      {
        _parsingContext = _parsingContext.getParent();
        _currToken = JsonToken.END_OBJECT;
        return null;
      }
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      int ch = _inputBuffer[(_inputPtr++)];
      int type = ch >> 5 & 0x7;
      if (type != 3)
      {
        if (ch == -1)
        {
          if (!_parsingContext.hasExpectedLength())
          {
            _parsingContext = _parsingContext.getParent();
            _currToken = JsonToken.END_OBJECT;
            return null;
          }
          _reportUnexpectedBreak();
        }
        _decodeNonStringName(ch);
        _currToken = JsonToken.FIELD_NAME;
        return getText();
      }
      int lenMarker = ch & 0x1F;
      String name;
      if (lenMarker <= 23)
      {
        String name;
        if (lenMarker == 0)
        {
          name = "";
        }
        else
        {
          String name = _findDecodedFromSymbols(lenMarker);
          if (name != null)
          {
            _inputPtr += lenMarker;
          }
          else
          {
            name = _decodeShortName(lenMarker);
            name = _addDecodedToSymbols(lenMarker, name);
          }
        }
      }
      else
      {
        int actualLen = _decodeExplicitLength(lenMarker);
        String name;
        if (actualLen < 0) {
          name = _decodeChunkedName();
        } else {
          name = _decodeLongerName(actualLen);
        }
      }
      _parsingContext.setCurrentName(name);
      _currToken = JsonToken.FIELD_NAME;
      return name;
    }
    return nextToken() == JsonToken.FIELD_NAME ? getCurrentName() : null;
  }
  
  public String nextTextValue()
    throws IOException
  {
    _numTypesValid = 0;
    if (_tokenIncomplete) {
      _skipIncomplete();
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr);
    _binaryValue = null;
    _tagValue = -1;
    if (_parsingContext.inObject())
    {
      if (_currToken != JsonToken.FIELD_NAME)
      {
        _tagValue = -1;
        if (!_parsingContext.expectMoreValues())
        {
          _parsingContext = _parsingContext.getParent();
          _currToken = JsonToken.END_OBJECT;
          return null;
        }
        _currToken = _decodeFieldName();
        return null;
      }
    }
    else if (!_parsingContext.expectMoreValues())
    {
      _tagValue = -1;
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_ARRAY;
      return null;
    }
    if ((_inputPtr >= _inputEnd) && 
      (!loadMore()))
    {
      _handleCBOREOF();
      return null;
    }
    int ch = _inputBuffer[(_inputPtr++)];
    int type = ch >> 5 & 0x7;
    if (type == 6)
    {
      _tagValue = Integer.valueOf(_decodeTag(ch & 0x1F)).intValue();
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore()))
      {
        _handleCBOREOF();
        return null;
      }
      ch = _inputBuffer[(_inputPtr++)];
      type = ch >> 5 & 0x7;
    }
    else
    {
      _tagValue = -1;
    }
    int lowBits = ch & 0x1F;
    switch (type)
    {
    case 0: 
      _numTypesValid = 1;
      if (lowBits <= 23) {
        _numberInt = lowBits;
      } else {
        switch (lowBits - 24)
        {
        case 0: 
          _numberInt = _decode8Bits();
          break;
        case 1: 
          _numberInt = _decode16Bits();
          break;
        case 2: 
          _numberInt = _decode32Bits();
          break;
        case 3: 
          _numberLong = _decode64Bits();
          _numTypesValid = 2;
          break;
        default: 
          _invalidToken(ch);
        }
      }
      _currToken = JsonToken.VALUE_NUMBER_INT;
      return null;
    case 1: 
      _numTypesValid = 1;
      if (lowBits <= 23) {
        _numberInt = (-lowBits - 1);
      } else {
        switch (lowBits - 24)
        {
        case 0: 
          _numberInt = (-_decode8Bits() - 1);
          break;
        case 1: 
          _numberInt = (-_decode16Bits() - 1);
          break;
        case 2: 
          _numberInt = (-_decode32Bits() - 1);
          break;
        case 3: 
          _numberLong = (-_decode64Bits() - 1L);
          _numTypesValid = 2;
          break;
        default: 
          _invalidToken(ch);
        }
      }
      _currToken = JsonToken.VALUE_NUMBER_INT;
      return null;
    case 2: 
      _typeByte = ch;
      _tokenIncomplete = true;
      _currToken = JsonToken.VALUE_EMBEDDED_OBJECT;
      return null;
    case 3: 
      _typeByte = ch;
      _tokenIncomplete = true;
      _currToken = JsonToken.VALUE_STRING;
      return _finishTextToken(ch);
    case 4: 
      _currToken = JsonToken.START_ARRAY;
      
      int len = _decodeExplicitLength(lowBits);
      _parsingContext = _parsingContext.createChildArrayContext(len);
      
      return null;
    case 5: 
      _currToken = JsonToken.START_OBJECT;
      
      int len = _decodeExplicitLength(lowBits);
      _parsingContext = _parsingContext.createChildObjectContext(len);
      
      return null;
    case 6: 
      _reportError("Multiple tags not allowed per value (first tag: " + _tagValue + ")");
    }
    switch (lowBits)
    {
    case 20: 
      _currToken = JsonToken.VALUE_FALSE;
      return null;
    case 21: 
      _currToken = JsonToken.VALUE_TRUE;
      return null;
    case 22: 
      _currToken = JsonToken.VALUE_NULL;
      return null;
    case 25: 
      _numberFloat = _decodeHalfSizeFloat();
      _numTypesValid = 8;
      
      _currToken = JsonToken.VALUE_NUMBER_FLOAT;
      return null;
    case 26: 
      _numberFloat = Float.intBitsToFloat(_decode32Bits());
      _numTypesValid = 8;
      
      _currToken = JsonToken.VALUE_NUMBER_FLOAT;
      return null;
    case 27: 
      _numberDouble = Double.longBitsToDouble(_decode64Bits());
      _numTypesValid = 16;
      _currToken = JsonToken.VALUE_NUMBER_FLOAT;
      return null;
    case 31: 
      if ((_parsingContext.inArray()) && 
        (!_parsingContext.hasExpectedLength()))
      {
        _parsingContext = _parsingContext.getParent();
        _currToken = JsonToken.END_ARRAY;
        return null;
      }
      _reportUnexpectedBreak();
    }
    _invalidToken(ch);
    
    return nextToken() == JsonToken.VALUE_STRING ? getText() : null;
  }
  
  public int nextIntValue(int defaultValue)
    throws IOException
  {
    if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
      return getIntValue();
    }
    return defaultValue;
  }
  
  public long nextLongValue(long defaultValue)
    throws IOException
  {
    if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
      return getLongValue();
    }
    return defaultValue;
  }
  
  public Boolean nextBooleanValue()
    throws IOException
  {
    switch (nextToken())
    {
    case VALUE_TRUE: 
      return Boolean.TRUE;
    case VALUE_FALSE: 
      return Boolean.FALSE;
    }
    return null;
  }
  
  public String getText()
    throws IOException
  {
    JsonToken t = _currToken;
    if ((_tokenIncomplete) && 
      (t == JsonToken.VALUE_STRING)) {
      return _finishTextToken(_typeByte);
    }
    if (t == JsonToken.VALUE_STRING) {
      return _textBuffer.contentsAsString();
    }
    if (t == null) {
      return null;
    }
    if (t == JsonToken.FIELD_NAME) {
      return _parsingContext.getCurrentName();
    }
    if (t.isNumeric()) {
      return getNumberValue().toString();
    }
    return _currToken.asString();
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    if (_currToken != null)
    {
      if (_tokenIncomplete) {
        _finishToken();
      }
      switch (_currToken)
      {
      case VALUE_STRING: 
        return _textBuffer.getTextBuffer();
      case FIELD_NAME: 
        return _parsingContext.getCurrentName().toCharArray();
      case VALUE_NUMBER_INT: 
      case VALUE_NUMBER_FLOAT: 
        return getNumberValue().toString().toCharArray();
      }
      return _currToken.asCharArray();
    }
    return null;
  }
  
  public int getTextLength()
    throws IOException
  {
    if (_currToken != null)
    {
      if (_tokenIncomplete) {
        _finishToken();
      }
      switch (_currToken)
      {
      case VALUE_STRING: 
        return _textBuffer.size();
      case FIELD_NAME: 
        return _parsingContext.getCurrentName().length();
      case VALUE_NUMBER_INT: 
      case VALUE_NUMBER_FLOAT: 
        return getNumberValue().toString().length();
      }
      return _currToken.asCharArray().length;
    }
    return 0;
  }
  
  public int getTextOffset()
    throws IOException
  {
    return 0;
  }
  
  public String getValueAsString()
    throws IOException
  {
    if ((_tokenIncomplete) && 
      (_currToken == JsonToken.VALUE_STRING)) {
      return _finishTextToken(_typeByte);
    }
    if (_currToken == JsonToken.VALUE_STRING) {
      return _textBuffer.contentsAsString();
    }
    if ((_currToken == null) || (_currToken == JsonToken.VALUE_NULL) || (!_currToken.isScalarValue())) {
      return null;
    }
    return getText();
  }
  
  public String getValueAsString(String defaultValue)
    throws IOException
  {
    if ((_currToken != JsonToken.VALUE_STRING) && (
      (_currToken == null) || (_currToken == JsonToken.VALUE_NULL) || (!_currToken.isScalarValue()))) {
      return defaultValue;
    }
    return getText();
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException
  {
    if (_tokenIncomplete) {
      _finishToken();
    }
    if (_currToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
      _reportError("Current token (" + getCurrentToken() + ") not VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    return _binaryValue;
  }
  
  public Object getEmbeddedObject()
    throws IOException
  {
    if (_tokenIncomplete) {
      _finishToken();
    }
    if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
      return _binaryValue;
    }
    return null;
  }
  
  public int readBinaryValue(Base64Variant b64variant, OutputStream out)
    throws IOException
  {
    if (_currToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
      _reportError("Current token (" + getCurrentToken() + ") not VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    if (!_tokenIncomplete)
    {
      if (_binaryValue == null) {
        return 0;
      }
      int len = _binaryValue.length;
      out.write(_binaryValue, 0, len);
      return len;
    }
    _tokenIncomplete = false;
    int len = _decodeExplicitLength(_typeByte & 0x1F);
    if (len >= 0) {
      return _readAndWriteBytes(out, len);
    }
    int total = 0;
    for (;;)
    {
      len = _decodeChunkLength(2);
      if (len < 0) {
        return total;
      }
      total += _readAndWriteBytes(out, len);
    }
  }
  
  private int _readAndWriteBytes(OutputStream out, int total)
    throws IOException
  {
    int left = total;
    while (left > 0)
    {
      int avail = _inputEnd - _inputPtr;
      if (_inputPtr >= _inputEnd)
      {
        loadMoreGuaranteed();
        avail = _inputEnd - _inputPtr;
      }
      int count = Math.min(avail, left);
      out.write(_inputBuffer, _inputPtr, count);
      _inputPtr += count;
      left -= count;
    }
    _tokenIncomplete = false;
    return total;
  }
  
  public Number getNumberValue()
    throws IOException
  {
    if (_numTypesValid == 0) {
      _checkNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((_numTypesValid & 0x1) != 0) {
        return Integer.valueOf(_numberInt);
      }
      if ((_numTypesValid & 0x2) != 0) {
        return Long.valueOf(_numberLong);
      }
      if ((_numTypesValid & 0x4) != 0) {
        return _numberBigInt;
      }
      return _numberBigDecimal;
    }
    if ((_numTypesValid & 0x20) != 0) {
      return _numberBigDecimal;
    }
    if ((_numTypesValid & 0x10) != 0) {
      return Double.valueOf(_numberDouble);
    }
    if ((_numTypesValid & 0x8) == 0) {
      _throwInternal();
    }
    return Float.valueOf(_numberFloat);
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    if (_numTypesValid == 0) {
      _checkNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((_numTypesValid & 0x1) != 0) {
        return JsonParser.NumberType.INT;
      }
      if ((_numTypesValid & 0x2) != 0) {
        return JsonParser.NumberType.LONG;
      }
      return JsonParser.NumberType.BIG_INTEGER;
    }
    if ((_numTypesValid & 0x20) != 0) {
      return JsonParser.NumberType.BIG_DECIMAL;
    }
    if ((_numTypesValid & 0x10) != 0) {
      return JsonParser.NumberType.DOUBLE;
    }
    return JsonParser.NumberType.FLOAT;
  }
  
  public int getIntValue()
    throws IOException
  {
    if ((_numTypesValid & 0x1) == 0)
    {
      if (_numTypesValid == 0) {
        _checkNumericValue(1);
      }
      if ((_numTypesValid & 0x1) == 0) {
        convertNumberToInt();
      }
    }
    return _numberInt;
  }
  
  public long getLongValue()
    throws IOException
  {
    if ((_numTypesValid & 0x2) == 0)
    {
      if (_numTypesValid == 0) {
        _checkNumericValue(2);
      }
      if ((_numTypesValid & 0x2) == 0) {
        convertNumberToLong();
      }
    }
    return _numberLong;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    if ((_numTypesValid & 0x4) == 0)
    {
      if (_numTypesValid == 0) {
        _checkNumericValue(4);
      }
      if ((_numTypesValid & 0x4) == 0) {
        convertNumberToBigInteger();
      }
    }
    return _numberBigInt;
  }
  
  public float getFloatValue()
    throws IOException
  {
    if ((_numTypesValid & 0x8) == 0)
    {
      if (_numTypesValid == 0) {
        _checkNumericValue(8);
      }
      if ((_numTypesValid & 0x8) == 0) {
        convertNumberToFloat();
      }
    }
    return _numberFloat;
  }
  
  public double getDoubleValue()
    throws IOException
  {
    if ((_numTypesValid & 0x10) == 0)
    {
      if (_numTypesValid == 0) {
        _checkNumericValue(16);
      }
      if ((_numTypesValid & 0x10) == 0) {
        convertNumberToDouble();
      }
    }
    return _numberDouble;
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    if ((_numTypesValid & 0x20) == 0)
    {
      if (_numTypesValid == 0) {
        _checkNumericValue(32);
      }
      if ((_numTypesValid & 0x20) == 0) {
        convertNumberToBigDecimal();
      }
    }
    return _numberBigDecimal;
  }
  
  protected void _checkNumericValue(int expType)
    throws IOException
  {
    if ((_currToken == JsonToken.VALUE_NUMBER_INT) || (_currToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return;
    }
    _reportError("Current token (" + getCurrentToken() + ") not numeric, can not use numeric value accessors");
  }
  
  protected void convertNumberToInt()
    throws IOException
  {
    if ((_numTypesValid & 0x2) != 0)
    {
      int result = (int)_numberLong;
      if (result != _numberLong) {
        _reportError("Numeric value (" + getText() + ") out of range of int");
      }
      _numberInt = result;
    }
    else if ((_numTypesValid & 0x4) != 0)
    {
      if ((BI_MIN_INT.compareTo(_numberBigInt) > 0) || (BI_MAX_INT.compareTo(_numberBigInt) < 0)) {
        reportOverflowInt();
      }
      _numberInt = _numberBigInt.intValue();
    }
    else if ((_numTypesValid & 0x10) != 0)
    {
      if ((_numberDouble < -2.147483648E9D) || (_numberDouble > 2.147483647E9D)) {
        reportOverflowInt();
      }
      _numberInt = ((int)_numberDouble);
    }
    else if ((_numTypesValid & 0x8) != 0)
    {
      if ((_numberFloat < -2.147483648E9D) || (_numberFloat > 2.147483647E9D)) {
        reportOverflowInt();
      }
      _numberInt = ((int)_numberFloat);
    }
    else if ((_numTypesValid & 0x20) != 0)
    {
      if ((BD_MIN_INT.compareTo(_numberBigDecimal) > 0) || (BD_MAX_INT.compareTo(_numberBigDecimal) < 0)) {
        reportOverflowInt();
      }
      _numberInt = _numberBigDecimal.intValue();
    }
    else
    {
      _throwInternal();
    }
    _numTypesValid |= 0x1;
  }
  
  protected void convertNumberToLong()
    throws IOException
  {
    if ((_numTypesValid & 0x1) != 0)
    {
      _numberLong = _numberInt;
    }
    else if ((_numTypesValid & 0x4) != 0)
    {
      if ((BI_MIN_LONG.compareTo(_numberBigInt) > 0) || (BI_MAX_LONG.compareTo(_numberBigInt) < 0)) {
        reportOverflowLong();
      }
      _numberLong = _numberBigInt.longValue();
    }
    else if ((_numTypesValid & 0x10) != 0)
    {
      if ((_numberDouble < -9.223372036854776E18D) || (_numberDouble > 9.223372036854776E18D)) {
        reportOverflowLong();
      }
      _numberLong = (_numberDouble);
    }
    else if ((_numTypesValid & 0x8) != 0)
    {
      if ((_numberFloat < -9.223372036854776E18D) || (_numberFloat > 9.223372036854776E18D)) {
        reportOverflowInt();
      }
      _numberLong = (_numberFloat);
    }
    else if ((_numTypesValid & 0x20) != 0)
    {
      if ((BD_MIN_LONG.compareTo(_numberBigDecimal) > 0) || (BD_MAX_LONG.compareTo(_numberBigDecimal) < 0)) {
        reportOverflowLong();
      }
      _numberLong = _numberBigDecimal.longValue();
    }
    else
    {
      _throwInternal();
    }
    _numTypesValid |= 0x2;
  }
  
  protected void convertNumberToBigInteger()
    throws IOException
  {
    if ((_numTypesValid & 0x20) != 0) {
      _numberBigInt = _numberBigDecimal.toBigInteger();
    } else if ((_numTypesValid & 0x2) != 0) {
      _numberBigInt = BigInteger.valueOf(_numberLong);
    } else if ((_numTypesValid & 0x1) != 0) {
      _numberBigInt = BigInteger.valueOf(_numberInt);
    } else if ((_numTypesValid & 0x10) != 0) {
      _numberBigInt = BigDecimal.valueOf(_numberDouble).toBigInteger();
    } else if ((_numTypesValid & 0x8) != 0) {
      _numberBigInt = BigDecimal.valueOf(_numberFloat).toBigInteger();
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x4;
  }
  
  protected void convertNumberToFloat()
    throws IOException
  {
    if ((_numTypesValid & 0x20) != 0) {
      _numberFloat = _numberBigDecimal.floatValue();
    } else if ((_numTypesValid & 0x4) != 0) {
      _numberFloat = _numberBigInt.floatValue();
    } else if ((_numTypesValid & 0x10) != 0) {
      _numberFloat = ((float)_numberDouble);
    } else if ((_numTypesValid & 0x2) != 0) {
      _numberFloat = ((float)_numberLong);
    } else if ((_numTypesValid & 0x1) != 0) {
      _numberFloat = _numberInt;
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x8;
  }
  
  protected void convertNumberToDouble()
    throws IOException
  {
    if ((_numTypesValid & 0x20) != 0) {
      _numberDouble = _numberBigDecimal.doubleValue();
    } else if ((_numTypesValid & 0x8) != 0) {
      _numberDouble = _numberFloat;
    } else if ((_numTypesValid & 0x4) != 0) {
      _numberDouble = _numberBigInt.doubleValue();
    } else if ((_numTypesValid & 0x2) != 0) {
      _numberDouble = _numberLong;
    } else if ((_numTypesValid & 0x1) != 0) {
      _numberDouble = _numberInt;
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x10;
  }
  
  protected void convertNumberToBigDecimal()
    throws IOException
  {
    if ((_numTypesValid & 0x18) != 0) {
      _numberBigDecimal = NumberInput.parseBigDecimal(getText());
    } else if ((_numTypesValid & 0x4) != 0) {
      _numberBigDecimal = new BigDecimal(_numberBigInt);
    } else if ((_numTypesValid & 0x2) != 0) {
      _numberBigDecimal = BigDecimal.valueOf(_numberLong);
    } else if ((_numTypesValid & 0x1) != 0) {
      _numberBigDecimal = BigDecimal.valueOf(_numberInt);
    } else {
      _throwInternal();
    }
    _numTypesValid |= 0x20;
  }
  
  protected void reportOverflowInt()
    throws IOException
  {
    _reportError("Numeric value (" + getText() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
  }
  
  protected void reportOverflowLong()
    throws IOException
  {
    _reportError("Numeric value (" + getText() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
  }
  
  protected void _finishToken()
    throws IOException
  {
    _tokenIncomplete = false;
    int ch = _typeByte;
    int type = ch >> 5 & 0x7;
    ch &= 0x1F;
    if (type != 3)
    {
      if (type == 2)
      {
        _binaryValue = _finishBytes(_decodeExplicitLength(ch));
        return;
      }
      _throwInternal();
    }
    int len = _decodeExplicitLength(ch);
    if (len <= 0)
    {
      if (len < 0) {
        _finishChunkedText();
      } else {
        _textBuffer.resetWithEmpty();
      }
      return;
    }
    if (len > _inputEnd - _inputPtr)
    {
      if (len >= _inputBuffer.length)
      {
        _finishLongText(len);
        return;
      }
      _loadToHaveAtLeast(len);
    }
    _finishShortText(len);
  }
  
  protected String _finishTextToken(int ch)
    throws IOException
  {
    _tokenIncomplete = false;
    int type = ch >> 5 & 0x7;
    ch &= 0x1F;
    if (type != 3) {
      _throwInternal();
    }
    int len = _decodeExplicitLength(ch);
    if (len <= 0)
    {
      if (len == 0)
      {
        _textBuffer.resetWithEmpty();
        return "";
      }
      _finishChunkedText();
      return _textBuffer.contentsAsString();
    }
    if (len > _inputEnd - _inputPtr)
    {
      if (len >= _inputBuffer.length)
      {
        _finishLongText(len);
        return _textBuffer.contentsAsString();
      }
      _loadToHaveAtLeast(len);
    }
    return _finishShortText(len);
  }
  
  private final String _finishShortText(int len)
    throws IOException
  {
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    if (outBuf.length < len) {
      outBuf = _textBuffer.expandCurrentSegment(len);
    }
    int outPtr = 0;
    int inPtr = _inputPtr;
    _inputPtr += len;
    byte[] inputBuf = _inputBuffer;
    
    int end = inPtr + len;
    int i;
    while ((i = inputBuf[inPtr]) >= 0)
    {
      outBuf[(outPtr++)] = ((char)i);
      inPtr++;
      if (inPtr == end) {
        return _textBuffer.setCurrentAndReturn(outPtr);
      }
    }
    int[] codes = UTF8_UNIT_CODES;
    do
    {
      i = inputBuf[(inPtr++)] & 0xFF;
      switch (codes[i])
      {
      case 0: 
        break;
      case 1: 
        i = (i & 0x1F) << 6 | inputBuf[(inPtr++)] & 0x3F;
        break;
      case 2: 
        i = (i & 0xF) << 12 | (inputBuf[(inPtr++)] & 0x3F) << 6 | inputBuf[(inPtr++)] & 0x3F;
        
        break;
      case 3: 
        i = (i & 0x7) << 18 | (inputBuf[(inPtr++)] & 0x3F) << 12 | (inputBuf[(inPtr++)] & 0x3F) << 6 | inputBuf[(inPtr++)] & 0x3F;
        
        i -= 65536;
        outBuf[(outPtr++)] = ((char)(0xD800 | i >> 10));
        i = 0xDC00 | i & 0x3FF;
        break;
      default: 
        _reportError("Invalid byte " + Integer.toHexString(i) + " in Unicode text block");
      }
      outBuf[(outPtr++)] = ((char)i);
    } while (inPtr < end);
    return _textBuffer.setCurrentAndReturn(outPtr);
  }
  
  private final void _finishLongText(int len)
    throws IOException
  {
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    int outPtr = 0;
    int[] codes = UTF8_UNIT_CODES;
    int outEnd = outBuf.length;
    for (;;)
    {
      len--;
      if (len < 0) {
        break;
      }
      int c = _nextByte() & 0xFF;
      int code = codes[c];
      if ((code == 0) && (outPtr < outEnd))
      {
        outBuf[(outPtr++)] = ((char)c);
      }
      else
      {
        if (len -= code < 0) {
          throw _constructError("Malformed UTF-8 character at end of long (non-chunked) text segment");
        }
        switch (code)
        {
        case 0: 
          break;
        case 1: 
          int d = _nextByte();
          if ((d & 0xC0) != 128) {
            _reportInvalidOther(d & 0xFF, _inputPtr);
          }
          c = (c & 0x1F) << 6 | d & 0x3F;
          
          break;
        case 2: 
          c = _decodeUTF8_3(c);
          break;
        case 3: 
          c = _decodeUTF8_4(c);
          
          outBuf[(outPtr++)] = ((char)(0xD800 | c >> 10));
          if (outPtr >= outBuf.length)
          {
            outBuf = _textBuffer.finishCurrentSegment();
            outPtr = 0;
            outEnd = outBuf.length;
          }
          c = 0xDC00 | c & 0x3FF;
          
          break;
        default: 
          _reportInvalidChar(c);
        }
        if (outPtr >= outEnd)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
          outEnd = outBuf.length;
        }
        outBuf[(outPtr++)] = ((char)c);
      }
    }
    _textBuffer.setCurrentLength(outPtr);
  }
  
  private final void _finishChunkedText()
    throws IOException
  {
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    int outPtr = 0;
    int[] codes = UTF8_UNIT_CODES;
    int outEnd = outBuf.length;
    byte[] input = _inputBuffer;
    
    _chunkEnd = _inputPtr;
    _chunkLeft = 0;
    for (;;)
    {
      if (_inputPtr >= _chunkEnd)
      {
        if (_chunkLeft == 0)
        {
          int len = _decodeChunkLength(3);
          if (len < 0) {
            break;
          }
          _chunkLeft = len;
          int end = _inputPtr + len;
          if (end <= _inputEnd)
          {
            _chunkLeft = 0;
            _chunkEnd = end;
          }
          else
          {
            _chunkLeft = (end - _inputEnd);
            _chunkEnd = _inputEnd;
          }
        }
        if (_inputPtr >= _inputEnd)
        {
          loadMoreGuaranteed();
          int end = _inputPtr + _chunkLeft;
          if (end <= _inputEnd)
          {
            _chunkLeft = 0;
            _chunkEnd = end;
          }
          else
          {
            _chunkLeft = (end - _inputEnd);
            _chunkEnd = _inputEnd;
          }
        }
      }
      int c = input[(_inputPtr++)] & 0xFF;
      int code = codes[c];
      if ((code == 0) && (outPtr < outEnd))
      {
        outBuf[(outPtr++)] = ((char)c);
      }
      else
      {
        switch (code)
        {
        case 0: 
          break;
        case 1: 
          int d = _nextChunkedByte();
          if ((d & 0xC0) != 128) {
            _reportInvalidOther(d & 0xFF, _inputPtr);
          }
          c = (c & 0x1F) << 6 | d & 0x3F;
          
          break;
        case 2: 
          c = _decodeChunkedUTF8_3(c);
          break;
        case 3: 
          c = _decodeChunkedUTF8_4(c);
          
          outBuf[(outPtr++)] = ((char)(0xD800 | c >> 10));
          if (outPtr >= outBuf.length)
          {
            outBuf = _textBuffer.finishCurrentSegment();
            outPtr = 0;
            outEnd = outBuf.length;
          }
          c = 0xDC00 | c & 0x3FF;
          
          break;
        default: 
          _reportInvalidChar(c);
        }
        if (outPtr >= outEnd)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
          outEnd = outBuf.length;
        }
        outBuf[(outPtr++)] = ((char)c);
      }
    }
    _textBuffer.setCurrentLength(outPtr);
  }
  
  private final int _nextByte()
    throws IOException
  {
    int inPtr = _inputPtr;
    if (inPtr < _inputEnd)
    {
      int ch = _inputBuffer[inPtr];
      _inputPtr = (inPtr + 1);
      return ch;
    }
    loadMoreGuaranteed();
    return _inputBuffer[(_inputPtr++)];
  }
  
  private final int _nextChunkedByte()
    throws IOException
  {
    int inPtr = _inputPtr;
    if (inPtr >= _chunkEnd) {
      return _nextChunkedByte2();
    }
    int ch = _inputBuffer[inPtr];
    _inputPtr = (inPtr + 1);
    return ch;
  }
  
  private final int _nextChunkedByte2()
    throws IOException
  {
    if (_inputPtr >= _inputEnd)
    {
      loadMoreGuaranteed();
      if (_chunkLeft > 0)
      {
        int end = _inputPtr + _chunkLeft;
        if (end <= _inputEnd)
        {
          _chunkLeft = 0;
          _chunkEnd = end;
        }
        else
        {
          _chunkLeft = (end - _inputEnd);
          _chunkEnd = _inputEnd;
        }
        return _inputBuffer[(_inputPtr++)];
      }
    }
    int len = _decodeChunkLength(3);
    if (len < 0) {
      _reportInvalidEOF(": chunked Text ends with partial UTF-8 character");
    }
    int end = _inputPtr + len;
    if (end <= _inputEnd)
    {
      _chunkLeft = 0;
      _chunkEnd = end;
    }
    else
    {
      _chunkLeft = (end - _inputEnd);
      _chunkEnd = _inputEnd;
    }
    return _inputBuffer[(_inputPtr++)];
  }
  
  protected byte[] _finishBytes(int len)
    throws IOException
  {
    if (len >= 0)
    {
      if (len == 0) {
        return NO_BYTES;
      }
      byte[] b = new byte[len];
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      int ptr = 0;
      for (;;)
      {
        int toAdd = Math.min(len, _inputEnd - _inputPtr);
        System.arraycopy(_inputBuffer, _inputPtr, b, ptr, toAdd);
        _inputPtr += toAdd;
        ptr += toAdd;
        len -= toAdd;
        if (len <= 0) {
          return b;
        }
        loadMoreGuaranteed();
      }
    }
    ByteArrayBuilder bb = _getByteArrayBuilder();
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      int ch = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (ch == 255) {
        break;
      }
      int type = ch >> 5;
      if (type != 2) {
        throw _constructError("Mismatched chunk in chunked content: expected 2 but encountered " + type);
      }
      len = _decodeExplicitLength(ch & 0x1F);
      if (len < 0) {
        throw _constructError("Illegal chunked-length indicator within chunked-length value (type 2)");
      }
      while (len > 0)
      {
        int avail = _inputEnd - _inputPtr;
        if (_inputPtr >= _inputEnd)
        {
          loadMoreGuaranteed();
          avail = _inputEnd - _inputPtr;
        }
        int count = Math.min(avail, len);
        bb.write(_inputBuffer, _inputPtr, count);
        _inputPtr += count;
        len -= count;
      }
    }
    return bb.toByteArray();
  }
  
  protected final JsonToken _decodeFieldName()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int ch = _inputBuffer[(_inputPtr++)];
    int type = ch >> 5 & 0x7;
    if (type != 3)
    {
      if (ch == -1)
      {
        if (!_parsingContext.hasExpectedLength())
        {
          _parsingContext = _parsingContext.getParent();
          return JsonToken.END_OBJECT;
        }
        _reportUnexpectedBreak();
      }
      _decodeNonStringName(ch);
      return JsonToken.FIELD_NAME;
    }
    int lenMarker = ch & 0x1F;
    String name;
    if (lenMarker <= 23)
    {
      String name;
      if (lenMarker == 0)
      {
        name = "";
      }
      else
      {
        String name = _findDecodedFromSymbols(lenMarker);
        if (name != null)
        {
          _inputPtr += lenMarker;
        }
        else
        {
          name = _decodeShortName(lenMarker);
          name = _addDecodedToSymbols(lenMarker, name);
        }
      }
    }
    else
    {
      int actualLen = _decodeExplicitLength(lenMarker);
      String name;
      if (actualLen < 0) {
        name = _decodeChunkedName();
      } else {
        name = _decodeLongerName(actualLen);
      }
    }
    _parsingContext.setCurrentName(name);
    return JsonToken.FIELD_NAME;
  }
  
  private final String _decodeShortName(int len)
    throws IOException
  {
    int outPtr = 0;
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    if (outBuf.length < len) {
      outBuf = _textBuffer.expandCurrentSegment(len);
    }
    int inPtr = _inputPtr;
    _inputPtr += len;
    int[] codes = UTF8_UNIT_CODES;
    byte[] inBuf = _inputBuffer;
    
    int end = inPtr + len;
    for (;;)
    {
      int i = inBuf[inPtr] & 0xFF;
      int code = codes[i];
      if (code != 0) {
        break;
      }
      outBuf[(outPtr++)] = ((char)i);
      inPtr++;
      if (inPtr == end) {
        return _textBuffer.setCurrentAndReturn(outPtr);
      }
    }
    while (inPtr < end)
    {
      int i = inBuf[(inPtr++)] & 0xFF;
      int code = codes[i];
      if (code != 0) {
        switch (code)
        {
        case 1: 
          i = (i & 0x1F) << 6 | inBuf[(inPtr++)] & 0x3F;
          break;
        case 2: 
          i = (i & 0xF) << 12 | (inBuf[(inPtr++)] & 0x3F) << 6 | inBuf[(inPtr++)] & 0x3F;
          
          break;
        case 3: 
          i = (i & 0x7) << 18 | (inBuf[(inPtr++)] & 0x3F) << 12 | (inBuf[(inPtr++)] & 0x3F) << 6 | inBuf[(inPtr++)] & 0x3F;
          
          i -= 65536;
          outBuf[(outPtr++)] = ((char)(0xD800 | i >> 10));
          i = 0xDC00 | i & 0x3FF;
          break;
        default: 
          _reportError("Invalid byte " + Integer.toHexString(i) + " in Object name");
        }
      }
      outBuf[(outPtr++)] = ((char)i);
    }
    return _textBuffer.setCurrentAndReturn(outPtr);
  }
  
  private final String _decodeLongerName(int len)
    throws IOException
  {
    if (_inputEnd - _inputPtr < len)
    {
      if (len >= _inputBuffer.length)
      {
        _finishLongText(len);
        return _textBuffer.contentsAsString();
      }
      _loadToHaveAtLeast(len);
    }
    String name = _findDecodedFromSymbols(len);
    if (name != null)
    {
      _inputPtr += len;
      return name;
    }
    name = _decodeShortName(len);
    return _addDecodedToSymbols(len, name);
  }
  
  private final String _decodeChunkedName()
    throws IOException
  {
    _finishChunkedText();
    return _textBuffer.contentsAsString();
  }
  
  protected final void _decodeNonStringName(int ch)
    throws IOException
  {
    int type = ch >> 5 & 0x7;
    String name;
    if (type == 0)
    {
      name = _numberToName(ch, false);
    }
    else
    {
      String name;
      if (type == 1)
      {
        name = _numberToName(ch, true);
      }
      else
      {
        String name;
        if (type == 2)
        {
          int blen = _decodeExplicitLength(ch & 0x1F);
          byte[] b = _finishBytes(blen);
          
          name = new String(b, UTF8);
        }
        else
        {
          if ((ch & 0xFF) == 255) {
            _reportUnexpectedBreak();
          }
          throw _constructError("Unsupported major type (" + type + ") for CBOR Objects, not (yet?) supported, only Strings");
        }
      }
    }
    String name;
    _parsingContext.setCurrentName(name);
  }
  
  private final String _findDecodedFromSymbols(int len)
    throws IOException
  {
    if (_inputEnd - _inputPtr < len) {
      _loadToHaveAtLeast(len);
    }
    if (len < 5)
    {
      int inPtr = _inputPtr;
      byte[] inBuf = _inputBuffer;
      int q = inBuf[inPtr] & 0xFF;
      if (len > 1)
      {
        q = (q << 8) + (inBuf[(++inPtr)] & 0xFF);
        if (len > 2)
        {
          q = (q << 8) + (inBuf[(++inPtr)] & 0xFF);
          if (len > 3) {
            q = (q << 8) + (inBuf[(++inPtr)] & 0xFF);
          }
        }
      }
      _quad1 = q;
      return _symbols.findName(q);
    }
    byte[] inBuf = _inputBuffer;
    int inPtr = _inputPtr;
    
    int q1 = inBuf[(inPtr++)] & 0xFF;
    q1 = q1 << 8 | inBuf[(inPtr++)] & 0xFF;
    q1 = q1 << 8 | inBuf[(inPtr++)] & 0xFF;
    q1 = q1 << 8 | inBuf[(inPtr++)] & 0xFF;
    if (len < 9)
    {
      int q2 = inBuf[(inPtr++)] & 0xFF;
      int left = len - 5;
      if (left > 0)
      {
        q2 = (q2 << 8) + (inBuf[(inPtr++)] & 0xFF);
        if (left > 1)
        {
          q2 = (q2 << 8) + (inBuf[(inPtr++)] & 0xFF);
          if (left > 2) {
            q2 = (q2 << 8) + (inBuf[(inPtr++)] & 0xFF);
          }
        }
      }
      _quad1 = q1;
      _quad2 = q2;
      return _symbols.findName(q1, q2);
    }
    int q2 = inBuf[(inPtr++)] & 0xFF;
    q2 = q2 << 8 | inBuf[(inPtr++)] & 0xFF;
    q2 = q2 << 8 | inBuf[(inPtr++)] & 0xFF;
    q2 = q2 << 8 | inBuf[(inPtr++)] & 0xFF;
    if (len < 13)
    {
      int q3 = inBuf[(inPtr++)] & 0xFF;
      int left = len - 9;
      if (left > 0)
      {
        q3 = (q3 << 8) + (inBuf[(inPtr++)] & 0xFF);
        if (left > 1)
        {
          q3 = (q3 << 8) + (inBuf[(inPtr++)] & 0xFF);
          if (left > 2) {
            q3 = (q3 << 8) + (inBuf[(inPtr++)] & 0xFF);
          }
        }
      }
      _quad1 = q1;
      _quad2 = q2;
      _quad3 = q3;
      return _symbols.findName(q1, q2, q3);
    }
    return _findDecodedLong(len, q1, q2);
  }
  
  private final String _findDecodedLong(int len, int q1, int q2)
    throws IOException
  {
    int bufLen = len + 3 >> 2;
    if (bufLen > _quadBuffer.length) {
      _quadBuffer = _growArrayTo(_quadBuffer, bufLen);
    }
    _quadBuffer[0] = q1;
    _quadBuffer[1] = q2;
    
    int offset = 2;
    int inPtr = _inputPtr + 8;
    len -= 8;
    
    byte[] inBuf = _inputBuffer;
    do
    {
      int q = inBuf[(inPtr++)] & 0xFF;
      q = q << 8 | inBuf[(inPtr++)] & 0xFF;
      q = q << 8 | inBuf[(inPtr++)] & 0xFF;
      q = q << 8 | inBuf[(inPtr++)] & 0xFF;
      _quadBuffer[(offset++)] = q;
      len -= 4;
    } while (len > 3);
    if (len > 0)
    {
      int q = inBuf[inPtr] & 0xFF;
      if (len > 1)
      {
        q = (q << 8) + (inBuf[(++inPtr)] & 0xFF);
        if (len > 2) {
          q = (q << 8) + (inBuf[(++inPtr)] & 0xFF);
        }
      }
      _quadBuffer[(offset++)] = q;
    }
    return _symbols.findName(_quadBuffer, offset);
  }
  
  private final String _addDecodedToSymbols(int len, String name)
  {
    if (len < 5) {
      return _symbols.addName(name, _quad1);
    }
    if (len < 9) {
      return _symbols.addName(name, _quad1, _quad2);
    }
    if (len < 13) {
      return _symbols.addName(name, _quad1, _quad2, _quad3);
    }
    int qlen = len + 3 >> 2;
    return _symbols.addName(name, _quadBuffer, qlen);
  }
  
  private static int[] _growArrayTo(int[] arr, int minSize)
  {
    return Arrays.copyOf(arr, minSize + 4);
  }
  
  protected void _skipIncomplete()
    throws IOException
  {
    _tokenIncomplete = false;
    int type = _typeByte >> 5 & 0x7;
    if ((type != 3) && (type == 3)) {
      _throwInternal();
    }
    int lowBits = _typeByte & 0x1F;
    if (lowBits <= 23)
    {
      if (lowBits > 0) {
        _skipBytes(lowBits);
      }
      return;
    }
    switch (lowBits)
    {
    case 24: 
      _skipBytes(_decode8Bits());
      break;
    case 25: 
      _skipBytes(_decode16Bits());
      break;
    case 26: 
      _skipBytes(_decode32Bits());
      break;
    case 27: 
      _skipBytesL(_decode64Bits());
      break;
    case 31: 
      _skipChunked(type);
      break;
    case 28: 
    case 29: 
    case 30: 
    default: 
      _invalidToken(_typeByte);
    }
  }
  
  protected void _skipChunked(int expectedType)
    throws IOException
  {
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      int ch = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (ch == 255) {
        return;
      }
      int type = ch >> 5;
      if (type != expectedType) {
        throw _constructError("Mismatched chunk in chunked content: expected " + expectedType + " but encountered " + type);
      }
      int lowBits = ch & 0x1F;
      if (lowBits <= 23)
      {
        if (lowBits > 0) {
          _skipBytes(lowBits);
        }
      }
      else {
        switch (lowBits)
        {
        case 24: 
          _skipBytes(_decode8Bits());
          break;
        case 25: 
          _skipBytes(_decode16Bits());
          break;
        case 26: 
          _skipBytes(_decode32Bits());
          break;
        case 27: 
          _skipBytesL(_decode64Bits());
          break;
        case 31: 
          throw _constructError("Illegal chunked-length indicator within chunked-length value (type " + expectedType + ")");
        case 28: 
        case 29: 
        case 30: 
        default: 
          _invalidToken(_typeByte);
        }
      }
    }
  }
  
  protected void _skipBytesL(long llen)
    throws IOException
  {
    while (llen > 2147483647L)
    {
      _skipBytes(Integer.MAX_VALUE);
      llen -= 2147483647L;
    }
    _skipBytes((int)llen);
  }
  
  protected void _skipBytes(int len)
    throws IOException
  {
    for (;;)
    {
      int toAdd = Math.min(len, _inputEnd - _inputPtr);
      _inputPtr += toAdd;
      len -= toAdd;
      if (len <= 0) {
        return;
      }
      loadMoreGuaranteed();
    }
  }
  
  private final int _decodeTag(int lowBits)
    throws IOException
  {
    if (lowBits <= 23) {
      return lowBits;
    }
    switch (lowBits - 24)
    {
    case 0: 
      return _decode8Bits();
    case 1: 
      return _decode16Bits();
    case 2: 
      return _decode32Bits();
    case 3: 
      long l = _decode64Bits();
      if ((l < -2147483648L) || (l > 2147483647L)) {
        _reportError("Illegal Tag value: " + l);
      }
      return (int)l;
    }
    throw _constructError("Invalid low bits for Tag token: 0x" + Integer.toHexString(lowBits));
  }
  
  private final int _decodeExplicitLength(int lowBits)
    throws IOException
  {
    if (lowBits == 31) {
      return -1;
    }
    if (lowBits <= 23) {
      return lowBits;
    }
    switch (lowBits - 24)
    {
    case 0: 
      return _decode8Bits();
    case 1: 
      return _decode16Bits();
    case 2: 
      return _decode32Bits();
    case 3: 
      long l = _decode64Bits();
      if ((l < 0L) || (l > 2147483647L)) {
        throw _constructError("Illegal length for " + getCurrentToken() + ": " + l);
      }
      return (int)l;
    }
    throw _constructError("Invalid length for " + getCurrentToken() + ": 0x" + Integer.toHexString(lowBits));
  }
  
  private int _decodeChunkLength(int expType)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int ch = _inputBuffer[(_inputPtr++)] & 0xFF;
    if (ch == 255) {
      return -1;
    }
    int type = ch >> 5;
    if (type != expType) {
      throw _constructError("Mismatched chunk in chunked content: expected " + expType + " but encountered " + type + " (byte 0x" + Integer.toHexString(ch) + ")");
    }
    int len = _decodeExplicitLength(ch & 0x1F);
    if (len < 0) {
      throw _constructError("Illegal chunked-length indicator within chunked-length value (type " + expType + ")");
    }
    return len;
  }
  
  private float _decodeHalfSizeFloat()
    throws IOException
  {
    int i16 = _decode16Bits() & 0xFFFF;
    
    boolean neg = i16 >> 15 != 0;
    int e = i16 >> 10 & 0x1F;
    int f = i16 & 0x3FF;
    if (e == 0)
    {
      float result = (float)(MATH_POW_2_NEG14 * (f / MATH_POW_2_10));
      return neg ? -result : result;
    }
    if (e == 31)
    {
      if (f != 0) {
        return NaN.0F;
      }
      return neg ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
    }
    float result = (float)(Math.pow(2.0D, e - 15) * (1.0D + f / MATH_POW_2_10));
    return neg ? -result : result;
  }
  
  private final int _decode8Bits()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    return _inputBuffer[(_inputPtr++)] & 0xFF;
  }
  
  private final int _decode16Bits()
    throws IOException
  {
    int ptr = _inputPtr;
    if (ptr + 1 >= _inputEnd) {
      return _slow16();
    }
    byte[] b = _inputBuffer;
    int v = ((b[ptr] & 0xFF) << 8) + (b[(ptr + 1)] & 0xFF);
    _inputPtr = (ptr + 2);
    return v;
  }
  
  private final int _slow16()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int v = _inputBuffer[(_inputPtr++)] & 0xFF;
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    return (v << 8) + (_inputBuffer[(_inputPtr++)] & 0xFF);
  }
  
  private final int _decode32Bits()
    throws IOException
  {
    int ptr = _inputPtr;
    if (ptr + 3 >= _inputEnd) {
      return _slow32();
    }
    byte[] b = _inputBuffer;
    int v = (b[(ptr++)] << 24) + ((b[(ptr++)] & 0xFF) << 16) + ((b[(ptr++)] & 0xFF) << 8) + (b[(ptr++)] & 0xFF);
    
    _inputPtr = ptr;
    return v;
  }
  
  private final int _slow32()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int v = _inputBuffer[(_inputPtr++)];
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    v = (v << 8) + (_inputBuffer[(_inputPtr++)] & 0xFF);
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    v = (v << 8) + (_inputBuffer[(_inputPtr++)] & 0xFF);
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    return (v << 8) + (_inputBuffer[(_inputPtr++)] & 0xFF);
  }
  
  private final long _decode64Bits()
    throws IOException
  {
    int ptr = _inputPtr;
    if (ptr + 7 >= _inputEnd) {
      return _slow64();
    }
    byte[] b = _inputBuffer;
    int i1 = (b[(ptr++)] << 24) + ((b[(ptr++)] & 0xFF) << 16) + ((b[(ptr++)] & 0xFF) << 8) + (b[(ptr++)] & 0xFF);
    
    int i2 = (b[(ptr++)] << 24) + ((b[(ptr++)] & 0xFF) << 16) + ((b[(ptr++)] & 0xFF) << 8) + (b[(ptr++)] & 0xFF);
    
    _inputPtr = ptr;
    return _long(i1, i2);
  }
  
  private final long _slow64()
    throws IOException
  {
    return _long(_decode32Bits(), _decode32Bits());
  }
  
  private static final long _long(int i1, int i2)
  {
    long l1 = i1;
    long l2 = i2;
    l2 = l2 << 32 >>> 32;
    return (l1 << 32) + l2;
  }
  
  private final int _decodeUTF8_3(int c1)
    throws IOException
  {
    c1 &= 0xF;
    int d = _nextByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    int c = c1 << 6 | d & 0x3F;
    d = _nextByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    return c;
  }
  
  private final int _decodeChunkedUTF8_3(int c1)
    throws IOException
  {
    c1 &= 0xF;
    int d = _nextChunkedByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    int c = c1 << 6 | d & 0x3F;
    d = _nextChunkedByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    return c;
  }
  
  private final int _decodeUTF8_4(int c)
    throws IOException
  {
    int d = _nextByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = (c & 0x7) << 6 | d & 0x3F;
    d = _nextByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    d = _nextByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    return (c << 6 | d & 0x3F) - 65536;
  }
  
  private final int _decodeChunkedUTF8_4(int c)
    throws IOException
  {
    int d = _nextChunkedByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = (c & 0x7) << 6 | d & 0x3F;
    d = _nextChunkedByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    d = _nextChunkedByte();
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    return (c << 6 | d & 0x3F) - 65536;
  }
  
  protected final boolean loadMore()
    throws IOException
  {
    _currInputProcessed += _inputEnd;
    if (_inputStream != null)
    {
      int count = _inputStream.read(_inputBuffer, 0, _inputBuffer.length);
      if (count > 0)
      {
        _inputPtr = 0;
        _inputEnd = count;
        return true;
      }
      _closeInput();
      if (count == 0) {
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + _inputBuffer.length + " bytes");
      }
    }
    return false;
  }
  
  protected final void loadMoreGuaranteed()
    throws IOException
  {
    if (!loadMore()) {
      _reportInvalidEOF();
    }
  }
  
  protected final void _loadToHaveAtLeast(int minAvailable)
    throws IOException
  {
    if (_inputStream == null) {
      throw _constructError("Needed to read " + minAvailable + " bytes, reached end-of-input");
    }
    int amount = _inputEnd - _inputPtr;
    if ((amount > 0) && (_inputPtr > 0))
    {
      _currInputProcessed += _inputPtr;
      
      System.arraycopy(_inputBuffer, _inputPtr, _inputBuffer, 0, amount);
      _inputEnd = amount;
    }
    else
    {
      _inputEnd = 0;
    }
    _inputPtr = 0;
    while (_inputEnd < minAvailable)
    {
      int count = _inputStream.read(_inputBuffer, _inputEnd, _inputBuffer.length - _inputEnd);
      if (count < 1)
      {
        _closeInput();
        if (count == 0) {
          throw new IOException("InputStream.read() returned 0 characters when trying to read " + amount + " bytes");
        }
        throw _constructError("Needed to read " + minAvailable + " bytes, missed " + minAvailable + " before end-of-input");
      }
      _inputEnd += count;
    }
  }
  
  protected ByteArrayBuilder _getByteArrayBuilder()
  {
    if (_byteArrayBuilder == null) {
      _byteArrayBuilder = new ByteArrayBuilder();
    } else {
      _byteArrayBuilder.reset();
    }
    return _byteArrayBuilder;
  }
  
  protected void _closeInput()
    throws IOException
  {
    if (_inputStream != null)
    {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        _inputStream.close();
      }
      _inputStream = null;
    }
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    if (!_parsingContext.inRoot()) {
      _reportInvalidEOF(": expected close marker for " + _parsingContext.getTypeDesc() + " (from " + _parsingContext.getStartLocation(_ioContext.getSourceReference()) + ")");
    }
  }
  
  protected void _reportUnexpectedBreak()
    throws IOException
  {
    if (_parsingContext.inRoot()) {
      throw _constructError("Unexpected Break (0xFF) token in Root context");
    }
    throw _constructError("Unexpected Break (0xFF) token in definite length (" + _parsingContext.getExpectedLength() + ") " + (_parsingContext.inObject() ? "Object" : "Array"));
  }
  
  protected void _reportInvalidChar(int c)
    throws JsonParseException
  {
    if (c < 32) {
      _throwInvalidSpace(c);
    }
    _reportInvalidInitial(c);
  }
  
  protected void _reportInvalidInitial(int mask)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(mask));
  }
  
  protected void _reportInvalidOther(int mask)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(mask));
  }
  
  protected void _reportInvalidOther(int mask, int ptr)
    throws JsonParseException
  {
    _inputPtr = ptr;
    _reportInvalidOther(mask);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */