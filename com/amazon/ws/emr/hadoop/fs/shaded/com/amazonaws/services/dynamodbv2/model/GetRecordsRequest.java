package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetRecordsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String shardIterator;
  private Integer limit;
  
  public void setShardIterator(String shardIterator)
  {
    this.shardIterator = shardIterator;
  }
  
  public String getShardIterator()
  {
    return shardIterator;
  }
  
  public GetRecordsRequest withShardIterator(String shardIterator)
  {
    setShardIterator(shardIterator);
    return this;
  }
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public GetRecordsRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getShardIterator() != null) {
      sb.append("ShardIterator: ").append(getShardIterator()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit());
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
    if (!(obj instanceof GetRecordsRequest)) {
      return false;
    }
    GetRecordsRequest other = (GetRecordsRequest)obj;
    if (((other.getShardIterator() == null ? 1 : 0) ^ (getShardIterator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShardIterator() != null) && (!other.getShardIterator().equals(getShardIterator()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getShardIterator() == null ? 0 : getShardIterator().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    return hashCode;
  }
  
  public GetRecordsRequest clone()
  {
    return (GetRecordsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */