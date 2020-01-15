package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssumeRoleRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleArn;
  private String roleSessionName;
  private List<PolicyDescriptorType> policyArns;
  private String policy;
  private Integer durationSeconds;
  private String externalId;
  private String serialNumber;
  private String tokenCode;
  
  public void setRoleArn(String roleArn)
  {
    this.roleArn = roleArn;
  }
  
  public String getRoleArn()
  {
    return roleArn;
  }
  
  public AssumeRoleRequest withRoleArn(String roleArn)
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
  
  public AssumeRoleRequest withRoleSessionName(String roleSessionName)
  {
    setRoleSessionName(roleSessionName);
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
  
  public AssumeRoleRequest withPolicyArns(PolicyDescriptorType... policyArns)
  {
    if (this.policyArns == null) {
      setPolicyArns(new ArrayList(policyArns.length));
    }
    for (PolicyDescriptorType ele : policyArns) {
      this.policyArns.add(ele);
    }
    return this;
  }
  
  public AssumeRoleRequest withPolicyArns(Collection<PolicyDescriptorType> policyArns)
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
  
  public AssumeRoleRequest withPolicy(String policy)
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
  
  public AssumeRoleRequest withDurationSeconds(Integer durationSeconds)
  {
    setDurationSeconds(durationSeconds);
    return this;
  }
  
  public void setExternalId(String externalId)
  {
    this.externalId = externalId;
  }
  
  public String getExternalId()
  {
    return externalId;
  }
  
  public AssumeRoleRequest withExternalId(String externalId)
  {
    setExternalId(externalId);
    return this;
  }
  
  public void setSerialNumber(String serialNumber)
  {
    this.serialNumber = serialNumber;
  }
  
  public String getSerialNumber()
  {
    return serialNumber;
  }
  
  public AssumeRoleRequest withSerialNumber(String serialNumber)
  {
    setSerialNumber(serialNumber);
    return this;
  }
  
  public void setTokenCode(String tokenCode)
  {
    this.tokenCode = tokenCode;
  }
  
  public String getTokenCode()
  {
    return tokenCode;
  }
  
  public AssumeRoleRequest withTokenCode(String tokenCode)
  {
    setTokenCode(tokenCode);
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
    if (getPolicyArns() != null) {
      sb.append("PolicyArns: ").append(getPolicyArns()).append(",");
    }
    if (getPolicy() != null) {
      sb.append("Policy: ").append(getPolicy()).append(",");
    }
    if (getDurationSeconds() != null) {
      sb.append("DurationSeconds: ").append(getDurationSeconds()).append(",");
    }
    if (getExternalId() != null) {
      sb.append("ExternalId: ").append(getExternalId()).append(",");
    }
    if (getSerialNumber() != null) {
      sb.append("SerialNumber: ").append(getSerialNumber()).append(",");
    }
    if (getTokenCode() != null) {
      sb.append("TokenCode: ").append(getTokenCode());
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
    if (!(obj instanceof AssumeRoleRequest)) {
      return false;
    }
    AssumeRoleRequest other = (AssumeRoleRequest)obj;
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
    if (((other.getExternalId() == null ? 1 : 0) ^ (getExternalId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExternalId() != null) && (!other.getExternalId().equals(getExternalId()))) {
      return false;
    }
    if (((other.getSerialNumber() == null ? 1 : 0) ^ (getSerialNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSerialNumber() != null) && (!other.getSerialNumber().equals(getSerialNumber()))) {
      return false;
    }
    if (((other.getTokenCode() == null ? 1 : 0) ^ (getTokenCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTokenCode() != null) && (!other.getTokenCode().equals(getTokenCode()))) {
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
    hashCode = 31 * hashCode + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode());
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    hashCode = 31 * hashCode + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode());
    hashCode = 31 * hashCode + (getExternalId() == null ? 0 : getExternalId().hashCode());
    hashCode = 31 * hashCode + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode());
    hashCode = 31 * hashCode + (getTokenCode() == null ? 0 : getTokenCode().hashCode());
    return hashCode;
  }
  
  public AssumeRoleRequest clone()
  {
    return (AssumeRoleRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */