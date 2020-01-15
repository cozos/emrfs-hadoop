package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NotThreadSafe
class TimingInfoFullSupport
  extends TimingInfo
{
  private final Map<String, List<TimingInfo>> subMeasurementsByName = new HashMap();
  private final Map<String, Number> countersByName = new HashMap();
  
  TimingInfoFullSupport(Long startEpochTimeMilli, long startTimeNano, Long endTimeNano)
  {
    super(startEpochTimeMilli, startTimeNano, endTimeNano);
  }
  
  public void addSubMeasurement(String subMeasurementName, TimingInfo ti)
  {
    List<TimingInfo> timings = (List)subMeasurementsByName.get(subMeasurementName);
    if (timings == null)
    {
      timings = new ArrayList();
      subMeasurementsByName.put(subMeasurementName, timings);
    }
    if (ti.isEndTimeKnown()) {
      timings.add(ti);
    } else {
      LogFactory.getLog(getClass()).debug("Skip submeasurement timing info with no end time for " + subMeasurementName);
    }
  }
  
  public TimingInfo getSubMeasurement(String subMeasurementName)
  {
    return getSubMeasurement(subMeasurementName, 0);
  }
  
  public TimingInfo getSubMeasurement(String subMesurementName, int index)
  {
    List<TimingInfo> timings = (List)subMeasurementsByName.get(subMesurementName);
    if ((index < 0) || (timings == null) || (timings.size() == 0) || 
      (index >= timings.size())) {
      return null;
    }
    return (TimingInfo)timings.get(index);
  }
  
  public TimingInfo getLastSubMeasurement(String subMeasurementName)
  {
    if ((subMeasurementsByName == null) || (subMeasurementsByName.size() == 0)) {
      return null;
    }
    List<TimingInfo> timings = (List)subMeasurementsByName.get(subMeasurementName);
    if ((timings == null) || (timings.size() == 0)) {
      return null;
    }
    return (TimingInfo)timings.get(timings.size() - 1);
  }
  
  public List<TimingInfo> getAllSubMeasurements(String subMeasurementName)
  {
    return (List)subMeasurementsByName.get(subMeasurementName);
  }
  
  public Map<String, List<TimingInfo>> getSubMeasurementsByName()
  {
    return subMeasurementsByName;
  }
  
  public Number getCounter(String key)
  {
    return (Number)countersByName.get(key);
  }
  
  public Map<String, Number> getAllCounters()
  {
    return countersByName;
  }
  
  public void setCounter(String key, long count)
  {
    countersByName.put(key, Long.valueOf(count));
  }
  
  public void incrementCounter(String key)
  {
    int count = 0;
    Number counter = getCounter(key);
    if (counter != null) {
      count = counter.intValue();
    }
    setCounter(key, ++count);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfoFullSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */