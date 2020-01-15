package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Tag
  implements Serializable
{
  private String key;
  private String value;
  
  public Tag(String key, String value)
  {
    this.key = key;
    this.value = value;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public Tag withKey(String key)
  {
    setKey(key);
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
  
  public Tag withValue(String value)
  {
    setValue(value);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Tag tag = (Tag)o;
    if (key != null ? !key.equals(key) : key != null) {
      return false;
    }
    return value == null ? true : value != null ? value.equals(value) : false;
  }
  
  public int hashCode()
  {
    int result = key != null ? key.hashCode() : 0;
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */