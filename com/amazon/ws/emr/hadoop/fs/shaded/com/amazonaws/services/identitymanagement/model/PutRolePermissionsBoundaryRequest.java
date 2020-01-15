package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class PutRolePermissionsBoundaryRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleName;
  private String permissionsBoundary;
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public String getRoleName()
  {
    return roleName;
  }
  
  public PutRolePermissionsBoundaryRequest withRoleName(String roleName)
  {
    setRoleName(roleName);
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
  
  public PutRolePermissionsBoundaryRequest withPermissionsBoundary(String permissionsBoundary)
  {
    setPermissionsBoundary(permissionsBoundary);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRoleName() != null) {
      sb.append("RoleName: ").append(getRoleName()).append(",");
    }
    if (getPermissionsBoundary() != null) {
      sb.append("PermissionsBoundary: ").append(getPermissionsBoundary());
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
    if (!(obj instanceof PutRolePermissionsBoundaryRequest)) {
      return false;
    }
    PutRolePermissionsBoundaryRequest other = (PutRolePermissionsBoundaryRequest)obj;
    if (((other.getRoleName() == null ? 1 : 0) ^ (getRoleName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleName() != null) && (!other.getRoleName().equals(getRoleName()))) {
      return false;
    }
    if (((other.getPermissionsBoundary() == null ? 1 : 0) ^ (getPermissionsBoundary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermissionsBoundary() != null) && (!other.getPermissionsBoundary().equals(getPermissionsBoundary()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRoleName() == null ? 0 : getRoleName().hashCode());
    hashCode = 31 * hashCode + (getPermissionsBoundary() == null ? 0 : getPermissionsBoundary().hashCode());
    return hashCode;
  }
  
  public PutRolePermissionsBoundaryRequest clone()
  {
    return (PutRolePermissionsBoundaryRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */