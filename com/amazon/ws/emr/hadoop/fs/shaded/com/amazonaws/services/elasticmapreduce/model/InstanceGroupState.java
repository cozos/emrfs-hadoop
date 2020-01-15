package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum InstanceGroupState
{
  PROVISIONING("PROVISIONING"),  BOOTSTRAPPING("BOOTSTRAPPING"),  RUNNING("RUNNING"),  RECONFIGURING("RECONFIGURING"),  RESIZING("RESIZING"),  SUSPENDED("SUSPENDED"),  TERMINATING("TERMINATING"),  TERMINATED("TERMINATED"),  ARRESTED("ARRESTED"),  SHUTTING_DOWN("SHUTTING_DOWN"),  ENDED("ENDED");
  
  private String value;
  
  private InstanceGroupState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static InstanceGroupState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (InstanceGroupState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */