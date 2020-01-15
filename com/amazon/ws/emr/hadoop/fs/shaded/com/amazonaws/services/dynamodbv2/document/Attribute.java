package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;

public class Attribute
{
  private final String name;
  private final Object value;
  
  public Attribute(String attrName, Object value)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    name = attrName;
    this.value = value;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public String toString()
  {
    return "{" + name + ": " + value + "}";
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + getName().hashCode();
    
    hashCode = 31 * hashCode + (getValue() == null ? 0 : getValue().hashCode());
    return hashCode;
  }
  
  public boolean equals(Object in)
  {
    if ((in instanceof Attribute))
    {
      Attribute that = (Attribute)in;
      if (name.equals(name))
      {
        if (value == null) {
          return value == null;
        }
        return value.equals(value);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Attribute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */