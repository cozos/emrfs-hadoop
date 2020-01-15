package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.Date;

public class ScheduleKeyDeletionResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String keyId;
  private Date deletionDate;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public ScheduleKeyDeletionResult withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setDeletionDate(Date deletionDate)
  {
    this.deletionDate = deletionDate;
  }
  
  public Date getDeletionDate()
  {
    return deletionDate;
  }
  
  public ScheduleKeyDeletionResult withDeletionDate(Date deletionDate)
  {
    setDeletionDate(deletionDate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getDeletionDate() != null) {
      sb.append("DeletionDate: ").append(getDeletionDate());
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
    if (!(obj instanceof ScheduleKeyDeletionResult)) {
      return false;
    }
    ScheduleKeyDeletionResult other = (ScheduleKeyDeletionResult)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getDeletionDate() == null ? 1 : 0) ^ (getDeletionDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDeletionDate() != null) && (!other.getDeletionDate().equals(getDeletionDate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getDeletionDate() == null ? 0 : getDeletionDate().hashCode());
    return hashCode;
  }
  
  public ScheduleKeyDeletionResult clone()
  {
    try
    {
      return (ScheduleKeyDeletionResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */