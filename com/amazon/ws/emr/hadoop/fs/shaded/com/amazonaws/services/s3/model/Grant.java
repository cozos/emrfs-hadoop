package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Grant
  implements Serializable
{
  private Grantee grantee = null;
  private Permission permission = null;
  
  public Grant(Grantee grantee, Permission permission)
  {
    this.grantee = grantee;
    this.permission = permission;
  }
  
  public Grantee getGrantee()
  {
    return grantee;
  }
  
  public Permission getPermission()
  {
    return permission;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (grantee == null ? 0 : grantee.hashCode());
    result = 31 * result + (permission == null ? 0 : permission.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Grant other = (Grant)obj;
    if (grantee == null)
    {
      if (grantee != null) {
        return false;
      }
    }
    else if (!grantee.equals(grantee)) {
      return false;
    }
    if (permission != permission) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "Grant [grantee=" + grantee + ", permission=" + permission + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */