package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Datapoint
  implements Serializable, Cloneable
{
  private Date timestamp;
  private Double sampleCount;
  private Double average;
  private Double sum;
  private Double minimum;
  private Double maximum;
  private String unit;
  private Map<String, Double> extendedStatistics;
  
  public void setTimestamp(Date timestamp)
  {
    this.timestamp = timestamp;
  }
  
  public Date getTimestamp()
  {
    return timestamp;
  }
  
  public Datapoint withTimestamp(Date timestamp)
  {
    setTimestamp(timestamp);
    return this;
  }
  
  public void setSampleCount(Double sampleCount)
  {
    this.sampleCount = sampleCount;
  }
  
  public Double getSampleCount()
  {
    return sampleCount;
  }
  
  public Datapoint withSampleCount(Double sampleCount)
  {
    setSampleCount(sampleCount);
    return this;
  }
  
  public void setAverage(Double average)
  {
    this.average = average;
  }
  
  public Double getAverage()
  {
    return average;
  }
  
  public Datapoint withAverage(Double average)
  {
    setAverage(average);
    return this;
  }
  
  public void setSum(Double sum)
  {
    this.sum = sum;
  }
  
  public Double getSum()
  {
    return sum;
  }
  
  public Datapoint withSum(Double sum)
  {
    setSum(sum);
    return this;
  }
  
  public void setMinimum(Double minimum)
  {
    this.minimum = minimum;
  }
  
  public Double getMinimum()
  {
    return minimum;
  }
  
  public Datapoint withMinimum(Double minimum)
  {
    setMinimum(minimum);
    return this;
  }
  
  public void setMaximum(Double maximum)
  {
    this.maximum = maximum;
  }
  
  public Double getMaximum()
  {
    return maximum;
  }
  
  public Datapoint withMaximum(Double maximum)
  {
    setMaximum(maximum);
    return this;
  }
  
  public void setUnit(String unit)
  {
    this.unit = unit;
  }
  
  public String getUnit()
  {
    return unit;
  }
  
  public Datapoint withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public void setUnit(StandardUnit unit)
  {
    withUnit(unit);
  }
  
  public Datapoint withUnit(StandardUnit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public Map<String, Double> getExtendedStatistics()
  {
    return extendedStatistics;
  }
  
  public void setExtendedStatistics(Map<String, Double> extendedStatistics)
  {
    this.extendedStatistics = extendedStatistics;
  }
  
  public Datapoint withExtendedStatistics(Map<String, Double> extendedStatistics)
  {
    setExtendedStatistics(extendedStatistics);
    return this;
  }
  
  public Datapoint addExtendedStatisticsEntry(String key, Double value)
  {
    if (null == extendedStatistics) {
      extendedStatistics = new HashMap();
    }
    if (extendedStatistics.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    extendedStatistics.put(key, value);
    return this;
  }
  
  public Datapoint clearExtendedStatisticsEntries()
  {
    extendedStatistics = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTimestamp() != null) {
      sb.append("Timestamp: ").append(getTimestamp()).append(",");
    }
    if (getSampleCount() != null) {
      sb.append("SampleCount: ").append(getSampleCount()).append(",");
    }
    if (getAverage() != null) {
      sb.append("Average: ").append(getAverage()).append(",");
    }
    if (getSum() != null) {
      sb.append("Sum: ").append(getSum()).append(",");
    }
    if (getMinimum() != null) {
      sb.append("Minimum: ").append(getMinimum()).append(",");
    }
    if (getMaximum() != null) {
      sb.append("Maximum: ").append(getMaximum()).append(",");
    }
    if (getUnit() != null) {
      sb.append("Unit: ").append(getUnit()).append(",");
    }
    if (getExtendedStatistics() != null) {
      sb.append("ExtendedStatistics: ").append(getExtendedStatistics());
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
    if (!(obj instanceof Datapoint)) {
      return false;
    }
    Datapoint other = (Datapoint)obj;
    if (((other.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimestamp() != null) && (!other.getTimestamp().equals(getTimestamp()))) {
      return false;
    }
    if (((other.getSampleCount() == null ? 1 : 0) ^ (getSampleCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSampleCount() != null) && (!other.getSampleCount().equals(getSampleCount()))) {
      return false;
    }
    if (((other.getAverage() == null ? 1 : 0) ^ (getAverage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAverage() != null) && (!other.getAverage().equals(getAverage()))) {
      return false;
    }
    if (((other.getSum() == null ? 1 : 0) ^ (getSum() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSum() != null) && (!other.getSum().equals(getSum()))) {
      return false;
    }
    if (((other.getMinimum() == null ? 1 : 0) ^ (getMinimum() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMinimum() != null) && (!other.getMinimum().equals(getMinimum()))) {
      return false;
    }
    if (((other.getMaximum() == null ? 1 : 0) ^ (getMaximum() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaximum() != null) && (!other.getMaximum().equals(getMaximum()))) {
      return false;
    }
    if (((other.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnit() != null) && (!other.getUnit().equals(getUnit()))) {
      return false;
    }
    if (((other.getExtendedStatistics() == null ? 1 : 0) ^ (getExtendedStatistics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExtendedStatistics() != null) && (!other.getExtendedStatistics().equals(getExtendedStatistics()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTimestamp() == null ? 0 : getTimestamp().hashCode());
    hashCode = 31 * hashCode + (getSampleCount() == null ? 0 : getSampleCount().hashCode());
    hashCode = 31 * hashCode + (getAverage() == null ? 0 : getAverage().hashCode());
    hashCode = 31 * hashCode + (getSum() == null ? 0 : getSum().hashCode());
    hashCode = 31 * hashCode + (getMinimum() == null ? 0 : getMinimum().hashCode());
    hashCode = 31 * hashCode + (getMaximum() == null ? 0 : getMaximum().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    hashCode = 31 * hashCode + (getExtendedStatistics() == null ? 0 : getExtendedStatistics().hashCode());
    return hashCode;
  }
  
  public Datapoint clone()
  {
    try
    {
      return (Datapoint)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Datapoint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */