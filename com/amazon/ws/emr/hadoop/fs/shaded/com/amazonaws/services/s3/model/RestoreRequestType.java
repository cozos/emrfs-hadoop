package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum RestoreRequestType
{
  SELECT("SELECT");
  
  private final String type;
  
  private RestoreRequestType(String type)
  {
    this.type = type;
  }
  
  public String toString()
  {
    return type;
  }
  
  public static RestoreRequestType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (RestoreRequestType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreRequestType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */