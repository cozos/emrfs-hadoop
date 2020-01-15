package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class ServerCertificateMetadata
  implements Serializable, Cloneable
{
  private String path;
  private String serverCertificateName;
  private String serverCertificateId;
  private String arn;
  private Date uploadDate;
  private Date expiration;
  
  public ServerCertificateMetadata() {}
  
  public ServerCertificateMetadata(String path, String serverCertificateName, String serverCertificateId, String arn)
  {
    setPath(path);
    setServerCertificateName(serverCertificateName);
    setServerCertificateId(serverCertificateId);
    setArn(arn);
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public ServerCertificateMetadata withPath(String path)
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
  
  public ServerCertificateMetadata withServerCertificateName(String serverCertificateName)
  {
    setServerCertificateName(serverCertificateName);
    return this;
  }
  
  public void setServerCertificateId(String serverCertificateId)
  {
    this.serverCertificateId = serverCertificateId;
  }
  
  public String getServerCertificateId()
  {
    return serverCertificateId;
  }
  
  public ServerCertificateMetadata withServerCertificateId(String serverCertificateId)
  {
    setServerCertificateId(serverCertificateId);
    return this;
  }
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public ServerCertificateMetadata withArn(String arn)
  {
    setArn(arn);
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
  
  public ServerCertificateMetadata withUploadDate(Date uploadDate)
  {
    setUploadDate(uploadDate);
    return this;
  }
  
  public void setExpiration(Date expiration)
  {
    this.expiration = expiration;
  }
  
  public Date getExpiration()
  {
    return expiration;
  }
  
  public ServerCertificateMetadata withExpiration(Date expiration)
  {
    setExpiration(expiration);
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
    if (getServerCertificateId() != null) {
      sb.append("ServerCertificateId: ").append(getServerCertificateId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getUploadDate() != null) {
      sb.append("UploadDate: ").append(getUploadDate()).append(",");
    }
    if (getExpiration() != null) {
      sb.append("Expiration: ").append(getExpiration());
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
    if (!(obj instanceof ServerCertificateMetadata)) {
      return false;
    }
    ServerCertificateMetadata other = (ServerCertificateMetadata)obj;
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
    if (((other.getServerCertificateId() == null ? 1 : 0) ^ (getServerCertificateId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateId() != null) && (!other.getServerCertificateId().equals(getServerCertificateId()))) {
      return false;
    }
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getUploadDate() == null ? 1 : 0) ^ (getUploadDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUploadDate() != null) && (!other.getUploadDate().equals(getUploadDate()))) {
      return false;
    }
    if (((other.getExpiration() == null ? 1 : 0) ^ (getExpiration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpiration() != null) && (!other.getExpiration().equals(getExpiration()))) {
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
    hashCode = 31 * hashCode + (getServerCertificateId() == null ? 0 : getServerCertificateId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getUploadDate() == null ? 0 : getUploadDate().hashCode());
    hashCode = 31 * hashCode + (getExpiration() == null ? 0 : getExpiration().hashCode());
    return hashCode;
  }
  
  public ServerCertificateMetadata clone()
  {
    try
    {
      return (ServerCertificateMetadata)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServerCertificateMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */