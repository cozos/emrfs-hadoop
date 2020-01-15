package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeTimeToLiveResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private TimeToLiveDescription timeToLiveDescription;
  
  public void setTimeToLiveDescription(TimeToLiveDescription timeToLiveDescription)
  {
    this.timeToLiveDescription = timeToLiveDescription;
  }
  
  public TimeToLiveDescription getTimeToLiveDescription()
  {
    return timeToLiveDescription;
  }
  
  public DescribeTimeToLiveResult withTimeToLiveDescription(TimeToLiveDescription timeToLiveDescription)
  {
    setTimeToLiveDescription(timeToLiveDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTimeToLiveDescription() != null) {
      sb.append("TimeToLiveDescription: ").append(getTimeToLiveDescription());
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
    if (!(obj instanceof DescribeTimeToLiveResult)) {
      return false;
    }
    DescribeTimeToLiveResult other = (DescribeTimeToLiveResult)obj;
    if (((other.getTimeToLiveDescription() == null ? 1 : 0) ^ (getTimeToLiveDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeToLiveDescription() != null) && (!other.getTimeToLiveDescription().equals(getTimeToLiveDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTimeToLiveDescription() == null ? 0 : getTimeToLiveDescription().hashCode());
    return hashCode;
  }
  
  public DescribeTimeToLiveResult clone()
  {
    try
    {
      return (DescribeTimeToLiveResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */