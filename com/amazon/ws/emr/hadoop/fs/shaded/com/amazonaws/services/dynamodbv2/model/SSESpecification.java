package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SSESpecificationMarshaller;
import java.io.Serializable;

public class SSESpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private Boolean enabled;
  private String sSEType;
  private String kMSMasterKeyId;
  
  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }
  
  public Boolean getEnabled()
  {
    return enabled;
  }
  
  public SSESpecification withEnabled(Boolean enabled)
  {
    setEnabled(enabled);
    return this;
  }
  
  public Boolean isEnabled()
  {
    return enabled;
  }
  
  public void setSSEType(String sSEType)
  {
    this.sSEType = sSEType;
  }
  
  public String getSSEType()
  {
    return sSEType;
  }
  
  public SSESpecification withSSEType(String sSEType)
  {
    setSSEType(sSEType);
    return this;
  }
  
  public SSESpecification withSSEType(SSEType sSEType)
  {
    this.sSEType = sSEType.toString();
    return this;
  }
  
  public void setKMSMasterKeyId(String kMSMasterKeyId)
  {
    this.kMSMasterKeyId = kMSMasterKeyId;
  }
  
  public String getKMSMasterKeyId()
  {
    return kMSMasterKeyId;
  }
  
  public SSESpecification withKMSMasterKeyId(String kMSMasterKeyId)
  {
    setKMSMasterKeyId(kMSMasterKeyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEnabled() != null) {
      sb.append("Enabled: ").append(getEnabled()).append(",");
    }
    if (getSSEType() != null) {
      sb.append("SSEType: ").append(getSSEType()).append(",");
    }
    if (getKMSMasterKeyId() != null) {
      sb.append("KMSMasterKeyId: ").append(getKMSMasterKeyId());
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
    if (!(obj instanceof SSESpecification)) {
      return false;
    }
    SSESpecification other = (SSESpecification)obj;
    if (((other.getEnabled() == null ? 1 : 0) ^ (getEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEnabled() != null) && (!other.getEnabled().equals(getEnabled()))) {
      return false;
    }
    if (((other.getSSEType() == null ? 1 : 0) ^ (getSSEType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSEType() != null) && (!other.getSSEType().equals(getSSEType()))) {
      return false;
    }
    if (((other.getKMSMasterKeyId() == null ? 1 : 0) ^ (getKMSMasterKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKMSMasterKeyId() != null) && (!other.getKMSMasterKeyId().equals(getKMSMasterKeyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEnabled() == null ? 0 : getEnabled().hashCode());
    hashCode = 31 * hashCode + (getSSEType() == null ? 0 : getSSEType().hashCode());
    hashCode = 31 * hashCode + (getKMSMasterKeyId() == null ? 0 : getKMSMasterKeyId().hashCode());
    return hashCode;
  }
  
  public SSESpecification clone()
  {
    try
    {
      return (SSESpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SSESpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SSESpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */