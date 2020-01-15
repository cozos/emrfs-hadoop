package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<MetricAlarm> metricAlarms;
  private String nextToken;
  
  public List<MetricAlarm> getMetricAlarms()
  {
    if (metricAlarms == null) {
      metricAlarms = new SdkInternalList();
    }
    return metricAlarms;
  }
  
  public void setMetricAlarms(Collection<MetricAlarm> metricAlarms)
  {
    if (metricAlarms == null)
    {
      this.metricAlarms = null;
      return;
    }
    this.metricAlarms = new SdkInternalList(metricAlarms);
  }
  
  public DescribeAlarmsResult withMetricAlarms(MetricAlarm... metricAlarms)
  {
    if (this.metricAlarms == null) {
      setMetricAlarms(new SdkInternalList(metricAlarms.length));
    }
    for (MetricAlarm ele : metricAlarms) {
      this.metricAlarms.add(ele);
    }
    return this;
  }
  
  public DescribeAlarmsResult withMetricAlarms(Collection<MetricAlarm> metricAlarms)
  {
    setMetricAlarms(metricAlarms);
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
  
  public DescribeAlarmsResult withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricAlarms() != null) {
      sb.append("MetricAlarms: ").append(getMetricAlarms()).append(",");
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
    if (!(obj instanceof DescribeAlarmsResult)) {
      return false;
    }
    DescribeAlarmsResult other = (DescribeAlarmsResult)obj;
    if (((other.getMetricAlarms() == null ? 1 : 0) ^ (getMetricAlarms() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricAlarms() != null) && (!other.getMetricAlarms().equals(getMetricAlarms()))) {
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
    
    hashCode = 31 * hashCode + (getMetricAlarms() == null ? 0 : getMetricAlarms().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public DescribeAlarmsResult clone()
  {
    try
    {
      return (DescribeAlarmsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */