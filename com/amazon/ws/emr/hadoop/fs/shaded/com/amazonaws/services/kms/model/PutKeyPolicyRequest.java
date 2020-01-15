package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class PutKeyPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private String policyName;
  private String policy;
  private Boolean bypassPolicyLockoutSafetyCheck;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public PutKeyPolicyRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public PutKeyPolicyRequest withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setPolicy(String policy)
  {
    this.policy = policy;
  }
  
  public String getPolicy()
  {
    return policy;
  }
  
  public PutKeyPolicyRequest withPolicy(String policy)
  {
    setPolicy(policy);
    return this;
  }
  
  public void setBypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck)
  {
    this.bypassPolicyLockoutSafetyCheck = bypassPolicyLockoutSafetyCheck;
  }
  
  public Boolean getBypassPolicyLockoutSafetyCheck()
  {
    return bypassPolicyLockoutSafetyCheck;
  }
  
  public PutKeyPolicyRequest withBypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck)
  {
    setBypassPolicyLockoutSafetyCheck(bypassPolicyLockoutSafetyCheck);
    return this;
  }
  
  public Boolean isBypassPolicyLockoutSafetyCheck()
  {
    return bypassPolicyLockoutSafetyCheck;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
    if (getPolicy() != null) {
      sb.append("Policy: ").append(getPolicy()).append(",");
    }
    if (getBypassPolicyLockoutSafetyCheck() != null) {
      sb.append("BypassPolicyLockoutSafetyCheck: ").append(getBypassPolicyLockoutSafetyCheck());
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
    if (!(obj instanceof PutKeyPolicyRequest)) {
      return false;
    }
    PutKeyPolicyRequest other = (PutKeyPolicyRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    if (((other.getPolicy() == null ? 1 : 0) ^ (getPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicy() != null) && (!other.getPolicy().equals(getPolicy()))) {
      return false;
    }
    if (((other.getBypassPolicyLockoutSafetyCheck() == null ? 1 : 0) ^ (getBypassPolicyLockoutSafetyCheck() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBypassPolicyLockoutSafetyCheck() != null) && 
      (!other.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    hashCode = 31 * hashCode + (getBypassPolicyLockoutSafetyCheck() == null ? 0 : getBypassPolicyLockoutSafetyCheck().hashCode());
    return hashCode;
  }
  
  public PutKeyPolicyRequest clone()
  {
    return (PutKeyPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */