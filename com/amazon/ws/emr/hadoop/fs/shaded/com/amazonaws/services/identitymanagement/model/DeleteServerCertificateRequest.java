package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteServerCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String serverCertificateName;
  
  public DeleteServerCertificateRequest() {}
  
  public DeleteServerCertificateRequest(String serverCertificateName)
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
  
  public DeleteServerCertificateRequest withServerCertificateName(String serverCertificateName)
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
    if (!(obj instanceof DeleteServerCertificateRequest)) {
      return false;
    }
    DeleteServerCertificateRequest other = (DeleteServerCertificateRequest)obj;
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
  
  public DeleteServerCertificateRequest clone()
  {
    return (DeleteServerCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServerCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */