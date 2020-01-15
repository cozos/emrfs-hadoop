package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class AccessKeyLastUsed
  implements Serializable, Cloneable
{
  private Date lastUsedDate;
  private String serviceName;
  private String region;
  
  public void setLastUsedDate(Date lastUsedDate)
  {
    this.lastUsedDate = lastUsedDate;
  }
  
  public Date getLastUsedDate()
  {
    return lastUsedDate;
  }
  
  public AccessKeyLastUsed withLastUsedDate(Date lastUsedDate)
  {
    setLastUsedDate(lastUsedDate);
    return this;
  }
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public AccessKeyLastUsed withServiceName(String serviceName)
  {
    setServiceName(serviceName);
    return this;
  }
  
  public void setRegion(String region)
  {
    this.region = region;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public AccessKeyLastUsed withRegion(String region)
  {
    setRegion(region);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLastUsedDate() != null) {
      sb.append("LastUsedDate: ").append(getLastUsedDate()).append(",");
    }
    if (getServiceName() != null) {
      sb.append("ServiceName: ").append(getServiceName()).append(",");
    }
    if (getRegion() != null) {
      sb.append("Region: ").append(getRegion());
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
    if (!(obj instanceof AccessKeyLastUsed)) {
      return false;
    }
    AccessKeyLastUsed other = (AccessKeyLastUsed)obj;
    if (((other.getLastUsedDate() == null ? 1 : 0) ^ (getLastUsedDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastUsedDate() != null) && (!other.getLastUsedDate().equals(getLastUsedDate()))) {
      return false;
    }
    if (((other.getServiceName() == null ? 1 : 0) ^ (getServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceName() != null) && (!other.getServiceName().equals(getServiceName()))) {
      return false;
    }
    if (((other.getRegion() == null ? 1 : 0) ^ (getRegion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegion() != null) && (!other.getRegion().equals(getRegion()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getLastUsedDate() == null ? 0 : getLastUsedDate().hashCode());
    hashCode = 31 * hashCode + (getServiceName() == null ? 0 : getServiceName().hashCode());
    hashCode = 31 * hashCode + (getRegion() == null ? 0 : getRegion().hashCode());
    return hashCode;
  }
  
  public AccessKeyLastUsed clone()
  {
    try
    {
      return (AccessKeyLastUsed)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AccessKeyLastUsed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */