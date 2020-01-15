package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateGroupRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String groupName;
  private String newPath;
  private String newGroupName;
  
  public UpdateGroupRequest() {}
  
  public UpdateGroupRequest(String groupName)
  {
    setGroupName(groupName);
  }
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public UpdateGroupRequest withGroupName(String groupName)
  {
    setGroupName(groupName);
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
  
  public UpdateGroupRequest withNewPath(String newPath)
  {
    setNewPath(newPath);
    return this;
  }
  
  public void setNewGroupName(String newGroupName)
  {
    this.newGroupName = newGroupName;
  }
  
  public String getNewGroupName()
  {
    return newGroupName;
  }
  
  public UpdateGroupRequest withNewGroupName(String newGroupName)
  {
    setNewGroupName(newGroupName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getNewPath() != null) {
      sb.append("NewPath: ").append(getNewPath()).append(",");
    }
    if (getNewGroupName() != null) {
      sb.append("NewGroupName: ").append(getNewGroupName());
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
    if (!(obj instanceof UpdateGroupRequest)) {
      return false;
    }
    UpdateGroupRequest other = (UpdateGroupRequest)obj;
    if (((other.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupName() != null) && (!other.getGroupName().equals(getGroupName()))) {
      return false;
    }
    if (((other.getNewPath() == null ? 1 : 0) ^ (getNewPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewPath() != null) && (!other.getNewPath().equals(getNewPath()))) {
      return false;
    }
    if (((other.getNewGroupName() == null ? 1 : 0) ^ (getNewGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewGroupName() != null) && (!other.getNewGroupName().equals(getNewGroupName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getNewPath() == null ? 0 : getNewPath().hashCode());
    hashCode = 31 * hashCode + (getNewGroupName() == null ? 0 : getNewGroupName().hashCode());
    return hashCode;
  }
  
  public UpdateGroupRequest clone()
  {
    return (UpdateGroupRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateGroupRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */