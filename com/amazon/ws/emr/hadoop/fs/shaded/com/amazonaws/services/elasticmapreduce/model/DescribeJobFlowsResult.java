package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeJobFlowsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<JobFlowDetail> jobFlows;
  
  public List<JobFlowDetail> getJobFlows()
  {
    if (jobFlows == null) {
      jobFlows = new SdkInternalList();
    }
    return jobFlows;
  }
  
  public void setJobFlows(Collection<JobFlowDetail> jobFlows)
  {
    if (jobFlows == null)
    {
      this.jobFlows = null;
      return;
    }
    this.jobFlows = new SdkInternalList(jobFlows);
  }
  
  public DescribeJobFlowsResult withJobFlows(JobFlowDetail... jobFlows)
  {
    if (this.jobFlows == null) {
      setJobFlows(new SdkInternalList(jobFlows.length));
    }
    for (JobFlowDetail ele : jobFlows) {
      this.jobFlows.add(ele);
    }
    return this;
  }
  
  public DescribeJobFlowsResult withJobFlows(Collection<JobFlowDetail> jobFlows)
  {
    setJobFlows(jobFlows);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlows() != null) {
      sb.append("JobFlows: ").append(getJobFlows());
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
    if (!(obj instanceof DescribeJobFlowsResult)) {
      return false;
    }
    DescribeJobFlowsResult other = (DescribeJobFlowsResult)obj;
    if (((other.getJobFlows() == null ? 1 : 0) ^ (getJobFlows() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlows() != null) && (!other.getJobFlows().equals(getJobFlows()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlows() == null ? 0 : getJobFlows().hashCode());
    return hashCode;
  }
  
  public DescribeJobFlowsResult clone()
  {
    try
    {
      return (DescribeJobFlowsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */