package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class PolicyVersion
  implements Serializable, Cloneable
{
  private String document;
  private String versionId;
  private Boolean isDefaultVersion;
  private Date createDate;
  
  public void setDocument(String document)
  {
    this.document = document;
  }
  
  public String getDocument()
  {
    return document;
  }
  
  public PolicyVersion withDocument(String document)
  {
    setDocument(document);
    return this;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public PolicyVersion withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
  
  public void setIsDefaultVersion(Boolean isDefaultVersion)
  {
    this.isDefaultVersion = isDefaultVersion;
  }
  
  public Boolean getIsDefaultVersion()
  {
    return isDefaultVersion;
  }
  
  public PolicyVersion withIsDefaultVersion(Boolean isDefaultVersion)
  {
    setIsDefaultVersion(isDefaultVersion);
    return this;
  }
  
  public Boolean isDefaultVersion()
  {
    return isDefaultVersion;
  }
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public Date getCreateDate()
  {
    return createDate;
  }
  
  public PolicyVersion withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDocument() != null) {
      sb.append("Document: ").append(getDocument()).append(",");
    }
    if (getVersionId() != null) {
      sb.append("VersionId: ").append(getVersionId()).append(",");
    }
    if (getIsDefaultVersion() != null) {
      sb.append("IsDefaultVersion: ").append(getIsDefaultVersion()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate());
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
    if (!(obj instanceof PolicyVersion)) {
      return false;
    }
    PolicyVersion other = (PolicyVersion)obj;
    if (((other.getDocument() == null ? 1 : 0) ^ (getDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDocument() != null) && (!other.getDocument().equals(getDocument()))) {
      return false;
    }
    if (((other.getVersionId() == null ? 1 : 0) ^ (getVersionId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVersionId() != null) && (!other.getVersionId().equals(getVersionId()))) {
      return false;
    }
    if (((other.getIsDefaultVersion() == null ? 1 : 0) ^ (getIsDefaultVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsDefaultVersion() != null) && (!other.getIsDefaultVersion().equals(getIsDefaultVersion()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDocument() == null ? 0 : getDocument().hashCode());
    hashCode = 31 * hashCode + (getVersionId() == null ? 0 : getVersionId().hashCode());
    hashCode = 31 * hashCode + (getIsDefaultVersion() == null ? 0 : getIsDefaultVersion().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    return hashCode;
  }
  
  public PolicyVersion clone()
  {
    try
    {
      return (PolicyVersion)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */