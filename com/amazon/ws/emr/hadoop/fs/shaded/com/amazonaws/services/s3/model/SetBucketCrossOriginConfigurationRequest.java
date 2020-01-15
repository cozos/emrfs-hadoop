package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketCrossOriginConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketCrossOriginConfiguration crossOriginConfiguration;
  
  public SetBucketCrossOriginConfigurationRequest(String bucketName, BucketCrossOriginConfiguration crossOriginConfiguration)
  {
    this.bucketName = bucketName;
    this.crossOriginConfiguration = crossOriginConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketCrossOriginConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketCrossOriginConfiguration getCrossOriginConfiguration()
  {
    return crossOriginConfiguration;
  }
  
  public void setCrossOriginConfiguration(BucketCrossOriginConfiguration crossOriginConfiguration)
  {
    this.crossOriginConfiguration = crossOriginConfiguration;
  }
  
  public SetBucketCrossOriginConfigurationRequest withCrossOriginConfiguration(BucketCrossOriginConfiguration crossOriginConfiguration)
  {
    setCrossOriginConfiguration(crossOriginConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketCrossOriginConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */