package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class AddRoleToInstanceProfileRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String instanceProfileName;
  private String roleName;
  
  public void setInstanceProfileName(String instanceProfileName)
  {
    this.instanceProfileName = instanceProfileName;
  }
  
  public String getInstanceProfileName()
  {
    return instanceProfileName;
  }
  
  public AddRoleToInstanceProfileRequest withInstanceProfileName(String instanceProfileName)
  {
    setInstanceProfileName(instanceProfileName);
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
  
  public AddRoleToInstanceProfileRequest withRoleName(String roleName)
  {
    setRoleName(roleName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceProfileName() != null) {
      sb.append("InstanceProfileName: ").append(getInstanceProfileName()).append(",");
    }
    if (getRoleName() != null) {
      sb.append("RoleName: ").append(getRoleName());
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
    if (!(obj instanceof AddRoleToInstanceProfileRequest)) {
      return false;
    }
    AddRoleToInstanceProfileRequest other = (AddRoleToInstanceProfileRequest)obj;
    if (((other.getInstanceProfileName() == null ? 1 : 0) ^ (getInstanceProfileName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfileName() != null) && (!other.getInstanceProfileName().equals(getInstanceProfileName()))) {
      return false;
    }
    if (((other.getRoleName() == null ? 1 : 0) ^ (getRoleName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleName() != null) && (!other.getRoleName().equals(getRoleName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceProfileName() == null ? 0 : getInstanceProfileName().hashCode());
    hashCode = 31 * hashCode + (getRoleName() == null ? 0 : getRoleName().hashCode());
    return hashCode;
  }
  
  public AddRoleToInstanceProfileRequest clone()
  {
    return (AddRoleToInstanceProfileRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */