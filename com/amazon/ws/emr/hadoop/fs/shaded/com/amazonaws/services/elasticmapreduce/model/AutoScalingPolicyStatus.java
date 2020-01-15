package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyStatusMarshaller;
import java.io.Serializable;

public class AutoScalingPolicyStatus
  implements Serializable, Cloneable, StructuredPojo
{
  private String state;
  private AutoScalingPolicyStateChangeReason stateChangeReason;
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getState()
  {
    return state;
  }
  
  public AutoScalingPolicyStatus withState(String state)
  {
    setState(state);
    return this;
  }
  
  public void setState(AutoScalingPolicyState state)
  {
    withState(state);
  }
  
  public AutoScalingPolicyStatus withState(AutoScalingPolicyState state)
  {
    this.state = state.toString();
    return this;
  }
  
  public void setStateChangeReason(AutoScalingPolicyStateChangeReason stateChangeReason)
  {
    this.stateChangeReason = stateChangeReason;
  }
  
  public AutoScalingPolicyStateChangeReason getStateChangeReason()
  {
    return stateChangeReason;
  }
  
  public AutoScalingPolicyStatus withStateChangeReason(AutoScalingPolicyStateChangeReason stateChangeReason)
  {
    setStateChangeReason(stateChangeReason);
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
      sb.append("StateChangeReason: ").append(getStateChangeReason());
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
    if (!(obj instanceof AutoScalingPolicyStatus)) {
      return false;
    }
    AutoScalingPolicyStatus other = (AutoScalingPolicyStatus)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getState() == null ? 0 : getState().hashCode());
    hashCode = 31 * hashCode + (getStateChangeReason() == null ? 0 : getStateChangeReason().hashCode());
    return hashCode;
  }
  
  public AutoScalingPolicyStatus clone()
  {
    try
    {
      return (AutoScalingPolicyStatus)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingPolicyStatusMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */