package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteSSHPublicKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String sSHPublicKeyId;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public DeleteSSHPublicKeyRequest withUserName(String userName)
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
  
  public DeleteSSHPublicKeyRequest withSSHPublicKeyId(String sSHPublicKeyId)
  {
    setSSHPublicKeyId(sSHPublicKeyId);
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
      sb.append("SSHPublicKeyId: ").append(getSSHPublicKeyId());
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
    if (!(obj instanceof DeleteSSHPublicKeyRequest)) {
      return false;
    }
    DeleteSSHPublicKeyRequest other = (DeleteSSHPublicKeyRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getSSHPublicKeyId() == null ? 0 : getSSHPublicKeyId().hashCode());
    return hashCode;
  }
  
  public DeleteSSHPublicKeyRequest clone()
  {
    return (DeleteSSHPublicKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */