package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketTaggingConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketTaggingConfiguration taggingConfiguration;
  
  public SetBucketTaggingConfigurationRequest(String bucketName, BucketTaggingConfiguration taggingConfiguration)
  {
    this.bucketName = bucketName;
    this.taggingConfiguration = taggingConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketTaggingConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketTaggingConfiguration getTaggingConfiguration()
  {
    return taggingConfiguration;
  }
  
  public void setTaggingConfiguration(BucketTaggingConfiguration taggingConfiguration)
  {
    this.taggingConfiguration = taggingConfiguration;
  }
  
  public SetBucketTaggingConfigurationRequest withTaggingConfiguration(BucketTaggingConfiguration taggingConfiguration)
  {
    setTaggingConfiguration(taggingConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketTaggingConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */