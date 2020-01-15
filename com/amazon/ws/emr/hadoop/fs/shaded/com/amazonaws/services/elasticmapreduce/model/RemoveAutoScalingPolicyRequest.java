package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RemoveAutoScalingPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private String instanceGroupId;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public RemoveAutoScalingPolicyRequest withClusterId(String clusterId)
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
  
  public RemoveAutoScalingPolicyRequest withInstanceGroupId(String instanceGroupId)
  {
    setInstanceGroupId(instanceGroupId);
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
      sb.append("InstanceGroupId: ").append(getInstanceGroupId());
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
    if (!(obj instanceof RemoveAutoScalingPolicyRequest)) {
      return false;
    }
    RemoveAutoScalingPolicyRequest other = (RemoveAutoScalingPolicyRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroupId() == null ? 0 : getInstanceGroupId().hashCode());
    return hashCode;
  }
  
  public RemoveAutoScalingPolicyRequest clone()
  {
    return (RemoveAutoScalingPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */