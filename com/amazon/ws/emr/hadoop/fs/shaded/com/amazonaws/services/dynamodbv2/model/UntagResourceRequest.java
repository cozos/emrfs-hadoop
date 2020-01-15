package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UntagResourceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceArn;
  private List<String> tagKeys;
  
  public void setResourceArn(String resourceArn)
  {
    this.resourceArn = resourceArn;
  }
  
  public String getResourceArn()
  {
    return resourceArn;
  }
  
  public UntagResourceRequest withResourceArn(String resourceArn)
  {
    setResourceArn(resourceArn);
    return this;
  }
  
  public List<String> getTagKeys()
  {
    return tagKeys;
  }
  
  public void setTagKeys(Collection<String> tagKeys)
  {
    if (tagKeys == null)
    {
      this.tagKeys = null;
      return;
    }
    this.tagKeys = new ArrayList(tagKeys);
  }
  
  public UntagResourceRequest withTagKeys(String... tagKeys)
  {
    if (this.tagKeys == null) {
      setTagKeys(new ArrayList(tagKeys.length));
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
    if (getResourceArn() != null) {
      sb.append("ResourceArn: ").append(getResourceArn()).append(",");
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
    if (((other.getResourceArn() == null ? 1 : 0) ^ (getResourceArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceArn() != null) && (!other.getResourceArn().equals(getResourceArn()))) {
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
    
    hashCode = 31 * hashCode + (getResourceArn() == null ? 0 : getResourceArn().hashCode());
    hashCode = 31 * hashCode + (getTagKeys() == null ? 0 : getTagKeys().hashCode());
    return hashCode;
  }
  
  public UntagResourceRequest clone()
  {
    return (UntagResourceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */