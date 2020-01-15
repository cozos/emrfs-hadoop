package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;

public class MetricStat
  implements Serializable, Cloneable
{
  private Metric metric;
  private Integer period;
  private String stat;
  private String unit;
  
  public void setMetric(Metric metric)
  {
    this.metric = metric;
  }
  
  public Metric getMetric()
  {
    return metric;
  }
  
  public MetricStat withMetric(Metric metric)
  {
    setMetric(metric);
    return this;
  }
  
  public void setPeriod(Integer period)
  {
    this.period = period;
  }
  
  public Integer getPeriod()
  {
    return period;
  }
  
  public MetricStat withPeriod(Integer period)
  {
    setPeriod(period);
    return this;
  }
  
  public void setStat(String stat)
  {
    this.stat = stat;
  }
  
  public String getStat()
  {
    return stat;
  }
  
  public MetricStat withStat(String stat)
  {
    setStat(stat);
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
  
  public MetricStat withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public MetricStat withUnit(StandardUnit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetric() != null) {
      sb.append("Metric: ").append(getMetric()).append(",");
    }
    if (getPeriod() != null) {
      sb.append("Period: ").append(getPeriod()).append(",");
    }
    if (getStat() != null) {
      sb.append("Stat: ").append(getStat()).append(",");
    }
    if (getUnit() != null) {
      sb.append("Unit: ").append(getUnit());
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
    if (!(obj instanceof MetricStat)) {
      return false;
    }
    MetricStat other = (MetricStat)obj;
    if (((other.getMetric() == null ? 1 : 0) ^ (getMetric() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetric() != null) && (!other.getMetric().equals(getMetric()))) {
      return false;
    }
    if (((other.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPeriod() != null) && (!other.getPeriod().equals(getPeriod()))) {
      return false;
    }
    if (((other.getStat() == null ? 1 : 0) ^ (getStat() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStat() != null) && (!other.getStat().equals(getStat()))) {
      return false;
    }
    if (((other.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnit() != null) && (!other.getUnit().equals(getUnit()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMetric() == null ? 0 : getMetric().hashCode());
    hashCode = 31 * hashCode + (getPeriod() == null ? 0 : getPeriod().hashCode());
    hashCode = 31 * hashCode + (getStat() == null ? 0 : getStat().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    return hashCode;
  }
  
  public MetricStat clone()
  {
    try
    {
      return (MetricStat)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricStat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */