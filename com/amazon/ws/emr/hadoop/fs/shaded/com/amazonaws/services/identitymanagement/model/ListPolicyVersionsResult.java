package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListPolicyVersionsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<PolicyVersion> versions;
  private Boolean isTruncated;
  private String marker;
  
  public List<PolicyVersion> getVersions()
  {
    if (versions == null) {
      versions = new SdkInternalList();
    }
    return versions;
  }
  
  public void setVersions(Collection<PolicyVersion> versions)
  {
    if (versions == null)
    {
      this.versions = null;
      return;
    }
    this.versions = new SdkInternalList(versions);
  }
  
  public ListPolicyVersionsResult withVersions(PolicyVersion... versions)
  {
    if (this.versions == null) {
      setVersions(new SdkInternalList(versions.length));
    }
    for (PolicyVersion ele : versions) {
      this.versions.add(ele);
    }
    return this;
  }
  
  public ListPolicyVersionsResult withVersions(Collection<PolicyVersion> versions)
  {
    setVersions(versions);
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
  
  public ListPolicyVersionsResult withIsTruncated(Boolean isTruncated)
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
  
  public ListPolicyVersionsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getVersions() != null) {
      sb.append("Versions: ").append(getVersions()).append(",");
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
    if (!(obj instanceof ListPolicyVersionsResult)) {
      return false;
    }
    ListPolicyVersionsResult other = (ListPolicyVersionsResult)obj;
    if (((other.getVersions() == null ? 1 : 0) ^ (getVersions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVersions() != null) && (!other.getVersions().equals(getVersions()))) {
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
    
    hashCode = 31 * hashCode + (getVersions() == null ? 0 : getVersions().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListPolicyVersionsResult clone()
  {
    try
    {
      return (ListPolicyVersionsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */