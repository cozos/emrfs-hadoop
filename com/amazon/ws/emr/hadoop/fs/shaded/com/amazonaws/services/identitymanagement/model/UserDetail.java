package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class UserDetail
  implements Serializable, Cloneable
{
  private String path;
  private String userName;
  private String userId;
  private String arn;
  private Date createDate;
  private SdkInternalList<PolicyDetail> userPolicyList;
  private SdkInternalList<String> groupList;
  private SdkInternalList<AttachedPolicy> attachedManagedPolicies;
  private AttachedPermissionsBoundary permissionsBoundary;
  private SdkInternalList<Tag> tags;
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public UserDetail withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UserDetail withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public UserDetail withUserId(String userId)
  {
    setUserId(userId);
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
  
  public UserDetail withArn(String arn)
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
  
  public UserDetail withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public List<PolicyDetail> getUserPolicyList()
  {
    if (userPolicyList == null) {
      userPolicyList = new SdkInternalList();
    }
    return userPolicyList;
  }
  
  public void setUserPolicyList(Collection<PolicyDetail> userPolicyList)
  {
    if (userPolicyList == null)
    {
      this.userPolicyList = null;
      return;
    }
    this.userPolicyList = new SdkInternalList(userPolicyList);
  }
  
  public UserDetail withUserPolicyList(PolicyDetail... userPolicyList)
  {
    if (this.userPolicyList == null) {
      setUserPolicyList(new SdkInternalList(userPolicyList.length));
    }
    for (PolicyDetail ele : userPolicyList) {
      this.userPolicyList.add(ele);
    }
    return this;
  }
  
  public UserDetail withUserPolicyList(Collection<PolicyDetail> userPolicyList)
  {
    setUserPolicyList(userPolicyList);
    return this;
  }
  
  public List<String> getGroupList()
  {
    if (groupList == null) {
      groupList = new SdkInternalList();
    }
    return groupList;
  }
  
  public void setGroupList(Collection<String> groupList)
  {
    if (groupList == null)
    {
      this.groupList = null;
      return;
    }
    this.groupList = new SdkInternalList(groupList);
  }
  
  public UserDetail withGroupList(String... groupList)
  {
    if (this.groupList == null) {
      setGroupList(new SdkInternalList(groupList.length));
    }
    for (String ele : groupList) {
      this.groupList.add(ele);
    }
    return this;
  }
  
  public UserDetail withGroupList(Collection<String> groupList)
  {
    setGroupList(groupList);
    return this;
  }
  
  public List<AttachedPolicy> getAttachedManagedPolicies()
  {
    if (attachedManagedPolicies == null) {
      attachedManagedPolicies = new SdkInternalList();
    }
    return attachedManagedPolicies;
  }
  
  public void setAttachedManagedPolicies(Collection<AttachedPolicy> attachedManagedPolicies)
  {
    if (attachedManagedPolicies == null)
    {
      this.attachedManagedPolicies = null;
      return;
    }
    this.attachedManagedPolicies = new SdkInternalList(attachedManagedPolicies);
  }
  
  public UserDetail withAttachedManagedPolicies(AttachedPolicy... attachedManagedPolicies)
  {
    if (this.attachedManagedPolicies == null) {
      setAttachedManagedPolicies(new SdkInternalList(attachedManagedPolicies.length));
    }
    for (AttachedPolicy ele : attachedManagedPolicies) {
      this.attachedManagedPolicies.add(ele);
    }
    return this;
  }
  
  public UserDetail withAttachedManagedPolicies(Collection<AttachedPolicy> attachedManagedPolicies)
  {
    setAttachedManagedPolicies(attachedManagedPolicies);
    return this;
  }
  
  public void setPermissionsBoundary(AttachedPermissionsBoundary permissionsBoundary)
  {
    this.permissionsBoundary = permissionsBoundary;
  }
  
  public AttachedPermissionsBoundary getPermissionsBoundary()
  {
    return permissionsBoundary;
  }
  
  public UserDetail withPermissionsBoundary(AttachedPermissionsBoundary permissionsBoundary)
  {
    setPermissionsBoundary(permissionsBoundary);
    return this;
  }
  
  public List<Tag> getTags()
  {
    if (tags == null) {
      tags = new SdkInternalList();
    }
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new SdkInternalList(tags);
  }
  
  public UserDetail withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public UserDetail withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getUserId() != null) {
      sb.append("UserId: ").append(getUserId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getUserPolicyList() != null) {
      sb.append("UserPolicyList: ").append(getUserPolicyList()).append(",");
    }
    if (getGroupList() != null) {
      sb.append("GroupList: ").append(getGroupList()).append(",");
    }
    if (getAttachedManagedPolicies() != null) {
      sb.append("AttachedManagedPolicies: ").append(getAttachedManagedPolicies()).append(",");
    }
    if (getPermissionsBoundary() != null) {
      sb.append("PermissionsBoundary: ").append(getPermissionsBoundary()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags());
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
    if (!(obj instanceof UserDetail)) {
      return false;
    }
    UserDetail other = (UserDetail)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getUserId() == null ? 1 : 0) ^ (getUserId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserId() != null) && (!other.getUserId().equals(getUserId()))) {
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
    if (((other.getUserPolicyList() == null ? 1 : 0) ^ (getUserPolicyList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserPolicyList() != null) && (!other.getUserPolicyList().equals(getUserPolicyList()))) {
      return false;
    }
    if (((other.getGroupList() == null ? 1 : 0) ^ (getGroupList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupList() != null) && (!other.getGroupList().equals(getGroupList()))) {
      return false;
    }
    if (((other.getAttachedManagedPolicies() == null ? 1 : 0) ^ (getAttachedManagedPolicies() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttachedManagedPolicies() != null) && (!other.getAttachedManagedPolicies().equals(getAttachedManagedPolicies()))) {
      return false;
    }
    if (((other.getPermissionsBoundary() == null ? 1 : 0) ^ (getPermissionsBoundary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermissionsBoundary() != null) && (!other.getPermissionsBoundary().equals(getPermissionsBoundary()))) {
      return false;
    }
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getUserId() == null ? 0 : getUserId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getUserPolicyList() == null ? 0 : getUserPolicyList().hashCode());
    hashCode = 31 * hashCode + (getGroupList() == null ? 0 : getGroupList().hashCode());
    hashCode = 31 * hashCode + (getAttachedManagedPolicies() == null ? 0 : getAttachedManagedPolicies().hashCode());
    hashCode = 31 * hashCode + (getPermissionsBoundary() == null ? 0 : getPermissionsBoundary().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public UserDetail clone()
  {
    try
    {
      return (UserDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UserDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */