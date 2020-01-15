package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListStepsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<StepSummary> steps;
  private String marker;
  
  public List<StepSummary> getSteps()
  {
    if (steps == null) {
      steps = new SdkInternalList();
    }
    return steps;
  }
  
  public void setSteps(Collection<StepSummary> steps)
  {
    if (steps == null)
    {
      this.steps = null;
      return;
    }
    this.steps = new SdkInternalList(steps);
  }
  
  public ListStepsResult withSteps(StepSummary... steps)
  {
    if (this.steps == null) {
      setSteps(new SdkInternalList(steps.length));
    }
    for (StepSummary ele : steps) {
      this.steps.add(ele);
    }
    return this;
  }
  
  public ListStepsResult withSteps(Collection<StepSummary> steps)
  {
    setSteps(steps);
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
  
  public ListStepsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSteps() != null) {
      sb.append("Steps: ").append(getSteps()).append(",");
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
    if (!(obj instanceof ListStepsResult)) {
      return false;
    }
    ListStepsResult other = (ListStepsResult)obj;
    if (((other.getSteps() == null ? 1 : 0) ^ (getSteps() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSteps() != null) && (!other.getSteps().equals(getSteps()))) {
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
    
    hashCode = 31 * hashCode + (getSteps() == null ? 0 : getSteps().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListStepsResult clone()
  {
    try
    {
      return (ListStepsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */