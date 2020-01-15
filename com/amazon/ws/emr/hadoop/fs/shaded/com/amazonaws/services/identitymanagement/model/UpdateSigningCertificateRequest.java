package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateSigningCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String certificateId;
  private String status;
  
  public UpdateSigningCertificateRequest() {}
  
  public UpdateSigningCertificateRequest(String certificateId, String status)
  {
    setCertificateId(certificateId);
    setStatus(status);
  }
  
  public UpdateSigningCertificateRequest(String certificateId, StatusType status)
  {
    setCertificateId(certificateId);
    setStatus(status.toString());
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UpdateSigningCertificateRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setCertificateId(String certificateId)
  {
    this.certificateId = certificateId;
  }
  
  public String getCertificateId()
  {
    return certificateId;
  }
  
  public UpdateSigningCertificateRequest withCertificateId(String certificateId)
  {
    setCertificateId(certificateId);
    return this;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public UpdateSigningCertificateRequest withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public UpdateSigningCertificateRequest withStatus(StatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getCertificateId() != null) {
      sb.append("CertificateId: ").append(getCertificateId()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus());
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
    if (!(obj instanceof UpdateSigningCertificateRequest)) {
      return false;
    }
    UpdateSigningCertificateRequest other = (UpdateSigningCertificateRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getCertificateId() == null ? 1 : 0) ^ (getCertificateId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificateId() != null) && (!other.getCertificateId().equals(getCertificateId()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getCertificateId() == null ? 0 : getCertificateId().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    return hashCode;
  }
  
  public UpdateSigningCertificateRequest clone()
  {
    return (UpdateSigningCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */