package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonReadContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonWriteContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

public class TokenBuffer
  extends JsonGenerator
{
  protected static final int DEFAULT_GENERATOR_FEATURES = ;
  protected ObjectCodec _objectCodec;
  protected int _generatorFeatures;
  protected boolean _closed;
  protected boolean _hasNativeTypeIds;
  protected boolean _hasNativeObjectIds;
  protected boolean _mayHaveNativeIds;
  protected boolean _forceBigDecimal;
  protected Segment _first;
  protected Segment _last;
  protected int _appendAt;
  protected Object _typeId;
  protected Object _objectId;
  protected boolean _hasNativeId = false;
  protected JsonWriteContext _writeContext;
  
  @Deprecated
  public TokenBuffer(ObjectCodec codec)
  {
    this(codec, false);
  }
  
  public TokenBuffer(ObjectCodec codec, boolean hasNativeIds)
  {
    _objectCodec = codec;
    _generatorFeatures = DEFAULT_GENERATOR_FEATURES;
    _writeContext = JsonWriteContext.createRootContext(null);
    
    _first = (_last = new Segment());
    _appendAt = 0;
    _hasNativeTypeIds = hasNativeIds;
    _hasNativeObjectIds = hasNativeIds;
    
    _mayHaveNativeIds = (_hasNativeTypeIds | _hasNativeObjectIds);
  }
  
  public TokenBuffer(JsonParser p)
  {
    this(p, null);
  }
  
  public TokenBuffer(JsonParser p, DeserializationContext ctxt)
  {
    _objectCodec = p.getCodec();
    _generatorFeatures = DEFAULT_GENERATOR_FEATURES;
    _writeContext = JsonWriteContext.createRootContext(null);
    
    _first = (_last = new Segment());
    _appendAt = 0;
    _hasNativeTypeIds = p.canReadTypeId();
    _hasNativeObjectIds = p.canReadObjectId();
    _mayHaveNativeIds = (_hasNativeTypeIds | _hasNativeObjectIds);
    _forceBigDecimal = (ctxt == null ? false : ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS));
  }
  
  public TokenBuffer forceUseOfBigDecimal(boolean b)
  {
    _forceBigDecimal = b;
    return this;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public JsonParser asParser()
  {
    return asParser(_objectCodec);
  }
  
  public JsonParser asParser(ObjectCodec codec)
  {
    return new Parser(_first, codec, _hasNativeTypeIds, _hasNativeObjectIds);
  }
  
  public JsonParser asParser(JsonParser src)
  {
    Parser p = new Parser(_first, src.getCodec(), _hasNativeTypeIds, _hasNativeObjectIds);
    p.setLocation(src.getTokenLocation());
    return p;
  }
  
  public JsonToken firstToken()
  {
    if (_first != null) {
      return _first.type(0);
    }
    return null;
  }
  
  public TokenBuffer append(TokenBuffer other)
    throws IOException
  {
    if (!_hasNativeTypeIds) {
      _hasNativeTypeIds = other.canWriteTypeId();
    }
    if (!_hasNativeObjectIds) {
      _hasNativeObjectIds = other.canWriteObjectId();
    }
    _mayHaveNativeIds = (_hasNativeTypeIds | _hasNativeObjectIds);
    
    JsonParser p = other.asParser();
    while (p.nextToken() != null) {
      copyCurrentStructure(p);
    }
    return this;
  }
  
  public void serialize(JsonGenerator gen)
    throws IOException
  {
    Segment segment = _first;
    int ptr = -1;
    
    boolean checkIds = _mayHaveNativeIds;
    boolean hasIds = (checkIds) && (segment.hasIds());
    for (;;)
    {
      ptr++;
      if (ptr >= 16)
      {
        ptr = 0;
        segment = segment.next();
        if (segment == null) {
          break;
        }
        hasIds = (checkIds) && (segment.hasIds());
      }
      JsonToken t = segment.type(ptr);
      if (t == null) {
        break;
      }
      if (hasIds)
      {
        Object id = segment.findObjectId(ptr);
        if (id != null) {
          gen.writeObjectId(id);
        }
        id = segment.findTypeId(ptr);
        if (id != null) {
          gen.writeTypeId(id);
        }
      }
      switch (t)
      {
      case START_OBJECT: 
        gen.writeStartObject();
        break;
      case END_OBJECT: 
        gen.writeEndObject();
        break;
      case START_ARRAY: 
        gen.writeStartArray();
        break;
      case END_ARRAY: 
        gen.writeEndArray();
        break;
      case FIELD_NAME: 
        Object ob = segment.get(ptr);
        if ((ob instanceof SerializableString)) {
          gen.writeFieldName((SerializableString)ob);
        } else {
          gen.writeFieldName((String)ob);
        }
        break;
      case VALUE_STRING: 
        Object ob = segment.get(ptr);
        if ((ob instanceof SerializableString)) {
          gen.writeString((SerializableString)ob);
        } else {
          gen.writeString((String)ob);
        }
        break;
      case VALUE_NUMBER_INT: 
        Object n = segment.get(ptr);
        if ((n instanceof Integer)) {
          gen.writeNumber(((Integer)n).intValue());
        } else if ((n instanceof BigInteger)) {
          gen.writeNumber((BigInteger)n);
        } else if ((n instanceof Long)) {
          gen.writeNumber(((Long)n).longValue());
        } else if ((n instanceof Short)) {
          gen.writeNumber(((Short)n).shortValue());
        } else {
          gen.writeNumber(((Number)n).intValue());
        }
        break;
      case VALUE_NUMBER_FLOAT: 
        Object n = segment.get(ptr);
        if ((n instanceof Double)) {
          gen.writeNumber(((Double)n).doubleValue());
        } else if ((n instanceof BigDecimal)) {
          gen.writeNumber((BigDecimal)n);
        } else if ((n instanceof Float)) {
          gen.writeNumber(((Float)n).floatValue());
        } else if (n == null) {
          gen.writeNull();
        } else if ((n instanceof String)) {
          gen.writeNumber((String)n);
        } else {
          throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + n.getClass().getName() + ", can not serialize");
        }
        break;
      case VALUE_TRUE: 
        gen.writeBoolean(true);
        break;
      case VALUE_FALSE: 
        gen.writeBoolean(false);
        break;
      case VALUE_NULL: 
        gen.writeNull();
        break;
      case VALUE_EMBEDDED_OBJECT: 
        Object value = segment.get(ptr);
        if ((value instanceof RawValue)) {
          ((RawValue)value).serialize(gen);
        } else {
          gen.writeObject(value);
        }
        break;
      default: 
        throw new RuntimeException("Internal error: should never end up through this code path");
      }
    }
  }
  
  public TokenBuffer deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.getCurrentTokenId() != JsonToken.FIELD_NAME.id())
    {
      copyCurrentStructure(p);
      return this;
    }
    writeStartObject();
    JsonToken t;
    do
    {
      copyCurrentStructure(p);
    } while ((t = p.nextToken()) == JsonToken.FIELD_NAME);
    if (t != JsonToken.END_OBJECT) {
      throw ctxt.mappingException("Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + t);
    }
    writeEndObject();
    return this;
  }
  
  public String toString()
  {
    int MAX_COUNT = 100;
    
    StringBuilder sb = new StringBuilder();
    sb.append("[TokenBuffer: ");
    
    JsonParser jp = asParser();
    int count = 0;
    boolean hasNativeIds = (_hasNativeTypeIds) || (_hasNativeObjectIds);
    for (;;)
    {
      try
      {
        JsonToken t = jp.nextToken();
        if (t == null) {
          break;
        }
        if (hasNativeIds) {
          _appendNativeIds(sb);
        }
        if (count < 100)
        {
          if (count > 0) {
            sb.append(", ");
          }
          sb.append(t.toString());
          if (t == JsonToken.FIELD_NAME)
          {
            sb.append('(');
            sb.append(jp.getCurrentName());
            sb.append(')');
          }
        }
      }
      catch (IOException ioe)
      {
        throw new IllegalStateException(ioe);
      }
      count++;
    }
    if (count >= 100) {
      sb.append(" ... (truncated ").append(count - 100).append(" entries)");
    }
    sb.append(']');
    return sb.toString();
  }
  
  private final void _appendNativeIds(StringBuilder sb)
  {
    Object objectId = _last.findObjectId(_appendAt - 1);
    if (objectId != null) {
      sb.append("[objectId=").append(String.valueOf(objectId)).append(']');
    }
    Object typeId = _last.findTypeId(_appendAt - 1);
    if (typeId != null) {
      sb.append("[typeId=").append(String.valueOf(typeId)).append(']');
    }
  }
  
  public JsonGenerator enable(JsonGenerator.Feature f)
  {
    _generatorFeatures |= f.getMask();
    return this;
  }
  
  public JsonGenerator disable(JsonGenerator.Feature f)
  {
    _generatorFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public boolean isEnabled(JsonGenerator.Feature f)
  {
    return (_generatorFeatures & f.getMask()) != 0;
  }
  
  public int getFeatureMask()
  {
    return _generatorFeatures;
  }
  
  public JsonGenerator setFeatureMask(int mask)
  {
    _generatorFeatures = mask;
    return this;
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    return this;
  }
  
  public JsonGenerator setCodec(ObjectCodec oc)
  {
    _objectCodec = oc;
    return this;
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public final JsonWriteContext getOutputContext()
  {
    return _writeContext;
  }
  
  public boolean canWriteBinaryNatively()
  {
    return true;
  }
  
  public void flush()
    throws IOException
  {}
  
  public void close()
    throws IOException
  {
    _closed = true;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public final void writeStartArray()
    throws IOException
  {
    _append(JsonToken.START_ARRAY);
    _writeContext = _writeContext.createChildArrayContext();
  }
  
  public final void writeEndArray()
    throws IOException
  {
    _append(JsonToken.END_ARRAY);
    
    JsonWriteContext c = _writeContext.getParent();
    if (c != null) {
      _writeContext = c;
    }
  }
  
  public final void writeStartObject()
    throws IOException
  {
    _append(JsonToken.START_OBJECT);
    _writeContext = _writeContext.createChildObjectContext();
  }
  
  public final void writeEndObject()
    throws IOException
  {
    _append(JsonToken.END_OBJECT);
    
    JsonWriteContext c = _writeContext.getParent();
    if (c != null) {
      _writeContext = c;
    }
  }
  
  public final void writeFieldName(String name)
    throws IOException
  {
    _append(JsonToken.FIELD_NAME, name);
    _writeContext.writeFieldName(name);
  }
  
  public void writeFieldName(SerializableString name)
    throws IOException
  {
    _append(JsonToken.FIELD_NAME, name);
    _writeContext.writeFieldName(name.getValue());
  }
  
  public void writeString(String text)
    throws IOException
  {
    if (text == null) {
      writeNull();
    } else {
      _appendValue(JsonToken.VALUE_STRING, text);
    }
  }
  
  public void writeString(char[] text, int offset, int len)
    throws IOException
  {
    writeString(new String(text, offset, len));
  }
  
  public void writeString(SerializableString text)
    throws IOException
  {
    if (text == null) {
      writeNull();
    } else {
      _appendValue(JsonToken.VALUE_STRING, text);
    }
  }
  
  public void writeRawUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String text)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String text, int offset, int len)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(SerializableString text)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(char[] text, int offset, int len)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(char c)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawValue(String text)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, new RawValue(text));
  }
  
  public void writeRawValue(String text, int offset, int len)
    throws IOException
  {
    if ((offset > 0) || (len != text.length())) {
      text = text.substring(offset, offset + len);
    }
    _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, new RawValue(text));
  }
  
  public void writeRawValue(char[] text, int offset, int len)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, new String(text, offset, len));
  }
  
  public void writeNumber(short i)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NUMBER_INT, Short.valueOf(i));
  }
  
  public void writeNumber(int i)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
  }
  
  public void writeNumber(long l)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NUMBER_INT, Long.valueOf(l));
  }
  
  public void writeNumber(double d)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
  }
  
  public void writeNumber(float f)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
  }
  
  public void writeNumber(BigDecimal dec)
    throws IOException
  {
    if (dec == null) {
      writeNull();
    } else {
      _appendValue(JsonToken.VALUE_NUMBER_FLOAT, dec);
    }
  }
  
  public void writeNumber(BigInteger v)
    throws IOException
  {
    if (v == null) {
      writeNull();
    } else {
      _appendValue(JsonToken.VALUE_NUMBER_INT, v);
    }
  }
  
  public void writeNumber(String encodedValue)
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NUMBER_FLOAT, encodedValue);
  }
  
  public void writeBoolean(boolean state)
    throws IOException
  {
    _appendValue(state ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
  }
  
  public void writeNull()
    throws IOException
  {
    _appendValue(JsonToken.VALUE_NULL);
  }
  
  public void writeObject(Object value)
    throws IOException
  {
    if (value == null)
    {
      writeNull();
      return;
    }
    Class<?> raw = value.getClass();
    if ((raw == byte[].class) || ((value instanceof RawValue)))
    {
      _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, value);
      return;
    }
    if (_objectCodec == null) {
      _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, value);
    } else {
      _objectCodec.writeValue(this, value);
    }
  }
  
  public void writeTree(TreeNode node)
    throws IOException
  {
    if (node == null)
    {
      writeNull();
      return;
    }
    if (_objectCodec == null) {
      _appendValue(JsonToken.VALUE_EMBEDDED_OBJECT, node);
    } else {
      _objectCodec.writeTree(this, node);
    }
  }
  
  public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len)
    throws IOException
  {
    byte[] copy = new byte[len];
    System.arraycopy(data, offset, copy, 0, len);
    writeObject(copy);
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean canWriteTypeId()
  {
    return _hasNativeTypeIds;
  }
  
  public boolean canWriteObjectId()
  {
    return _hasNativeObjectIds;
  }
  
  public void writeTypeId(Object id)
  {
    _typeId = id;
    _hasNativeId = true;
  }
  
  public void writeObjectId(Object id)
  {
    _objectId = id;
    _hasNativeId = true;
  }
  
  public void copyCurrentEvent(JsonParser p)
    throws IOException
  {
    if (_mayHaveNativeIds) {
      _checkNativeIds(p);
    }
    switch (p.getCurrentToken())
    {
    case START_OBJECT: 
      writeStartObject();
      break;
    case END_OBJECT: 
      writeEndObject();
      break;
    case START_ARRAY: 
      writeStartArray();
      break;
    case END_ARRAY: 
      writeEndArray();
      break;
    case FIELD_NAME: 
      writeFieldName(p.getCurrentName());
      break;
    case VALUE_STRING: 
      if (p.hasTextCharacters()) {
        writeString(p.getTextCharacters(), p.getTextOffset(), p.getTextLength());
      } else {
        writeString(p.getText());
      }
      break;
    case VALUE_NUMBER_INT: 
      switch (p.getNumberType())
      {
      case INT: 
        writeNumber(p.getIntValue());
        break;
      case BIG_INTEGER: 
        writeNumber(p.getBigIntegerValue());
        break;
      default: 
        writeNumber(p.getLongValue());
      }
      break;
    case VALUE_NUMBER_FLOAT: 
      if (_forceBigDecimal) {
        writeNumber(p.getDecimalValue());
      } else {
        switch (p.getNumberType())
        {
        case BIG_DECIMAL: 
          writeNumber(p.getDecimalValue());
          break;
        case FLOAT: 
          writeNumber(p.getFloatValue());
          break;
        default: 
          writeNumber(p.getDoubleValue());
        }
      }
      break;
    case VALUE_TRUE: 
      writeBoolean(true);
      break;
    case VALUE_FALSE: 
      writeBoolean(false);
      break;
    case VALUE_NULL: 
      writeNull();
      break;
    case VALUE_EMBEDDED_OBJECT: 
      writeObject(p.getEmbeddedObject());
      break;
    default: 
      throw new RuntimeException("Internal error: should never end up through this code path");
    }
  }
  
  public void copyCurrentStructure(JsonParser jp)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.FIELD_NAME)
    {
      if (_mayHaveNativeIds) {
        _checkNativeIds(jp);
      }
      writeFieldName(jp.getCurrentName());
      t = jp.nextToken();
    }
    if (_mayHaveNativeIds) {
      _checkNativeIds(jp);
    }
    switch (t)
    {
    case START_ARRAY: 
      writeStartArray();
      while (jp.nextToken() != JsonToken.END_ARRAY) {
        copyCurrentStructure(jp);
      }
      writeEndArray();
      break;
    case START_OBJECT: 
      writeStartObject();
      while (jp.nextToken() != JsonToken.END_OBJECT) {
        copyCurrentStructure(jp);
      }
      writeEndObject();
      break;
    default: 
      copyCurrentEvent(jp);
    }
  }
  
  private final void _checkNativeIds(JsonParser jp)
    throws IOException
  {
    if ((_typeId = jp.getTypeId()) != null) {
      _hasNativeId = true;
    }
    if ((_objectId = jp.getObjectId()) != null) {
      _hasNativeId = true;
    }
  }
  
  protected final void _append(JsonToken type)
  {
    Segment next = _hasNativeId ? _last.append(_appendAt, type, _objectId, _typeId) : _last.append(_appendAt, type);
    if (next == null)
    {
      _appendAt += 1;
    }
    else
    {
      _last = next;
      _appendAt = 1;
    }
  }
  
  protected final void _append(JsonToken type, Object value)
  {
    Segment next = _hasNativeId ? _last.append(_appendAt, type, value, _objectId, _typeId) : _last.append(_appendAt, type, value);
    if (next == null)
    {
      _appendAt += 1;
    }
    else
    {
      _last = next;
      _appendAt = 1;
    }
  }
  
  protected final void _appendValue(JsonToken type)
  {
    _writeContext.writeValue();
    Segment next = _hasNativeId ? _last.append(_appendAt, type, _objectId, _typeId) : _last.append(_appendAt, type);
    if (next == null)
    {
      _appendAt += 1;
    }
    else
    {
      _last = next;
      _appendAt = 1;
    }
  }
  
  protected final void _appendValue(JsonToken type, Object value)
  {
    _writeContext.writeValue();
    Segment next = _hasNativeId ? _last.append(_appendAt, type, value, _objectId, _typeId) : _last.append(_appendAt, type, value);
    if (next == null)
    {
      _appendAt += 1;
    }
    else
    {
      _last = next;
      _appendAt = 1;
    }
  }
  
  protected final void _appendRaw(int rawType, Object value)
  {
    Segment next = _hasNativeId ? _last.appendRaw(_appendAt, rawType, value, _objectId, _typeId) : _last.appendRaw(_appendAt, rawType, value);
    if (next == null)
    {
      _appendAt += 1;
    }
    else
    {
      _last = next;
      _appendAt = 1;
    }
  }
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
  }
  
  protected static final class Parser
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
    
    public Parser(TokenBuffer.Segment firstSeg, ObjectCodec codec, boolean hasNativeTypeIds, boolean hasNativeObjectIds)
    {
      super();
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
  
  protected static final class Segment
  {
    public static final int TOKENS_PER_SEGMENT = 16;
    private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
    protected Segment _next;
    protected long _tokenTypes;
    
    static
    {
      JsonToken[] t = JsonToken.values();
      
      System.arraycopy(t, 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, t.length - 1));
    }
    
    protected final Object[] _tokens = new Object[16];
    protected TreeMap<Integer, Object> _nativeIds;
    
    public JsonToken type(int index)
    {
      long l = _tokenTypes;
      if (index > 0) {
        l >>= index << 2;
      }
      int ix = (int)l & 0xF;
      return TOKEN_TYPES_BY_INDEX[ix];
    }
    
    public int rawType(int index)
    {
      long l = _tokenTypes;
      if (index > 0) {
        l >>= index << 2;
      }
      int ix = (int)l & 0xF;
      return ix;
    }
    
    public Object get(int index)
    {
      return _tokens[index];
    }
    
    public Segment next()
    {
      return _next;
    }
    
    public boolean hasIds()
    {
      return _nativeIds != null;
    }
    
    public Segment append(int index, JsonToken tokenType)
    {
      if (index < 16)
      {
        set(index, tokenType);
        return null;
      }
      _next = new Segment();
      _next.set(0, tokenType);
      return _next;
    }
    
    public Segment append(int index, JsonToken tokenType, Object objectId, Object typeId)
    {
      if (index < 16)
      {
        set(index, tokenType, objectId, typeId);
        return null;
      }
      _next = new Segment();
      _next.set(0, tokenType, objectId, typeId);
      return _next;
    }
    
    public Segment append(int index, JsonToken tokenType, Object value)
    {
      if (index < 16)
      {
        set(index, tokenType, value);
        return null;
      }
      _next = new Segment();
      _next.set(0, tokenType, value);
      return _next;
    }
    
    public Segment append(int index, JsonToken tokenType, Object value, Object objectId, Object typeId)
    {
      if (index < 16)
      {
        set(index, tokenType, value, objectId, typeId);
        return null;
      }
      _next = new Segment();
      _next.set(0, tokenType, value, objectId, typeId);
      return _next;
    }
    
    public Segment appendRaw(int index, int rawTokenType, Object value)
    {
      if (index < 16)
      {
        set(index, rawTokenType, value);
        return null;
      }
      _next = new Segment();
      _next.set(0, rawTokenType, value);
      return _next;
    }
    
    public Segment appendRaw(int index, int rawTokenType, Object value, Object objectId, Object typeId)
    {
      if (index < 16)
      {
        set(index, rawTokenType, value, objectId, typeId);
        return null;
      }
      _next = new Segment();
      _next.set(0, rawTokenType, value, objectId, typeId);
      return _next;
    }
    
    private void set(int index, JsonToken tokenType)
    {
      long typeCode = tokenType.ordinal();
      if (index > 0) {
        typeCode <<= index << 2;
      }
      _tokenTypes |= typeCode;
    }
    
    private void set(int index, JsonToken tokenType, Object objectId, Object typeId)
    {
      long typeCode = tokenType.ordinal();
      if (index > 0) {
        typeCode <<= index << 2;
      }
      _tokenTypes |= typeCode;
      assignNativeIds(index, objectId, typeId);
    }
    
    private void set(int index, JsonToken tokenType, Object value)
    {
      _tokens[index] = value;
      long typeCode = tokenType.ordinal();
      if (index > 0) {
        typeCode <<= index << 2;
      }
      _tokenTypes |= typeCode;
    }
    
    private void set(int index, JsonToken tokenType, Object value, Object objectId, Object typeId)
    {
      _tokens[index] = value;
      long typeCode = tokenType.ordinal();
      if (index > 0) {
        typeCode <<= index << 2;
      }
      _tokenTypes |= typeCode;
      assignNativeIds(index, objectId, typeId);
    }
    
    private void set(int index, int rawTokenType, Object value)
    {
      _tokens[index] = value;
      long typeCode = rawTokenType;
      if (index > 0) {
        typeCode <<= index << 2;
      }
      _tokenTypes |= typeCode;
    }
    
    private void set(int index, int rawTokenType, Object value, Object objectId, Object typeId)
    {
      _tokens[index] = value;
      long typeCode = rawTokenType;
      if (index > 0) {
        typeCode <<= index << 2;
      }
      _tokenTypes |= typeCode;
      assignNativeIds(index, objectId, typeId);
    }
    
    private final void assignNativeIds(int index, Object objectId, Object typeId)
    {
      if (_nativeIds == null) {
        _nativeIds = new TreeMap();
      }
      if (objectId != null) {
        _nativeIds.put(Integer.valueOf(_objectIdIndex(index)), objectId);
      }
      if (typeId != null) {
        _nativeIds.put(Integer.valueOf(_typeIdIndex(index)), typeId);
      }
    }
    
    public Object findObjectId(int index)
    {
      return _nativeIds == null ? null : _nativeIds.get(Integer.valueOf(_objectIdIndex(index)));
    }
    
    public Object findTypeId(int index)
    {
      return _nativeIds == null ? null : _nativeIds.get(Integer.valueOf(_typeIdIndex(index)));
    }
    
    private final int _typeIdIndex(int i)
    {
      return i + i;
    }
    
    private final int _objectIdIndex(int i)
    {
      return i + i + 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */