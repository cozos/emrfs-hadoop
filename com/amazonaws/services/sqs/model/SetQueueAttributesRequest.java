package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class SetQueueAttributesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalMap<String, String> attributes;
  
  public SetQueueAttributesRequest() {}
  
  public SetQueueAttributesRequest(String queueUrl, Map<String, String> attributes)
  {
    setQueueUrl(queueUrl);
    setAttributes(attributes);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public SetQueueAttributesRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
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
  
  public SetQueueAttributesRequest withAttributes(Map<String, String> attributes)
  {
    setAttributes(attributes);
    return this;
  }
  
  public SetQueueAttributesRequest addAttributesEntry(String key, String value)
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
  
  public SetQueueAttributesRequest clearAttributesEntries()
  {
    attributes = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getAttributes() != null) {
      sb.append("Attributes: ").append(getAttributes());
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
    if (!(obj instanceof SetQueueAttributesRequest)) {
      return false;
    }
    SetQueueAttributesRequest other = (SetQueueAttributesRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributes() != null) && (!other.getAttributes().equals(getAttributes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getAttributes() == null ? 0 : getAttributes().hashCode());
    return hashCode;
  }
  
  public SetQueueAttributesRequest clone()
  {
    return (SetQueueAttributesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.SetQueueAttributesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */