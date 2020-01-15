package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListKeysResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<KeyListEntry> keys;
  private String nextMarker;
  private Boolean truncated;
  
  public List<KeyListEntry> getKeys()
  {
    if (keys == null) {
      keys = new SdkInternalList();
    }
    return keys;
  }
  
  public void setKeys(Collection<KeyListEntry> keys)
  {
    if (keys == null)
    {
      this.keys = null;
      return;
    }
    this.keys = new SdkInternalList(keys);
  }
  
  public ListKeysResult withKeys(KeyListEntry... keys)
  {
    if (this.keys == null) {
      setKeys(new SdkInternalList(keys.length));
    }
    for (KeyListEntry ele : keys) {
      this.keys.add(ele);
    }
    return this;
  }
  
  public ListKeysResult withKeys(Collection<KeyListEntry> keys)
  {
    setKeys(keys);
    return this;
  }
  
  public void setNextMarker(String nextMarker)
  {
    this.nextMarker = nextMarker;
  }
  
  public String getNextMarker()
  {
    return nextMarker;
  }
  
  public ListKeysResult withNextMarker(String nextMarker)
  {
    setNextMarker(nextMarker);
    return this;
  }
  
  public void setTruncated(Boolean truncated)
  {
    this.truncated = truncated;
  }
  
  public Boolean getTruncated()
  {
    return truncated;
  }
  
  public ListKeysResult withTruncated(Boolean truncated)
  {
    setTruncated(truncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return truncated;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeys() != null) {
      sb.append("Keys: ").append(getKeys()).append(",");
    }
    if (getNextMarker() != null) {
      sb.append("NextMarker: ").append(getNextMarker()).append(",");
    }
    if (getTruncated() != null) {
      sb.append("Truncated: ").append(getTruncated());
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
    if (!(obj instanceof ListKeysResult)) {
      return false;
    }
    ListKeysResult other = (ListKeysResult)obj;
    if (((other.getKeys() == null ? 1 : 0) ^ (getKeys() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeys() != null) && (!other.getKeys().equals(getKeys()))) {
      return false;
    }
    if (((other.getNextMarker() == null ? 1 : 0) ^ (getNextMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextMarker() != null) && (!other.getNextMarker().equals(getNextMarker()))) {
      return false;
    }
    if (((other.getTruncated() == null ? 1 : 0) ^ (getTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTruncated() != null) && (!other.getTruncated().equals(getTruncated()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeys() == null ? 0 : getKeys().hashCode());
    hashCode = 31 * hashCode + (getNextMarker() == null ? 0 : getNextMarker().hashCode());
    hashCode = 31 * hashCode + (getTruncated() == null ? 0 : getTruncated().hashCode());
    return hashCode;
  }
  
  public ListKeysResult clone()
  {
    try
    {
      return (ListKeysResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeysResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */