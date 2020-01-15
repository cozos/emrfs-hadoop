package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum InstanceState
{
  AWAITING_FULFILLMENT("AWAITING_FULFILLMENT"),  PROVISIONING("PROVISIONING"),  BOOTSTRAPPING("BOOTSTRAPPING"),  RUNNING("RUNNING"),  TERMINATED("TERMINATED");
  
  private String value;
  
  private InstanceState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static InstanceState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (InstanceState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */