package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class SetVisibleToAllUsersRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> jobFlowIds;
  private Boolean visibleToAllUsers;
  
  public List<String> getJobFlowIds()
  {
    if (jobFlowIds == null) {
      jobFlowIds = new SdkInternalList();
    }
    return jobFlowIds;
  }
  
  public void setJobFlowIds(Collection<String> jobFlowIds)
  {
    if (jobFlowIds == null)
    {
      this.jobFlowIds = null;
      return;
    }
    this.jobFlowIds = new SdkInternalList(jobFlowIds);
  }
  
  public SetVisibleToAllUsersRequest withJobFlowIds(String... jobFlowIds)
  {
    if (this.jobFlowIds == null) {
      setJobFlowIds(new SdkInternalList(jobFlowIds.length));
    }
    for (String ele : jobFlowIds) {
      this.jobFlowIds.add(ele);
    }
    return this;
  }
  
  public SetVisibleToAllUsersRequest withJobFlowIds(Collection<String> jobFlowIds)
  {
    setJobFlowIds(jobFlowIds);
    return this;
  }
  
  public void setVisibleToAllUsers(Boolean visibleToAllUsers)
  {
    this.visibleToAllUsers = visibleToAllUsers;
  }
  
  public Boolean getVisibleToAllUsers()
  {
    return visibleToAllUsers;
  }
  
  public SetVisibleToAllUsersRequest withVisibleToAllUsers(Boolean visibleToAllUsers)
  {
    setVisibleToAllUsers(visibleToAllUsers);
    return this;
  }
  
  public Boolean isVisibleToAllUsers()
  {
    return visibleToAllUsers;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlowIds() != null) {
      sb.append("JobFlowIds: ").append(getJobFlowIds()).append(",");
    }
    if (getVisibleToAllUsers() != null) {
      sb.append("VisibleToAllUsers: ").append(getVisibleToAllUsers());
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
    if (!(obj instanceof SetVisibleToAllUsersRequest)) {
      return false;
    }
    SetVisibleToAllUsersRequest other = (SetVisibleToAllUsersRequest)obj;
    if (((other.getJobFlowIds() == null ? 1 : 0) ^ (getJobFlowIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowIds() != null) && (!other.getJobFlowIds().equals(getJobFlowIds()))) {
      return false;
    }
    if (((other.getVisibleToAllUsers() == null ? 1 : 0) ^ (getVisibleToAllUsers() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVisibleToAllUsers() != null) && (!other.getVisibleToAllUsers().equals(getVisibleToAllUsers()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlowIds() == null ? 0 : getJobFlowIds().hashCode());
    hashCode = 31 * hashCode + (getVisibleToAllUsers() == null ? 0 : getVisibleToAllUsers().hashCode());
    return hashCode;
  }
  
  public SetVisibleToAllUsersRequest clone()
  {
    return (SetVisibleToAllUsersRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */