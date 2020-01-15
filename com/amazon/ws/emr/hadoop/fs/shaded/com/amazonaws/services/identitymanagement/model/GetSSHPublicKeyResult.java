package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetSSHPublicKeyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SSHPublicKey sSHPublicKey;
  
  public void setSSHPublicKey(SSHPublicKey sSHPublicKey)
  {
    this.sSHPublicKey = sSHPublicKey;
  }
  
  public SSHPublicKey getSSHPublicKey()
  {
    return sSHPublicKey;
  }
  
  public GetSSHPublicKeyResult withSSHPublicKey(SSHPublicKey sSHPublicKey)
  {
    setSSHPublicKey(sSHPublicKey);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSSHPublicKey() != null) {
      sb.append("SSHPublicKey: ").append(getSSHPublicKey());
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
    if (!(obj instanceof GetSSHPublicKeyResult)) {
      return false;
    }
    GetSSHPublicKeyResult other = (GetSSHPublicKeyResult)obj;
    if (((other.getSSHPublicKey() == null ? 1 : 0) ^ (getSSHPublicKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSHPublicKey() != null) && (!other.getSSHPublicKey().equals(getSSHPublicKey()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSSHPublicKey() == null ? 0 : getSSHPublicKey().hashCode());
    return hashCode;
  }
  
  public GetSSHPublicKeyResult clone()
  {
    try
    {
      return (GetSSHPublicKeyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */