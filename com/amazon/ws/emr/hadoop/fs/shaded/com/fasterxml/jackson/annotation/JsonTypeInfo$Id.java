package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public enum JsonTypeInfo$Id
{
  NONE(null),  CLASS("@class"),  MINIMAL_CLASS("@c"),  NAME("@type"),  CUSTOM(null);
  
  private final String _defaultPropertyName;
  
  private JsonTypeInfo$Id(String defProp)
  {
    _defaultPropertyName = defProp;
  }
  
  public String getDefaultPropertyName()
  {
    return _defaultPropertyName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */