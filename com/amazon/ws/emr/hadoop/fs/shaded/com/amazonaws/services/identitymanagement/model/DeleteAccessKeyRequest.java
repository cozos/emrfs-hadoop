package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteAccessKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String accessKeyId;
  
  public DeleteAccessKeyRequest() {}
  
  public DeleteAccessKeyRequest(String userName, String accessKeyId)
  {
    setUserName(userName);
    setAccessKeyId(accessKeyId);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public DeleteAccessKeyRequest withUserName(String userName)
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
  
  public DeleteAccessKeyRequest withAccessKeyId(String accessKeyId)
  {
    setAccessKeyId(accessKeyId);
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
      sb.append("AccessKeyId: ").append(getAccessKeyId());
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
    if (!(obj instanceof DeleteAccessKeyRequest)) {
      return false;
    }
    DeleteAccessKeyRequest other = (DeleteAccessKeyRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode());
    return hashCode;
  }
  
  public DeleteAccessKeyRequest clone()
  {
    return (DeleteAccessKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccessKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */