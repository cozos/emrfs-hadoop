package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class SendMessageBatchRequestEntry
  implements Serializable, Cloneable
{
  private String id;
  private String messageBody;
  private Integer delaySeconds;
  private SdkInternalMap<String, MessageAttributeValue> messageAttributes;
  private SdkInternalMap<String, MessageSystemAttributeValue> messageSystemAttributes;
  private String messageDeduplicationId;
  private String messageGroupId;
  
  public SendMessageBatchRequestEntry() {}
  
  public SendMessageBatchRequestEntry(String id, String messageBody)
  {
    setId(id);
    setMessageBody(messageBody);
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public SendMessageBatchRequestEntry withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setMessageBody(String messageBody)
  {
    this.messageBody = messageBody;
  }
  
  public String getMessageBody()
  {
    return messageBody;
  }
  
  public SendMessageBatchRequestEntry withMessageBody(String messageBody)
  {
    setMessageBody(messageBody);
    return this;
  }
  
  public void setDelaySeconds(Integer delaySeconds)
  {
    this.delaySeconds = delaySeconds;
  }
  
  public Integer getDelaySeconds()
  {
    return delaySeconds;
  }
  
  public SendMessageBatchRequestEntry withDelaySeconds(Integer delaySeconds)
  {
    setDelaySeconds(delaySeconds);
    return this;
  }
  
  public Map<String, MessageAttributeValue> getMessageAttributes()
  {
    if (messageAttributes == null) {
      messageAttributes = new SdkInternalMap();
    }
    return messageAttributes;
  }
  
  public void setMessageAttributes(Map<String, MessageAttributeValue> messageAttributes)
  {
    this.messageAttributes = (messageAttributes == null ? null : new SdkInternalMap(messageAttributes));
  }
  
  public SendMessageBatchRequestEntry withMessageAttributes(Map<String, MessageAttributeValue> messageAttributes)
  {
    setMessageAttributes(messageAttributes);
    return this;
  }
  
  public SendMessageBatchRequestEntry addMessageAttributesEntry(String key, MessageAttributeValue value)
  {
    if (null == messageAttributes) {
      messageAttributes = new SdkInternalMap();
    }
    if (messageAttributes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    messageAttributes.put(key, value);
    return this;
  }
  
  public SendMessageBatchRequestEntry clearMessageAttributesEntries()
  {
    messageAttributes = null;
    return this;
  }
  
  public Map<String, MessageSystemAttributeValue> getMessageSystemAttributes()
  {
    if (messageSystemAttributes == null) {
      messageSystemAttributes = new SdkInternalMap();
    }
    return messageSystemAttributes;
  }
  
  public void setMessageSystemAttributes(Map<String, MessageSystemAttributeValue> messageSystemAttributes)
  {
    this.messageSystemAttributes = (messageSystemAttributes == null ? null : new SdkInternalMap(messageSystemAttributes));
  }
  
  public SendMessageBatchRequestEntry withMessageSystemAttributes(Map<String, MessageSystemAttributeValue> messageSystemAttributes)
  {
    setMessageSystemAttributes(messageSystemAttributes);
    return this;
  }
  
  public SendMessageBatchRequestEntry addMessageSystemAttributesEntry(String key, MessageSystemAttributeValue value)
  {
    if (null == messageSystemAttributes) {
      messageSystemAttributes = new SdkInternalMap();
    }
    if (messageSystemAttributes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    messageSystemAttributes.put(key, value);
    return this;
  }
  
  public SendMessageBatchRequestEntry clearMessageSystemAttributesEntries()
  {
    messageSystemAttributes = null;
    return this;
  }
  
  public void setMessageDeduplicationId(String messageDeduplicationId)
  {
    this.messageDeduplicationId = messageDeduplicationId;
  }
  
  public String getMessageDeduplicationId()
  {
    return messageDeduplicationId;
  }
  
  public SendMessageBatchRequestEntry withMessageDeduplicationId(String messageDeduplicationId)
  {
    setMessageDeduplicationId(messageDeduplicationId);
    return this;
  }
  
  public void setMessageGroupId(String messageGroupId)
  {
    this.messageGroupId = messageGroupId;
  }
  
  public String getMessageGroupId()
  {
    return messageGroupId;
  }
  
  public SendMessageBatchRequestEntry withMessageGroupId(String messageGroupId)
  {
    setMessageGroupId(messageGroupId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getMessageBody() != null) {
      sb.append("MessageBody: ").append(getMessageBody()).append(",");
    }
    if (getDelaySeconds() != null) {
      sb.append("DelaySeconds: ").append(getDelaySeconds()).append(",");
    }
    if (getMessageAttributes() != null) {
      sb.append("MessageAttributes: ").append(getMessageAttributes()).append(",");
    }
    if (getMessageSystemAttributes() != null) {
      sb.append("MessageSystemAttributes: ").append(getMessageSystemAttributes()).append(",");
    }
    if (getMessageDeduplicationId() != null) {
      sb.append("MessageDeduplicationId: ").append(getMessageDeduplicationId()).append(",");
    }
    if (getMessageGroupId() != null) {
      sb.append("MessageGroupId: ").append(getMessageGroupId());
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
    if (!(obj instanceof SendMessageBatchRequestEntry)) {
      return false;
    }
    SendMessageBatchRequestEntry other = (SendMessageBatchRequestEntry)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getMessageBody() == null ? 1 : 0) ^ (getMessageBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageBody() != null) && (!other.getMessageBody().equals(getMessageBody()))) {
      return false;
    }
    if (((other.getDelaySeconds() == null ? 1 : 0) ^ (getDelaySeconds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDelaySeconds() != null) && (!other.getDelaySeconds().equals(getDelaySeconds()))) {
      return false;
    }
    if (((other.getMessageAttributes() == null ? 1 : 0) ^ (getMessageAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageAttributes() != null) && (!other.getMessageAttributes().equals(getMessageAttributes()))) {
      return false;
    }
    if (((other.getMessageSystemAttributes() == null ? 1 : 0) ^ (getMessageSystemAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageSystemAttributes() != null) && (!other.getMessageSystemAttributes().equals(getMessageSystemAttributes()))) {
      return false;
    }
    if (((other.getMessageDeduplicationId() == null ? 1 : 0) ^ (getMessageDeduplicationId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageDeduplicationId() != null) && (!other.getMessageDeduplicationId().equals(getMessageDeduplicationId()))) {
      return false;
    }
    if (((other.getMessageGroupId() == null ? 1 : 0) ^ (getMessageGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageGroupId() != null) && (!other.getMessageGroupId().equals(getMessageGroupId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getMessageBody() == null ? 0 : getMessageBody().hashCode());
    hashCode = 31 * hashCode + (getDelaySeconds() == null ? 0 : getDelaySeconds().hashCode());
    hashCode = 31 * hashCode + (getMessageAttributes() == null ? 0 : getMessageAttributes().hashCode());
    hashCode = 31 * hashCode + (getMessageSystemAttributes() == null ? 0 : getMessageSystemAttributes().hashCode());
    hashCode = 31 * hashCode + (getMessageDeduplicationId() == null ? 0 : getMessageDeduplicationId().hashCode());
    hashCode = 31 * hashCode + (getMessageGroupId() == null ? 0 : getMessageGroupId().hashCode());
    return hashCode;
  }
  
  public SendMessageBatchRequestEntry clone()
  {
    try
    {
      return (SendMessageBatchRequestEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */