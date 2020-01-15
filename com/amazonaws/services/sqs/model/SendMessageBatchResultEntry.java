package com.amazonaws.services.sqs.model;

import java.io.Serializable;

public class SendMessageBatchResultEntry
  implements Serializable, Cloneable
{
  private String id;
  private String messageId;
  private String mD5OfMessageBody;
  private String mD5OfMessageAttributes;
  private String mD5OfMessageSystemAttributes;
  private String sequenceNumber;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public SendMessageBatchResultEntry withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setMessageId(String messageId)
  {
    this.messageId = messageId;
  }
  
  public String getMessageId()
  {
    return messageId;
  }
  
  public SendMessageBatchResultEntry withMessageId(String messageId)
  {
    setMessageId(messageId);
    return this;
  }
  
  public void setMD5OfMessageBody(String mD5OfMessageBody)
  {
    this.mD5OfMessageBody = mD5OfMessageBody;
  }
  
  public String getMD5OfMessageBody()
  {
    return mD5OfMessageBody;
  }
  
  public SendMessageBatchResultEntry withMD5OfMessageBody(String mD5OfMessageBody)
  {
    setMD5OfMessageBody(mD5OfMessageBody);
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
  
  public SendMessageBatchResultEntry withMD5OfMessageAttributes(String mD5OfMessageAttributes)
  {
    setMD5OfMessageAttributes(mD5OfMessageAttributes);
    return this;
  }
  
  public void setMD5OfMessageSystemAttributes(String mD5OfMessageSystemAttributes)
  {
    this.mD5OfMessageSystemAttributes = mD5OfMessageSystemAttributes;
  }
  
  public String getMD5OfMessageSystemAttributes()
  {
    return mD5OfMessageSystemAttributes;
  }
  
  public SendMessageBatchResultEntry withMD5OfMessageSystemAttributes(String mD5OfMessageSystemAttributes)
  {
    setMD5OfMessageSystemAttributes(mD5OfMessageSystemAttributes);
    return this;
  }
  
  public void setSequenceNumber(String sequenceNumber)
  {
    this.sequenceNumber = sequenceNumber;
  }
  
  public String getSequenceNumber()
  {
    return sequenceNumber;
  }
  
  public SendMessageBatchResultEntry withSequenceNumber(String sequenceNumber)
  {
    setSequenceNumber(sequenceNumber);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getMessageId() != null) {
      sb.append("MessageId: ").append(getMessageId()).append(",");
    }
    if (getMD5OfMessageBody() != null) {
      sb.append("MD5OfMessageBody: ").append(getMD5OfMessageBody()).append(",");
    }
    if (getMD5OfMessageAttributes() != null) {
      sb.append("MD5OfMessageAttributes: ").append(getMD5OfMessageAttributes()).append(",");
    }
    if (getMD5OfMessageSystemAttributes() != null) {
      sb.append("MD5OfMessageSystemAttributes: ").append(getMD5OfMessageSystemAttributes()).append(",");
    }
    if (getSequenceNumber() != null) {
      sb.append("SequenceNumber: ").append(getSequenceNumber());
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
    if (!(obj instanceof SendMessageBatchResultEntry)) {
      return false;
    }
    SendMessageBatchResultEntry other = (SendMessageBatchResultEntry)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageId() != null) && (!other.getMessageId().equals(getMessageId()))) {
      return false;
    }
    if (((other.getMD5OfMessageBody() == null ? 1 : 0) ^ (getMD5OfMessageBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMD5OfMessageBody() != null) && (!other.getMD5OfMessageBody().equals(getMD5OfMessageBody()))) {
      return false;
    }
    if (((other.getMD5OfMessageAttributes() == null ? 1 : 0) ^ (getMD5OfMessageAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMD5OfMessageAttributes() != null) && (!other.getMD5OfMessageAttributes().equals(getMD5OfMessageAttributes()))) {
      return false;
    }
    if (((other.getMD5OfMessageSystemAttributes() == null ? 1 : 0) ^ (getMD5OfMessageSystemAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMD5OfMessageSystemAttributes() != null) && (!other.getMD5OfMessageSystemAttributes().equals(getMD5OfMessageSystemAttributes()))) {
      return false;
    }
    if (((other.getSequenceNumber() == null ? 1 : 0) ^ (getSequenceNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSequenceNumber() != null) && (!other.getSequenceNumber().equals(getSequenceNumber()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getMessageId() == null ? 0 : getMessageId().hashCode());
    hashCode = 31 * hashCode + (getMD5OfMessageBody() == null ? 0 : getMD5OfMessageBody().hashCode());
    hashCode = 31 * hashCode + (getMD5OfMessageAttributes() == null ? 0 : getMD5OfMessageAttributes().hashCode());
    hashCode = 31 * hashCode + (getMD5OfMessageSystemAttributes() == null ? 0 : getMD5OfMessageSystemAttributes().hashCode());
    hashCode = 31 * hashCode + (getSequenceNumber() == null ? 0 : getSequenceNumber().hashCode());
    return hashCode;
  }
  
  public SendMessageBatchResultEntry clone()
  {
    try
    {
      return (SendMessageBatchResultEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.SendMessageBatchResultEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */