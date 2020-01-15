package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GroupDetail
  implements Serializable, Cloneable
{
  private String path;
  private String groupName;
  private String groupId;
  private String arn;
  private Date createDate;
  private SdkInternalList<PolicyDetail> groupPolicyList;
  private SdkInternalList<AttachedPolicy> attachedManagedPolicies;
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public GroupDetail withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public GroupDetail withGroupName(String groupName)
  {
    setGroupName(groupName);
    return this;
  }
  
  public void setGroupId(String groupId)
  {
    this.groupId = groupId;
  }
  
  public String getGroupId()
  {
    return groupId;
  }
  
  public GroupDetail withGroupId(String groupId)
  {
    setGroupId(groupId);
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
  
  public GroupDetail withArn(String arn)
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
  
  public GroupDetail withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public List<PolicyDetail> getGroupPolicyList()
  {
    if (groupPolicyList == null) {
      groupPolicyList = new SdkInternalList();
    }
    return groupPolicyList;
  }
  
  public void setGroupPolicyList(Collection<PolicyDetail> groupPolicyList)
  {
    if (groupPolicyList == null)
    {
      this.groupPolicyList = null;
      return;
    }
    this.groupPolicyList = new SdkInternalList(groupPolicyList);
  }
  
  public GroupDetail withGroupPolicyList(PolicyDetail... groupPolicyList)
  {
    if (this.groupPolicyList == null) {
      setGroupPolicyList(new SdkInternalList(groupPolicyList.length));
    }
    for (PolicyDetail ele : groupPolicyList) {
      this.groupPolicyList.add(ele);
    }
    return this;
  }
  
  public GroupDetail withGroupPolicyList(Collection<PolicyDetail> groupPolicyList)
  {
    setGroupPolicyList(groupPolicyList);
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
  
  public GroupDetail withAttachedManagedPolicies(AttachedPolicy... attachedManagedPolicies)
  {
    if (this.attachedManagedPolicies == null) {
      setAttachedManagedPolicies(new SdkInternalList(attachedManagedPolicies.length));
    }
    for (AttachedPolicy ele : attachedManagedPolicies) {
      this.attachedManagedPolicies.add(ele);
    }
    return this;
  }
  
  public GroupDetail withAttachedManagedPolicies(Collection<AttachedPolicy> attachedManagedPolicies)
  {
    setAttachedManagedPolicies(attachedManagedPolicies);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getGroupId() != null) {
      sb.append("GroupId: ").append(getGroupId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getGroupPolicyList() != null) {
      sb.append("GroupPolicyList: ").append(getGroupPolicyList()).append(",");
    }
    if (getAttachedManagedPolicies() != null) {
      sb.append("AttachedManagedPolicies: ").append(getAttachedManagedPolicies());
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
    if (!(obj instanceof GroupDetail)) {
      return false;
    }
    GroupDetail other = (GroupDetail)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupName() != null) && (!other.getGroupName().equals(getGroupName()))) {
      return false;
    }
    if (((other.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupId() != null) && (!other.getGroupId().equals(getGroupId()))) {
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
    if (((other.getGroupPolicyList() == null ? 1 : 0) ^ (getGroupPolicyList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupPolicyList() != null) && (!other.getGroupPolicyList().equals(getGroupPolicyList()))) {
      return false;
    }
    if (((other.getAttachedManagedPolicies() == null ? 1 : 0) ^ (getAttachedManagedPolicies() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttachedManagedPolicies() != null) && (!other.getAttachedManagedPolicies().equals(getAttachedManagedPolicies()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getGroupId() == null ? 0 : getGroupId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getGroupPolicyList() == null ? 0 : getGroupPolicyList().hashCode());
    hashCode = 31 * hashCode + (getAttachedManagedPolicies() == null ? 0 : getAttachedManagedPolicies().hashCode());
    return hashCode;
  }
  
  public GroupDetail clone()
  {
    try
    {
      return (GroupDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GroupDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */