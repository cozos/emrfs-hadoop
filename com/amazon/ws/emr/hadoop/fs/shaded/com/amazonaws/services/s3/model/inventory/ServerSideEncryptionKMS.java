package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class ServerSideEncryptionKMS
  implements InventoryEncryption, Serializable, Cloneable
{
  private String keyId;
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public ServerSideEncryptionKMS withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
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
    if (!(obj instanceof ServerSideEncryptionKMS)) {
      return false;
    }
    ServerSideEncryptionKMS other = (ServerSideEncryptionKMS)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    return hashCode;
  }
  
  public ServerSideEncryptionKMS clone()
  {
    try
    {
      return (ServerSideEncryptionKMS)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionKMS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */