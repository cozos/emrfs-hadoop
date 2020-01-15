package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum StepExecutionState
{
  PENDING("PENDING"),  RUNNING("RUNNING"),  CONTINUE("CONTINUE"),  COMPLETED("COMPLETED"),  CANCELLED("CANCELLED"),  FAILED("FAILED"),  INTERRUPTED("INTERRUPTED");
  
  private String value;
  
  private StepExecutionState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static StepExecutionState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (StepExecutionState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepExecutionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */