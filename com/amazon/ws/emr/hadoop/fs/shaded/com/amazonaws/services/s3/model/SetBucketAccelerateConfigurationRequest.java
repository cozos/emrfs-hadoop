package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

public class SetBucketAccelerateConfigurationRequest
  extends AmazonWebServiceRequest
{
  private String bucketName;
  private BucketAccelerateConfiguration accelerateConfiguration;
  
  public SetBucketAccelerateConfigurationRequest(String bucketName, BucketAccelerateConfiguration configuration)
  {
    this.bucketName = bucketName;
    accelerateConfiguration = configuration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketAccelerateConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketAccelerateConfiguration getAccelerateConfiguration()
  {
    return accelerateConfiguration;
  }
  
  public void setAccelerateConfiguration(BucketAccelerateConfiguration accelerateConfiguration)
  {
    this.accelerateConfiguration = accelerateConfiguration;
  }
  
  public SetBucketAccelerateConfigurationRequest withAccelerateConfiguration(BucketAccelerateConfiguration accelerateConfiguration)
  {
    setAccelerateConfiguration(accelerateConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */