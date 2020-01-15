package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;

public class MetricDataQuery
  implements Serializable, Cloneable
{
  private String id;
  private MetricStat metricStat;
  private String expression;
  private String label;
  private Boolean returnData;
  private Integer period;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public MetricDataQuery withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setMetricStat(MetricStat metricStat)
  {
    this.metricStat = metricStat;
  }
  
  public MetricStat getMetricStat()
  {
    return metricStat;
  }
  
  public MetricDataQuery withMetricStat(MetricStat metricStat)
  {
    setMetricStat(metricStat);
    return this;
  }
  
  public void setExpression(String expression)
  {
    this.expression = expression;
  }
  
  public String getExpression()
  {
    return expression;
  }
  
  public MetricDataQuery withExpression(String expression)
  {
    setExpression(expression);
    return this;
  }
  
  public void setLabel(String label)
  {
    this.label = label;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public MetricDataQuery withLabel(String label)
  {
    setLabel(label);
    return this;
  }
  
  public void setReturnData(Boolean returnData)
  {
    this.returnData = returnData;
  }
  
  public Boolean getReturnData()
  {
    return returnData;
  }
  
  public MetricDataQuery withReturnData(Boolean returnData)
  {
    setReturnData(returnData);
    return this;
  }
  
  public Boolean isReturnData()
  {
    return returnData;
  }
  
  public void setPeriod(Integer period)
  {
    this.period = period;
  }
  
  public Integer getPeriod()
  {
    return period;
  }
  
  public MetricDataQuery withPeriod(Integer period)
  {
    setPeriod(period);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getMetricStat() != null) {
      sb.append("MetricStat: ").append(getMetricStat()).append(",");
    }
    if (getExpression() != null) {
      sb.append("Expression: ").append(getExpression()).append(",");
    }
    if (getLabel() != null) {
      sb.append("Label: ").append(getLabel()).append(",");
    }
    if (getReturnData() != null) {
      sb.append("ReturnData: ").append(getReturnData()).append(",");
    }
    if (getPeriod() != null) {
      sb.append("Period: ").append(getPeriod());
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
    if (!(obj instanceof MetricDataQuery)) {
      return false;
    }
    MetricDataQuery other = (MetricDataQuery)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getMetricStat() == null ? 1 : 0) ^ (getMetricStat() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricStat() != null) && (!other.getMetricStat().equals(getMetricStat()))) {
      return false;
    }
    if (((other.getExpression() == null ? 1 : 0) ^ (getExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpression() != null) && (!other.getExpression().equals(getExpression()))) {
      return false;
    }
    if (((other.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLabel() != null) && (!other.getLabel().equals(getLabel()))) {
      return false;
    }
    if (((other.getReturnData() == null ? 1 : 0) ^ (getReturnData() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnData() != null) && (!other.getReturnData().equals(getReturnData()))) {
      return false;
    }
    if (((other.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPeriod() != null) && (!other.getPeriod().equals(getPeriod()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getMetricStat() == null ? 0 : getMetricStat().hashCode());
    hashCode = 31 * hashCode + (getExpression() == null ? 0 : getExpression().hashCode());
    hashCode = 31 * hashCode + (getLabel() == null ? 0 : getLabel().hashCode());
    hashCode = 31 * hashCode + (getReturnData() == null ? 0 : getReturnData().hashCode());
    hashCode = 31 * hashCode + (getPeriod() == null ? 0 : getPeriod().hashCode());
    return hashCode;
  }
  
  public MetricDataQuery clone()
  {
    try
    {
      return (MetricDataQuery)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */