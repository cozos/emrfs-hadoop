package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.Map;

public abstract class PropertyValue
{
  public final PropertyValue next;
  public final Object value;
  
  protected PropertyValue(PropertyValue next, Object value)
  {
    this.next = next;
    this.value = value;
  }
  
  public abstract void assign(Object paramObject)
    throws IOException, JsonProcessingException;
  
  static final class Regular
    extends PropertyValue
  {
    final SettableBeanProperty _property;
    
    public Regular(PropertyValue next, Object value, SettableBeanProperty prop)
    {
      super(value);
      _property = prop;
    }
    
    public void assign(Object bean)
      throws IOException, JsonProcessingException
    {
      _property.set(bean, value);
    }
  }
  
  static final class Any
    extends PropertyValue
  {
    final SettableAnyProperty _property;
    final String _propertyName;
    
    public Any(PropertyValue next, Object value, SettableAnyProperty prop, String propName)
    {
      super(value);
      _property = prop;
      _propertyName = propName;
    }
    
    public void assign(Object bean)
      throws IOException, JsonProcessingException
    {
      _property.set(bean, _propertyName, value);
    }
  }
  
  static final class Map
    extends PropertyValue
  {
    final Object _key;
    
    public Map(PropertyValue next, Object value, Object key)
    {
      super(value);
      _key = key;
    }
    
    public void assign(Object bean)
      throws IOException, JsonProcessingException
    {
      ((Map)bean).put(_key, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */