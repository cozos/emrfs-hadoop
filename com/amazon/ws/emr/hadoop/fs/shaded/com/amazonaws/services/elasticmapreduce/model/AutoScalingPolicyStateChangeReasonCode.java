package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum AutoScalingPolicyStateChangeReasonCode
{
  USER_REQUEST("USER_REQUEST"),  PROVISION_FAILURE("PROVISION_FAILURE"),  CLEANUP_FAILURE("CLEANUP_FAILURE");
  
  private String value;
  
  private AutoScalingPolicyStateChangeReasonCode(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static AutoScalingPolicyStateChangeReasonCode fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (AutoScalingPolicyStateChangeReasonCode enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyStateChangeReasonCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */