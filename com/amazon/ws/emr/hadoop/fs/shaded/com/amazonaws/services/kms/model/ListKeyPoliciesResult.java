package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListKeyPoliciesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<String> policyNames;
  private String nextMarker;
  private Boolean truncated;
  
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
  
  public ListKeyPoliciesResult withPolicyNames(String... policyNames)
  {
    if (this.policyNames == null) {
      setPolicyNames(new SdkInternalList(policyNames.length));
    }
    for (String ele : policyNames) {
      this.policyNames.add(ele);
    }
    return this;
  }
  
  public ListKeyPoliciesResult withPolicyNames(Collection<String> policyNames)
  {
    setPolicyNames(policyNames);
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
  
  public ListKeyPoliciesResult withNextMarker(String nextMarker)
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
  
  public ListKeyPoliciesResult withTruncated(Boolean truncated)
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
    if (getPolicyNames() != null) {
      sb.append("PolicyNames: ").append(getPolicyNames()).append(",");
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
    if (!(obj instanceof ListKeyPoliciesResult)) {
      return false;
    }
    ListKeyPoliciesResult other = (ListKeyPoliciesResult)obj;
    if (((other.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyNames() != null) && (!other.getPolicyNames().equals(getPolicyNames()))) {
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
    
    hashCode = 31 * hashCode + (getPolicyNames() == null ? 0 : getPolicyNames().hashCode());
    hashCode = 31 * hashCode + (getNextMarker() == null ? 0 : getNextMarker().hashCode());
    hashCode = 31 * hashCode + (getTruncated() == null ? 0 : getTruncated().hashCode());
    return hashCode;
  }
  
  public ListKeyPoliciesResult clone()
  {
    try
    {
      return (ListKeyPoliciesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeyPoliciesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */