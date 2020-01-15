package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ShardMarshaller;
import java.io.Serializable;

public class Shard
  implements Serializable, Cloneable, StructuredPojo
{
  private String shardId;
  private SequenceNumberRange sequenceNumberRange;
  private String parentShardId;
  
  public void setShardId(String shardId)
  {
    this.shardId = shardId;
  }
  
  public String getShardId()
  {
    return shardId;
  }
  
  public Shard withShardId(String shardId)
  {
    setShardId(shardId);
    return this;
  }
  
  public void setSequenceNumberRange(SequenceNumberRange sequenceNumberRange)
  {
    this.sequenceNumberRange = sequenceNumberRange;
  }
  
  public SequenceNumberRange getSequenceNumberRange()
  {
    return sequenceNumberRange;
  }
  
  public Shard withSequenceNumberRange(SequenceNumberRange sequenceNumberRange)
  {
    setSequenceNumberRange(sequenceNumberRange);
    return this;
  }
  
  public void setParentShardId(String parentShardId)
  {
    this.parentShardId = parentShardId;
  }
  
  public String getParentShardId()
  {
    return parentShardId;
  }
  
  public Shard withParentShardId(String parentShardId)
  {
    setParentShardId(parentShardId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getShardId() != null) {
      sb.append("ShardId: ").append(getShardId()).append(",");
    }
    if (getSequenceNumberRange() != null) {
      sb.append("SequenceNumberRange: ").append(getSequenceNumberRange()).append(",");
    }
    if (getParentShardId() != null) {
      sb.append("ParentShardId: ").append(getParentShardId());
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
    if (!(obj instanceof Shard)) {
      return false;
    }
    Shard other = (Shard)obj;
    if (((other.getShardId() == null ? 1 : 0) ^ (getShardId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShardId() != null) && (!other.getShardId().equals(getShardId()))) {
      return false;
    }
    if (((other.getSequenceNumberRange() == null ? 1 : 0) ^ (getSequenceNumberRange() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSequenceNumberRange() != null) && (!other.getSequenceNumberRange().equals(getSequenceNumberRange()))) {
      return false;
    }
    if (((other.getParentShardId() == null ? 1 : 0) ^ (getParentShardId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getParentShardId() != null) && (!other.getParentShardId().equals(getParentShardId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getShardId() == null ? 0 : getShardId().hashCode());
    hashCode = 31 * hashCode + (getSequenceNumberRange() == null ? 0 : getSequenceNumberRange().hashCode());
    hashCode = 31 * hashCode + (getParentShardId() == null ? 0 : getParentShardId().hashCode());
    return hashCode;
  }
  
  public Shard clone()
  {
    try
    {
      return (Shard)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ShardMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Shard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */