package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class ServerCertificate
  implements Serializable, Cloneable
{
  private ServerCertificateMetadata serverCertificateMetadata;
  private String certificateBody;
  private String certificateChain;
  
  public ServerCertificate() {}
  
  public ServerCertificate(ServerCertificateMetadata serverCertificateMetadata, String certificateBody)
  {
    setServerCertificateMetadata(serverCertificateMetadata);
    setCertificateBody(certificateBody);
  }
  
  public void setServerCertificateMetadata(ServerCertificateMetadata serverCertificateMetadata)
  {
    this.serverCertificateMetadata = serverCertificateMetadata;
  }
  
  public ServerCertificateMetadata getServerCertificateMetadata()
  {
    return serverCertificateMetadata;
  }
  
  public ServerCertificate withServerCertificateMetadata(ServerCertificateMetadata serverCertificateMetadata)
  {
    setServerCertificateMetadata(serverCertificateMetadata);
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
  
  public ServerCertificate withCertificateBody(String certificateBody)
  {
    setCertificateBody(certificateBody);
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
  
  public ServerCertificate withCertificateChain(String certificateChain)
  {
    setCertificateChain(certificateChain);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerCertificateMetadata() != null) {
      sb.append("ServerCertificateMetadata: ").append(getServerCertificateMetadata()).append(",");
    }
    if (getCertificateBody() != null) {
      sb.append("CertificateBody: ").append(getCertificateBody()).append(",");
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
    if (!(obj instanceof ServerCertificate)) {
      return false;
    }
    ServerCertificate other = (ServerCertificate)obj;
    if (((other.getServerCertificateMetadata() == null ? 1 : 0) ^ (getServerCertificateMetadata() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateMetadata() != null) && (!other.getServerCertificateMetadata().equals(getServerCertificateMetadata()))) {
      return false;
    }
    if (((other.getCertificateBody() == null ? 1 : 0) ^ (getCertificateBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCertificateBody() != null) && (!other.getCertificateBody().equals(getCertificateBody()))) {
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
    
    hashCode = 31 * hashCode + (getServerCertificateMetadata() == null ? 0 : getServerCertificateMetadata().hashCode());
    hashCode = 31 * hashCode + (getCertificateBody() == null ? 0 : getCertificateBody().hashCode());
    hashCode = 31 * hashCode + (getCertificateChain() == null ? 0 : getCertificateChain().hashCode());
    return hashCode;
  }
  
  public ServerCertificate clone()
  {
    try
    {
      return (ServerCertificate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServerCertificate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */