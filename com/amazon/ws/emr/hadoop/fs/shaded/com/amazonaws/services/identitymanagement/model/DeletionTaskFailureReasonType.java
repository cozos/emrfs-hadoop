package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DeletionTaskFailureReasonType
  implements Serializable, Cloneable
{
  private String reason;
  private SdkInternalList<RoleUsageType> roleUsageList;
  
  public void setReason(String reason)
  {
    this.reason = reason;
  }
  
  public String getReason()
  {
    return reason;
  }
  
  public DeletionTaskFailureReasonType withReason(String reason)
  {
    setReason(reason);
    return this;
  }
  
  public List<RoleUsageType> getRoleUsageList()
  {
    if (roleUsageList == null) {
      roleUsageList = new SdkInternalList();
    }
    return roleUsageList;
  }
  
  public void setRoleUsageList(Collection<RoleUsageType> roleUsageList)
  {
    if (roleUsageList == null)
    {
      this.roleUsageList = null;
      return;
    }
    this.roleUsageList = new SdkInternalList(roleUsageList);
  }
  
  public DeletionTaskFailureReasonType withRoleUsageList(RoleUsageType... roleUsageList)
  {
    if (this.roleUsageList == null) {
      setRoleUsageList(new SdkInternalList(roleUsageList.length));
    }
    for (RoleUsageType ele : roleUsageList) {
      this.roleUsageList.add(ele);
    }
    return this;
  }
  
  public DeletionTaskFailureReasonType withRoleUsageList(Collection<RoleUsageType> roleUsageList)
  {
    setRoleUsageList(roleUsageList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getReason() != null) {
      sb.append("Reason: ").append(getReason()).append(",");
    }
    if (getRoleUsageList() != null) {
      sb.append("RoleUsageList: ").append(getRoleUsageList());
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
    if (!(obj instanceof DeletionTaskFailureReasonType)) {
      return false;
    }
    DeletionTaskFailureReasonType other = (DeletionTaskFailureReasonType)obj;
    if (((other.getReason() == null ? 1 : 0) ^ (getReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReason() != null) && (!other.getReason().equals(getReason()))) {
      return false;
    }
    if (((other.getRoleUsageList() == null ? 1 : 0) ^ (getRoleUsageList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleUsageList() != null) && (!other.getRoleUsageList().equals(getRoleUsageList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getReason() == null ? 0 : getReason().hashCode());
    hashCode = 31 * hashCode + (getRoleUsageList() == null ? 0 : getRoleUsageList().hashCode());
    return hashCode;
  }
  
  public DeletionTaskFailureReasonType clone()
  {
    try
    {
      return (DeletionTaskFailureReasonType)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletionTaskFailureReasonType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */