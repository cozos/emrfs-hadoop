package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Role
  implements Serializable, Cloneable
{
  private String path;
  private String roleName;
  private String roleId;
  private String arn;
  private Date createDate;
  private String assumeRolePolicyDocument;
  private String description;
  private Integer maxSessionDuration;
  private AttachedPermissionsBoundary permissionsBoundary;
  private SdkInternalList<Tag> tags;
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public Role withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public String getRoleName()
  {
    return roleName;
  }
  
  public Role withRoleName(String roleName)
  {
    setRoleName(roleName);
    return this;
  }
  
  public void setRoleId(String roleId)
  {
    this.roleId = roleId;
  }
  
  public String getRoleId()
  {
    return roleId;
  }
  
  public Role withRoleId(String roleId)
  {
    setRoleId(roleId);
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
  
  public Role withArn(String arn)
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
  
  public Role withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public void setAssumeRolePolicyDocument(String assumeRolePolicyDocument)
  {
    this.assumeRolePolicyDocument = assumeRolePolicyDocument;
  }
  
  public String getAssumeRolePolicyDocument()
  {
    return assumeRolePolicyDocument;
  }
  
  public Role withAssumeRolePolicyDocument(String assumeRolePolicyDocument)
  {
    setAssumeRolePolicyDocument(assumeRolePolicyDocument);
    return this;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Role withDescription(String description)
  {
    setDescription(description);
    return this;
  }
  
  public void setMaxSessionDuration(Integer maxSessionDuration)
  {
    this.maxSessionDuration = maxSessionDuration;
  }
  
  public Integer getMaxSessionDuration()
  {
    return maxSessionDuration;
  }
  
  public Role withMaxSessionDuration(Integer maxSessionDuration)
  {
    setMaxSessionDuration(maxSessionDuration);
    return this;
  }
  
  public void setPermissionsBoundary(AttachedPermissionsBoundary permissionsBoundary)
  {
    this.permissionsBoundary = permissionsBoundary;
  }
  
  public AttachedPermissionsBoundary getPermissionsBoundary()
  {
    return permissionsBoundary;
  }
  
  public Role withPermissionsBoundary(AttachedPermissionsBoundary permissionsBoundary)
  {
    setPermissionsBoundary(permissionsBoundary);
    return this;
  }
  
  public List<Tag> getTags()
  {
    if (tags == null) {
      tags = new SdkInternalList();
    }
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new SdkInternalList(tags);
  }
  
  public Role withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public Role withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getRoleName() != null) {
      sb.append("RoleName: ").append(getRoleName()).append(",");
    }
    if (getRoleId() != null) {
      sb.append("RoleId: ").append(getRoleId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getAssumeRolePolicyDocument() != null) {
      sb.append("AssumeRolePolicyDocument: ").append(getAssumeRolePolicyDocument()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getMaxSessionDuration() != null) {
      sb.append("MaxSessionDuration: ").append(getMaxSessionDuration()).append(",");
    }
    if (getPermissionsBoundary() != null) {
      sb.append("PermissionsBoundary: ").append(getPermissionsBoundary()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags());
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
    if (!(obj instanceof Role)) {
      return false;
    }
    Role other = (Role)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getRoleName() == null ? 1 : 0) ^ (getRoleName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleName() != null) && (!other.getRoleName().equals(getRoleName()))) {
      return false;
    }
    if (((other.getRoleId() == null ? 1 : 0) ^ (getRoleId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleId() != null) && (!other.getRoleId().equals(getRoleId()))) {
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
    if (((other.getAssumeRolePolicyDocument() == null ? 1 : 0) ^ (getAssumeRolePolicyDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAssumeRolePolicyDocument() != null) && (!other.getAssumeRolePolicyDocument().equals(getAssumeRolePolicyDocument()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getMaxSessionDuration() == null ? 1 : 0) ^ (getMaxSessionDuration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxSessionDuration() != null) && (!other.getMaxSessionDuration().equals(getMaxSessionDuration()))) {
      return false;
    }
    if (((other.getPermissionsBoundary() == null ? 1 : 0) ^ (getPermissionsBoundary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermissionsBoundary() != null) && (!other.getPermissionsBoundary().equals(getPermissionsBoundary()))) {
      return false;
    }
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getRoleName() == null ? 0 : getRoleName().hashCode());
    hashCode = 31 * hashCode + (getRoleId() == null ? 0 : getRoleId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getAssumeRolePolicyDocument() == null ? 0 : getAssumeRolePolicyDocument().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getMaxSessionDuration() == null ? 0 : getMaxSessionDuration().hashCode());
    hashCode = 31 * hashCode + (getPermissionsBoundary() == null ? 0 : getPermissionsBoundary().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public Role clone()
  {
    try
    {
      return (Role)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Role
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */