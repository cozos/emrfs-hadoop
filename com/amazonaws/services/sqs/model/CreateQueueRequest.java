package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class CreateQueueRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueName;
  private SdkInternalMap<String, String> attributes;
  private SdkInternalMap<String, String> tags;
  
  public CreateQueueRequest() {}
  
  public CreateQueueRequest(String queueName)
  {
    setQueueName(queueName);
  }
  
  public void setQueueName(String queueName)
  {
    this.queueName = queueName;
  }
  
  public String getQueueName()
  {
    return queueName;
  }
  
  public CreateQueueRequest withQueueName(String queueName)
  {
    setQueueName(queueName);
    return this;
  }
  
  public Map<String, String> getAttributes()
  {
    if (attributes == null) {
      attributes = new SdkInternalMap();
    }
    return attributes;
  }
  
  public void setAttributes(Map<String, String> attributes)
  {
    this.attributes = (attributes == null ? null : new SdkInternalMap(attributes));
  }
  
  public CreateQueueRequest withAttributes(Map<String, String> attributes)
  {
    setAttributes(attributes);
    return this;
  }
  
  public CreateQueueRequest addAttributesEntry(String key, String value)
  {
    if (null == attributes) {
      attributes = new SdkInternalMap();
    }
    if (attributes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    attributes.put(key, value);
    return this;
  }
  
  public CreateQueueRequest clearAttributesEntries()
  {
    attributes = null;
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
  
  public CreateQueueRequest withTags(Map<String, String> tags)
  {
    setTags(tags);
    return this;
  }
  
  public CreateQueueRequest addTagsEntry(String key, String value)
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
  
  public CreateQueueRequest clearTagsEntries()
  {
    tags = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueName() != null) {
      sb.append("QueueName: ").append(getQueueName()).append(",");
    }
    if (getAttributes() != null) {
      sb.append("Attributes: ").append(getAttributes()).append(",");
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
    if (!(obj instanceof CreateQueueRequest)) {
      return false;
    }
    CreateQueueRequest other = (CreateQueueRequest)obj;
    if (((other.getQueueName() == null ? 1 : 0) ^ (getQueueName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueName() != null) && (!other.getQueueName().equals(getQueueName()))) {
      return false;
    }
    if (((other.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributes() != null) && (!other.getAttributes().equals(getAttributes()))) {
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
    
    hashCode = 31 * hashCode + (getQueueName() == null ? 0 : getQueueName().hashCode());
    hashCode = 31 * hashCode + (getAttributes() == null ? 0 : getAttributes().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public CreateQueueRequest clone()
  {
    return (CreateQueueRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.CreateQueueRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */