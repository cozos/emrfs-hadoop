package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum InstanceFleetState
{
  PROVISIONING("PROVISIONING"),  BOOTSTRAPPING("BOOTSTRAPPING"),  RUNNING("RUNNING"),  RESIZING("RESIZING"),  SUSPENDED("SUSPENDED"),  TERMINATING("TERMINATING"),  TERMINATED("TERMINATED");
  
  private String value;
  
  private InstanceFleetState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static InstanceFleetState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (InstanceFleetState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */