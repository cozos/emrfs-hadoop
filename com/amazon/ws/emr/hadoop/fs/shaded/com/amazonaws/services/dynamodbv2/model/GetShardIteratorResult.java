package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetShardIteratorResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String shardIterator;
  
  public void setShardIterator(String shardIterator)
  {
    this.shardIterator = shardIterator;
  }
  
  public String getShardIterator()
  {
    return shardIterator;
  }
  
  public GetShardIteratorResult withShardIterator(String shardIterator)
  {
    setShardIterator(shardIterator);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getShardIterator() != null) {
      sb.append("ShardIterator: ").append(getShardIterator());
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
    if (!(obj instanceof GetShardIteratorResult)) {
      return false;
    }
    GetShardIteratorResult other = (GetShardIteratorResult)obj;
    if (((other.getShardIterator() == null ? 1 : 0) ^ (getShardIterator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShardIterator() != null) && (!other.getShardIterator().equals(getShardIterator()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getShardIterator() == null ? 0 : getShardIterator().hashCode());
    return hashCode;
  }
  
  public GetShardIteratorResult clone()
  {
    try
    {
      return (GetShardIteratorResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */