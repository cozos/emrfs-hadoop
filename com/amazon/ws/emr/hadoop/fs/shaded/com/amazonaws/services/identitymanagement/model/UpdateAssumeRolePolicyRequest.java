package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateAssumeRolePolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleName;
  private String policyDocument;
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public String getRoleName()
  {
    return roleName;
  }
  
  public UpdateAssumeRolePolicyRequest withRoleName(String roleName)
  {
    setRoleName(roleName);
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
  
  public UpdateAssumeRolePolicyRequest withPolicyDocument(String policyDocument)
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
    if (!(obj instanceof UpdateAssumeRolePolicyRequest)) {
      return false;
    }
    UpdateAssumeRolePolicyRequest other = (UpdateAssumeRolePolicyRequest)obj;
    if (((other.getRoleName() == null ? 1 : 0) ^ (getRoleName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleName() != null) && (!other.getRoleName().equals(getRoleName()))) {
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
    hashCode = 31 * hashCode + (getPolicyDocument() == null ? 0 : getPolicyDocument().hashCode());
    return hashCode;
  }
  
  public UpdateAssumeRolePolicyRequest clone()
  {
    return (UpdateAssumeRolePolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */