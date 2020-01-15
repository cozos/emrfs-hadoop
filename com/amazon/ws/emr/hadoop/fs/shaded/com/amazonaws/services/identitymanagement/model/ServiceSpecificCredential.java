package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class ServiceSpecificCredential
  implements Serializable, Cloneable
{
  private Date createDate;
  private String serviceName;
  private String serviceUserName;
  private String servicePassword;
  private String serviceSpecificCredentialId;
  private String userName;
  private String status;
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public Date getCreateDate()
  {
    return createDate;
  }
  
  public ServiceSpecificCredential withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
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
  
  public ServiceSpecificCredential withServiceName(String serviceName)
  {
    setServiceName(serviceName);
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
  
  public ServiceSpecificCredential withServiceUserName(String serviceUserName)
  {
    setServiceUserName(serviceUserName);
    return this;
  }
  
  public void setServicePassword(String servicePassword)
  {
    this.servicePassword = servicePassword;
  }
  
  public String getServicePassword()
  {
    return servicePassword;
  }
  
  public ServiceSpecificCredential withServicePassword(String servicePassword)
  {
    setServicePassword(servicePassword);
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
  
  public ServiceSpecificCredential withServiceSpecificCredentialId(String serviceSpecificCredentialId)
  {
    setServiceSpecificCredentialId(serviceSpecificCredentialId);
    return this;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public ServiceSpecificCredential withUserName(String userName)
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
  
  public ServiceSpecificCredential withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public ServiceSpecificCredential withStatus(StatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getServiceName() != null) {
      sb.append("ServiceName: ").append(getServiceName()).append(",");
    }
    if (getServiceUserName() != null) {
      sb.append("ServiceUserName: ").append(getServiceUserName()).append(",");
    }
    if (getServicePassword() != null) {
      sb.append("ServicePassword: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getServiceSpecificCredentialId() != null) {
      sb.append("ServiceSpecificCredentialId: ").append(getServiceSpecificCredentialId()).append(",");
    }
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus());
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
    if (!(obj instanceof ServiceSpecificCredential)) {
      return false;
    }
    ServiceSpecificCredential other = (ServiceSpecificCredential)obj;
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    if (((other.getServiceName() == null ? 1 : 0) ^ (getServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceName() != null) && (!other.getServiceName().equals(getServiceName()))) {
      return false;
    }
    if (((other.getServiceUserName() == null ? 1 : 0) ^ (getServiceUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceUserName() != null) && (!other.getServiceUserName().equals(getServiceUserName()))) {
      return false;
    }
    if (((other.getServicePassword() == null ? 1 : 0) ^ (getServicePassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServicePassword() != null) && (!other.getServicePassword().equals(getServicePassword()))) {
      return false;
    }
    if (((other.getServiceSpecificCredentialId() == null ? 1 : 0) ^ (getServiceSpecificCredentialId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceSpecificCredentialId() != null) && (!other.getServiceSpecificCredentialId().equals(getServiceSpecificCredentialId()))) {
      return false;
    }
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getServiceName() == null ? 0 : getServiceName().hashCode());
    hashCode = 31 * hashCode + (getServiceUserName() == null ? 0 : getServiceUserName().hashCode());
    hashCode = 31 * hashCode + (getServicePassword() == null ? 0 : getServicePassword().hashCode());
    hashCode = 31 * hashCode + (getServiceSpecificCredentialId() == null ? 0 : getServiceSpecificCredentialId().hashCode());
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    return hashCode;
  }
  
  public ServiceSpecificCredential clone()
  {
    try
    {
      return (ServiceSpecificCredential)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceSpecificCredential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */