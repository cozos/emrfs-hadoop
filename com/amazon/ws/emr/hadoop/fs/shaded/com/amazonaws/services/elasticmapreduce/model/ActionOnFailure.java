package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum ActionOnFailure
{
  TERMINATE_JOB_FLOW("TERMINATE_JOB_FLOW"),  TERMINATE_CLUSTER("TERMINATE_CLUSTER"),  CANCEL_AND_WAIT("CANCEL_AND_WAIT"),  CONTINUE("CONTINUE");
  
  private String value;
  
  private ActionOnFailure(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ActionOnFailure fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ActionOnFailure enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ActionOnFailure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */