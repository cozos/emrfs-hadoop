package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamSpecificationMarshaller;
import java.io.Serializable;

public class StreamSpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private Boolean streamEnabled;
  private String streamViewType;
  
  public void setStreamEnabled(Boolean streamEnabled)
  {
    this.streamEnabled = streamEnabled;
  }
  
  public Boolean getStreamEnabled()
  {
    return streamEnabled;
  }
  
  public StreamSpecification withStreamEnabled(Boolean streamEnabled)
  {
    setStreamEnabled(streamEnabled);
    return this;
  }
  
  public Boolean isStreamEnabled()
  {
    return streamEnabled;
  }
  
  public void setStreamViewType(String streamViewType)
  {
    this.streamViewType = streamViewType;
  }
  
  public String getStreamViewType()
  {
    return streamViewType;
  }
  
  public StreamSpecification withStreamViewType(String streamViewType)
  {
    setStreamViewType(streamViewType);
    return this;
  }
  
  public void setStreamViewType(StreamViewType streamViewType)
  {
    withStreamViewType(streamViewType);
  }
  
  public StreamSpecification withStreamViewType(StreamViewType streamViewType)
  {
    this.streamViewType = streamViewType.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreamEnabled() != null) {
      sb.append("StreamEnabled: ").append(getStreamEnabled()).append(",");
    }
    if (getStreamViewType() != null) {
      sb.append("StreamViewType: ").append(getStreamViewType());
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
    if (!(obj instanceof StreamSpecification)) {
      return false;
    }
    StreamSpecification other = (StreamSpecification)obj;
    if (((other.getStreamEnabled() == null ? 1 : 0) ^ (getStreamEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamEnabled() != null) && (!other.getStreamEnabled().equals(getStreamEnabled()))) {
      return false;
    }
    if (((other.getStreamViewType() == null ? 1 : 0) ^ (getStreamViewType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamViewType() != null) && (!other.getStreamViewType().equals(getStreamViewType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreamEnabled() == null ? 0 : getStreamEnabled().hashCode());
    hashCode = 31 * hashCode + (getStreamViewType() == null ? 0 : getStreamViewType().hashCode());
    return hashCode;
  }
  
  public StreamSpecification clone()
  {
    try
    {
      return (StreamSpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StreamSpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */