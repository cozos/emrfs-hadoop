package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class SseKmsEncryptedObjects
  implements Serializable, Cloneable
{
  private String status;
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public SseKmsEncryptedObjects withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public SseKmsEncryptedObjects withStatus(SseKmsEncryptedObjectsStatus status)
  {
    setStatus(status == null ? null : status.toString());
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
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
    if (!(obj instanceof SseKmsEncryptedObjects)) {
      return false;
    }
    SseKmsEncryptedObjects other = (SseKmsEncryptedObjects)obj;
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && 
      (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    return hashCode;
  }
  
  public SseKmsEncryptedObjects clone()
  {
    try
    {
      return (SseKmsEncryptedObjects)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SseKmsEncryptedObjects
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */