package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CancelStepsInfoMarshaller;
import java.io.Serializable;

public class CancelStepsInfo
  implements Serializable, Cloneable, StructuredPojo
{
  private String stepId;
  private String status;
  private String reason;
  
  public void setStepId(String stepId)
  {
    this.stepId = stepId;
  }
  
  public String getStepId()
  {
    return stepId;
  }
  
  public CancelStepsInfo withStepId(String stepId)
  {
    setStepId(stepId);
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
  
  public CancelStepsInfo withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(CancelStepsRequestStatus status)
  {
    withStatus(status);
  }
  
  public CancelStepsInfo withStatus(CancelStepsRequestStatus status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setReason(String reason)
  {
    this.reason = reason;
  }
  
  public String getReason()
  {
    return reason;
  }
  
  public CancelStepsInfo withReason(String reason)
  {
    setReason(reason);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStepId() != null) {
      sb.append("StepId: ").append(getStepId()).append(",");
    }
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
    if (!(obj instanceof CancelStepsInfo)) {
      return false;
    }
    CancelStepsInfo other = (CancelStepsInfo)obj;
    if (((other.getStepId() == null ? 1 : 0) ^ (getStepId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStepId() != null) && (!other.getStepId().equals(getStepId()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getStepId() == null ? 0 : getStepId().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getReason() == null ? 0 : getReason().hashCode());
    return hashCode;
  }
  
  public CancelStepsInfo clone()
  {
    try
    {
      return (CancelStepsInfo)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CancelStepsInfoMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */