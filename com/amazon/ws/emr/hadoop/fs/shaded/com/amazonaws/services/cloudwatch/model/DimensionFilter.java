package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;

public class DimensionFilter
  implements Serializable, Cloneable
{
  private String name;
  private String value;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public DimensionFilter withName(String name)
  {
    setName(name);
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
  
  public DimensionFilter withValue(String value)
  {
    setValue(value);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
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
    if (!(obj instanceof DimensionFilter)) {
      return false;
    }
    DimensionFilter other = (DimensionFilter)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
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
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getValue() == null ? 0 : getValue().hashCode());
    return hashCode;
  }
  
  public DimensionFilter clone()
  {
    try
    {
      return (DimensionFilter)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DimensionFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */