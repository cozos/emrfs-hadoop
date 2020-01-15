package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AddTagsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceId;
  private SdkInternalList<Tag> tags;
  
  public AddTagsRequest() {}
  
  public AddTagsRequest(String resourceId)
  {
    setResourceId(resourceId);
  }
  
  public AddTagsRequest(String resourceId, List<Tag> tags)
  {
    setResourceId(resourceId);
    setTags(tags);
  }
  
  public void setResourceId(String resourceId)
  {
    this.resourceId = resourceId;
  }
  
  public String getResourceId()
  {
    return resourceId;
  }
  
  public AddTagsRequest withResourceId(String resourceId)
  {
    setResourceId(resourceId);
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
  
  public AddTagsRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public AddTagsRequest withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResourceId() != null) {
      sb.append("ResourceId: ").append(getResourceId()).append(",");
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
    if (!(obj instanceof AddTagsRequest)) {
      return false;
    }
    AddTagsRequest other = (AddTagsRequest)obj;
    if (((other.getResourceId() == null ? 1 : 0) ^ (getResourceId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceId() != null) && (!other.getResourceId().equals(getResourceId()))) {
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
    
    hashCode = 31 * hashCode + (getResourceId() == null ? 0 : getResourceId().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public AddTagsRequest clone()
  {
    return (AddTagsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */