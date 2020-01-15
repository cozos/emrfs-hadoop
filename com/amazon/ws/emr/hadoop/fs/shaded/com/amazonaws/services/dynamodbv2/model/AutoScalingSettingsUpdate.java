package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingSettingsUpdateMarshaller;
import java.io.Serializable;

public class AutoScalingSettingsUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private Long minimumUnits;
  private Long maximumUnits;
  private Boolean autoScalingDisabled;
  private String autoScalingRoleArn;
  private AutoScalingPolicyUpdate scalingPolicyUpdate;
  
  public void setMinimumUnits(Long minimumUnits)
  {
    this.minimumUnits = minimumUnits;
  }
  
  public Long getMinimumUnits()
  {
    return minimumUnits;
  }
  
  public AutoScalingSettingsUpdate withMinimumUnits(Long minimumUnits)
  {
    setMinimumUnits(minimumUnits);
    return this;
  }
  
  public void setMaximumUnits(Long maximumUnits)
  {
    this.maximumUnits = maximumUnits;
  }
  
  public Long getMaximumUnits()
  {
    return maximumUnits;
  }
  
  public AutoScalingSettingsUpdate withMaximumUnits(Long maximumUnits)
  {
    setMaximumUnits(maximumUnits);
    return this;
  }
  
  public void setAutoScalingDisabled(Boolean autoScalingDisabled)
  {
    this.autoScalingDisabled = autoScalingDisabled;
  }
  
  public Boolean getAutoScalingDisabled()
  {
    return autoScalingDisabled;
  }
  
  public AutoScalingSettingsUpdate withAutoScalingDisabled(Boolean autoScalingDisabled)
  {
    setAutoScalingDisabled(autoScalingDisabled);
    return this;
  }
  
  public Boolean isAutoScalingDisabled()
  {
    return autoScalingDisabled;
  }
  
  public void setAutoScalingRoleArn(String autoScalingRoleArn)
  {
    this.autoScalingRoleArn = autoScalingRoleArn;
  }
  
  public String getAutoScalingRoleArn()
  {
    return autoScalingRoleArn;
  }
  
  public AutoScalingSettingsUpdate withAutoScalingRoleArn(String autoScalingRoleArn)
  {
    setAutoScalingRoleArn(autoScalingRoleArn);
    return this;
  }
  
  public void setScalingPolicyUpdate(AutoScalingPolicyUpdate scalingPolicyUpdate)
  {
    this.scalingPolicyUpdate = scalingPolicyUpdate;
  }
  
  public AutoScalingPolicyUpdate getScalingPolicyUpdate()
  {
    return scalingPolicyUpdate;
  }
  
  public AutoScalingSettingsUpdate withScalingPolicyUpdate(AutoScalingPolicyUpdate scalingPolicyUpdate)
  {
    setScalingPolicyUpdate(scalingPolicyUpdate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMinimumUnits() != null) {
      sb.append("MinimumUnits: ").append(getMinimumUnits()).append(",");
    }
    if (getMaximumUnits() != null) {
      sb.append("MaximumUnits: ").append(getMaximumUnits()).append(",");
    }
    if (getAutoScalingDisabled() != null) {
      sb.append("AutoScalingDisabled: ").append(getAutoScalingDisabled()).append(",");
    }
    if (getAutoScalingRoleArn() != null) {
      sb.append("AutoScalingRoleArn: ").append(getAutoScalingRoleArn()).append(",");
    }
    if (getScalingPolicyUpdate() != null) {
      sb.append("ScalingPolicyUpdate: ").append(getScalingPolicyUpdate());
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
    if (!(obj instanceof AutoScalingSettingsUpdate)) {
      return false;
    }
    AutoScalingSettingsUpdate other = (AutoScalingSettingsUpdate)obj;
    if (((other.getMinimumUnits() == null ? 1 : 0) ^ (getMinimumUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMinimumUnits() != null) && (!other.getMinimumUnits().equals(getMinimumUnits()))) {
      return false;
    }
    if (((other.getMaximumUnits() == null ? 1 : 0) ^ (getMaximumUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaximumUnits() != null) && (!other.getMaximumUnits().equals(getMaximumUnits()))) {
      return false;
    }
    if (((other.getAutoScalingDisabled() == null ? 1 : 0) ^ (getAutoScalingDisabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAutoScalingDisabled() != null) && (!other.getAutoScalingDisabled().equals(getAutoScalingDisabled()))) {
      return false;
    }
    if (((other.getAutoScalingRoleArn() == null ? 1 : 0) ^ (getAutoScalingRoleArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAutoScalingRoleArn() != null) && (!other.getAutoScalingRoleArn().equals(getAutoScalingRoleArn()))) {
      return false;
    }
    if (((other.getScalingPolicyUpdate() == null ? 1 : 0) ^ (getScalingPolicyUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScalingPolicyUpdate() != null) && (!other.getScalingPolicyUpdate().equals(getScalingPolicyUpdate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMinimumUnits() == null ? 0 : getMinimumUnits().hashCode());
    hashCode = 31 * hashCode + (getMaximumUnits() == null ? 0 : getMaximumUnits().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingDisabled() == null ? 0 : getAutoScalingDisabled().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingRoleArn() == null ? 0 : getAutoScalingRoleArn().hashCode());
    hashCode = 31 * hashCode + (getScalingPolicyUpdate() == null ? 0 : getScalingPolicyUpdate().hashCode());
    return hashCode;
  }
  
  public AutoScalingSettingsUpdate clone()
  {
    try
    {
      return (AutoScalingSettingsUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingSettingsUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */