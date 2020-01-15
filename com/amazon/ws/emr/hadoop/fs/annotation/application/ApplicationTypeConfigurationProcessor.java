package com.amazon.ws.emr.hadoop.fs.annotation.application;

public abstract interface ApplicationTypeConfigurationProcessor
{
  public abstract String getJobId();
  
  public abstract String getJobName();
  
  public abstract String getTaskId();
  
  public abstract String getTaskAttemptId();
  
  public abstract String getApplicationAttemptId();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.application.ApplicationTypeConfigurationProcessor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */