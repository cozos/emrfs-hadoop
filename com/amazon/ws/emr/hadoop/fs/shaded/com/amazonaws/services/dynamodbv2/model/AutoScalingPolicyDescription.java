package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingPolicyDescriptionMarshaller;
import java.io.Serializable;

public class AutoScalingPolicyDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String policyName;
  private AutoScalingTargetTrackingScalingPolicyConfigurationDescription targetTrackingScalingPolicyConfiguration;
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public AutoScalingPolicyDescription withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationDescription targetTrackingScalingPolicyConfiguration)
  {
    this.targetTrackingScalingPolicyConfiguration = targetTrackingScalingPolicyConfiguration;
  }
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationDescription getTargetTrackingScalingPolicyConfiguration()
  {
    return targetTrackingScalingPolicyConfiguration;
  }
  
  public AutoScalingPolicyDescription withTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationDescription targetTrackingScalingPolicyConfiguration)
  {
    setTargetTrackingScalingPolicyConfiguration(targetTrackingScalingPolicyConfiguration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
    if (getTargetTrackingScalingPolicyConfiguration() != null) {
      sb.append("TargetTrackingScalingPolicyConfiguration: ").append(getTargetTrackingScalingPolicyConfiguration());
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
    if (!(obj instanceof AutoScalingPolicyDescription)) {
      return false;
    }
    AutoScalingPolicyDescription other = (AutoScalingPolicyDescription)obj;
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    if (((other.getTargetTrackingScalingPolicyConfiguration() == null ? 1 : 0) ^ (getTargetTrackingScalingPolicyConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetTrackingScalingPolicyConfiguration() != null) && 
      (!other.getTargetTrackingScalingPolicyConfiguration().equals(getTargetTrackingScalingPolicyConfiguration()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getTargetTrackingScalingPolicyConfiguration() == null ? 0 : getTargetTrackingScalingPolicyConfiguration().hashCode());
    return hashCode;
  }
  
  public AutoScalingPolicyDescription clone()
  {
    try
    {
      return (AutoScalingPolicyDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingPolicyDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */