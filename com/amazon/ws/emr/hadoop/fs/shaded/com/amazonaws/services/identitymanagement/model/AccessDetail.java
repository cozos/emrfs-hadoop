package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class AccessDetail
  implements Serializable, Cloneable
{
  private String serviceName;
  private String serviceNamespace;
  private String region;
  private String entityPath;
  private Date lastAuthenticatedTime;
  private Integer totalAuthenticatedEntities;
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public AccessDetail withServiceName(String serviceName)
  {
    setServiceName(serviceName);
    return this;
  }
  
  public void setServiceNamespace(String serviceNamespace)
  {
    this.serviceNamespace = serviceNamespace;
  }
  
  public String getServiceNamespace()
  {
    return serviceNamespace;
  }
  
  public AccessDetail withServiceNamespace(String serviceNamespace)
  {
    setServiceNamespace(serviceNamespace);
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
  
  public AccessDetail withRegion(String region)
  {
    setRegion(region);
    return this;
  }
  
  public void setEntityPath(String entityPath)
  {
    this.entityPath = entityPath;
  }
  
  public String getEntityPath()
  {
    return entityPath;
  }
  
  public AccessDetail withEntityPath(String entityPath)
  {
    setEntityPath(entityPath);
    return this;
  }
  
  public void setLastAuthenticatedTime(Date lastAuthenticatedTime)
  {
    this.lastAuthenticatedTime = lastAuthenticatedTime;
  }
  
  public Date getLastAuthenticatedTime()
  {
    return lastAuthenticatedTime;
  }
  
  public AccessDetail withLastAuthenticatedTime(Date lastAuthenticatedTime)
  {
    setLastAuthenticatedTime(lastAuthenticatedTime);
    return this;
  }
  
  public void setTotalAuthenticatedEntities(Integer totalAuthenticatedEntities)
  {
    this.totalAuthenticatedEntities = totalAuthenticatedEntities;
  }
  
  public Integer getTotalAuthenticatedEntities()
  {
    return totalAuthenticatedEntities;
  }
  
  public AccessDetail withTotalAuthenticatedEntities(Integer totalAuthenticatedEntities)
  {
    setTotalAuthenticatedEntities(totalAuthenticatedEntities);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServiceName() != null) {
      sb.append("ServiceName: ").append(getServiceName()).append(",");
    }
    if (getServiceNamespace() != null) {
      sb.append("ServiceNamespace: ").append(getServiceNamespace()).append(",");
    }
    if (getRegion() != null) {
      sb.append("Region: ").append(getRegion()).append(",");
    }
    if (getEntityPath() != null) {
      sb.append("EntityPath: ").append(getEntityPath()).append(",");
    }
    if (getLastAuthenticatedTime() != null) {
      sb.append("LastAuthenticatedTime: ").append(getLastAuthenticatedTime()).append(",");
    }
    if (getTotalAuthenticatedEntities() != null) {
      sb.append("TotalAuthenticatedEntities: ").append(getTotalAuthenticatedEntities());
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
    if (!(obj instanceof AccessDetail)) {
      return false;
    }
    AccessDetail other = (AccessDetail)obj;
    if (((other.getServiceName() == null ? 1 : 0) ^ (getServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceName() != null) && (!other.getServiceName().equals(getServiceName()))) {
      return false;
    }
    if (((other.getServiceNamespace() == null ? 1 : 0) ^ (getServiceNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceNamespace() != null) && (!other.getServiceNamespace().equals(getServiceNamespace()))) {
      return false;
    }
    if (((other.getRegion() == null ? 1 : 0) ^ (getRegion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegion() != null) && (!other.getRegion().equals(getRegion()))) {
      return false;
    }
    if (((other.getEntityPath() == null ? 1 : 0) ^ (getEntityPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntityPath() != null) && (!other.getEntityPath().equals(getEntityPath()))) {
      return false;
    }
    if (((other.getLastAuthenticatedTime() == null ? 1 : 0) ^ (getLastAuthenticatedTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastAuthenticatedTime() != null) && (!other.getLastAuthenticatedTime().equals(getLastAuthenticatedTime()))) {
      return false;
    }
    if (((other.getTotalAuthenticatedEntities() == null ? 1 : 0) ^ (getTotalAuthenticatedEntities() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTotalAuthenticatedEntities() != null) && (!other.getTotalAuthenticatedEntities().equals(getTotalAuthenticatedEntities()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServiceName() == null ? 0 : getServiceName().hashCode());
    hashCode = 31 * hashCode + (getServiceNamespace() == null ? 0 : getServiceNamespace().hashCode());
    hashCode = 31 * hashCode + (getRegion() == null ? 0 : getRegion().hashCode());
    hashCode = 31 * hashCode + (getEntityPath() == null ? 0 : getEntityPath().hashCode());
    hashCode = 31 * hashCode + (getLastAuthenticatedTime() == null ? 0 : getLastAuthenticatedTime().hashCode());
    hashCode = 31 * hashCode + (getTotalAuthenticatedEntities() == null ? 0 : getTotalAuthenticatedEntities().hashCode());
    return hashCode;
  }
  
  public AccessDetail clone()
  {
    try
    {
      return (AccessDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AccessDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */