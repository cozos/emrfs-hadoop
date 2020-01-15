package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TagResourceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceArn;
  private List<Tag> tags;
  
  public void setResourceArn(String resourceArn)
  {
    this.resourceArn = resourceArn;
  }
  
  public String getResourceArn()
  {
    return resourceArn;
  }
  
  public TagResourceRequest withResourceArn(String resourceArn)
  {
    setResourceArn(resourceArn);
    return this;
  }
  
  public List<Tag> getTags()
  {
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new ArrayList(tags);
  }
  
  public TagResourceRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new ArrayList(tags.length));
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
    if (getResourceArn() != null) {
      sb.append("ResourceArn: ").append(getResourceArn()).append(",");
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
    if (((other.getResourceArn() == null ? 1 : 0) ^ (getResourceArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceArn() != null) && (!other.getResourceArn().equals(getResourceArn()))) {
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
    
    hashCode = 31 * hashCode + (getResourceArn() == null ? 0 : getResourceArn().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public TagResourceRequest clone()
  {
    return (TagResourceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TagResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */