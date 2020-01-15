package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListUserPoliciesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<String> policyNames;
  private Boolean isTruncated;
  private String marker;
  
  public List<String> getPolicyNames()
  {
    if (policyNames == null) {
      policyNames = new SdkInternalList();
    }
    return policyNames;
  }
  
  public void setPolicyNames(Collection<String> policyNames)
  {
    if (policyNames == null)
    {
      this.policyNames = null;
      return;
    }
    this.policyNames = new SdkInternalList(policyNames);
  }
  
  public ListUserPoliciesResult withPolicyNames(String... policyNames)
  {
    if (this.policyNames == null) {
      setPolicyNames(new SdkInternalList(policyNames.length));
    }
    for (String ele : policyNames) {
      this.policyNames.add(ele);
    }
    return this;
  }
  
  public ListUserPoliciesResult withPolicyNames(Collection<String> policyNames)
  {
    setPolicyNames(policyNames);
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
  
  public ListUserPoliciesResult withIsTruncated(Boolean isTruncated)
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
  
  public ListUserPoliciesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyNames() != null) {
      sb.append("PolicyNames: ").append(getPolicyNames()).append(",");
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
    if (!(obj instanceof ListUserPoliciesResult)) {
      return false;
    }
    ListUserPoliciesResult other = (ListUserPoliciesResult)obj;
    if (((other.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyNames() != null) && (!other.getPolicyNames().equals(getPolicyNames()))) {
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
    
    hashCode = 31 * hashCode + (getPolicyNames() == null ? 0 : getPolicyNames().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListUserPoliciesResult clone()
  {
    try
    {
      return (ListUserPoliciesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserPoliciesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */