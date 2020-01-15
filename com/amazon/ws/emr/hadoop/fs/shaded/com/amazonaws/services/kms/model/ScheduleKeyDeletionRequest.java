package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ScheduleKeyDeletionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private Integer pendingWindowInDays;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public ScheduleKeyDeletionRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setPendingWindowInDays(Integer pendingWindowInDays)
  {
    this.pendingWindowInDays = pendingWindowInDays;
  }
  
  public Integer getPendingWindowInDays()
  {
    return pendingWindowInDays;
  }
  
  public ScheduleKeyDeletionRequest withPendingWindowInDays(Integer pendingWindowInDays)
  {
    setPendingWindowInDays(pendingWindowInDays);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getPendingWindowInDays() != null) {
      sb.append("PendingWindowInDays: ").append(getPendingWindowInDays());
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
    if (!(obj instanceof ScheduleKeyDeletionRequest)) {
      return false;
    }
    ScheduleKeyDeletionRequest other = (ScheduleKeyDeletionRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getPendingWindowInDays() == null ? 1 : 0) ^ (getPendingWindowInDays() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPendingWindowInDays() != null) && (!other.getPendingWindowInDays().equals(getPendingWindowInDays()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getPendingWindowInDays() == null ? 0 : getPendingWindowInDays().hashCode());
    return hashCode;
  }
  
  public ScheduleKeyDeletionRequest clone()
  {
    return (ScheduleKeyDeletionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */