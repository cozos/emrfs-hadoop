package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class AttachedPolicy
  implements Serializable, Cloneable
{
  private String policyName;
  private String policyArn;
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public AttachedPolicy withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setPolicyArn(String policyArn)
  {
    this.policyArn = policyArn;
  }
  
  public String getPolicyArn()
  {
    return policyArn;
  }
  
  public AttachedPolicy withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
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
    if (!(obj instanceof AttachedPolicy)) {
      return false;
    }
    AttachedPolicy other = (AttachedPolicy)obj;
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    return hashCode;
  }
  
  public AttachedPolicy clone()
  {
    try
    {
      return (AttachedPolicy)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */