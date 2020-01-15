package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AddJobFlowStepsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String jobFlowId;
  private SdkInternalList<StepConfig> steps;
  
  public AddJobFlowStepsRequest() {}
  
  public AddJobFlowStepsRequest(String jobFlowId)
  {
    setJobFlowId(jobFlowId);
  }
  
  public AddJobFlowStepsRequest(String jobFlowId, List<StepConfig> steps)
  {
    setJobFlowId(jobFlowId);
    setSteps(steps);
  }
  
  public void setJobFlowId(String jobFlowId)
  {
    this.jobFlowId = jobFlowId;
  }
  
  public String getJobFlowId()
  {
    return jobFlowId;
  }
  
  public AddJobFlowStepsRequest withJobFlowId(String jobFlowId)
  {
    setJobFlowId(jobFlowId);
    return this;
  }
  
  public List<StepConfig> getSteps()
  {
    if (steps == null) {
      steps = new SdkInternalList();
    }
    return steps;
  }
  
  public void setSteps(Collection<StepConfig> steps)
  {
    if (steps == null)
    {
      this.steps = null;
      return;
    }
    this.steps = new SdkInternalList(steps);
  }
  
  public AddJobFlowStepsRequest withSteps(StepConfig... steps)
  {
    if (this.steps == null) {
      setSteps(new SdkInternalList(steps.length));
    }
    for (StepConfig ele : steps) {
      this.steps.add(ele);
    }
    return this;
  }
  
  public AddJobFlowStepsRequest withSteps(Collection<StepConfig> steps)
  {
    setSteps(steps);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlowId() != null) {
      sb.append("JobFlowId: ").append(getJobFlowId()).append(",");
    }
    if (getSteps() != null) {
      sb.append("Steps: ").append(getSteps());
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
    if (!(obj instanceof AddJobFlowStepsRequest)) {
      return false;
    }
    AddJobFlowStepsRequest other = (AddJobFlowStepsRequest)obj;
    if (((other.getJobFlowId() == null ? 1 : 0) ^ (getJobFlowId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowId() != null) && (!other.getJobFlowId().equals(getJobFlowId()))) {
      return false;
    }
    if (((other.getSteps() == null ? 1 : 0) ^ (getSteps() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSteps() != null) && (!other.getSteps().equals(getSteps()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlowId() == null ? 0 : getJobFlowId().hashCode());
    hashCode = 31 * hashCode + (getSteps() == null ? 0 : getSteps().hashCode());
    return hashCode;
  }
  
  public AddJobFlowStepsRequest clone()
  {
    return (AddJobFlowStepsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */