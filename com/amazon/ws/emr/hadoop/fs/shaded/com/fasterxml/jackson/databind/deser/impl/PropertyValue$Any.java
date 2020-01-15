package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import java.io.IOException;

final class PropertyValue$Any
  extends PropertyValue
{
  final SettableAnyProperty _property;
  final String _propertyName;
  
  public PropertyValue$Any(PropertyValue next, Object value, SettableAnyProperty prop, String propName)
  {
    super(next, value);
    _property = prop;
    _propertyName = propName;
  }
  
  public void assign(Object bean)
    throws IOException, JsonProcessingException
  {
    _property.set(bean, _propertyName, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValue.Any
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */