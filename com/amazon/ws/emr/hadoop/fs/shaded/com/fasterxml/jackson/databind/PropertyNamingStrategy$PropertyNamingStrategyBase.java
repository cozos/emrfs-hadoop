package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter;

public abstract class PropertyNamingStrategy$PropertyNamingStrategyBase
  extends PropertyNamingStrategy
{
  public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName)
  {
    return translate(defaultName);
  }
  
  public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName)
  {
    return translate(defaultName);
  }
  
  public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName)
  {
    return translate(defaultName);
  }
  
  public String nameForConstructorParameter(MapperConfig<?> config, AnnotatedParameter ctorParam, String defaultName)
  {
    return translate(defaultName);
  }
  
  public abstract String translate(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */