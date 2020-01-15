package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeStepRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private String stepId;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public DescribeStepRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
  public void setStepId(String stepId)
  {
    this.stepId = stepId;
  }
  
  public String getStepId()
  {
    return stepId;
  }
  
  public DescribeStepRequest withStepId(String stepId)
  {
    setStepId(stepId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
    if (getStepId() != null) {
      sb.append("StepId: ").append(getStepId());
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
    if (!(obj instanceof DescribeStepRequest)) {
      return false;
    }
    DescribeStepRequest other = (DescribeStepRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getStepId() == null ? 1 : 0) ^ (getStepId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStepId() != null) && (!other.getStepId().equals(getStepId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getStepId() == null ? 0 : getStepId().hashCode());
    return hashCode;
  }
  
  public DescribeStepRequest clone()
  {
    return (DescribeStepRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */