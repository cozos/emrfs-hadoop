package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ClusterTimelineMarshaller;
import java.io.Serializable;
import java.util.Date;

public class ClusterTimeline
  implements Serializable, Cloneable, StructuredPojo
{
  private Date creationDateTime;
  private Date readyDateTime;
  private Date endDateTime;
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public ClusterTimeline withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setReadyDateTime(Date readyDateTime)
  {
    this.readyDateTime = readyDateTime;
  }
  
  public Date getReadyDateTime()
  {
    return readyDateTime;
  }
  
  public ClusterTimeline withReadyDateTime(Date readyDateTime)
  {
    setReadyDateTime(readyDateTime);
    return this;
  }
  
  public void setEndDateTime(Date endDateTime)
  {
    this.endDateTime = endDateTime;
  }
  
  public Date getEndDateTime()
  {
    return endDateTime;
  }
  
  public ClusterTimeline withEndDateTime(Date endDateTime)
  {
    setEndDateTime(endDateTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime()).append(",");
    }
    if (getReadyDateTime() != null) {
      sb.append("ReadyDateTime: ").append(getReadyDateTime()).append(",");
    }
    if (getEndDateTime() != null) {
      sb.append("EndDateTime: ").append(getEndDateTime());
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
    if (!(obj instanceof ClusterTimeline)) {
      return false;
    }
    ClusterTimeline other = (ClusterTimeline)obj;
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getReadyDateTime() == null ? 1 : 0) ^ (getReadyDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReadyDateTime() != null) && (!other.getReadyDateTime().equals(getReadyDateTime()))) {
      return false;
    }
    if (((other.getEndDateTime() == null ? 1 : 0) ^ (getEndDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndDateTime() != null) && (!other.getEndDateTime().equals(getEndDateTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getReadyDateTime() == null ? 0 : getReadyDateTime().hashCode());
    hashCode = 31 * hashCode + (getEndDateTime() == null ? 0 : getEndDateTime().hashCode());
    return hashCode;
  }
  
  public ClusterTimeline clone()
  {
    try
    {
      return (ClusterTimeline)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ClusterTimelineMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ClusterTimeline
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */