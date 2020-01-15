package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DeleteDashboardsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> dashboardNames;
  
  public List<String> getDashboardNames()
  {
    if (dashboardNames == null) {
      dashboardNames = new SdkInternalList();
    }
    return dashboardNames;
  }
  
  public void setDashboardNames(Collection<String> dashboardNames)
  {
    if (dashboardNames == null)
    {
      this.dashboardNames = null;
      return;
    }
    this.dashboardNames = new SdkInternalList(dashboardNames);
  }
  
  public DeleteDashboardsRequest withDashboardNames(String... dashboardNames)
  {
    if (this.dashboardNames == null) {
      setDashboardNames(new SdkInternalList(dashboardNames.length));
    }
    for (String ele : dashboardNames) {
      this.dashboardNames.add(ele);
    }
    return this;
  }
  
  public DeleteDashboardsRequest withDashboardNames(Collection<String> dashboardNames)
  {
    setDashboardNames(dashboardNames);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardNames() != null) {
      sb.append("DashboardNames: ").append(getDashboardNames());
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
    if (!(obj instanceof DeleteDashboardsRequest)) {
      return false;
    }
    DeleteDashboardsRequest other = (DeleteDashboardsRequest)obj;
    if (((other.getDashboardNames() == null ? 1 : 0) ^ (getDashboardNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardNames() != null) && (!other.getDashboardNames().equals(getDashboardNames()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDashboardNames() == null ? 0 : getDashboardNames().hashCode());
    return hashCode;
  }
  
  public DeleteDashboardsRequest clone()
  {
    return (DeleteDashboardsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */