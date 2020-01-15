package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;

public class GetBucketMetricsConfigurationResult
  implements Serializable
{
  private MetricsConfiguration metricsConfiguration;
  
  public MetricsConfiguration getMetricsConfiguration()
  {
    return metricsConfiguration;
  }
  
  public void setMetricsConfiguration(MetricsConfiguration metricsConfiguration)
  {
    this.metricsConfiguration = metricsConfiguration;
  }
  
  public GetBucketMetricsConfigurationResult withMetricsConfiguration(MetricsConfiguration metricsConfiguration)
  {
    setMetricsConfiguration(metricsConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */