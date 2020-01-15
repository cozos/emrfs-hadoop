package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoresListEntryMarshaller;
import java.io.Serializable;
import java.util.Date;

public class CustomKeyStoresListEntry
  implements Serializable, Cloneable, StructuredPojo
{
  private String customKeyStoreId;
  private String customKeyStoreName;
  private String cloudHsmClusterId;
  private String trustAnchorCertificate;
  private String connectionState;
  private String connectionErrorCode;
  private Date creationDate;
  
  public void setCustomKeyStoreId(String customKeyStoreId)
  {
    this.customKeyStoreId = customKeyStoreId;
  }
  
  public String getCustomKeyStoreId()
  {
    return customKeyStoreId;
  }
  
  public CustomKeyStoresListEntry withCustomKeyStoreId(String customKeyStoreId)
  {
    setCustomKeyStoreId(customKeyStoreId);
    return this;
  }
  
  public void setCustomKeyStoreName(String customKeyStoreName)
  {
    this.customKeyStoreName = customKeyStoreName;
  }
  
  public String getCustomKeyStoreName()
  {
    return customKeyStoreName;
  }
  
  public CustomKeyStoresListEntry withCustomKeyStoreName(String customKeyStoreName)
  {
    setCustomKeyStoreName(customKeyStoreName);
    return this;
  }
  
  public void setCloudHsmClusterId(String cloudHsmClusterId)
  {
    this.cloudHsmClusterId = cloudHsmClusterId;
  }
  
  public String getCloudHsmClusterId()
  {
    return cloudHsmClusterId;
  }
  
  public CustomKeyStoresListEntry withCloudHsmClusterId(String cloudHsmClusterId)
  {
    setCloudHsmClusterId(cloudHsmClusterId);
    return this;
  }
  
  public void setTrustAnchorCertificate(String trustAnchorCertificate)
  {
    this.trustAnchorCertificate = trustAnchorCertificate;
  }
  
  public String getTrustAnchorCertificate()
  {
    return trustAnchorCertificate;
  }
  
  public CustomKeyStoresListEntry withTrustAnchorCertificate(String trustAnchorCertificate)
  {
    setTrustAnchorCertificate(trustAnchorCertificate);
    return this;
  }
  
  public void setConnectionState(String connectionState)
  {
    this.connectionState = connectionState;
  }
  
  public String getConnectionState()
  {
    return connectionState;
  }
  
  public CustomKeyStoresListEntry withConnectionState(String connectionState)
  {
    setConnectionState(connectionState);
    return this;
  }
  
  public CustomKeyStoresListEntry withConnectionState(ConnectionStateType connectionState)
  {
    this.connectionState = connectionState.toString();
    return this;
  }
  
  public void setConnectionErrorCode(String connectionErrorCode)
  {
    this.connectionErrorCode = connectionErrorCode;
  }
  
  public String getConnectionErrorCode()
  {
    return connectionErrorCode;
  }
  
  public CustomKeyStoresListEntry withConnectionErrorCode(String connectionErrorCode)
  {
    setConnectionErrorCode(connectionErrorCode);
    return this;
  }
  
  public CustomKeyStoresListEntry withConnectionErrorCode(ConnectionErrorCodeType connectionErrorCode)
  {
    this.connectionErrorCode = connectionErrorCode.toString();
    return this;
  }
  
  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }
  
  public Date getCreationDate()
  {
    return creationDate;
  }
  
  public CustomKeyStoresListEntry withCreationDate(Date creationDate)
  {
    setCreationDate(creationDate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCustomKeyStoreId() != null) {
      sb.append("CustomKeyStoreId: ").append(getCustomKeyStoreId()).append(",");
    }
    if (getCustomKeyStoreName() != null) {
      sb.append("CustomKeyStoreName: ").append(getCustomKeyStoreName()).append(",");
    }
    if (getCloudHsmClusterId() != null) {
      sb.append("CloudHsmClusterId: ").append(getCloudHsmClusterId()).append(",");
    }
    if (getTrustAnchorCertificate() != null) {
      sb.append("TrustAnchorCertificate: ").append(getTrustAnchorCertificate()).append(",");
    }
    if (getConnectionState() != null) {
      sb.append("ConnectionState: ").append(getConnectionState()).append(",");
    }
    if (getConnectionErrorCode() != null) {
      sb.append("ConnectionErrorCode: ").append(getConnectionErrorCode()).append(",");
    }
    if (getCreationDate() != null) {
      sb.append("CreationDate: ").append(getCreationDate());
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
    if (!(obj instanceof CustomKeyStoresListEntry)) {
      return false;
    }
    CustomKeyStoresListEntry other = (CustomKeyStoresListEntry)obj;
    if (((other.getCustomKeyStoreId() == null ? 1 : 0) ^ (getCustomKeyStoreId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreId() != null) && (!other.getCustomKeyStoreId().equals(getCustomKeyStoreId()))) {
      return false;
    }
    if (((other.getCustomKeyStoreName() == null ? 1 : 0) ^ (getCustomKeyStoreName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreName() != null) && (!other.getCustomKeyStoreName().equals(getCustomKeyStoreName()))) {
      return false;
    }
    if (((other.getCloudHsmClusterId() == null ? 1 : 0) ^ (getCloudHsmClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCloudHsmClusterId() != null) && (!other.getCloudHsmClusterId().equals(getCloudHsmClusterId()))) {
      return false;
    }
    if (((other.getTrustAnchorCertificate() == null ? 1 : 0) ^ (getTrustAnchorCertificate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTrustAnchorCertificate() != null) && (!other.getTrustAnchorCertificate().equals(getTrustAnchorCertificate()))) {
      return false;
    }
    if (((other.getConnectionState() == null ? 1 : 0) ^ (getConnectionState() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConnectionState() != null) && (!other.getConnectionState().equals(getConnectionState()))) {
      return false;
    }
    if (((other.getConnectionErrorCode() == null ? 1 : 0) ^ (getConnectionErrorCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConnectionErrorCode() != null) && (!other.getConnectionErrorCode().equals(getConnectionErrorCode()))) {
      return false;
    }
    if (((other.getCreationDate() == null ? 1 : 0) ^ (getCreationDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDate() != null) && (!other.getCreationDate().equals(getCreationDate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    hashCode = 31 * hashCode + (getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode());
    hashCode = 31 * hashCode + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode());
    hashCode = 31 * hashCode + (getTrustAnchorCertificate() == null ? 0 : getTrustAnchorCertificate().hashCode());
    hashCode = 31 * hashCode + (getConnectionState() == null ? 0 : getConnectionState().hashCode());
    hashCode = 31 * hashCode + (getConnectionErrorCode() == null ? 0 : getConnectionErrorCode().hashCode());
    hashCode = 31 * hashCode + (getCreationDate() == null ? 0 : getCreationDate().hashCode());
    return hashCode;
  }
  
  public CustomKeyStoresListEntry clone()
  {
    try
    {
      return (CustomKeyStoresListEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CustomKeyStoresListEntryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CustomKeyStoresListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */