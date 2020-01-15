package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

public abstract class JsonParser
  implements Closeable, Versioned
{
  private static final int MIN_BYTE_I = -128;
  private static final int MAX_BYTE_I = 255;
  private static final int MIN_SHORT_I = -32768;
  private static final int MAX_SHORT_I = 32767;
  protected int _features;
  protected JsonParser() {}
  
  public static enum NumberType
  {
    INT,  LONG,  BIG_INTEGER,  FLOAT,  DOUBLE,  BIG_DECIMAL;
    
    private NumberType() {}
  }
  
  public static enum Feature
  {
    AUTO_CLOSE_SOURCE(true),  ALLOW_COMMENTS(false),  ALLOW_YAML_COMMENTS(false),  ALLOW_UNQUOTED_FIELD_NAMES(false),  ALLOW_SINGLE_QUOTES(false),  ALLOW_UNQUOTED_CONTROL_CHARS(false),  ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),  ALLOW_NUMERIC_LEADING_ZEROS(false),  ALLOW_NON_NUMERIC_NUMBERS(false),  STRICT_DUPLICATE_DETECTION(false),  IGNORE_UNDEFINED(false);
    
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
      _mask = (1 << ordinal());
      _defaultState = defaultState;
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
  
  protected JsonParser(int features)
  {
    _features = features;
  }
  
  public abstract ObjectCodec getCodec();
  
  public abstract void setCodec(ObjectCodec paramObjectCodec);
  
  public Object getInputSource()
  {
    return null;
  }
  
  public Object getCurrentValue()
  {
    JsonStreamContext ctxt = getParsingContext();
    return ctxt == null ? null : ctxt.getCurrentValue();
  }
  
  public void setCurrentValue(Object v)
  {
    JsonStreamContext ctxt = getParsingContext();
    if (ctxt != null) {
      ctxt.setCurrentValue(v);
    }
  }
  
  public void setSchema(FormatSchema schema)
  {
    throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + schema.getSchemaType() + "'");
  }
  
  public FormatSchema getSchema()
  {
    return null;
  }
  
  public boolean canUseSchema(FormatSchema schema)
  {
    return false;
  }
  
  public boolean requiresCustomCodec()
  {
    return false;
  }
  
  public abstract Version version();
  
  public abstract void close()
    throws IOException;
  
  public int releaseBuffered(OutputStream out)
    throws IOException
  {
    return -1;
  }
  
  public int releaseBuffered(Writer w)
    throws IOException
  {
    return -1;
  }
  
  public JsonParser enable(Feature f)
  {
    _features |= f.getMask();
    return this;
  }
  
  public JsonParser disable(Feature f)
  {
    _features &= (f.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public JsonParser configure(Feature f, boolean state)
  {
    if (state) {
      enable(f);
    } else {
      disable(f);
    }
    return this;
  }
  
  public boolean isEnabled(Feature f)
  {
    return f.enabledIn(_features);
  }
  
  public int getFeatureMask()
  {
    return _features;
  }
  
  public JsonParser setFeatureMask(int mask)
  {
    _features = mask;
    return this;
  }
  
  public JsonParser overrideStdFeatures(int values, int mask)
  {
    _features = (_features & (mask ^ 0xFFFFFFFF) | values & mask);
    return this;
  }
  
  public int getFormatFeatures()
  {
    return 0;
  }
  
  public JsonParser overrideFormatFeatures(int values, int mask)
  {
    throw new IllegalArgumentException("No FormatFeatures defined for parser of type " + getClass().getName());
  }
  
  public abstract JsonToken nextToken()
    throws IOException, JsonParseException;
  
  public abstract JsonToken nextValue()
    throws IOException, JsonParseException;
  
  public boolean nextFieldName(SerializableString str)
    throws IOException, JsonParseException
  {
    return (nextToken() == JsonToken.FIELD_NAME) && (str.getValue().equals(getCurrentName()));
  }
  
  public String nextFieldName()
    throws IOException, JsonParseException
  {
    return nextToken() == JsonToken.FIELD_NAME ? getCurrentName() : null;
  }
  
  public String nextTextValue()
    throws IOException, JsonParseException
  {
    return nextToken() == JsonToken.VALUE_STRING ? getText() : null;
  }
  
  public int nextIntValue(int defaultValue)
    throws IOException, JsonParseException
  {
    return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : defaultValue;
  }
  
  public long nextLongValue(long defaultValue)
    throws IOException, JsonParseException
  {
    return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : defaultValue;
  }
  
  public Boolean nextBooleanValue()
    throws IOException, JsonParseException
  {
    JsonToken t = nextToken();
    if (t == JsonToken.VALUE_TRUE) {
      return Boolean.TRUE;
    }
    if (t == JsonToken.VALUE_FALSE) {
      return Boolean.FALSE;
    }
    return null;
  }
  
  public abstract JsonParser skipChildren()
    throws IOException, JsonParseException;
  
  public abstract boolean isClosed();
  
  public abstract JsonToken getCurrentToken();
  
  public abstract int getCurrentTokenId();
  
  public abstract boolean hasCurrentToken();
  
  public abstract boolean hasTokenId(int paramInt);
  
  public abstract boolean hasToken(JsonToken paramJsonToken);
  
  public abstract String getCurrentName()
    throws IOException;
  
  public abstract JsonStreamContext getParsingContext();
  
  public abstract JsonLocation getTokenLocation();
  
  public abstract JsonLocation getCurrentLocation();
  
  public boolean isExpectedStartArrayToken()
  {
    return getCurrentToken() == JsonToken.START_ARRAY;
  }
  
  public boolean isExpectedStartObjectToken()
  {
    return getCurrentToken() == JsonToken.START_OBJECT;
  }
  
  public abstract void clearCurrentToken();
  
  public abstract JsonToken getLastClearedToken();
  
  public abstract void overrideCurrentName(String paramString);
  
  public abstract String getText()
    throws IOException;
  
  public abstract char[] getTextCharacters()
    throws IOException;
  
  public abstract int getTextLength()
    throws IOException;
  
  public abstract int getTextOffset()
    throws IOException;
  
  public abstract boolean hasTextCharacters();
  
  public abstract Number getNumberValue()
    throws IOException;
  
  public abstract NumberType getNumberType()
    throws IOException;
  
  public byte getByteValue()
    throws IOException
  {
    int value = getIntValue();
    if ((value < -128) || (value > 255)) {
      throw _constructError("Numeric value (" + getText() + ") out of range of Java byte");
    }
    return (byte)value;
  }
  
  public short getShortValue()
    throws IOException
  {
    int value = getIntValue();
    if ((value < 32768) || (value > 32767)) {
      throw _constructError("Numeric value (" + getText() + ") out of range of Java short");
    }
    return (short)value;
  }
  
  public abstract int getIntValue()
    throws IOException;
  
  public abstract long getLongValue()
    throws IOException;
  
  public abstract BigInteger getBigIntegerValue()
    throws IOException;
  
  public abstract float getFloatValue()
    throws IOException;
  
  public abstract double getDoubleValue()
    throws IOException;
  
  public abstract BigDecimal getDecimalValue()
    throws IOException;
  
  public boolean getBooleanValue()
    throws IOException
  {
    JsonToken t = getCurrentToken();
    if (t == JsonToken.VALUE_TRUE) {
      return true;
    }
    if (t == JsonToken.VALUE_FALSE) {
      return false;
    }
    throw new JsonParseException("Current token (" + t + ") not of boolean type", getCurrentLocation());
  }
  
  public abstract Object getEmbeddedObject()
    throws IOException;
  
  public abstract byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException;
  
  public byte[] getBinaryValue()
    throws IOException
  {
    return getBinaryValue(Base64Variants.getDefaultVariant());
  }
  
  public int readBinaryValue(OutputStream out)
    throws IOException
  {
    return readBinaryValue(Base64Variants.getDefaultVariant(), out);
  }
  
  public int readBinaryValue(Base64Variant bv, OutputStream out)
    throws IOException
  {
    _reportUnsupportedOperation();
    return 0;
  }
  
  public int getValueAsInt()
    throws IOException
  {
    return getValueAsInt(0);
  }
  
  public int getValueAsInt(int def)
    throws IOException
  {
    return def;
  }
  
  public long getValueAsLong()
    throws IOException
  {
    return getValueAsLong(0L);
  }
  
  public long getValueAsLong(long def)
    throws IOException
  {
    return def;
  }
  
  public double getValueAsDouble()
    throws IOException
  {
    return getValueAsDouble(0.0D);
  }
  
  public double getValueAsDouble(double def)
    throws IOException
  {
    return def;
  }
  
  public boolean getValueAsBoolean()
    throws IOException
  {
    return getValueAsBoolean(false);
  }
  
  public boolean getValueAsBoolean(boolean def)
    throws IOException
  {
    return def;
  }
  
  public String getValueAsString()
    throws IOException
  {
    return getValueAsString(null);
  }
  
  public abstract String getValueAsString(String paramString)
    throws IOException;
  
  public boolean canReadObjectId()
  {
    return false;
  }
  
  public boolean canReadTypeId()
  {
    return false;
  }
  
  public Object getObjectId()
    throws IOException
  {
    return null;
  }
  
  public Object getTypeId()
    throws IOException
  {
    return null;
  }
  
  public <T> T readValueAs(Class<T> valueType)
    throws IOException
  {
    return (T)_codec().readValue(this, valueType);
  }
  
  public <T> T readValueAs(TypeReference<?> valueTypeRef)
    throws IOException
  {
    return (T)_codec().readValue(this, valueTypeRef);
  }
  
  public <T> Iterator<T> readValuesAs(Class<T> valueType)
    throws IOException
  {
    return _codec().readValues(this, valueType);
  }
  
  public <T> Iterator<T> readValuesAs(TypeReference<?> valueTypeRef)
    throws IOException
  {
    return _codec().readValues(this, valueTypeRef);
  }
  
  public <T extends TreeNode> T readValueAsTree()
    throws IOException
  {
    return _codec().readTree(this);
  }
  
  protected ObjectCodec _codec()
  {
    ObjectCodec c = getCodec();
    if (c == null) {
      throw new IllegalStateException("No ObjectCodec defined for parser, needed for deserialization");
    }
    return c;
  }
  
  protected JsonParseException _constructError(String msg)
  {
    return new JsonParseException(msg, getCurrentLocation());
  }
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Operation not supported by parser of type " + getClass().getName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */