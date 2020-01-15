package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateLoginProfileRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String password;
  private Boolean passwordResetRequired;
  
  public UpdateLoginProfileRequest() {}
  
  public UpdateLoginProfileRequest(String userName)
  {
    setUserName(userName);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UpdateLoginProfileRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getPassword()
  {
    return password;
  }
  
  public UpdateLoginProfileRequest withPassword(String password)
  {
    setPassword(password);
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
  
  public UpdateLoginProfileRequest withPasswordResetRequired(Boolean passwordResetRequired)
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
    if (getPassword() != null) {
      sb.append("Password: ").append("***Sensitive Data Redacted***").append(",");
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
    if (!(obj instanceof UpdateLoginProfileRequest)) {
      return false;
    }
    UpdateLoginProfileRequest other = (UpdateLoginProfileRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getPassword() == null ? 1 : 0) ^ (getPassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPassword() != null) && (!other.getPassword().equals(getPassword()))) {
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
    hashCode = 31 * hashCode + (getPassword() == null ? 0 : getPassword().hashCode());
    hashCode = 31 * hashCode + (getPasswordResetRequired() == null ? 0 : getPasswordResetRequired().hashCode());
    return hashCode;
  }
  
  public UpdateLoginProfileRequest clone()
  {
    return (UpdateLoginProfileRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateLoginProfileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */