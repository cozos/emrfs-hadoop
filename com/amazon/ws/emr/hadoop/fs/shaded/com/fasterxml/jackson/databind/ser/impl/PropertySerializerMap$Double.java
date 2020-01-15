package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;

final class PropertySerializerMap$Double
  extends PropertySerializerMap
{
  private final Class<?> _type1;
  private final Class<?> _type2;
  private final JsonSerializer<Object> _serializer1;
  private final JsonSerializer<Object> _serializer2;
  
  public PropertySerializerMap$Double(PropertySerializerMap base, Class<?> type1, JsonSerializer<Object> serializer1, Class<?> type2, JsonSerializer<Object> serializer2)
  {
    super(base);
    _type1 = type1;
    _serializer1 = serializer1;
    _type2 = type2;
    _serializer2 = serializer2;
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> type)
  {
    if (type == _type1) {
      return _serializer1;
    }
    if (type == _type2) {
      return _serializer2;
    }
    return null;
  }
  
  public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
  {
    PropertySerializerMap.TypeAndSerializer[] ts = new PropertySerializerMap.TypeAndSerializer[3];
    ts[0] = new PropertySerializerMap.TypeAndSerializer(_type1, _serializer1);
    ts[1] = new PropertySerializerMap.TypeAndSerializer(_type2, _serializer2);
    ts[2] = new PropertySerializerMap.TypeAndSerializer(type, serializer);
    return new PropertySerializerMap.Multi(this, ts);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Double
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */