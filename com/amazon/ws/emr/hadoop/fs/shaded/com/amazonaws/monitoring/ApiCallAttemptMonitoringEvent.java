package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

public class ApiCallAttemptMonitoringEvent
  extends ApiMonitoringEvent
{
  public static final String API_CALL_ATTEMPT_MONITORING_EVENT_TYPE = "ApiCallAttempt";
  private String fqdn;
  private String accessKey;
  private String sessionToken;
  private Integer httpStatusCode;
  private String xAmznRequestId;
  private String xAmzRequestId;
  private String xAmzId2;
  private String awsException;
  private String awsExceptionMessage;
  private String sdkException;
  private String sdkExceptionMessage;
  private Long attemptLatency;
  private Long requestLatency;
  
  public ApiCallAttemptMonitoringEvent withApi(String api)
  {
    this.api = api;
    return this;
  }
  
  public ApiCallAttemptMonitoringEvent withVersion(Integer version)
  {
    this.version = version;
    return this;
  }
  
  public ApiCallAttemptMonitoringEvent withUserAgent(String userAgent)
  {
    this.userAgent = userAgent;
    return this;
  }
  
  public ApiCallAttemptMonitoringEvent withService(String service)
  {
    this.service = service;
    return this;
  }
  
  public ApiCallAttemptMonitoringEvent withClientId(String clientId)
  {
    this.clientId = clientId;
    return this;
  }
  
  public ApiCallAttemptMonitoringEvent withTimestamp(Long timestamp)
  {
    this.timestamp = timestamp;
    return this;
  }
  
  public String getFqdn()
  {
    return fqdn;
  }
  
  public ApiCallAttemptMonitoringEvent withFqdn(String fqdn)
  {
    this.fqdn = fqdn;
    return this;
  }
  
  public ApiCallAttemptMonitoringEvent withRegion(String region)
  {
    this.region = region;
    return this;
  }
  
  public String getAccessKey()
  {
    return accessKey;
  }
  
  public ApiCallAttemptMonitoringEvent withAccessKey(String accessKey)
  {
    this.accessKey = accessKey;
    return this;
  }
  
  public String getSessionToken()
  {
    return sessionToken;
  }
  
  public ApiCallAttemptMonitoringEvent withSessionToken(String sessionToken)
  {
    this.sessionToken = sessionToken;
    return this;
  }
  
  public Integer getHttpStatusCode()
  {
    return httpStatusCode;
  }
  
  public ApiCallAttemptMonitoringEvent withHttpStatusCode(Integer httpStatusCode)
  {
    this.httpStatusCode = httpStatusCode;
    return this;
  }
  
  public String getxAmznRequestId()
  {
    return xAmznRequestId;
  }
  
  public ApiCallAttemptMonitoringEvent withXAmznRequestId(String xAmznRequestId)
  {
    this.xAmznRequestId = xAmznRequestId;
    return this;
  }
  
  public String getxAmzRequestId()
  {
    return xAmzRequestId;
  }
  
  public ApiCallAttemptMonitoringEvent withXAmzRequestId(String xAmzRequestId)
  {
    this.xAmzRequestId = xAmzRequestId;
    return this;
  }
  
  public String getxAmzId2()
  {
    return xAmzId2;
  }
  
  public ApiCallAttemptMonitoringEvent withXAmzId2(String xAmzId2)
  {
    this.xAmzId2 = xAmzId2;
    return this;
  }
  
  public String getAwsException()
  {
    return awsException;
  }
  
  public ApiCallAttemptMonitoringEvent withAwsException(String awsException)
  {
    this.awsException = awsException;
    return this;
  }
  
  public String getAwsExceptionMessage()
  {
    return awsExceptionMessage;
  }
  
  public ApiCallAttemptMonitoringEvent withAwsExceptionMessage(String awsExceptionMessage)
  {
    this.awsExceptionMessage = awsExceptionMessage;
    return this;
  }
  
  public String getSdkException()
  {
    return sdkException;
  }
  
  public ApiCallAttemptMonitoringEvent withSdkException(String sdkException)
  {
    this.sdkException = sdkException;
    return this;
  }
  
  public String getSdkExceptionMessage()
  {
    return sdkExceptionMessage;
  }
  
  public ApiCallAttemptMonitoringEvent withSdkExceptionMessage(String sdkExceptionMessage)
  {
    this.sdkExceptionMessage = sdkExceptionMessage;
    return this;
  }
  
  public Long getAttemptLatency()
  {
    return attemptLatency;
  }
  
  public ApiCallAttemptMonitoringEvent withAttemptLatency(Long attemptLatency)
  {
    this.attemptLatency = attemptLatency;
    return this;
  }
  
  public Long getRequestLatency()
  {
    return requestLatency;
  }
  
  public ApiCallAttemptMonitoringEvent withRequestLatency(Long requestLatency)
  {
    this.requestLatency = requestLatency;
    return this;
  }
  
  public String getType()
  {
    return "ApiCallAttempt";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.ApiCallAttemptMonitoringEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */