package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListMetricsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String namespace;
  private String metricName;
  private SdkInternalList<DimensionFilter> dimensions;
  private String nextToken;
  
  public void setNamespace(String namespace)
  {
    this.namespace = namespace;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public ListMetricsRequest withNamespace(String namespace)
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
  
  public ListMetricsRequest withMetricName(String metricName)
  {
    setMetricName(metricName);
    return this;
  }
  
  public List<DimensionFilter> getDimensions()
  {
    if (dimensions == null) {
      dimensions = new SdkInternalList();
    }
    return dimensions;
  }
  
  public void setDimensions(Collection<DimensionFilter> dimensions)
  {
    if (dimensions == null)
    {
      this.dimensions = null;
      return;
    }
    this.dimensions = new SdkInternalList(dimensions);
  }
  
  public ListMetricsRequest withDimensions(DimensionFilter... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (DimensionFilter ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public ListMetricsRequest withDimensions(Collection<DimensionFilter> dimensions)
  {
    setDimensions(dimensions);
    return this;
  }
  
  public void setNextToken(String nextToken)
  {
    this.nextToken = nextToken;
  }
  
  public String getNextToken()
  {
    return nextToken;
  }
  
  public ListMetricsRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
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
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken());
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
    if (!(obj instanceof ListMetricsRequest)) {
      return false;
    }
    ListMetricsRequest other = (ListMetricsRequest)obj;
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
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
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
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public ListMetricsRequest clone()
  {
    return (ListMetricsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */