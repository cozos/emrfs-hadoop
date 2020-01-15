package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UploadSigningCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String certificateBody;
  
  public UploadSigningCertificateRequest() {}
  
  public UploadSigningCertificateRequest(String certificateBody)
  {
    setCertificateBody(certificateBody);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public UploadSigningCertificateRequest withUserName(String userName)
  {
    setUserName(userName);
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
  
  public UploadSigningCertificateRequest withCertificateBody(String certificateBody)
  {
    setCertificateBody(certificateBody);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getCertificateBody() != null) {
      sb.append("CertificateBody: ").append(getCertificateBody());
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
    if (!(obj instanceof UploadSigningCertificateRequest)) {
      return false;
    }
    UploadSigningCertificateRequest other = (UploadSigningCertificateRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getCertificateBody() == null ? 1 : 0) ^ (getCertificateBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificateBody() != null) && (!other.getCertificateBody().equals(getCertificateBody()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getCertificateBody() == null ? 0 : getCertificateBody().hashCode());
    return hashCode;
  }
  
  public UploadSigningCertificateRequest clone()
  {
    return (UploadSigningCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSigningCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */