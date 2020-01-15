package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class UntagResourceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceARN;
  private SdkInternalList<String> tagKeys;
  
  public void setResourceARN(String resourceARN)
  {
    this.resourceARN = resourceARN;
  }
  
  public String getResourceARN()
  {
    return resourceARN;
  }
  
  public UntagResourceRequest withResourceARN(String resourceARN)
  {
    setResourceARN(resourceARN);
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
  
  public UntagResourceRequest withTagKeys(String... tagKeys)
  {
    if (this.tagKeys == null) {
      setTagKeys(new SdkInternalList(tagKeys.length));
    }
    for (String ele : tagKeys) {
      this.tagKeys.add(ele);
    }
    return this;
  }
  
  public UntagResourceRequest withTagKeys(Collection<String> tagKeys)
  {
    setTagKeys(tagKeys);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResourceARN() != null) {
      sb.append("ResourceARN: ").append(getResourceARN()).append(",");
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
    if (!(obj instanceof UntagResourceRequest)) {
      return false;
    }
    UntagResourceRequest other = (UntagResourceRequest)obj;
    if (((other.getResourceARN() == null ? 1 : 0) ^ (getResourceARN() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceARN() != null) && (!other.getResourceARN().equals(getResourceARN()))) {
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
    
    hashCode = 31 * hashCode + (getResourceARN() == null ? 0 : getResourceARN().hashCode());
    hashCode = 31 * hashCode + (getTagKeys() == null ? 0 : getTagKeys().hashCode());
    return hashCode;
  }
  
  public UntagResourceRequest clone()
  {
    return (UntagResourceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */