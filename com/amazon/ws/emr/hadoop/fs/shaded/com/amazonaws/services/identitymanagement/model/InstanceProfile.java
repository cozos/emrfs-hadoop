package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class InstanceProfile
  implements Serializable, Cloneable
{
  private String path;
  private String instanceProfileName;
  private String instanceProfileId;
  private String arn;
  private Date createDate;
  private SdkInternalList<Role> roles;
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public InstanceProfile withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setInstanceProfileName(String instanceProfileName)
  {
    this.instanceProfileName = instanceProfileName;
  }
  
  public String getInstanceProfileName()
  {
    return instanceProfileName;
  }
  
  public InstanceProfile withInstanceProfileName(String instanceProfileName)
  {
    setInstanceProfileName(instanceProfileName);
    return this;
  }
  
  public void setInstanceProfileId(String instanceProfileId)
  {
    this.instanceProfileId = instanceProfileId;
  }
  
  public String getInstanceProfileId()
  {
    return instanceProfileId;
  }
  
  public InstanceProfile withInstanceProfileId(String instanceProfileId)
  {
    setInstanceProfileId(instanceProfileId);
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
  
  public InstanceProfile withArn(String arn)
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
  
  public InstanceProfile withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public List<Role> getRoles()
  {
    if (roles == null) {
      roles = new SdkInternalList();
    }
    return roles;
  }
  
  public void setRoles(Collection<Role> roles)
  {
    if (roles == null)
    {
      this.roles = null;
      return;
    }
    this.roles = new SdkInternalList(roles);
  }
  
  public InstanceProfile withRoles(Role... roles)
  {
    if (this.roles == null) {
      setRoles(new SdkInternalList(roles.length));
    }
    for (Role ele : roles) {
      this.roles.add(ele);
    }
    return this;
  }
  
  public InstanceProfile withRoles(Collection<Role> roles)
  {
    setRoles(roles);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getInstanceProfileName() != null) {
      sb.append("InstanceProfileName: ").append(getInstanceProfileName()).append(",");
    }
    if (getInstanceProfileId() != null) {
      sb.append("InstanceProfileId: ").append(getInstanceProfileId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getRoles() != null) {
      sb.append("Roles: ").append(getRoles());
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
    if (!(obj instanceof InstanceProfile)) {
      return false;
    }
    InstanceProfile other = (InstanceProfile)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getInstanceProfileName() == null ? 1 : 0) ^ (getInstanceProfileName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfileName() != null) && (!other.getInstanceProfileName().equals(getInstanceProfileName()))) {
      return false;
    }
    if (((other.getInstanceProfileId() == null ? 1 : 0) ^ (getInstanceProfileId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfileId() != null) && (!other.getInstanceProfileId().equals(getInstanceProfileId()))) {
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
    if (((other.getRoles() == null ? 1 : 0) ^ (getRoles() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoles() != null) && (!other.getRoles().equals(getRoles()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getInstanceProfileName() == null ? 0 : getInstanceProfileName().hashCode());
    hashCode = 31 * hashCode + (getInstanceProfileId() == null ? 0 : getInstanceProfileId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getRoles() == null ? 0 : getRoles().hashCode());
    return hashCode;
  }
  
  public InstanceProfile clone()
  {
    try
    {
      return (InstanceProfile)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.InstanceProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */