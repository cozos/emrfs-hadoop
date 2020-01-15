package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AddJobFlowStepsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<String> stepIds;
  
  public List<String> getStepIds()
  {
    if (stepIds == null) {
      stepIds = new SdkInternalList();
    }
    return stepIds;
  }
  
  public void setStepIds(Collection<String> stepIds)
  {
    if (stepIds == null)
    {
      this.stepIds = null;
      return;
    }
    this.stepIds = new SdkInternalList(stepIds);
  }
  
  public AddJobFlowStepsResult withStepIds(String... stepIds)
  {
    if (this.stepIds == null) {
      setStepIds(new SdkInternalList(stepIds.length));
    }
    for (String ele : stepIds) {
      this.stepIds.add(ele);
    }
    return this;
  }
  
  public AddJobFlowStepsResult withStepIds(Collection<String> stepIds)
  {
    setStepIds(stepIds);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStepIds() != null) {
      sb.append("StepIds: ").append(getStepIds());
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
    if (!(obj instanceof AddJobFlowStepsResult)) {
      return false;
    }
    AddJobFlowStepsResult other = (AddJobFlowStepsResult)obj;
    if (((other.getStepIds() == null ? 1 : 0) ^ (getStepIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStepIds() != null) && (!other.getStepIds().equals(getStepIds()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStepIds() == null ? 0 : getStepIds().hashCode());
    return hashCode;
  }
  
  public AddJobFlowStepsResult clone()
  {
    try
    {
      return (AddJobFlowStepsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */