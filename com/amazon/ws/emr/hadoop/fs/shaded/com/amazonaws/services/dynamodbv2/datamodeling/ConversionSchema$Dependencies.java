package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.HashMap;
import java.util.Map;

public class ConversionSchema$Dependencies
{
  private final Map<Class<?>, Object> values;
  
  public ConversionSchema$Dependencies()
  {
    values = new HashMap();
  }
  
  public <T> T get(Class<T> clazz)
  {
    return (T)values.get(clazz);
  }
  
  public <T> Dependencies with(Class<T> clazz, T value)
  {
    values.put(clazz, value);
    return this;
  }
  
  public String toString()
  {
    return values.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchema.Dependencies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */