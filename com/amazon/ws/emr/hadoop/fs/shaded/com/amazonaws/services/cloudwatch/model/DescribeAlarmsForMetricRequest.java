package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsForMetricRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String metricName;
  private String namespace;
  private String statistic;
  private String extendedStatistic;
  private SdkInternalList<Dimension> dimensions;
  private Integer period;
  private String unit;
  
  public void setMetricName(String metricName)
  {
    this.metricName = metricName;
  }
  
  public String getMetricName()
  {
    return metricName;
  }
  
  public DescribeAlarmsForMetricRequest withMetricName(String metricName)
  {
    setMetricName(metricName);
    return this;
  }
  
  public void setNamespace(String namespace)
  {
    this.namespace = namespace;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public DescribeAlarmsForMetricRequest withNamespace(String namespace)
  {
    setNamespace(namespace);
    return this;
  }
  
  public void setStatistic(String statistic)
  {
    this.statistic = statistic;
  }
  
  public String getStatistic()
  {
    return statistic;
  }
  
  public DescribeAlarmsForMetricRequest withStatistic(String statistic)
  {
    setStatistic(statistic);
    return this;
  }
  
  public void setStatistic(Statistic statistic)
  {
    withStatistic(statistic);
  }
  
  public DescribeAlarmsForMetricRequest withStatistic(Statistic statistic)
  {
    this.statistic = statistic.toString();
    return this;
  }
  
  public void setExtendedStatistic(String extendedStatistic)
  {
    this.extendedStatistic = extendedStatistic;
  }
  
  public String getExtendedStatistic()
  {
    return extendedStatistic;
  }
  
  public DescribeAlarmsForMetricRequest withExtendedStatistic(String extendedStatistic)
  {
    setExtendedStatistic(extendedStatistic);
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
  
  public DescribeAlarmsForMetricRequest withDimensions(Dimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (Dimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public DescribeAlarmsForMetricRequest withDimensions(Collection<Dimension> dimensions)
  {
    setDimensions(dimensions);
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
  
  public DescribeAlarmsForMetricRequest withPeriod(Integer period)
  {
    setPeriod(period);
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
  
  public DescribeAlarmsForMetricRequest withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public void setUnit(StandardUnit unit)
  {
    withUnit(unit);
  }
  
  public DescribeAlarmsForMetricRequest withUnit(StandardUnit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricName() != null) {
      sb.append("MetricName: ").append(getMetricName()).append(",");
    }
    if (getNamespace() != null) {
      sb.append("Namespace: ").append(getNamespace()).append(",");
    }
    if (getStatistic() != null) {
      sb.append("Statistic: ").append(getStatistic()).append(",");
    }
    if (getExtendedStatistic() != null) {
      sb.append("ExtendedStatistic: ").append(getExtendedStatistic()).append(",");
    }
    if (getDimensions() != null) {
      sb.append("Dimensions: ").append(getDimensions()).append(",");
    }
    if (getPeriod() != null) {
      sb.append("Period: ").append(getPeriod()).append(",");
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
    if (!(obj instanceof DescribeAlarmsForMetricRequest)) {
      return false;
    }
    DescribeAlarmsForMetricRequest other = (DescribeAlarmsForMetricRequest)obj;
    if (((other.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricName() != null) && (!other.getMetricName().equals(getMetricName()))) {
      return false;
    }
    if (((other.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNamespace() != null) && (!other.getNamespace().equals(getNamespace()))) {
      return false;
    }
    if (((other.getStatistic() == null ? 1 : 0) ^ (getStatistic() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatistic() != null) && (!other.getStatistic().equals(getStatistic()))) {
      return false;
    }
    if (((other.getExtendedStatistic() == null ? 1 : 0) ^ (getExtendedStatistic() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExtendedStatistic() != null) && (!other.getExtendedStatistic().equals(getExtendedStatistic()))) {
      return false;
    }
    if (((other.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDimensions() != null) && (!other.getDimensions().equals(getDimensions()))) {
      return false;
    }
    if (((other.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPeriod() != null) && (!other.getPeriod().equals(getPeriod()))) {
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
    
    hashCode = 31 * hashCode + (getMetricName() == null ? 0 : getMetricName().hashCode());
    hashCode = 31 * hashCode + (getNamespace() == null ? 0 : getNamespace().hashCode());
    hashCode = 31 * hashCode + (getStatistic() == null ? 0 : getStatistic().hashCode());
    hashCode = 31 * hashCode + (getExtendedStatistic() == null ? 0 : getExtendedStatistic().hashCode());
    hashCode = 31 * hashCode + (getDimensions() == null ? 0 : getDimensions().hashCode());
    hashCode = 31 * hashCode + (getPeriod() == null ? 0 : getPeriod().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    return hashCode;
  }
  
  public DescribeAlarmsForMetricRequest clone()
  {
    return (DescribeAlarmsForMetricRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */