package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetAccessKeyLastUsedResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String userName;
  private AccessKeyLastUsed accessKeyLastUsed;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public GetAccessKeyLastUsedResult withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setAccessKeyLastUsed(AccessKeyLastUsed accessKeyLastUsed)
  {
    this.accessKeyLastUsed = accessKeyLastUsed;
  }
  
  public AccessKeyLastUsed getAccessKeyLastUsed()
  {
    return accessKeyLastUsed;
  }
  
  public GetAccessKeyLastUsedResult withAccessKeyLastUsed(AccessKeyLastUsed accessKeyLastUsed)
  {
    setAccessKeyLastUsed(accessKeyLastUsed);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getAccessKeyLastUsed() != null) {
      sb.append("AccessKeyLastUsed: ").append(getAccessKeyLastUsed());
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
    if (!(obj instanceof GetAccessKeyLastUsedResult)) {
      return false;
    }
    GetAccessKeyLastUsedResult other = (GetAccessKeyLastUsedResult)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getAccessKeyLastUsed() == null ? 1 : 0) ^ (getAccessKeyLastUsed() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessKeyLastUsed() != null) && (!other.getAccessKeyLastUsed().equals(getAccessKeyLastUsed()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getAccessKeyLastUsed() == null ? 0 : getAccessKeyLastUsed().hashCode());
    return hashCode;
  }
  
  public GetAccessKeyLastUsedResult clone()
  {
    try
    {
      return (GetAccessKeyLastUsedResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */