package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSServiceMetrics;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class AwsSdkMetrics$MetricRegistry
{
  private final Set<MetricType> metricTypes = new HashSet();
  private volatile Set<MetricType> readOnly;
  
  AwsSdkMetrics$MetricRegistry()
  {
    metricTypes.add(AWSRequestMetrics.Field.ClientExecuteTime);
    metricTypes.add(AWSRequestMetrics.Field.Exception);
    metricTypes.add(AWSRequestMetrics.Field.ThrottleException);
    metricTypes.add(AWSRequestMetrics.Field.HttpClientRetryCount);
    metricTypes.add(AWSRequestMetrics.Field.HttpRequestTime);
    metricTypes.add(AWSRequestMetrics.Field.RequestCount);
    
    metricTypes.add(AWSRequestMetrics.Field.RetryCount);
    metricTypes.add(AWSRequestMetrics.Field.RetryCapacityConsumed);
    metricTypes.add(AWSRequestMetrics.Field.ThrottledRetryCount);
    metricTypes.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
    metricTypes.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
    metricTypes.add(AWSRequestMetrics.Field.HttpSocketReadTime);
    metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolAvailableCount);
    metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolLeasedCount);
    metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolPendingCount);
    metricTypes.add(AWSServiceMetrics.HttpClientGetConnectionTime);
    syncReadOnly();
  }
  
  private void syncReadOnly()
  {
    readOnly = Collections.unmodifiableSet(new HashSet(metricTypes));
  }
  
  public boolean addMetricType(MetricType type)
  {
    synchronized (metricTypes)
    {
      boolean added = metricTypes.add(type);
      if (added) {
        syncReadOnly();
      }
      return added;
    }
  }
  
  public <T extends MetricType> boolean addMetricTypes(Collection<T> types)
  {
    synchronized (metricTypes)
    {
      boolean added = metricTypes.addAll(types);
      if (added) {
        syncReadOnly();
      }
      return added;
    }
  }
  
  public <T extends MetricType> void setMetricTypes(Collection<T> types)
  {
    synchronized (metricTypes)
    {
      if ((types == null) || (types.size() == 0))
      {
        if (metricTypes.size() == 0) {
          return;
        }
        if (types == null) {
          types = Collections.emptyList();
        }
      }
      metricTypes.clear();
      if (!addMetricTypes(types)) {
        syncReadOnly();
      }
    }
  }
  
  public boolean removeMetricType(MetricType type)
  {
    synchronized (metricTypes)
    {
      boolean removed = metricTypes.remove(type);
      if (removed) {
        syncReadOnly();
      }
      return removed;
    }
  }
  
  public Set<MetricType> predefinedMetrics()
  {
    return readOnly;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics.MetricRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */