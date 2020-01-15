package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class PutAutoScalingPolicyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String clusterId;
  private String instanceGroupId;
  private AutoScalingPolicyDescription autoScalingPolicy;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public PutAutoScalingPolicyResult withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
  public void setInstanceGroupId(String instanceGroupId)
  {
    this.instanceGroupId = instanceGroupId;
  }
  
  public String getInstanceGroupId()
  {
    return instanceGroupId;
  }
  
  public PutAutoScalingPolicyResult withInstanceGroupId(String instanceGroupId)
  {
    setInstanceGroupId(instanceGroupId);
    return this;
  }
  
  public void setAutoScalingPolicy(AutoScalingPolicyDescription autoScalingPolicy)
  {
    this.autoScalingPolicy = autoScalingPolicy;
  }
  
  public AutoScalingPolicyDescription getAutoScalingPolicy()
  {
    return autoScalingPolicy;
  }
  
  public PutAutoScalingPolicyResult withAutoScalingPolicy(AutoScalingPolicyDescription autoScalingPolicy)
  {
    setAutoScalingPolicy(autoScalingPolicy);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
    if (getInstanceGroupId() != null) {
      sb.append("InstanceGroupId: ").append(getInstanceGroupId()).append(",");
    }
    if (getAutoScalingPolicy() != null) {
      sb.append("AutoScalingPolicy: ").append(getAutoScalingPolicy());
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
    if (!(obj instanceof PutAutoScalingPolicyResult)) {
      return false;
    }
    PutAutoScalingPolicyResult other = (PutAutoScalingPolicyResult)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getInstanceGroupId() == null ? 1 : 0) ^ (getInstanceGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupId() != null) && (!other.getInstanceGroupId().equals(getInstanceGroupId()))) {
      return false;
    }
    if (((other.getAutoScalingPolicy() == null ? 1 : 0) ^ (getAutoScalingPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAutoScalingPolicy() != null) && (!other.getAutoScalingPolicy().equals(getAutoScalingPolicy()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroupId() == null ? 0 : getInstanceGroupId().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingPolicy() == null ? 0 : getAutoScalingPolicy().hashCode());
    return hashCode;
  }
  
  public PutAutoScalingPolicyResult clone()
  {
    try
    {
      return (PutAutoScalingPolicyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */