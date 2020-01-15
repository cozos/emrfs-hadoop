package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class JsonGenerator
  implements Closeable, Flushable, Versioned
{
  protected PrettyPrinter _cfgPrettyPrinter;
  public abstract JsonGenerator setCodec(ObjectCodec paramObjectCodec);
  
  public abstract ObjectCodec getCodec();
  
  public abstract Version version();
  
  public abstract JsonGenerator enable(Feature paramFeature);
  
  public abstract JsonGenerator disable(Feature paramFeature);
  
  public static enum Feature
  {
    AUTO_CLOSE_TARGET(true),  AUTO_CLOSE_JSON_CONTENT(true),  FLUSH_PASSED_TO_STREAM(true),  QUOTE_FIELD_NAMES(true),  QUOTE_NON_NUMERIC_NUMBERS(true),  WRITE_NUMBERS_AS_STRINGS(false),  WRITE_BIGDECIMAL_AS_PLAIN(false),  ESCAPE_NON_ASCII(false),  STRICT_DUPLICATE_DETECTION(false),  IGNORE_UNKNOWN(false);
    
    private final boolean _defaultState;
    private final int _mask;
    
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
    
    public boolean enabledIn(int flags)
    {
      return (flags & _mask) != 0;
    }
    
    public int getMask()
    {
      return _mask;
    }
  }
  
  public final JsonGenerator configure(Feature f, boolean state)
  {
    if (state) {
      enable(f);
    } else {
      disable(f);
    }
    return this;
  }
  
  public abstract boolean isEnabled(Feature paramFeature);
  
  public abstract int getFeatureMask();
  
  public abstract JsonGenerator setFeatureMask(int paramInt);
  
  public JsonGenerator overrideStdFeatures(int values, int mask)
  {
    int oldState = getFeatureMask();
    int newState = oldState & (mask ^ 0xFFFFFFFF) | values & mask;
    return setFeatureMask(newState);
  }
  
  public int getFormatFeatures()
  {
    return 0;
  }
  
  public JsonGenerator overrideFormatFeatures(int values, int mask)
  {
    throw new IllegalArgumentException("No FormatFeatures defined for generator of type " + getClass().getName());
  }
  
  public void setSchema(FormatSchema schema)
  {
    throw new UnsupportedOperationException("Generator of type " + getClass().getName() + " does not support schema of type '" + schema.getSchemaType() + "'");
  }
  
  public FormatSchema getSchema()
  {
    return null;
  }
  
  public JsonGenerator setPrettyPrinter(PrettyPrinter pp)
  {
    _cfgPrettyPrinter = pp;
    return this;
  }
  
  public PrettyPrinter getPrettyPrinter()
  {
    return _cfgPrettyPrinter;
  }
  
  public abstract JsonGenerator useDefaultPrettyPrinter();
  
  public JsonGenerator setHighestNonEscapedChar(int charCode)
  {
    return this;
  }
  
  public int getHighestEscapedChar()
  {
    return 0;
  }
  
  public CharacterEscapes getCharacterEscapes()
  {
    return null;
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes esc)
  {
    return this;
  }
  
  public JsonGenerator setRootValueSeparator(SerializableString sep)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object getOutputTarget()
  {
    return null;
  }
  
  public int getOutputBuffered()
  {
    return -1;
  }
  
  public Object getCurrentValue()
  {
    JsonStreamContext ctxt = getOutputContext();
    return ctxt == null ? null : ctxt.getCurrentValue();
  }
  
  public void setCurrentValue(Object v)
  {
    JsonStreamContext ctxt = getOutputContext();
    if (ctxt != null) {
      ctxt.setCurrentValue(v);
    }
  }
  
  public boolean canUseSchema(FormatSchema schema)
  {
    return false;
  }
  
  public boolean canWriteObjectId()
  {
    return false;
  }
  
  public boolean canWriteTypeId()
  {
    return false;
  }
  
  public boolean canWriteBinaryNatively()
  {
    return false;
  }
  
  public boolean canOmitFields()
  {
    return true;
  }
  
  public abstract void writeStartArray()
    throws IOException;
  
  public void writeStartArray(int size)
    throws IOException
  {
    writeStartArray();
  }
  
  public abstract void writeEndArray()
    throws IOException;
  
  public abstract void writeStartObject()
    throws IOException;
  
  public abstract void writeEndObject()
    throws IOException;
  
  public abstract void writeFieldName(String paramString)
    throws IOException;
  
  public abstract void writeFieldName(SerializableString paramSerializableString)
    throws IOException;
  
  public abstract void writeString(String paramString)
    throws IOException;
  
  public abstract void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeString(SerializableString paramSerializableString)
    throws IOException;
  
  public abstract void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeRaw(String paramString)
    throws IOException;
  
  public abstract void writeRaw(String paramString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeRaw(char paramChar)
    throws IOException;
  
  public void writeRaw(SerializableString raw)
    throws IOException
  {
    writeRaw(raw.getValue());
  }
  
  public abstract void writeRawValue(String paramString)
    throws IOException;
  
  public abstract void writeRawValue(String paramString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException;
  
  public void writeRawValue(SerializableString raw)
    throws IOException
  {
    writeRawValue(raw.getValue());
  }
  
  public abstract void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public void writeBinary(byte[] data, int offset, int len)
    throws IOException
  {
    writeBinary(Base64Variants.getDefaultVariant(), data, offset, len);
  }
  
  public void writeBinary(byte[] data)
    throws IOException
  {
    writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
  }
  
  public int writeBinary(InputStream data, int dataLength)
    throws IOException
  {
    return writeBinary(Base64Variants.getDefaultVariant(), data, dataLength);
  }
  
  public abstract int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
    throws IOException;
  
  public void writeNumber(short v)
    throws IOException
  {
    writeNumber(v);
  }
  
  public abstract void writeNumber(int paramInt)
    throws IOException;
  
  public abstract void writeNumber(long paramLong)
    throws IOException;
  
  public abstract void writeNumber(BigInteger paramBigInteger)
    throws IOException;
  
  public abstract void writeNumber(double paramDouble)
    throws IOException;
  
  public abstract void writeNumber(float paramFloat)
    throws IOException;
  
  public abstract void writeNumber(BigDecimal paramBigDecimal)
    throws IOException;
  
  public abstract void writeNumber(String paramString)
    throws IOException;
  
  public abstract void writeBoolean(boolean paramBoolean)
    throws IOException;
  
  public abstract void writeNull()
    throws IOException;
  
  public void writeObjectId(Object id)
    throws IOException
  {
    throw new JsonGenerationException("No native support for writing Object Ids");
  }
  
  public void writeObjectRef(Object id)
    throws IOException
  {
    throw new JsonGenerationException("No native support for writing Object Ids");
  }
  
  public void writeTypeId(Object id)
    throws IOException
  {
    throw new JsonGenerationException("No native support for writing Type Ids");
  }
  
  public abstract void writeObject(Object paramObject)
    throws IOException;
  
  public abstract void writeTree(TreeNode paramTreeNode)
    throws IOException;
  
  public void writeStringField(String fieldName, String value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeString(value);
  }
  
  public final void writeBooleanField(String fieldName, boolean value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeBoolean(value);
  }
  
  public final void writeNullField(String fieldName)
    throws IOException
  {
    writeFieldName(fieldName);
    writeNull();
  }
  
  public final void writeNumberField(String fieldName, int value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeNumber(value);
  }
  
  public final void writeNumberField(String fieldName, long value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeNumber(value);
  }
  
  public final void writeNumberField(String fieldName, double value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeNumber(value);
  }
  
  public final void writeNumberField(String fieldName, float value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeNumber(value);
  }
  
  public final void writeNumberField(String fieldName, BigDecimal value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeNumber(value);
  }
  
  public final void writeBinaryField(String fieldName, byte[] data)
    throws IOException
  {
    writeFieldName(fieldName);
    writeBinary(data);
  }
  
  public final void writeArrayFieldStart(String fieldName)
    throws IOException
  {
    writeFieldName(fieldName);
    writeStartArray();
  }
  
  public final void writeObjectFieldStart(String fieldName)
    throws IOException
  {
    writeFieldName(fieldName);
    writeStartObject();
  }
  
  public final void writeObjectField(String fieldName, Object pojo)
    throws IOException
  {
    writeFieldName(fieldName);
    writeObject(pojo);
  }
  
  public void writeOmittedField(String fieldName)
    throws IOException
  {}
  
  public void copyCurrentEvent(JsonParser jp)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == null) {
      _reportError("No current event to copy");
    }
    switch (t.id())
    {
    case -1: 
      _reportError("No current event to copy");
    case 1: 
      writeStartObject();
      break;
    case 2: 
      writeEndObject();
      break;
    case 3: 
      writeStartArray();
      break;
    case 4: 
      writeEndArray();
      break;
    case 5: 
      writeFieldName(jp.getCurrentName());
      break;
    case 6: 
      if (jp.hasTextCharacters()) {
        writeString(jp.getTextCharacters(), jp.getTextOffset(), jp.getTextLength());
      } else {
        writeString(jp.getText());
      }
      break;
    case 7: 
      JsonParser.NumberType n = jp.getNumberType();
      if (n == JsonParser.NumberType.INT) {
        writeNumber(jp.getIntValue());
      } else if (n == JsonParser.NumberType.BIG_INTEGER) {
        writeNumber(jp.getBigIntegerValue());
      } else {
        writeNumber(jp.getLongValue());
      }
      break;
    case 8: 
      JsonParser.NumberType n = jp.getNumberType();
      if (n == JsonParser.NumberType.BIG_DECIMAL) {
        writeNumber(jp.getDecimalValue());
      } else if (n == JsonParser.NumberType.FLOAT) {
        writeNumber(jp.getFloatValue());
      } else {
        writeNumber(jp.getDoubleValue());
      }
      break;
    case 9: 
      writeBoolean(true);
      break;
    case 10: 
      writeBoolean(false);
      break;
    case 11: 
      writeNull();
      break;
    case 12: 
      writeObject(jp.getEmbeddedObject());
      break;
    case 0: 
    default: 
      _throwInternal();
    }
  }
  
  public void copyCurrentStructure(JsonParser jp)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == null) {
      _reportError("No current event to copy");
    }
    int id = t.id();
    if (id == 5)
    {
      writeFieldName(jp.getCurrentName());
      t = jp.nextToken();
      id = t.id();
    }
    switch (id)
    {
    case 1: 
      writeStartObject();
      while (jp.nextToken() != JsonToken.END_OBJECT) {
        copyCurrentStructure(jp);
      }
      writeEndObject();
      break;
    case 3: 
      writeStartArray();
      while (jp.nextToken() != JsonToken.END_ARRAY) {
        copyCurrentStructure(jp);
      }
      writeEndArray();
      break;
    default: 
      copyCurrentEvent(jp);
    }
  }
  
  public abstract JsonStreamContext getOutputContext();
  
  public abstract void flush()
    throws IOException;
  
  public abstract boolean isClosed();
  
  public abstract void close()
    throws IOException;
  
  protected void _reportError(String msg)
    throws JsonGenerationException
  {
    throw new JsonGenerationException(msg);
  }
  
  protected final void _throwInternal() {}
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Operation not supported by generator of type " + getClass().getName());
  }
  
  protected void _writeSimpleObject(Object value)
    throws IOException
  {
    if (value == null)
    {
      writeNull();
      return;
    }
    if ((value instanceof String))
    {
      writeString((String)value);
      return;
    }
    if ((value instanceof Number))
    {
      Number n = (Number)value;
      if ((n instanceof Integer))
      {
        writeNumber(n.intValue());
        return;
      }
      if ((n instanceof Long))
      {
        writeNumber(n.longValue());
        return;
      }
      if ((n instanceof Double))
      {
        writeNumber(n.doubleValue());
        return;
      }
      if ((n instanceof Float))
      {
        writeNumber(n.floatValue());
        return;
      }
      if ((n instanceof Short))
      {
        writeNumber(n.shortValue());
        return;
      }
      if ((n instanceof Byte))
      {
        writeNumber((short)n.byteValue());
        return;
      }
      if ((n instanceof BigInteger))
      {
        writeNumber((BigInteger)n);
        return;
      }
      if ((n instanceof BigDecimal))
      {
        writeNumber((BigDecimal)n);
        return;
      }
      if ((n instanceof AtomicInteger))
      {
        writeNumber(((AtomicInteger)n).get());
        return;
      }
      if ((n instanceof AtomicLong))
      {
        writeNumber(((AtomicLong)n).get());
        return;
      }
    }
    else
    {
      if ((value instanceof byte[]))
      {
        writeBinary((byte[])value);
        return;
      }
      if ((value instanceof Boolean))
      {
        writeBoolean(((Boolean)value).booleanValue());
        return;
      }
      if ((value instanceof AtomicBoolean))
      {
        writeBoolean(((AtomicBoolean)value).get());
        return;
      }
    }
    throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + value.getClass().getName() + ")");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */