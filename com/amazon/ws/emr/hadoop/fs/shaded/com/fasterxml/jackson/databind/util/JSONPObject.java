package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class JSONPObject
  implements JsonSerializable
{
  protected final String _function;
  protected final Object _value;
  protected final JavaType _serializationType;
  
  public JSONPObject(String function, Object value)
  {
    this(function, value, (JavaType)null);
  }
  
  public JSONPObject(String function, Object value, JavaType asType)
  {
    _function = function;
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
    jgen.writeRaw(_function);
    jgen.writeRaw('(');
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
    jgen.writeRaw(')');
  }
  
  public String getFunction()
  {
    return _function;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.JSONPObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */