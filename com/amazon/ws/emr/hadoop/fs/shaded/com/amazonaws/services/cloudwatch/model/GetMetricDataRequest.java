package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GetMetricDataRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<MetricDataQuery> metricDataQueries;
  private Date startTime;
  private Date endTime;
  private String nextToken;
  private String scanBy;
  private Integer maxDatapoints;
  
  public List<MetricDataQuery> getMetricDataQueries()
  {
    if (metricDataQueries == null) {
      metricDataQueries = new SdkInternalList();
    }
    return metricDataQueries;
  }
  
  public void setMetricDataQueries(Collection<MetricDataQuery> metricDataQueries)
  {
    if (metricDataQueries == null)
    {
      this.metricDataQueries = null;
      return;
    }
    this.metricDataQueries = new SdkInternalList(metricDataQueries);
  }
  
  public GetMetricDataRequest withMetricDataQueries(MetricDataQuery... metricDataQueries)
  {
    if (this.metricDataQueries == null) {
      setMetricDataQueries(new SdkInternalList(metricDataQueries.length));
    }
    for (MetricDataQuery ele : metricDataQueries) {
      this.metricDataQueries.add(ele);
    }
    return this;
  }
  
  public GetMetricDataRequest withMetricDataQueries(Collection<MetricDataQuery> metricDataQueries)
  {
    setMetricDataQueries(metricDataQueries);
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
  
  public GetMetricDataRequest withStartTime(Date startTime)
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
  
  public GetMetricDataRequest withEndTime(Date endTime)
  {
    setEndTime(endTime);
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
  
  public GetMetricDataRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public void setScanBy(String scanBy)
  {
    this.scanBy = scanBy;
  }
  
  public String getScanBy()
  {
    return scanBy;
  }
  
  public GetMetricDataRequest withScanBy(String scanBy)
  {
    setScanBy(scanBy);
    return this;
  }
  
  public GetMetricDataRequest withScanBy(ScanBy scanBy)
  {
    this.scanBy = scanBy.toString();
    return this;
  }
  
  public void setMaxDatapoints(Integer maxDatapoints)
  {
    this.maxDatapoints = maxDatapoints;
  }
  
  public Integer getMaxDatapoints()
  {
    return maxDatapoints;
  }
  
  public GetMetricDataRequest withMaxDatapoints(Integer maxDatapoints)
  {
    setMaxDatapoints(maxDatapoints);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricDataQueries() != null) {
      sb.append("MetricDataQueries: ").append(getMetricDataQueries()).append(",");
    }
    if (getStartTime() != null) {
      sb.append("StartTime: ").append(getStartTime()).append(",");
    }
    if (getEndTime() != null) {
      sb.append("EndTime: ").append(getEndTime()).append(",");
    }
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken()).append(",");
    }
    if (getScanBy() != null) {
      sb.append("ScanBy: ").append(getScanBy()).append(",");
    }
    if (getMaxDatapoints() != null) {
      sb.append("MaxDatapoints: ").append(getMaxDatapoints());
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
    if (!(obj instanceof GetMetricDataRequest)) {
      return false;
    }
    GetMetricDataRequest other = (GetMetricDataRequest)obj;
    if (((other.getMetricDataQueries() == null ? 1 : 0) ^ (getMetricDataQueries() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricDataQueries() != null) && (!other.getMetricDataQueries().equals(getMetricDataQueries()))) {
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
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
      return false;
    }
    if (((other.getScanBy() == null ? 1 : 0) ^ (getScanBy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScanBy() != null) && (!other.getScanBy().equals(getScanBy()))) {
      return false;
    }
    if (((other.getMaxDatapoints() == null ? 1 : 0) ^ (getMaxDatapoints() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxDatapoints() != null) && (!other.getMaxDatapoints().equals(getMaxDatapoints()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMetricDataQueries() == null ? 0 : getMetricDataQueries().hashCode());
    hashCode = 31 * hashCode + (getStartTime() == null ? 0 : getStartTime().hashCode());
    hashCode = 31 * hashCode + (getEndTime() == null ? 0 : getEndTime().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    hashCode = 31 * hashCode + (getScanBy() == null ? 0 : getScanBy().hashCode());
    hashCode = 31 * hashCode + (getMaxDatapoints() == null ? 0 : getMaxDatapoints().hashCode());
    return hashCode;
  }
  
  public GetMetricDataRequest clone()
  {
    return (GetMetricDataRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */