package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class AnalyticsConfiguration
  implements Serializable
{
  private String id;
  private AnalyticsFilter filter;
  private StorageClassAnalysis storageClassAnalysis;
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public AnalyticsConfiguration withId(String id)
  {
    setId(id);
    return this;
  }
  
  public AnalyticsFilter getFilter()
  {
    return filter;
  }
  
  public void setFilter(AnalyticsFilter filter)
  {
    this.filter = filter;
  }
  
  public AnalyticsConfiguration withFilter(AnalyticsFilter filter)
  {
    setFilter(filter);
    return this;
  }
  
  public StorageClassAnalysis getStorageClassAnalysis()
  {
    return storageClassAnalysis;
  }
  
  public void setStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis)
  {
    this.storageClassAnalysis = storageClassAnalysis;
  }
  
  public AnalyticsConfiguration withStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis)
  {
    setStorageClassAnalysis(storageClassAnalysis);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */