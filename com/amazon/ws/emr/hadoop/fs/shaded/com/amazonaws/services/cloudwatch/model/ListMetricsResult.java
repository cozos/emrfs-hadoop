package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListMetricsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<Metric> metrics;
  private String nextToken;
  
  public List<Metric> getMetrics()
  {
    if (metrics == null) {
      metrics = new SdkInternalList();
    }
    return metrics;
  }
  
  public void setMetrics(Collection<Metric> metrics)
  {
    if (metrics == null)
    {
      this.metrics = null;
      return;
    }
    this.metrics = new SdkInternalList(metrics);
  }
  
  public ListMetricsResult withMetrics(Metric... metrics)
  {
    if (this.metrics == null) {
      setMetrics(new SdkInternalList(metrics.length));
    }
    for (Metric ele : metrics) {
      this.metrics.add(ele);
    }
    return this;
  }
  
  public ListMetricsResult withMetrics(Collection<Metric> metrics)
  {
    setMetrics(metrics);
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
  
  public ListMetricsResult withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetrics() != null) {
      sb.append("Metrics: ").append(getMetrics()).append(",");
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
    if (!(obj instanceof ListMetricsResult)) {
      return false;
    }
    ListMetricsResult other = (ListMetricsResult)obj;
    if (((other.getMetrics() == null ? 1 : 0) ^ (getMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetrics() != null) && (!other.getMetrics().equals(getMetrics()))) {
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
    
    hashCode = 31 * hashCode + (getMetrics() == null ? 0 : getMetrics().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public ListMetricsResult clone()
  {
    try
    {
      return (ListMetricsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */