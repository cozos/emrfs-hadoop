package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreatePolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policyName;
  private String path;
  private String policyDocument;
  private String description;
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public CreatePolicyRequest withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public CreatePolicyRequest withPath(String path)
  {
    setPath(path);
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
  
  public CreatePolicyRequest withPolicyDocument(String policyDocument)
  {
    setPolicyDocument(policyDocument);
    return this;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public CreatePolicyRequest withDescription(String description)
  {
    setDescription(description);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getPolicyDocument() != null) {
      sb.append("PolicyDocument: ").append(getPolicyDocument()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription());
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
    if (!(obj instanceof CreatePolicyRequest)) {
      return false;
    }
    CreatePolicyRequest other = (CreatePolicyRequest)obj;
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getPolicyDocument() == null ? 1 : 0) ^ (getPolicyDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyDocument() != null) && (!other.getPolicyDocument().equals(getPolicyDocument()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getPolicyDocument() == null ? 0 : getPolicyDocument().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    return hashCode;
  }
  
  public CreatePolicyRequest clone()
  {
    return (CreatePolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */