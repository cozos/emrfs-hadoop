package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetQueueAttributesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private SdkInternalList<String> attributeNames;
  
  public GetQueueAttributesRequest() {}
  
  public GetQueueAttributesRequest(String queueUrl)
  {
    setQueueUrl(queueUrl);
  }
  
  public GetQueueAttributesRequest(String queueUrl, List<String> attributeNames)
  {
    setQueueUrl(queueUrl);
    setAttributeNames(attributeNames);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public GetQueueAttributesRequest withQueueUrl(String queueUrl)
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
  
  public GetQueueAttributesRequest withAttributeNames(String... attributeNames)
  {
    if (this.attributeNames == null) {
      setAttributeNames(new SdkInternalList(attributeNames.length));
    }
    for (String ele : attributeNames) {
      this.attributeNames.add(ele);
    }
    return this;
  }
  
  public GetQueueAttributesRequest withAttributeNames(Collection<String> attributeNames)
  {
    setAttributeNames(attributeNames);
    return this;
  }
  
  public GetQueueAttributesRequest withAttributeNames(QueueAttributeName... attributeNames)
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
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getAttributeNames() != null) {
      sb.append("AttributeNames: ").append(getAttributeNames());
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
    if (!(obj instanceof GetQueueAttributesRequest)) {
      return false;
    }
    GetQueueAttributesRequest other = (GetQueueAttributesRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getAttributeNames() == null ? 0 : getAttributeNames().hashCode());
    return hashCode;
  }
  
  public GetQueueAttributesRequest clone()
  {
    return (GetQueueAttributesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.GetQueueAttributesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */