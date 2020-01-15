package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ResetServiceSpecificCredentialRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String serviceSpecificCredentialId;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public ResetServiceSpecificCredentialRequest withUserName(String userName)
  {
    setUserName(userName);
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
  
  public ResetServiceSpecificCredentialRequest withServiceSpecificCredentialId(String serviceSpecificCredentialId)
  {
    setServiceSpecificCredentialId(serviceSpecificCredentialId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getServiceSpecificCredentialId() != null) {
      sb.append("ServiceSpecificCredentialId: ").append(getServiceSpecificCredentialId());
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
    if (!(obj instanceof ResetServiceSpecificCredentialRequest)) {
      return false;
    }
    ResetServiceSpecificCredentialRequest other = (ResetServiceSpecificCredentialRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getServiceSpecificCredentialId() == null ? 1 : 0) ^ (getServiceSpecificCredentialId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceSpecificCredentialId() != null) && (!other.getServiceSpecificCredentialId().equals(getServiceSpecificCredentialId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getServiceSpecificCredentialId() == null ? 0 : getServiceSpecificCredentialId().hashCode());
    return hashCode;
  }
  
  public ResetServiceSpecificCredentialRequest clone()
  {
    return (ResetServiceSpecificCredentialRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResetServiceSpecificCredentialRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */