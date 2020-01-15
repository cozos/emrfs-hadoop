package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class PutUserPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String policyName;
  private String policyDocument;
  
  public PutUserPolicyRequest() {}
  
  public PutUserPolicyRequest(String userName, String policyName, String policyDocument)
  {
    setUserName(userName);
    setPolicyName(policyName);
    setPolicyDocument(policyDocument);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public PutUserPolicyRequest withUserName(String userName)
  {
    setUserName(userName);
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
  
  public PutUserPolicyRequest withPolicyName(String policyName)
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
  
  public PutUserPolicyRequest withPolicyDocument(String policyDocument)
  {
    setPolicyDocument(policyDocument);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
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
    if (!(obj instanceof PutUserPolicyRequest)) {
      return false;
    }
    PutUserPolicyRequest other = (PutUserPolicyRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
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
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPolicyDocument() == null ? 0 : getPolicyDocument().hashCode());
    return hashCode;
  }
  
  public PutUserPolicyRequest clone()
  {
    return (PutUserPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */