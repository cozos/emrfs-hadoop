package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ChangeMessageVisibilityRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private String receiptHandle;
  private Integer visibilityTimeout;
  
  public ChangeMessageVisibilityRequest() {}
  
  public ChangeMessageVisibilityRequest(String queueUrl, String receiptHandle, Integer visibilityTimeout)
  {
    setQueueUrl(queueUrl);
    setReceiptHandle(receiptHandle);
    setVisibilityTimeout(visibilityTimeout);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public ChangeMessageVisibilityRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
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
  
  public ChangeMessageVisibilityRequest withReceiptHandle(String receiptHandle)
  {
    setReceiptHandle(receiptHandle);
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
  
  public ChangeMessageVisibilityRequest withVisibilityTimeout(Integer visibilityTimeout)
  {
    setVisibilityTimeout(visibilityTimeout);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getReceiptHandle() != null) {
      sb.append("ReceiptHandle: ").append(getReceiptHandle()).append(",");
    }
    if (getVisibilityTimeout() != null) {
      sb.append("VisibilityTimeout: ").append(getVisibilityTimeout());
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
    if (!(obj instanceof ChangeMessageVisibilityRequest)) {
      return false;
    }
    ChangeMessageVisibilityRequest other = (ChangeMessageVisibilityRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReceiptHandle() != null) && (!other.getReceiptHandle().equals(getReceiptHandle()))) {
      return false;
    }
    if (((other.getVisibilityTimeout() == null ? 1 : 0) ^ (getVisibilityTimeout() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVisibilityTimeout() != null) && (!other.getVisibilityTimeout().equals(getVisibilityTimeout()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode());
    hashCode = 31 * hashCode + (getVisibilityTimeout() == null ? 0 : getVisibilityTimeout().hashCode());
    return hashCode;
  }
  
  public ChangeMessageVisibilityRequest clone()
  {
    return (ChangeMessageVisibilityRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */