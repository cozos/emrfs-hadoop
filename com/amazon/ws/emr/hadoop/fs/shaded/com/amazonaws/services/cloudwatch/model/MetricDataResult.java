package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MetricDataResult
  implements Serializable, Cloneable
{
  private String id;
  private String label;
  private SdkInternalList<Date> timestamps;
  private SdkInternalList<Double> values;
  private String statusCode;
  private SdkInternalList<MessageData> messages;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public MetricDataResult withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setLabel(String label)
  {
    this.label = label;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public MetricDataResult withLabel(String label)
  {
    setLabel(label);
    return this;
  }
  
  public List<Date> getTimestamps()
  {
    if (timestamps == null) {
      timestamps = new SdkInternalList();
    }
    return timestamps;
  }
  
  public void setTimestamps(Collection<Date> timestamps)
  {
    if (timestamps == null)
    {
      this.timestamps = null;
      return;
    }
    this.timestamps = new SdkInternalList(timestamps);
  }
  
  public MetricDataResult withTimestamps(Date... timestamps)
  {
    if (this.timestamps == null) {
      setTimestamps(new SdkInternalList(timestamps.length));
    }
    for (Date ele : timestamps) {
      this.timestamps.add(ele);
    }
    return this;
  }
  
  public MetricDataResult withTimestamps(Collection<Date> timestamps)
  {
    setTimestamps(timestamps);
    return this;
  }
  
  public List<Double> getValues()
  {
    if (values == null) {
      values = new SdkInternalList();
    }
    return values;
  }
  
  public void setValues(Collection<Double> values)
  {
    if (values == null)
    {
      this.values = null;
      return;
    }
    this.values = new SdkInternalList(values);
  }
  
  public MetricDataResult withValues(Double... values)
  {
    if (this.values == null) {
      setValues(new SdkInternalList(values.length));
    }
    for (Double ele : values) {
      this.values.add(ele);
    }
    return this;
  }
  
  public MetricDataResult withValues(Collection<Double> values)
  {
    setValues(values);
    return this;
  }
  
  public void setStatusCode(String statusCode)
  {
    this.statusCode = statusCode;
  }
  
  public String getStatusCode()
  {
    return statusCode;
  }
  
  public MetricDataResult withStatusCode(String statusCode)
  {
    setStatusCode(statusCode);
    return this;
  }
  
  public MetricDataResult withStatusCode(StatusCode statusCode)
  {
    this.statusCode = statusCode.toString();
    return this;
  }
  
  public List<MessageData> getMessages()
  {
    if (messages == null) {
      messages = new SdkInternalList();
    }
    return messages;
  }
  
  public void setMessages(Collection<MessageData> messages)
  {
    if (messages == null)
    {
      this.messages = null;
      return;
    }
    this.messages = new SdkInternalList(messages);
  }
  
  public MetricDataResult withMessages(MessageData... messages)
  {
    if (this.messages == null) {
      setMessages(new SdkInternalList(messages.length));
    }
    for (MessageData ele : messages) {
      this.messages.add(ele);
    }
    return this;
  }
  
  public MetricDataResult withMessages(Collection<MessageData> messages)
  {
    setMessages(messages);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getLabel() != null) {
      sb.append("Label: ").append(getLabel()).append(",");
    }
    if (getTimestamps() != null) {
      sb.append("Timestamps: ").append(getTimestamps()).append(",");
    }
    if (getValues() != null) {
      sb.append("Values: ").append(getValues()).append(",");
    }
    if (getStatusCode() != null) {
      sb.append("StatusCode: ").append(getStatusCode()).append(",");
    }
    if (getMessages() != null) {
      sb.append("Messages: ").append(getMessages());
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
    if (!(obj instanceof MetricDataResult)) {
      return false;
    }
    MetricDataResult other = (MetricDataResult)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLabel() != null) && (!other.getLabel().equals(getLabel()))) {
      return false;
    }
    if (((other.getTimestamps() == null ? 1 : 0) ^ (getTimestamps() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimestamps() != null) && (!other.getTimestamps().equals(getTimestamps()))) {
      return false;
    }
    if (((other.getValues() == null ? 1 : 0) ^ (getValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValues() != null) && (!other.getValues().equals(getValues()))) {
      return false;
    }
    if (((other.getStatusCode() == null ? 1 : 0) ^ (getStatusCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatusCode() != null) && (!other.getStatusCode().equals(getStatusCode()))) {
      return false;
    }
    if (((other.getMessages() == null ? 1 : 0) ^ (getMessages() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessages() != null) && (!other.getMessages().equals(getMessages()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getLabel() == null ? 0 : getLabel().hashCode());
    hashCode = 31 * hashCode + (getTimestamps() == null ? 0 : getTimestamps().hashCode());
    hashCode = 31 * hashCode + (getValues() == null ? 0 : getValues().hashCode());
    hashCode = 31 * hashCode + (getStatusCode() == null ? 0 : getStatusCode().hashCode());
    hashCode = 31 * hashCode + (getMessages() == null ? 0 : getMessages().hashCode());
    return hashCode;
  }
  
  public MetricDataResult clone()
  {
    try
    {
      return (MetricDataResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */