package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SSEDescriptionMarshaller;
import java.io.Serializable;

public class SSEDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String status;
  private String sSEType;
  private String kMSMasterKeyArn;
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public SSEDescription withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public SSEDescription withStatus(SSEStatus status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setSSEType(String sSEType)
  {
    this.sSEType = sSEType;
  }
  
  public String getSSEType()
  {
    return sSEType;
  }
  
  public SSEDescription withSSEType(String sSEType)
  {
    setSSEType(sSEType);
    return this;
  }
  
  public SSEDescription withSSEType(SSEType sSEType)
  {
    this.sSEType = sSEType.toString();
    return this;
  }
  
  public void setKMSMasterKeyArn(String kMSMasterKeyArn)
  {
    this.kMSMasterKeyArn = kMSMasterKeyArn;
  }
  
  public String getKMSMasterKeyArn()
  {
    return kMSMasterKeyArn;
  }
  
  public SSEDescription withKMSMasterKeyArn(String kMSMasterKeyArn)
  {
    setKMSMasterKeyArn(kMSMasterKeyArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getSSEType() != null) {
      sb.append("SSEType: ").append(getSSEType()).append(",");
    }
    if (getKMSMasterKeyArn() != null) {
      sb.append("KMSMasterKeyArn: ").append(getKMSMasterKeyArn());
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
    if (!(obj instanceof SSEDescription)) {
      return false;
    }
    SSEDescription other = (SSEDescription)obj;
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getSSEType() == null ? 1 : 0) ^ (getSSEType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSEType() != null) && (!other.getSSEType().equals(getSSEType()))) {
      return false;
    }
    if (((other.getKMSMasterKeyArn() == null ? 1 : 0) ^ (getKMSMasterKeyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKMSMasterKeyArn() != null) && (!other.getKMSMasterKeyArn().equals(getKMSMasterKeyArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getSSEType() == null ? 0 : getSSEType().hashCode());
    hashCode = 31 * hashCode + (getKMSMasterKeyArn() == null ? 0 : getKMSMasterKeyArn().hashCode());
    return hashCode;
  }
  
  public SSEDescription clone()
  {
    try
    {
      return (SSEDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SSEDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SSEDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */