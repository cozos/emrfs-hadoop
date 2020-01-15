package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListAttachedGroupPoliciesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<AttachedPolicy> attachedPolicies;
  private Boolean isTruncated;
  private String marker;
  
  public List<AttachedPolicy> getAttachedPolicies()
  {
    if (attachedPolicies == null) {
      attachedPolicies = new SdkInternalList();
    }
    return attachedPolicies;
  }
  
  public void setAttachedPolicies(Collection<AttachedPolicy> attachedPolicies)
  {
    if (attachedPolicies == null)
    {
      this.attachedPolicies = null;
      return;
    }
    this.attachedPolicies = new SdkInternalList(attachedPolicies);
  }
  
  public ListAttachedGroupPoliciesResult withAttachedPolicies(AttachedPolicy... attachedPolicies)
  {
    if (this.attachedPolicies == null) {
      setAttachedPolicies(new SdkInternalList(attachedPolicies.length));
    }
    for (AttachedPolicy ele : attachedPolicies) {
      this.attachedPolicies.add(ele);
    }
    return this;
  }
  
  public ListAttachedGroupPoliciesResult withAttachedPolicies(Collection<AttachedPolicy> attachedPolicies)
  {
    setAttachedPolicies(attachedPolicies);
    return this;
  }
  
  public void setIsTruncated(Boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public Boolean getIsTruncated()
  {
    return isTruncated;
  }
  
  public ListAttachedGroupPoliciesResult withIsTruncated(Boolean isTruncated)
  {
    setIsTruncated(isTruncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListAttachedGroupPoliciesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttachedPolicies() != null) {
      sb.append("AttachedPolicies: ").append(getAttachedPolicies()).append(",");
    }
    if (getIsTruncated() != null) {
      sb.append("IsTruncated: ").append(getIsTruncated()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof ListAttachedGroupPoliciesResult)) {
      return false;
    }
    ListAttachedGroupPoliciesResult other = (ListAttachedGroupPoliciesResult)obj;
    if (((other.getAttachedPolicies() == null ? 1 : 0) ^ (getAttachedPolicies() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttachedPolicies() != null) && (!other.getAttachedPolicies().equals(getAttachedPolicies()))) {
      return false;
    }
    if (((other.getIsTruncated() == null ? 1 : 0) ^ (getIsTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsTruncated() != null) && (!other.getIsTruncated().equals(getIsTruncated()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAttachedPolicies() == null ? 0 : getAttachedPolicies().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListAttachedGroupPoliciesResult clone()
  {
    try
    {
      return (ListAttachedGroupPoliciesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */