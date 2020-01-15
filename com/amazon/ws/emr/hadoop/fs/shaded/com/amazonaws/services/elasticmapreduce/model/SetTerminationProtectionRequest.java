package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class SetTerminationProtectionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> jobFlowIds;
  private Boolean terminationProtected;
  
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
  
  public SetTerminationProtectionRequest withJobFlowIds(String... jobFlowIds)
  {
    if (this.jobFlowIds == null) {
      setJobFlowIds(new SdkInternalList(jobFlowIds.length));
    }
    for (String ele : jobFlowIds) {
      this.jobFlowIds.add(ele);
    }
    return this;
  }
  
  public SetTerminationProtectionRequest withJobFlowIds(Collection<String> jobFlowIds)
  {
    setJobFlowIds(jobFlowIds);
    return this;
  }
  
  public void setTerminationProtected(Boolean terminationProtected)
  {
    this.terminationProtected = terminationProtected;
  }
  
  public Boolean getTerminationProtected()
  {
    return terminationProtected;
  }
  
  public SetTerminationProtectionRequest withTerminationProtected(Boolean terminationProtected)
  {
    setTerminationProtected(terminationProtected);
    return this;
  }
  
  public Boolean isTerminationProtected()
  {
    return terminationProtected;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlowIds() != null) {
      sb.append("JobFlowIds: ").append(getJobFlowIds()).append(",");
    }
    if (getTerminationProtected() != null) {
      sb.append("TerminationProtected: ").append(getTerminationProtected());
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
    if (!(obj instanceof SetTerminationProtectionRequest)) {
      return false;
    }
    SetTerminationProtectionRequest other = (SetTerminationProtectionRequest)obj;
    if (((other.getJobFlowIds() == null ? 1 : 0) ^ (getJobFlowIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowIds() != null) && (!other.getJobFlowIds().equals(getJobFlowIds()))) {
      return false;
    }
    if (((other.getTerminationProtected() == null ? 1 : 0) ^ (getTerminationProtected() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTerminationProtected() != null) && (!other.getTerminationProtected().equals(getTerminationProtected()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlowIds() == null ? 0 : getJobFlowIds().hashCode());
    hashCode = 31 * hashCode + (getTerminationProtected() == null ? 0 : getTerminationProtected().hashCode());
    return hashCode;
  }
  
  public SetTerminationProtectionRequest clone()
  {
    return (SetTerminationProtectionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */