package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ChangePasswordRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String oldPassword;
  private String newPassword;
  
  public void setOldPassword(String oldPassword)
  {
    this.oldPassword = oldPassword;
  }
  
  public String getOldPassword()
  {
    return oldPassword;
  }
  
  public ChangePasswordRequest withOldPassword(String oldPassword)
  {
    setOldPassword(oldPassword);
    return this;
  }
  
  public void setNewPassword(String newPassword)
  {
    this.newPassword = newPassword;
  }
  
  public String getNewPassword()
  {
    return newPassword;
  }
  
  public ChangePasswordRequest withNewPassword(String newPassword)
  {
    setNewPassword(newPassword);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getOldPassword() != null) {
      sb.append("OldPassword: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getNewPassword() != null) {
      sb.append("NewPassword: ").append("***Sensitive Data Redacted***");
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
    if (!(obj instanceof ChangePasswordRequest)) {
      return false;
    }
    ChangePasswordRequest other = (ChangePasswordRequest)obj;
    if (((other.getOldPassword() == null ? 1 : 0) ^ (getOldPassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOldPassword() != null) && (!other.getOldPassword().equals(getOldPassword()))) {
      return false;
    }
    if (((other.getNewPassword() == null ? 1 : 0) ^ (getNewPassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewPassword() != null) && (!other.getNewPassword().equals(getNewPassword()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getOldPassword() == null ? 0 : getOldPassword().hashCode());
    hashCode = 31 * hashCode + (getNewPassword() == null ? 0 : getNewPassword().hashCode());
    return hashCode;
  }
  
  public ChangePasswordRequest clone()
  {
    return (ChangePasswordRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ChangePasswordRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */