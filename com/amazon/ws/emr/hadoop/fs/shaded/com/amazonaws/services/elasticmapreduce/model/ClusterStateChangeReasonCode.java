package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum ClusterStateChangeReasonCode
{
  INTERNAL_ERROR("INTERNAL_ERROR"),  VALIDATION_ERROR("VALIDATION_ERROR"),  INSTANCE_FAILURE("INSTANCE_FAILURE"),  INSTANCE_FLEET_TIMEOUT("INSTANCE_FLEET_TIMEOUT"),  BOOTSTRAP_FAILURE("BOOTSTRAP_FAILURE"),  USER_REQUEST("USER_REQUEST"),  STEP_FAILURE("STEP_FAILURE"),  ALL_STEPS_COMPLETED("ALL_STEPS_COMPLETED");
  
  private String value;
  
  private ClusterStateChangeReasonCode(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ClusterStateChangeReasonCode fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ClusterStateChangeReasonCode enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ClusterStateChangeReasonCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */