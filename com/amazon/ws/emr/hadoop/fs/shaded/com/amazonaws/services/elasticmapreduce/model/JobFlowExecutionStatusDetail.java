package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowExecutionStatusDetailMarshaller;
import java.io.Serializable;
import java.util.Date;

public class JobFlowExecutionStatusDetail
  implements Serializable, Cloneable, StructuredPojo
{
  private String state;
  private Date creationDateTime;
  private Date startDateTime;
  private Date readyDateTime;
  private Date endDateTime;
  private String lastStateChangeReason;
  
  public JobFlowExecutionStatusDetail() {}
  
  public JobFlowExecutionStatusDetail(String state, Date creationDateTime)
  {
    setState(state);
    setCreationDateTime(creationDateTime);
  }
  
  public JobFlowExecutionStatusDetail(JobFlowExecutionState state, Date creationDateTime)
  {
    setState(state.toString());
    setCreationDateTime(creationDateTime);
  }
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getState()
  {
    return state;
  }
  
  public JobFlowExecutionStatusDetail withState(String state)
  {
    setState(state);
    return this;
  }
  
  public void setState(JobFlowExecutionState state)
  {
    withState(state);
  }
  
  public JobFlowExecutionStatusDetail withState(JobFlowExecutionState state)
  {
    this.state = state.toString();
    return this;
  }
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public JobFlowExecutionStatusDetail withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setStartDateTime(Date startDateTime)
  {
    this.startDateTime = startDateTime;
  }
  
  public Date getStartDateTime()
  {
    return startDateTime;
  }
  
  public JobFlowExecutionStatusDetail withStartDateTime(Date startDateTime)
  {
    setStartDateTime(startDateTime);
    return this;
  }
  
  public void setReadyDateTime(Date readyDateTime)
  {
    this.readyDateTime = readyDateTime;
  }
  
  public Date getReadyDateTime()
  {
    return readyDateTime;
  }
  
  public JobFlowExecutionStatusDetail withReadyDateTime(Date readyDateTime)
  {
    setReadyDateTime(readyDateTime);
    return this;
  }
  
  public void setEndDateTime(Date endDateTime)
  {
    this.endDateTime = endDateTime;
  }
  
  public Date getEndDateTime()
  {
    return endDateTime;
  }
  
  public JobFlowExecutionStatusDetail withEndDateTime(Date endDateTime)
  {
    setEndDateTime(endDateTime);
    return this;
  }
  
  public void setLastStateChangeReason(String lastStateChangeReason)
  {
    this.lastStateChangeReason = lastStateChangeReason;
  }
  
  public String getLastStateChangeReason()
  {
    return lastStateChangeReason;
  }
  
  public JobFlowExecutionStatusDetail withLastStateChangeReason(String lastStateChangeReason)
  {
    setLastStateChangeReason(lastStateChangeReason);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getState() != null) {
      sb.append("State: ").append(getState()).append(",");
    }
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime()).append(",");
    }
    if (getStartDateTime() != null) {
      sb.append("StartDateTime: ").append(getStartDateTime()).append(",");
    }
    if (getReadyDateTime() != null) {
      sb.append("ReadyDateTime: ").append(getReadyDateTime()).append(",");
    }
    if (getEndDateTime() != null) {
      sb.append("EndDateTime: ").append(getEndDateTime()).append(",");
    }
    if (getLastStateChangeReason() != null) {
      sb.append("LastStateChangeReason: ").append(getLastStateChangeReason());
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
    if (!(obj instanceof JobFlowExecutionStatusDetail)) {
      return false;
    }
    JobFlowExecutionStatusDetail other = (JobFlowExecutionStatusDetail)obj;
    if (((other.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getState() != null) && (!other.getState().equals(getState()))) {
      return false;
    }
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getStartDateTime() == null ? 1 : 0) ^ (getStartDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartDateTime() != null) && (!other.getStartDateTime().equals(getStartDateTime()))) {
      return false;
    }
    if (((other.getReadyDateTime() == null ? 1 : 0) ^ (getReadyDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReadyDateTime() != null) && (!other.getReadyDateTime().equals(getReadyDateTime()))) {
      return false;
    }
    if (((other.getEndDateTime() == null ? 1 : 0) ^ (getEndDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndDateTime() != null) && (!other.getEndDateTime().equals(getEndDateTime()))) {
      return false;
    }
    if (((other.getLastStateChangeReason() == null ? 1 : 0) ^ (getLastStateChangeReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastStateChangeReason() != null) && (!other.getLastStateChangeReason().equals(getLastStateChangeReason()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getState() == null ? 0 : getState().hashCode());
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getStartDateTime() == null ? 0 : getStartDateTime().hashCode());
    hashCode = 31 * hashCode + (getReadyDateTime() == null ? 0 : getReadyDateTime().hashCode());
    hashCode = 31 * hashCode + (getEndDateTime() == null ? 0 : getEndDateTime().hashCode());
    hashCode = 31 * hashCode + (getLastStateChangeReason() == null ? 0 : getLastStateChangeReason().hashCode());
    return hashCode;
  }
  
  public JobFlowExecutionStatusDetail clone()
  {
    try
    {
      return (JobFlowExecutionStatusDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    JobFlowExecutionStatusDetailMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowExecutionStatusDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */