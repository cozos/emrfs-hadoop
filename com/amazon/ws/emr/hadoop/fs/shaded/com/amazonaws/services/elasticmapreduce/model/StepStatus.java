package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepStatusMarshaller;
import java.io.Serializable;

public class StepStatus
  implements Serializable, Cloneable, StructuredPojo
{
  private String state;
  private StepStateChangeReason stateChangeReason;
  private FailureDetails failureDetails;
  private StepTimeline timeline;
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getState()
  {
    return state;
  }
  
  public StepStatus withState(String state)
  {
    setState(state);
    return this;
  }
  
  public void setState(StepState state)
  {
    withState(state);
  }
  
  public StepStatus withState(StepState state)
  {
    this.state = state.toString();
    return this;
  }
  
  public void setStateChangeReason(StepStateChangeReason stateChangeReason)
  {
    this.stateChangeReason = stateChangeReason;
  }
  
  public StepStateChangeReason getStateChangeReason()
  {
    return stateChangeReason;
  }
  
  public StepStatus withStateChangeReason(StepStateChangeReason stateChangeReason)
  {
    setStateChangeReason(stateChangeReason);
    return this;
  }
  
  public void setFailureDetails(FailureDetails failureDetails)
  {
    this.failureDetails = failureDetails;
  }
  
  public FailureDetails getFailureDetails()
  {
    return failureDetails;
  }
  
  public StepStatus withFailureDetails(FailureDetails failureDetails)
  {
    setFailureDetails(failureDetails);
    return this;
  }
  
  public void setTimeline(StepTimeline timeline)
  {
    this.timeline = timeline;
  }
  
  public StepTimeline getTimeline()
  {
    return timeline;
  }
  
  public StepStatus withTimeline(StepTimeline timeline)
  {
    setTimeline(timeline);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getState() != null) {
      sb.append("State: ").append(getState()).append(",");
    }
    if (getStateChangeReason() != null) {
      sb.append("StateChangeReason: ").append(getStateChangeReason()).append(",");
    }
    if (getFailureDetails() != null) {
      sb.append("FailureDetails: ").append(getFailureDetails()).append(",");
    }
    if (getTimeline() != null) {
      sb.append("Timeline: ").append(getTimeline());
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
    if (!(obj instanceof StepStatus)) {
      return false;
    }
    StepStatus other = (StepStatus)obj;
    if (((other.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getState() != null) && (!other.getState().equals(getState()))) {
      return false;
    }
    if (((other.getStateChangeReason() == null ? 1 : 0) ^ (getStateChangeReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateChangeReason() != null) && (!other.getStateChangeReason().equals(getStateChangeReason()))) {
      return false;
    }
    if (((other.getFailureDetails() == null ? 1 : 0) ^ (getFailureDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFailureDetails() != null) && (!other.getFailureDetails().equals(getFailureDetails()))) {
      return false;
    }
    if (((other.getTimeline() == null ? 1 : 0) ^ (getTimeline() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeline() != null) && (!other.getTimeline().equals(getTimeline()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getState() == null ? 0 : getState().hashCode());
    hashCode = 31 * hashCode + (getStateChangeReason() == null ? 0 : getStateChangeReason().hashCode());
    hashCode = 31 * hashCode + (getFailureDetails() == null ? 0 : getFailureDetails().hashCode());
    hashCode = 31 * hashCode + (getTimeline() == null ? 0 : getTimeline().hashCode());
    return hashCode;
  }
  
  public StepStatus clone()
  {
    try
    {
      return (StepStatus)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StepStatusMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */