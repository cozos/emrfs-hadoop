package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeAnomalyDetectorsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String nextToken;
  private Integer maxResults;
  private String namespace;
  private String metricName;
  private SdkInternalList<Dimension> dimensions;
  
  public void setNextToken(String nextToken)
  {
    this.nextToken = nextToken;
  }
  
  public String getNextToken()
  {
    return nextToken;
  }
  
  public DescribeAnomalyDetectorsRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public void setMaxResults(Integer maxResults)
  {
    this.maxResults = maxResults;
  }
  
  public Integer getMaxResults()
  {
    return maxResults;
  }
  
  public DescribeAnomalyDetectorsRequest withMaxResults(Integer maxResults)
  {
    setMaxResults(maxResults);
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
  
  public DescribeAnomalyDetectorsRequest withNamespace(String namespace)
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
  
  public DescribeAnomalyDetectorsRequest withMetricName(String metricName)
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
  
  public DescribeAnomalyDetectorsRequest withDimensions(Dimension... dimensions)
  {
    if (this.dimensions == null) {
      setDimensions(new SdkInternalList(dimensions.length));
    }
    for (Dimension ele : dimensions) {
      this.dimensions.add(ele);
    }
    return this;
  }
  
  public DescribeAnomalyDetectorsRequest withDimensions(Collection<Dimension> dimensions)
  {
    setDimensions(dimensions);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken()).append(",");
    }
    if (getMaxResults() != null) {
      sb.append("MaxResults: ").append(getMaxResults()).append(",");
    }
    if (getNamespace() != null) {
      sb.append("Namespace: ").append(getNamespace()).append(",");
    }
    if (getMetricName() != null) {
      sb.append("MetricName: ").append(getMetricName()).append(",");
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
    if (!(obj instanceof DescribeAnomalyDetectorsRequest)) {
      return false;
    }
    DescribeAnomalyDetectorsRequest other = (DescribeAnomalyDetectorsRequest)obj;
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
      return false;
    }
    if (((other.getMaxResults() == null ? 1 : 0) ^ (getMaxResults() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxResults() != null) && (!other.getMaxResults().equals(getMaxResults()))) {
      return false;
    }
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    hashCode = 31 * hashCode + (getMaxResults() == null ? 0 : getMaxResults().hashCode());
    hashCode = 31 * hashCode + (getNamespace() == null ? 0 : getNamespace().hashCode());
    hashCode = 31 * hashCode + (getMetricName() == null ? 0 : getMetricName().hashCode());
    hashCode = 31 * hashCode + (getDimensions() == null ? 0 : getDimensions().hashCode());
    return hashCode;
  }
  
  public DescribeAnomalyDetectorsRequest clone()
  {
    return (DescribeAnomalyDetectorsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */