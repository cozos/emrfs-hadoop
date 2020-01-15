package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetAccessKeyInfoResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String account;
  
  public void setAccount(String account)
  {
    this.account = account;
  }
  
  public String getAccount()
  {
    return account;
  }
  
  public GetAccessKeyInfoResult withAccount(String account)
  {
    setAccount(account);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccount() != null) {
      sb.append("Account: ").append(getAccount());
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
    if (!(obj instanceof GetAccessKeyInfoResult)) {
      return false;
    }
    GetAccessKeyInfoResult other = (GetAccessKeyInfoResult)obj;
    if (((other.getAccount() == null ? 1 : 0) ^ (getAccount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccount() != null) && (!other.getAccount().equals(getAccount()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAccount() == null ? 0 : getAccount().hashCode());
    return hashCode;
  }
  
  public GetAccessKeyInfoResult clone()
  {
    try
    {
      return (GetAccessKeyInfoResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */