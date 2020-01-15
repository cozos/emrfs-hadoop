package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class ServiceSpecificCredentialMetadata
  implements Serializable, Cloneable
{
  private String userName;
  private String status;
  private String serviceUserName;
  private Date createDate;
  private String serviceSpecificCredentialId;
  private String serviceName;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public ServiceSpecificCredentialMetadata withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public ServiceSpecificCredentialMetadata withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public ServiceSpecificCredentialMetadata withStatus(StatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setServiceUserName(String serviceUserName)
  {
    this.serviceUserName = serviceUserName;
  }
  
  public String getServiceUserName()
  {
    return serviceUserName;
  }
  
  public ServiceSpecificCredentialMetadata withServiceUserName(String serviceUserName)
  {
    setServiceUserName(serviceUserName);
    return this;
  }
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public Date getCreateDate()
  {
    return createDate;
  }
  
  public ServiceSpecificCredentialMetadata withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public void setServiceSpecificCredentialId(String serviceSpecificCredentialId)
  {
    this.serviceSpecificCredentialId = serviceSpecificCredentialId;
  }
  
  public String getServiceSpecificCredentialId()
  {
    return serviceSpecificCredentialId;
  }
  
  public ServiceSpecificCredentialMetadata withServiceSpecificCredentialId(String serviceSpecificCredentialId)
  {
    setServiceSpecificCredentialId(serviceSpecificCredentialId);
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
  
  public ServiceSpecificCredentialMetadata withServiceName(String serviceName)
  {
    setServiceName(serviceName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getServiceUserName() != null) {
      sb.append("ServiceUserName: ").append(getServiceUserName()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getServiceSpecificCredentialId() != null) {
      sb.append("ServiceSpecificCredentialId: ").append(getServiceSpecificCredentialId()).append(",");
    }
    if (getServiceName() != null) {
      sb.append("ServiceName: ").append(getServiceName());
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
    if (!(obj instanceof ServiceSpecificCredentialMetadata)) {
      return false;
    }
    ServiceSpecificCredentialMetadata other = (ServiceSpecificCredentialMetadata)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getServiceUserName() == null ? 1 : 0) ^ (getServiceUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceUserName() != null) && (!other.getServiceUserName().equals(getServiceUserName()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    if (((other.getServiceSpecificCredentialId() == null ? 1 : 0) ^ (getServiceSpecificCredentialId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceSpecificCredentialId() != null) && (!other.getServiceSpecificCredentialId().equals(getServiceSpecificCredentialId()))) {
      return false;
    }
    if (((other.getServiceName() == null ? 1 : 0) ^ (getServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceName() != null) && (!other.getServiceName().equals(getServiceName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getServiceUserName() == null ? 0 : getServiceUserName().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getServiceSpecificCredentialId() == null ? 0 : getServiceSpecificCredentialId().hashCode());
    hashCode = 31 * hashCode + (getServiceName() == null ? 0 : getServiceName().hashCode());
    return hashCode;
  }
  
  public ServiceSpecificCredentialMetadata clone()
  {
    try
    {
      return (ServiceSpecificCredentialMetadata)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceSpecificCredentialMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */