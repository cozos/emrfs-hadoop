package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListSSHPublicKeysResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<SSHPublicKeyMetadata> sSHPublicKeys;
  private Boolean isTruncated;
  private String marker;
  
  public List<SSHPublicKeyMetadata> getSSHPublicKeys()
  {
    if (sSHPublicKeys == null) {
      sSHPublicKeys = new SdkInternalList();
    }
    return sSHPublicKeys;
  }
  
  public void setSSHPublicKeys(Collection<SSHPublicKeyMetadata> sSHPublicKeys)
  {
    if (sSHPublicKeys == null)
    {
      this.sSHPublicKeys = null;
      return;
    }
    this.sSHPublicKeys = new SdkInternalList(sSHPublicKeys);
  }
  
  public ListSSHPublicKeysResult withSSHPublicKeys(SSHPublicKeyMetadata... sSHPublicKeys)
  {
    if (this.sSHPublicKeys == null) {
      setSSHPublicKeys(new SdkInternalList(sSHPublicKeys.length));
    }
    for (SSHPublicKeyMetadata ele : sSHPublicKeys) {
      this.sSHPublicKeys.add(ele);
    }
    return this;
  }
  
  public ListSSHPublicKeysResult withSSHPublicKeys(Collection<SSHPublicKeyMetadata> sSHPublicKeys)
  {
    setSSHPublicKeys(sSHPublicKeys);
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
  
  public ListSSHPublicKeysResult withIsTruncated(Boolean isTruncated)
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
  
  public ListSSHPublicKeysResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSSHPublicKeys() != null) {
      sb.append("SSHPublicKeys: ").append(getSSHPublicKeys()).append(",");
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
    if (!(obj instanceof ListSSHPublicKeysResult)) {
      return false;
    }
    ListSSHPublicKeysResult other = (ListSSHPublicKeysResult)obj;
    if (((other.getSSHPublicKeys() == null ? 1 : 0) ^ (getSSHPublicKeys() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSHPublicKeys() != null) && (!other.getSSHPublicKeys().equals(getSSHPublicKeys()))) {
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
    
    hashCode = 31 * hashCode + (getSSHPublicKeys() == null ? 0 : getSSHPublicKeys().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListSSHPublicKeysResult clone()
  {
    try
    {
      return (ListSSHPublicKeysResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */