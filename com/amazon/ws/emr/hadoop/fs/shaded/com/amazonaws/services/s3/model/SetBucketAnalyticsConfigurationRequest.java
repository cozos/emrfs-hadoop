package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;

public class SetBucketAnalyticsConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private AnalyticsConfiguration analyticsConfiguration;
  
  public SetBucketAnalyticsConfigurationRequest() {}
  
  public SetBucketAnalyticsConfigurationRequest(String bucketName, AnalyticsConfiguration analyticsConfiguration)
  {
    this.bucketName = bucketName;
    this.analyticsConfiguration = analyticsConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketAnalyticsConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public AnalyticsConfiguration getAnalyticsConfiguration()
  {
    return analyticsConfiguration;
  }
  
  public void setAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration)
  {
    this.analyticsConfiguration = analyticsConfiguration;
  }
  
  public SetBucketAnalyticsConfigurationRequest withAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration)
  {
    setAnalyticsConfiguration(analyticsConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */