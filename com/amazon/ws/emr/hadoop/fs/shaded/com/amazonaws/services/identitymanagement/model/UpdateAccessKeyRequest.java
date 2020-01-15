package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateAccessKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String accessKeyId;
  private String status;
  
  public UpdateAccessKeyRequest() {}
  
  public UpdateAccessKeyRequest(String accessKeyId, String status)
  {
    setAccessKeyId(accessKeyId);
    setStatus(status);
  }
  
  public UpdateAccessKeyRequest(String accessKeyId, StatusType status)
  {
    setAccessKeyId(accessKeyId);
    setStatus(status.toString());
  }
  
  public UpdateAccessKeyRequest(String userName, String accessKeyId, String status)
  {
    setUserName(userName);
    setAccessKeyId(accessKeyId);
    setStatus(status);
  }
  
  public UpdateAccessKeyRequest(String userName, String accessKeyId, StatusType status)
  {
    setUserName(userName);
    setAccessKeyId(accessKeyId);
    setStatus(status.toString());
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UpdateAccessKeyRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setAccessKeyId(String accessKeyId)
  {
    this.accessKeyId = accessKeyId;
  }
  
  public String getAccessKeyId()
  {
    return accessKeyId;
  }
  
  public UpdateAccessKeyRequest withAccessKeyId(String accessKeyId)
  {
    setAccessKeyId(accessKeyId);
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
  
  public UpdateAccessKeyRequest withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public UpdateAccessKeyRequest withStatus(StatusType status)
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
    if (getAccessKeyId() != null) {
      sb.append("AccessKeyId: ").append(getAccessKeyId()).append(",");
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
    if (!(obj instanceof UpdateAccessKeyRequest)) {
      return false;
    }
    UpdateAccessKeyRequest other = (UpdateAccessKeyRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getAccessKeyId() == null ? 1 : 0) ^ (getAccessKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessKeyId() != null) && (!other.getAccessKeyId().equals(getAccessKeyId()))) {
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
    hashCode = 31 * hashCode + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    return hashCode;
  }
  
  public UpdateAccessKeyRequest clone()
  {
    return (UpdateAccessKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccessKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */