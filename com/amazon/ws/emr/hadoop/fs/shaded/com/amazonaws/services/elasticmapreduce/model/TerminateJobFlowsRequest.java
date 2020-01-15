package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class TerminateJobFlowsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> jobFlowIds;
  
  public TerminateJobFlowsRequest() {}
  
  public TerminateJobFlowsRequest(List<String> jobFlowIds)
  {
    setJobFlowIds(jobFlowIds);
  }
  
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
  
  public TerminateJobFlowsRequest withJobFlowIds(String... jobFlowIds)
  {
    if (this.jobFlowIds == null) {
      setJobFlowIds(new SdkInternalList(jobFlowIds.length));
    }
    for (String ele : jobFlowIds) {
      this.jobFlowIds.add(ele);
    }
    return this;
  }
  
  public TerminateJobFlowsRequest withJobFlowIds(Collection<String> jobFlowIds)
  {
    setJobFlowIds(jobFlowIds);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlowIds() != null) {
      sb.append("JobFlowIds: ").append(getJobFlowIds());
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
    if (!(obj instanceof TerminateJobFlowsRequest)) {
      return false;
    }
    TerminateJobFlowsRequest other = (TerminateJobFlowsRequest)obj;
    if (((other.getJobFlowIds() == null ? 1 : 0) ^ (getJobFlowIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowIds() != null) && (!other.getJobFlowIds().equals(getJobFlowIds()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlowIds() == null ? 0 : getJobFlowIds().hashCode());
    return hashCode;
  }
  
  public TerminateJobFlowsRequest clone()
  {
    return (TerminateJobFlowsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */