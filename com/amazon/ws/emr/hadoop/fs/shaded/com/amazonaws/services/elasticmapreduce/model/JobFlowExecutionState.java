package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum JobFlowExecutionState
{
  STARTING("STARTING"),  BOOTSTRAPPING("BOOTSTRAPPING"),  RUNNING("RUNNING"),  WAITING("WAITING"),  SHUTTING_DOWN("SHUTTING_DOWN"),  TERMINATED("TERMINATED"),  COMPLETED("COMPLETED"),  FAILED("FAILED");
  
  private String value;
  
  private JobFlowExecutionState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static JobFlowExecutionState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (JobFlowExecutionState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowExecutionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */