package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetFederationTokenRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String name;
  private String policy;
  private List<PolicyDescriptorType> policyArns;
  private Integer durationSeconds;
  
  public GetFederationTokenRequest() {}
  
  public GetFederationTokenRequest(String name)
  {
    setName(name);
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public GetFederationTokenRequest withName(String name)
  {
    setName(name);
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
  
  public GetFederationTokenRequest withPolicy(String policy)
  {
    setPolicy(policy);
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
  
  public GetFederationTokenRequest withPolicyArns(PolicyDescriptorType... policyArns)
  {
    if (this.policyArns == null) {
      setPolicyArns(new ArrayList(policyArns.length));
    }
    for (PolicyDescriptorType ele : policyArns) {
      this.policyArns.add(ele);
    }
    return this;
  }
  
  public GetFederationTokenRequest withPolicyArns(Collection<PolicyDescriptorType> policyArns)
  {
    setPolicyArns(policyArns);
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
  
  public GetFederationTokenRequest withDurationSeconds(Integer durationSeconds)
  {
    setDurationSeconds(durationSeconds);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getPolicy() != null) {
      sb.append("Policy: ").append(getPolicy()).append(",");
    }
    if (getPolicyArns() != null) {
      sb.append("PolicyArns: ").append(getPolicyArns()).append(",");
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
    if (!(obj instanceof GetFederationTokenRequest)) {
      return false;
    }
    GetFederationTokenRequest other = (GetFederationTokenRequest)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getPolicy() == null ? 1 : 0) ^ (getPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicy() != null) && (!other.getPolicy().equals(getPolicy()))) {
      return false;
    }
    if (((other.getPolicyArns() == null ? 1 : 0) ^ (getPolicyArns() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArns() != null) && (!other.getPolicyArns().equals(getPolicyArns()))) {
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
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    hashCode = 31 * hashCode + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode());
    hashCode = 31 * hashCode + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode());
    return hashCode;
  }
  
  public GetFederationTokenRequest clone()
  {
    return (GetFederationTokenRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */