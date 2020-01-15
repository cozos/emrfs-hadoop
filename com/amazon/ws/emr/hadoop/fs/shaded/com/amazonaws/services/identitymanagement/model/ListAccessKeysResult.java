package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListAccessKeysResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<AccessKeyMetadata> accessKeyMetadata;
  private Boolean isTruncated;
  private String marker;
  
  public List<AccessKeyMetadata> getAccessKeyMetadata()
  {
    if (accessKeyMetadata == null) {
      accessKeyMetadata = new SdkInternalList();
    }
    return accessKeyMetadata;
  }
  
  public void setAccessKeyMetadata(Collection<AccessKeyMetadata> accessKeyMetadata)
  {
    if (accessKeyMetadata == null)
    {
      this.accessKeyMetadata = null;
      return;
    }
    this.accessKeyMetadata = new SdkInternalList(accessKeyMetadata);
  }
  
  public ListAccessKeysResult withAccessKeyMetadata(AccessKeyMetadata... accessKeyMetadata)
  {
    if (this.accessKeyMetadata == null) {
      setAccessKeyMetadata(new SdkInternalList(accessKeyMetadata.length));
    }
    for (AccessKeyMetadata ele : accessKeyMetadata) {
      this.accessKeyMetadata.add(ele);
    }
    return this;
  }
  
  public ListAccessKeysResult withAccessKeyMetadata(Collection<AccessKeyMetadata> accessKeyMetadata)
  {
    setAccessKeyMetadata(accessKeyMetadata);
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
  
  public ListAccessKeysResult withIsTruncated(Boolean isTruncated)
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
  
  public ListAccessKeysResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccessKeyMetadata() != null) {
      sb.append("AccessKeyMetadata: ").append(getAccessKeyMetadata()).append(",");
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
    if (!(obj instanceof ListAccessKeysResult)) {
      return false;
    }
    ListAccessKeysResult other = (ListAccessKeysResult)obj;
    if (((other.getAccessKeyMetadata() == null ? 1 : 0) ^ (getAccessKeyMetadata() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessKeyMetadata() != null) && (!other.getAccessKeyMetadata().equals(getAccessKeyMetadata()))) {
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
    
    hashCode = 31 * hashCode + (getAccessKeyMetadata() == null ? 0 : getAccessKeyMetadata().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListAccessKeysResult clone()
  {
    try
    {
      return (ListAccessKeysResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccessKeysResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */