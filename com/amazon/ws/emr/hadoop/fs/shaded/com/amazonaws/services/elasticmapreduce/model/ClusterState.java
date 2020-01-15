package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum ClusterState
{
  STARTING("STARTING"),  BOOTSTRAPPING("BOOTSTRAPPING"),  RUNNING("RUNNING"),  WAITING("WAITING"),  TERMINATING("TERMINATING"),  TERMINATED("TERMINATED"),  TERMINATED_WITH_ERRORS("TERMINATED_WITH_ERRORS");
  
  private String value;
  
  private ClusterState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ClusterState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ClusterState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ClusterState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */