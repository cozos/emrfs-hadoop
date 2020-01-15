package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteSigningCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String certificateId;
  
  public DeleteSigningCertificateRequest() {}
  
  public DeleteSigningCertificateRequest(String certificateId)
  {
    setCertificateId(certificateId);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public DeleteSigningCertificateRequest withUserName(String userName)
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
  
  public DeleteSigningCertificateRequest withCertificateId(String certificateId)
  {
    setCertificateId(certificateId);
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
      sb.append("CertificateId: ").append(getCertificateId());
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
    if (!(obj instanceof DeleteSigningCertificateRequest)) {
      return false;
    }
    DeleteSigningCertificateRequest other = (DeleteSigningCertificateRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getCertificateId() == null ? 0 : getCertificateId().hashCode());
    return hashCode;
  }
  
  public DeleteSigningCertificateRequest clone()
  {
    return (DeleteSigningCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */