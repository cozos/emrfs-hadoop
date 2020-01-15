package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class TagResourceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceARN;
  private SdkInternalList<Tag> tags;
  
  public void setResourceARN(String resourceARN)
  {
    this.resourceARN = resourceARN;
  }
  
  public String getResourceARN()
  {
    return resourceARN;
  }
  
  public TagResourceRequest withResourceARN(String resourceARN)
  {
    setResourceARN(resourceARN);
    return this;
  }
  
  public List<Tag> getTags()
  {
    if (tags == null) {
      tags = new SdkInternalList();
    }
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new SdkInternalList(tags);
  }
  
  public TagResourceRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public TagResourceRequest withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResourceARN() != null) {
      sb.append("ResourceARN: ").append(getResourceARN()).append(",");
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
    if (!(obj instanceof TagResourceRequest)) {
      return false;
    }
    TagResourceRequest other = (TagResourceRequest)obj;
    if (((other.getResourceARN() == null ? 1 : 0) ^ (getResourceARN() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceARN() != null) && (!other.getResourceARN().equals(getResourceARN()))) {
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
    
    hashCode = 31 * hashCode + (getResourceARN() == null ? 0 : getResourceARN().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public TagResourceRequest clone()
  {
    return (TagResourceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */