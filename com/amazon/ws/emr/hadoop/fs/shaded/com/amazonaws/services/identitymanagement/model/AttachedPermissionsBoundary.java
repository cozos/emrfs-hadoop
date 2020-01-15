package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class AttachedPermissionsBoundary
  implements Serializable, Cloneable
{
  private String permissionsBoundaryType;
  private String permissionsBoundaryArn;
  
  public void setPermissionsBoundaryType(String permissionsBoundaryType)
  {
    this.permissionsBoundaryType = permissionsBoundaryType;
  }
  
  public String getPermissionsBoundaryType()
  {
    return permissionsBoundaryType;
  }
  
  public AttachedPermissionsBoundary withPermissionsBoundaryType(String permissionsBoundaryType)
  {
    setPermissionsBoundaryType(permissionsBoundaryType);
    return this;
  }
  
  public AttachedPermissionsBoundary withPermissionsBoundaryType(PermissionsBoundaryAttachmentType permissionsBoundaryType)
  {
    this.permissionsBoundaryType = permissionsBoundaryType.toString();
    return this;
  }
  
  public void setPermissionsBoundaryArn(String permissionsBoundaryArn)
  {
    this.permissionsBoundaryArn = permissionsBoundaryArn;
  }
  
  public String getPermissionsBoundaryArn()
  {
    return permissionsBoundaryArn;
  }
  
  public AttachedPermissionsBoundary withPermissionsBoundaryArn(String permissionsBoundaryArn)
  {
    setPermissionsBoundaryArn(permissionsBoundaryArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPermissionsBoundaryType() != null) {
      sb.append("PermissionsBoundaryType: ").append(getPermissionsBoundaryType()).append(",");
    }
    if (getPermissionsBoundaryArn() != null) {
      sb.append("PermissionsBoundaryArn: ").append(getPermissionsBoundaryArn());
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
    if (!(obj instanceof AttachedPermissionsBoundary)) {
      return false;
    }
    AttachedPermissionsBoundary other = (AttachedPermissionsBoundary)obj;
    if (((other.getPermissionsBoundaryType() == null ? 1 : 0) ^ (getPermissionsBoundaryType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermissionsBoundaryType() != null) && (!other.getPermissionsBoundaryType().equals(getPermissionsBoundaryType()))) {
      return false;
    }
    if (((other.getPermissionsBoundaryArn() == null ? 1 : 0) ^ (getPermissionsBoundaryArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermissionsBoundaryArn() != null) && (!other.getPermissionsBoundaryArn().equals(getPermissionsBoundaryArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPermissionsBoundaryType() == null ? 0 : getPermissionsBoundaryType().hashCode());
    hashCode = 31 * hashCode + (getPermissionsBoundaryArn() == null ? 0 : getPermissionsBoundaryArn().hashCode());
    return hashCode;
  }
  
  public AttachedPermissionsBoundary clone()
  {
    try
    {
      return (AttachedPermissionsBoundary)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPermissionsBoundary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */