package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class UntagUserRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private SdkInternalList<String> tagKeys;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UntagUserRequest withUserName(String userName)
  {
    setUserName(userName);
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
  
  public UntagUserRequest withTagKeys(String... tagKeys)
  {
    if (this.tagKeys == null) {
      setTagKeys(new SdkInternalList(tagKeys.length));
    }
    for (String ele : tagKeys) {
      this.tagKeys.add(ele);
    }
    return this;
  }
  
  public UntagUserRequest withTagKeys(Collection<String> tagKeys)
  {
    setTagKeys(tagKeys);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
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
    if (!(obj instanceof UntagUserRequest)) {
      return false;
    }
    UntagUserRequest other = (UntagUserRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
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
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getTagKeys() == null ? 0 : getTagKeys().hashCode());
    return hashCode;
  }
  
  public UntagUserRequest clone()
  {
    return (UntagUserRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagUserRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */