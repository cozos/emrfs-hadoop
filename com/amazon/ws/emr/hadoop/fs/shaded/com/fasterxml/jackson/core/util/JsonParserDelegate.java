package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonParserDelegate
  extends JsonParser
{
  protected JsonParser delegate;
  
  public JsonParserDelegate(JsonParser d)
  {
    delegate = d;
  }
  
  public Object getCurrentValue()
  {
    return delegate.getCurrentValue();
  }
  
  public void setCurrentValue(Object v)
  {
    delegate.setCurrentValue(v);
  }
  
  public void setCodec(ObjectCodec c)
  {
    delegate.setCodec(c);
  }
  
  public ObjectCodec getCodec()
  {
    return delegate.getCodec();
  }
  
  public JsonParser enable(JsonParser.Feature f)
  {
    delegate.enable(f);
    return this;
  }
  
  public JsonParser disable(JsonParser.Feature f)
  {
    delegate.disable(f);
    return this;
  }
  
  public boolean isEnabled(JsonParser.Feature f)
  {
    return delegate.isEnabled(f);
  }
  
  public int getFeatureMask()
  {
    return delegate.getFeatureMask();
  }
  
  public JsonParser setFeatureMask(int mask)
  {
    delegate.setFeatureMask(mask);
    return this;
  }
  
  public FormatSchema getSchema()
  {
    return delegate.getSchema();
  }
  
  public void setSchema(FormatSchema schema)
  {
    delegate.setSchema(schema);
  }
  
  public boolean canUseSchema(FormatSchema schema)
  {
    return delegate.canUseSchema(schema);
  }
  
  public Version version()
  {
    return delegate.version();
  }
  
  public Object getInputSource()
  {
    return delegate.getInputSource();
  }
  
  public boolean requiresCustomCodec()
  {
    return delegate.requiresCustomCodec();
  }
  
  public void close()
    throws IOException
  {
    delegate.close();
  }
  
  public boolean isClosed()
  {
    return delegate.isClosed();
  }
  
  public JsonToken getCurrentToken()
  {
    return delegate.getCurrentToken();
  }
  
  public int getCurrentTokenId()
  {
    return delegate.getCurrentTokenId();
  }
  
  public boolean hasCurrentToken()
  {
    return delegate.hasCurrentToken();
  }
  
  public boolean hasTokenId(int id)
  {
    return delegate.hasTokenId(id);
  }
  
  public boolean hasToken(JsonToken t)
  {
    return delegate.hasToken(t);
  }
  
  public String getCurrentName()
    throws IOException
  {
    return delegate.getCurrentName();
  }
  
  public JsonLocation getCurrentLocation()
  {
    return delegate.getCurrentLocation();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return delegate.getParsingContext();
  }
  
  public boolean isExpectedStartArrayToken()
  {
    return delegate.isExpectedStartArrayToken();
  }
  
  public boolean isExpectedStartObjectToken()
  {
    return delegate.isExpectedStartObjectToken();
  }
  
  public void clearCurrentToken()
  {
    delegate.clearCurrentToken();
  }
  
  public JsonToken getLastClearedToken()
  {
    return delegate.getLastClearedToken();
  }
  
  public void overrideCurrentName(String name)
  {
    delegate.overrideCurrentName(name);
  }
  
  public String getText()
    throws IOException
  {
    return delegate.getText();
  }
  
  public boolean hasTextCharacters()
  {
    return delegate.hasTextCharacters();
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    return delegate.getTextCharacters();
  }
  
  public int getTextLength()
    throws IOException
  {
    return delegate.getTextLength();
  }
  
  public int getTextOffset()
    throws IOException
  {
    return delegate.getTextOffset();
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    return delegate.getBigIntegerValue();
  }
  
  public boolean getBooleanValue()
    throws IOException
  {
    return delegate.getBooleanValue();
  }
  
  public byte getByteValue()
    throws IOException
  {
    return delegate.getByteValue();
  }
  
  public short getShortValue()
    throws IOException
  {
    return delegate.getShortValue();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    return delegate.getDecimalValue();
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return delegate.getDoubleValue();
  }
  
  public float getFloatValue()
    throws IOException
  {
    return delegate.getFloatValue();
  }
  
  public int getIntValue()
    throws IOException
  {
    return delegate.getIntValue();
  }
  
  public long getLongValue()
    throws IOException
  {
    return delegate.getLongValue();
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    return delegate.getNumberType();
  }
  
  public Number getNumberValue()
    throws IOException
  {
    return delegate.getNumberValue();
  }
  
  public int getValueAsInt()
    throws IOException
  {
    return delegate.getValueAsInt();
  }
  
  public int getValueAsInt(int defaultValue)
    throws IOException
  {
    return delegate.getValueAsInt(defaultValue);
  }
  
  public long getValueAsLong()
    throws IOException
  {
    return delegate.getValueAsLong();
  }
  
  public long getValueAsLong(long defaultValue)
    throws IOException
  {
    return delegate.getValueAsLong(defaultValue);
  }
  
  public double getValueAsDouble()
    throws IOException
  {
    return delegate.getValueAsDouble();
  }
  
  public double getValueAsDouble(double defaultValue)
    throws IOException
  {
    return delegate.getValueAsDouble(defaultValue);
  }
  
  public boolean getValueAsBoolean()
    throws IOException
  {
    return delegate.getValueAsBoolean();
  }
  
  public boolean getValueAsBoolean(boolean defaultValue)
    throws IOException
  {
    return delegate.getValueAsBoolean(defaultValue);
  }
  
  public String getValueAsString()
    throws IOException
  {
    return delegate.getValueAsString();
  }
  
  public String getValueAsString(String defaultValue)
    throws IOException
  {
    return delegate.getValueAsString(defaultValue);
  }
  
  public Object getEmbeddedObject()
    throws IOException
  {
    return delegate.getEmbeddedObject();
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException
  {
    return delegate.getBinaryValue(b64variant);
  }
  
  public int readBinaryValue(Base64Variant b64variant, OutputStream out)
    throws IOException
  {
    return delegate.readBinaryValue(b64variant, out);
  }
  
  public JsonLocation getTokenLocation()
  {
    return delegate.getTokenLocation();
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    return delegate.nextToken();
  }
  
  public JsonToken nextValue()
    throws IOException
  {
    return delegate.nextValue();
  }
  
  public JsonParser skipChildren()
    throws IOException
  {
    delegate.skipChildren();
    
    return this;
  }
  
  public boolean canReadObjectId()
  {
    return delegate.canReadObjectId();
  }
  
  public boolean canReadTypeId()
  {
    return delegate.canReadTypeId();
  }
  
  public Object getObjectId()
    throws IOException
  {
    return delegate.getObjectId();
  }
  
  public Object getTypeId()
    throws IOException
  {
    return delegate.getTypeId();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.JsonParserDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */