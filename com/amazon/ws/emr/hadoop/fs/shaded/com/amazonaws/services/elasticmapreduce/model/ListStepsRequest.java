package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListStepsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private SdkInternalList<String> stepStates;
  private SdkInternalList<String> stepIds;
  private String marker;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public ListStepsRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
  public List<String> getStepStates()
  {
    if (stepStates == null) {
      stepStates = new SdkInternalList();
    }
    return stepStates;
  }
  
  public void setStepStates(Collection<String> stepStates)
  {
    if (stepStates == null)
    {
      this.stepStates = null;
      return;
    }
    this.stepStates = new SdkInternalList(stepStates);
  }
  
  public ListStepsRequest withStepStates(String... stepStates)
  {
    if (this.stepStates == null) {
      setStepStates(new SdkInternalList(stepStates.length));
    }
    for (String ele : stepStates) {
      this.stepStates.add(ele);
    }
    return this;
  }
  
  public ListStepsRequest withStepStates(Collection<String> stepStates)
  {
    setStepStates(stepStates);
    return this;
  }
  
  public ListStepsRequest withStepStates(StepState... stepStates)
  {
    SdkInternalList<String> stepStatesCopy = new SdkInternalList(stepStates.length);
    for (StepState value : stepStates) {
      stepStatesCopy.add(value.toString());
    }
    if (getStepStates() == null) {
      setStepStates(stepStatesCopy);
    } else {
      getStepStates().addAll(stepStatesCopy);
    }
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
  
  public ListStepsRequest withStepIds(String... stepIds)
  {
    if (this.stepIds == null) {
      setStepIds(new SdkInternalList(stepIds.length));
    }
    for (String ele : stepIds) {
      this.stepIds.add(ele);
    }
    return this;
  }
  
  public ListStepsRequest withStepIds(Collection<String> stepIds)
  {
    setStepIds(stepIds);
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListStepsRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
    if (getStepStates() != null) {
      sb.append("StepStates: ").append(getStepStates()).append(",");
    }
    if (getStepIds() != null) {
      sb.append("StepIds: ").append(getStepIds()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof ListStepsRequest)) {
      return false;
    }
    ListStepsRequest other = (ListStepsRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getStepStates() == null ? 1 : 0) ^ (getStepStates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStepStates() != null) && (!other.getStepStates().equals(getStepStates()))) {
      return false;
    }
    if (((other.getStepIds() == null ? 1 : 0) ^ (getStepIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStepIds() != null) && (!other.getStepIds().equals(getStepIds()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getStepStates() == null ? 0 : getStepStates().hashCode());
    hashCode = 31 * hashCode + (getStepIds() == null ? 0 : getStepIds().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListStepsRequest clone()
  {
    return (ListStepsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */