package com.amazon.ws.emr.hadoop.fs.annotation.application;

import org.apache.hadoop.conf.Configuration;

public final class DefaultConfigurationProcessor
  implements ApplicationTypeConfigurationProcessor
{
  private Configuration configuration;
  
  public DefaultConfigurationProcessor(Configuration configuration)
  {
    this.configuration = configuration;
  }
  
  public String getJobId()
  {
    return configuration.get("mapreduce.job.id", "");
  }
  
  public String getJobName()
  {
    return configuration.get("mapreduce.job.name", "");
  }
  
  public String getTaskId()
  {
    return configuration.get("mapreduce.task.id", "");
  }
  
  public String getTaskAttemptId()
  {
    return configuration.get("mapreduce.task.attempt.id", "");
  }
  
  public String getApplicationAttemptId()
  {
    return configuration.get("mapreduce.job.application.attempt.id", "");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.application.DefaultConfigurationProcessor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */