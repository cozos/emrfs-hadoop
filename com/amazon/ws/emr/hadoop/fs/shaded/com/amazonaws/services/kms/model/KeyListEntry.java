package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KeyListEntryMarshaller;
import java.io.Serializable;

public class KeyListEntry
  implements Serializable, Cloneable, StructuredPojo
{
  private String keyId;
  private String keyArn;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public KeyListEntry withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setKeyArn(String keyArn)
  {
    this.keyArn = keyArn;
  }
  
  public String getKeyArn()
  {
    return keyArn;
  }
  
  public KeyListEntry withKeyArn(String keyArn)
  {
    setKeyArn(keyArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getKeyArn() != null) {
      sb.append("KeyArn: ").append(getKeyArn());
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
    if (!(obj instanceof KeyListEntry)) {
      return false;
    }
    KeyListEntry other = (KeyListEntry)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getKeyArn() == null ? 1 : 0) ^ (getKeyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyArn() != null) && (!other.getKeyArn().equals(getKeyArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getKeyArn() == null ? 0 : getKeyArn().hashCode());
    return hashCode;
  }
  
  public KeyListEntry clone()
  {
    try
    {
      return (KeyListEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    KeyListEntryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.KeyListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */