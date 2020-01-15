package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreatePolicyVersionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policyArn;
  private String policyDocument;
  private Boolean setAsDefault;
  
  public void setPolicyArn(String policyArn)
  {
    this.policyArn = policyArn;
  }
  
  public String getPolicyArn()
  {
    return policyArn;
  }
  
  public CreatePolicyVersionRequest withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
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
  
  public CreatePolicyVersionRequest withPolicyDocument(String policyDocument)
  {
    setPolicyDocument(policyDocument);
    return this;
  }
  
  public void setSetAsDefault(Boolean setAsDefault)
  {
    this.setAsDefault = setAsDefault;
  }
  
  public Boolean getSetAsDefault()
  {
    return setAsDefault;
  }
  
  public CreatePolicyVersionRequest withSetAsDefault(Boolean setAsDefault)
  {
    setSetAsDefault(setAsDefault);
    return this;
  }
  
  public Boolean isSetAsDefault()
  {
    return setAsDefault;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyArn() != null) {
      sb.append("PolicyArn: ").append(getPolicyArn()).append(",");
    }
    if (getPolicyDocument() != null) {
      sb.append("PolicyDocument: ").append(getPolicyDocument()).append(",");
    }
    if (getSetAsDefault() != null) {
      sb.append("SetAsDefault: ").append(getSetAsDefault());
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
    if (!(obj instanceof CreatePolicyVersionRequest)) {
      return false;
    }
    CreatePolicyVersionRequest other = (CreatePolicyVersionRequest)obj;
    if (((other.getPolicyArn() == null ? 1 : 0) ^ (getPolicyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArn() != null) && (!other.getPolicyArn().equals(getPolicyArn()))) {
      return false;
    }
    if (((other.getPolicyDocument() == null ? 1 : 0) ^ (getPolicyDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyDocument() != null) && (!other.getPolicyDocument().equals(getPolicyDocument()))) {
      return false;
    }
    if (((other.getSetAsDefault() == null ? 1 : 0) ^ (getSetAsDefault() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSetAsDefault() != null) && (!other.getSetAsDefault().equals(getSetAsDefault()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    hashCode = 31 * hashCode + (getPolicyDocument() == null ? 0 : getPolicyDocument().hashCode());
    hashCode = 31 * hashCode + (getSetAsDefault() == null ? 0 : getSetAsDefault().hashCode());
    return hashCode;
  }
  
  public CreatePolicyVersionRequest clone()
  {
    return (CreatePolicyVersionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyVersionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */