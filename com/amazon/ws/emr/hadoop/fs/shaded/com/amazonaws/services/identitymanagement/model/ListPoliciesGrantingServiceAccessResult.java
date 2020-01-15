package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListPoliciesGrantingServiceAccessResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<ListPoliciesGrantingServiceAccessEntry> policiesGrantingServiceAccess;
  private Boolean isTruncated;
  private String marker;
  
  public List<ListPoliciesGrantingServiceAccessEntry> getPoliciesGrantingServiceAccess()
  {
    if (policiesGrantingServiceAccess == null) {
      policiesGrantingServiceAccess = new SdkInternalList();
    }
    return policiesGrantingServiceAccess;
  }
  
  public void setPoliciesGrantingServiceAccess(Collection<ListPoliciesGrantingServiceAccessEntry> policiesGrantingServiceAccess)
  {
    if (policiesGrantingServiceAccess == null)
    {
      this.policiesGrantingServiceAccess = null;
      return;
    }
    this.policiesGrantingServiceAccess = new SdkInternalList(policiesGrantingServiceAccess);
  }
  
  public ListPoliciesGrantingServiceAccessResult withPoliciesGrantingServiceAccess(ListPoliciesGrantingServiceAccessEntry... policiesGrantingServiceAccess)
  {
    if (this.policiesGrantingServiceAccess == null) {
      setPoliciesGrantingServiceAccess(new SdkInternalList(policiesGrantingServiceAccess.length));
    }
    for (ListPoliciesGrantingServiceAccessEntry ele : policiesGrantingServiceAccess) {
      this.policiesGrantingServiceAccess.add(ele);
    }
    return this;
  }
  
  public ListPoliciesGrantingServiceAccessResult withPoliciesGrantingServiceAccess(Collection<ListPoliciesGrantingServiceAccessEntry> policiesGrantingServiceAccess)
  {
    setPoliciesGrantingServiceAccess(policiesGrantingServiceAccess);
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
  
  public ListPoliciesGrantingServiceAccessResult withIsTruncated(Boolean isTruncated)
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
  
  public ListPoliciesGrantingServiceAccessResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPoliciesGrantingServiceAccess() != null) {
      sb.append("PoliciesGrantingServiceAccess: ").append(getPoliciesGrantingServiceAccess()).append(",");
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
    if (!(obj instanceof ListPoliciesGrantingServiceAccessResult)) {
      return false;
    }
    ListPoliciesGrantingServiceAccessResult other = (ListPoliciesGrantingServiceAccessResult)obj;
    if (((other.getPoliciesGrantingServiceAccess() == null ? 1 : 0) ^ (getPoliciesGrantingServiceAccess() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPoliciesGrantingServiceAccess() != null) && 
      (!other.getPoliciesGrantingServiceAccess().equals(getPoliciesGrantingServiceAccess()))) {
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
    
    hashCode = 31 * hashCode + (getPoliciesGrantingServiceAccess() == null ? 0 : getPoliciesGrantingServiceAccess().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListPoliciesGrantingServiceAccessResult clone()
  {
    try
    {
      return (ListPoliciesGrantingServiceAccessResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */