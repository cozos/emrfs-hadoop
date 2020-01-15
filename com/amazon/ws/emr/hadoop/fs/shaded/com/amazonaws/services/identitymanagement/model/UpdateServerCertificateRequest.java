package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateServerCertificateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String serverCertificateName;
  private String newPath;
  private String newServerCertificateName;
  
  public UpdateServerCertificateRequest() {}
  
  public UpdateServerCertificateRequest(String serverCertificateName)
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
  
  public UpdateServerCertificateRequest withServerCertificateName(String serverCertificateName)
  {
    setServerCertificateName(serverCertificateName);
    return this;
  }
  
  public void setNewPath(String newPath)
  {
    this.newPath = newPath;
  }
  
  public String getNewPath()
  {
    return newPath;
  }
  
  public UpdateServerCertificateRequest withNewPath(String newPath)
  {
    setNewPath(newPath);
    return this;
  }
  
  public void setNewServerCertificateName(String newServerCertificateName)
  {
    this.newServerCertificateName = newServerCertificateName;
  }
  
  public String getNewServerCertificateName()
  {
    return newServerCertificateName;
  }
  
  public UpdateServerCertificateRequest withNewServerCertificateName(String newServerCertificateName)
  {
    setNewServerCertificateName(newServerCertificateName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerCertificateName() != null) {
      sb.append("ServerCertificateName: ").append(getServerCertificateName()).append(",");
    }
    if (getNewPath() != null) {
      sb.append("NewPath: ").append(getNewPath()).append(",");
    }
    if (getNewServerCertificateName() != null) {
      sb.append("NewServerCertificateName: ").append(getNewServerCertificateName());
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
    if (!(obj instanceof UpdateServerCertificateRequest)) {
      return false;
    }
    UpdateServerCertificateRequest other = (UpdateServerCertificateRequest)obj;
    if (((other.getServerCertificateName() == null ? 1 : 0) ^ (getServerCertificateName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateName() != null) && (!other.getServerCertificateName().equals(getServerCertificateName()))) {
      return false;
    }
    if (((other.getNewPath() == null ? 1 : 0) ^ (getNewPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewPath() != null) && (!other.getNewPath().equals(getNewPath()))) {
      return false;
    }
    if (((other.getNewServerCertificateName() == null ? 1 : 0) ^ (getNewServerCertificateName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewServerCertificateName() != null) && (!other.getNewServerCertificateName().equals(getNewServerCertificateName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServerCertificateName() == null ? 0 : getServerCertificateName().hashCode());
    hashCode = 31 * hashCode + (getNewPath() == null ? 0 : getNewPath().hashCode());
    hashCode = 31 * hashCode + (getNewServerCertificateName() == null ? 0 : getNewServerCertificateName().hashCode());
    return hashCode;
  }
  
  public UpdateServerCertificateRequest clone()
  {
    return (UpdateServerCertificateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */