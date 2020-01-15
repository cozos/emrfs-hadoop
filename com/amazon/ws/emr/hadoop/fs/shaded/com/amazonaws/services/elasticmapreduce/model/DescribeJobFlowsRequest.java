package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DescribeJobFlowsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Date createdAfter;
  private Date createdBefore;
  private SdkInternalList<String> jobFlowIds;
  private SdkInternalList<String> jobFlowStates;
  
  public DescribeJobFlowsRequest() {}
  
  public DescribeJobFlowsRequest(List<String> jobFlowIds)
  {
    setJobFlowIds(jobFlowIds);
  }
  
  public void setCreatedAfter(Date createdAfter)
  {
    this.createdAfter = createdAfter;
  }
  
  public Date getCreatedAfter()
  {
    return createdAfter;
  }
  
  public DescribeJobFlowsRequest withCreatedAfter(Date createdAfter)
  {
    setCreatedAfter(createdAfter);
    return this;
  }
  
  public void setCreatedBefore(Date createdBefore)
  {
    this.createdBefore = createdBefore;
  }
  
  public Date getCreatedBefore()
  {
    return createdBefore;
  }
  
  public DescribeJobFlowsRequest withCreatedBefore(Date createdBefore)
  {
    setCreatedBefore(createdBefore);
    return this;
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
  
  public DescribeJobFlowsRequest withJobFlowIds(String... jobFlowIds)
  {
    if (this.jobFlowIds == null) {
      setJobFlowIds(new SdkInternalList(jobFlowIds.length));
    }
    for (String ele : jobFlowIds) {
      this.jobFlowIds.add(ele);
    }
    return this;
  }
  
  public DescribeJobFlowsRequest withJobFlowIds(Collection<String> jobFlowIds)
  {
    setJobFlowIds(jobFlowIds);
    return this;
  }
  
  public List<String> getJobFlowStates()
  {
    if (jobFlowStates == null) {
      jobFlowStates = new SdkInternalList();
    }
    return jobFlowStates;
  }
  
  public void setJobFlowStates(Collection<String> jobFlowStates)
  {
    if (jobFlowStates == null)
    {
      this.jobFlowStates = null;
      return;
    }
    this.jobFlowStates = new SdkInternalList(jobFlowStates);
  }
  
  public DescribeJobFlowsRequest withJobFlowStates(String... jobFlowStates)
  {
    if (this.jobFlowStates == null) {
      setJobFlowStates(new SdkInternalList(jobFlowStates.length));
    }
    for (String ele : jobFlowStates) {
      this.jobFlowStates.add(ele);
    }
    return this;
  }
  
  public DescribeJobFlowsRequest withJobFlowStates(Collection<String> jobFlowStates)
  {
    setJobFlowStates(jobFlowStates);
    return this;
  }
  
  public DescribeJobFlowsRequest withJobFlowStates(JobFlowExecutionState... jobFlowStates)
  {
    SdkInternalList<String> jobFlowStatesCopy = new SdkInternalList(jobFlowStates.length);
    for (JobFlowExecutionState value : jobFlowStates) {
      jobFlowStatesCopy.add(value.toString());
    }
    if (getJobFlowStates() == null) {
      setJobFlowStates(jobFlowStatesCopy);
    } else {
      getJobFlowStates().addAll(jobFlowStatesCopy);
    }
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCreatedAfter() != null) {
      sb.append("CreatedAfter: ").append(getCreatedAfter()).append(",");
    }
    if (getCreatedBefore() != null) {
      sb.append("CreatedBefore: ").append(getCreatedBefore()).append(",");
    }
    if (getJobFlowIds() != null) {
      sb.append("JobFlowIds: ").append(getJobFlowIds()).append(",");
    }
    if (getJobFlowStates() != null) {
      sb.append("JobFlowStates: ").append(getJobFlowStates());
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
    if (!(obj instanceof DescribeJobFlowsRequest)) {
      return false;
    }
    DescribeJobFlowsRequest other = (DescribeJobFlowsRequest)obj;
    if (((other.getCreatedAfter() == null ? 1 : 0) ^ (getCreatedAfter() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreatedAfter() != null) && (!other.getCreatedAfter().equals(getCreatedAfter()))) {
      return false;
    }
    if (((other.getCreatedBefore() == null ? 1 : 0) ^ (getCreatedBefore() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreatedBefore() != null) && (!other.getCreatedBefore().equals(getCreatedBefore()))) {
      return false;
    }
    if (((other.getJobFlowIds() == null ? 1 : 0) ^ (getJobFlowIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowIds() != null) && (!other.getJobFlowIds().equals(getJobFlowIds()))) {
      return false;
    }
    if (((other.getJobFlowStates() == null ? 1 : 0) ^ (getJobFlowStates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowStates() != null) && (!other.getJobFlowStates().equals(getJobFlowStates()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCreatedAfter() == null ? 0 : getCreatedAfter().hashCode());
    hashCode = 31 * hashCode + (getCreatedBefore() == null ? 0 : getCreatedBefore().hashCode());
    hashCode = 31 * hashCode + (getJobFlowIds() == null ? 0 : getJobFlowIds().hashCode());
    hashCode = 31 * hashCode + (getJobFlowStates() == null ? 0 : getJobFlowStates().hashCode());
    return hashCode;
  }
  
  public DescribeJobFlowsRequest clone()
  {
    return (DescribeJobFlowsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */