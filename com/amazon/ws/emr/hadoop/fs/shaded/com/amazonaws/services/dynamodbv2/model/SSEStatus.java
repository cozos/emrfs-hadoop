package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum SSEStatus
{
  ENABLING("ENABLING"),  ENABLED("ENABLED"),  DISABLING("DISABLING"),  DISABLED("DISABLED"),  UPDATING("UPDATING");
  
  private String value;
  
  private SSEStatus(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static SSEStatus fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (SSEStatus enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SSEStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */