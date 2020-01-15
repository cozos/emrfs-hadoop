package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class SimpleBeanPropertyFilter$SerializeExceptFilter
  extends SimpleBeanPropertyFilter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  static final SerializeExceptFilter INCLUDE_ALL = new SerializeExceptFilter();
  protected final Set<String> _propertiesToExclude;
  
  SimpleBeanPropertyFilter$SerializeExceptFilter()
  {
    _propertiesToExclude = Collections.emptySet();
  }
  
  public SimpleBeanPropertyFilter$SerializeExceptFilter(Set<String> properties)
  {
    _propertiesToExclude = properties;
  }
  
  protected boolean include(BeanPropertyWriter writer)
  {
    return !_propertiesToExclude.contains(writer.getName());
  }
  
  protected boolean include(PropertyWriter writer)
  {
    return !_propertiesToExclude.contains(writer.getName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.SerializeExceptFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */