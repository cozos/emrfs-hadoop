package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ManagedPolicyDetail
  implements Serializable, Cloneable
{
  private String policyName;
  private String policyId;
  private String arn;
  private String path;
  private String defaultVersionId;
  private Integer attachmentCount;
  private Integer permissionsBoundaryUsageCount;
  private Boolean isAttachable;
  private String description;
  private Date createDate;
  private Date updateDate;
  private SdkInternalList<PolicyVersion> policyVersionList;
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public ManagedPolicyDetail withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public void setPolicyId(String policyId)
  {
    this.policyId = policyId;
  }
  
  public String getPolicyId()
  {
    return policyId;
  }
  
  public ManagedPolicyDetail withPolicyId(String policyId)
  {
    setPolicyId(policyId);
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
  
  public ManagedPolicyDetail withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public ManagedPolicyDetail withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setDefaultVersionId(String defaultVersionId)
  {
    this.defaultVersionId = defaultVersionId;
  }
  
  public String getDefaultVersionId()
  {
    return defaultVersionId;
  }
  
  public ManagedPolicyDetail withDefaultVersionId(String defaultVersionId)
  {
    setDefaultVersionId(defaultVersionId);
    return this;
  }
  
  public void setAttachmentCount(Integer attachmentCount)
  {
    this.attachmentCount = attachmentCount;
  }
  
  public Integer getAttachmentCount()
  {
    return attachmentCount;
  }
  
  public ManagedPolicyDetail withAttachmentCount(Integer attachmentCount)
  {
    setAttachmentCount(attachmentCount);
    return this;
  }
  
  public void setPermissionsBoundaryUsageCount(Integer permissionsBoundaryUsageCount)
  {
    this.permissionsBoundaryUsageCount = permissionsBoundaryUsageCount;
  }
  
  public Integer getPermissionsBoundaryUsageCount()
  {
    return permissionsBoundaryUsageCount;
  }
  
  public ManagedPolicyDetail withPermissionsBoundaryUsageCount(Integer permissionsBoundaryUsageCount)
  {
    setPermissionsBoundaryUsageCount(permissionsBoundaryUsageCount);
    return this;
  }
  
  public void setIsAttachable(Boolean isAttachable)
  {
    this.isAttachable = isAttachable;
  }
  
  public Boolean getIsAttachable()
  {
    return isAttachable;
  }
  
  public ManagedPolicyDetail withIsAttachable(Boolean isAttachable)
  {
    setIsAttachable(isAttachable);
    return this;
  }
  
  public Boolean isAttachable()
  {
    return isAttachable;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public ManagedPolicyDetail withDescription(String description)
  {
    setDescription(description);
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
  
  public ManagedPolicyDetail withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public void setUpdateDate(Date updateDate)
  {
    this.updateDate = updateDate;
  }
  
  public Date getUpdateDate()
  {
    return updateDate;
  }
  
  public ManagedPolicyDetail withUpdateDate(Date updateDate)
  {
    setUpdateDate(updateDate);
    return this;
  }
  
  public List<PolicyVersion> getPolicyVersionList()
  {
    if (policyVersionList == null) {
      policyVersionList = new SdkInternalList();
    }
    return policyVersionList;
  }
  
  public void setPolicyVersionList(Collection<PolicyVersion> policyVersionList)
  {
    if (policyVersionList == null)
    {
      this.policyVersionList = null;
      return;
    }
    this.policyVersionList = new SdkInternalList(policyVersionList);
  }
  
  public ManagedPolicyDetail withPolicyVersionList(PolicyVersion... policyVersionList)
  {
    if (this.policyVersionList == null) {
      setPolicyVersionList(new SdkInternalList(policyVersionList.length));
    }
    for (PolicyVersion ele : policyVersionList) {
      this.policyVersionList.add(ele);
    }
    return this;
  }
  
  public ManagedPolicyDetail withPolicyVersionList(Collection<PolicyVersion> policyVersionList)
  {
    setPolicyVersionList(policyVersionList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName()).append(",");
    }
    if (getPolicyId() != null) {
      sb.append("PolicyId: ").append(getPolicyId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getDefaultVersionId() != null) {
      sb.append("DefaultVersionId: ").append(getDefaultVersionId()).append(",");
    }
    if (getAttachmentCount() != null) {
      sb.append("AttachmentCount: ").append(getAttachmentCount()).append(",");
    }
    if (getPermissionsBoundaryUsageCount() != null) {
      sb.append("PermissionsBoundaryUsageCount: ").append(getPermissionsBoundaryUsageCount()).append(",");
    }
    if (getIsAttachable() != null) {
      sb.append("IsAttachable: ").append(getIsAttachable()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getUpdateDate() != null) {
      sb.append("UpdateDate: ").append(getUpdateDate()).append(",");
    }
    if (getPolicyVersionList() != null) {
      sb.append("PolicyVersionList: ").append(getPolicyVersionList());
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
    if (!(obj instanceof ManagedPolicyDetail)) {
      return false;
    }
    ManagedPolicyDetail other = (ManagedPolicyDetail)obj;
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    if (((other.getPolicyId() == null ? 1 : 0) ^ (getPolicyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyId() != null) && (!other.getPolicyId().equals(getPolicyId()))) {
      return false;
    }
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getDefaultVersionId() == null ? 1 : 0) ^ (getDefaultVersionId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDefaultVersionId() != null) && (!other.getDefaultVersionId().equals(getDefaultVersionId()))) {
      return false;
    }
    if (((other.getAttachmentCount() == null ? 1 : 0) ^ (getAttachmentCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttachmentCount() != null) && (!other.getAttachmentCount().equals(getAttachmentCount()))) {
      return false;
    }
    if (((other.getPermissionsBoundaryUsageCount() == null ? 1 : 0) ^ (getPermissionsBoundaryUsageCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermissionsBoundaryUsageCount() != null) && 
      (!other.getPermissionsBoundaryUsageCount().equals(getPermissionsBoundaryUsageCount()))) {
      return false;
    }
    if (((other.getIsAttachable() == null ? 1 : 0) ^ (getIsAttachable() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsAttachable() != null) && (!other.getIsAttachable().equals(getIsAttachable()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    if (((other.getUpdateDate() == null ? 1 : 0) ^ (getUpdateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUpdateDate() != null) && (!other.getUpdateDate().equals(getUpdateDate()))) {
      return false;
    }
    if (((other.getPolicyVersionList() == null ? 1 : 0) ^ (getPolicyVersionList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyVersionList() != null) && (!other.getPolicyVersionList().equals(getPolicyVersionList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    hashCode = 31 * hashCode + (getPolicyId() == null ? 0 : getPolicyId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getDefaultVersionId() == null ? 0 : getDefaultVersionId().hashCode());
    hashCode = 31 * hashCode + (getAttachmentCount() == null ? 0 : getAttachmentCount().hashCode());
    hashCode = 31 * hashCode + (getPermissionsBoundaryUsageCount() == null ? 0 : getPermissionsBoundaryUsageCount().hashCode());
    hashCode = 31 * hashCode + (getIsAttachable() == null ? 0 : getIsAttachable().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getUpdateDate() == null ? 0 : getUpdateDate().hashCode());
    hashCode = 31 * hashCode + (getPolicyVersionList() == null ? 0 : getPolicyVersionList().hashCode());
    return hashCode;
  }
  
  public ManagedPolicyDetail clone()
  {
    try
    {
      return (ManagedPolicyDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ManagedPolicyDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */