package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListSigningCertificatesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<SigningCertificate> certificates;
  private Boolean isTruncated;
  private String marker;
  
  public List<SigningCertificate> getCertificates()
  {
    if (certificates == null) {
      certificates = new SdkInternalList();
    }
    return certificates;
  }
  
  public void setCertificates(Collection<SigningCertificate> certificates)
  {
    if (certificates == null)
    {
      this.certificates = null;
      return;
    }
    this.certificates = new SdkInternalList(certificates);
  }
  
  public ListSigningCertificatesResult withCertificates(SigningCertificate... certificates)
  {
    if (this.certificates == null) {
      setCertificates(new SdkInternalList(certificates.length));
    }
    for (SigningCertificate ele : certificates) {
      this.certificates.add(ele);
    }
    return this;
  }
  
  public ListSigningCertificatesResult withCertificates(Collection<SigningCertificate> certificates)
  {
    setCertificates(certificates);
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
  
  public ListSigningCertificatesResult withIsTruncated(Boolean isTruncated)
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
  
  public ListSigningCertificatesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCertificates() != null) {
      sb.append("Certificates: ").append(getCertificates()).append(",");
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
    if (!(obj instanceof ListSigningCertificatesResult)) {
      return false;
    }
    ListSigningCertificatesResult other = (ListSigningCertificatesResult)obj;
    if (((other.getCertificates() == null ? 1 : 0) ^ (getCertificates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificates() != null) && (!other.getCertificates().equals(getCertificates()))) {
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
    
    hashCode = 31 * hashCode + (getCertificates() == null ? 0 : getCertificates().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListSigningCertificatesResult clone()
  {
    try
    {
      return (ListSigningCertificatesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSigningCertificatesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */