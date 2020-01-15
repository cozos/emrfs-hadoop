package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class FilterRule
  implements Serializable
{
  private String name;
  private String value;
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    if (name == null) {
      throw new IllegalArgumentException("FilterRule Name is a required argument");
    }
    this.name = name;
  }
  
  public FilterRule withName(String name)
  {
    setName(name);
    return this;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }
  
  public FilterRule withValue(String value)
  {
    setValue(value);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.FilterRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */