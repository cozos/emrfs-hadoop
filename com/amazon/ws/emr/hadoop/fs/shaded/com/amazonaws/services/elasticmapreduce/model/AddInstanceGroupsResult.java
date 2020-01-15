package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AddInstanceGroupsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String jobFlowId;
  private SdkInternalList<String> instanceGroupIds;
  
  public void setJobFlowId(String jobFlowId)
  {
    this.jobFlowId = jobFlowId;
  }
  
  public String getJobFlowId()
  {
    return jobFlowId;
  }
  
  public AddInstanceGroupsResult withJobFlowId(String jobFlowId)
  {
    setJobFlowId(jobFlowId);
    return this;
  }
  
  public List<String> getInstanceGroupIds()
  {
    if (instanceGroupIds == null) {
      instanceGroupIds = new SdkInternalList();
    }
    return instanceGroupIds;
  }
  
  public void setInstanceGroupIds(Collection<String> instanceGroupIds)
  {
    if (instanceGroupIds == null)
    {
      this.instanceGroupIds = null;
      return;
    }
    this.instanceGroupIds = new SdkInternalList(instanceGroupIds);
  }
  
  public AddInstanceGroupsResult withInstanceGroupIds(String... instanceGroupIds)
  {
    if (this.instanceGroupIds == null) {
      setInstanceGroupIds(new SdkInternalList(instanceGroupIds.length));
    }
    for (String ele : instanceGroupIds) {
      this.instanceGroupIds.add(ele);
    }
    return this;
  }
  
  public AddInstanceGroupsResult withInstanceGroupIds(Collection<String> instanceGroupIds)
  {
    setInstanceGroupIds(instanceGroupIds);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlowId() != null) {
      sb.append("JobFlowId: ").append(getJobFlowId()).append(",");
    }
    if (getInstanceGroupIds() != null) {
      sb.append("InstanceGroupIds: ").append(getInstanceGroupIds());
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
    if (!(obj instanceof AddInstanceGroupsResult)) {
      return false;
    }
    AddInstanceGroupsResult other = (AddInstanceGroupsResult)obj;
    if (((other.getJobFlowId() == null ? 1 : 0) ^ (getJobFlowId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowId() != null) && (!other.getJobFlowId().equals(getJobFlowId()))) {
      return false;
    }
    if (((other.getInstanceGroupIds() == null ? 1 : 0) ^ (getInstanceGroupIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupIds() != null) && (!other.getInstanceGroupIds().equals(getInstanceGroupIds()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlowId() == null ? 0 : getJobFlowId().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroupIds() == null ? 0 : getInstanceGroupIds().hashCode());
    return hashCode;
  }
  
  public AddInstanceGroupsResult clone()
  {
    try
    {
      return (AddInstanceGroupsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */