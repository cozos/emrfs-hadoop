package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetDashboardResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String dashboardArn;
  private String dashboardBody;
  private String dashboardName;
  
  public void setDashboardArn(String dashboardArn)
  {
    this.dashboardArn = dashboardArn;
  }
  
  public String getDashboardArn()
  {
    return dashboardArn;
  }
  
  public GetDashboardResult withDashboardArn(String dashboardArn)
  {
    setDashboardArn(dashboardArn);
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
  
  public GetDashboardResult withDashboardBody(String dashboardBody)
  {
    setDashboardBody(dashboardBody);
    return this;
  }
  
  public void setDashboardName(String dashboardName)
  {
    this.dashboardName = dashboardName;
  }
  
  public String getDashboardName()
  {
    return dashboardName;
  }
  
  public GetDashboardResult withDashboardName(String dashboardName)
  {
    setDashboardName(dashboardName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardArn() != null) {
      sb.append("DashboardArn: ").append(getDashboardArn()).append(",");
    }
    if (getDashboardBody() != null) {
      sb.append("DashboardBody: ").append(getDashboardBody()).append(",");
    }
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
    if (!(obj instanceof GetDashboardResult)) {
      return false;
    }
    GetDashboardResult other = (GetDashboardResult)obj;
    if (((other.getDashboardArn() == null ? 1 : 0) ^ (getDashboardArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardArn() != null) && (!other.getDashboardArn().equals(getDashboardArn()))) {
      return false;
    }
    if (((other.getDashboardBody() == null ? 1 : 0) ^ (getDashboardBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardBody() != null) && (!other.getDashboardBody().equals(getDashboardBody()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getDashboardArn() == null ? 0 : getDashboardArn().hashCode());
    hashCode = 31 * hashCode + (getDashboardBody() == null ? 0 : getDashboardBody().hashCode());
    hashCode = 31 * hashCode + (getDashboardName() == null ? 0 : getDashboardName().hashCode());
    return hashCode;
  }
  
  public GetDashboardResult clone()
  {
    try
    {
      return (GetDashboardResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */