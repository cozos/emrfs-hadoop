package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TimeToLiveDescriptionMarshaller;
import java.io.Serializable;

public class TimeToLiveDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String timeToLiveStatus;
  private String attributeName;
  
  public void setTimeToLiveStatus(String timeToLiveStatus)
  {
    this.timeToLiveStatus = timeToLiveStatus;
  }
  
  public String getTimeToLiveStatus()
  {
    return timeToLiveStatus;
  }
  
  public TimeToLiveDescription withTimeToLiveStatus(String timeToLiveStatus)
  {
    setTimeToLiveStatus(timeToLiveStatus);
    return this;
  }
  
  public void setTimeToLiveStatus(TimeToLiveStatus timeToLiveStatus)
  {
    withTimeToLiveStatus(timeToLiveStatus);
  }
  
  public TimeToLiveDescription withTimeToLiveStatus(TimeToLiveStatus timeToLiveStatus)
  {
    this.timeToLiveStatus = timeToLiveStatus.toString();
    return this;
  }
  
  public void setAttributeName(String attributeName)
  {
    this.attributeName = attributeName;
  }
  
  public String getAttributeName()
  {
    return attributeName;
  }
  
  public TimeToLiveDescription withAttributeName(String attributeName)
  {
    setAttributeName(attributeName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTimeToLiveStatus() != null) {
      sb.append("TimeToLiveStatus: ").append(getTimeToLiveStatus()).append(",");
    }
    if (getAttributeName() != null) {
      sb.append("AttributeName: ").append(getAttributeName());
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
    if (!(obj instanceof TimeToLiveDescription)) {
      return false;
    }
    TimeToLiveDescription other = (TimeToLiveDescription)obj;
    if (((other.getTimeToLiveStatus() == null ? 1 : 0) ^ (getTimeToLiveStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeToLiveStatus() != null) && (!other.getTimeToLiveStatus().equals(getTimeToLiveStatus()))) {
      return false;
    }
    if (((other.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeName() != null) && (!other.getAttributeName().equals(getAttributeName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTimeToLiveStatus() == null ? 0 : getTimeToLiveStatus().hashCode());
    hashCode = 31 * hashCode + (getAttributeName() == null ? 0 : getAttributeName().hashCode());
    return hashCode;
  }
  
  public TimeToLiveDescription clone()
  {
    try
    {
      return (TimeToLiveDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    TimeToLiveDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TimeToLiveDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */