package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListGrantsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<GrantListEntry> grants;
  private String nextMarker;
  private Boolean truncated;
  
  public List<GrantListEntry> getGrants()
  {
    if (grants == null) {
      grants = new SdkInternalList();
    }
    return grants;
  }
  
  public void setGrants(Collection<GrantListEntry> grants)
  {
    if (grants == null)
    {
      this.grants = null;
      return;
    }
    this.grants = new SdkInternalList(grants);
  }
  
  public ListGrantsResult withGrants(GrantListEntry... grants)
  {
    if (this.grants == null) {
      setGrants(new SdkInternalList(grants.length));
    }
    for (GrantListEntry ele : grants) {
      this.grants.add(ele);
    }
    return this;
  }
  
  public ListGrantsResult withGrants(Collection<GrantListEntry> grants)
  {
    setGrants(grants);
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
  
  public ListGrantsResult withNextMarker(String nextMarker)
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
  
  public ListGrantsResult withTruncated(Boolean truncated)
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
    if (getGrants() != null) {
      sb.append("Grants: ").append(getGrants()).append(",");
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
    if (!(obj instanceof ListGrantsResult)) {
      return false;
    }
    ListGrantsResult other = (ListGrantsResult)obj;
    if (((other.getGrants() == null ? 1 : 0) ^ (getGrants() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrants() != null) && (!other.getGrants().equals(getGrants()))) {
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
    
    hashCode = 31 * hashCode + (getGrants() == null ? 0 : getGrants().hashCode());
    hashCode = 31 * hashCode + (getNextMarker() == null ? 0 : getNextMarker().hashCode());
    hashCode = 31 * hashCode + (getTruncated() == null ? 0 : getTruncated().hashCode());
    return hashCode;
  }
  
  public ListGrantsResult clone()
  {
    try
    {
      return (ListGrantsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListGrantsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */