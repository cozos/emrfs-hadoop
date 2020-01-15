package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class SSHPublicKey
  implements Serializable, Cloneable
{
  private String userName;
  private String sSHPublicKeyId;
  private String fingerprint;
  private String sSHPublicKeyBody;
  private String status;
  private Date uploadDate;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public SSHPublicKey withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setSSHPublicKeyId(String sSHPublicKeyId)
  {
    this.sSHPublicKeyId = sSHPublicKeyId;
  }
  
  public String getSSHPublicKeyId()
  {
    return sSHPublicKeyId;
  }
  
  public SSHPublicKey withSSHPublicKeyId(String sSHPublicKeyId)
  {
    setSSHPublicKeyId(sSHPublicKeyId);
    return this;
  }
  
  public void setFingerprint(String fingerprint)
  {
    this.fingerprint = fingerprint;
  }
  
  public String getFingerprint()
  {
    return fingerprint;
  }
  
  public SSHPublicKey withFingerprint(String fingerprint)
  {
    setFingerprint(fingerprint);
    return this;
  }
  
  public void setSSHPublicKeyBody(String sSHPublicKeyBody)
  {
    this.sSHPublicKeyBody = sSHPublicKeyBody;
  }
  
  public String getSSHPublicKeyBody()
  {
    return sSHPublicKeyBody;
  }
  
  public SSHPublicKey withSSHPublicKeyBody(String sSHPublicKeyBody)
  {
    setSSHPublicKeyBody(sSHPublicKeyBody);
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
  
  public SSHPublicKey withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(StatusType status)
  {
    withStatus(status);
  }
  
  public SSHPublicKey withStatus(StatusType status)
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
  
  public SSHPublicKey withUploadDate(Date uploadDate)
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
    if (getSSHPublicKeyId() != null) {
      sb.append("SSHPublicKeyId: ").append(getSSHPublicKeyId()).append(",");
    }
    if (getFingerprint() != null) {
      sb.append("Fingerprint: ").append(getFingerprint()).append(",");
    }
    if (getSSHPublicKeyBody() != null) {
      sb.append("SSHPublicKeyBody: ").append(getSSHPublicKeyBody()).append(",");
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
    if (!(obj instanceof SSHPublicKey)) {
      return false;
    }
    SSHPublicKey other = (SSHPublicKey)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getSSHPublicKeyId() == null ? 1 : 0) ^ (getSSHPublicKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSHPublicKeyId() != null) && (!other.getSSHPublicKeyId().equals(getSSHPublicKeyId()))) {
      return false;
    }
    if (((other.getFingerprint() == null ? 1 : 0) ^ (getFingerprint() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFingerprint() != null) && (!other.getFingerprint().equals(getFingerprint()))) {
      return false;
    }
    if (((other.getSSHPublicKeyBody() == null ? 1 : 0) ^ (getSSHPublicKeyBody() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSHPublicKeyBody() != null) && (!other.getSSHPublicKeyBody().equals(getSSHPublicKeyBody()))) {
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
    hashCode = 31 * hashCode + (getSSHPublicKeyId() == null ? 0 : getSSHPublicKeyId().hashCode());
    hashCode = 31 * hashCode + (getFingerprint() == null ? 0 : getFingerprint().hashCode());
    hashCode = 31 * hashCode + (getSSHPublicKeyBody() == null ? 0 : getSSHPublicKeyBody().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getUploadDate() == null ? 0 : getUploadDate().hashCode());
    return hashCode;
  }
  
  public SSHPublicKey clone()
  {
    try
    {
      return (SSHPublicKey)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SSHPublicKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */