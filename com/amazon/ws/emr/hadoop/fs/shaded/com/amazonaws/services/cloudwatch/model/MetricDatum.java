package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MetricDatum
  implements Serializable, Cloneable
{
  private String metricName;
  private SdkInternalList<Dimension> dimensions;
  private Date timestamp;
  private Double value;
  private StatisticSet statisticValues;
  private SdkInternalList<Double> values;
  private SdkInternalList<Double> counts;
  private String unit;
  private Integer storageResolution;
  
  public void setMetricName(String metricName)
  {
    this.metricName = metricName;
  }
  
  public String getMetricName()
  {
    return metricName;
  }
  
  public MetricDatum withMetricName(String metricName)
  {
    setMetricName(metricName);
    return this;
  }
  
  public List<Dimension> getDimensions()
  {
    if (dimensions == null) {
      dimensions = new SdkInternalList();
    }
    return dimensions;
  }
  
  public void setDimensions(Collection<Dimension> dimensions)
  {
    if (dimensions == null)
    {
      this.dimensions = null;
      return;
    }
    this.dimensions = new SdkInternalList(dimensions);
  }
  
  public MetricDatum withDimensions(Dimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (Dimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public MetricDatum withDimensions(Collection<Dimension> dimensions)
  {
    setDimensions(dimensions);
    return this;
  }
  
  public void setTimestamp(Date timestamp)
  {
    this.timestamp = timestamp;
  }
  
  public Date getTimestamp()
  {
    return timestamp;
  }
  
  public MetricDatum withTimestamp(Date timestamp)
  {
    setTimestamp(timestamp);
    return this;
  }
  
  public void setValue(Double value)
  {
    this.value = value;
  }
  
  public Double getValue()
  {
    return value;
  }
  
  public MetricDatum withValue(Double value)
  {
    setValue(value);
    return this;
  }
  
  public void setStatisticValues(StatisticSet statisticValues)
  {
    this.statisticValues = statisticValues;
  }
  
  public StatisticSet getStatisticValues()
  {
    return statisticValues;
  }
  
  public MetricDatum withStatisticValues(StatisticSet statisticValues)
  {
    setStatisticValues(statisticValues);
    return this;
  }
  
  public List<Double> getValues()
  {
    if (values == null) {
      values = new SdkInternalList();
    }
    return values;
  }
  
  public void setValues(Collection<Double> values)
  {
    if (values == null)
    {
      this.values = null;
      return;
    }
    this.values = new SdkInternalList(values);
  }
  
  public MetricDatum withValues(Double... values)
  {
    if (this.values == null) {
      setValues(new SdkInternalList(values.length));
    }
    for (Double ele : values) {
      this.values.add(ele);
    }
    return this;
  }
  
  public MetricDatum withValues(Collection<Double> values)
  {
    setValues(values);
    return this;
  }
  
  public List<Double> getCounts()
  {
    if (counts == null) {
      counts = new SdkInternalList();
    }
    return counts;
  }
  
  public void setCounts(Collection<Double> counts)
  {
    if (counts == null)
    {
      this.counts = null;
      return;
    }
    this.counts = new SdkInternalList(counts);
  }
  
  public MetricDatum withCounts(Double... counts)
  {
    if (this.counts == null) {
      setCounts(new SdkInternalList(counts.length));
    }
    for (Double ele : counts) {
      this.counts.add(ele);
    }
    return this;
  }
  
  public MetricDatum withCounts(Collection<Double> counts)
  {
    setCounts(counts);
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
  
  public MetricDatum withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public void setUnit(StandardUnit unit)
  {
    withUnit(unit);
  }
  
  public MetricDatum withUnit(StandardUnit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public void setStorageResolution(Integer storageResolution)
  {
    this.storageResolution = storageResolution;
  }
  
  public Integer getStorageResolution()
  {
    return storageResolution;
  }
  
  public MetricDatum withStorageResolution(Integer storageResolution)
  {
    setStorageResolution(storageResolution);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricName() != null) {
      sb.append("MetricName: ").append(getMetricName()).append(",");
    }
    if (getDimensions() != null) {
      sb.append("Dimensions: ").append(getDimensions()).append(",");
    }
    if (getTimestamp() != null) {
      sb.append("Timestamp: ").append(getTimestamp()).append(",");
    }
    if (getValue() != null) {
      sb.append("Value: ").append(getValue()).append(",");
    }
    if (getStatisticValues() != null) {
      sb.append("StatisticValues: ").append(getStatisticValues()).append(",");
    }
    if (getValues() != null) {
      sb.append("Values: ").append(getValues()).append(",");
    }
    if (getCounts() != null) {
      sb.append("Counts: ").append(getCounts()).append(",");
    }
    if (getUnit() != null) {
      sb.append("Unit: ").append(getUnit()).append(",");
    }
    if (getStorageResolution() != null) {
      sb.append("StorageResolution: ").append(getStorageResolution());
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
    if (!(obj instanceof MetricDatum)) {
      return false;
    }
    MetricDatum other = (MetricDatum)obj;
    if (((other.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricName() != null) && (!other.getMetricName().equals(getMetricName()))) {
      return false;
    }
    if (((other.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDimensions() != null) && (!other.getDimensions().equals(getDimensions()))) {
      return false;
    }
    if (((other.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimestamp() != null) && (!other.getTimestamp().equals(getTimestamp()))) {
      return false;
    }
    if (((other.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValue() != null) && (!other.getValue().equals(getValue()))) {
      return false;
    }
    if (((other.getStatisticValues() == null ? 1 : 0) ^ (getStatisticValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatisticValues() != null) && (!other.getStatisticValues().equals(getStatisticValues()))) {
      return false;
    }
    if (((other.getValues() == null ? 1 : 0) ^ (getValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValues() != null) && (!other.getValues().equals(getValues()))) {
      return false;
    }
    if (((other.getCounts() == null ? 1 : 0) ^ (getCounts() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCounts() != null) && (!other.getCounts().equals(getCounts()))) {
      return false;
    }
    if (((other.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnit() != null) && (!other.getUnit().equals(getUnit()))) {
      return false;
    }
    if (((other.getStorageResolution() == null ? 1 : 0) ^ (getStorageResolution() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStorageResolution() != null) && (!other.getStorageResolution().equals(getStorageResolution()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMetricName() == null ? 0 : getMetricName().hashCode());
    hashCode = 31 * hashCode + (getDimensions() == null ? 0 : getDimensions().hashCode());
    hashCode = 31 * hashCode + (getTimestamp() == null ? 0 : getTimestamp().hashCode());
    hashCode = 31 * hashCode + (getValue() == null ? 0 : getValue().hashCode());
    hashCode = 31 * hashCode + (getStatisticValues() == null ? 0 : getStatisticValues().hashCode());
    hashCode = 31 * hashCode + (getValues() == null ? 0 : getValues().hashCode());
    hashCode = 31 * hashCode + (getCounts() == null ? 0 : getCounts().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    hashCode = 31 * hashCode + (getStorageResolution() == null ? 0 : getStorageResolution().hashCode());
    return hashCode;
  }
  
  public MetricDatum clone()
  {
    try
    {
      return (MetricDatum)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDatum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */