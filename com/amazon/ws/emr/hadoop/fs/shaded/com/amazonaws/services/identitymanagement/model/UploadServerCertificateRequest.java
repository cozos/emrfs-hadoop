package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UploadServerCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String path;
  private String serverCertificateName;
  private String certificateBody;
  private String privateKey;
  private String certificateChain;
  
  public UploadServerCertificateRequest() {}
  
  public UploadServerCertificateRequest(String serverCertificateName, String certificateBody, String privateKey)
  {
    setServerCertificateName(serverCertificateName);
    setCertificateBody(certificateBody);
    setPrivateKey(privateKey);
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public UploadServerCertificateRequest withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setServerCertificateName(String serverCertificateName)
  {
    this.serverCertificateName = serverCertificateName;
  }
  
  public String getServerCertificateName()
  {
    return serverCertificateName;
  }
  
  public UploadServerCertificateRequest withServerCertificateName(String serverCertificateName)
  {
    setServerCertificateName(serverCertificateName);
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
  
  public UploadServerCertificateRequest withCertificateBody(String certificateBody)
  {
    setCertificateBody(certificateBody);
    return this;
  }
  
  public void setPrivateKey(String privateKey)
  {
    this.privateKey = privateKey;
  }
  
  public String getPrivateKey()
  {
    return privateKey;
  }
  
  public UploadServerCertificateRequest withPrivateKey(String privateKey)
  {
    setPrivateKey(privateKey);
    return this;
  }
  
  public void setCertificateChain(String certificateChain)
  {
    this.certificateChain = certificateChain;
  }
  
  public String getCertificateChain()
  {
    return certificateChain;
  }
  
  public UploadServerCertificateRequest withCertificateChain(String certificateChain)
  {
    setCertificateChain(certificateChain);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getServerCertificateName() != null) {
      sb.append("ServerCertificateName: ").append(getServerCertificateName()).append(",");
    }
    if (getCertificateBody() != null) {
      sb.append("CertificateBody: ").append(getCertificateBody()).append(",");
    }
    if (getPrivateKey() != null) {
      sb.append("PrivateKey: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getCertificateChain() != null) {
      sb.append("CertificateChain: ").append(getCertificateChain());
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
    if (!(obj instanceof UploadServerCertificateRequest)) {
      return false;
    }
    UploadServerCertificateRequest other = (UploadServerCertificateRequest)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getServerCertificateName() == null ? 1 : 0) ^ (getServerCertificateName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateName() != null) && (!other.getServerCertificateName().equals(getServerCertificateName()))) {
      return false;
    }
    if (((other.getCertificateBody() == null ? 1 : 0) ^ (getCertificateBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificateBody() != null) && (!other.getCertificateBody().equals(getCertificateBody()))) {
      return false;
    }
    if (((other.getPrivateKey() == null ? 1 : 0) ^ (getPrivateKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPrivateKey() != null) && (!other.getPrivateKey().equals(getPrivateKey()))) {
      return false;
    }
    if (((other.getCertificateChain() == null ? 1 : 0) ^ (getCertificateChain() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificateChain() != null) && (!other.getCertificateChain().equals(getCertificateChain()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getServerCertificateName() == null ? 0 : getServerCertificateName().hashCode());
    hashCode = 31 * hashCode + (getCertificateBody() == null ? 0 : getCertificateBody().hashCode());
    hashCode = 31 * hashCode + (getPrivateKey() == null ? 0 : getPrivateKey().hashCode());
    hashCode = 31 * hashCode + (getCertificateChain() == null ? 0 : getCertificateChain().hashCode());
    return hashCode;
  }
  
  public UploadServerCertificateRequest clone()
  {
    return (UploadServerCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */