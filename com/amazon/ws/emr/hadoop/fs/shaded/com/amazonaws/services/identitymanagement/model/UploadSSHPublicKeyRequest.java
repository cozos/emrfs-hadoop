package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UploadSSHPublicKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String sSHPublicKeyBody;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UploadSSHPublicKeyRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setSSHPublicKeyBody(String sSHPublicKeyBody)
  {
    this.sSHPublicKeyBody = sSHPublicKeyBody;
  }
  
  public String getSSHPublicKeyBody()
  {
    return sSHPublicKeyBody;
  }
  
  public UploadSSHPublicKeyRequest withSSHPublicKeyBody(String sSHPublicKeyBody)
  {
    setSSHPublicKeyBody(sSHPublicKeyBody);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getSSHPublicKeyBody() != null) {
      sb.append("SSHPublicKeyBody: ").append(getSSHPublicKeyBody());
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
    if (!(obj instanceof UploadSSHPublicKeyRequest)) {
      return false;
    }
    UploadSSHPublicKeyRequest other = (UploadSSHPublicKeyRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getSSHPublicKeyBody() == null ? 1 : 0) ^ (getSSHPublicKeyBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSHPublicKeyBody() != null) && (!other.getSSHPublicKeyBody().equals(getSSHPublicKeyBody()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getSSHPublicKeyBody() == null ? 0 : getSSHPublicKeyBody().hashCode());
    return hashCode;
  }
  
  public UploadSSHPublicKeyRequest clone()
  {
    return (UploadSSHPublicKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */