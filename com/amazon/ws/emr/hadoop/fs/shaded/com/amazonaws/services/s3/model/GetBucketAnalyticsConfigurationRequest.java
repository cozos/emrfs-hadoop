package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetBucketAnalyticsConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String id;
  
  public GetBucketAnalyticsConfigurationRequest() {}
  
  public GetBucketAnalyticsConfigurationRequest(String bucketName, String id)
  {
    this.bucketName = bucketName;
    this.id = id;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GetBucketAnalyticsConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public GetBucketAnalyticsConfigurationRequest withId(String id)
  {
    setId(id);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */