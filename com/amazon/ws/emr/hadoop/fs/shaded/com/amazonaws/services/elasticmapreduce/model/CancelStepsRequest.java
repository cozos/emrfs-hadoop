package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CancelStepsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private SdkInternalList<String> stepIds;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public CancelStepsRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
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
  
  public CancelStepsRequest withStepIds(String... stepIds)
  {
    if (this.stepIds == null) {
      setStepIds(new SdkInternalList(stepIds.length));
    }
    for (String ele : stepIds) {
      this.stepIds.add(ele);
    }
    return this;
  }
  
  public CancelStepsRequest withStepIds(Collection<String> stepIds)
  {
    setStepIds(stepIds);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
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
    if (!(obj instanceof CancelStepsRequest)) {
      return false;
    }
    CancelStepsRequest other = (CancelStepsRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getStepIds() == null ? 0 : getStepIds().hashCode());
    return hashCode;
  }
  
  public CancelStepsRequest clone()
  {
    return (CancelStepsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */