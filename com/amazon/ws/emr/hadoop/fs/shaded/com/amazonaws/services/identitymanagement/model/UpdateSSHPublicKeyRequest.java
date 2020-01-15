package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateSSHPublicKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String sSHPublicKeyId;
  private String status;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UpdateSSHPublicKeyRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setSSHPublicKeyId(String sSHPublicKeyId)
  {
    this.sSHPublicKeyId = sSHPublicKeyId;
  }
  
  public String getSSHPublicKeyId()
  {
    return sSHPublicKeyId;
  }
  
  public UpdateSSHPublicKeyRequest withSSHPublicKeyId(String sSHPublicKeyId)
  {
    setSSHPublicKeyId(sSHPublicKeyId);
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
  
  public UpdateSSHPublicKeyRequest withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public UpdateSSHPublicKeyRequest withStatus(StatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getSSHPublicKeyId() != null) {
      sb.append("SSHPublicKeyId: ").append(getSSHPublicKeyId()).append(",");
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
    if (!(obj instanceof UpdateSSHPublicKeyRequest)) {
      return false;
    }
    UpdateSSHPublicKeyRequest other = (UpdateSSHPublicKeyRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getSSHPublicKeyId() == null ? 1 : 0) ^ (getSSHPublicKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSHPublicKeyId() != null) && (!other.getSSHPublicKeyId().equals(getSSHPublicKeyId()))) {
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
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getSSHPublicKeyId() == null ? 0 : getSSHPublicKeyId().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    return hashCode;
  }
  
  public UpdateSSHPublicKeyRequest clone()
  {
    return (UpdateSSHPublicKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */