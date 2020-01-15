package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepDetailMarshaller;
import java.io.Serializable;

public class StepDetail
  implements Serializable, Cloneable, StructuredPojo
{
  private StepConfig stepConfig;
  private StepExecutionStatusDetail executionStatusDetail;
  
  public StepDetail() {}
  
  public StepDetail(StepConfig stepConfig, StepExecutionStatusDetail executionStatusDetail)
  {
    setStepConfig(stepConfig);
    setExecutionStatusDetail(executionStatusDetail);
  }
  
  public void setStepConfig(StepConfig stepConfig)
  {
    this.stepConfig = stepConfig;
  }
  
  public StepConfig getStepConfig()
  {
    return stepConfig;
  }
  
  public StepDetail withStepConfig(StepConfig stepConfig)
  {
    setStepConfig(stepConfig);
    return this;
  }
  
  public void setExecutionStatusDetail(StepExecutionStatusDetail executionStatusDetail)
  {
    this.executionStatusDetail = executionStatusDetail;
  }
  
  public StepExecutionStatusDetail getExecutionStatusDetail()
  {
    return executionStatusDetail;
  }
  
  public StepDetail withExecutionStatusDetail(StepExecutionStatusDetail executionStatusDetail)
  {
    setExecutionStatusDetail(executionStatusDetail);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStepConfig() != null) {
      sb.append("StepConfig: ").append(getStepConfig()).append(",");
    }
    if (getExecutionStatusDetail() != null) {
      sb.append("ExecutionStatusDetail: ").append(getExecutionStatusDetail());
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
    if (!(obj instanceof StepDetail)) {
      return false;
    }
    StepDetail other = (StepDetail)obj;
    if (((other.getStepConfig() == null ? 1 : 0) ^ (getStepConfig() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStepConfig() != null) && (!other.getStepConfig().equals(getStepConfig()))) {
      return false;
    }
    if (((other.getExecutionStatusDetail() == null ? 1 : 0) ^ (getExecutionStatusDetail() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExecutionStatusDetail() != null) && (!other.getExecutionStatusDetail().equals(getExecutionStatusDetail()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStepConfig() == null ? 0 : getStepConfig().hashCode());
    hashCode = 31 * hashCode + (getExecutionStatusDetail() == null ? 0 : getExecutionStatusDetail().hashCode());
    return hashCode;
  }
  
  public StepDetail clone()
  {
    try
    {
      return (StepDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StepDetailMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */