package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum SpotProvisioningTimeoutAction
{
  SWITCH_TO_ON_DEMAND("SWITCH_TO_ON_DEMAND"),  TERMINATE_CLUSTER("TERMINATE_CLUSTER");
  
  private String value;
  
  private SpotProvisioningTimeoutAction(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static SpotProvisioningTimeoutAction fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (SpotProvisioningTimeoutAction enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SpotProvisioningTimeoutAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */