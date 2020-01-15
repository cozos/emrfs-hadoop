package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AddInstanceGroupsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<InstanceGroupConfig> instanceGroups;
  private String jobFlowId;
  
  public AddInstanceGroupsRequest() {}
  
  public AddInstanceGroupsRequest(List<InstanceGroupConfig> instanceGroups, String jobFlowId)
  {
    setInstanceGroups(instanceGroups);
    setJobFlowId(jobFlowId);
  }
  
  public List<InstanceGroupConfig> getInstanceGroups()
  {
    if (instanceGroups == null) {
      instanceGroups = new SdkInternalList();
    }
    return instanceGroups;
  }
  
  public void setInstanceGroups(Collection<InstanceGroupConfig> instanceGroups)
  {
    if (instanceGroups == null)
    {
      this.instanceGroups = null;
      return;
    }
    this.instanceGroups = new SdkInternalList(instanceGroups);
  }
  
  public AddInstanceGroupsRequest withInstanceGroups(InstanceGroupConfig... instanceGroups)
  {
    if (this.instanceGroups == null) {
      setInstanceGroups(new SdkInternalList(instanceGroups.length));
    }
    for (InstanceGroupConfig ele : instanceGroups) {
      this.instanceGroups.add(ele);
    }
    return this;
  }
  
  public AddInstanceGroupsRequest withInstanceGroups(Collection<InstanceGroupConfig> instanceGroups)
  {
    setInstanceGroups(instanceGroups);
    return this;
  }
  
  public void setJobFlowId(String jobFlowId)
  {
    this.jobFlowId = jobFlowId;
  }
  
  public String getJobFlowId()
  {
    return jobFlowId;
  }
  
  public AddInstanceGroupsRequest withJobFlowId(String jobFlowId)
  {
    setJobFlowId(jobFlowId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceGroups() != null) {
      sb.append("InstanceGroups: ").append(getInstanceGroups()).append(",");
    }
    if (getJobFlowId() != null) {
      sb.append("JobFlowId: ").append(getJobFlowId());
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
    if (!(obj instanceof AddInstanceGroupsRequest)) {
      return false;
    }
    AddInstanceGroupsRequest other = (AddInstanceGroupsRequest)obj;
    if (((other.getInstanceGroups() == null ? 1 : 0) ^ (getInstanceGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroups() != null) && (!other.getInstanceGroups().equals(getInstanceGroups()))) {
      return false;
    }
    if (((other.getJobFlowId() == null ? 1 : 0) ^ (getJobFlowId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowId() != null) && (!other.getJobFlowId().equals(getJobFlowId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceGroups() == null ? 0 : getInstanceGroups().hashCode());
    hashCode = 31 * hashCode + (getJobFlowId() == null ? 0 : getJobFlowId().hashCode());
    return hashCode;
  }
  
  public AddInstanceGroupsRequest clone()
  {
    return (AddInstanceGroupsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */