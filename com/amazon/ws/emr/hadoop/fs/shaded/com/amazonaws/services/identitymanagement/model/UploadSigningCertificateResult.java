package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class UploadSigningCertificateResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SigningCertificate certificate;
  
  public void setCertificate(SigningCertificate certificate)
  {
    this.certificate = certificate;
  }
  
  public SigningCertificate getCertificate()
  {
    return certificate;
  }
  
  public UploadSigningCertificateResult withCertificate(SigningCertificate certificate)
  {
    setCertificate(certificate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCertificate() != null) {
      sb.append("Certificate: ").append(getCertificate());
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
    if (!(obj instanceof UploadSigningCertificateResult)) {
      return false;
    }
    UploadSigningCertificateResult other = (UploadSigningCertificateResult)obj;
    if (((other.getCertificate() == null ? 1 : 0) ^ (getCertificate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificate() != null) && (!other.getCertificate().equals(getCertificate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCertificate() == null ? 0 : getCertificate().hashCode());
    return hashCode;
  }
  
  public UploadSigningCertificateResult clone()
  {
    try
    {
      return (UploadSigningCertificateResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSigningCertificateResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */