package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;

public class StatisticSet
  implements Serializable, Cloneable
{
  private Double sampleCount;
  private Double sum;
  private Double minimum;
  private Double maximum;
  
  public void setSampleCount(Double sampleCount)
  {
    this.sampleCount = sampleCount;
  }
  
  public Double getSampleCount()
  {
    return sampleCount;
  }
  
  public StatisticSet withSampleCount(Double sampleCount)
  {
    setSampleCount(sampleCount);
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
  
  public StatisticSet withSum(Double sum)
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
  
  public StatisticSet withMinimum(Double minimum)
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
  
  public StatisticSet withMaximum(Double maximum)
  {
    setMaximum(maximum);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSampleCount() != null) {
      sb.append("SampleCount: ").append(getSampleCount()).append(",");
    }
    if (getSum() != null) {
      sb.append("Sum: ").append(getSum()).append(",");
    }
    if (getMinimum() != null) {
      sb.append("Minimum: ").append(getMinimum()).append(",");
    }
    if (getMaximum() != null) {
      sb.append("Maximum: ").append(getMaximum());
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
    if (!(obj instanceof StatisticSet)) {
      return false;
    }
    StatisticSet other = (StatisticSet)obj;
    if (((other.getSampleCount() == null ? 1 : 0) ^ (getSampleCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSampleCount() != null) && (!other.getSampleCount().equals(getSampleCount()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSampleCount() == null ? 0 : getSampleCount().hashCode());
    hashCode = 31 * hashCode + (getSum() == null ? 0 : getSum().hashCode());
    hashCode = 31 * hashCode + (getMinimum() == null ? 0 : getMinimum().hashCode());
    hashCode = 31 * hashCode + (getMaximum() == null ? 0 : getMaximum().hashCode());
    return hashCode;
  }
  
  public StatisticSet clone()
  {
    try
    {
      return (StatisticSet)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.StatisticSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */