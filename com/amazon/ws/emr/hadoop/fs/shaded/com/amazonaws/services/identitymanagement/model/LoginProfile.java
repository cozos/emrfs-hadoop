package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class LoginProfile
  implements Serializable, Cloneable
{
  private String userName;
  private Date createDate;
  private Boolean passwordResetRequired;
  
  public LoginProfile() {}
  
  public LoginProfile(String userName, Date createDate)
  {
    setUserName(userName);
    setCreateDate(createDate);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public LoginProfile withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public Date getCreateDate()
  {
    return createDate;
  }
  
  public LoginProfile withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public void setPasswordResetRequired(Boolean passwordResetRequired)
  {
    this.passwordResetRequired = passwordResetRequired;
  }
  
  public Boolean getPasswordResetRequired()
  {
    return passwordResetRequired;
  }
  
  public LoginProfile withPasswordResetRequired(Boolean passwordResetRequired)
  {
    setPasswordResetRequired(passwordResetRequired);
    return this;
  }
  
  public Boolean isPasswordResetRequired()
  {
    return passwordResetRequired;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getPasswordResetRequired() != null) {
      sb.append("PasswordResetRequired: ").append(getPasswordResetRequired());
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
    if (!(obj instanceof LoginProfile)) {
      return false;
    }
    LoginProfile other = (LoginProfile)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    if (((other.getPasswordResetRequired() == null ? 1 : 0) ^ (getPasswordResetRequired() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPasswordResetRequired() != null) && (!other.getPasswordResetRequired().equals(getPasswordResetRequired()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getPasswordResetRequired() == null ? 0 : getPasswordResetRequired().hashCode());
    return hashCode;
  }
  
  public LoginProfile clone()
  {
    try
    {
      return (LoginProfile)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.LoginProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */