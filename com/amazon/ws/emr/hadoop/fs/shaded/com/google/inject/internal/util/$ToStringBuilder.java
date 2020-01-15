package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class $ToStringBuilder
{
  final Map<String, Object> map = new LinkedHashMap();
  final String name;
  
  public $ToStringBuilder(Class type)
  {
    name = type.getSimpleName();
  }
  
  public ToStringBuilder add(String name, Object value)
  {
    if (map.put(name, value) != null) {
      throw new RuntimeException("Duplicate names: " + name);
    }
    return this;
  }
  
  public String toString()
  {
    return name + map.toString().replace('{', '[').replace('}', ']');
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */