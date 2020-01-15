package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;

public class Tag
  implements Serializable, Cloneable
{
  private String key;
  private String value;
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public Tag withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public Tag withValue(String value)
  {
    setValue(value);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKey() != null) {
      sb.append("Key: ").append(getKey()).append(",");
    }
    if (getValue() != null) {
      sb.append("Value: ").append(getValue());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Tag)) {
      return false;
    }
    Tag other = (Tag)obj;
    if (((other.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKey() != null) && (!other.getKey().equals(getKey()))) {
      return false;
    }
    if (((other.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValue() != null) && (!other.getValue().equals(getValue()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKey() == null ? 0 : getKey().hashCode());
    hashCode = 31 * hashCode + (getValue() == null ? 0 : getValue().hashCode());
    return hashCode;
  }
  
  public Tag clone()
  {
    try
    {
      return (Tag)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Tag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */