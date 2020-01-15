package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingTargetTrackingScalingPolicyConfigurationUpdateMarshaller;
import java.io.Serializable;

public class AutoScalingTargetTrackingScalingPolicyConfigurationUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private Boolean disableScaleIn;
  private Integer scaleInCooldown;
  private Integer scaleOutCooldown;
  private Double targetValue;
  
  public void setDisableScaleIn(Boolean disableScaleIn)
  {
    this.disableScaleIn = disableScaleIn;
  }
  
  public Boolean getDisableScaleIn()
  {
    return disableScaleIn;
  }
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withDisableScaleIn(Boolean disableScaleIn)
  {
    setDisableScaleIn(disableScaleIn);
    return this;
  }
  
  public Boolean isDisableScaleIn()
  {
    return disableScaleIn;
  }
  
  public void setScaleInCooldown(Integer scaleInCooldown)
  {
    this.scaleInCooldown = scaleInCooldown;
  }
  
  public Integer getScaleInCooldown()
  {
    return scaleInCooldown;
  }
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withScaleInCooldown(Integer scaleInCooldown)
  {
    setScaleInCooldown(scaleInCooldown);
    return this;
  }
  
  public void setScaleOutCooldown(Integer scaleOutCooldown)
  {
    this.scaleOutCooldown = scaleOutCooldown;
  }
  
  public Integer getScaleOutCooldown()
  {
    return scaleOutCooldown;
  }
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withScaleOutCooldown(Integer scaleOutCooldown)
  {
    setScaleOutCooldown(scaleOutCooldown);
    return this;
  }
  
  public void setTargetValue(Double targetValue)
  {
    this.targetValue = targetValue;
  }
  
  public Double getTargetValue()
  {
    return targetValue;
  }
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withTargetValue(Double targetValue)
  {
    setTargetValue(targetValue);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDisableScaleIn() != null) {
      sb.append("DisableScaleIn: ").append(getDisableScaleIn()).append(",");
    }
    if (getScaleInCooldown() != null) {
      sb.append("ScaleInCooldown: ").append(getScaleInCooldown()).append(",");
    }
    if (getScaleOutCooldown() != null) {
      sb.append("ScaleOutCooldown: ").append(getScaleOutCooldown()).append(",");
    }
    if (getTargetValue() != null) {
      sb.append("TargetValue: ").append(getTargetValue());
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
    if (!(obj instanceof AutoScalingTargetTrackingScalingPolicyConfigurationUpdate)) {
      return false;
    }
    AutoScalingTargetTrackingScalingPolicyConfigurationUpdate other = (AutoScalingTargetTrackingScalingPolicyConfigurationUpdate)obj;
    if (((other.getDisableScaleIn() == null ? 1 : 0) ^ (getDisableScaleIn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDisableScaleIn() != null) && (!other.getDisableScaleIn().equals(getDisableScaleIn()))) {
      return false;
    }
    if (((other.getScaleInCooldown() == null ? 1 : 0) ^ (getScaleInCooldown() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScaleInCooldown() != null) && (!other.getScaleInCooldown().equals(getScaleInCooldown()))) {
      return false;
    }
    if (((other.getScaleOutCooldown() == null ? 1 : 0) ^ (getScaleOutCooldown() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScaleOutCooldown() != null) && (!other.getScaleOutCooldown().equals(getScaleOutCooldown()))) {
      return false;
    }
    if (((other.getTargetValue() == null ? 1 : 0) ^ (getTargetValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetValue() != null) && (!other.getTargetValue().equals(getTargetValue()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDisableScaleIn() == null ? 0 : getDisableScaleIn().hashCode());
    hashCode = 31 * hashCode + (getScaleInCooldown() == null ? 0 : getScaleInCooldown().hashCode());
    hashCode = 31 * hashCode + (getScaleOutCooldown() == null ? 0 : getScaleOutCooldown().hashCode());
    hashCode = 31 * hashCode + (getTargetValue() == null ? 0 : getTargetValue().hashCode());
    return hashCode;
  }
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate clone()
  {
    try
    {
      return (AutoScalingTargetTrackingScalingPolicyConfigurationUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingTargetTrackingScalingPolicyConfigurationUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */