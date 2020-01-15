package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceStatusMarshaller;
import java.io.Serializable;

public class InstanceStatus
  implements Serializable, Cloneable, StructuredPojo
{
  private String state;
  private InstanceStateChangeReason stateChangeReason;
  private InstanceTimeline timeline;
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getState()
  {
    return state;
  }
  
  public InstanceStatus withState(String state)
  {
    setState(state);
    return this;
  }
  
  public void setState(InstanceState state)
  {
    withState(state);
  }
  
  public InstanceStatus withState(InstanceState state)
  {
    this.state = state.toString();
    return this;
  }
  
  public void setStateChangeReason(InstanceStateChangeReason stateChangeReason)
  {
    this.stateChangeReason = stateChangeReason;
  }
  
  public InstanceStateChangeReason getStateChangeReason()
  {
    return stateChangeReason;
  }
  
  public InstanceStatus withStateChangeReason(InstanceStateChangeReason stateChangeReason)
  {
    setStateChangeReason(stateChangeReason);
    return this;
  }
  
  public void setTimeline(InstanceTimeline timeline)
  {
    this.timeline = timeline;
  }
  
  public InstanceTimeline getTimeline()
  {
    return timeline;
  }
  
  public InstanceStatus withTimeline(InstanceTimeline timeline)
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
    if (!(obj instanceof InstanceStatus)) {
      return false;
    }
    InstanceStatus other = (InstanceStatus)obj;
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
    hashCode = 31 * hashCode + (getTimeline() == null ? 0 : getTimeline().hashCode());
    return hashCode;
  }
  
  public InstanceStatus clone()
  {
    try
    {
      return (InstanceStatus)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceStatusMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */