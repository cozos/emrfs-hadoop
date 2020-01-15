package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import java.util.Arrays;

final class PropertySerializerMap$Multi
  extends PropertySerializerMap
{
  private static final int MAX_ENTRIES = 8;
  private final PropertySerializerMap.TypeAndSerializer[] _entries;
  
  public PropertySerializerMap$Multi(PropertySerializerMap base, PropertySerializerMap.TypeAndSerializer[] entries)
  {
    super(base);
    _entries = entries;
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> type)
  {
    int i = 0;
    for (int len = _entries.length; i < len; i++)
    {
      PropertySerializerMap.TypeAndSerializer entry = _entries[i];
      if (type == type) {
        return serializer;
      }
    }
    return null;
  }
  
  public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
  {
    int len = _entries.length;
    if (len == 8)
    {
      if (_resetWhenFull) {
        return new PropertySerializerMap.Single(this, type, serializer);
      }
      return this;
    }
    PropertySerializerMap.TypeAndSerializer[] entries = (PropertySerializerMap.TypeAndSerializer[])Arrays.copyOf(_entries, len + 1);
    entries[len] = new PropertySerializerMap.TypeAndSerializer(type, serializer);
    return new Multi(this, entries);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Multi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */