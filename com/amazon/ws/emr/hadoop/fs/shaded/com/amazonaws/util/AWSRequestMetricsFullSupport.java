package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@NotThreadSafe
public class AWSRequestMetricsFullSupport
  extends AWSRequestMetrics
{
  private final Map<String, List<Object>> properties = new HashMap();
  private final Map<String, TimingInfo> eventsBeingProfiled = new HashMap();
  private static final Log latencyLogger = LogFactory.getLog("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.latency");
  private static final Object KEY_VALUE_SEPARATOR = "=";
  private static final Object COMMA_SEPARATOR = ", ";
  
  public AWSRequestMetricsFullSupport()
  {
    super(TimingInfo.startTimingFullSupport());
  }
  
  public void startEvent(String eventName)
  {
    eventsBeingProfiled.put(eventName, TimingInfo.startTimingFullSupport(System.currentTimeMillis(), System.nanoTime()));
  }
  
  public void startEvent(MetricType f)
  {
    startEvent(f.name());
  }
  
  public void endEvent(String eventName)
  {
    TimingInfo event = (TimingInfo)eventsBeingProfiled.get(eventName);
    if (event == null)
    {
      LogFactory.getLog(getClass()).warn("Trying to end an event which was never started: " + eventName);
      return;
    }
    event.endTiming();
    timingInfo.addSubMeasurement(eventName, 
    
      TimingInfo.unmodifiableTimingInfo(event
      .getStartEpochTimeMilliIfKnown().longValue(), event
      .getStartTimeNano(), 
      Long.valueOf(event.getEndTimeNano())));
  }
  
  public void endEvent(MetricType f)
  {
    endEvent(f.name());
  }
  
  public void incrementCounter(String event)
  {
    timingInfo.incrementCounter(event);
  }
  
  public void incrementCounter(MetricType f)
  {
    incrementCounter(f.name());
  }
  
  public void setCounter(String counterName, long count)
  {
    timingInfo.setCounter(counterName, count);
  }
  
  public void setCounter(MetricType f, long count)
  {
    setCounter(f.name(), count);
  }
  
  public void addProperty(String propertyName, Object value)
  {
    List<Object> propertyList = (List)properties.get(propertyName);
    if (propertyList == null)
    {
      propertyList = new ArrayList();
      properties.put(propertyName, propertyList);
    }
    propertyList.add(value);
  }
  
  public void addProperty(MetricType f, Object value)
  {
    addProperty(f.name(), value);
  }
  
  public void log()
  {
    if (latencyLogger.isDebugEnabled())
    {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<String, List<Object>> entry : properties.entrySet()) {
        keyValueFormat(entry.getKey(), entry.getValue(), builder);
      }
      for (Map.Entry<String, Number> entry : timingInfo.getAllCounters()
        .entrySet()) {
        keyValueFormat(entry.getKey(), entry.getValue(), builder);
      }
      for (Map.Entry<String, List<TimingInfo>> entry : timingInfo
        .getSubMeasurementsByName().entrySet()) {
        keyValueFormat(entry.getKey(), entry.getValue(), builder);
      }
      latencyLogger.debug(builder.toString());
    }
  }
  
  private void keyValueFormat(Object key, Object value, StringBuilder builder)
  {
    builder.append(key).append(KEY_VALUE_SEPARATOR).append(value).append(COMMA_SEPARATOR);
  }
  
  public List<Object> getProperty(String propertyName)
  {
    return (List)properties.get(propertyName);
  }
  
  public List<Object> getProperty(MetricType f)
  {
    return getProperty(f.name());
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetricsFullSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */