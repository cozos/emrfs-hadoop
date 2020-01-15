package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricType;
import java.util.Collections;
import java.util.List;

@NotThreadSafe
public class AWSRequestMetrics
{
  public static final String SIMPLE_NAME = AWSRequestMetrics.class.getSimpleName();
  protected final TimingInfo timingInfo;
  
  public static enum Field
    implements RequestMetricType
  {
    AWSErrorCode,  AWSRequestID,  RequestType,  BytesProcessed,  ClientExecuteTime,  CredentialsRequestTime,  Exception,  ThrottleException,  HttpRequestTime,  RedirectLocation,  RequestMarshallTime,  RequestSigningTime,  ResponseProcessingTime,  RequestCount,  RetryCount,  RetryCapacityConsumed,  ThrottledRetryCount,  HttpClientRetryCount,  HttpClientSendRequestTime,  HttpClientReceiveResponseTime,  HttpSocketReadTime,  HttpClientPoolAvailableCount,  HttpClientPoolLeasedCount,  HttpClientPoolPendingCount,  RetryPauseTime,  ServiceEndpoint,  ServiceName,  StatusCode;
    
    private Field() {}
  }
  
  public AWSRequestMetrics()
  {
    timingInfo = TimingInfo.startTiming();
  }
  
  protected AWSRequestMetrics(TimingInfo timingInfo)
  {
    this.timingInfo = timingInfo;
  }
  
  public final TimingInfo getTimingInfo()
  {
    return timingInfo;
  }
  
  public boolean isEnabled()
  {
    return false;
  }
  
  public void startEvent(String eventName) {}
  
  public void startEvent(MetricType f) {}
  
  public void endEvent(String eventName) {}
  
  public void endEvent(MetricType f) {}
  
  public void incrementCounter(String event) {}
  
  public void incrementCounter(MetricType f) {}
  
  public final AWSRequestMetrics incrementCounterWith(String event)
  {
    incrementCounter(event);
    return this;
  }
  
  public final AWSRequestMetrics incrementCounterWith(MetricType f)
  {
    incrementCounter(f);
    return this;
  }
  
  public void setCounter(String counterName, long count) {}
  
  public void setCounter(MetricType f, long count) {}
  
  public final AWSRequestMetrics withCounter(String counterName, long count)
  {
    setCounter(counterName, count);
    return this;
  }
  
  public final AWSRequestMetrics withCounter(MetricType f, long count)
  {
    setCounter(f, count);
    return this;
  }
  
  public void addProperty(String propertyName, Object value) {}
  
  public void addProperty(MetricType f, Object value) {}
  
  public final AWSRequestMetrics addPropertyWith(String propertyName, Object value)
  {
    addProperty(propertyName, value);
    return this;
  }
  
  public final AWSRequestMetrics addPropertyWith(MetricType f, Object value)
  {
    addProperty(f, value);
    return this;
  }
  
  public void log() {}
  
  public List<Object> getProperty(String propertyName)
  {
    return Collections.emptyList();
  }
  
  public List<Object> getProperty(MetricType f)
  {
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */