package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.Serializable;
import java.util.Set;

public class SimpleBeanPropertyFilter$FilterExceptFilter
  extends SimpleBeanPropertyFilter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Set<String> _propertiesToInclude;
  
  public SimpleBeanPropertyFilter$FilterExceptFilter(Set<String> properties)
  {
    _propertiesToInclude = properties;
  }
  
  protected boolean include(BeanPropertyWriter writer)
  {
    return _propertiesToInclude.contains(writer.getName());
  }
  
  protected boolean include(PropertyWriter writer)
  {
    return _propertiesToInclude.contains(writer.getName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.FilterExceptFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */