package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateServiceLinkedRoleResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Role role;
  
  public void setRole(Role role)
  {
    this.role = role;
  }
  
  public Role getRole()
  {
    return role;
  }
  
  public CreateServiceLinkedRoleResult withRole(Role role)
  {
    setRole(role);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRole() != null) {
      sb.append("Role: ").append(getRole());
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
    if (!(obj instanceof CreateServiceLinkedRoleResult)) {
      return false;
    }
    CreateServiceLinkedRoleResult other = (CreateServiceLinkedRoleResult)obj;
    if (((other.getRole() == null ? 1 : 0) ^ (getRole() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRole() != null) && (!other.getRole().equals(getRole()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRole() == null ? 0 : getRole().hashCode());
    return hashCode;
  }
  
  public CreateServiceLinkedRoleResult clone()
  {
    try
    {
      return (CreateServiceLinkedRoleResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */