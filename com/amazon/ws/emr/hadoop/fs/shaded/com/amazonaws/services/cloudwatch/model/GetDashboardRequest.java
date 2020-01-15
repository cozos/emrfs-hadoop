package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetDashboardRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String dashboardName;
  
  public void setDashboardName(String dashboardName)
  {
    this.dashboardName = dashboardName;
  }
  
  public String getDashboardName()
  {
    return dashboardName;
  }
  
  public GetDashboardRequest withDashboardName(String dashboardName)
  {
    setDashboardName(dashboardName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardName() != null) {
      sb.append("DashboardName: ").append(getDashboardName());
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
    if (!(obj instanceof GetDashboardRequest)) {
      return false;
    }
    GetDashboardRequest other = (GetDashboardRequest)obj;
    if (((other.getDashboardName() == null ? 1 : 0) ^ (getDashboardName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardName() != null) && (!other.getDashboardName().equals(getDashboardName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDashboardName() == null ? 0 : getDashboardName().hashCode());
    return hashCode;
  }
  
  public GetDashboardRequest clone()
  {
    return (GetDashboardRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */