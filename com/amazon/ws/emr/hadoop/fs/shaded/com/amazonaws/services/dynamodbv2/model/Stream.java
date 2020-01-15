package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamMarshaller;
import java.io.Serializable;

public class Stream
  implements Serializable, Cloneable, StructuredPojo
{
  private String streamArn;
  private String tableName;
  private String streamLabel;
  
  public void setStreamArn(String streamArn)
  {
    this.streamArn = streamArn;
  }
  
  public String getStreamArn()
  {
    return streamArn;
  }
  
  public Stream withStreamArn(String streamArn)
  {
    setStreamArn(streamArn);
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
  
  public Stream withTableName(String tableName)
  {
    setTableName(tableName);
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
  
  public Stream withStreamLabel(String streamLabel)
  {
    setStreamLabel(streamLabel);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreamArn() != null) {
      sb.append("StreamArn: ").append(getStreamArn()).append(",");
    }
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getStreamLabel() != null) {
      sb.append("StreamLabel: ").append(getStreamLabel());
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
    if (!(obj instanceof Stream)) {
      return false;
    }
    Stream other = (Stream)obj;
    if (((other.getStreamArn() == null ? 1 : 0) ^ (getStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamArn() != null) && (!other.getStreamArn().equals(getStreamArn()))) {
      return false;
    }
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getStreamLabel() == null ? 1 : 0) ^ (getStreamLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamLabel() != null) && (!other.getStreamLabel().equals(getStreamLabel()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreamArn() == null ? 0 : getStreamArn().hashCode());
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getStreamLabel() == null ? 0 : getStreamLabel().hashCode());
    return hashCode;
  }
  
  public Stream clone()
  {
    try
    {
      return (Stream)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StreamMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Stream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */