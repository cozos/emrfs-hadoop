package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ChangeMessageVisibilityBatchRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalList<ChangeMessageVisibilityBatchRequestEntry> entries;
  
  public ChangeMessageVisibilityBatchRequest() {}
  
  public ChangeMessageVisibilityBatchRequest(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries)
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
  
  public ChangeMessageVisibilityBatchRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public List<ChangeMessageVisibilityBatchRequestEntry> getEntries()
  {
    if (entries == null) {
      entries = new SdkInternalList();
    }
    return entries;
  }
  
  public void setEntries(Collection<ChangeMessageVisibilityBatchRequestEntry> entries)
  {
    if (entries == null)
    {
      this.entries = null;
      return;
    }
    this.entries = new SdkInternalList(entries);
  }
  
  public ChangeMessageVisibilityBatchRequest withEntries(ChangeMessageVisibilityBatchRequestEntry... entries)
  {
    if (this.entries == null) {
      setEntries(new SdkInternalList(entries.length));
    }
    for (ChangeMessageVisibilityBatchRequestEntry ele : entries) {
      this.entries.add(ele);
    }
    return this;
  }
  
  public ChangeMessageVisibilityBatchRequest withEntries(Collection<ChangeMessageVisibilityBatchRequestEntry> entries)
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
    if (!(obj instanceof ChangeMessageVisibilityBatchRequest)) {
      return false;
    }
    ChangeMessageVisibilityBatchRequest other = (ChangeMessageVisibilityBatchRequest)obj;
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
  
  public ChangeMessageVisibilityBatchRequest clone()
  {
    return (ChangeMessageVisibilityBatchRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */