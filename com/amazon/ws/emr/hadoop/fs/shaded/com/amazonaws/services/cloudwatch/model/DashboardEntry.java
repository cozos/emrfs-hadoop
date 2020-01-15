package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;
import java.util.Date;

public class DashboardEntry
  implements Serializable, Cloneable
{
  private String dashboardName;
  private String dashboardArn;
  private Date lastModified;
  private Long size;
  
  public void setDashboardName(String dashboardName)
  {
    this.dashboardName = dashboardName;
  }
  
  public String getDashboardName()
  {
    return dashboardName;
  }
  
  public DashboardEntry withDashboardName(String dashboardName)
  {
    setDashboardName(dashboardName);
    return this;
  }
  
  public void setDashboardArn(String dashboardArn)
  {
    this.dashboardArn = dashboardArn;
  }
  
  public String getDashboardArn()
  {
    return dashboardArn;
  }
  
  public DashboardEntry withDashboardArn(String dashboardArn)
  {
    setDashboardArn(dashboardArn);
    return this;
  }
  
  public void setLastModified(Date lastModified)
  {
    this.lastModified = lastModified;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public DashboardEntry withLastModified(Date lastModified)
  {
    setLastModified(lastModified);
    return this;
  }
  
  public void setSize(Long size)
  {
    this.size = size;
  }
  
  public Long getSize()
  {
    return size;
  }
  
  public DashboardEntry withSize(Long size)
  {
    setSize(size);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardName() != null) {
      sb.append("DashboardName: ").append(getDashboardName()).append(",");
    }
    if (getDashboardArn() != null) {
      sb.append("DashboardArn: ").append(getDashboardArn()).append(",");
    }
    if (getLastModified() != null) {
      sb.append("LastModified: ").append(getLastModified()).append(",");
    }
    if (getSize() != null) {
      sb.append("Size: ").append(getSize());
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
    if (!(obj instanceof DashboardEntry)) {
      return false;
    }
    DashboardEntry other = (DashboardEntry)obj;
    if (((other.getDashboardName() == null ? 1 : 0) ^ (getDashboardName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardName() != null) && (!other.getDashboardName().equals(getDashboardName()))) {
      return false;
    }
    if (((other.getDashboardArn() == null ? 1 : 0) ^ (getDashboardArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardArn() != null) && (!other.getDashboardArn().equals(getDashboardArn()))) {
      return false;
    }
    if (((other.getLastModified() == null ? 1 : 0) ^ (getLastModified() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastModified() != null) && (!other.getLastModified().equals(getLastModified()))) {
      return false;
    }
    if (((other.getSize() == null ? 1 : 0) ^ (getSize() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSize() != null) && (!other.getSize().equals(getSize()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDashboardName() == null ? 0 : getDashboardName().hashCode());
    hashCode = 31 * hashCode + (getDashboardArn() == null ? 0 : getDashboardArn().hashCode());
    hashCode = 31 * hashCode + (getLastModified() == null ? 0 : getLastModified().hashCode());
    hashCode = 31 * hashCode + (getSize() == null ? 0 : getSize().hashCode());
    return hashCode;
  }
  
  public DashboardEntry clone()
  {
    try
    {
      return (DashboardEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DashboardEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */