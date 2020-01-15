package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;

final class PropertySerializerMap$Empty
  extends PropertySerializerMap
{
  public static final Empty FOR_PROPERTIES = new Empty(false);
  public static final Empty FOR_ROOT_VALUES = new Empty(true);
  
  protected PropertySerializerMap$Empty(boolean resetWhenFull)
  {
    super(resetWhenFull);
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> type)
  {
    return null;
  }
  
  public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
  {
    return new PropertySerializerMap.Single(this, type, serializer);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Empty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */