package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetShardIteratorRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String streamArn;
  private String shardId;
  private String shardIteratorType;
  private String sequenceNumber;
  
  public void setStreamArn(String streamArn)
  {
    this.streamArn = streamArn;
  }
  
  public String getStreamArn()
  {
    return streamArn;
  }
  
  public GetShardIteratorRequest withStreamArn(String streamArn)
  {
    setStreamArn(streamArn);
    return this;
  }
  
  public void setShardId(String shardId)
  {
    this.shardId = shardId;
  }
  
  public String getShardId()
  {
    return shardId;
  }
  
  public GetShardIteratorRequest withShardId(String shardId)
  {
    setShardId(shardId);
    return this;
  }
  
  public void setShardIteratorType(String shardIteratorType)
  {
    this.shardIteratorType = shardIteratorType;
  }
  
  public String getShardIteratorType()
  {
    return shardIteratorType;
  }
  
  public GetShardIteratorRequest withShardIteratorType(String shardIteratorType)
  {
    setShardIteratorType(shardIteratorType);
    return this;
  }
  
  public void setShardIteratorType(ShardIteratorType shardIteratorType)
  {
    withShardIteratorType(shardIteratorType);
  }
  
  public GetShardIteratorRequest withShardIteratorType(ShardIteratorType shardIteratorType)
  {
    this.shardIteratorType = shardIteratorType.toString();
    return this;
  }
  
  public void setSequenceNumber(String sequenceNumber)
  {
    this.sequenceNumber = sequenceNumber;
  }
  
  public String getSequenceNumber()
  {
    return sequenceNumber;
  }
  
  public GetShardIteratorRequest withSequenceNumber(String sequenceNumber)
  {
    setSequenceNumber(sequenceNumber);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreamArn() != null) {
      sb.append("StreamArn: ").append(getStreamArn()).append(",");
    }
    if (getShardId() != null) {
      sb.append("ShardId: ").append(getShardId()).append(",");
    }
    if (getShardIteratorType() != null) {
      sb.append("ShardIteratorType: ").append(getShardIteratorType()).append(",");
    }
    if (getSequenceNumber() != null) {
      sb.append("SequenceNumber: ").append(getSequenceNumber());
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
    if (!(obj instanceof GetShardIteratorRequest)) {
      return false;
    }
    GetShardIteratorRequest other = (GetShardIteratorRequest)obj;
    if (((other.getStreamArn() == null ? 1 : 0) ^ (getStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamArn() != null) && (!other.getStreamArn().equals(getStreamArn()))) {
      return false;
    }
    if (((other.getShardId() == null ? 1 : 0) ^ (getShardId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShardId() != null) && (!other.getShardId().equals(getShardId()))) {
      return false;
    }
    if (((other.getShardIteratorType() == null ? 1 : 0) ^ (getShardIteratorType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShardIteratorType() != null) && (!other.getShardIteratorType().equals(getShardIteratorType()))) {
      return false;
    }
    if (((other.getSequenceNumber() == null ? 1 : 0) ^ (getSequenceNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSequenceNumber() != null) && (!other.getSequenceNumber().equals(getSequenceNumber()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreamArn() == null ? 0 : getStreamArn().hashCode());
    hashCode = 31 * hashCode + (getShardId() == null ? 0 : getShardId().hashCode());
    hashCode = 31 * hashCode + (getShardIteratorType() == null ? 0 : getShardIteratorType().hashCode());
    hashCode = 31 * hashCode + (getSequenceNumber() == null ? 0 : getSequenceNumber().hashCode());
    return hashCode;
  }
  
  public GetShardIteratorRequest clone()
  {
    return (GetShardIteratorRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */