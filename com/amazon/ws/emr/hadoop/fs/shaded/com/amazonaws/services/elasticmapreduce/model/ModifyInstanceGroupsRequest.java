package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ModifyInstanceGroupsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private SdkInternalList<InstanceGroupModifyConfig> instanceGroups;
  
  public ModifyInstanceGroupsRequest() {}
  
  public ModifyInstanceGroupsRequest(List<InstanceGroupModifyConfig> instanceGroups)
  {
    setInstanceGroups(instanceGroups);
  }
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public ModifyInstanceGroupsRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
  public List<InstanceGroupModifyConfig> getInstanceGroups()
  {
    if (instanceGroups == null) {
      instanceGroups = new SdkInternalList();
    }
    return instanceGroups;
  }
  
  public void setInstanceGroups(Collection<InstanceGroupModifyConfig> instanceGroups)
  {
    if (instanceGroups == null)
    {
      this.instanceGroups = null;
      return;
    }
    this.instanceGroups = new SdkInternalList(instanceGroups);
  }
  
  public ModifyInstanceGroupsRequest withInstanceGroups(InstanceGroupModifyConfig... instanceGroups)
  {
    if (this.instanceGroups == null) {
      setInstanceGroups(new SdkInternalList(instanceGroups.length));
    }
    for (InstanceGroupModifyConfig ele : instanceGroups) {
      this.instanceGroups.add(ele);
    }
    return this;
  }
  
  public ModifyInstanceGroupsRequest withInstanceGroups(Collection<InstanceGroupModifyConfig> instanceGroups)
  {
    setInstanceGroups(instanceGroups);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
    if (getInstanceGroups() != null) {
      sb.append("InstanceGroups: ").append(getInstanceGroups());
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
    if (!(obj instanceof ModifyInstanceGroupsRequest)) {
      return false;
    }
    ModifyInstanceGroupsRequest other = (ModifyInstanceGroupsRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getInstanceGroups() == null ? 1 : 0) ^ (getInstanceGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroups() != null) && (!other.getInstanceGroups().equals(getInstanceGroups()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroups() == null ? 0 : getInstanceGroups().hashCode());
    return hashCode;
  }
  
  public ModifyInstanceGroupsRequest clone()
  {
    return (ModifyInstanceGroupsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */