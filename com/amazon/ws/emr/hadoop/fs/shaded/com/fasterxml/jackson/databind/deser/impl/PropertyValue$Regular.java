package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;

final class PropertyValue$Regular
  extends PropertyValue
{
  final SettableBeanProperty _property;
  
  public PropertyValue$Regular(PropertyValue next, Object value, SettableBeanProperty prop)
  {
    super(next, value);
    _property = prop;
  }
  
  public void assign(Object bean)
    throws IOException, JsonProcessingException
  {
    _property.set(bean, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValue.Regular
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */