package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetCallerIdentityResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String userId;
  private String account;
  private String arn;
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public GetCallerIdentityResult withUserId(String userId)
  {
    setUserId(userId);
    return this;
  }
  
  public void setAccount(String account)
  {
    this.account = account;
  }
  
  public String getAccount()
  {
    return account;
  }
  
  public GetCallerIdentityResult withAccount(String account)
  {
    setAccount(account);
    return this;
  }
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public GetCallerIdentityResult withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserId() != null) {
      sb.append("UserId: ").append(getUserId()).append(",");
    }
    if (getAccount() != null) {
      sb.append("Account: ").append(getAccount()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn());
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
    if (!(obj instanceof GetCallerIdentityResult)) {
      return false;
    }
    GetCallerIdentityResult other = (GetCallerIdentityResult)obj;
    if (((other.getUserId() == null ? 1 : 0) ^ (getUserId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserId() != null) && (!other.getUserId().equals(getUserId()))) {
      return false;
    }
    if (((other.getAccount() == null ? 1 : 0) ^ (getAccount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccount() != null) && (!other.getAccount().equals(getAccount()))) {
      return false;
    }
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserId() == null ? 0 : getUserId().hashCode());
    hashCode = 31 * hashCode + (getAccount() == null ? 0 : getAccount().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    return hashCode;
  }
  
  public GetCallerIdentityResult clone()
  {
    try
    {
      return (GetCallerIdentityResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */