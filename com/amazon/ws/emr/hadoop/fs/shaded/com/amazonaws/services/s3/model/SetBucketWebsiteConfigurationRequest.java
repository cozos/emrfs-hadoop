package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketWebsiteConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketWebsiteConfiguration configuration;
  
  public SetBucketWebsiteConfigurationRequest(String bucketName, BucketWebsiteConfiguration configuration)
  {
    this.bucketName = bucketName;
    this.configuration = configuration;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public SetBucketWebsiteConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public void setConfiguration(BucketWebsiteConfiguration configuration)
  {
    this.configuration = configuration;
  }
  
  public BucketWebsiteConfiguration getConfiguration()
  {
    return configuration;
  }
  
  public SetBucketWebsiteConfigurationRequest withConfiguration(BucketWebsiteConfiguration configuration)
  {
    setConfiguration(configuration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */