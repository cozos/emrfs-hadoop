package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonReadContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class TokenBuffer$Parser
  extends ParserMinimalBase
{
  protected ObjectCodec _codec;
  protected final boolean _hasNativeTypeIds;
  protected final boolean _hasNativeObjectIds;
  protected final boolean _hasNativeIds;
  protected TokenBuffer.Segment _segment;
  protected int _segmentPtr;
  protected JsonReadContext _parsingContext;
  protected boolean _closed;
  protected transient ByteArrayBuilder _byteBuilder;
  protected JsonLocation _location = null;
  
  public TokenBuffer$Parser(TokenBuffer.Segment firstSeg, ObjectCodec codec, boolean hasNativeTypeIds, boolean hasNativeObjectIds)
  {
    super(0);
    _segment = firstSeg;
    _segmentPtr = -1;
    _codec = codec;
    _parsingContext = JsonReadContext.createRootContext(null);
    _hasNativeTypeIds = hasNativeTypeIds;
    _hasNativeObjectIds = hasNativeObjectIds;
    _hasNativeIds = (hasNativeTypeIds | hasNativeObjectIds);
  }
  
  public void setLocation(JsonLocation l)
  {
    _location = l;
  }
  
  public ObjectCodec getCodec()
  {
    return _codec;
  }
  
  public void setCodec(ObjectCodec c)
  {
    _codec = c;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public JsonToken peekNextToken()
    throws IOException
  {
    if (_closed) {
      return null;
    }
    TokenBuffer.Segment seg = _segment;
    int ptr = _segmentPtr + 1;
    if (ptr >= 16)
    {
      ptr = 0;
      seg = seg == null ? null : seg.next();
    }
    return seg == null ? null : seg.type(ptr);
  }
  
  public void close()
    throws IOException
  {
    if (!_closed) {
      _closed = true;
    }
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    if ((_closed) || (_segment == null)) {
      return null;
    }
    if (++_segmentPtr >= 16)
    {
      _segmentPtr = 0;
      _segment = _segment.next();
      if (_segment == null) {
        return null;
      }
    }
    _currToken = _segment.type(_segmentPtr);
    if (_currToken == JsonToken.FIELD_NAME)
    {
      Object ob = _currentObject();
      String name = (ob instanceof String) ? (String)ob : ob.toString();
      _parsingContext.setCurrentName(name);
    }
    else if (_currToken == JsonToken.START_OBJECT)
    {
      _parsingContext = _parsingContext.createChildObjectContext(-1, -1);
    }
    else if (_currToken == JsonToken.START_ARRAY)
    {
      _parsingContext = _parsingContext.createChildArrayContext(-1, -1);
    }
    else if ((_currToken == JsonToken.END_OBJECT) || (_currToken == JsonToken.END_ARRAY))
    {
      _parsingContext = _parsingContext.getParent();
      if (_parsingContext == null) {
        _parsingContext = JsonReadContext.createRootContext(null);
      }
    }
    return _currToken;
  }
  
  public String nextFieldName()
    throws IOException
  {
    if ((_closed) || (_segment == null)) {
      return null;
    }
    int ptr = _segmentPtr + 1;
    if ((ptr < 16) && (_segment.type(ptr) == JsonToken.FIELD_NAME))
    {
      _segmentPtr = ptr;
      Object ob = _segment.get(ptr);
      String name = (ob instanceof String) ? (String)ob : ob.toString();
      _parsingContext.setCurrentName(name);
      return name;
    }
    return nextToken() == JsonToken.FIELD_NAME ? getCurrentName() : null;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public JsonStreamContext getParsingContext()
  {
    return _parsingContext;
  }
  
  public JsonLocation getTokenLocation()
  {
    return getCurrentLocation();
  }
  
  public JsonLocation getCurrentLocation()
  {
    return _location == null ? JsonLocation.NA : _location;
  }
  
  public String getCurrentName()
  {
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY))
    {
      JsonReadContext parent = _parsingContext.getParent();
      return parent.getCurrentName();
    }
    return _parsingContext.getCurrentName();
  }
  
  public void overrideCurrentName(String name)
  {
    JsonReadContext ctxt = _parsingContext;
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
      ctxt = ctxt.getParent();
    }
    try
    {
      ctxt.setCurrentName(name);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public String getText()
  {
    if ((_currToken == JsonToken.VALUE_STRING) || (_currToken == JsonToken.FIELD_NAME))
    {
      Object ob = _currentObject();
      if ((ob instanceof String)) {
        return (String)ob;
      }
      return ob == null ? null : ob.toString();
    }
    if (_currToken == null) {
      return null;
    }
    switch (TokenBuffer.1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[_currToken.ordinal()])
    {
    case 7: 
    case 8: 
      Object ob = _currentObject();
      return ob == null ? null : ob.toString();
    }
    return _currToken.asString();
  }
  
  public char[] getTextCharacters()
  {
    String str = getText();
    return str == null ? null : str.toCharArray();
  }
  
  public int getTextLength()
  {
    String str = getText();
    return str == null ? 0 : str.length();
  }
  
  public int getTextOffset()
  {
    return 0;
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    Number n = getNumberValue();
    if ((n instanceof BigInteger)) {
      return (BigInteger)n;
    }
    if (getNumberType() == JsonParser.NumberType.BIG_DECIMAL) {
      return ((BigDecimal)n).toBigInteger();
    }
    return BigInteger.valueOf(n.longValue());
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    Number n = getNumberValue();
    if ((n instanceof BigDecimal)) {
      return (BigDecimal)n;
    }
    switch (TokenBuffer.1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[getNumberType().ordinal()])
    {
    case 1: 
    case 5: 
      return BigDecimal.valueOf(n.longValue());
    case 2: 
      return new BigDecimal((BigInteger)n);
    }
    return BigDecimal.valueOf(n.doubleValue());
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return getNumberValue().doubleValue();
  }
  
  public float getFloatValue()
    throws IOException
  {
    return getNumberValue().floatValue();
  }
  
  public int getIntValue()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_NUMBER_INT) {
      return ((Number)_currentObject()).intValue();
    }
    return getNumberValue().intValue();
  }
  
  public long getLongValue()
    throws IOException
  {
    return getNumberValue().longValue();
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    Number n = getNumberValue();
    if ((n instanceof Integer)) {
      return JsonParser.NumberType.INT;
    }
    if ((n instanceof Long)) {
      return JsonParser.NumberType.LONG;
    }
    if ((n instanceof Double)) {
      return JsonParser.NumberType.DOUBLE;
    }
    if ((n instanceof BigDecimal)) {
      return JsonParser.NumberType.BIG_DECIMAL;
    }
    if ((n instanceof BigInteger)) {
      return JsonParser.NumberType.BIG_INTEGER;
    }
    if ((n instanceof Float)) {
      return JsonParser.NumberType.FLOAT;
    }
    if ((n instanceof Short)) {
      return JsonParser.NumberType.INT;
    }
    return null;
  }
  
  public final Number getNumberValue()
    throws IOException
  {
    _checkIsNumber();
    Object value = _currentObject();
    if ((value instanceof Number)) {
      return (Number)value;
    }
    if ((value instanceof String))
    {
      String str = (String)value;
      if (str.indexOf('.') >= 0) {
        return Double.valueOf(Double.parseDouble(str));
      }
      return Long.valueOf(Long.parseLong(str));
    }
    if (value == null) {
      return null;
    }
    throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + value.getClass().getName());
  }
  
  public Object getEmbeddedObject()
  {
    if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
      return _currentObject();
    }
    return null;
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      Object ob = _currentObject();
      if ((ob instanceof byte[])) {
        return (byte[])ob;
      }
    }
    if (_currToken != JsonToken.VALUE_STRING) {
      throw _constructError("Current token (" + _currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
    }
    String str = getText();
    if (str == null) {
      return null;
    }
    ByteArrayBuilder builder = _byteBuilder;
    if (builder == null) {
      _byteBuilder = (builder = new ByteArrayBuilder(100));
    } else {
      _byteBuilder.reset();
    }
    _decodeBase64(str, builder, b64variant);
    return builder.toByteArray();
  }
  
  public int readBinaryValue(Base64Variant b64variant, OutputStream out)
    throws IOException
  {
    byte[] data = getBinaryValue(b64variant);
    if (data != null)
    {
      out.write(data, 0, data.length);
      return data.length;
    }
    return 0;
  }
  
  public boolean canReadObjectId()
  {
    return _hasNativeObjectIds;
  }
  
  public boolean canReadTypeId()
  {
    return _hasNativeTypeIds;
  }
  
  public Object getTypeId()
  {
    return _segment.findTypeId(_segmentPtr);
  }
  
  public Object getObjectId()
  {
    return _segment.findObjectId(_segmentPtr);
  }
  
  protected final Object _currentObject()
  {
    return _segment.get(_segmentPtr);
  }
  
  protected final void _checkIsNumber()
    throws JsonParseException
  {
    if ((_currToken == null) || (!_currToken.isNumeric())) {
      throw _constructError("Current token (" + _currToken + ") not numeric, can not use numeric value accessors");
    }
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    _throwInternal();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer.Parser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */