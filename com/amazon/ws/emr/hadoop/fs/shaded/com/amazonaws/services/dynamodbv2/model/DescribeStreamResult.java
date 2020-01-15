package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeStreamResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private StreamDescription streamDescription;
  
  public void setStreamDescription(StreamDescription streamDescription)
  {
    this.streamDescription = streamDescription;
  }
  
  public StreamDescription getStreamDescription()
  {
    return streamDescription;
  }
  
  public DescribeStreamResult withStreamDescription(StreamDescription streamDescription)
  {
    setStreamDescription(streamDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreamDescription() != null) {
      sb.append("StreamDescription: ").append(getStreamDescription());
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
    if (!(obj instanceof DescribeStreamResult)) {
      return false;
    }
    DescribeStreamResult other = (DescribeStreamResult)obj;
    if (((other.getStreamDescription() == null ? 1 : 0) ^ (getStreamDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamDescription() != null) && (!other.getStreamDescription().equals(getStreamDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreamDescription() == null ? 0 : getStreamDescription().hashCode());
    return hashCode;
  }
  
  public DescribeStreamResult clone()
  {
    try
    {
      return (DescribeStreamResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */