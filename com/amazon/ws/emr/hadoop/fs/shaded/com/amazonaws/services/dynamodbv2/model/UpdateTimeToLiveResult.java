package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class UpdateTimeToLiveResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private TimeToLiveSpecification timeToLiveSpecification;
  
  public void setTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification)
  {
    this.timeToLiveSpecification = timeToLiveSpecification;
  }
  
  public TimeToLiveSpecification getTimeToLiveSpecification()
  {
    return timeToLiveSpecification;
  }
  
  public UpdateTimeToLiveResult withTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification)
  {
    setTimeToLiveSpecification(timeToLiveSpecification);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTimeToLiveSpecification() != null) {
      sb.append("TimeToLiveSpecification: ").append(getTimeToLiveSpecification());
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
    if (!(obj instanceof UpdateTimeToLiveResult)) {
      return false;
    }
    UpdateTimeToLiveResult other = (UpdateTimeToLiveResult)obj;
    if (((other.getTimeToLiveSpecification() == null ? 1 : 0) ^ (getTimeToLiveSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeToLiveSpecification() != null) && (!other.getTimeToLiveSpecification().equals(getTimeToLiveSpecification()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTimeToLiveSpecification() == null ? 0 : getTimeToLiveSpecification().hashCode());
    return hashCode;
  }
  
  public UpdateTimeToLiveResult clone()
  {
    try
    {
      return (UpdateTimeToLiveResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */