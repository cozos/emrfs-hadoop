package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class ServiceLastAccessed
  implements Serializable, Cloneable
{
  private String serviceName;
  private Date lastAuthenticated;
  private String serviceNamespace;
  private String lastAuthenticatedEntity;
  private Integer totalAuthenticatedEntities;
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public ServiceLastAccessed withServiceName(String serviceName)
  {
    setServiceName(serviceName);
    return this;
  }
  
  public void setLastAuthenticated(Date lastAuthenticated)
  {
    this.lastAuthenticated = lastAuthenticated;
  }
  
  public Date getLastAuthenticated()
  {
    return lastAuthenticated;
  }
  
  public ServiceLastAccessed withLastAuthenticated(Date lastAuthenticated)
  {
    setLastAuthenticated(lastAuthenticated);
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
  
  public ServiceLastAccessed withServiceNamespace(String serviceNamespace)
  {
    setServiceNamespace(serviceNamespace);
    return this;
  }
  
  public void setLastAuthenticatedEntity(String lastAuthenticatedEntity)
  {
    this.lastAuthenticatedEntity = lastAuthenticatedEntity;
  }
  
  public String getLastAuthenticatedEntity()
  {
    return lastAuthenticatedEntity;
  }
  
  public ServiceLastAccessed withLastAuthenticatedEntity(String lastAuthenticatedEntity)
  {
    setLastAuthenticatedEntity(lastAuthenticatedEntity);
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
  
  public ServiceLastAccessed withTotalAuthenticatedEntities(Integer totalAuthenticatedEntities)
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
    if (getLastAuthenticated() != null) {
      sb.append("LastAuthenticated: ").append(getLastAuthenticated()).append(",");
    }
    if (getServiceNamespace() != null) {
      sb.append("ServiceNamespace: ").append(getServiceNamespace()).append(",");
    }
    if (getLastAuthenticatedEntity() != null) {
      sb.append("LastAuthenticatedEntity: ").append(getLastAuthenticatedEntity()).append(",");
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
    if (!(obj instanceof ServiceLastAccessed)) {
      return false;
    }
    ServiceLastAccessed other = (ServiceLastAccessed)obj;
    if (((other.getServiceName() == null ? 1 : 0) ^ (getServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceName() != null) && (!other.getServiceName().equals(getServiceName()))) {
      return false;
    }
    if (((other.getLastAuthenticated() == null ? 1 : 0) ^ (getLastAuthenticated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastAuthenticated() != null) && (!other.getLastAuthenticated().equals(getLastAuthenticated()))) {
      return false;
    }
    if (((other.getServiceNamespace() == null ? 1 : 0) ^ (getServiceNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceNamespace() != null) && (!other.getServiceNamespace().equals(getServiceNamespace()))) {
      return false;
    }
    if (((other.getLastAuthenticatedEntity() == null ? 1 : 0) ^ (getLastAuthenticatedEntity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastAuthenticatedEntity() != null) && (!other.getLastAuthenticatedEntity().equals(getLastAuthenticatedEntity()))) {
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
    hashCode = 31 * hashCode + (getLastAuthenticated() == null ? 0 : getLastAuthenticated().hashCode());
    hashCode = 31 * hashCode + (getServiceNamespace() == null ? 0 : getServiceNamespace().hashCode());
    hashCode = 31 * hashCode + (getLastAuthenticatedEntity() == null ? 0 : getLastAuthenticatedEntity().hashCode());
    hashCode = 31 * hashCode + (getTotalAuthenticatedEntities() == null ? 0 : getTotalAuthenticatedEntities().hashCode());
    return hashCode;
  }
  
  public ServiceLastAccessed clone()
  {
    try
    {
      return (ServiceLastAccessed)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceLastAccessed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */