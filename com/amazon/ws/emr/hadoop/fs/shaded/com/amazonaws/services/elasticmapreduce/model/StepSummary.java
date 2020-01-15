package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepSummaryMarshaller;
import java.io.Serializable;

public class StepSummary
  implements Serializable, Cloneable, StructuredPojo
{
  private String id;
  private String name;
  private HadoopStepConfig config;
  private String actionOnFailure;
  private StepStatus status;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public StepSummary withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public StepSummary withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setConfig(HadoopStepConfig config)
  {
    this.config = config;
  }
  
  public HadoopStepConfig getConfig()
  {
    return config;
  }
  
  public StepSummary withConfig(HadoopStepConfig config)
  {
    setConfig(config);
    return this;
  }
  
  public void setActionOnFailure(String actionOnFailure)
  {
    this.actionOnFailure = actionOnFailure;
  }
  
  public String getActionOnFailure()
  {
    return actionOnFailure;
  }
  
  public StepSummary withActionOnFailure(String actionOnFailure)
  {
    setActionOnFailure(actionOnFailure);
    return this;
  }
  
  public void setActionOnFailure(ActionOnFailure actionOnFailure)
  {
    withActionOnFailure(actionOnFailure);
  }
  
  public StepSummary withActionOnFailure(ActionOnFailure actionOnFailure)
  {
    this.actionOnFailure = actionOnFailure.toString();
    return this;
  }
  
  public void setStatus(StepStatus status)
  {
    this.status = status;
  }
  
  public StepStatus getStatus()
  {
    return status;
  }
  
  public StepSummary withStatus(StepStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getConfig() != null) {
      sb.append("Config: ").append(getConfig()).append(",");
    }
    if (getActionOnFailure() != null) {
      sb.append("ActionOnFailure: ").append(getActionOnFailure()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus());
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
    if (!(obj instanceof StepSummary)) {
      return false;
    }
    StepSummary other = (StepSummary)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getConfig() == null ? 1 : 0) ^ (getConfig() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfig() != null) && (!other.getConfig().equals(getConfig()))) {
      return false;
    }
    if (((other.getActionOnFailure() == null ? 1 : 0) ^ (getActionOnFailure() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getActionOnFailure() != null) && (!other.getActionOnFailure().equals(getActionOnFailure()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getConfig() == null ? 0 : getConfig().hashCode());
    hashCode = 31 * hashCode + (getActionOnFailure() == null ? 0 : getActionOnFailure().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    return hashCode;
  }
  
  public StepSummary clone()
  {
    try
    {
      return (StepSummary)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StepSummaryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */