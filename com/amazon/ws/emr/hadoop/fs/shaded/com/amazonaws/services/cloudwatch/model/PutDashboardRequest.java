package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class PutDashboardRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String dashboardName;
  private String dashboardBody;
  
  public void setDashboardName(String dashboardName)
  {
    this.dashboardName = dashboardName;
  }
  
  public String getDashboardName()
  {
    return dashboardName;
  }
  
  public PutDashboardRequest withDashboardName(String dashboardName)
  {
    setDashboardName(dashboardName);
    return this;
  }
  
  public void setDashboardBody(String dashboardBody)
  {
    this.dashboardBody = dashboardBody;
  }
  
  public String getDashboardBody()
  {
    return dashboardBody;
  }
  
  public PutDashboardRequest withDashboardBody(String dashboardBody)
  {
    setDashboardBody(dashboardBody);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardName() != null) {
      sb.append("DashboardName: ").append(getDashboardName()).append(",");
    }
    if (getDashboardBody() != null) {
      sb.append("DashboardBody: ").append(getDashboardBody());
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
    if (!(obj instanceof PutDashboardRequest)) {
      return false;
    }
    PutDashboardRequest other = (PutDashboardRequest)obj;
    if (((other.getDashboardName() == null ? 1 : 0) ^ (getDashboardName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardName() != null) && (!other.getDashboardName().equals(getDashboardName()))) {
      return false;
    }
    if (((other.getDashboardBody() == null ? 1 : 0) ^ (getDashboardBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardBody() != null) && (!other.getDashboardBody().equals(getDashboardBody()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDashboardName() == null ? 0 : getDashboardName().hashCode());
    hashCode = 31 * hashCode + (getDashboardBody() == null ? 0 : getDashboardBody().hashCode());
    return hashCode;
  }
  
  public PutDashboardRequest clone()
  {
    return (PutDashboardRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */