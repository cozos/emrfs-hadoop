package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SimpleScalingPolicyConfigurationMarshaller;
import java.io.Serializable;

public class SimpleScalingPolicyConfiguration
  implements Serializable, Cloneable, StructuredPojo
{
  private String adjustmentType;
  private Integer scalingAdjustment;
  private Integer coolDown;
  
  public void setAdjustmentType(String adjustmentType)
  {
    this.adjustmentType = adjustmentType;
  }
  
  public String getAdjustmentType()
  {
    return adjustmentType;
  }
  
  public SimpleScalingPolicyConfiguration withAdjustmentType(String adjustmentType)
  {
    setAdjustmentType(adjustmentType);
    return this;
  }
  
  public void setAdjustmentType(AdjustmentType adjustmentType)
  {
    withAdjustmentType(adjustmentType);
  }
  
  public SimpleScalingPolicyConfiguration withAdjustmentType(AdjustmentType adjustmentType)
  {
    this.adjustmentType = adjustmentType.toString();
    return this;
  }
  
  public void setScalingAdjustment(Integer scalingAdjustment)
  {
    this.scalingAdjustment = scalingAdjustment;
  }
  
  public Integer getScalingAdjustment()
  {
    return scalingAdjustment;
  }
  
  public SimpleScalingPolicyConfiguration withScalingAdjustment(Integer scalingAdjustment)
  {
    setScalingAdjustment(scalingAdjustment);
    return this;
  }
  
  public void setCoolDown(Integer coolDown)
  {
    this.coolDown = coolDown;
  }
  
  public Integer getCoolDown()
  {
    return coolDown;
  }
  
  public SimpleScalingPolicyConfiguration withCoolDown(Integer coolDown)
  {
    setCoolDown(coolDown);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAdjustmentType() != null) {
      sb.append("AdjustmentType: ").append(getAdjustmentType()).append(",");
    }
    if (getScalingAdjustment() != null) {
      sb.append("ScalingAdjustment: ").append(getScalingAdjustment()).append(",");
    }
    if (getCoolDown() != null) {
      sb.append("CoolDown: ").append(getCoolDown());
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
    if (!(obj instanceof SimpleScalingPolicyConfiguration)) {
      return false;
    }
    SimpleScalingPolicyConfiguration other = (SimpleScalingPolicyConfiguration)obj;
    if (((other.getAdjustmentType() == null ? 1 : 0) ^ (getAdjustmentType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAdjustmentType() != null) && (!other.getAdjustmentType().equals(getAdjustmentType()))) {
      return false;
    }
    if (((other.getScalingAdjustment() == null ? 1 : 0) ^ (getScalingAdjustment() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScalingAdjustment() != null) && (!other.getScalingAdjustment().equals(getScalingAdjustment()))) {
      return false;
    }
    if (((other.getCoolDown() == null ? 1 : 0) ^ (getCoolDown() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCoolDown() != null) && (!other.getCoolDown().equals(getCoolDown()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAdjustmentType() == null ? 0 : getAdjustmentType().hashCode());
    hashCode = 31 * hashCode + (getScalingAdjustment() == null ? 0 : getScalingAdjustment().hashCode());
    hashCode = 31 * hashCode + (getCoolDown() == null ? 0 : getCoolDown().hashCode());
    return hashCode;
  }
  
  public SimpleScalingPolicyConfiguration clone()
  {
    try
    {
      return (SimpleScalingPolicyConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SimpleScalingPolicyConfigurationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SimpleScalingPolicyConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */