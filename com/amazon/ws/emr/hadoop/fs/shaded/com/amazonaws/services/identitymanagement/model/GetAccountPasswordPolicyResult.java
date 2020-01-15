package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetAccountPasswordPolicyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private PasswordPolicy passwordPolicy;
  
  public void setPasswordPolicy(PasswordPolicy passwordPolicy)
  {
    this.passwordPolicy = passwordPolicy;
  }
  
  public PasswordPolicy getPasswordPolicy()
  {
    return passwordPolicy;
  }
  
  public GetAccountPasswordPolicyResult withPasswordPolicy(PasswordPolicy passwordPolicy)
  {
    setPasswordPolicy(passwordPolicy);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPasswordPolicy() != null) {
      sb.append("PasswordPolicy: ").append(getPasswordPolicy());
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
    if (!(obj instanceof GetAccountPasswordPolicyResult)) {
      return false;
    }
    GetAccountPasswordPolicyResult other = (GetAccountPasswordPolicyResult)obj;
    if (((other.getPasswordPolicy() == null ? 1 : 0) ^ (getPasswordPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPasswordPolicy() != null) && (!other.getPasswordPolicy().equals(getPasswordPolicy()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPasswordPolicy() == null ? 0 : getPasswordPolicy().hashCode());
    return hashCode;
  }
  
  public GetAccountPasswordPolicyResult clone()
  {
    try
    {
      return (GetAccountPasswordPolicyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */