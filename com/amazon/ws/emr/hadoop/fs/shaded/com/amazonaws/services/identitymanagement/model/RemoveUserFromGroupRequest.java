package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RemoveUserFromGroupRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String groupName;
  private String userName;
  
  public RemoveUserFromGroupRequest() {}
  
  public RemoveUserFromGroupRequest(String groupName, String userName)
  {
    setGroupName(groupName);
    setUserName(userName);
  }
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public RemoveUserFromGroupRequest withGroupName(String groupName)
  {
    setGroupName(groupName);
    return this;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public RemoveUserFromGroupRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName());
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
    if (!(obj instanceof RemoveUserFromGroupRequest)) {
      return false;
    }
    RemoveUserFromGroupRequest other = (RemoveUserFromGroupRequest)obj;
    if (((other.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupName() != null) && (!other.getGroupName().equals(getGroupName()))) {
      return false;
    }
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    return hashCode;
  }
  
  public RemoveUserFromGroupRequest clone()
  {
    return (RemoveUserFromGroupRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */