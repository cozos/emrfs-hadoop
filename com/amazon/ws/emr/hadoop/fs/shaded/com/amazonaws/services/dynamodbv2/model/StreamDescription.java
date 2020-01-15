package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class StreamDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String streamArn;
  private String streamLabel;
  private String streamStatus;
  private String streamViewType;
  private Date creationRequestDateTime;
  private String tableName;
  private List<KeySchemaElement> keySchema;
  private List<Shard> shards;
  private String lastEvaluatedShardId;
  
  public void setStreamArn(String streamArn)
  {
    this.streamArn = streamArn;
  }
  
  public String getStreamArn()
  {
    return streamArn;
  }
  
  public StreamDescription withStreamArn(String streamArn)
  {
    setStreamArn(streamArn);
    return this;
  }
  
  public void setStreamLabel(String streamLabel)
  {
    this.streamLabel = streamLabel;
  }
  
  public String getStreamLabel()
  {
    return streamLabel;
  }
  
  public StreamDescription withStreamLabel(String streamLabel)
  {
    setStreamLabel(streamLabel);
    return this;
  }
  
  public void setStreamStatus(String streamStatus)
  {
    this.streamStatus = streamStatus;
  }
  
  public String getStreamStatus()
  {
    return streamStatus;
  }
  
  public StreamDescription withStreamStatus(String streamStatus)
  {
    setStreamStatus(streamStatus);
    return this;
  }
  
  public void setStreamStatus(StreamStatus streamStatus)
  {
    withStreamStatus(streamStatus);
  }
  
  public StreamDescription withStreamStatus(StreamStatus streamStatus)
  {
    this.streamStatus = streamStatus.toString();
    return this;
  }
  
  public void setStreamViewType(String streamViewType)
  {
    this.streamViewType = streamViewType;
  }
  
  public String getStreamViewType()
  {
    return streamViewType;
  }
  
  public StreamDescription withStreamViewType(String streamViewType)
  {
    setStreamViewType(streamViewType);
    return this;
  }
  
  public void setStreamViewType(StreamViewType streamViewType)
  {
    withStreamViewType(streamViewType);
  }
  
  public StreamDescription withStreamViewType(StreamViewType streamViewType)
  {
    this.streamViewType = streamViewType.toString();
    return this;
  }
  
  public void setCreationRequestDateTime(Date creationRequestDateTime)
  {
    this.creationRequestDateTime = creationRequestDateTime;
  }
  
  public Date getCreationRequestDateTime()
  {
    return creationRequestDateTime;
  }
  
  public StreamDescription withCreationRequestDateTime(Date creationRequestDateTime)
  {
    setCreationRequestDateTime(creationRequestDateTime);
    return this;
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public StreamDescription withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public List<KeySchemaElement> getKeySchema()
  {
    return keySchema;
  }
  
  public void setKeySchema(Collection<KeySchemaElement> keySchema)
  {
    if (keySchema == null)
    {
      this.keySchema = null;
      return;
    }
    this.keySchema = new ArrayList(keySchema);
  }
  
  public StreamDescription withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public StreamDescription withKeySchema(Collection<KeySchemaElement> keySchema)
  {
    setKeySchema(keySchema);
    return this;
  }
  
  public List<Shard> getShards()
  {
    return shards;
  }
  
  public void setShards(Collection<Shard> shards)
  {
    if (shards == null)
    {
      this.shards = null;
      return;
    }
    this.shards = new ArrayList(shards);
  }
  
  public StreamDescription withShards(Shard... shards)
  {
    if (this.shards == null) {
      setShards(new ArrayList(shards.length));
    }
    for (Shard ele : shards) {
      this.shards.add(ele);
    }
    return this;
  }
  
  public StreamDescription withShards(Collection<Shard> shards)
  {
    setShards(shards);
    return this;
  }
  
  public void setLastEvaluatedShardId(String lastEvaluatedShardId)
  {
    this.lastEvaluatedShardId = lastEvaluatedShardId;
  }
  
  public String getLastEvaluatedShardId()
  {
    return lastEvaluatedShardId;
  }
  
  public StreamDescription withLastEvaluatedShardId(String lastEvaluatedShardId)
  {
    setLastEvaluatedShardId(lastEvaluatedShardId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreamArn() != null) {
      sb.append("StreamArn: ").append(getStreamArn()).append(",");
    }
    if (getStreamLabel() != null) {
      sb.append("StreamLabel: ").append(getStreamLabel()).append(",");
    }
    if (getStreamStatus() != null) {
      sb.append("StreamStatus: ").append(getStreamStatus()).append(",");
    }
    if (getStreamViewType() != null) {
      sb.append("StreamViewType: ").append(getStreamViewType()).append(",");
    }
    if (getCreationRequestDateTime() != null) {
      sb.append("CreationRequestDateTime: ").append(getCreationRequestDateTime()).append(",");
    }
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getKeySchema() != null) {
      sb.append("KeySchema: ").append(getKeySchema()).append(",");
    }
    if (getShards() != null) {
      sb.append("Shards: ").append(getShards()).append(",");
    }
    if (getLastEvaluatedShardId() != null) {
      sb.append("LastEvaluatedShardId: ").append(getLastEvaluatedShardId());
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
    if (!(obj instanceof StreamDescription)) {
      return false;
    }
    StreamDescription other = (StreamDescription)obj;
    if (((other.getStreamArn() == null ? 1 : 0) ^ (getStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamArn() != null) && (!other.getStreamArn().equals(getStreamArn()))) {
      return false;
    }
    if (((other.getStreamLabel() == null ? 1 : 0) ^ (getStreamLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamLabel() != null) && (!other.getStreamLabel().equals(getStreamLabel()))) {
      return false;
    }
    if (((other.getStreamStatus() == null ? 1 : 0) ^ (getStreamStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamStatus() != null) && (!other.getStreamStatus().equals(getStreamStatus()))) {
      return false;
    }
    if (((other.getStreamViewType() == null ? 1 : 0) ^ (getStreamViewType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamViewType() != null) && (!other.getStreamViewType().equals(getStreamViewType()))) {
      return false;
    }
    if (((other.getCreationRequestDateTime() == null ? 1 : 0) ^ (getCreationRequestDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationRequestDateTime() != null) && (!other.getCreationRequestDateTime().equals(getCreationRequestDateTime()))) {
      return false;
    }
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getKeySchema() == null ? 1 : 0) ^ (getKeySchema() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeySchema() != null) && (!other.getKeySchema().equals(getKeySchema()))) {
      return false;
    }
    if (((other.getShards() == null ? 1 : 0) ^ (getShards() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShards() != null) && (!other.getShards().equals(getShards()))) {
      return false;
    }
    if (((other.getLastEvaluatedShardId() == null ? 1 : 0) ^ (getLastEvaluatedShardId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastEvaluatedShardId() != null) && (!other.getLastEvaluatedShardId().equals(getLastEvaluatedShardId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreamArn() == null ? 0 : getStreamArn().hashCode());
    hashCode = 31 * hashCode + (getStreamLabel() == null ? 0 : getStreamLabel().hashCode());
    hashCode = 31 * hashCode + (getStreamStatus() == null ? 0 : getStreamStatus().hashCode());
    hashCode = 31 * hashCode + (getStreamViewType() == null ? 0 : getStreamViewType().hashCode());
    hashCode = 31 * hashCode + (getCreationRequestDateTime() == null ? 0 : getCreationRequestDateTime().hashCode());
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getKeySchema() == null ? 0 : getKeySchema().hashCode());
    hashCode = 31 * hashCode + (getShards() == null ? 0 : getShards().hashCode());
    hashCode = 31 * hashCode + (getLastEvaluatedShardId() == null ? 0 : getLastEvaluatedShardId().hashCode());
    return hashCode;
  }
  
  public StreamDescription clone()
  {
    try
    {
      return (StreamDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StreamDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */