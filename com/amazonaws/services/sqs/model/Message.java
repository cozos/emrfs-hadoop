package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class Message
  implements Serializable, Cloneable
{
  private String messageId;
  private String receiptHandle;
  private String mD5OfBody;
  private String body;
  private SdkInternalMap<String, String> attributes;
  private String mD5OfMessageAttributes;
  private SdkInternalMap<String, MessageAttributeValue> messageAttributes;
  
  public void setMessageId(String messageId)
  {
    this.messageId = messageId;
  }
  
  public String getMessageId()
  {
    return messageId;
  }
  
  public Message withMessageId(String messageId)
  {
    setMessageId(messageId);
    return this;
  }
  
  public void setReceiptHandle(String receiptHandle)
  {
    this.receiptHandle = receiptHandle;
  }
  
  public String getReceiptHandle()
  {
    return receiptHandle;
  }
  
  public Message withReceiptHandle(String receiptHandle)
  {
    setReceiptHandle(receiptHandle);
    return this;
  }
  
  public void setMD5OfBody(String mD5OfBody)
  {
    this.mD5OfBody = mD5OfBody;
  }
  
  public String getMD5OfBody()
  {
    return mD5OfBody;
  }
  
  public Message withMD5OfBody(String mD5OfBody)
  {
    setMD5OfBody(mD5OfBody);
    return this;
  }
  
  public void setBody(String body)
  {
    this.body = body;
  }
  
  public String getBody()
  {
    return body;
  }
  
  public Message withBody(String body)
  {
    setBody(body);
    return this;
  }
  
  public Map<String, String> getAttributes()
  {
    if (attributes == null) {
      attributes = new SdkInternalMap();
    }
    return attributes;
  }
  
  public void setAttributes(Map<String, String> attributes)
  {
    this.attributes = (attributes == null ? null : new SdkInternalMap(attributes));
  }
  
  public Message withAttributes(Map<String, String> attributes)
  {
    setAttributes(attributes);
    return this;
  }
  
  public Message addAttributesEntry(String key, String value)
  {
    if (null == attributes) {
      attributes = new SdkInternalMap();
    }
    if (attributes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    attributes.put(key, value);
    return this;
  }
  
  public Message clearAttributesEntries()
  {
    attributes = null;
    return this;
  }
  
  public void setMD5OfMessageAttributes(String mD5OfMessageAttributes)
  {
    this.mD5OfMessageAttributes = mD5OfMessageAttributes;
  }
  
  public String getMD5OfMessageAttributes()
  {
    return mD5OfMessageAttributes;
  }
  
  public Message withMD5OfMessageAttributes(String mD5OfMessageAttributes)
  {
    setMD5OfMessageAttributes(mD5OfMessageAttributes);
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
  
  public Message withMessageAttributes(Map<String, MessageAttributeValue> messageAttributes)
  {
    setMessageAttributes(messageAttributes);
    return this;
  }
  
  public Message addMessageAttributesEntry(String key, MessageAttributeValue value)
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
  
  public Message clearMessageAttributesEntries()
  {
    messageAttributes = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMessageId() != null) {
      sb.append("MessageId: ").append(getMessageId()).append(",");
    }
    if (getReceiptHandle() != null) {
      sb.append("ReceiptHandle: ").append(getReceiptHandle()).append(",");
    }
    if (getMD5OfBody() != null) {
      sb.append("MD5OfBody: ").append(getMD5OfBody()).append(",");
    }
    if (getBody() != null) {
      sb.append("Body: ").append(getBody()).append(",");
    }
    if (getAttributes() != null) {
      sb.append("Attributes: ").append(getAttributes()).append(",");
    }
    if (getMD5OfMessageAttributes() != null) {
      sb.append("MD5OfMessageAttributes: ").append(getMD5OfMessageAttributes()).append(",");
    }
    if (getMessageAttributes() != null) {
      sb.append("MessageAttributes: ").append(getMessageAttributes());
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
    if (!(obj instanceof Message)) {
      return false;
    }
    Message other = (Message)obj;
    if (((other.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageId() != null) && (!other.getMessageId().equals(getMessageId()))) {
      return false;
    }
    if (((other.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReceiptHandle() != null) && (!other.getReceiptHandle().equals(getReceiptHandle()))) {
      return false;
    }
    if (((other.getMD5OfBody() == null ? 1 : 0) ^ (getMD5OfBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMD5OfBody() != null) && (!other.getMD5OfBody().equals(getMD5OfBody()))) {
      return false;
    }
    if (((other.getBody() == null ? 1 : 0) ^ (getBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBody() != null) && (!other.getBody().equals(getBody()))) {
      return false;
    }
    if (((other.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributes() != null) && (!other.getAttributes().equals(getAttributes()))) {
      return false;
    }
    if (((other.getMD5OfMessageAttributes() == null ? 1 : 0) ^ (getMD5OfMessageAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMD5OfMessageAttributes() != null) && (!other.getMD5OfMessageAttributes().equals(getMD5OfMessageAttributes()))) {
      return false;
    }
    if (((other.getMessageAttributes() == null ? 1 : 0) ^ (getMessageAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageAttributes() != null) && (!other.getMessageAttributes().equals(getMessageAttributes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMessageId() == null ? 0 : getMessageId().hashCode());
    hashCode = 31 * hashCode + (getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode());
    hashCode = 31 * hashCode + (getMD5OfBody() == null ? 0 : getMD5OfBody().hashCode());
    hashCode = 31 * hashCode + (getBody() == null ? 0 : getBody().hashCode());
    hashCode = 31 * hashCode + (getAttributes() == null ? 0 : getAttributes().hashCode());
    hashCode = 31 * hashCode + (getMD5OfMessageAttributes() == null ? 0 : getMD5OfMessageAttributes().hashCode());
    hashCode = 31 * hashCode + (getMessageAttributes() == null ? 0 : getMessageAttributes().hashCode());
    return hashCode;
  }
  
  public Message clone()
  {
    try
    {
      return (Message)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */