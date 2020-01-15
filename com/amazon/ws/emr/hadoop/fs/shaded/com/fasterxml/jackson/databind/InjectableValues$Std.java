package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InjectableValues$Std
  extends InjectableValues
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Map<String, Object> _values;
  
  public InjectableValues$Std()
  {
    this(new HashMap());
  }
  
  public InjectableValues$Std(Map<String, Object> values)
  {
    _values = values;
  }
  
  public Std addValue(String key, Object value)
  {
    _values.put(key, value);
    return this;
  }
  
  public Std addValue(Class<?> classKey, Object value)
  {
    _values.put(classKey.getName(), value);
    return this;
  }
  
  public Object findInjectableValue(Object valueId, DeserializationContext ctxt, BeanProperty forProperty, Object beanInstance)
  {
    if (!(valueId instanceof String))
    {
      String type = valueId == null ? "[null]" : valueId.getClass().getName();
      throw new IllegalArgumentException("Unrecognized inject value id type (" + type + "), expecting String");
    }
    String key = (String)valueId;
    Object ob = _values.get(key);
    if ((ob == null) && (!_values.containsKey(key))) {
      throw new IllegalArgumentException("No injectable id with value '" + key + "' found (for property '" + forProperty.getName() + "')");
    }
    return ob;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.InjectableValues.Std
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */