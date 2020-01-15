package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ReceiveMessageResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<Message> messages;
  
  public List<Message> getMessages()
  {
    if (messages == null) {
      messages = new SdkInternalList();
    }
    return messages;
  }
  
  public void setMessages(Collection<Message> messages)
  {
    if (messages == null)
    {
      this.messages = null;
      return;
    }
    this.messages = new SdkInternalList(messages);
  }
  
  public ReceiveMessageResult withMessages(Message... messages)
  {
    if (this.messages == null) {
      setMessages(new SdkInternalList(messages.length));
    }
    for (Message ele : messages) {
      this.messages.add(ele);
    }
    return this;
  }
  
  public ReceiveMessageResult withMessages(Collection<Message> messages)
  {
    setMessages(messages);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof ReceiveMessageResult)) {
      return false;
    }
    ReceiveMessageResult other = (ReceiveMessageResult)obj;
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
    
    hashCode = 31 * hashCode + (getMessages() == null ? 0 : getMessages().hashCode());
    return hashCode;
  }
  
  public ReceiveMessageResult clone()
  {
    try
    {
      return (ReceiveMessageResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ReceiveMessageResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */