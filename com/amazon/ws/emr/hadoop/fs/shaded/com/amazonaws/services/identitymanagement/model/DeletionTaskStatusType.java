package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum DeletionTaskStatusType
{
  SUCCEEDED("SUCCEEDED"),  IN_PROGRESS("IN_PROGRESS"),  FAILED("FAILED"),  NOT_STARTED("NOT_STARTED");
  
  private String value;
  
  private DeletionTaskStatusType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static DeletionTaskStatusType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (DeletionTaskStatusType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletionTaskStatusType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */