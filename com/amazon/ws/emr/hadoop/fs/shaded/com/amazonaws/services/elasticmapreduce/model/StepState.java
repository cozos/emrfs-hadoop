package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum StepState
{
  PENDING("PENDING"),  CANCEL_PENDING("CANCEL_PENDING"),  RUNNING("RUNNING"),  COMPLETED("COMPLETED"),  CANCELLED("CANCELLED"),  FAILED("FAILED"),  INTERRUPTED("INTERRUPTED");
  
  private String value;
  
  private StepState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static StepState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (StepState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */