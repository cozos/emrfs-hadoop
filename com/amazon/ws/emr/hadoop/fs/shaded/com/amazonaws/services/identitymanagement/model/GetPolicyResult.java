package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetPolicyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Policy policy;
  
  public void setPolicy(Policy policy)
  {
    this.policy = policy;
  }
  
  public Policy getPolicy()
  {
    return policy;
  }
  
  public GetPolicyResult withPolicy(Policy policy)
  {
    setPolicy(policy);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicy() != null) {
      sb.append("Policy: ").append(getPolicy());
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
    if (!(obj instanceof GetPolicyResult)) {
      return false;
    }
    GetPolicyResult other = (GetPolicyResult)obj;
    if (((other.getPolicy() == null ? 1 : 0) ^ (getPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicy() != null) && (!other.getPolicy().equals(getPolicy()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    return hashCode;
  }
  
  public GetPolicyResult clone()
  {
    try
    {
      return (GetPolicyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */