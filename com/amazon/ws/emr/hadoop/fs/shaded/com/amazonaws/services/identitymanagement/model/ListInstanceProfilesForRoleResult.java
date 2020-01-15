package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListInstanceProfilesForRoleResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<InstanceProfile> instanceProfiles;
  private Boolean isTruncated;
  private String marker;
  
  public List<InstanceProfile> getInstanceProfiles()
  {
    if (instanceProfiles == null) {
      instanceProfiles = new SdkInternalList();
    }
    return instanceProfiles;
  }
  
  public void setInstanceProfiles(Collection<InstanceProfile> instanceProfiles)
  {
    if (instanceProfiles == null)
    {
      this.instanceProfiles = null;
      return;
    }
    this.instanceProfiles = new SdkInternalList(instanceProfiles);
  }
  
  public ListInstanceProfilesForRoleResult withInstanceProfiles(InstanceProfile... instanceProfiles)
  {
    if (this.instanceProfiles == null) {
      setInstanceProfiles(new SdkInternalList(instanceProfiles.length));
    }
    for (InstanceProfile ele : instanceProfiles) {
      this.instanceProfiles.add(ele);
    }
    return this;
  }
  
  public ListInstanceProfilesForRoleResult withInstanceProfiles(Collection<InstanceProfile> instanceProfiles)
  {
    setInstanceProfiles(instanceProfiles);
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
  
  public ListInstanceProfilesForRoleResult withIsTruncated(Boolean isTruncated)
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
  
  public ListInstanceProfilesForRoleResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceProfiles() != null) {
      sb.append("InstanceProfiles: ").append(getInstanceProfiles()).append(",");
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
    if (!(obj instanceof ListInstanceProfilesForRoleResult)) {
      return false;
    }
    ListInstanceProfilesForRoleResult other = (ListInstanceProfilesForRoleResult)obj;
    if (((other.getInstanceProfiles() == null ? 1 : 0) ^ (getInstanceProfiles() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfiles() != null) && (!other.getInstanceProfiles().equals(getInstanceProfiles()))) {
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
    
    hashCode = 31 * hashCode + (getInstanceProfiles() == null ? 0 : getInstanceProfiles().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListInstanceProfilesForRoleResult clone()
  {
    try
    {
      return (ListInstanceProfilesForRoleResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesForRoleResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */