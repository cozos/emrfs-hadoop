package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateRoleRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String roleName;
  private String description;
  private Integer maxSessionDuration;
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public String getRoleName()
  {
    return roleName;
  }
  
  public UpdateRoleRequest withRoleName(String roleName)
  {
    setRoleName(roleName);
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
  
  public UpdateRoleRequest withDescription(String description)
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
  
  public UpdateRoleRequest withMaxSessionDuration(Integer maxSessionDuration)
  {
    setMaxSessionDuration(maxSessionDuration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRoleName() != null) {
      sb.append("RoleName: ").append(getRoleName()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getMaxSessionDuration() != null) {
      sb.append("MaxSessionDuration: ").append(getMaxSessionDuration());
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
    if (!(obj instanceof UpdateRoleRequest)) {
      return false;
    }
    UpdateRoleRequest other = (UpdateRoleRequest)obj;
    if (((other.getRoleName() == null ? 1 : 0) ^ (getRoleName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleName() != null) && (!other.getRoleName().equals(getRoleName()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRoleName() == null ? 0 : getRoleName().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getMaxSessionDuration() == null ? 0 : getMaxSessionDuration().hashCode());
    return hashCode;
  }
  
  public UpdateRoleRequest clone()
  {
    return (UpdateRoleRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */