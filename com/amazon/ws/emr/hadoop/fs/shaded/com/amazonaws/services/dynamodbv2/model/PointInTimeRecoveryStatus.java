package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum PointInTimeRecoveryStatus
{
  ENABLED("ENABLED"),  DISABLED("DISABLED");
  
  private String value;
  
  private PointInTimeRecoveryStatus(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static PointInTimeRecoveryStatus fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (PointInTimeRecoveryStatus enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */