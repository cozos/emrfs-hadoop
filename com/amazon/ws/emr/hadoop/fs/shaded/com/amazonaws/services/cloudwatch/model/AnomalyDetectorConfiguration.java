package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AnomalyDetectorConfiguration
  implements Serializable, Cloneable
{
  private SdkInternalList<Range> excludedTimeRanges;
  private String metricTimezone;
  
  public List<Range> getExcludedTimeRanges()
  {
    if (excludedTimeRanges == null) {
      excludedTimeRanges = new SdkInternalList();
    }
    return excludedTimeRanges;
  }
  
  public void setExcludedTimeRanges(Collection<Range> excludedTimeRanges)
  {
    if (excludedTimeRanges == null)
    {
      this.excludedTimeRanges = null;
      return;
    }
    this.excludedTimeRanges = new SdkInternalList(excludedTimeRanges);
  }
  
  public AnomalyDetectorConfiguration withExcludedTimeRanges(Range... excludedTimeRanges)
  {
    if (this.excludedTimeRanges == null) {
      setExcludedTimeRanges(new SdkInternalList(excludedTimeRanges.length));
    }
    for (Range ele : excludedTimeRanges) {
      this.excludedTimeRanges.add(ele);
    }
    return this;
  }
  
  public AnomalyDetectorConfiguration withExcludedTimeRanges(Collection<Range> excludedTimeRanges)
  {
    setExcludedTimeRanges(excludedTimeRanges);
    return this;
  }
  
  public void setMetricTimezone(String metricTimezone)
  {
    this.metricTimezone = metricTimezone;
  }
  
  public String getMetricTimezone()
  {
    return metricTimezone;
  }
  
  public AnomalyDetectorConfiguration withMetricTimezone(String metricTimezone)
  {
    setMetricTimezone(metricTimezone);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getExcludedTimeRanges() != null) {
      sb.append("ExcludedTimeRanges: ").append(getExcludedTimeRanges()).append(",");
    }
    if (getMetricTimezone() != null) {
      sb.append("MetricTimezone: ").append(getMetricTimezone());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof AnomalyDetectorConfiguration)) {
      return false;
    }
    AnomalyDetectorConfiguration other = (AnomalyDetectorConfiguration)obj;
    if (((other.getExcludedTimeRanges() == null ? 1 : 0) ^ (getExcludedTimeRanges() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExcludedTimeRanges() != null) && (!other.getExcludedTimeRanges().equals(getExcludedTimeRanges()))) {
      return false;
    }
    if (((other.getMetricTimezone() == null ? 1 : 0) ^ (getMetricTimezone() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricTimezone() != null) && (!other.getMetricTimezone().equals(getMetricTimezone()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getExcludedTimeRanges() == null ? 0 : getExcludedTimeRanges().hashCode());
    hashCode = 31 * hashCode + (getMetricTimezone() == null ? 0 : getMetricTimezone().hashCode());
    return hashCode;
  }
  
  public AnomalyDetectorConfiguration clone()
  {
    try
    {
      return (AnomalyDetectorConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AnomalyDetectorConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */