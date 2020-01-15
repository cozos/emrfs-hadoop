package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepConfigMarshaller;
import java.io.Serializable;

public class StepConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private String actionOnFailure;
  private HadoopJarStepConfig hadoopJarStep;
  
  public StepConfig() {}
  
  public StepConfig(String name, HadoopJarStepConfig hadoopJarStep)
  {
    setName(name);
    setHadoopJarStep(hadoopJarStep);
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public StepConfig withName(String name)
  {
    setName(name);
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
  
  public StepConfig withActionOnFailure(String actionOnFailure)
  {
    setActionOnFailure(actionOnFailure);
    return this;
  }
  
  public void setActionOnFailure(ActionOnFailure actionOnFailure)
  {
    withActionOnFailure(actionOnFailure);
  }
  
  public StepConfig withActionOnFailure(ActionOnFailure actionOnFailure)
  {
    this.actionOnFailure = actionOnFailure.toString();
    return this;
  }
  
  public void setHadoopJarStep(HadoopJarStepConfig hadoopJarStep)
  {
    this.hadoopJarStep = hadoopJarStep;
  }
  
  public HadoopJarStepConfig getHadoopJarStep()
  {
    return hadoopJarStep;
  }
  
  public StepConfig withHadoopJarStep(HadoopJarStepConfig hadoopJarStep)
  {
    setHadoopJarStep(hadoopJarStep);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getActionOnFailure() != null) {
      sb.append("ActionOnFailure: ").append(getActionOnFailure()).append(",");
    }
    if (getHadoopJarStep() != null) {
      sb.append("HadoopJarStep: ").append(getHadoopJarStep());
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
    if (!(obj instanceof StepConfig)) {
      return false;
    }
    StepConfig other = (StepConfig)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getActionOnFailure() == null ? 1 : 0) ^ (getActionOnFailure() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getActionOnFailure() != null) && (!other.getActionOnFailure().equals(getActionOnFailure()))) {
      return false;
    }
    if (((other.getHadoopJarStep() == null ? 1 : 0) ^ (getHadoopJarStep() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHadoopJarStep() != null) && (!other.getHadoopJarStep().equals(getHadoopJarStep()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getActionOnFailure() == null ? 0 : getActionOnFailure().hashCode());
    hashCode = 31 * hashCode + (getHadoopJarStep() == null ? 0 : getHadoopJarStep().hashCode());
    return hashCode;
  }
  
  public StepConfig clone()
  {
    try
    {
      return (StepConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StepConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */