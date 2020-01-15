package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;

public class SetBucketMetricsConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private MetricsConfiguration metricsConfiguration;
  
  public SetBucketMetricsConfigurationRequest() {}
  
  public SetBucketMetricsConfigurationRequest(String bucketName, MetricsConfiguration metricsConfiguration)
  {
    this.bucketName = bucketName;
    this.metricsConfiguration = metricsConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketMetricsConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public MetricsConfiguration getMetricsConfiguration()
  {
    return metricsConfiguration;
  }
  
  public void setMetricsConfiguration(MetricsConfiguration metricsConfiguration)
  {
    this.metricsConfiguration = metricsConfiguration;
  }
  
  public SetBucketMetricsConfigurationRequest withMetricsConfiguration(MetricsConfiguration metricsConfiguration)
  {
    setMetricsConfiguration(metricsConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketMetricsConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */