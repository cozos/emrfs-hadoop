package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingRuleMarshaller;
import java.io.Serializable;

public class ScalingRule
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private String description;
  private ScalingAction action;
  private ScalingTrigger trigger;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public ScalingRule withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public ScalingRule withDescription(String description)
  {
    setDescription(description);
    return this;
  }
  
  public void setAction(ScalingAction action)
  {
    this.action = action;
  }
  
  public ScalingAction getAction()
  {
    return action;
  }
  
  public ScalingRule withAction(ScalingAction action)
  {
    setAction(action);
    return this;
  }
  
  public void setTrigger(ScalingTrigger trigger)
  {
    this.trigger = trigger;
  }
  
  public ScalingTrigger getTrigger()
  {
    return trigger;
  }
  
  public ScalingRule withTrigger(ScalingTrigger trigger)
  {
    setTrigger(trigger);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getAction() != null) {
      sb.append("Action: ").append(getAction()).append(",");
    }
    if (getTrigger() != null) {
      sb.append("Trigger: ").append(getTrigger());
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
    if (!(obj instanceof ScalingRule)) {
      return false;
    }
    ScalingRule other = (ScalingRule)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getAction() == null ? 1 : 0) ^ (getAction() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAction() != null) && (!other.getAction().equals(getAction()))) {
      return false;
    }
    if (((other.getTrigger() == null ? 1 : 0) ^ (getTrigger() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTrigger() != null) && (!other.getTrigger().equals(getTrigger()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getAction() == null ? 0 : getAction().hashCode());
    hashCode = 31 * hashCode + (getTrigger() == null ? 0 : getTrigger().hashCode());
    return hashCode;
  }
  
  public ScalingRule clone()
  {
    try
    {
      return (ScalingRule)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ScalingRuleMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */