package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RecordMarshaller;
import java.io.Serializable;

public class Record
  implements Serializable, Cloneable, StructuredPojo
{
  private String eventID;
  private String eventName;
  private String eventVersion;
  private String eventSource;
  private String awsRegion;
  private StreamRecord dynamodb;
  private Identity userIdentity;
  
  public void setEventID(String eventID)
  {
    this.eventID = eventID;
  }
  
  public String getEventID()
  {
    return eventID;
  }
  
  public Record withEventID(String eventID)
  {
    setEventID(eventID);
    return this;
  }
  
  public void setEventName(String eventName)
  {
    this.eventName = eventName;
  }
  
  public String getEventName()
  {
    return eventName;
  }
  
  public Record withEventName(String eventName)
  {
    setEventName(eventName);
    return this;
  }
  
  public void setEventName(OperationType eventName)
  {
    withEventName(eventName);
  }
  
  public Record withEventName(OperationType eventName)
  {
    this.eventName = eventName.toString();
    return this;
  }
  
  public void setEventVersion(String eventVersion)
  {
    this.eventVersion = eventVersion;
  }
  
  public String getEventVersion()
  {
    return eventVersion;
  }
  
  public Record withEventVersion(String eventVersion)
  {
    setEventVersion(eventVersion);
    return this;
  }
  
  public void setEventSource(String eventSource)
  {
    this.eventSource = eventSource;
  }
  
  public String getEventSource()
  {
    return eventSource;
  }
  
  public Record withEventSource(String eventSource)
  {
    setEventSource(eventSource);
    return this;
  }
  
  public void setAwsRegion(String awsRegion)
  {
    this.awsRegion = awsRegion;
  }
  
  public String getAwsRegion()
  {
    return awsRegion;
  }
  
  public Record withAwsRegion(String awsRegion)
  {
    setAwsRegion(awsRegion);
    return this;
  }
  
  public void setDynamodb(StreamRecord dynamodb)
  {
    this.dynamodb = dynamodb;
  }
  
  public StreamRecord getDynamodb()
  {
    return dynamodb;
  }
  
  public Record withDynamodb(StreamRecord dynamodb)
  {
    setDynamodb(dynamodb);
    return this;
  }
  
  public void setUserIdentity(Identity userIdentity)
  {
    this.userIdentity = userIdentity;
  }
  
  public Identity getUserIdentity()
  {
    return userIdentity;
  }
  
  public Record withUserIdentity(Identity userIdentity)
  {
    setUserIdentity(userIdentity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEventID() != null) {
      sb.append("EventID: ").append(getEventID()).append(",");
    }
    if (getEventName() != null) {
      sb.append("EventName: ").append(getEventName()).append(",");
    }
    if (getEventVersion() != null) {
      sb.append("EventVersion: ").append(getEventVersion()).append(",");
    }
    if (getEventSource() != null) {
      sb.append("EventSource: ").append(getEventSource()).append(",");
    }
    if (getAwsRegion() != null) {
      sb.append("AwsRegion: ").append(getAwsRegion()).append(",");
    }
    if (getDynamodb() != null) {
      sb.append("Dynamodb: ").append(getDynamodb()).append(",");
    }
    if (getUserIdentity() != null) {
      sb.append("UserIdentity: ").append(getUserIdentity());
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
    if (!(obj instanceof Record)) {
      return false;
    }
    Record other = (Record)obj;
    if (((other.getEventID() == null ? 1 : 0) ^ (getEventID() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEventID() != null) && (!other.getEventID().equals(getEventID()))) {
      return false;
    }
    if (((other.getEventName() == null ? 1 : 0) ^ (getEventName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEventName() != null) && (!other.getEventName().equals(getEventName()))) {
      return false;
    }
    if (((other.getEventVersion() == null ? 1 : 0) ^ (getEventVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEventVersion() != null) && (!other.getEventVersion().equals(getEventVersion()))) {
      return false;
    }
    if (((other.getEventSource() == null ? 1 : 0) ^ (getEventSource() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEventSource() != null) && (!other.getEventSource().equals(getEventSource()))) {
      return false;
    }
    if (((other.getAwsRegion() == null ? 1 : 0) ^ (getAwsRegion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAwsRegion() != null) && (!other.getAwsRegion().equals(getAwsRegion()))) {
      return false;
    }
    if (((other.getDynamodb() == null ? 1 : 0) ^ (getDynamodb() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDynamodb() != null) && (!other.getDynamodb().equals(getDynamodb()))) {
      return false;
    }
    if (((other.getUserIdentity() == null ? 1 : 0) ^ (getUserIdentity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserIdentity() != null) && (!other.getUserIdentity().equals(getUserIdentity()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEventID() == null ? 0 : getEventID().hashCode());
    hashCode = 31 * hashCode + (getEventName() == null ? 0 : getEventName().hashCode());
    hashCode = 31 * hashCode + (getEventVersion() == null ? 0 : getEventVersion().hashCode());
    hashCode = 31 * hashCode + (getEventSource() == null ? 0 : getEventSource().hashCode());
    hashCode = 31 * hashCode + (getAwsRegion() == null ? 0 : getAwsRegion().hashCode());
    hashCode = 31 * hashCode + (getDynamodb() == null ? 0 : getDynamodb().hashCode());
    hashCode = 31 * hashCode + (getUserIdentity() == null ? 0 : getUserIdentity().hashCode());
    return hashCode;
  }
  
  public Record clone()
  {
    try
    {
      return (Record)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    RecordMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Record
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */