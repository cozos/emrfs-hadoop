package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateUserRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String newPath;
  private String newUserName;
  
  public UpdateUserRequest() {}
  
  public UpdateUserRequest(String userName)
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
  
  public UpdateUserRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setNewPath(String newPath)
  {
    this.newPath = newPath;
  }
  
  public String getNewPath()
  {
    return newPath;
  }
  
  public UpdateUserRequest withNewPath(String newPath)
  {
    setNewPath(newPath);
    return this;
  }
  
  public void setNewUserName(String newUserName)
  {
    this.newUserName = newUserName;
  }
  
  public String getNewUserName()
  {
    return newUserName;
  }
  
  public UpdateUserRequest withNewUserName(String newUserName)
  {
    setNewUserName(newUserName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getNewPath() != null) {
      sb.append("NewPath: ").append(getNewPath()).append(",");
    }
    if (getNewUserName() != null) {
      sb.append("NewUserName: ").append(getNewUserName());
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
    if (!(obj instanceof UpdateUserRequest)) {
      return false;
    }
    UpdateUserRequest other = (UpdateUserRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getNewPath() == null ? 1 : 0) ^ (getNewPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewPath() != null) && (!other.getNewPath().equals(getNewPath()))) {
      return false;
    }
    if (((other.getNewUserName() == null ? 1 : 0) ^ (getNewUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewUserName() != null) && (!other.getNewUserName().equals(getNewUserName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getNewPath() == null ? 0 : getNewPath().hashCode());
    hashCode = 31 * hashCode + (getNewUserName() == null ? 0 : getNewUserName().hashCode());
    return hashCode;
  }
  
  public UpdateUserRequest clone()
  {
    return (UpdateUserRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateUserRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */