package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetAccountAuthorizationDetailsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<UserDetail> userDetailList;
  private SdkInternalList<GroupDetail> groupDetailList;
  private SdkInternalList<RoleDetail> roleDetailList;
  private SdkInternalList<ManagedPolicyDetail> policies;
  private Boolean isTruncated;
  private String marker;
  
  public List<UserDetail> getUserDetailList()
  {
    if (userDetailList == null) {
      userDetailList = new SdkInternalList();
    }
    return userDetailList;
  }
  
  public void setUserDetailList(Collection<UserDetail> userDetailList)
  {
    if (userDetailList == null)
    {
      this.userDetailList = null;
      return;
    }
    this.userDetailList = new SdkInternalList(userDetailList);
  }
  
  public GetAccountAuthorizationDetailsResult withUserDetailList(UserDetail... userDetailList)
  {
    if (this.userDetailList == null) {
      setUserDetailList(new SdkInternalList(userDetailList.length));
    }
    for (UserDetail ele : userDetailList) {
      this.userDetailList.add(ele);
    }
    return this;
  }
  
  public GetAccountAuthorizationDetailsResult withUserDetailList(Collection<UserDetail> userDetailList)
  {
    setUserDetailList(userDetailList);
    return this;
  }
  
  public List<GroupDetail> getGroupDetailList()
  {
    if (groupDetailList == null) {
      groupDetailList = new SdkInternalList();
    }
    return groupDetailList;
  }
  
  public void setGroupDetailList(Collection<GroupDetail> groupDetailList)
  {
    if (groupDetailList == null)
    {
      this.groupDetailList = null;
      return;
    }
    this.groupDetailList = new SdkInternalList(groupDetailList);
  }
  
  public GetAccountAuthorizationDetailsResult withGroupDetailList(GroupDetail... groupDetailList)
  {
    if (this.groupDetailList == null) {
      setGroupDetailList(new SdkInternalList(groupDetailList.length));
    }
    for (GroupDetail ele : groupDetailList) {
      this.groupDetailList.add(ele);
    }
    return this;
  }
  
  public GetAccountAuthorizationDetailsResult withGroupDetailList(Collection<GroupDetail> groupDetailList)
  {
    setGroupDetailList(groupDetailList);
    return this;
  }
  
  public List<RoleDetail> getRoleDetailList()
  {
    if (roleDetailList == null) {
      roleDetailList = new SdkInternalList();
    }
    return roleDetailList;
  }
  
  public void setRoleDetailList(Collection<RoleDetail> roleDetailList)
  {
    if (roleDetailList == null)
    {
      this.roleDetailList = null;
      return;
    }
    this.roleDetailList = new SdkInternalList(roleDetailList);
  }
  
  public GetAccountAuthorizationDetailsResult withRoleDetailList(RoleDetail... roleDetailList)
  {
    if (this.roleDetailList == null) {
      setRoleDetailList(new SdkInternalList(roleDetailList.length));
    }
    for (RoleDetail ele : roleDetailList) {
      this.roleDetailList.add(ele);
    }
    return this;
  }
  
  public GetAccountAuthorizationDetailsResult withRoleDetailList(Collection<RoleDetail> roleDetailList)
  {
    setRoleDetailList(roleDetailList);
    return this;
  }
  
  public List<ManagedPolicyDetail> getPolicies()
  {
    if (policies == null) {
      policies = new SdkInternalList();
    }
    return policies;
  }
  
  public void setPolicies(Collection<ManagedPolicyDetail> policies)
  {
    if (policies == null)
    {
      this.policies = null;
      return;
    }
    this.policies = new SdkInternalList(policies);
  }
  
  public GetAccountAuthorizationDetailsResult withPolicies(ManagedPolicyDetail... policies)
  {
    if (this.policies == null) {
      setPolicies(new SdkInternalList(policies.length));
    }
    for (ManagedPolicyDetail ele : policies) {
      this.policies.add(ele);
    }
    return this;
  }
  
  public GetAccountAuthorizationDetailsResult withPolicies(Collection<ManagedPolicyDetail> policies)
  {
    setPolicies(policies);
    return this;
  }
  
  public void setIsTruncated(Boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public Boolean getIsTruncated()
  {
    return isTruncated;
  }
  
  public GetAccountAuthorizationDetailsResult withIsTruncated(Boolean isTruncated)
  {
    setIsTruncated(isTruncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public GetAccountAuthorizationDetailsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserDetailList() != null) {
      sb.append("UserDetailList: ").append(getUserDetailList()).append(",");
    }
    if (getGroupDetailList() != null) {
      sb.append("GroupDetailList: ").append(getGroupDetailList()).append(",");
    }
    if (getRoleDetailList() != null) {
      sb.append("RoleDetailList: ").append(getRoleDetailList()).append(",");
    }
    if (getPolicies() != null) {
      sb.append("Policies: ").append(getPolicies()).append(",");
    }
    if (getIsTruncated() != null) {
      sb.append("IsTruncated: ").append(getIsTruncated()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof GetAccountAuthorizationDetailsResult)) {
      return false;
    }
    GetAccountAuthorizationDetailsResult other = (GetAccountAuthorizationDetailsResult)obj;
    if (((other.getUserDetailList() == null ? 1 : 0) ^ (getUserDetailList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserDetailList() != null) && (!other.getUserDetailList().equals(getUserDetailList()))) {
      return false;
    }
    if (((other.getGroupDetailList() == null ? 1 : 0) ^ (getGroupDetailList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupDetailList() != null) && (!other.getGroupDetailList().equals(getGroupDetailList()))) {
      return false;
    }
    if (((other.getRoleDetailList() == null ? 1 : 0) ^ (getRoleDetailList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleDetailList() != null) && (!other.getRoleDetailList().equals(getRoleDetailList()))) {
      return false;
    }
    if (((other.getPolicies() == null ? 1 : 0) ^ (getPolicies() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicies() != null) && (!other.getPolicies().equals(getPolicies()))) {
      return false;
    }
    if (((other.getIsTruncated() == null ? 1 : 0) ^ (getIsTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsTruncated() != null) && (!other.getIsTruncated().equals(getIsTruncated()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserDetailList() == null ? 0 : getUserDetailList().hashCode());
    hashCode = 31 * hashCode + (getGroupDetailList() == null ? 0 : getGroupDetailList().hashCode());
    hashCode = 31 * hashCode + (getRoleDetailList() == null ? 0 : getRoleDetailList().hashCode());
    hashCode = 31 * hashCode + (getPolicies() == null ? 0 : getPolicies().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public GetAccountAuthorizationDetailsResult clone()
  {
    try
    {
      return (GetAccountAuthorizationDetailsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */