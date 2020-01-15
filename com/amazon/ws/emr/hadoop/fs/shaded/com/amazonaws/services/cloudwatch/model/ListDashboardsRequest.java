package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListDashboardsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String dashboardNamePrefix;
  private String nextToken;
  
  public void setDashboardNamePrefix(String dashboardNamePrefix)
  {
    this.dashboardNamePrefix = dashboardNamePrefix;
  }
  
  public String getDashboardNamePrefix()
  {
    return dashboardNamePrefix;
  }
  
  public ListDashboardsRequest withDashboardNamePrefix(String dashboardNamePrefix)
  {
    setDashboardNamePrefix(dashboardNamePrefix);
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
  
  public ListDashboardsRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardNamePrefix() != null) {
      sb.append("DashboardNamePrefix: ").append(getDashboardNamePrefix()).append(",");
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
    if (!(obj instanceof ListDashboardsRequest)) {
      return false;
    }
    ListDashboardsRequest other = (ListDashboardsRequest)obj;
    if (((other.getDashboardNamePrefix() == null ? 1 : 0) ^ (getDashboardNamePrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardNamePrefix() != null) && (!other.getDashboardNamePrefix().equals(getDashboardNamePrefix()))) {
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
    
    hashCode = 31 * hashCode + (getDashboardNamePrefix() == null ? 0 : getDashboardNamePrefix().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public ListDashboardsRequest clone()
  {
    return (ListDashboardsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */