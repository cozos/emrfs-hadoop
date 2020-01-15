package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GetMetricStatisticsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String namespace;
  private String metricName;
  private SdkInternalList<Dimension> dimensions;
  private Date startTime;
  private Date endTime;
  private Integer period;
  private SdkInternalList<String> statistics;
  private SdkInternalList<String> extendedStatistics;
  private String unit;
  
  public void setNamespace(String namespace)
  {
    this.namespace = namespace;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public GetMetricStatisticsRequest withNamespace(String namespace)
  {
    setNamespace(namespace);
    return this;
  }
  
  public void setMetricName(String metricName)
  {
    this.metricName = metricName;
  }
  
  public String getMetricName()
  {
    return metricName;
  }
  
  public GetMetricStatisticsRequest withMetricName(String metricName)
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
  
  public GetMetricStatisticsRequest withDimensions(Dimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (Dimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public GetMetricStatisticsRequest withDimensions(Collection<Dimension> dimensions)
  {
    setDimensions(dimensions);
    return this;
  }
  
  public void setStartTime(Date startTime)
  {
    this.startTime = startTime;
  }
  
  public Date getStartTime()
  {
    return startTime;
  }
  
  public GetMetricStatisticsRequest withStartTime(Date startTime)
  {
    setStartTime(startTime);
    return this;
  }
  
  public void setEndTime(Date endTime)
  {
    this.endTime = endTime;
  }
  
  public Date getEndTime()
  {
    return endTime;
  }
  
  public GetMetricStatisticsRequest withEndTime(Date endTime)
  {
    setEndTime(endTime);
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
  
  public GetMetricStatisticsRequest withPeriod(Integer period)
  {
    setPeriod(period);
    return this;
  }
  
  public List<String> getStatistics()
  {
    if (statistics == null) {
      statistics = new SdkInternalList();
    }
    return statistics;
  }
  
  public void setStatistics(Collection<String> statistics)
  {
    if (statistics == null)
    {
      this.statistics = null;
      return;
    }
    this.statistics = new SdkInternalList(statistics);
  }
  
  public GetMetricStatisticsRequest withStatistics(String... statistics)
  {
    if (this.statistics == null) {
      setStatistics(new SdkInternalList(statistics.length));
    }
    for (String ele : statistics) {
      this.statistics.add(ele);
    }
    return this;
  }
  
  public GetMetricStatisticsRequest withStatistics(Collection<String> statistics)
  {
    setStatistics(statistics);
    return this;
  }
  
  public GetMetricStatisticsRequest withStatistics(Statistic... statistics)
  {
    SdkInternalList<String> statisticsCopy = new SdkInternalList(statistics.length);
    for (Statistic value : statistics) {
      statisticsCopy.add(value.toString());
    }
    if (getStatistics() == null) {
      setStatistics(statisticsCopy);
    } else {
      getStatistics().addAll(statisticsCopy);
    }
    return this;
  }
  
  public List<String> getExtendedStatistics()
  {
    if (extendedStatistics == null) {
      extendedStatistics = new SdkInternalList();
    }
    return extendedStatistics;
  }
  
  public void setExtendedStatistics(Collection<String> extendedStatistics)
  {
    if (extendedStatistics == null)
    {
      this.extendedStatistics = null;
      return;
    }
    this.extendedStatistics = new SdkInternalList(extendedStatistics);
  }
  
  public GetMetricStatisticsRequest withExtendedStatistics(String... extendedStatistics)
  {
    if (this.extendedStatistics == null) {
      setExtendedStatistics(new SdkInternalList(extendedStatistics.length));
    }
    for (String ele : extendedStatistics) {
      this.extendedStatistics.add(ele);
    }
    return this;
  }
  
  public GetMetricStatisticsRequest withExtendedStatistics(Collection<String> extendedStatistics)
  {
    setExtendedStatistics(extendedStatistics);
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
  
  public GetMetricStatisticsRequest withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public void setUnit(StandardUnit unit)
  {
    withUnit(unit);
  }
  
  public GetMetricStatisticsRequest withUnit(StandardUnit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getNamespace() != null) {
      sb.append("Namespace: ").append(getNamespace()).append(",");
    }
    if (getMetricName() != null) {
      sb.append("MetricName: ").append(getMetricName()).append(",");
    }
    if (getDimensions() != null) {
      sb.append("Dimensions: ").append(getDimensions()).append(",");
    }
    if (getStartTime() != null) {
      sb.append("StartTime: ").append(getStartTime()).append(",");
    }
    if (getEndTime() != null) {
      sb.append("EndTime: ").append(getEndTime()).append(",");
    }
    if (getPeriod() != null) {
      sb.append("Period: ").append(getPeriod()).append(",");
    }
    if (getStatistics() != null) {
      sb.append("Statistics: ").append(getStatistics()).append(",");
    }
    if (getExtendedStatistics() != null) {
      sb.append("ExtendedStatistics: ").append(getExtendedStatistics()).append(",");
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
    if (!(obj instanceof GetMetricStatisticsRequest)) {
      return false;
    }
    GetMetricStatisticsRequest other = (GetMetricStatisticsRequest)obj;
    if (((other.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNamespace() != null) && (!other.getNamespace().equals(getNamespace()))) {
      return false;
    }
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
    if (((other.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartTime() != null) && (!other.getStartTime().equals(getStartTime()))) {
      return false;
    }
    if (((other.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndTime() != null) && (!other.getEndTime().equals(getEndTime()))) {
      return false;
    }
    if (((other.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPeriod() != null) && (!other.getPeriod().equals(getPeriod()))) {
      return false;
    }
    if (((other.getStatistics() == null ? 1 : 0) ^ (getStatistics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatistics() != null) && (!other.getStatistics().equals(getStatistics()))) {
      return false;
    }
    if (((other.getExtendedStatistics() == null ? 1 : 0) ^ (getExtendedStatistics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExtendedStatistics() != null) && (!other.getExtendedStatistics().equals(getExtendedStatistics()))) {
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
    
    hashCode = 31 * hashCode + (getNamespace() == null ? 0 : getNamespace().hashCode());
    hashCode = 31 * hashCode + (getMetricName() == null ? 0 : getMetricName().hashCode());
    hashCode = 31 * hashCode + (getDimensions() == null ? 0 : getDimensions().hashCode());
    hashCode = 31 * hashCode + (getStartTime() == null ? 0 : getStartTime().hashCode());
    hashCode = 31 * hashCode + (getEndTime() == null ? 0 : getEndTime().hashCode());
    hashCode = 31 * hashCode + (getPeriod() == null ? 0 : getPeriod().hashCode());
    hashCode = 31 * hashCode + (getStatistics() == null ? 0 : getStatistics().hashCode());
    hashCode = 31 * hashCode + (getExtendedStatistics() == null ? 0 : getExtendedStatistics().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    return hashCode;
  }
  
  public GetMetricStatisticsRequest clone()
  {
    return (GetMetricStatisticsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */