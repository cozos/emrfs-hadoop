package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;
import java.util.List;

public class ListBucketAnalyticsConfigurationsResult
  implements Serializable
{
  private List<AnalyticsConfiguration> analyticsConfigurationList;
  private String continuationToken;
  private boolean isTruncated;
  private String nextContinuationToken;
  
  public List<AnalyticsConfiguration> getAnalyticsConfigurationList()
  {
    return analyticsConfigurationList;
  }
  
  public void setAnalyticsConfigurationList(List<AnalyticsConfiguration> analyticsConfigurationList)
  {
    this.analyticsConfigurationList = analyticsConfigurationList;
  }
  
  public ListBucketAnalyticsConfigurationsResult withAnalyticsConfigurationList(List<AnalyticsConfiguration> analyticsConfigurationList)
  {
    setAnalyticsConfigurationList(analyticsConfigurationList);
    return this;
  }
  
  public boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setTruncated(boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public ListBucketAnalyticsConfigurationsResult withTruncated(boolean isTruncated)
  {
    setTruncated(isTruncated);
    return this;
  }
  
  public String getContinuationToken()
  {
    return continuationToken;
  }
  
  public void setContinuationToken(String continuationToken)
  {
    this.continuationToken = continuationToken;
  }
  
  public ListBucketAnalyticsConfigurationsResult withContinuationToken(String continuationToken)
  {
    setContinuationToken(continuationToken);
    return this;
  }
  
  public String getNextContinuationToken()
  {
    return nextContinuationToken;
  }
  
  public void setNextContinuationToken(String nextContinuationToken)
  {
    this.nextContinuationToken = nextContinuationToken;
  }
  
  public ListBucketAnalyticsConfigurationsResult withNextContinuationToken(String nextContinuationToken)
  {
    setNextContinuationToken(nextContinuationToken);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */