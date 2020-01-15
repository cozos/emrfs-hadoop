package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public final class TypeWrappedSerializer
  extends JsonSerializer<Object>
{
  protected final TypeSerializer _typeSerializer;
  protected final JsonSerializer<Object> _serializer;
  
  public TypeWrappedSerializer(TypeSerializer typeSer, JsonSerializer<?> ser)
  {
    _typeSerializer = typeSer;
    _serializer = ser;
  }
  
  public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    _serializer.serializeWithType(value, jgen, provider, _typeSerializer);
  }
  
  public void serializeWithType(Object value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    _serializer.serializeWithType(value, jgen, provider, typeSer);
  }
  
  public Class<Object> handledType()
  {
    return Object.class;
  }
  
  public JsonSerializer<Object> valueSerializer()
  {
    return _serializer;
  }
  
  public TypeSerializer typeSerializer()
  {
    return _typeSerializer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */