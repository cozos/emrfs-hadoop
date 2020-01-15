package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class ListQueueTagsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalMap<String, String> tags;
  
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
  
  public ListQueueTagsResult withTags(Map<String, String> tags)
  {
    setTags(tags);
    return this;
  }
  
  public ListQueueTagsResult addTagsEntry(String key, String value)
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
  
  public ListQueueTagsResult clearTagsEntries()
  {
    tags = null;
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
    if (!(obj instanceof ListQueueTagsResult)) {
      return false;
    }
    ListQueueTagsResult other = (ListQueueTagsResult)obj;
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
  
  public ListQueueTagsResult clone()
  {
    try
    {
      return (ListQueueTagsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ListQueueTagsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */