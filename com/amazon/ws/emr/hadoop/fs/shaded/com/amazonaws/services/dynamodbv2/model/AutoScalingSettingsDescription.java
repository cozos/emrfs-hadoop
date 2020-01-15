package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingSettingsDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AutoScalingSettingsDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private Long minimumUnits;
  private Long maximumUnits;
  private Boolean autoScalingDisabled;
  private String autoScalingRoleArn;
  private List<AutoScalingPolicyDescription> scalingPolicies;
  
  public void setMinimumUnits(Long minimumUnits)
  {
    this.minimumUnits = minimumUnits;
  }
  
  public Long getMinimumUnits()
  {
    return minimumUnits;
  }
  
  public AutoScalingSettingsDescription withMinimumUnits(Long minimumUnits)
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
  
  public AutoScalingSettingsDescription withMaximumUnits(Long maximumUnits)
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
  
  public AutoScalingSettingsDescription withAutoScalingDisabled(Boolean autoScalingDisabled)
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
  
  public AutoScalingSettingsDescription withAutoScalingRoleArn(String autoScalingRoleArn)
  {
    setAutoScalingRoleArn(autoScalingRoleArn);
    return this;
  }
  
  public List<AutoScalingPolicyDescription> getScalingPolicies()
  {
    return scalingPolicies;
  }
  
  public void setScalingPolicies(Collection<AutoScalingPolicyDescription> scalingPolicies)
  {
    if (scalingPolicies == null)
    {
      this.scalingPolicies = null;
      return;
    }
    this.scalingPolicies = new ArrayList(scalingPolicies);
  }
  
  public AutoScalingSettingsDescription withScalingPolicies(AutoScalingPolicyDescription... scalingPolicies)
  {
    if (this.scalingPolicies == null) {
      setScalingPolicies(new ArrayList(scalingPolicies.length));
    }
    for (AutoScalingPolicyDescription ele : scalingPolicies) {
      this.scalingPolicies.add(ele);
    }
    return this;
  }
  
  public AutoScalingSettingsDescription withScalingPolicies(Collection<AutoScalingPolicyDescription> scalingPolicies)
  {
    setScalingPolicies(scalingPolicies);
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
    if (getScalingPolicies() != null) {
      sb.append("ScalingPolicies: ").append(getScalingPolicies());
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
    if (!(obj instanceof AutoScalingSettingsDescription)) {
      return false;
    }
    AutoScalingSettingsDescription other = (AutoScalingSettingsDescription)obj;
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
    if (((other.getScalingPolicies() == null ? 1 : 0) ^ (getScalingPolicies() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScalingPolicies() != null) && (!other.getScalingPolicies().equals(getScalingPolicies()))) {
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
    hashCode = 31 * hashCode + (getScalingPolicies() == null ? 0 : getScalingPolicies().hashCode());
    return hashCode;
  }
  
  public AutoScalingSettingsDescription clone()
  {
    try
    {
      return (AutoScalingSettingsDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingSettingsDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */