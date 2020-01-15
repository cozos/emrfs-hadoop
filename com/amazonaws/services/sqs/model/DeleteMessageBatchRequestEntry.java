package com.amazonaws.services.sqs.model;

import java.io.Serializable;

public class DeleteMessageBatchRequestEntry
  implements Serializable, Cloneable
{
  private String id;
  private String receiptHandle;
  
  public DeleteMessageBatchRequestEntry() {}
  
  public DeleteMessageBatchRequestEntry(String id, String receiptHandle)
  {
    setId(id);
    setReceiptHandle(receiptHandle);
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public DeleteMessageBatchRequestEntry withId(String id)
  {
    setId(id);
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
  
  public DeleteMessageBatchRequestEntry withReceiptHandle(String receiptHandle)
  {
    setReceiptHandle(receiptHandle);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getReceiptHandle() != null) {
      sb.append("ReceiptHandle: ").append(getReceiptHandle());
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
    if (!(obj instanceof DeleteMessageBatchRequestEntry)) {
      return false;
    }
    DeleteMessageBatchRequestEntry other = (DeleteMessageBatchRequestEntry)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReceiptHandle() != null) && (!other.getReceiptHandle().equals(getReceiptHandle()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode());
    return hashCode;
  }
  
  public DeleteMessageBatchRequestEntry clone()
  {
    try
    {
      return (DeleteMessageBatchRequestEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */