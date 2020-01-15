package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum GlobalEndpointTokenVersion
{
  V1Token("v1Token"),  V2Token("v2Token");
  
  private String value;
  
  private GlobalEndpointTokenVersion(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static GlobalEndpointTokenVersion fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (GlobalEndpointTokenVersion enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GlobalEndpointTokenVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */