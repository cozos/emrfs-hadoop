package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policyArn;
  
  public void setPolicyArn(String policyArn)
  {
    this.policyArn = policyArn;
  }
  
  public String getPolicyArn()
  {
    return policyArn;
  }
  
  public GetPolicyRequest withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyArn() != null) {
      sb.append("PolicyArn: ").append(getPolicyArn());
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
    if (!(obj instanceof GetPolicyRequest)) {
      return false;
    }
    GetPolicyRequest other = (GetPolicyRequest)obj;
    if (((other.getPolicyArn() == null ? 1 : 0) ^ (getPolicyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArn() != null) && (!other.getPolicyArn().equals(getPolicyArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    return hashCode;
  }
  
  public GetPolicyRequest clone()
  {
    return (GetPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */