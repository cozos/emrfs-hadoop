package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetServiceLinkedRoleDeletionStatusResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String status;
  private DeletionTaskFailureReasonType reason;
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public GetServiceLinkedRoleDeletionStatusResult withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public GetServiceLinkedRoleDeletionStatusResult withStatus(DeletionTaskStatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setReason(DeletionTaskFailureReasonType reason)
  {
    this.reason = reason;
  }
  
  public DeletionTaskFailureReasonType getReason()
  {
    return reason;
  }
  
  public GetServiceLinkedRoleDeletionStatusResult withReason(DeletionTaskFailureReasonType reason)
  {
    setReason(reason);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getReason() != null) {
      sb.append("Reason: ").append(getReason());
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
    if (!(obj instanceof GetServiceLinkedRoleDeletionStatusResult)) {
      return false;
    }
    GetServiceLinkedRoleDeletionStatusResult other = (GetServiceLinkedRoleDeletionStatusResult)obj;
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getReason() == null ? 1 : 0) ^ (getReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReason() != null) && (!other.getReason().equals(getReason()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getReason() == null ? 0 : getReason().hashCode());
    return hashCode;
  }
  
  public GetServiceLinkedRoleDeletionStatusResult clone()
  {
    try
    {
      return (GetServiceLinkedRoleDeletionStatusResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */