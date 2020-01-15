package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketLoggingConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketLoggingConfiguration loggingConfiguration;
  
  public SetBucketLoggingConfigurationRequest(String bucketName, BucketLoggingConfiguration loggingConfiguration)
  {
    this.bucketName = bucketName;
    this.loggingConfiguration = loggingConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketLoggingConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketLoggingConfiguration getLoggingConfiguration()
  {
    return loggingConfiguration;
  }
  
  public void setLoggingConfiguration(BucketLoggingConfiguration loggingConfiguration)
  {
    this.loggingConfiguration = loggingConfiguration;
  }
  
  public SetBucketLoggingConfigurationRequest withLoggingConfiguration(BucketLoggingConfiguration loggingConfiguration)
  {
    setLoggingConfiguration(loggingConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */