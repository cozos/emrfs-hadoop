package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum ReplicationRuleStatus
{
  Enabled("Enabled"),  Disabled("Disabled");
  
  private final String status;
  
  private ReplicationRuleStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationRuleStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */