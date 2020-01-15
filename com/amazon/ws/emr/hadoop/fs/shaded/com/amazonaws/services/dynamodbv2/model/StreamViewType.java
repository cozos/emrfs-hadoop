package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum StreamViewType
{
  NEW_IMAGE("NEW_IMAGE"),  OLD_IMAGE("OLD_IMAGE"),  NEW_AND_OLD_IMAGES("NEW_AND_OLD_IMAGES"),  KEYS_ONLY("KEYS_ONLY");
  
  private String value;
  
  private StreamViewType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static StreamViewType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (StreamViewType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamViewType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */