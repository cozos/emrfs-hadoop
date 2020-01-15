package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class PolicyGrantingServiceAccess
  implements Serializable, Cloneable
{
  private String policyName;
  private String policyType;
  private String policyArn;
  private String entityType;
  private String entityName;
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public PolicyGrantingServiceAccess withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setPolicyType(String policyType)
  {
    this.policyType = policyType;
  }
  
  public String getPolicyType()
  {
    return policyType;
  }
  
  public PolicyGrantingServiceAccess withPolicyType(String policyType)
  {
    setPolicyType(policyType);
    return this;
  }
  
  public PolicyGrantingServiceAccess withPolicyType(PolicyType policyType)
  {
    this.policyType = policyType.toString();
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
  
  public PolicyGrantingServiceAccess withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
    return this;
  }
  
  public void setEntityType(String entityType)
  {
    this.entityType = entityType;
  }
  
  public String getEntityType()
  {
    return entityType;
  }
  
  public PolicyGrantingServiceAccess withEntityType(String entityType)
  {
    setEntityType(entityType);
    return this;
  }
  
  public PolicyGrantingServiceAccess withEntityType(PolicyOwnerEntityType entityType)
  {
    this.entityType = entityType.toString();
    return this;
  }
  
  public void setEntityName(String entityName)
  {
    this.entityName = entityName;
  }
  
  public String getEntityName()
  {
    return entityName;
  }
  
  public PolicyGrantingServiceAccess withEntityName(String entityName)
  {
    setEntityName(entityName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
    if (getPolicyType() != null) {
      sb.append("PolicyType: ").append(getPolicyType()).append(",");
    }
    if (getPolicyArn() != null) {
      sb.append("PolicyArn: ").append(getPolicyArn()).append(",");
    }
    if (getEntityType() != null) {
      sb.append("EntityType: ").append(getEntityType()).append(",");
    }
    if (getEntityName() != null) {
      sb.append("EntityName: ").append(getEntityName());
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
    if (!(obj instanceof PolicyGrantingServiceAccess)) {
      return false;
    }
    PolicyGrantingServiceAccess other = (PolicyGrantingServiceAccess)obj;
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    if (((other.getPolicyType() == null ? 1 : 0) ^ (getPolicyType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyType() != null) && (!other.getPolicyType().equals(getPolicyType()))) {
      return false;
    }
    if (((other.getPolicyArn() == null ? 1 : 0) ^ (getPolicyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArn() != null) && (!other.getPolicyArn().equals(getPolicyArn()))) {
      return false;
    }
    if (((other.getEntityType() == null ? 1 : 0) ^ (getEntityType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntityType() != null) && (!other.getEntityType().equals(getEntityType()))) {
      return false;
    }
    if (((other.getEntityName() == null ? 1 : 0) ^ (getEntityName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntityName() != null) && (!other.getEntityName().equals(getEntityName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPolicyType() == null ? 0 : getPolicyType().hashCode());
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    hashCode = 31 * hashCode + (getEntityType() == null ? 0 : getEntityType().hashCode());
    hashCode = 31 * hashCode + (getEntityName() == null ? 0 : getEntityName().hashCode());
    return hashCode;
  }
  
  public PolicyGrantingServiceAccess clone()
  {
    try
    {
      return (PolicyGrantingServiceAccess)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyGrantingServiceAccess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */