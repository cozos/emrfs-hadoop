package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetSSHPublicKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String sSHPublicKeyId;
  private String encoding;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public GetSSHPublicKeyRequest withUserName(String userName)
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
  
  public GetSSHPublicKeyRequest withSSHPublicKeyId(String sSHPublicKeyId)
  {
    setSSHPublicKeyId(sSHPublicKeyId);
    return this;
  }
  
  public void setEncoding(String encoding)
  {
    this.encoding = encoding;
  }
  
  public String getEncoding()
  {
    return encoding;
  }
  
  public GetSSHPublicKeyRequest withEncoding(String encoding)
  {
    setEncoding(encoding);
    return this;
  }
  
  public void setEncoding(EncodingType encoding)
  {
    withEncoding(encoding);
  }
  
  public GetSSHPublicKeyRequest withEncoding(EncodingType encoding)
  {
    this.encoding = encoding.toString();
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
    if (getEncoding() != null) {
      sb.append("Encoding: ").append(getEncoding());
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
    if (!(obj instanceof GetSSHPublicKeyRequest)) {
      return false;
    }
    GetSSHPublicKeyRequest other = (GetSSHPublicKeyRequest)obj;
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
    if (((other.getEncoding() == null ? 1 : 0) ^ (getEncoding() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncoding() != null) && (!other.getEncoding().equals(getEncoding()))) {
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
    hashCode = 31 * hashCode + (getEncoding() == null ? 0 : getEncoding().hashCode());
    return hashCode;
  }
  
  public GetSSHPublicKeyRequest clone()
  {
    return (GetSSHPublicKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */