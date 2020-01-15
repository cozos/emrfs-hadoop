package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetLoginProfileResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private LoginProfile loginProfile;
  
  public void setLoginProfile(LoginProfile loginProfile)
  {
    this.loginProfile = loginProfile;
  }
  
  public LoginProfile getLoginProfile()
  {
    return loginProfile;
  }
  
  public GetLoginProfileResult withLoginProfile(LoginProfile loginProfile)
  {
    setLoginProfile(loginProfile);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLoginProfile() != null) {
      sb.append("LoginProfile: ").append(getLoginProfile());
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
    if (!(obj instanceof GetLoginProfileResult)) {
      return false;
    }
    GetLoginProfileResult other = (GetLoginProfileResult)obj;
    if (((other.getLoginProfile() == null ? 1 : 0) ^ (getLoginProfile() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLoginProfile() != null) && (!other.getLoginProfile().equals(getLoginProfile()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getLoginProfile() == null ? 0 : getLoginProfile().hashCode());
    return hashCode;
  }
  
  public GetLoginProfileResult clone()
  {
    try
    {
      return (GetLoginProfileResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */