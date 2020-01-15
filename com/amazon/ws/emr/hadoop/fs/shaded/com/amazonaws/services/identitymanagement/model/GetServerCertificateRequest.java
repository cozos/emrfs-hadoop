package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetServerCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String serverCertificateName;
  
  public GetServerCertificateRequest() {}
  
  public GetServerCertificateRequest(String serverCertificateName)
  {
    setServerCertificateName(serverCertificateName);
  }
  
  public void setServerCertificateName(String serverCertificateName)
  {
    this.serverCertificateName = serverCertificateName;
  }
  
  public String getServerCertificateName()
  {
    return serverCertificateName;
  }
  
  public GetServerCertificateRequest withServerCertificateName(String serverCertificateName)
  {
    setServerCertificateName(serverCertificateName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerCertificateName() != null) {
      sb.append("ServerCertificateName: ").append(getServerCertificateName());
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
    if (!(obj instanceof GetServerCertificateRequest)) {
      return false;
    }
    GetServerCertificateRequest other = (GetServerCertificateRequest)obj;
    if (((other.getServerCertificateName() == null ? 1 : 0) ^ (getServerCertificateName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateName() != null) && (!other.getServerCertificateName().equals(getServerCertificateName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServerCertificateName() == null ? 0 : getServerCertificateName().hashCode());
    return hashCode;
  }
  
  public GetServerCertificateRequest clone()
  {
    return (GetServerCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */