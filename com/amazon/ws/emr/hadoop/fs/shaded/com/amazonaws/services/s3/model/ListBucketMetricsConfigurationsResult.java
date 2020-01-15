package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;
import java.util.List;

public class ListBucketMetricsConfigurationsResult
  implements Serializable
{
  private List<MetricsConfiguration> metricsConfigurationList;
  private String continuationToken;
  private boolean isTruncated;
  private String nextContinuationToken;
  
  public List<MetricsConfiguration> getMetricsConfigurationList()
  {
    return metricsConfigurationList;
  }
  
  public void setMetricsConfigurationList(List<MetricsConfiguration> metricsConfigurationList)
  {
    this.metricsConfigurationList = metricsConfigurationList;
  }
  
  public ListBucketMetricsConfigurationsResult withMetricsConfigurationList(List<MetricsConfiguration> metricsConfigurationList)
  {
    setMetricsConfigurationList(metricsConfigurationList);
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
  
  public ListBucketMetricsConfigurationsResult withTruncated(boolean isTruncated)
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
  
  public ListBucketMetricsConfigurationsResult withContinuationToken(String continuationToken)
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
  
  public ListBucketMetricsConfigurationsResult withNextContinuationToken(String nextContinuationToken)
  {
    setNextContinuationToken(nextContinuationToken);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */