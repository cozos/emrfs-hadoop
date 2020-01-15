package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class UntagQueueRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalList<String> tagKeys;
  
  public UntagQueueRequest() {}
  
  public UntagQueueRequest(String queueUrl, List<String> tagKeys)
  {
    setQueueUrl(queueUrl);
    setTagKeys(tagKeys);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public UntagQueueRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public List<String> getTagKeys()
  {
    if (tagKeys == null) {
      tagKeys = new SdkInternalList();
    }
    return tagKeys;
  }
  
  public void setTagKeys(Collection<String> tagKeys)
  {
    if (tagKeys == null)
    {
      this.tagKeys = null;
      return;
    }
    this.tagKeys = new SdkInternalList(tagKeys);
  }
  
  public UntagQueueRequest withTagKeys(String... tagKeys)
  {
    if (this.tagKeys == null) {
      setTagKeys(new SdkInternalList(tagKeys.length));
    }
    for (String ele : tagKeys) {
      this.tagKeys.add(ele);
    }
    return this;
  }
  
  public UntagQueueRequest withTagKeys(Collection<String> tagKeys)
  {
    setTagKeys(tagKeys);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getTagKeys() != null) {
      sb.append("TagKeys: ").append(getTagKeys());
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
    if (!(obj instanceof UntagQueueRequest)) {
      return false;
    }
    UntagQueueRequest other = (UntagQueueRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getTagKeys() == null ? 1 : 0) ^ (getTagKeys() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTagKeys() != null) && (!other.getTagKeys().equals(getTagKeys()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getTagKeys() == null ? 0 : getTagKeys().hashCode());
    return hashCode;
  }
  
  public UntagQueueRequest clone()
  {
    return (UntagQueueRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.UntagQueueRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */