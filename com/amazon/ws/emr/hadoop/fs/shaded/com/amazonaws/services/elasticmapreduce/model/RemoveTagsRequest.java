package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class RemoveTagsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceId;
  private SdkInternalList<String> tagKeys;
  
  public RemoveTagsRequest() {}
  
  public RemoveTagsRequest(String resourceId)
  {
    setResourceId(resourceId);
  }
  
  public RemoveTagsRequest(String resourceId, List<String> tagKeys)
  {
    setResourceId(resourceId);
    setTagKeys(tagKeys);
  }
  
  public void setResourceId(String resourceId)
  {
    this.resourceId = resourceId;
  }
  
  public String getResourceId()
  {
    return resourceId;
  }
  
  public RemoveTagsRequest withResourceId(String resourceId)
  {
    setResourceId(resourceId);
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
  
  public RemoveTagsRequest withTagKeys(String... tagKeys)
  {
    if (this.tagKeys == null) {
      setTagKeys(new SdkInternalList(tagKeys.length));
    }
    for (String ele : tagKeys) {
      this.tagKeys.add(ele);
    }
    return this;
  }
  
  public RemoveTagsRequest withTagKeys(Collection<String> tagKeys)
  {
    setTagKeys(tagKeys);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResourceId() != null) {
      sb.append("ResourceId: ").append(getResourceId()).append(",");
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
    if (!(obj instanceof RemoveTagsRequest)) {
      return false;
    }
    RemoveTagsRequest other = (RemoveTagsRequest)obj;
    if (((other.getResourceId() == null ? 1 : 0) ^ (getResourceId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceId() != null) && (!other.getResourceId().equals(getResourceId()))) {
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
    
    hashCode = 31 * hashCode + (getResourceId() == null ? 0 : getResourceId().hashCode());
    hashCode = 31 * hashCode + (getTagKeys() == null ? 0 : getTagKeys().hashCode());
    return hashCode;
  }
  
  public RemoveTagsRequest clone()
  {
    return (RemoveTagsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */