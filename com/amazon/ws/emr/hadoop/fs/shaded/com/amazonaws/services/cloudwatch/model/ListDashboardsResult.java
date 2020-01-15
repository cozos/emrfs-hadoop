package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListDashboardsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<DashboardEntry> dashboardEntries;
  private String nextToken;
  
  public List<DashboardEntry> getDashboardEntries()
  {
    if (dashboardEntries == null) {
      dashboardEntries = new SdkInternalList();
    }
    return dashboardEntries;
  }
  
  public void setDashboardEntries(Collection<DashboardEntry> dashboardEntries)
  {
    if (dashboardEntries == null)
    {
      this.dashboardEntries = null;
      return;
    }
    this.dashboardEntries = new SdkInternalList(dashboardEntries);
  }
  
  public ListDashboardsResult withDashboardEntries(DashboardEntry... dashboardEntries)
  {
    if (this.dashboardEntries == null) {
      setDashboardEntries(new SdkInternalList(dashboardEntries.length));
    }
    for (DashboardEntry ele : dashboardEntries) {
      this.dashboardEntries.add(ele);
    }
    return this;
  }
  
  public ListDashboardsResult withDashboardEntries(Collection<DashboardEntry> dashboardEntries)
  {
    setDashboardEntries(dashboardEntries);
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
  
  public ListDashboardsResult withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardEntries() != null) {
      sb.append("DashboardEntries: ").append(getDashboardEntries()).append(",");
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
    if (!(obj instanceof ListDashboardsResult)) {
      return false;
    }
    ListDashboardsResult other = (ListDashboardsResult)obj;
    if (((other.getDashboardEntries() == null ? 1 : 0) ^ (getDashboardEntries() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardEntries() != null) && (!other.getDashboardEntries().equals(getDashboardEntries()))) {
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
    
    hashCode = 31 * hashCode + (getDashboardEntries() == null ? 0 : getDashboardEntries().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public ListDashboardsResult clone()
  {
    try
    {
      return (ListDashboardsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */