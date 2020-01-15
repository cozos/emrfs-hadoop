package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum InstanceFleetStateChangeReasonCode
{
  INTERNAL_ERROR("INTERNAL_ERROR"),  VALIDATION_ERROR("VALIDATION_ERROR"),  INSTANCE_FAILURE("INSTANCE_FAILURE"),  CLUSTER_TERMINATED("CLUSTER_TERMINATED");
  
  private String value;
  
  private InstanceFleetStateChangeReasonCode(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static InstanceFleetStateChangeReasonCode fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (InstanceFleetStateChangeReasonCode enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetStateChangeReasonCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */