package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Map;

final class PropertyValue$Map
  extends PropertyValue
{
  final Object _key;
  
  public PropertyValue$Map(PropertyValue next, Object value, Object key)
  {
    super(next, value);
    _key = key;
  }
  
  public void assign(Object bean)
    throws IOException, JsonProcessingException
  {
    ((Map)bean).put(_key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValue.Map
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */