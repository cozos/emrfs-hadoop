package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketLifecycleConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketLifecycleConfiguration lifecycleConfiguration;
  
  public SetBucketLifecycleConfigurationRequest(String bucketName, BucketLifecycleConfiguration lifecycleConfiguration)
  {
    this.bucketName = bucketName;
    this.lifecycleConfiguration = lifecycleConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketLifecycleConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketLifecycleConfiguration getLifecycleConfiguration()
  {
    return lifecycleConfiguration;
  }
  
  public void setLifecycleConfiguration(BucketLifecycleConfiguration lifecycleConfiguration)
  {
    this.lifecycleConfiguration = lifecycleConfiguration;
  }
  
  public SetBucketLifecycleConfigurationRequest withLifecycleConfiguration(BucketLifecycleConfiguration lifecycleConfiguration)
  {
    setLifecycleConfiguration(lifecycleConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketLifecycleConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */