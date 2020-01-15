package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;

final class PropertySerializerMap$Single
  extends PropertySerializerMap
{
  private final Class<?> _type;
  private final JsonSerializer<Object> _serializer;
  
  public PropertySerializerMap$Single(PropertySerializerMap base, Class<?> type, JsonSerializer<Object> serializer)
  {
    super(base);
    _type = type;
    _serializer = serializer;
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> type)
  {
    if (type == _type) {
      return _serializer;
    }
    return null;
  }
  
  public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
  {
    return new PropertySerializerMap.Double(this, _type, _serializer, type, serializer);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Single
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */