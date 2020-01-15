package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum OwnerOverride
{
  DESTINATION("Destination");
  
  private final String id;
  
  private OwnerOverride(String id)
  {
    this.id = id;
  }
  
  public String toString()
  {
    return id;
  }
  
  public static OwnerOverride fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (OwnerOverride enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OwnerOverride
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */