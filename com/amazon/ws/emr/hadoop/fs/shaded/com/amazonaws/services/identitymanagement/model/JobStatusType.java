package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum JobStatusType
{
  IN_PROGRESS("IN_PROGRESS"),  COMPLETED("COMPLETED"),  FAILED("FAILED");
  
  private String value;
  
  private JobStatusType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static JobStatusType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (JobStatusType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.JobStatusType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */