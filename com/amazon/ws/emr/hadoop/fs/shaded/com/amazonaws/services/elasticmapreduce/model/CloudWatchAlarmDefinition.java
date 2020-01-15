package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CloudWatchAlarmDefinitionMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CloudWatchAlarmDefinition
  implements Serializable, Cloneable, StructuredPojo
{
  private String comparisonOperator;
  private Integer evaluationPeriods;
  private String metricName;
  private String namespace;
  private Integer period;
  private String statistic;
  private Double threshold;
  private String unit;
  private SdkInternalList<MetricDimension> dimensions;
  
  public void setComparisonOperator(String comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator;
  }
  
  public String getComparisonOperator()
  {
    return comparisonOperator;
  }
  
  public CloudWatchAlarmDefinition withComparisonOperator(String comparisonOperator)
  {
    setComparisonOperator(comparisonOperator);
    return this;
  }
  
  public void setComparisonOperator(ComparisonOperator comparisonOperator)
  {
    withComparisonOperator(comparisonOperator);
  }
  
  public CloudWatchAlarmDefinition withComparisonOperator(ComparisonOperator comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator.toString();
    return this;
  }
  
  public void setEvaluationPeriods(Integer evaluationPeriods)
  {
    this.evaluationPeriods = evaluationPeriods;
  }
  
  public Integer getEvaluationPeriods()
  {
    return evaluationPeriods;
  }
  
  public CloudWatchAlarmDefinition withEvaluationPeriods(Integer evaluationPeriods)
  {
    setEvaluationPeriods(evaluationPeriods);
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
  
  public CloudWatchAlarmDefinition withMetricName(String metricName)
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
  
  public CloudWatchAlarmDefinition withNamespace(String namespace)
  {
    setNamespace(namespace);
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
  
  public CloudWatchAlarmDefinition withPeriod(Integer period)
  {
    setPeriod(period);
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
  
  public CloudWatchAlarmDefinition withStatistic(String statistic)
  {
    setStatistic(statistic);
    return this;
  }
  
  public void setStatistic(Statistic statistic)
  {
    withStatistic(statistic);
  }
  
  public CloudWatchAlarmDefinition withStatistic(Statistic statistic)
  {
    this.statistic = statistic.toString();
    return this;
  }
  
  public void setThreshold(Double threshold)
  {
    this.threshold = threshold;
  }
  
  public Double getThreshold()
  {
    return threshold;
  }
  
  public CloudWatchAlarmDefinition withThreshold(Double threshold)
  {
    setThreshold(threshold);
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
  
  public CloudWatchAlarmDefinition withUnit(String unit)
  {
    setUnit(unit);
    return this;
  }
  
  public void setUnit(Unit unit)
  {
    withUnit(unit);
  }
  
  public CloudWatchAlarmDefinition withUnit(Unit unit)
  {
    this.unit = unit.toString();
    return this;
  }
  
  public List<MetricDimension> getDimensions()
  {
    if (dimensions == null) {
      dimensions = new SdkInternalList();
    }
    return dimensions;
  }
  
  public void setDimensions(Collection<MetricDimension> dimensions)
  {
    if (dimensions == null)
    {
      this.dimensions = null;
      return;
    }
    this.dimensions = new SdkInternalList(dimensions);
  }
  
  public CloudWatchAlarmDefinition withDimensions(MetricDimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (MetricDimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public CloudWatchAlarmDefinition withDimensions(Collection<MetricDimension> dimensions)
  {
    setDimensions(dimensions);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getComparisonOperator() != null) {
      sb.append("ComparisonOperator: ").append(getComparisonOperator()).append(",");
    }
    if (getEvaluationPeriods() != null) {
      sb.append("EvaluationPeriods: ").append(getEvaluationPeriods()).append(",");
    }
    if (getMetricName() != null) {
      sb.append("MetricName: ").append(getMetricName()).append(",");
    }
    if (getNamespace() != null) {
      sb.append("Namespace: ").append(getNamespace()).append(",");
    }
    if (getPeriod() != null) {
      sb.append("Period: ").append(getPeriod()).append(",");
    }
    if (getStatistic() != null) {
      sb.append("Statistic: ").append(getStatistic()).append(",");
    }
    if (getThreshold() != null) {
      sb.append("Threshold: ").append(getThreshold()).append(",");
    }
    if (getUnit() != null) {
      sb.append("Unit: ").append(getUnit()).append(",");
    }
    if (getDimensions() != null) {
      sb.append("Dimensions: ").append(getDimensions());
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
    if (!(obj instanceof CloudWatchAlarmDefinition)) {
      return false;
    }
    CloudWatchAlarmDefinition other = (CloudWatchAlarmDefinition)obj;
    if (((other.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getComparisonOperator() != null) && (!other.getComparisonOperator().equals(getComparisonOperator()))) {
      return false;
    }
    if (((other.getEvaluationPeriods() == null ? 1 : 0) ^ (getEvaluationPeriods() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvaluationPeriods() != null) && (!other.getEvaluationPeriods().equals(getEvaluationPeriods()))) {
      return false;
    }
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
    if (((other.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPeriod() != null) && (!other.getPeriod().equals(getPeriod()))) {
      return false;
    }
    if (((other.getStatistic() == null ? 1 : 0) ^ (getStatistic() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatistic() != null) && (!other.getStatistic().equals(getStatistic()))) {
      return false;
    }
    if (((other.getThreshold() == null ? 1 : 0) ^ (getThreshold() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getThreshold() != null) && (!other.getThreshold().equals(getThreshold()))) {
      return false;
    }
    if (((other.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnit() != null) && (!other.getUnit().equals(getUnit()))) {
      return false;
    }
    if (((other.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDimensions() != null) && (!other.getDimensions().equals(getDimensions()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getComparisonOperator() == null ? 0 : getComparisonOperator().hashCode());
    hashCode = 31 * hashCode + (getEvaluationPeriods() == null ? 0 : getEvaluationPeriods().hashCode());
    hashCode = 31 * hashCode + (getMetricName() == null ? 0 : getMetricName().hashCode());
    hashCode = 31 * hashCode + (getNamespace() == null ? 0 : getNamespace().hashCode());
    hashCode = 31 * hashCode + (getPeriod() == null ? 0 : getPeriod().hashCode());
    hashCode = 31 * hashCode + (getStatistic() == null ? 0 : getStatistic().hashCode());
    hashCode = 31 * hashCode + (getThreshold() == null ? 0 : getThreshold().hashCode());
    hashCode = 31 * hashCode + (getUnit() == null ? 0 : getUnit().hashCode());
    hashCode = 31 * hashCode + (getDimensions() == null ? 0 : getDimensions().hashCode());
    return hashCode;
  }
  
  public CloudWatchAlarmDefinition clone()
  {
    try
    {
      return (CloudWatchAlarmDefinition)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CloudWatchAlarmDefinitionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CloudWatchAlarmDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */