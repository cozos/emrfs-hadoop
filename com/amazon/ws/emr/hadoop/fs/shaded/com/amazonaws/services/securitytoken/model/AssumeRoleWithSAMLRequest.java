package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssumeRoleWithSAMLRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleArn;
  private String principalArn;
  private String sAMLAssertion;
  private List<PolicyDescriptorType> policyArns;
  private String policy;
  private Integer durationSeconds;
  
  public void setRoleArn(String roleArn)
  {
    this.roleArn = roleArn;
  }
  
  public String getRoleArn()
  {
    return roleArn;
  }
  
  public AssumeRoleWithSAMLRequest withRoleArn(String roleArn)
  {
    setRoleArn(roleArn);
    return this;
  }
  
  public void setPrincipalArn(String principalArn)
  {
    this.principalArn = principalArn;
  }
  
  public String getPrincipalArn()
  {
    return principalArn;
  }
  
  public AssumeRoleWithSAMLRequest withPrincipalArn(String principalArn)
  {
    setPrincipalArn(principalArn);
    return this;
  }
  
  public void setSAMLAssertion(String sAMLAssertion)
  {
    this.sAMLAssertion = sAMLAssertion;
  }
  
  public String getSAMLAssertion()
  {
    return sAMLAssertion;
  }
  
  public AssumeRoleWithSAMLRequest withSAMLAssertion(String sAMLAssertion)
  {
    setSAMLAssertion(sAMLAssertion);
    return this;
  }
  
  public List<PolicyDescriptorType> getPolicyArns()
  {
    return policyArns;
  }
  
  public void setPolicyArns(Collection<PolicyDescriptorType> policyArns)
  {
    if (policyArns == null)
    {
      this.policyArns = null;
      return;
    }
    this.policyArns = new ArrayList(policyArns);
  }
  
  public AssumeRoleWithSAMLRequest withPolicyArns(PolicyDescriptorType... policyArns)
  {
    if (this.policyArns == null) {
      setPolicyArns(new ArrayList(policyArns.length));
    }
    for (PolicyDescriptorType ele : policyArns) {
      this.policyArns.add(ele);
    }
    return this;
  }
  
  public AssumeRoleWithSAMLRequest withPolicyArns(Collection<PolicyDescriptorType> policyArns)
  {
    setPolicyArns(policyArns);
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
  
  public AssumeRoleWithSAMLRequest withPolicy(String policy)
  {
    setPolicy(policy);
    return this;
  }
  
  public void setDurationSeconds(Integer durationSeconds)
  {
    this.durationSeconds = durationSeconds;
  }
  
  public Integer getDurationSeconds()
  {
    return durationSeconds;
  }
  
  public AssumeRoleWithSAMLRequest withDurationSeconds(Integer durationSeconds)
  {
    setDurationSeconds(durationSeconds);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRoleArn() != null) {
      sb.append("RoleArn: ").append(getRoleArn()).append(",");
    }
    if (getPrincipalArn() != null) {
      sb.append("PrincipalArn: ").append(getPrincipalArn()).append(",");
    }
    if (getSAMLAssertion() != null) {
      sb.append("SAMLAssertion: ").append(getSAMLAssertion()).append(",");
    }
    if (getPolicyArns() != null) {
      sb.append("PolicyArns: ").append(getPolicyArns()).append(",");
    }
    if (getPolicy() != null) {
      sb.append("Policy: ").append(getPolicy()).append(",");
    }
    if (getDurationSeconds() != null) {
      sb.append("DurationSeconds: ").append(getDurationSeconds());
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
    if (!(obj instanceof AssumeRoleWithSAMLRequest)) {
      return false;
    }
    AssumeRoleWithSAMLRequest other = (AssumeRoleWithSAMLRequest)obj;
    if (((other.getRoleArn() == null ? 1 : 0) ^ (getRoleArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleArn() != null) && (!other.getRoleArn().equals(getRoleArn()))) {
      return false;
    }
    if (((other.getPrincipalArn() == null ? 1 : 0) ^ (getPrincipalArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPrincipalArn() != null) && (!other.getPrincipalArn().equals(getPrincipalArn()))) {
      return false;
    }
    if (((other.getSAMLAssertion() == null ? 1 : 0) ^ (getSAMLAssertion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLAssertion() != null) && (!other.getSAMLAssertion().equals(getSAMLAssertion()))) {
      return false;
    }
    if (((other.getPolicyArns() == null ? 1 : 0) ^ (getPolicyArns() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArns() != null) && (!other.getPolicyArns().equals(getPolicyArns()))) {
      return false;
    }
    if (((other.getPolicy() == null ? 1 : 0) ^ (getPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicy() != null) && (!other.getPolicy().equals(getPolicy()))) {
      return false;
    }
    if (((other.getDurationSeconds() == null ? 1 : 0) ^ (getDurationSeconds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDurationSeconds() != null) && (!other.getDurationSeconds().equals(getDurationSeconds()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRoleArn() == null ? 0 : getRoleArn().hashCode());
    hashCode = 31 * hashCode + (getPrincipalArn() == null ? 0 : getPrincipalArn().hashCode());
    hashCode = 31 * hashCode + (getSAMLAssertion() == null ? 0 : getSAMLAssertion().hashCode());
    hashCode = 31 * hashCode + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode());
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    hashCode = 31 * hashCode + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode());
    return hashCode;
  }
  
  public AssumeRoleWithSAMLRequest clone()
  {
    return (AssumeRoleWithSAMLRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */