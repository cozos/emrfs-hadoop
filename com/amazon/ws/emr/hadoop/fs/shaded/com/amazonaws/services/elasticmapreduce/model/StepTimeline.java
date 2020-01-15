package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepTimelineMarshaller;
import java.io.Serializable;
import java.util.Date;

public class StepTimeline
  implements Serializable, Cloneable, StructuredPojo
{
  private Date creationDateTime;
  private Date startDateTime;
  private Date endDateTime;
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public StepTimeline withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setStartDateTime(Date startDateTime)
  {
    this.startDateTime = startDateTime;
  }
  
  public Date getStartDateTime()
  {
    return startDateTime;
  }
  
  public StepTimeline withStartDateTime(Date startDateTime)
  {
    setStartDateTime(startDateTime);
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
  
  public StepTimeline withEndDateTime(Date endDateTime)
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
    if (getStartDateTime() != null) {
      sb.append("StartDateTime: ").append(getStartDateTime()).append(",");
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
    if (!(obj instanceof StepTimeline)) {
      return false;
    }
    StepTimeline other = (StepTimeline)obj;
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getStartDateTime() == null ? 1 : 0) ^ (getStartDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartDateTime() != null) && (!other.getStartDateTime().equals(getStartDateTime()))) {
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
    hashCode = 31 * hashCode + (getStartDateTime() == null ? 0 : getStartDateTime().hashCode());
    hashCode = 31 * hashCode + (getEndDateTime() == null ? 0 : getEndDateTime().hashCode());
    return hashCode;
  }
  
  public StepTimeline clone()
  {
    try
    {
      return (StepTimeline)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StepTimelineMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepTimeline
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */