package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.AliasListEntryMarshaller;
import java.io.Serializable;

public class AliasListEntry
  implements Serializable, Cloneable, StructuredPojo
{
  private String aliasName;
  private String aliasArn;
  private String targetKeyId;
  
  public void setAliasName(String aliasName)
  {
    this.aliasName = aliasName;
  }
  
  public String getAliasName()
  {
    return aliasName;
  }
  
  public AliasListEntry withAliasName(String aliasName)
  {
    setAliasName(aliasName);
    return this;
  }
  
  public void setAliasArn(String aliasArn)
  {
    this.aliasArn = aliasArn;
  }
  
  public String getAliasArn()
  {
    return aliasArn;
  }
  
  public AliasListEntry withAliasArn(String aliasArn)
  {
    setAliasArn(aliasArn);
    return this;
  }
  
  public void setTargetKeyId(String targetKeyId)
  {
    this.targetKeyId = targetKeyId;
  }
  
  public String getTargetKeyId()
  {
    return targetKeyId;
  }
  
  public AliasListEntry withTargetKeyId(String targetKeyId)
  {
    setTargetKeyId(targetKeyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAliasName() != null) {
      sb.append("AliasName: ").append(getAliasName()).append(",");
    }
    if (getAliasArn() != null) {
      sb.append("AliasArn: ").append(getAliasArn()).append(",");
    }
    if (getTargetKeyId() != null) {
      sb.append("TargetKeyId: ").append(getTargetKeyId());
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
    if (!(obj instanceof AliasListEntry)) {
      return false;
    }
    AliasListEntry other = (AliasListEntry)obj;
    if (((other.getAliasName() == null ? 1 : 0) ^ (getAliasName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAliasName() != null) && (!other.getAliasName().equals(getAliasName()))) {
      return false;
    }
    if (((other.getAliasArn() == null ? 1 : 0) ^ (getAliasArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAliasArn() != null) && (!other.getAliasArn().equals(getAliasArn()))) {
      return false;
    }
    if (((other.getTargetKeyId() == null ? 1 : 0) ^ (getTargetKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetKeyId() != null) && (!other.getTargetKeyId().equals(getTargetKeyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAliasName() == null ? 0 : getAliasName().hashCode());
    hashCode = 31 * hashCode + (getAliasArn() == null ? 0 : getAliasArn().hashCode());
    hashCode = 31 * hashCode + (getTargetKeyId() == null ? 0 : getTargetKeyId().hashCode());
    return hashCode;
  }
  
  public AliasListEntry clone()
  {
    try
    {
      return (AliasListEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AliasListEntryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.AliasListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */