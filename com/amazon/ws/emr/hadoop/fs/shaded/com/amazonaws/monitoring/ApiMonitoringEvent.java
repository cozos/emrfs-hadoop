package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

public abstract class ApiMonitoringEvent
  implements MonitoringEvent
{
  protected String api;
  protected String service;
  protected String clientId;
  protected Long timestamp;
  protected Integer version;
  protected String region;
  protected String userAgent;
  
  public String getApi()
  {
    return api;
  }
  
  public String getService()
  {
    return service;
  }
  
  public abstract ApiMonitoringEvent withService(String paramString);
  
  public String getClientId()
  {
    return clientId;
  }
  
  public abstract ApiMonitoringEvent withClientId(String paramString);
  
  public Long getTimestamp()
  {
    return timestamp;
  }
  
  public abstract ApiMonitoringEvent withTimestamp(Long paramLong);
  
  public abstract ApiMonitoringEvent withApi(String paramString);
  
  public Integer getVersion()
  {
    return version;
  }
  
  public abstract ApiMonitoringEvent withVersion(Integer paramInteger);
  
  public String getRegion()
  {
    return region;
  }
  
  public abstract ApiMonitoringEvent withRegion(String paramString);
  
  public String getUserAgent()
  {
    return userAgent;
  }
  
  public abstract ApiMonitoringEvent withUserAgent(String paramString);
  
  public abstract String getType();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.ApiMonitoringEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */