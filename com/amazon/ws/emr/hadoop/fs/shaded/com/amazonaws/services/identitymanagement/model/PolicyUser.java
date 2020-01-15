package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class PolicyUser
  implements Serializable, Cloneable
{
  private String userName;
  private String userId;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public PolicyUser withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public PolicyUser withUserId(String userId)
  {
    setUserId(userId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getUserId() != null) {
      sb.append("UserId: ").append(getUserId());
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
    if (!(obj instanceof PolicyUser)) {
      return false;
    }
    PolicyUser other = (PolicyUser)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getUserId() == null ? 1 : 0) ^ (getUserId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserId() != null) && (!other.getUserId().equals(getUserId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getUserId() == null ? 0 : getUserId().hashCode());
    return hashCode;
  }
  
  public PolicyUser clone()
  {
    try
    {
      return (PolicyUser)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */