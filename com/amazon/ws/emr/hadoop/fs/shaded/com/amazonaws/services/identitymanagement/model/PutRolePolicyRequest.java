package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class PutRolePolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleName;
  private String policyName;
  private String policyDocument;
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public String getRoleName()
  {
    return roleName;
  }
  
  public PutRolePolicyRequest withRoleName(String roleName)
  {
    setRoleName(roleName);
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
  
  public PutRolePolicyRequest withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setPolicyDocument(String policyDocument)
  {
    this.policyDocument = policyDocument;
  }
  
  public String getPolicyDocument()
  {
    return policyDocument;
  }
  
  public PutRolePolicyRequest withPolicyDocument(String policyDocument)
  {
    setPolicyDocument(policyDocument);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRoleName() != null) {
      sb.append("RoleName: ").append(getRoleName()).append(",");
    }
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
    if (getPolicyDocument() != null) {
      sb.append("PolicyDocument: ").append(getPolicyDocument());
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
    if (!(obj instanceof PutRolePolicyRequest)) {
      return false;
    }
    PutRolePolicyRequest other = (PutRolePolicyRequest)obj;
    if (((other.getRoleName() == null ? 1 : 0) ^ (getRoleName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleName() != null) && (!other.getRoleName().equals(getRoleName()))) {
      return false;
    }
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    if (((other.getPolicyDocument() == null ? 1 : 0) ^ (getPolicyDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyDocument() != null) && (!other.getPolicyDocument().equals(getPolicyDocument()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRoleName() == null ? 0 : getRoleName().hashCode());
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPolicyDocument() == null ? 0 : getPolicyDocument().hashCode());
    return hashCode;
  }
  
  public PutRolePolicyRequest clone()
  {
    return (PutRolePolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */