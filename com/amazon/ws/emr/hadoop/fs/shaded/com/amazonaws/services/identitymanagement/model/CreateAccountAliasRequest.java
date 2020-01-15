package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateAccountAliasRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String accountAlias;
  
  public CreateAccountAliasRequest() {}
  
  public CreateAccountAliasRequest(String accountAlias)
  {
    setAccountAlias(accountAlias);
  }
  
  public void setAccountAlias(String accountAlias)
  {
    this.accountAlias = accountAlias;
  }
  
  public String getAccountAlias()
  {
    return accountAlias;
  }
  
  public CreateAccountAliasRequest withAccountAlias(String accountAlias)
  {
    setAccountAlias(accountAlias);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccountAlias() != null) {
      sb.append("AccountAlias: ").append(getAccountAlias());
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
    if (!(obj instanceof CreateAccountAliasRequest)) {
      return false;
    }
    CreateAccountAliasRequest other = (CreateAccountAliasRequest)obj;
    if (((other.getAccountAlias() == null ? 1 : 0) ^ (getAccountAlias() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccountAlias() != null) && (!other.getAccountAlias().equals(getAccountAlias()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAccountAlias() == null ? 0 : getAccountAlias().hashCode());
    return hashCode;
  }
  
  public CreateAccountAliasRequest clone()
  {
    return (CreateAccountAliasRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */