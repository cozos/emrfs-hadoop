package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class PolicyRole
  implements Serializable, Cloneable
{
  private String roleName;
  private String roleId;
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public String getRoleName()
  {
    return roleName;
  }
  
  public PolicyRole withRoleName(String roleName)
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
  
  public PolicyRole withRoleId(String roleId)
  {
    setRoleId(roleId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRoleName() != null) {
      sb.append("RoleName: ").append(getRoleName()).append(",");
    }
    if (getRoleId() != null) {
      sb.append("RoleId: ").append(getRoleId());
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
    if (!(obj instanceof PolicyRole)) {
      return false;
    }
    PolicyRole other = (PolicyRole)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRoleName() == null ? 0 : getRoleName().hashCode());
    hashCode = 31 * hashCode + (getRoleId() == null ? 0 : getRoleId().hashCode());
    return hashCode;
  }
  
  public PolicyRole clone()
  {
    try
    {
      return (PolicyRole)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyRole
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */