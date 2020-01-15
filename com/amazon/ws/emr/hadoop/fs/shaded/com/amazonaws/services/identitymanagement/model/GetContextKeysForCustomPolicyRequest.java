package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetContextKeysForCustomPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> policyInputList;
  
  public List<String> getPolicyInputList()
  {
    if (policyInputList == null) {
      policyInputList = new SdkInternalList();
    }
    return policyInputList;
  }
  
  public void setPolicyInputList(Collection<String> policyInputList)
  {
    if (policyInputList == null)
    {
      this.policyInputList = null;
      return;
    }
    this.policyInputList = new SdkInternalList(policyInputList);
  }
  
  public GetContextKeysForCustomPolicyRequest withPolicyInputList(String... policyInputList)
  {
    if (this.policyInputList == null) {
      setPolicyInputList(new SdkInternalList(policyInputList.length));
    }
    for (String ele : policyInputList) {
      this.policyInputList.add(ele);
    }
    return this;
  }
  
  public GetContextKeysForCustomPolicyRequest withPolicyInputList(Collection<String> policyInputList)
  {
    setPolicyInputList(policyInputList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyInputList() != null) {
      sb.append("PolicyInputList: ").append(getPolicyInputList());
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
    if (!(obj instanceof GetContextKeysForCustomPolicyRequest)) {
      return false;
    }
    GetContextKeysForCustomPolicyRequest other = (GetContextKeysForCustomPolicyRequest)obj;
    if (((other.getPolicyInputList() == null ? 1 : 0) ^ (getPolicyInputList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyInputList() != null) && (!other.getPolicyInputList().equals(getPolicyInputList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyInputList() == null ? 0 : getPolicyInputList().hashCode());
    return hashCode;
  }
  
  public GetContextKeysForCustomPolicyRequest clone()
  {
    return (GetContextKeysForCustomPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */