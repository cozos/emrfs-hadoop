package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

@NotThreadSafe
public class ServiceLatencyProvider
{
  private final long startNano = System.nanoTime();
  private long endNano = startNano;
  private final ServiceMetricType serviceMetricType;
  
  public ServiceLatencyProvider(ServiceMetricType type)
  {
    serviceMetricType = type;
  }
  
  public ServiceMetricType getServiceMetricType()
  {
    return serviceMetricType;
  }
  
  public ServiceLatencyProvider endTiming()
  {
    if (endNano != startNano) {
      throw new IllegalStateException();
    }
    endNano = System.nanoTime();
    return this;
  }
  
  public double getDurationMilli()
  {
    if (endNano == startNano) {
      LogFactory.getLog(getClass()).debug("Likely to be a missing invocation of endTiming().");
    }
    return TimingInfo.durationMilliOf(startNano, endNano);
  }
  
  public String getProviderId()
  {
    return super.toString();
  }
  
  public String toString()
  {
    return String.format("providerId=%s, serviceMetricType=%s, startNano=%d, endNano=%d", new Object[] {
    
      getProviderId(), serviceMetricType, Long.valueOf(startNano), Long.valueOf(endNano) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceLatencyProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */