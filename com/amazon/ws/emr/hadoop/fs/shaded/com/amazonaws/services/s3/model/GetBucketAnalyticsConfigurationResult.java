package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;

public class GetBucketAnalyticsConfigurationResult
  implements Serializable
{
  private AnalyticsConfiguration analyticsConfiguration;
  
  public AnalyticsConfiguration getAnalyticsConfiguration()
  {
    return analyticsConfiguration;
  }
  
  public void setAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration)
  {
    this.analyticsConfiguration = analyticsConfiguration;
  }
  
  public GetBucketAnalyticsConfigurationResult withAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration)
  {
    setAnalyticsConfiguration(analyticsConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */