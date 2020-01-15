package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetContextKeysForPrincipalPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policySourceArn;
  private SdkInternalList<String> policyInputList;
  
  public void setPolicySourceArn(String policySourceArn)
  {
    this.policySourceArn = policySourceArn;
  }
  
  public String getPolicySourceArn()
  {
    return policySourceArn;
  }
  
  public GetContextKeysForPrincipalPolicyRequest withPolicySourceArn(String policySourceArn)
  {
    setPolicySourceArn(policySourceArn);
    return this;
  }
  
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
  
  public GetContextKeysForPrincipalPolicyRequest withPolicyInputList(String... policyInputList)
  {
    if (this.policyInputList == null) {
      setPolicyInputList(new SdkInternalList(policyInputList.length));
    }
    for (String ele : policyInputList) {
      this.policyInputList.add(ele);
    }
    return this;
  }
  
  public GetContextKeysForPrincipalPolicyRequest withPolicyInputList(Collection<String> policyInputList)
  {
    setPolicyInputList(policyInputList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicySourceArn() != null) {
      sb.append("PolicySourceArn: ").append(getPolicySourceArn()).append(",");
    }
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
    if (!(obj instanceof GetContextKeysForPrincipalPolicyRequest)) {
      return false;
    }
    GetContextKeysForPrincipalPolicyRequest other = (GetContextKeysForPrincipalPolicyRequest)obj;
    if (((other.getPolicySourceArn() == null ? 1 : 0) ^ (getPolicySourceArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicySourceArn() != null) && (!other.getPolicySourceArn().equals(getPolicySourceArn()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getPolicySourceArn() == null ? 0 : getPolicySourceArn().hashCode());
    hashCode = 31 * hashCode + (getPolicyInputList() == null ? 0 : getPolicyInputList().hashCode());
    return hashCode;
  }
  
  public GetContextKeysForPrincipalPolicyRequest clone()
  {
    return (GetContextKeysForPrincipalPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */