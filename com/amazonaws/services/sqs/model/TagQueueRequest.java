package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class TagQueueRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalMap<String, String> tags;
  
  public TagQueueRequest() {}
  
  public TagQueueRequest(String queueUrl, Map<String, String> tags)
  {
    setQueueUrl(queueUrl);
    setTags(tags);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public TagQueueRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public Map<String, String> getTags()
  {
    if (tags == null) {
      tags = new SdkInternalMap();
    }
    return tags;
  }
  
  public void setTags(Map<String, String> tags)
  {
    this.tags = (tags == null ? null : new SdkInternalMap(tags));
  }
  
  public TagQueueRequest withTags(Map<String, String> tags)
  {
    setTags(tags);
    return this;
  }
  
  public TagQueueRequest addTagsEntry(String key, String value)
  {
    if (null == tags) {
      tags = new SdkInternalMap();
    }
    if (tags.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    tags.put(key, value);
    return this;
  }
  
  public TagQueueRequest clearTagsEntries()
  {
    tags = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags());
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
    if (!(obj instanceof TagQueueRequest)) {
      return false;
    }
    TagQueueRequest other = (TagQueueRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public TagQueueRequest clone()
  {
    return (TagQueueRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.TagQueueRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */