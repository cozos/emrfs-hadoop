package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class AccessKey
  implements Serializable, Cloneable
{
  private String userName;
  private String accessKeyId;
  private String status;
  private String secretAccessKey;
  private Date createDate;
  
  public AccessKey() {}
  
  public AccessKey(String userName, String accessKeyId, String status, String secretAccessKey)
  {
    setUserName(userName);
    setAccessKeyId(accessKeyId);
    setStatus(status);
    setSecretAccessKey(secretAccessKey);
  }
  
  public AccessKey(String userName, String accessKeyId, StatusType status, String secretAccessKey)
  {
    setUserName(userName);
    setAccessKeyId(accessKeyId);
    setStatus(status.toString());
    setSecretAccessKey(secretAccessKey);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public AccessKey withUserName(String userName)
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
  
  public AccessKey withAccessKeyId(String accessKeyId)
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
  
  public AccessKey withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public AccessKey withStatus(StatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setSecretAccessKey(String secretAccessKey)
  {
    this.secretAccessKey = secretAccessKey;
  }
  
  public String getSecretAccessKey()
  {
    return secretAccessKey;
  }
  
  public AccessKey withSecretAccessKey(String secretAccessKey)
  {
    setSecretAccessKey(secretAccessKey);
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
  
  public AccessKey withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
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
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getSecretAccessKey() != null) {
      sb.append("SecretAccessKey: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate());
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
    if (!(obj instanceof AccessKey)) {
      return false;
    }
    AccessKey other = (AccessKey)obj;
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
    if (((other.getSecretAccessKey() == null ? 1 : 0) ^ (getSecretAccessKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSecretAccessKey() != null) && (!other.getSecretAccessKey().equals(getSecretAccessKey()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
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
    hashCode = 31 * hashCode + (getSecretAccessKey() == null ? 0 : getSecretAccessKey().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    return hashCode;
  }
  
  public AccessKey clone()
  {
    try
    {
      return (AccessKey)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AccessKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */