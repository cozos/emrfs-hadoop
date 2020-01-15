package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListMFADevicesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<MFADevice> mFADevices;
  private Boolean isTruncated;
  private String marker;
  
  public List<MFADevice> getMFADevices()
  {
    if (mFADevices == null) {
      mFADevices = new SdkInternalList();
    }
    return mFADevices;
  }
  
  public void setMFADevices(Collection<MFADevice> mFADevices)
  {
    if (mFADevices == null)
    {
      this.mFADevices = null;
      return;
    }
    this.mFADevices = new SdkInternalList(mFADevices);
  }
  
  public ListMFADevicesResult withMFADevices(MFADevice... mFADevices)
  {
    if (this.mFADevices == null) {
      setMFADevices(new SdkInternalList(mFADevices.length));
    }
    for (MFADevice ele : mFADevices) {
      this.mFADevices.add(ele);
    }
    return this;
  }
  
  public ListMFADevicesResult withMFADevices(Collection<MFADevice> mFADevices)
  {
    setMFADevices(mFADevices);
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
  
  public ListMFADevicesResult withIsTruncated(Boolean isTruncated)
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
  
  public ListMFADevicesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMFADevices() != null) {
      sb.append("MFADevices: ").append(getMFADevices()).append(",");
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
    if (!(obj instanceof ListMFADevicesResult)) {
      return false;
    }
    ListMFADevicesResult other = (ListMFADevicesResult)obj;
    if (((other.getMFADevices() == null ? 1 : 0) ^ (getMFADevices() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMFADevices() != null) && (!other.getMFADevices().equals(getMFADevices()))) {
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
    
    hashCode = 31 * hashCode + (getMFADevices() == null ? 0 : getMFADevices().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListMFADevicesResult clone()
  {
    try
    {
      return (ListMFADevicesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListMFADevicesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */