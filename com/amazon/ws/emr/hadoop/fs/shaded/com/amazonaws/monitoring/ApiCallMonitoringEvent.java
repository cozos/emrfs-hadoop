package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

public class ApiCallMonitoringEvent
  extends ApiMonitoringEvent
{
  public static final String API_CALL_MONITORING_EVENT_TYPE = "ApiCall";
  private Integer attemptCount;
  private Long latency;
  private int apiCallTimeout;
  private int maxRetriesExceeded;
  private String finalAwsException;
  private String finalAwsExceptionMessage;
  private String finalSdkException;
  private String finalSdkExceptionMessage;
  private Integer finalHttpStatusCode;
  
  public ApiCallMonitoringEvent withApi(String api)
  {
    this.api = api;
    return this;
  }
  
  public ApiCallMonitoringEvent withVersion(Integer version)
  {
    this.version = version;
    return this;
  }
  
  public ApiCallMonitoringEvent withUserAgent(String userAgent)
  {
    this.userAgent = userAgent;
    return this;
  }
  
  public ApiCallMonitoringEvent withRegion(String region)
  {
    this.region = region;
    return this;
  }
  
  public ApiCallMonitoringEvent withService(String service)
  {
    this.service = service;
    return this;
  }
  
  public ApiCallMonitoringEvent withClientId(String clientId)
  {
    this.clientId = clientId;
    return this;
  }
  
  public ApiCallMonitoringEvent withTimestamp(Long timestamp)
  {
    this.timestamp = timestamp;
    return this;
  }
  
  public Integer getAttemptCount()
  {
    return attemptCount;
  }
  
  public ApiCallMonitoringEvent withAttemptCount(Integer attemptCount)
  {
    this.attemptCount = attemptCount;
    return this;
  }
  
  public Long getLatency()
  {
    return latency;
  }
  
  public ApiCallMonitoringEvent withLatency(Long latency)
  {
    this.latency = latency;
    return this;
  }
  
  public int getApiCallTimeout()
  {
    return apiCallTimeout;
  }
  
  public ApiCallMonitoringEvent withApiCallTimeout(int apiCallTimeout)
  {
    this.apiCallTimeout = apiCallTimeout;
    return this;
  }
  
  public int getMaxRetriesExceeded()
  {
    return maxRetriesExceeded;
  }
  
  public ApiCallMonitoringEvent withMaxRetriesExceeded(int maxRetriesExceeded)
  {
    this.maxRetriesExceeded = maxRetriesExceeded;
    return this;
  }
  
  public String getFinalAwsException()
  {
    return finalAwsException;
  }
  
  public ApiCallMonitoringEvent withFinalAwsException(String finalAwsException)
  {
    this.finalAwsException = finalAwsException;
    return this;
  }
  
  public String getFinalAwsExceptionMessage()
  {
    return finalAwsExceptionMessage;
  }
  
  public ApiCallMonitoringEvent withFinalAwsExceptionMessage(String finalAwsExceptionMessage)
  {
    this.finalAwsExceptionMessage = finalAwsExceptionMessage;
    return this;
  }
  
  public String getFinalSdkException()
  {
    return finalSdkException;
  }
  
  public ApiCallMonitoringEvent withFinalSdkException(String finalSdkException)
  {
    this.finalSdkException = finalSdkException;
    return this;
  }
  
  public String getFinalSdkExceptionMessage()
  {
    return finalSdkExceptionMessage;
  }
  
  public ApiCallMonitoringEvent withFinalSdkExceptionMessage(String finalSdkExceptionMessage)
  {
    this.finalSdkExceptionMessage = finalSdkExceptionMessage;
    return this;
  }
  
  public Integer getFinalHttpStatusCode()
  {
    return finalHttpStatusCode;
  }
  
  public ApiCallMonitoringEvent withFinalHttpStatusCode(Integer finalHttpStatusCode)
  {
    this.finalHttpStatusCode = finalHttpStatusCode;
    return this;
  }
  
  public String getType()
  {
    return "ApiCall";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.ApiCallMonitoringEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */