package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class BucketLoggingConfiguration
  implements Serializable
{
  private String destinationBucketName = null;
  private String logFilePrefix = null;
  
  public BucketLoggingConfiguration() {}
  
  public BucketLoggingConfiguration(String destinationBucketName, String logFilePrefix)
  {
    setLogFilePrefix(logFilePrefix);
    setDestinationBucketName(destinationBucketName);
  }
  
  public boolean isLoggingEnabled()
  {
    return (destinationBucketName != null) && (logFilePrefix != null);
  }
  
  public String getLogFilePrefix()
  {
    return logFilePrefix;
  }
  
  public void setLogFilePrefix(String logFilePrefix)
  {
    if (logFilePrefix == null) {
      logFilePrefix = "";
    }
    this.logFilePrefix = logFilePrefix;
  }
  
  public String getDestinationBucketName()
  {
    return destinationBucketName;
  }
  
  public void setDestinationBucketName(String destinationBucketName)
  {
    this.destinationBucketName = destinationBucketName;
  }
  
  public String toString()
  {
    String result = "LoggingConfiguration enabled=" + isLoggingEnabled();
    if (isLoggingEnabled()) {
      result = result + ", destinationBucketName=" + getDestinationBucketName() + ", logFilePrefix=" + getLogFilePrefix();
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */