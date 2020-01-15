package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetPolicyVersionResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private PolicyVersion policyVersion;
  
  public void setPolicyVersion(PolicyVersion policyVersion)
  {
    this.policyVersion = policyVersion;
  }
  
  public PolicyVersion getPolicyVersion()
  {
    return policyVersion;
  }
  
  public GetPolicyVersionResult withPolicyVersion(PolicyVersion policyVersion)
  {
    setPolicyVersion(policyVersion);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyVersion() != null) {
      sb.append("PolicyVersion: ").append(getPolicyVersion());
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
    if (!(obj instanceof GetPolicyVersionResult)) {
      return false;
    }
    GetPolicyVersionResult other = (GetPolicyVersionResult)obj;
    if (((other.getPolicyVersion() == null ? 1 : 0) ^ (getPolicyVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyVersion() != null) && (!other.getPolicyVersion().equals(getPolicyVersion()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyVersion() == null ? 0 : getPolicyVersion().hashCode());
    return hashCode;
  }
  
  public GetPolicyVersionResult clone()
  {
    try
    {
      return (GetPolicyVersionResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */