package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class JSONWrappedObject
  implements JsonSerializable
{
  protected final String _prefix;
  protected final String _suffix;
  protected final Object _value;
  protected final JavaType _serializationType;
  
  public JSONWrappedObject(String prefix, String suffix, Object value)
  {
    this(prefix, suffix, value, (JavaType)null);
  }
  
  public JSONWrappedObject(String prefix, String suffix, Object value, JavaType asType)
  {
    _prefix = prefix;
    _suffix = suffix;
    _value = value;
    _serializationType = asType;
  }
  
  public void serializeWithType(JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonProcessingException
  {
    serialize(jgen, provider);
  }
  
  public void serialize(JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    if (_prefix != null) {
      jgen.writeRaw(_prefix);
    }
    if (_value == null)
    {
      provider.defaultSerializeNull(jgen);
    }
    else if (_serializationType != null)
    {
      provider.findTypedValueSerializer(_serializationType, true, null).serialize(_value, jgen, provider);
    }
    else
    {
      Class<?> cls = _value.getClass();
      provider.findTypedValueSerializer(cls, true, null).serialize(_value, jgen, provider);
    }
    if (_suffix != null) {
      jgen.writeRaw(_suffix);
    }
  }
  
  public String getPrefix()
  {
    return _prefix;
  }
  
  public String getSuffix()
  {
    return _suffix;
  }
  
  public Object getValue()
  {
    return _value;
  }
  
  public JavaType getSerializationType()
  {
    return _serializationType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.JSONWrappedObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */