package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssumeRoleWithWebIdentityRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleArn;
  private String roleSessionName;
  private String webIdentityToken;
  private String providerId;
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
  
  public AssumeRoleWithWebIdentityRequest withRoleArn(String roleArn)
  {
    setRoleArn(roleArn);
    return this;
  }
  
  public void setRoleSessionName(String roleSessionName)
  {
    this.roleSessionName = roleSessionName;
  }
  
  public String getRoleSessionName()
  {
    return roleSessionName;
  }
  
  public AssumeRoleWithWebIdentityRequest withRoleSessionName(String roleSessionName)
  {
    setRoleSessionName(roleSessionName);
    return this;
  }
  
  public void setWebIdentityToken(String webIdentityToken)
  {
    this.webIdentityToken = webIdentityToken;
  }
  
  public String getWebIdentityToken()
  {
    return webIdentityToken;
  }
  
  public AssumeRoleWithWebIdentityRequest withWebIdentityToken(String webIdentityToken)
  {
    setWebIdentityToken(webIdentityToken);
    return this;
  }
  
  public void setProviderId(String providerId)
  {
    this.providerId = providerId;
  }
  
  public String getProviderId()
  {
    return providerId;
  }
  
  public AssumeRoleWithWebIdentityRequest withProviderId(String providerId)
  {
    setProviderId(providerId);
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
  
  public AssumeRoleWithWebIdentityRequest withPolicyArns(PolicyDescriptorType... policyArns)
  {
    if (this.policyArns == null) {
      setPolicyArns(new ArrayList(policyArns.length));
    }
    for (PolicyDescriptorType ele : policyArns) {
      this.policyArns.add(ele);
    }
    return this;
  }
  
  public AssumeRoleWithWebIdentityRequest withPolicyArns(Collection<PolicyDescriptorType> policyArns)
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
  
  public AssumeRoleWithWebIdentityRequest withPolicy(String policy)
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
  
  public AssumeRoleWithWebIdentityRequest withDurationSeconds(Integer durationSeconds)
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
    if (getRoleSessionName() != null) {
      sb.append("RoleSessionName: ").append(getRoleSessionName()).append(",");
    }
    if (getWebIdentityToken() != null) {
      sb.append("WebIdentityToken: ").append(getWebIdentityToken()).append(",");
    }
    if (getProviderId() != null) {
      sb.append("ProviderId: ").append(getProviderId()).append(",");
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
    if (!(obj instanceof AssumeRoleWithWebIdentityRequest)) {
      return false;
    }
    AssumeRoleWithWebIdentityRequest other = (AssumeRoleWithWebIdentityRequest)obj;
    if (((other.getRoleArn() == null ? 1 : 0) ^ (getRoleArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleArn() != null) && (!other.getRoleArn().equals(getRoleArn()))) {
      return false;
    }
    if (((other.getRoleSessionName() == null ? 1 : 0) ^ (getRoleSessionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleSessionName() != null) && (!other.getRoleSessionName().equals(getRoleSessionName()))) {
      return false;
    }
    if (((other.getWebIdentityToken() == null ? 1 : 0) ^ (getWebIdentityToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWebIdentityToken() != null) && (!other.getWebIdentityToken().equals(getWebIdentityToken()))) {
      return false;
    }
    if (((other.getProviderId() == null ? 1 : 0) ^ (getProviderId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProviderId() != null) && (!other.getProviderId().equals(getProviderId()))) {
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
    hashCode = 31 * hashCode + (getRoleSessionName() == null ? 0 : getRoleSessionName().hashCode());
    hashCode = 31 * hashCode + (getWebIdentityToken() == null ? 0 : getWebIdentityToken().hashCode());
    hashCode = 31 * hashCode + (getProviderId() == null ? 0 : getProviderId().hashCode());
    hashCode = 31 * hashCode + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode());
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    hashCode = 31 * hashCode + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode());
    return hashCode;
  }
  
  public AssumeRoleWithWebIdentityRequest clone()
  {
    return (AssumeRoleWithWebIdentityRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */