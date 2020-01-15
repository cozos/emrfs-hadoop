package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteMessageRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private String receiptHandle;
  
  public DeleteMessageRequest() {}
  
  public DeleteMessageRequest(String queueUrl, String receiptHandle)
  {
    setQueueUrl(queueUrl);
    setReceiptHandle(receiptHandle);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public DeleteMessageRequest withQueueUrl(String queueUrl)
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
  
  public DeleteMessageRequest withReceiptHandle(String receiptHandle)
  {
    setReceiptHandle(receiptHandle);
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
    if (!(obj instanceof DeleteMessageRequest)) {
      return false;
    }
    DeleteMessageRequest other = (DeleteMessageRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode());
    return hashCode;
  }
  
  public DeleteMessageRequest clone()
  {
    return (DeleteMessageRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.DeleteMessageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */