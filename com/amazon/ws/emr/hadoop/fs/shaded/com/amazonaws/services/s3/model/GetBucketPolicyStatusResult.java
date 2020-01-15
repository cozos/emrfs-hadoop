package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class GetBucketPolicyStatusResult
  implements Serializable, Cloneable
{
  private PolicyStatus policyStatus;
  
  public PolicyStatus getPolicyStatus()
  {
    return policyStatus;
  }
  
  public void setPolicyStatus(PolicyStatus policyStatus)
  {
    this.policyStatus = policyStatus;
  }
  
  public GetBucketPolicyStatusResult withPolicyStatus(PolicyStatus policyStatus)
  {
    setPolicyStatus(policyStatus);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    GetBucketPolicyStatusResult that = (GetBucketPolicyStatusResult)o;
    
    return policyStatus == null ? true : policyStatus != null ? policyStatus.equals(policyStatus) : false;
  }
  
  public int hashCode()
  {
    return policyStatus != null ? policyStatus.hashCode() : 0;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyStatus() != null) {
      sb.append("PolicyStatus: ").append(getPolicyStatus()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public GetBucketPolicyStatusResult clone()
  {
    try
    {
      return (GetBucketPolicyStatusResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketPolicyStatusResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */