package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class ServerSideEncryptionS3
  implements InventoryEncryption, Serializable, Cloneable
{
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof ServerSideEncryptionS3)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int hashCode = 1;
    return hashCode;
  }
  
  public ServerSideEncryptionS3 clone()
  {
    try
    {
      return (ServerSideEncryptionS3)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionS3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */