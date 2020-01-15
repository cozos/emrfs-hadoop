package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class PolicyGroup
  implements Serializable, Cloneable
{
  private String groupName;
  private String groupId;
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public PolicyGroup withGroupName(String groupName)
  {
    setGroupName(groupName);
    return this;
  }
  
  public void setGroupId(String groupId)
  {
    this.groupId = groupId;
  }
  
  public String getGroupId()
  {
    return groupId;
  }
  
  public PolicyGroup withGroupId(String groupId)
  {
    setGroupId(groupId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getGroupId() != null) {
      sb.append("GroupId: ").append(getGroupId());
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
    if (!(obj instanceof PolicyGroup)) {
      return false;
    }
    PolicyGroup other = (PolicyGroup)obj;
    if (((other.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupName() != null) && (!other.getGroupName().equals(getGroupName()))) {
      return false;
    }
    if (((other.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupId() != null) && (!other.getGroupId().equals(getGroupId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getGroupId() == null ? 0 : getGroupId().hashCode());
    return hashCode;
  }
  
  public PolicyGroup clone()
  {
    try
    {
      return (PolicyGroup)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */