package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class SigningCertificate
  implements Serializable, Cloneable
{
  private String userName;
  private String certificateId;
  private String certificateBody;
  private String status;
  private Date uploadDate;
  
  public SigningCertificate() {}
  
  public SigningCertificate(String userName, String certificateId, String certificateBody, String status)
  {
    setUserName(userName);
    setCertificateId(certificateId);
    setCertificateBody(certificateBody);
    setStatus(status);
  }
  
  public SigningCertificate(String userName, String certificateId, String certificateBody, StatusType status)
  {
    setUserName(userName);
    setCertificateId(certificateId);
    setCertificateBody(certificateBody);
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
  
  public SigningCertificate withUserName(String userName)
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
  
  public SigningCertificate withCertificateId(String certificateId)
  {
    setCertificateId(certificateId);
    return this;
  }
  
  public void setCertificateBody(String certificateBody)
  {
    this.certificateBody = certificateBody;
  }
  
  public String getCertificateBody()
  {
    return certificateBody;
  }
  
  public SigningCertificate withCertificateBody(String certificateBody)
  {
    setCertificateBody(certificateBody);
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
  
  public SigningCertificate withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public SigningCertificate withStatus(StatusType status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setUploadDate(Date uploadDate)
  {
    this.uploadDate = uploadDate;
  }
  
  public Date getUploadDate()
  {
    return uploadDate;
  }
  
  public SigningCertificate withUploadDate(Date uploadDate)
  {
    setUploadDate(uploadDate);
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
    if (getCertificateBody() != null) {
      sb.append("CertificateBody: ").append(getCertificateBody()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getUploadDate() != null) {
      sb.append("UploadDate: ").append(getUploadDate());
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
    if (!(obj instanceof SigningCertificate)) {
      return false;
    }
    SigningCertificate other = (SigningCertificate)obj;
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
    if (((other.getCertificateBody() == null ? 1 : 0) ^ (getCertificateBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificateBody() != null) && (!other.getCertificateBody().equals(getCertificateBody()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getUploadDate() == null ? 1 : 0) ^ (getUploadDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUploadDate() != null) && (!other.getUploadDate().equals(getUploadDate()))) {
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
    hashCode = 31 * hashCode + (getCertificateBody() == null ? 0 : getCertificateBody().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getUploadDate() == null ? 0 : getUploadDate().hashCode());
    return hashCode;
  }
  
  public SigningCertificate clone()
  {
    try
    {
      return (SigningCertificate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SigningCertificate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */