package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeStepResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Step step;
  
  public void setStep(Step step)
  {
    this.step = step;
  }
  
  public Step getStep()
  {
    return step;
  }
  
  public DescribeStepResult withStep(Step step)
  {
    setStep(step);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStep() != null) {
      sb.append("Step: ").append(getStep());
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
    if (!(obj instanceof DescribeStepResult)) {
      return false;
    }
    DescribeStepResult other = (DescribeStepResult)obj;
    if (((other.getStep() == null ? 1 : 0) ^ (getStep() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStep() != null) && (!other.getStep().equals(getStep()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStep() == null ? 0 : getStep().hashCode());
    return hashCode;
  }
  
  public DescribeStepResult clone()
  {
    try
    {
      return (DescribeStepResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */