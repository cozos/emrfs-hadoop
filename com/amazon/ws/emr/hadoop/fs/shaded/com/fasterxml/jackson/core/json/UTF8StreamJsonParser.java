package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.ParserBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class UTF8StreamJsonParser
  extends ParserBase
{
  static final byte BYTE_LF = 10;
  private static final int[] _icUTF8 = ;
  protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
  protected ObjectCodec _objectCodec;
  protected final ByteQuadsCanonicalizer _symbols;
  protected int[] _quadBuffer = new int[16];
  protected boolean _tokenIncomplete = false;
  private int _quad1;
  protected InputStream _inputStream;
  protected byte[] _inputBuffer;
  protected boolean _bufferRecyclable;
  
  public UTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, ByteQuadsCanonicalizer sym, byte[] inputBuffer, int start, int end, boolean bufferRecyclable)
  {
    super(ctxt, features);
    _inputStream = in;
    _objectCodec = codec;
    _symbols = sym;
    _inputBuffer = inputBuffer;
    _inputPtr = start;
    _inputEnd = end;
    _currInputRowStart = start;
    
    _currInputProcessed = (-start);
    _bufferRecyclable = bufferRecyclable;
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public void setCodec(ObjectCodec c)
  {
    _objectCodec = c;
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
  
  protected final boolean loadMore()
    throws IOException
  {
    _currInputProcessed += _inputEnd;
    _currInputRowStart -= _inputEnd;
    if (_inputStream != null)
    {
      int space = _inputBuffer.length;
      if (space == 0) {
        return false;
      }
      int count = _inputStream.read(_inputBuffer, 0, space);
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
  
  protected final boolean _loadToHaveAtLeast(int minAvailable)
    throws IOException
  {
    if (_inputStream == null) {
      return false;
    }
    int amount = _inputEnd - _inputPtr;
    if ((amount > 0) && (_inputPtr > 0))
    {
      _currInputProcessed += _inputPtr;
      _currInputRowStart -= _inputPtr;
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
        return false;
      }
      _inputEnd += count;
    }
    return true;
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
  
  protected void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    
    _symbols.release();
    if (_bufferRecyclable)
    {
      byte[] buf = _inputBuffer;
      if (buf != null)
      {
        _inputBuffer = ByteArrayBuilder.NO_BYTES;
        _ioContext.releaseReadIOBuffer(buf);
      }
    }
  }
  
  public String getText()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        return _finishAndReturnString();
      }
      return _textBuffer.contentsAsString();
    }
    return _getText2(_currToken);
  }
  
  public String getValueAsString()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        return _finishAndReturnString();
      }
      return _textBuffer.contentsAsString();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return getCurrentName();
    }
    return super.getValueAsString(null);
  }
  
  public String getValueAsString(String defValue)
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        return _finishAndReturnString();
      }
      return _textBuffer.contentsAsString();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return getCurrentName();
    }
    return super.getValueAsString(defValue);
  }
  
  public int getValueAsInt()
    throws IOException
  {
    JsonToken t = _currToken;
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT))
    {
      if ((_numTypesValid & 0x1) == 0)
      {
        if (_numTypesValid == 0) {
          return _parseIntValue();
        }
        if ((_numTypesValid & 0x1) == 0) {
          convertNumberToInt();
        }
      }
      return _numberInt;
    }
    return super.getValueAsInt(0);
  }
  
  public int getValueAsInt(int defValue)
    throws IOException
  {
    JsonToken t = _currToken;
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT))
    {
      if ((_numTypesValid & 0x1) == 0)
      {
        if (_numTypesValid == 0) {
          return _parseIntValue();
        }
        if ((_numTypesValid & 0x1) == 0) {
          convertNumberToInt();
        }
      }
      return _numberInt;
    }
    return super.getValueAsInt(defValue);
  }
  
  protected final String _getText2(JsonToken t)
  {
    if (t == null) {
      return null;
    }
    switch (t.id())
    {
    case 5: 
      return _parsingContext.getCurrentName();
    case 6: 
    case 7: 
    case 8: 
      return _textBuffer.contentsAsString();
    }
    return t.asString();
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    if (_currToken != null)
    {
      switch (_currToken.id())
      {
      case 5: 
        if (!_nameCopied)
        {
          String name = _parsingContext.getCurrentName();
          int nameLen = name.length();
          if (_nameCopyBuffer == null) {
            _nameCopyBuffer = _ioContext.allocNameCopyBuffer(nameLen);
          } else if (_nameCopyBuffer.length < nameLen) {
            _nameCopyBuffer = new char[nameLen];
          }
          name.getChars(0, nameLen, _nameCopyBuffer, 0);
          _nameCopied = true;
        }
        return _nameCopyBuffer;
      case 6: 
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
      case 7: 
      case 8: 
        return _textBuffer.getTextBuffer();
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
      switch (_currToken.id())
      {
      case 5: 
        return _parsingContext.getCurrentName().length();
      case 6: 
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
      case 7: 
      case 8: 
        return _textBuffer.size();
      }
      return _currToken.asCharArray().length;
    }
    return 0;
  }
  
  public int getTextOffset()
    throws IOException
  {
    if (_currToken != null) {
      switch (_currToken.id())
      {
      case 5: 
        return 0;
      case 6: 
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
      case 7: 
      case 8: 
        return _textBuffer.getTextOffset();
      }
    }
    return 0;
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException
  {
    if ((_currToken != JsonToken.VALUE_STRING) && ((_currToken != JsonToken.VALUE_EMBEDDED_OBJECT) || (_binaryValue == null))) {
      _reportError("Current token (" + _currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    if (_tokenIncomplete)
    {
      try
      {
        _binaryValue = _decodeBase64(b64variant);
      }
      catch (IllegalArgumentException iae)
      {
        throw _constructError("Failed to decode VALUE_STRING as base64 (" + b64variant + "): " + iae.getMessage());
      }
      _tokenIncomplete = false;
    }
    else if (_binaryValue == null)
    {
      ByteArrayBuilder builder = _getByteArrayBuilder();
      _decodeBase64(getText(), builder, b64variant);
      _binaryValue = builder.toByteArray();
    }
    return _binaryValue;
  }
  
  public int readBinaryValue(Base64Variant b64variant, OutputStream out)
    throws IOException
  {
    if ((!_tokenIncomplete) || (_currToken != JsonToken.VALUE_STRING))
    {
      byte[] b = getBinaryValue(b64variant);
      out.write(b);
      return b.length;
    }
    byte[] buf = _ioContext.allocBase64Buffer();
    try
    {
      return _readBinary(b64variant, out, buf);
    }
    finally
    {
      _ioContext.releaseBase64Buffer(buf);
    }
  }
  
  protected int _readBinary(Base64Variant b64variant, OutputStream out, byte[] buffer)
    throws IOException
  {
    int outputPtr = 0;
    int outputEnd = buffer.length - 3;
    int outputCount = 0;
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      int ch = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (ch > 32)
      {
        int bits = b64variant.decodeBase64Char(ch);
        if (bits < 0)
        {
          if (ch == 34) {
            break;
          }
          bits = _decodeBase64Escape(b64variant, ch, 0);
          if (bits < 0) {}
        }
        else
        {
          if (outputPtr > outputEnd)
          {
            outputCount += outputPtr;
            out.write(buffer, 0, outputPtr);
            outputPtr = 0;
          }
          int decodedData = bits;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          ch = _inputBuffer[(_inputPtr++)] & 0xFF;
          bits = b64variant.decodeBase64Char(ch);
          if (bits < 0) {
            bits = _decodeBase64Escape(b64variant, ch, 1);
          }
          decodedData = decodedData << 6 | bits;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          ch = _inputBuffer[(_inputPtr++)] & 0xFF;
          bits = b64variant.decodeBase64Char(ch);
          if (bits < 0)
          {
            if (bits != -2)
            {
              if ((ch == 34) && (!b64variant.usesPadding()))
              {
                decodedData >>= 4;
                buffer[(outputPtr++)] = ((byte)decodedData);
                break;
              }
              bits = _decodeBase64Escape(b64variant, ch, 2);
            }
            if (bits == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              ch = _inputBuffer[(_inputPtr++)] & 0xFF;
              if (!b64variant.usesPaddingChar(ch)) {
                throw reportInvalidBase64Char(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
              }
              decodedData >>= 4;
              buffer[(outputPtr++)] = ((byte)decodedData);
              continue;
            }
          }
          decodedData = decodedData << 6 | bits;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          ch = _inputBuffer[(_inputPtr++)] & 0xFF;
          bits = b64variant.decodeBase64Char(ch);
          if (bits < 0)
          {
            if (bits != -2)
            {
              if ((ch == 34) && (!b64variant.usesPadding()))
              {
                decodedData >>= 2;
                buffer[(outputPtr++)] = ((byte)(decodedData >> 8));
                buffer[(outputPtr++)] = ((byte)decodedData);
                break;
              }
              bits = _decodeBase64Escape(b64variant, ch, 3);
            }
            if (bits == -2)
            {
              decodedData >>= 2;
              buffer[(outputPtr++)] = ((byte)(decodedData >> 8));
              buffer[(outputPtr++)] = ((byte)decodedData);
              continue;
            }
          }
          decodedData = decodedData << 6 | bits;
          buffer[(outputPtr++)] = ((byte)(decodedData >> 16));
          buffer[(outputPtr++)] = ((byte)(decodedData >> 8));
          buffer[(outputPtr++)] = ((byte)decodedData);
        }
      }
    }
    _tokenIncomplete = false;
    if (outputPtr > 0)
    {
      outputCount += outputPtr;
      out.write(buffer, 0, outputPtr);
    }
    return outputCount;
  }
  
  public JsonLocation getTokenLocation()
  {
    return new JsonLocation(_ioContext.getSourceReference(), getTokenCharacterOffset(), -1L, getTokenLineNr(), getTokenColumnNr());
  }
  
  public JsonLocation getCurrentLocation()
  {
    int col = _inputPtr - _currInputRowStart + 1;
    return new JsonLocation(_ioContext.getSourceReference(), _currInputProcessed + _inputPtr, -1L, _currInputRow, col);
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME) {
      return _nextAfterName();
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int i = _skipWSOrEnd();
    if (i < 0)
    {
      close();
      return _currToken = null;
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
    
    _binaryValue = null;
    if (i == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(i, '}');
      }
      _parsingContext = _parsingContext.getParent();
      return _currToken = JsonToken.END_ARRAY;
    }
    if (i == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(i, ']');
      }
      _parsingContext = _parsingContext.getParent();
      return _currToken = JsonToken.END_OBJECT;
    }
    if (_parsingContext.expectComma())
    {
      if (i != 44) {
        _reportUnexpectedChar(i, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject()) {
      return _nextTokenNotInObject(i);
    }
    String n = _parseName(i);
    _parsingContext.setCurrentName(n);
    _currToken = JsonToken.FIELD_NAME;
    
    i = _skipColon();
    if (i == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return _currToken;
    }
    JsonToken t;
    switch (i)
    {
    case 45: 
      t = _parseNegNumber();
      break;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      t = _parsePosNumber(i);
      break;
    case 102: 
      _matchToken("false", 1);
      t = JsonToken.VALUE_FALSE;
      break;
    case 110: 
      _matchToken("null", 1);
      t = JsonToken.VALUE_NULL;
      break;
    case 116: 
      _matchToken("true", 1);
      t = JsonToken.VALUE_TRUE;
      break;
    case 91: 
      t = JsonToken.START_ARRAY;
      break;
    case 123: 
      t = JsonToken.START_OBJECT;
      break;
    default: 
      t = _handleUnexpectedValue(i);
    }
    _nextToken = t;
    return _currToken;
  }
  
  private final JsonToken _nextTokenNotInObject(int i)
    throws IOException
  {
    if (i == 34)
    {
      _tokenIncomplete = true;
      return _currToken = JsonToken.VALUE_STRING;
    }
    switch (i)
    {
    case 91: 
      _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      return _currToken = JsonToken.START_ARRAY;
    case 123: 
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      return _currToken = JsonToken.START_OBJECT;
    case 116: 
      _matchToken("true", 1);
      return _currToken = JsonToken.VALUE_TRUE;
    case 102: 
      _matchToken("false", 1);
      return _currToken = JsonToken.VALUE_FALSE;
    case 110: 
      _matchToken("null", 1);
      return _currToken = JsonToken.VALUE_NULL;
    case 45: 
      return _currToken = _parseNegNumber();
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      return _currToken = _parsePosNumber(i);
    }
    return _currToken = _handleUnexpectedValue(i);
  }
  
  private final JsonToken _nextAfterName()
  {
    _nameCopied = false;
    JsonToken t = _nextToken;
    _nextToken = null;
    if (t == JsonToken.START_ARRAY) {
      _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
    } else if (t == JsonToken.START_OBJECT) {
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
    }
    return _currToken = t;
  }
  
  public boolean nextFieldName(SerializableString str)
    throws IOException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nextAfterName();
      return false;
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int i = _skipWSOrEnd();
    if (i < 0)
    {
      close();
      _currToken = null;
      return false;
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
    
    _binaryValue = null;
    if (i == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(i, '}');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_ARRAY;
      return false;
    }
    if (i == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(i, ']');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_OBJECT;
      return false;
    }
    if (_parsingContext.expectComma())
    {
      if (i != 44) {
        _reportUnexpectedChar(i, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject())
    {
      _nextTokenNotInObject(i);
      return false;
    }
    if (i == 34)
    {
      byte[] nameBytes = str.asQuotedUTF8();
      int len = nameBytes.length;
      if (_inputPtr + len + 4 < _inputEnd)
      {
        int end = _inputPtr + len;
        if (_inputBuffer[end] == 34)
        {
          int offset = 0;
          int ptr = _inputPtr;
          for (;;)
          {
            if (ptr == end)
            {
              _parsingContext.setCurrentName(str.getValue());
              i = _skipColonFast(ptr + 1);
              _isNextTokenNameYes(i);
              return true;
            }
            if (nameBytes[offset] != _inputBuffer[ptr]) {
              break;
            }
            offset++;
            ptr++;
          }
        }
      }
    }
    return _isNextTokenNameMaybe(i, str);
  }
  
  public String nextFieldName()
    throws IOException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nextAfterName();
      return null;
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int i = _skipWSOrEnd();
    if (i < 0)
    {
      close();
      _currToken = null;
      return null;
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
    
    _binaryValue = null;
    if (i == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(i, '}');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_ARRAY;
      return null;
    }
    if (i == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(i, ']');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_OBJECT;
      return null;
    }
    if (_parsingContext.expectComma())
    {
      if (i != 44) {
        _reportUnexpectedChar(i, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject())
    {
      _nextTokenNotInObject(i);
      return null;
    }
    String nameStr = _parseName(i);
    _parsingContext.setCurrentName(nameStr);
    _currToken = JsonToken.FIELD_NAME;
    
    i = _skipColon();
    if (i == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return nameStr;
    }
    JsonToken t;
    switch (i)
    {
    case 45: 
      t = _parseNegNumber();
      break;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      t = _parsePosNumber(i);
      break;
    case 102: 
      _matchToken("false", 1);
      t = JsonToken.VALUE_FALSE;
      break;
    case 110: 
      _matchToken("null", 1);
      t = JsonToken.VALUE_NULL;
      break;
    case 116: 
      _matchToken("true", 1);
      t = JsonToken.VALUE_TRUE;
      break;
    case 91: 
      t = JsonToken.START_ARRAY;
      break;
    case 123: 
      t = JsonToken.START_OBJECT;
      break;
    default: 
      t = _handleUnexpectedValue(i);
    }
    _nextToken = t;
    return nameStr;
  }
  
  private final int _skipColonFast(int ptr)
    throws IOException
  {
    int i = _inputBuffer[(ptr++)];
    if (i == 58)
    {
      i = _inputBuffer[(ptr++)];
      if (i > 32)
      {
        if ((i != 47) && (i != 35))
        {
          _inputPtr = ptr;
          return i;
        }
      }
      else if ((i == 32) || (i == 9))
      {
        i = _inputBuffer[(ptr++)];
        if ((i > 32) && 
          (i != 47) && (i != 35))
        {
          _inputPtr = ptr;
          return i;
        }
      }
      _inputPtr = (ptr - 1);
      return _skipColon2(true);
    }
    if ((i == 32) || (i == 9)) {
      i = _inputBuffer[(ptr++)];
    }
    if (i == 58)
    {
      i = _inputBuffer[(ptr++)];
      if (i > 32)
      {
        if ((i != 47) && (i != 35))
        {
          _inputPtr = ptr;
          return i;
        }
      }
      else if ((i == 32) || (i == 9))
      {
        i = _inputBuffer[(ptr++)];
        if ((i > 32) && 
          (i != 47) && (i != 35))
        {
          _inputPtr = ptr;
          return i;
        }
      }
      _inputPtr = (ptr - 1);
      return _skipColon2(true);
    }
    _inputPtr = (ptr - 1);
    return _skipColon2(false);
  }
  
  private final void _isNextTokenNameYes(int i)
    throws IOException
  {
    _currToken = JsonToken.FIELD_NAME;
    switch (i)
    {
    case 34: 
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return;
    case 91: 
      _nextToken = JsonToken.START_ARRAY;
      return;
    case 123: 
      _nextToken = JsonToken.START_OBJECT;
      return;
    case 116: 
      _matchToken("true", 1);
      _nextToken = JsonToken.VALUE_TRUE;
      return;
    case 102: 
      _matchToken("false", 1);
      _nextToken = JsonToken.VALUE_FALSE;
      return;
    case 110: 
      _matchToken("null", 1);
      _nextToken = JsonToken.VALUE_NULL;
      return;
    case 45: 
      _nextToken = _parseNegNumber();
      return;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      _nextToken = _parsePosNumber(i);
      return;
    }
    _nextToken = _handleUnexpectedValue(i);
  }
  
  private final boolean _isNextTokenNameMaybe(int i, SerializableString str)
    throws IOException
  {
    String n = _parseName(i);
    _parsingContext.setCurrentName(n);
    boolean match = n.equals(str.getValue());
    _currToken = JsonToken.FIELD_NAME;
    i = _skipColon();
    if (i == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return match;
    }
    JsonToken t;
    switch (i)
    {
    case 91: 
      t = JsonToken.START_ARRAY;
      break;
    case 123: 
      t = JsonToken.START_OBJECT;
      break;
    case 116: 
      _matchToken("true", 1);
      t = JsonToken.VALUE_TRUE;
      break;
    case 102: 
      _matchToken("false", 1);
      t = JsonToken.VALUE_FALSE;
      break;
    case 110: 
      _matchToken("null", 1);
      t = JsonToken.VALUE_NULL;
      break;
    case 45: 
      t = _parseNegNumber();
      break;
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
      t = _parsePosNumber(i);
      break;
    default: 
      t = _handleUnexpectedValue(i);
    }
    _nextToken = t;
    return match;
  }
  
  public String nextTextValue()
    throws IOException
  {
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken t = _nextToken;
      _nextToken = null;
      _currToken = t;
      if (t == JsonToken.VALUE_STRING)
      {
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          return _finishAndReturnString();
        }
        return _textBuffer.contentsAsString();
      }
      if (t == JsonToken.START_ARRAY) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      } else if (t == JsonToken.START_OBJECT) {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      }
      return null;
    }
    return nextToken() == JsonToken.VALUE_STRING ? getText() : null;
  }
  
  public int nextIntValue(int defaultValue)
    throws IOException
  {
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken t = _nextToken;
      _nextToken = null;
      _currToken = t;
      if (t == JsonToken.VALUE_NUMBER_INT) {
        return getIntValue();
      }
      if (t == JsonToken.START_ARRAY) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      } else if (t == JsonToken.START_OBJECT) {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      }
      return defaultValue;
    }
    return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : defaultValue;
  }
  
  public long nextLongValue(long defaultValue)
    throws IOException
  {
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken t = _nextToken;
      _nextToken = null;
      _currToken = t;
      if (t == JsonToken.VALUE_NUMBER_INT) {
        return getLongValue();
      }
      if (t == JsonToken.START_ARRAY) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      } else if (t == JsonToken.START_OBJECT) {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      }
      return defaultValue;
    }
    return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : defaultValue;
  }
  
  public Boolean nextBooleanValue()
    throws IOException
  {
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      JsonToken t = _nextToken;
      _nextToken = null;
      _currToken = t;
      if (t == JsonToken.VALUE_TRUE) {
        return Boolean.TRUE;
      }
      if (t == JsonToken.VALUE_FALSE) {
        return Boolean.FALSE;
      }
      if (t == JsonToken.START_ARRAY) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      } else if (t == JsonToken.START_OBJECT) {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      }
      return null;
    }
    JsonToken t = nextToken();
    if (t == JsonToken.VALUE_TRUE) {
      return Boolean.TRUE;
    }
    if (t == JsonToken.VALUE_FALSE) {
      return Boolean.FALSE;
    }
    return null;
  }
  
  protected JsonToken _parsePosNumber(int c)
    throws IOException
  {
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    if (c == 48) {
      c = _verifyNoLeadingZeroes();
    }
    outBuf[0] = ((char)c);
    int intLen = 1;
    int outPtr = 1;
    
    int end = _inputPtr + outBuf.length - 1;
    if (end > _inputEnd) {
      end = _inputEnd;
    }
    for (;;)
    {
      if (_inputPtr >= end) {
        return _parseNumber2(outBuf, outPtr, false, intLen);
      }
      c = _inputBuffer[(_inputPtr++)] & 0xFF;
      if ((c < 48) || (c > 57)) {
        break;
      }
      intLen++;
      outBuf[(outPtr++)] = ((char)c);
    }
    if ((c == 46) || (c == 101) || (c == 69)) {
      return _parseFloat(outBuf, outPtr, c, false, intLen);
    }
    _inputPtr -= 1;
    _textBuffer.setCurrentLength(outPtr);
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(c);
    }
    return resetInt(false, intLen);
  }
  
  protected JsonToken _parseNegNumber()
    throws IOException
  {
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    int outPtr = 0;
    
    outBuf[(outPtr++)] = '-';
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int c = _inputBuffer[(_inputPtr++)] & 0xFF;
    if ((c < 48) || (c > 57)) {
      return _handleInvalidNumberStart(c, true);
    }
    if (c == 48) {
      c = _verifyNoLeadingZeroes();
    }
    outBuf[(outPtr++)] = ((char)c);
    int intLen = 1;
    
    int end = _inputPtr + outBuf.length - outPtr;
    if (end > _inputEnd) {
      end = _inputEnd;
    }
    for (;;)
    {
      if (_inputPtr >= end) {
        return _parseNumber2(outBuf, outPtr, true, intLen);
      }
      c = _inputBuffer[(_inputPtr++)] & 0xFF;
      if ((c < 48) || (c > 57)) {
        break;
      }
      intLen++;
      outBuf[(outPtr++)] = ((char)c);
    }
    if ((c == 46) || (c == 101) || (c == 69)) {
      return _parseFloat(outBuf, outPtr, c, true, intLen);
    }
    _inputPtr -= 1;
    _textBuffer.setCurrentLength(outPtr);
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(c);
    }
    return resetInt(true, intLen);
  }
  
  private final JsonToken _parseNumber2(char[] outBuf, int outPtr, boolean negative, int intPartLength)
    throws IOException
  {
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        _textBuffer.setCurrentLength(outPtr);
        return resetInt(negative, intPartLength);
      }
      int c = _inputBuffer[(_inputPtr++)] & 0xFF;
      if ((c > 57) || (c < 48))
      {
        if ((c != 46) && (c != 101) && (c != 69)) {
          break;
        }
        return _parseFloat(outBuf, outPtr, c, negative, intPartLength);
      }
      if (outPtr >= outBuf.length)
      {
        outBuf = _textBuffer.finishCurrentSegment();
        outPtr = 0;
      }
      outBuf[(outPtr++)] = ((char)c);
      intPartLength++;
    }
    _inputPtr -= 1;
    _textBuffer.setCurrentLength(outPtr);
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(_inputBuffer[(_inputPtr++)] & 0xFF);
    }
    return resetInt(negative, intPartLength);
  }
  
  private final int _verifyNoLeadingZeroes()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      return 48;
    }
    int ch = _inputBuffer[_inputPtr] & 0xFF;
    if ((ch < 48) || (ch > 57)) {
      return 48;
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
      reportInvalidNumber("Leading zeroes not allowed");
    }
    _inputPtr += 1;
    if (ch == 48) {
      while ((_inputPtr < _inputEnd) || (loadMore()))
      {
        ch = _inputBuffer[_inputPtr] & 0xFF;
        if ((ch < 48) || (ch > 57)) {
          return 48;
        }
        _inputPtr += 1;
        if (ch != 48) {
          break;
        }
      }
    }
    return ch;
  }
  
  private final JsonToken _parseFloat(char[] outBuf, int outPtr, int c, boolean negative, int integerPartLength)
    throws IOException
  {
    int fractLen = 0;
    boolean eof = false;
    if (c == 46)
    {
      outBuf[(outPtr++)] = ((char)c);
      for (;;)
      {
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          eof = true;
          break;
        }
        c = _inputBuffer[(_inputPtr++)] & 0xFF;
        if ((c < 48) || (c > 57)) {
          break;
        }
        fractLen++;
        if (outPtr >= outBuf.length)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
        }
        outBuf[(outPtr++)] = ((char)c);
      }
      if (fractLen == 0) {
        reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
      }
    }
    int expLen = 0;
    if ((c == 101) || (c == 69))
    {
      if (outPtr >= outBuf.length)
      {
        outBuf = _textBuffer.finishCurrentSegment();
        outPtr = 0;
      }
      outBuf[(outPtr++)] = ((char)c);
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      c = _inputBuffer[(_inputPtr++)] & 0xFF;
      if ((c == 45) || (c == 43))
      {
        if (outPtr >= outBuf.length)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
        }
        outBuf[(outPtr++)] = ((char)c);
        if (_inputPtr >= _inputEnd) {
          loadMoreGuaranteed();
        }
        c = _inputBuffer[(_inputPtr++)] & 0xFF;
      }
      while ((c <= 57) && (c >= 48))
      {
        expLen++;
        if (outPtr >= outBuf.length)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
        }
        outBuf[(outPtr++)] = ((char)c);
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          eof = true;
          break;
        }
        c = _inputBuffer[(_inputPtr++)] & 0xFF;
      }
      if (expLen == 0) {
        reportUnexpectedNumberChar(c, "Exponent indicator not followed by a digit");
      }
    }
    if (!eof)
    {
      _inputPtr -= 1;
      if (_parsingContext.inRoot()) {
        _verifyRootSpace(c);
      }
    }
    _textBuffer.setCurrentLength(outPtr);
    
    return resetFloat(negative, integerPartLength, fractLen, expLen);
  }
  
  private final void _verifyRootSpace(int ch)
    throws IOException
  {
    _inputPtr += 1;
    switch (ch)
    {
    case 9: 
    case 32: 
      return;
    case 13: 
      _skipCR();
      return;
    case 10: 
      _currInputRow += 1;
      _currInputRowStart = _inputPtr;
      return;
    }
    _reportMissingRootWS(ch);
  }
  
  protected final String _parseName(int i)
    throws IOException
  {
    if (i != 34) {
      return _handleOddName(i);
    }
    if (_inputPtr + 13 > _inputEnd) {
      return slowParseName();
    }
    byte[] input = _inputBuffer;
    int[] codes = _icLatin1;
    
    int q = input[(_inputPtr++)] & 0xFF;
    if (codes[q] == 0)
    {
      i = input[(_inputPtr++)] & 0xFF;
      if (codes[i] == 0)
      {
        q = q << 8 | i;
        i = input[(_inputPtr++)] & 0xFF;
        if (codes[i] == 0)
        {
          q = q << 8 | i;
          i = input[(_inputPtr++)] & 0xFF;
          if (codes[i] == 0)
          {
            q = q << 8 | i;
            i = input[(_inputPtr++)] & 0xFF;
            if (codes[i] == 0)
            {
              _quad1 = q;
              return parseMediumName(i);
            }
            if (i == 34) {
              return findName(q, 4);
            }
            return parseName(q, i, 4);
          }
          if (i == 34) {
            return findName(q, 3);
          }
          return parseName(q, i, 3);
        }
        if (i == 34) {
          return findName(q, 2);
        }
        return parseName(q, i, 2);
      }
      if (i == 34) {
        return findName(q, 1);
      }
      return parseName(q, i, 1);
    }
    if (q == 34) {
      return "";
    }
    return parseName(0, q, 0);
  }
  
  protected final String parseMediumName(int q2)
    throws IOException
  {
    byte[] input = _inputBuffer;
    int[] codes = _icLatin1;
    
    int i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, 1);
      }
      return parseName(_quad1, q2, i, 1);
    }
    q2 = q2 << 8 | i;
    i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, 2);
      }
      return parseName(_quad1, q2, i, 2);
    }
    q2 = q2 << 8 | i;
    i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, 3);
      }
      return parseName(_quad1, q2, i, 3);
    }
    q2 = q2 << 8 | i;
    i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, 4);
      }
      return parseName(_quad1, q2, i, 4);
    }
    return parseMediumName2(i, q2);
  }
  
  protected final String parseMediumName2(int q3, int q2)
    throws IOException
  {
    byte[] input = _inputBuffer;
    int[] codes = _icLatin1;
    
    int i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, q3, 1);
      }
      return parseName(_quad1, q2, q3, i, 1);
    }
    q3 = q3 << 8 | i;
    i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, q3, 2);
      }
      return parseName(_quad1, q2, q3, i, 2);
    }
    q3 = q3 << 8 | i;
    i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, q3, 3);
      }
      return parseName(_quad1, q2, q3, i, 3);
    }
    q3 = q3 << 8 | i;
    i = input[(_inputPtr++)] & 0xFF;
    if (codes[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, q2, q3, 4);
      }
      return parseName(_quad1, q2, q3, i, 4);
    }
    return parseLongName(i, q2, q3);
  }
  
  protected final String parseLongName(int q, int q2, int q3)
    throws IOException
  {
    _quadBuffer[0] = _quad1;
    _quadBuffer[1] = q2;
    _quadBuffer[2] = q3;
    
    byte[] input = _inputBuffer;
    int[] codes = _icLatin1;
    int qlen = 3;
    while (_inputPtr + 4 <= _inputEnd)
    {
      int i = input[(_inputPtr++)] & 0xFF;
      if (codes[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, qlen, q, 1);
        }
        return parseEscapedName(_quadBuffer, qlen, q, i, 1);
      }
      q = q << 8 | i;
      i = input[(_inputPtr++)] & 0xFF;
      if (codes[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, qlen, q, 2);
        }
        return parseEscapedName(_quadBuffer, qlen, q, i, 2);
      }
      q = q << 8 | i;
      i = input[(_inputPtr++)] & 0xFF;
      if (codes[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, qlen, q, 3);
        }
        return parseEscapedName(_quadBuffer, qlen, q, i, 3);
      }
      q = q << 8 | i;
      i = input[(_inputPtr++)] & 0xFF;
      if (codes[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, qlen, q, 4);
        }
        return parseEscapedName(_quadBuffer, qlen, q, i, 4);
      }
      if (qlen >= _quadBuffer.length) {
        _quadBuffer = growArrayBy(_quadBuffer, qlen);
      }
      _quadBuffer[(qlen++)] = q;
      q = i;
    }
    return parseEscapedName(_quadBuffer, qlen, 0, q, 0);
  }
  
  protected String slowParseName()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && 
      (!loadMore())) {
      _reportInvalidEOF(": was expecting closing '\"' for name");
    }
    int i = _inputBuffer[(_inputPtr++)] & 0xFF;
    if (i == 34) {
      return "";
    }
    return parseEscapedName(_quadBuffer, 0, 0, i, 0);
  }
  
  private final String parseName(int q1, int ch, int lastQuadBytes)
    throws IOException
  {
    return parseEscapedName(_quadBuffer, 0, q1, ch, lastQuadBytes);
  }
  
  private final String parseName(int q1, int q2, int ch, int lastQuadBytes)
    throws IOException
  {
    _quadBuffer[0] = q1;
    return parseEscapedName(_quadBuffer, 1, q2, ch, lastQuadBytes);
  }
  
  private final String parseName(int q1, int q2, int q3, int ch, int lastQuadBytes)
    throws IOException
  {
    _quadBuffer[0] = q1;
    _quadBuffer[1] = q2;
    return parseEscapedName(_quadBuffer, 2, q3, ch, lastQuadBytes);
  }
  
  protected final String parseEscapedName(int[] quads, int qlen, int currQuad, int ch, int currQuadBytes)
    throws IOException
  {
    int[] codes = _icLatin1;
    for (;;)
    {
      if (codes[ch] != 0)
      {
        if (ch == 34) {
          break;
        }
        if (ch != 92) {
          _throwUnquotedSpace(ch, "name");
        } else {
          ch = _decodeEscaped();
        }
        if (ch > 127)
        {
          if (currQuadBytes >= 4)
          {
            if (qlen >= quads.length) {
              _quadBuffer = (quads = growArrayBy(quads, quads.length));
            }
            quads[(qlen++)] = currQuad;
            currQuad = 0;
            currQuadBytes = 0;
          }
          if (ch < 2048)
          {
            currQuad = currQuad << 8 | 0xC0 | ch >> 6;
            currQuadBytes++;
          }
          else
          {
            currQuad = currQuad << 8 | 0xE0 | ch >> 12;
            currQuadBytes++;
            if (currQuadBytes >= 4)
            {
              if (qlen >= quads.length) {
                _quadBuffer = (quads = growArrayBy(quads, quads.length));
              }
              quads[(qlen++)] = currQuad;
              currQuad = 0;
              currQuadBytes = 0;
            }
            currQuad = currQuad << 8 | 0x80 | ch >> 6 & 0x3F;
            currQuadBytes++;
          }
          ch = 0x80 | ch & 0x3F;
        }
      }
      if (currQuadBytes < 4)
      {
        currQuadBytes++;
        currQuad = currQuad << 8 | ch;
      }
      else
      {
        if (qlen >= quads.length) {
          _quadBuffer = (quads = growArrayBy(quads, quads.length));
        }
        quads[(qlen++)] = currQuad;
        currQuad = ch;
        currQuadBytes = 1;
      }
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      ch = _inputBuffer[(_inputPtr++)] & 0xFF;
    }
    if (currQuadBytes > 0)
    {
      if (qlen >= quads.length) {
        _quadBuffer = (quads = growArrayBy(quads, quads.length));
      }
      quads[(qlen++)] = pad(currQuad, currQuadBytes);
    }
    String name = _symbols.findName(quads, qlen);
    if (name == null) {
      name = addName(quads, qlen, currQuadBytes);
    }
    return name;
  }
  
  protected String _handleOddName(int ch)
    throws IOException
  {
    if ((ch == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return _parseAposName();
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES))
    {
      char c = (char)_decodeCharForError(ch);
      _reportUnexpectedChar(c, "was expecting double-quote to start field name");
    }
    int[] codes = CharTypes.getInputCodeUtf8JsNames();
    if (codes[ch] != 0) {
      _reportUnexpectedChar(ch, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    int[] quads = _quadBuffer;
    int qlen = 0;
    int currQuad = 0;
    int currQuadBytes = 0;
    for (;;)
    {
      if (currQuadBytes < 4)
      {
        currQuadBytes++;
        currQuad = currQuad << 8 | ch;
      }
      else
      {
        if (qlen >= quads.length) {
          _quadBuffer = (quads = growArrayBy(quads, quads.length));
        }
        quads[(qlen++)] = currQuad;
        currQuad = ch;
        currQuadBytes = 1;
      }
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      ch = _inputBuffer[_inputPtr] & 0xFF;
      if (codes[ch] != 0) {
        break;
      }
      _inputPtr += 1;
    }
    if (currQuadBytes > 0)
    {
      if (qlen >= quads.length) {
        _quadBuffer = (quads = growArrayBy(quads, quads.length));
      }
      quads[(qlen++)] = currQuad;
    }
    String name = _symbols.findName(quads, qlen);
    if (name == null) {
      name = addName(quads, qlen, currQuadBytes);
    }
    return name;
  }
  
  protected String _parseAposName()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && 
      (!loadMore())) {
      _reportInvalidEOF(": was expecting closing ''' for name");
    }
    int ch = _inputBuffer[(_inputPtr++)] & 0xFF;
    if (ch == 39) {
      return "";
    }
    int[] quads = _quadBuffer;
    int qlen = 0;
    int currQuad = 0;
    int currQuadBytes = 0;
    
    int[] codes = _icLatin1;
    while (ch != 39)
    {
      if ((ch != 34) && (codes[ch] != 0))
      {
        if (ch != 92) {
          _throwUnquotedSpace(ch, "name");
        } else {
          ch = _decodeEscaped();
        }
        if (ch > 127)
        {
          if (currQuadBytes >= 4)
          {
            if (qlen >= quads.length) {
              _quadBuffer = (quads = growArrayBy(quads, quads.length));
            }
            quads[(qlen++)] = currQuad;
            currQuad = 0;
            currQuadBytes = 0;
          }
          if (ch < 2048)
          {
            currQuad = currQuad << 8 | 0xC0 | ch >> 6;
            currQuadBytes++;
          }
          else
          {
            currQuad = currQuad << 8 | 0xE0 | ch >> 12;
            currQuadBytes++;
            if (currQuadBytes >= 4)
            {
              if (qlen >= quads.length) {
                _quadBuffer = (quads = growArrayBy(quads, quads.length));
              }
              quads[(qlen++)] = currQuad;
              currQuad = 0;
              currQuadBytes = 0;
            }
            currQuad = currQuad << 8 | 0x80 | ch >> 6 & 0x3F;
            currQuadBytes++;
          }
          ch = 0x80 | ch & 0x3F;
        }
      }
      if (currQuadBytes < 4)
      {
        currQuadBytes++;
        currQuad = currQuad << 8 | ch;
      }
      else
      {
        if (qlen >= quads.length) {
          _quadBuffer = (quads = growArrayBy(quads, quads.length));
        }
        quads[(qlen++)] = currQuad;
        currQuad = ch;
        currQuadBytes = 1;
      }
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      ch = _inputBuffer[(_inputPtr++)] & 0xFF;
    }
    if (currQuadBytes > 0)
    {
      if (qlen >= quads.length) {
        _quadBuffer = (quads = growArrayBy(quads, quads.length));
      }
      quads[(qlen++)] = pad(currQuad, currQuadBytes);
    }
    String name = _symbols.findName(quads, qlen);
    if (name == null) {
      name = addName(quads, qlen, currQuadBytes);
    }
    return name;
  }
  
  private final String findName(int q1, int lastQuadBytes)
    throws JsonParseException
  {
    q1 = pad(q1, lastQuadBytes);
    
    String name = _symbols.findName(q1);
    if (name != null) {
      return name;
    }
    _quadBuffer[0] = q1;
    return addName(_quadBuffer, 1, lastQuadBytes);
  }
  
  private final String findName(int q1, int q2, int lastQuadBytes)
    throws JsonParseException
  {
    q2 = pad(q2, lastQuadBytes);
    
    String name = _symbols.findName(q1, q2);
    if (name != null) {
      return name;
    }
    _quadBuffer[0] = q1;
    _quadBuffer[1] = q2;
    return addName(_quadBuffer, 2, lastQuadBytes);
  }
  
  private final String findName(int q1, int q2, int q3, int lastQuadBytes)
    throws JsonParseException
  {
    q3 = pad(q3, lastQuadBytes);
    String name = _symbols.findName(q1, q2, q3);
    if (name != null) {
      return name;
    }
    int[] quads = _quadBuffer;
    quads[0] = q1;
    quads[1] = q2;
    quads[2] = pad(q3, lastQuadBytes);
    return addName(quads, 3, lastQuadBytes);
  }
  
  private final String findName(int[] quads, int qlen, int lastQuad, int lastQuadBytes)
    throws JsonParseException
  {
    if (qlen >= quads.length) {
      _quadBuffer = (quads = growArrayBy(quads, quads.length));
    }
    quads[(qlen++)] = pad(lastQuad, lastQuadBytes);
    String name = _symbols.findName(quads, qlen);
    if (name == null) {
      return addName(quads, qlen, lastQuadBytes);
    }
    return name;
  }
  
  private final String addName(int[] quads, int qlen, int lastQuadBytes)
    throws JsonParseException
  {
    int byteLen = (qlen << 2) - 4 + lastQuadBytes;
    int lastQuad;
    if (lastQuadBytes < 4)
    {
      int lastQuad = quads[(qlen - 1)];
      
      quads[(qlen - 1)] = (lastQuad << (4 - lastQuadBytes << 3));
    }
    else
    {
      lastQuad = 0;
    }
    char[] cbuf = _textBuffer.emptyAndGetCurrentSegment();
    int cix = 0;
    for (int ix = 0; ix < byteLen;)
    {
      int ch = quads[(ix >> 2)];
      int byteIx = ix & 0x3;
      ch = ch >> (3 - byteIx << 3) & 0xFF;
      ix++;
      if (ch > 127)
      {
        int needed;
        int needed;
        if ((ch & 0xE0) == 192)
        {
          ch &= 0x1F;
          needed = 1;
        }
        else
        {
          int needed;
          if ((ch & 0xF0) == 224)
          {
            ch &= 0xF;
            needed = 2;
          }
          else
          {
            int needed;
            if ((ch & 0xF8) == 240)
            {
              ch &= 0x7;
              needed = 3;
            }
            else
            {
              _reportInvalidInitial(ch);
              needed = ch = 1;
            }
          }
        }
        if (ix + needed > byteLen) {
          _reportInvalidEOF(" in field name");
        }
        int ch2 = quads[(ix >> 2)];
        byteIx = ix & 0x3;
        ch2 >>= 3 - byteIx << 3;
        ix++;
        if ((ch2 & 0xC0) != 128) {
          _reportInvalidOther(ch2);
        }
        ch = ch << 6 | ch2 & 0x3F;
        if (needed > 1)
        {
          ch2 = quads[(ix >> 2)];
          byteIx = ix & 0x3;
          ch2 >>= 3 - byteIx << 3;
          ix++;
          if ((ch2 & 0xC0) != 128) {
            _reportInvalidOther(ch2);
          }
          ch = ch << 6 | ch2 & 0x3F;
          if (needed > 2)
          {
            ch2 = quads[(ix >> 2)];
            byteIx = ix & 0x3;
            ch2 >>= 3 - byteIx << 3;
            ix++;
            if ((ch2 & 0xC0) != 128) {
              _reportInvalidOther(ch2 & 0xFF);
            }
            ch = ch << 6 | ch2 & 0x3F;
          }
        }
        if (needed > 2)
        {
          ch -= 65536;
          if (cix >= cbuf.length) {
            cbuf = _textBuffer.expandCurrentSegment();
          }
          cbuf[(cix++)] = ((char)(55296 + (ch >> 10)));
          ch = 0xDC00 | ch & 0x3FF;
        }
      }
      if (cix >= cbuf.length) {
        cbuf = _textBuffer.expandCurrentSegment();
      }
      cbuf[(cix++)] = ((char)ch);
    }
    String baseName = new String(cbuf, 0, cix);
    if (lastQuadBytes < 4) {
      quads[(qlen - 1)] = lastQuad;
    }
    return _symbols.addName(baseName, quads, qlen);
  }
  
  protected void _finishString()
    throws IOException
  {
    int ptr = _inputPtr;
    if (ptr >= _inputEnd)
    {
      loadMoreGuaranteed();
      ptr = _inputPtr;
    }
    int outPtr = 0;
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    int[] codes = _icUTF8;
    
    int max = Math.min(_inputEnd, ptr + outBuf.length);
    byte[] inputBuffer = _inputBuffer;
    while (ptr < max)
    {
      int c = inputBuffer[ptr] & 0xFF;
      if (codes[c] != 0)
      {
        if (c != 34) {
          break;
        }
        _inputPtr = (ptr + 1);
        _textBuffer.setCurrentLength(outPtr);
        return;
      }
      ptr++;
      outBuf[(outPtr++)] = ((char)c);
    }
    _inputPtr = ptr;
    _finishString2(outBuf, outPtr);
  }
  
  protected String _finishAndReturnString()
    throws IOException
  {
    int ptr = _inputPtr;
    if (ptr >= _inputEnd)
    {
      loadMoreGuaranteed();
      ptr = _inputPtr;
    }
    int outPtr = 0;
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    int[] codes = _icUTF8;
    
    int max = Math.min(_inputEnd, ptr + outBuf.length);
    byte[] inputBuffer = _inputBuffer;
    while (ptr < max)
    {
      int c = inputBuffer[ptr] & 0xFF;
      if (codes[c] != 0)
      {
        if (c != 34) {
          break;
        }
        _inputPtr = (ptr + 1);
        return _textBuffer.setCurrentAndReturn(outPtr);
      }
      ptr++;
      outBuf[(outPtr++)] = ((char)c);
    }
    _inputPtr = ptr;
    _finishString2(outBuf, outPtr);
    return _textBuffer.contentsAsString();
  }
  
  private final void _finishString2(char[] outBuf, int outPtr)
    throws IOException
  {
    int[] codes = _icUTF8;
    byte[] inputBuffer = _inputBuffer;
    for (;;)
    {
      int ptr = _inputPtr;
      if (ptr >= _inputEnd)
      {
        loadMoreGuaranteed();
        ptr = _inputPtr;
      }
      if (outPtr >= outBuf.length)
      {
        outBuf = _textBuffer.finishCurrentSegment();
        outPtr = 0;
      }
      int max = Math.min(_inputEnd, ptr + (outBuf.length - outPtr));
      while (ptr < max)
      {
        int c = inputBuffer[(ptr++)] & 0xFF;
        if (codes[c] != 0)
        {
          _inputPtr = ptr;
          break label125;
        }
        outBuf[(outPtr++)] = ((char)c);
      }
      _inputPtr = ptr;
      continue;
      label125:
      int c;
      if (c == 34) {
        break;
      }
      switch (codes[c])
      {
      case 1: 
        c = _decodeEscaped();
        break;
      case 2: 
        c = _decodeUtf8_2(c);
        break;
      case 3: 
        if (_inputEnd - _inputPtr >= 2) {
          c = _decodeUtf8_3fast(c);
        } else {
          c = _decodeUtf8_3(c);
        }
        break;
      case 4: 
        c = _decodeUtf8_4(c);
        
        outBuf[(outPtr++)] = ((char)(0xD800 | c >> 10));
        if (outPtr >= outBuf.length)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
        }
        c = 0xDC00 | c & 0x3FF;
        
        break;
      default: 
        if (c < 32) {
          _throwUnquotedSpace(c, "string value");
        } else {
          _reportInvalidChar(c);
        }
        break;
      }
      if (outPtr >= outBuf.length)
      {
        outBuf = _textBuffer.finishCurrentSegment();
        outPtr = 0;
      }
      outBuf[(outPtr++)] = ((char)c);
    }
    _textBuffer.setCurrentLength(outPtr);
  }
  
  protected void _skipString()
    throws IOException
  {
    _tokenIncomplete = false;
    
    int[] codes = _icUTF8;
    byte[] inputBuffer = _inputBuffer;
    for (;;)
    {
      int ptr = _inputPtr;
      int max = _inputEnd;
      if (ptr >= max)
      {
        loadMoreGuaranteed();
        ptr = _inputPtr;
        max = _inputEnd;
      }
      while (ptr < max)
      {
        int c = inputBuffer[(ptr++)] & 0xFF;
        if (codes[c] != 0)
        {
          _inputPtr = ptr;
          break label87;
        }
      }
      _inputPtr = ptr;
      continue;
      label87:
      int c;
      if (c == 34) {
        break;
      }
      switch (codes[c])
      {
      case 1: 
        _decodeEscaped();
        break;
      case 2: 
        _skipUtf8_2(c);
        break;
      case 3: 
        _skipUtf8_3(c);
        break;
      case 4: 
        _skipUtf8_4(c);
        break;
      default: 
        if (c < 32) {
          _throwUnquotedSpace(c, "string value");
        } else {
          _reportInvalidChar(c);
        }
        break;
      }
    }
  }
  
  protected JsonToken _handleUnexpectedValue(int c)
    throws IOException
  {
    switch (c)
    {
    case 93: 
    case 125: 
      _reportUnexpectedChar(c, "expected a value");
    case 39: 
      if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
        return _handleApos();
      }
      break;
    case 78: 
      _matchToken("NaN", 1);
      if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
        return resetAsNaN("NaN", NaN.0D);
      }
      _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      break;
    case 73: 
      _matchToken("Infinity", 1);
      if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
        return resetAsNaN("Infinity", Double.POSITIVE_INFINITY);
      }
      _reportError("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      break;
    case 43: 
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      return _handleInvalidNumberStart(_inputBuffer[(_inputPtr++)] & 0xFF, false);
    }
    if (Character.isJavaIdentifierStart(c)) {
      _reportInvalidToken("" + (char)c, "('true', 'false' or 'null')");
    }
    _reportUnexpectedChar(c, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
    return null;
  }
  
  protected JsonToken _handleApos()
    throws IOException
  {
    int c = 0;
    
    int outPtr = 0;
    char[] outBuf = _textBuffer.emptyAndGetCurrentSegment();
    
    int[] codes = _icUTF8;
    byte[] inputBuffer = _inputBuffer;
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      if (outPtr >= outBuf.length)
      {
        outBuf = _textBuffer.finishCurrentSegment();
        outPtr = 0;
      }
      int max = _inputEnd;
      
      int max2 = _inputPtr + (outBuf.length - outPtr);
      if (max2 < max) {
        max = max2;
      }
      while (_inputPtr < max)
      {
        c = inputBuffer[(_inputPtr++)] & 0xFF;
        if ((c == 39) || (codes[c] != 0)) {
          break label140;
        }
        outBuf[(outPtr++)] = ((char)c);
      }
      continue;
      label140:
      if (c == 39) {
        break;
      }
      switch (codes[c])
      {
      case 1: 
        if (c != 39) {
          c = _decodeEscaped();
        }
        break;
      case 2: 
        c = _decodeUtf8_2(c);
        break;
      case 3: 
        if (_inputEnd - _inputPtr >= 2) {
          c = _decodeUtf8_3fast(c);
        } else {
          c = _decodeUtf8_3(c);
        }
        break;
      case 4: 
        c = _decodeUtf8_4(c);
        
        outBuf[(outPtr++)] = ((char)(0xD800 | c >> 10));
        if (outPtr >= outBuf.length)
        {
          outBuf = _textBuffer.finishCurrentSegment();
          outPtr = 0;
        }
        c = 0xDC00 | c & 0x3FF;
        
        break;
      default: 
        if (c < 32) {
          _throwUnquotedSpace(c, "string value");
        }
        _reportInvalidChar(c);
      }
      if (outPtr >= outBuf.length)
      {
        outBuf = _textBuffer.finishCurrentSegment();
        outPtr = 0;
      }
      outBuf[(outPtr++)] = ((char)c);
    }
    _textBuffer.setCurrentLength(outPtr);
    
    return JsonToken.VALUE_STRING;
  }
  
  protected JsonToken _handleInvalidNumberStart(int ch, boolean neg)
    throws IOException
  {
    while (ch == 73)
    {
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      ch = _inputBuffer[(_inputPtr++)];
      String match;
      String match;
      if (ch == 78)
      {
        match = neg ? "-INF" : "+INF";
      }
      else
      {
        if (ch != 110) {
          break;
        }
        match = neg ? "-Infinity" : "+Infinity";
      }
      _matchToken(match, 3);
      if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
        return resetAsNaN(match, neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
      }
      _reportError("Non-standard token '" + match + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
    }
    reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
    return null;
  }
  
  protected final void _matchToken(String matchStr, int i)
    throws IOException
  {
    int len = matchStr.length();
    if (_inputPtr + len >= _inputEnd)
    {
      _matchToken2(matchStr, i);
    }
    else
    {
      do
      {
        if (_inputBuffer[_inputPtr] != matchStr.charAt(i)) {
          _reportInvalidToken(matchStr.substring(0, i));
        }
        _inputPtr += 1;
        i++;
      } while (i < len);
      int ch = _inputBuffer[_inputPtr] & 0xFF;
      if ((ch >= 48) && (ch != 93) && (ch != 125)) {
        _checkMatchEnd(matchStr, i, ch);
      }
    }
  }
  
  private final void _matchToken2(String matchStr, int i)
    throws IOException
  {
    int len = matchStr.length();
    do
    {
      if (((_inputPtr >= _inputEnd) && (!loadMore())) || (_inputBuffer[_inputPtr] != matchStr.charAt(i))) {
        _reportInvalidToken(matchStr.substring(0, i));
      }
      _inputPtr += 1;
      i++;
    } while (i < len);
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      return;
    }
    int ch = _inputBuffer[_inputPtr] & 0xFF;
    if ((ch >= 48) && (ch != 93) && (ch != 125)) {
      _checkMatchEnd(matchStr, i, ch);
    }
  }
  
  private final void _checkMatchEnd(String matchStr, int i, int ch)
    throws IOException
  {
    char c = (char)_decodeCharForError(ch);
    if (Character.isJavaIdentifierPart(c)) {
      _reportInvalidToken(matchStr.substring(0, i));
    }
  }
  
  private final int _skipWS()
    throws IOException
  {
    while (_inputPtr < _inputEnd)
    {
      int i = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (i > 32)
      {
        if ((i == 47) || (i == 35))
        {
          _inputPtr -= 1;
          return _skipWS2();
        }
        return i;
      }
      if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    return _skipWS2();
  }
  
  private final int _skipWS2()
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      int i = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else if ((i != 35) || 
          (!_skipYAMLComment())) {
          return i;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + _parsingContext.getTypeDesc() + " entries");
  }
  
  private final int _skipWSOrEnd()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && 
      (!loadMore())) {
      return _eofAsNextChar();
    }
    int i = _inputBuffer[(_inputPtr++)] & 0xFF;
    if (i > 32)
    {
      if ((i == 47) || (i == 35))
      {
        _inputPtr -= 1;
        return _skipWSOrEnd2();
      }
      return i;
    }
    if (i != 32) {
      if (i == 10)
      {
        _currInputRow += 1;
        _currInputRowStart = _inputPtr;
      }
      else if (i == 13)
      {
        _skipCR();
      }
      else if (i != 9)
      {
        _throwInvalidSpace(i);
      }
    }
    while (_inputPtr < _inputEnd)
    {
      i = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (i > 32)
      {
        if ((i == 47) || (i == 35))
        {
          _inputPtr -= 1;
          return _skipWSOrEnd2();
        }
        return i;
      }
      if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    return _skipWSOrEnd2();
  }
  
  private final int _skipWSOrEnd2()
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      int i = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else if ((i != 35) || 
          (!_skipYAMLComment())) {
          return i;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    return _eofAsNextChar();
  }
  
  private final int _skipColon()
    throws IOException
  {
    if (_inputPtr + 4 >= _inputEnd) {
      return _skipColon2(false);
    }
    int i = _inputBuffer[_inputPtr];
    if (i == 58)
    {
      i = _inputBuffer[(++_inputPtr)];
      if (i > 32)
      {
        if ((i == 47) || (i == 35)) {
          return _skipColon2(true);
        }
        _inputPtr += 1;
        return i;
      }
      if ((i == 32) || (i == 9))
      {
        i = _inputBuffer[(++_inputPtr)];
        if (i > 32)
        {
          if ((i == 47) || (i == 35)) {
            return _skipColon2(true);
          }
          _inputPtr += 1;
          return i;
        }
      }
      return _skipColon2(true);
    }
    if ((i == 32) || (i == 9)) {
      i = _inputBuffer[(++_inputPtr)];
    }
    if (i == 58)
    {
      i = _inputBuffer[(++_inputPtr)];
      if (i > 32)
      {
        if ((i == 47) || (i == 35)) {
          return _skipColon2(true);
        }
        _inputPtr += 1;
        return i;
      }
      if ((i == 32) || (i == 9))
      {
        i = _inputBuffer[(++_inputPtr)];
        if (i > 32)
        {
          if ((i == 47) || (i == 35)) {
            return _skipColon2(true);
          }
          _inputPtr += 1;
          return i;
        }
      }
      return _skipColon2(true);
    }
    return _skipColon2(false);
  }
  
  private final int _skipColon2(boolean gotColon)
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      int i = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (i > 32)
      {
        if (i == 47)
        {
          _skipComment();
        }
        else if ((i != 35) || 
          (!_skipYAMLComment()))
        {
          if (gotColon) {
            return i;
          }
          if (i != 58)
          {
            if (i < 32) {
              _throwInvalidSpace(i);
            }
            _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
          }
          gotColon = true;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + _parsingContext.getTypeDesc() + " entries");
  }
  
  private final void _skipComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    int c = _inputBuffer[(_inputPtr++)] & 0xFF;
    if (c == 47) {
      _skipLine();
    } else if (c == 42) {
      _skipCComment();
    } else {
      _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
    }
  }
  
  private final void _skipCComment()
    throws IOException
  {
    int[] codes = CharTypes.getInputCodeComment();
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      int i = _inputBuffer[(_inputPtr++)] & 0xFF;
      int code = codes[i];
      if (code != 0) {
        switch (code)
        {
        case 42: 
          if ((_inputPtr >= _inputEnd) && (!loadMore())) {
            break label218;
          }
          if (_inputBuffer[_inputPtr] == 47)
          {
            _inputPtr += 1; return;
          }
          break;
        case 10: 
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
          break;
        case 13: 
          _skipCR();
          break;
        case 2: 
          _skipUtf8_2(i);
          break;
        case 3: 
          _skipUtf8_3(i);
          break;
        case 4: 
          _skipUtf8_4(i);
          break;
        default: 
          _reportInvalidChar(i);
        }
      }
    }
    label218:
    _reportInvalidEOF(" in a comment");
  }
  
  private final boolean _skipYAMLComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
      return false;
    }
    _skipLine();
    return true;
  }
  
  private final void _skipLine()
    throws IOException
  {
    int[] codes = CharTypes.getInputCodeComment();
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      int i = _inputBuffer[(_inputPtr++)] & 0xFF;
      int code = codes[i];
      if (code != 0) {
        switch (code)
        {
        case 10: 
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
          return;
        case 13: 
          _skipCR(); return;
        case 42: 
          break;
        case 2: 
          _skipUtf8_2(i);
          break;
        case 3: 
          _skipUtf8_3(i);
          break;
        case 4: 
          _skipUtf8_4(i);
          break;
        default: 
          if (code < 0) {
            _reportInvalidChar(i);
          }
          break;
        }
      }
    }
  }
  
  protected char _decodeEscaped()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && 
      (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    int c = _inputBuffer[(_inputPtr++)];
    switch (c)
    {
    case 98: 
      return '\b';
    case 116: 
      return '\t';
    case 110: 
      return '\n';
    case 102: 
      return '\f';
    case 114: 
      return '\r';
    case 34: 
    case 47: 
    case 92: 
      return (char)c;
    case 117: 
      break;
    default: 
      return _handleUnrecognizedCharacterEscape((char)_decodeCharForError(c));
    }
    int value = 0;
    for (int i = 0; i < 4; i++)
    {
      if ((_inputPtr >= _inputEnd) && 
        (!loadMore())) {
        _reportInvalidEOF(" in character escape sequence");
      }
      int ch = _inputBuffer[(_inputPtr++)];
      int digit = CharTypes.charToHex(ch);
      if (digit < 0) {
        _reportUnexpectedChar(ch, "expected a hex-digit for character escape sequence");
      }
      value = value << 4 | digit;
    }
    return (char)value;
  }
  
  protected int _decodeCharForError(int firstByte)
    throws IOException
  {
    int c = firstByte & 0xFF;
    if (c > 127)
    {
      int needed;
      int needed;
      if ((c & 0xE0) == 192)
      {
        c &= 0x1F;
        needed = 1;
      }
      else
      {
        int needed;
        if ((c & 0xF0) == 224)
        {
          c &= 0xF;
          needed = 2;
        }
        else
        {
          int needed;
          if ((c & 0xF8) == 240)
          {
            c &= 0x7;
            needed = 3;
          }
          else
          {
            _reportInvalidInitial(c & 0xFF);
            needed = 1;
          }
        }
      }
      int d = nextByte();
      if ((d & 0xC0) != 128) {
        _reportInvalidOther(d & 0xFF);
      }
      c = c << 6 | d & 0x3F;
      if (needed > 1)
      {
        d = nextByte();
        if ((d & 0xC0) != 128) {
          _reportInvalidOther(d & 0xFF);
        }
        c = c << 6 | d & 0x3F;
        if (needed > 2)
        {
          d = nextByte();
          if ((d & 0xC0) != 128) {
            _reportInvalidOther(d & 0xFF);
          }
          c = c << 6 | d & 0x3F;
        }
      }
    }
    return c;
  }
  
  private final int _decodeUtf8_2(int c)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    return (c & 0x1F) << 6 | d & 0x3F;
  }
  
  private final int _decodeUtf8_3(int c1)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    c1 &= 0xF;
    int d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    int c = c1 << 6 | d & 0x3F;
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    return c;
  }
  
  private final int _decodeUtf8_3fast(int c1)
    throws IOException
  {
    c1 &= 0xF;
    int d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    int c = c1 << 6 | d & 0x3F;
    d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    return c;
  }
  
  private final int _decodeUtf8_4(int c)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = (c & 0x7) << 6 | d & 0x3F;
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    c = c << 6 | d & 0x3F;
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    return (c << 6 | d & 0x3F) - 65536;
  }
  
  private final void _skipUtf8_2(int c)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    c = _inputBuffer[(_inputPtr++)];
    if ((c & 0xC0) != 128) {
      _reportInvalidOther(c & 0xFF, _inputPtr);
    }
  }
  
  private final void _skipUtf8_3(int c)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    c = _inputBuffer[(_inputPtr++)];
    if ((c & 0xC0) != 128) {
      _reportInvalidOther(c & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    c = _inputBuffer[(_inputPtr++)];
    if ((c & 0xC0) != 128) {
      _reportInvalidOther(c & 0xFF, _inputPtr);
    }
  }
  
  private final void _skipUtf8_4(int c)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    int d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    d = _inputBuffer[(_inputPtr++)];
    if ((d & 0xC0) != 128) {
      _reportInvalidOther(d & 0xFF, _inputPtr);
    }
  }
  
  protected final void _skipCR()
    throws IOException
  {
    if (((_inputPtr < _inputEnd) || (loadMore())) && 
      (_inputBuffer[_inputPtr] == 10)) {
      _inputPtr += 1;
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  private int nextByte()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    return _inputBuffer[(_inputPtr++)] & 0xFF;
  }
  
  protected void _reportInvalidToken(String matchedPart)
    throws IOException
  {
    _reportInvalidToken(matchedPart, "'null', 'true', 'false' or NaN");
  }
  
  protected void _reportInvalidToken(String matchedPart, String msg)
    throws IOException
  {
    StringBuilder sb = new StringBuilder(matchedPart);
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      int i = _inputBuffer[(_inputPtr++)];
      char c = (char)_decodeCharForError(i);
      if (!Character.isJavaIdentifierPart(c)) {
        break;
      }
      sb.append(c);
    }
    _reportError("Unrecognized token '" + sb.toString() + "': was expecting " + msg);
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
  
  public static int[] growArrayBy(int[] arr, int more)
  {
    if (arr == null) {
      return new int[more];
    }
    return Arrays.copyOf(arr, arr.length + more);
  }
  
  protected final byte[] _decodeBase64(Base64Variant b64variant)
    throws IOException
  {
    ByteArrayBuilder builder = _getByteArrayBuilder();
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      int ch = _inputBuffer[(_inputPtr++)] & 0xFF;
      if (ch > 32)
      {
        int bits = b64variant.decodeBase64Char(ch);
        if (bits < 0)
        {
          if (ch == 34) {
            return builder.toByteArray();
          }
          bits = _decodeBase64Escape(b64variant, ch, 0);
          if (bits < 0) {}
        }
        else
        {
          int decodedData = bits;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          ch = _inputBuffer[(_inputPtr++)] & 0xFF;
          bits = b64variant.decodeBase64Char(ch);
          if (bits < 0) {
            bits = _decodeBase64Escape(b64variant, ch, 1);
          }
          decodedData = decodedData << 6 | bits;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          ch = _inputBuffer[(_inputPtr++)] & 0xFF;
          bits = b64variant.decodeBase64Char(ch);
          if (bits < 0)
          {
            if (bits != -2)
            {
              if ((ch == 34) && (!b64variant.usesPadding()))
              {
                decodedData >>= 4;
                builder.append(decodedData);
                return builder.toByteArray();
              }
              bits = _decodeBase64Escape(b64variant, ch, 2);
            }
            if (bits == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              ch = _inputBuffer[(_inputPtr++)] & 0xFF;
              if (!b64variant.usesPaddingChar(ch)) {
                throw reportInvalidBase64Char(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
              }
              decodedData >>= 4;
              builder.append(decodedData);
              continue;
            }
          }
          decodedData = decodedData << 6 | bits;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          ch = _inputBuffer[(_inputPtr++)] & 0xFF;
          bits = b64variant.decodeBase64Char(ch);
          if (bits < 0)
          {
            if (bits != -2)
            {
              if ((ch == 34) && (!b64variant.usesPadding()))
              {
                decodedData >>= 2;
                builder.appendTwoBytes(decodedData);
                return builder.toByteArray();
              }
              bits = _decodeBase64Escape(b64variant, ch, 3);
            }
            if (bits == -2)
            {
              decodedData >>= 2;
              builder.appendTwoBytes(decodedData);
              continue;
            }
          }
          decodedData = decodedData << 6 | bits;
          builder.appendThreeBytes(decodedData);
        }
      }
    }
  }
  
  private static final int pad(int q, int bytes)
  {
    return bytes == 4 ? q : q | -1 << (bytes << 3);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.UTF8StreamJsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */