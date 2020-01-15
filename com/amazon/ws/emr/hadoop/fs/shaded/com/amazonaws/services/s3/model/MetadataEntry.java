package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class MetadataEntry
  implements Serializable, Cloneable
{
  private String name;
  private String value;
  
  public MetadataEntry(String name, String value)
  {
    this.name = name;
    this.value = value;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public MetadataEntry withName(String key)
  {
    setName(key);
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
  
  public MetadataEntry withValue(String metadataValue)
  {
    setValue(metadataValue);
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof MetadataEntry))) {
      return false;
    }
    MetadataEntry other = (MetadataEntry)obj;
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
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getValue() != null) {
      sb.append("Value: ").append(getValue()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public MetadataEntry clone()
  {
    try
    {
      return (MetadataEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MetadataEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */