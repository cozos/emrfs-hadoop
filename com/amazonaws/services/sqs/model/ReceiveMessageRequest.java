package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ReceiveMessageRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalList<String> attributeNames;
  private SdkInternalList<String> messageAttributeNames;
  private Integer maxNumberOfMessages;
  private Integer visibilityTimeout;
  private Integer waitTimeSeconds;
  private String receiveRequestAttemptId;
  
  public ReceiveMessageRequest() {}
  
  public ReceiveMessageRequest(String queueUrl)
  {
    setQueueUrl(queueUrl);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public ReceiveMessageRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public List<String> getAttributeNames()
  {
    if (attributeNames == null) {
      attributeNames = new SdkInternalList();
    }
    return attributeNames;
  }
  
  public void setAttributeNames(Collection<String> attributeNames)
  {
    if (attributeNames == null)
    {
      this.attributeNames = null;
      return;
    }
    this.attributeNames = new SdkInternalList(attributeNames);
  }
  
  public ReceiveMessageRequest withAttributeNames(String... attributeNames)
  {
    if (this.attributeNames == null) {
      setAttributeNames(new SdkInternalList(attributeNames.length));
    }
    for (String ele : attributeNames) {
      this.attributeNames.add(ele);
    }
    return this;
  }
  
  public ReceiveMessageRequest withAttributeNames(Collection<String> attributeNames)
  {
    setAttributeNames(attributeNames);
    return this;
  }
  
  public ReceiveMessageRequest withAttributeNames(QueueAttributeName... attributeNames)
  {
    SdkInternalList<String> attributeNamesCopy = new SdkInternalList(attributeNames.length);
    for (QueueAttributeName value : attributeNames) {
      attributeNamesCopy.add(value.toString());
    }
    if (getAttributeNames() == null) {
      setAttributeNames(attributeNamesCopy);
    } else {
      getAttributeNames().addAll(attributeNamesCopy);
    }
    return this;
  }
  
  public List<String> getMessageAttributeNames()
  {
    if (messageAttributeNames == null) {
      messageAttributeNames = new SdkInternalList();
    }
    return messageAttributeNames;
  }
  
  public void setMessageAttributeNames(Collection<String> messageAttributeNames)
  {
    if (messageAttributeNames == null)
    {
      this.messageAttributeNames = null;
      return;
    }
    this.messageAttributeNames = new SdkInternalList(messageAttributeNames);
  }
  
  public ReceiveMessageRequest withMessageAttributeNames(String... messageAttributeNames)
  {
    if (this.messageAttributeNames == null) {
      setMessageAttributeNames(new SdkInternalList(messageAttributeNames.length));
    }
    for (String ele : messageAttributeNames) {
      this.messageAttributeNames.add(ele);
    }
    return this;
  }
  
  public ReceiveMessageRequest withMessageAttributeNames(Collection<String> messageAttributeNames)
  {
    setMessageAttributeNames(messageAttributeNames);
    return this;
  }
  
  public void setMaxNumberOfMessages(Integer maxNumberOfMessages)
  {
    this.maxNumberOfMessages = maxNumberOfMessages;
  }
  
  public Integer getMaxNumberOfMessages()
  {
    return maxNumberOfMessages;
  }
  
  public ReceiveMessageRequest withMaxNumberOfMessages(Integer maxNumberOfMessages)
  {
    setMaxNumberOfMessages(maxNumberOfMessages);
    return this;
  }
  
  public void setVisibilityTimeout(Integer visibilityTimeout)
  {
    this.visibilityTimeout = visibilityTimeout;
  }
  
  public Integer getVisibilityTimeout()
  {
    return visibilityTimeout;
  }
  
  public ReceiveMessageRequest withVisibilityTimeout(Integer visibilityTimeout)
  {
    setVisibilityTimeout(visibilityTimeout);
    return this;
  }
  
  public void setWaitTimeSeconds(Integer waitTimeSeconds)
  {
    this.waitTimeSeconds = waitTimeSeconds;
  }
  
  public Integer getWaitTimeSeconds()
  {
    return waitTimeSeconds;
  }
  
  public ReceiveMessageRequest withWaitTimeSeconds(Integer waitTimeSeconds)
  {
    setWaitTimeSeconds(waitTimeSeconds);
    return this;
  }
  
  public void setReceiveRequestAttemptId(String receiveRequestAttemptId)
  {
    this.receiveRequestAttemptId = receiveRequestAttemptId;
  }
  
  public String getReceiveRequestAttemptId()
  {
    return receiveRequestAttemptId;
  }
  
  public ReceiveMessageRequest withReceiveRequestAttemptId(String receiveRequestAttemptId)
  {
    setReceiveRequestAttemptId(receiveRequestAttemptId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getAttributeNames() != null) {
      sb.append("AttributeNames: ").append(getAttributeNames()).append(",");
    }
    if (getMessageAttributeNames() != null) {
      sb.append("MessageAttributeNames: ").append(getMessageAttributeNames()).append(",");
    }
    if (getMaxNumberOfMessages() != null) {
      sb.append("MaxNumberOfMessages: ").append(getMaxNumberOfMessages()).append(",");
    }
    if (getVisibilityTimeout() != null) {
      sb.append("VisibilityTimeout: ").append(getVisibilityTimeout()).append(",");
    }
    if (getWaitTimeSeconds() != null) {
      sb.append("WaitTimeSeconds: ").append(getWaitTimeSeconds()).append(",");
    }
    if (getReceiveRequestAttemptId() != null) {
      sb.append("ReceiveRequestAttemptId: ").append(getReceiveRequestAttemptId());
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
    if (!(obj instanceof ReceiveMessageRequest)) {
      return false;
    }
    ReceiveMessageRequest other = (ReceiveMessageRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getAttributeNames() == null ? 1 : 0) ^ (getAttributeNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeNames() != null) && (!other.getAttributeNames().equals(getAttributeNames()))) {
      return false;
    }
    if (((other.getMessageAttributeNames() == null ? 1 : 0) ^ (getMessageAttributeNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessageAttributeNames() != null) && (!other.getMessageAttributeNames().equals(getMessageAttributeNames()))) {
      return false;
    }
    if (((other.getMaxNumberOfMessages() == null ? 1 : 0) ^ (getMaxNumberOfMessages() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxNumberOfMessages() != null) && (!other.getMaxNumberOfMessages().equals(getMaxNumberOfMessages()))) {
      return false;
    }
    if (((other.getVisibilityTimeout() == null ? 1 : 0) ^ (getVisibilityTimeout() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVisibilityTimeout() != null) && (!other.getVisibilityTimeout().equals(getVisibilityTimeout()))) {
      return false;
    }
    if (((other.getWaitTimeSeconds() == null ? 1 : 0) ^ (getWaitTimeSeconds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWaitTimeSeconds() != null) && (!other.getWaitTimeSeconds().equals(getWaitTimeSeconds()))) {
      return false;
    }
    if (((other.getReceiveRequestAttemptId() == null ? 1 : 0) ^ (getReceiveRequestAttemptId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReceiveRequestAttemptId() != null) && (!other.getReceiveRequestAttemptId().equals(getReceiveRequestAttemptId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getAttributeNames() == null ? 0 : getAttributeNames().hashCode());
    hashCode = 31 * hashCode + (getMessageAttributeNames() == null ? 0 : getMessageAttributeNames().hashCode());
    hashCode = 31 * hashCode + (getMaxNumberOfMessages() == null ? 0 : getMaxNumberOfMessages().hashCode());
    hashCode = 31 * hashCode + (getVisibilityTimeout() == null ? 0 : getVisibilityTimeout().hashCode());
    hashCode = 31 * hashCode + (getWaitTimeSeconds() == null ? 0 : getWaitTimeSeconds().hashCode());
    hashCode = 31 * hashCode + (getReceiveRequestAttemptId() == null ? 0 : getReceiveRequestAttemptId().hashCode());
    return hashCode;
  }
  
  public ReceiveMessageRequest clone()
  {
    return (ReceiveMessageRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ReceiveMessageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */