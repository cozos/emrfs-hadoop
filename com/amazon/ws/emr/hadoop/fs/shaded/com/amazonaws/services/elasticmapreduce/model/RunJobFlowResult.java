package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class RunJobFlowResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String jobFlowId;
  
  public void setJobFlowId(String jobFlowId)
  {
    this.jobFlowId = jobFlowId;
  }
  
  public String getJobFlowId()
  {
    return jobFlowId;
  }
  
  public RunJobFlowResult withJobFlowId(String jobFlowId)
  {
    setJobFlowId(jobFlowId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof RunJobFlowResult)) {
      return false;
    }
    RunJobFlowResult other = (RunJobFlowResult)obj;
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
    
    hashCode = 31 * hashCode + (getJobFlowId() == null ? 0 : getJobFlowId().hashCode());
    return hashCode;
  }
  
  public RunJobFlowResult clone()
  {
    try
    {
      return (RunJobFlowResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */