package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum ScaleDownBehavior
{
  TERMINATE_AT_INSTANCE_HOUR("TERMINATE_AT_INSTANCE_HOUR"),  TERMINATE_AT_TASK_COMPLETION("TERMINATE_AT_TASK_COMPLETION");
  
  private String value;
  
  private ScaleDownBehavior(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ScaleDownBehavior fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ScaleDownBehavior enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScaleDownBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */