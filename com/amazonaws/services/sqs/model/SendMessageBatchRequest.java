package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class SendMessageBatchRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalList<SendMessageBatchRequestEntry> entries;
  
  public SendMessageBatchRequest() {}
  
  public SendMessageBatchRequest(String queueUrl)
  {
    setQueueUrl(queueUrl);
  }
  
  public SendMessageBatchRequest(String queueUrl, List<SendMessageBatchRequestEntry> entries)
  {
    setQueueUrl(queueUrl);
    setEntries(entries);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public SendMessageBatchRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public List<SendMessageBatchRequestEntry> getEntries()
  {
    if (entries == null) {
      entries = new SdkInternalList();
    }
    return entries;
  }
  
  public void setEntries(Collection<SendMessageBatchRequestEntry> entries)
  {
    if (entries == null)
    {
      this.entries = null;
      return;
    }
    this.entries = new SdkInternalList(entries);
  }
  
  public SendMessageBatchRequest withEntries(SendMessageBatchRequestEntry... entries)
  {
    if (this.entries == null) {
      setEntries(new SdkInternalList(entries.length));
    }
    for (SendMessageBatchRequestEntry ele : entries) {
      this.entries.add(ele);
    }
    return this;
  }
  
  public SendMessageBatchRequest withEntries(Collection<SendMessageBatchRequestEntry> entries)
  {
    setEntries(entries);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getEntries() != null) {
      sb.append("Entries: ").append(getEntries());
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
    if (!(obj instanceof SendMessageBatchRequest)) {
      return false;
    }
    SendMessageBatchRequest other = (SendMessageBatchRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getEntries() == null ? 1 : 0) ^ (getEntries() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntries() != null) && (!other.getEntries().equals(getEntries()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getEntries() == null ? 0 : getEntries().hashCode());
    return hashCode;
  }
  
  public SendMessageBatchRequest clone()
  {
    return (SendMessageBatchRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.SendMessageBatchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */