package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListServerCertificatesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<ServerCertificateMetadata> serverCertificateMetadataList;
  private Boolean isTruncated;
  private String marker;
  
  public List<ServerCertificateMetadata> getServerCertificateMetadataList()
  {
    if (serverCertificateMetadataList == null) {
      serverCertificateMetadataList = new SdkInternalList();
    }
    return serverCertificateMetadataList;
  }
  
  public void setServerCertificateMetadataList(Collection<ServerCertificateMetadata> serverCertificateMetadataList)
  {
    if (serverCertificateMetadataList == null)
    {
      this.serverCertificateMetadataList = null;
      return;
    }
    this.serverCertificateMetadataList = new SdkInternalList(serverCertificateMetadataList);
  }
  
  public ListServerCertificatesResult withServerCertificateMetadataList(ServerCertificateMetadata... serverCertificateMetadataList)
  {
    if (this.serverCertificateMetadataList == null) {
      setServerCertificateMetadataList(new SdkInternalList(serverCertificateMetadataList.length));
    }
    for (ServerCertificateMetadata ele : serverCertificateMetadataList) {
      this.serverCertificateMetadataList.add(ele);
    }
    return this;
  }
  
  public ListServerCertificatesResult withServerCertificateMetadataList(Collection<ServerCertificateMetadata> serverCertificateMetadataList)
  {
    setServerCertificateMetadataList(serverCertificateMetadataList);
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
  
  public ListServerCertificatesResult withIsTruncated(Boolean isTruncated)
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
  
  public ListServerCertificatesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerCertificateMetadataList() != null) {
      sb.append("ServerCertificateMetadataList: ").append(getServerCertificateMetadataList()).append(",");
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
    if (!(obj instanceof ListServerCertificatesResult)) {
      return false;
    }
    ListServerCertificatesResult other = (ListServerCertificatesResult)obj;
    if (((other.getServerCertificateMetadataList() == null ? 1 : 0) ^ (getServerCertificateMetadataList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateMetadataList() != null) && 
      (!other.getServerCertificateMetadataList().equals(getServerCertificateMetadataList()))) {
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
    
    hashCode = 31 * hashCode + (getServerCertificateMetadataList() == null ? 0 : getServerCertificateMetadataList().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListServerCertificatesResult clone()
  {
    try
    {
      return (ListServerCertificatesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServerCertificatesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */