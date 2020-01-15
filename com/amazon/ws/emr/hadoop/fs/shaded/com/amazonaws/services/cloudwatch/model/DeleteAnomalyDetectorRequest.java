package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DeleteAnomalyDetectorRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String namespace;
  private String metricName;
  private SdkInternalList<Dimension> dimensions;
  private String stat;
  
  public void setNamespace(String namespace)
  {
    this.namespace = namespace;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public DeleteAnomalyDetectorRequest withNamespace(String namespace)
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
  
  public DeleteAnomalyDetectorRequest withMetricName(String metricName)
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
  
  public DeleteAnomalyDetectorRequest withDimensions(Dimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (Dimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public DeleteAnomalyDetectorRequest withDimensions(Collection<Dimension> dimensions)
  {
    setDimensions(dimensions);
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
  
  public DeleteAnomalyDetectorRequest withStat(String stat)
  {
    setStat(stat);
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
    if (getStat() != null) {
      sb.append("Stat: ").append(getStat());
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
    if (!(obj instanceof DeleteAnomalyDetectorRequest)) {
      return false;
    }
    DeleteAnomalyDetectorRequest other = (DeleteAnomalyDetectorRequest)obj;
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
    if (((other.getStat() == null ? 1 : 0) ^ (getStat() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStat() != null) && (!other.getStat().equals(getStat()))) {
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
    hashCode = 31 * hashCode + (getStat() == null ? 0 : getStat().hashCode());
    return hashCode;
  }
  
  public DeleteAnomalyDetectorRequest clone()
  {
    return (DeleteAnomalyDetectorRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */