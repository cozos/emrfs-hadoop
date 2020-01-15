package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListTagsForResourceResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<Tag> tags;
  
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
  
  public ListTagsForResourceResult withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public ListTagsForResourceResult withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof ListTagsForResourceResult)) {
      return false;
    }
    ListTagsForResourceResult other = (ListTagsForResourceResult)obj;
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
    
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public ListTagsForResourceResult clone()
  {
    try
    {
      return (ListTagsForResourceResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */