package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CreateRoleRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String path;
  private String roleName;
  private String assumeRolePolicyDocument;
  private String description;
  private Integer maxSessionDuration;
  private String permissionsBoundary;
  private SdkInternalList<Tag> tags;
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public CreateRoleRequest withPath(String path)
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
  
  public CreateRoleRequest withRoleName(String roleName)
  {
    setRoleName(roleName);
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
  
  public CreateRoleRequest withAssumeRolePolicyDocument(String assumeRolePolicyDocument)
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
  
  public CreateRoleRequest withDescription(String description)
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
  
  public CreateRoleRequest withMaxSessionDuration(Integer maxSessionDuration)
  {
    setMaxSessionDuration(maxSessionDuration);
    return this;
  }
  
  public void setPermissionsBoundary(String permissionsBoundary)
  {
    this.permissionsBoundary = permissionsBoundary;
  }
  
  public String getPermissionsBoundary()
  {
    return permissionsBoundary;
  }
  
  public CreateRoleRequest withPermissionsBoundary(String permissionsBoundary)
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
  
  public CreateRoleRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public CreateRoleRequest withTags(Collection<Tag> tags)
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
    if (!(obj instanceof CreateRoleRequest)) {
      return false;
    }
    CreateRoleRequest other = (CreateRoleRequest)obj;
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
    hashCode = 31 * hashCode + (getAssumeRolePolicyDocument() == null ? 0 : getAssumeRolePolicyDocument().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getMaxSessionDuration() == null ? 0 : getMaxSessionDuration().hashCode());
    hashCode = 31 * hashCode + (getPermissionsBoundary() == null ? 0 : getPermissionsBoundary().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public CreateRoleRequest clone()
  {
    return (CreateRoleRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateRoleRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */