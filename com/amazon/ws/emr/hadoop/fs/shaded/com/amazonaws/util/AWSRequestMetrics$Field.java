package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricType;

public enum AWSRequestMetrics$Field
  implements RequestMetricType
{
  AWSErrorCode,  AWSRequestID,  RequestType,  BytesProcessed,  ClientExecuteTime,  CredentialsRequestTime,  Exception,  ThrottleException,  HttpRequestTime,  RedirectLocation,  RequestMarshallTime,  RequestSigningTime,  ResponseProcessingTime,  RequestCount,  RetryCount,  RetryCapacityConsumed,  ThrottledRetryCount,  HttpClientRetryCount,  HttpClientSendRequestTime,  HttpClientReceiveResponseTime,  HttpSocketReadTime,  HttpClientPoolAvailableCount,  HttpClientPoolLeasedCount,  HttpClientPoolPendingCount,  RetryPauseTime,  ServiceEndpoint,  ServiceName,  StatusCode;
  
  private AWSRequestMetrics$Field() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */