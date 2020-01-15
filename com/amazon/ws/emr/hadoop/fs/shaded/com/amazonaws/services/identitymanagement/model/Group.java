package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class Group
  implements Serializable, Cloneable
{
  private String path;
  private String groupName;
  private String groupId;
  private String arn;
  private Date createDate;
  
  public Group() {}
  
  public Group(String path, String groupName, String groupId, String arn, Date createDate)
  {
    setPath(path);
    setGroupName(groupName);
    setGroupId(groupId);
    setArn(arn);
    setCreateDate(createDate);
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public Group withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public Group withGroupName(String groupName)
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
  
  public Group withGroupId(String groupId)
  {
    setGroupId(groupId);
    return this;
  }
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public Group withArn(String arn)
  {
    setArn(arn);
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
  
  public Group withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getGroupId() != null) {
      sb.append("GroupId: ").append(getGroupId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate());
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
    if (!(obj instanceof Group)) {
      return false;
    }
    Group other = (Group)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
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
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getGroupId() == null ? 0 : getGroupId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    return hashCode;
  }
  
  public Group clone()
  {
    try
    {
      return (Group)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Group
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */