package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeStreamRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String streamArn;
  private Integer limit;
  private String exclusiveStartShardId;
  
  public void setStreamArn(String streamArn)
  {
    this.streamArn = streamArn;
  }
  
  public String getStreamArn()
  {
    return streamArn;
  }
  
  public DescribeStreamRequest withStreamArn(String streamArn)
  {
    setStreamArn(streamArn);
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
  
  public DescribeStreamRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public void setExclusiveStartShardId(String exclusiveStartShardId)
  {
    this.exclusiveStartShardId = exclusiveStartShardId;
  }
  
  public String getExclusiveStartShardId()
  {
    return exclusiveStartShardId;
  }
  
  public DescribeStreamRequest withExclusiveStartShardId(String exclusiveStartShardId)
  {
    setExclusiveStartShardId(exclusiveStartShardId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreamArn() != null) {
      sb.append("StreamArn: ").append(getStreamArn()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
    }
    if (getExclusiveStartShardId() != null) {
      sb.append("ExclusiveStartShardId: ").append(getExclusiveStartShardId());
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
    if (!(obj instanceof DescribeStreamRequest)) {
      return false;
    }
    DescribeStreamRequest other = (DescribeStreamRequest)obj;
    if (((other.getStreamArn() == null ? 1 : 0) ^ (getStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamArn() != null) && (!other.getStreamArn().equals(getStreamArn()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    if (((other.getExclusiveStartShardId() == null ? 1 : 0) ^ (getExclusiveStartShardId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExclusiveStartShardId() != null) && (!other.getExclusiveStartShardId().equals(getExclusiveStartShardId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreamArn() == null ? 0 : getStreamArn().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getExclusiveStartShardId() == null ? 0 : getExclusiveStartShardId().hashCode());
    return hashCode;
  }
  
  public DescribeStreamRequest clone()
  {
    return (DescribeStreamRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */