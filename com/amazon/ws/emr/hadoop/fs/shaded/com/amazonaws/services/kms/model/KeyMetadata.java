package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KeyMetadataMarshaller;
import java.io.Serializable;
import java.util.Date;

public class KeyMetadata
  implements Serializable, Cloneable, StructuredPojo
{
  private String aWSAccountId;
  private String keyId;
  private String arn;
  private Date creationDate;
  private Boolean enabled;
  private String description;
  private String keyUsage;
  private String keyState;
  private Date deletionDate;
  private Date validTo;
  private String origin;
  private String customKeyStoreId;
  private String cloudHsmClusterId;
  private String expirationModel;
  private String keyManager;
  
  public void setAWSAccountId(String aWSAccountId)
  {
    this.aWSAccountId = aWSAccountId;
  }
  
  public String getAWSAccountId()
  {
    return aWSAccountId;
  }
  
  public KeyMetadata withAWSAccountId(String aWSAccountId)
  {
    setAWSAccountId(aWSAccountId);
    return this;
  }
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public KeyMetadata withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public KeyMetadata withArn(String arn)
  {
    setArn(arn);
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
  
  public KeyMetadata withCreationDate(Date creationDate)
  {
    setCreationDate(creationDate);
    return this;
  }
  
  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }
  
  public Boolean getEnabled()
  {
    return enabled;
  }
  
  public KeyMetadata withEnabled(Boolean enabled)
  {
    setEnabled(enabled);
    return this;
  }
  
  public Boolean isEnabled()
  {
    return enabled;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public KeyMetadata withDescription(String description)
  {
    setDescription(description);
    return this;
  }
  
  public void setKeyUsage(String keyUsage)
  {
    this.keyUsage = keyUsage;
  }
  
  public String getKeyUsage()
  {
    return keyUsage;
  }
  
  public KeyMetadata withKeyUsage(String keyUsage)
  {
    setKeyUsage(keyUsage);
    return this;
  }
  
  public void setKeyUsage(KeyUsageType keyUsage)
  {
    withKeyUsage(keyUsage);
  }
  
  public KeyMetadata withKeyUsage(KeyUsageType keyUsage)
  {
    this.keyUsage = keyUsage.toString();
    return this;
  }
  
  public void setKeyState(String keyState)
  {
    this.keyState = keyState;
  }
  
  public String getKeyState()
  {
    return keyState;
  }
  
  public KeyMetadata withKeyState(String keyState)
  {
    setKeyState(keyState);
    return this;
  }
  
  public void setKeyState(KeyState keyState)
  {
    withKeyState(keyState);
  }
  
  public KeyMetadata withKeyState(KeyState keyState)
  {
    this.keyState = keyState.toString();
    return this;
  }
  
  public void setDeletionDate(Date deletionDate)
  {
    this.deletionDate = deletionDate;
  }
  
  public Date getDeletionDate()
  {
    return deletionDate;
  }
  
  public KeyMetadata withDeletionDate(Date deletionDate)
  {
    setDeletionDate(deletionDate);
    return this;
  }
  
  public void setValidTo(Date validTo)
  {
    this.validTo = validTo;
  }
  
  public Date getValidTo()
  {
    return validTo;
  }
  
  public KeyMetadata withValidTo(Date validTo)
  {
    setValidTo(validTo);
    return this;
  }
  
  public void setOrigin(String origin)
  {
    this.origin = origin;
  }
  
  public String getOrigin()
  {
    return origin;
  }
  
  public KeyMetadata withOrigin(String origin)
  {
    setOrigin(origin);
    return this;
  }
  
  public void setOrigin(OriginType origin)
  {
    withOrigin(origin);
  }
  
  public KeyMetadata withOrigin(OriginType origin)
  {
    this.origin = origin.toString();
    return this;
  }
  
  public void setCustomKeyStoreId(String customKeyStoreId)
  {
    this.customKeyStoreId = customKeyStoreId;
  }
  
  public String getCustomKeyStoreId()
  {
    return customKeyStoreId;
  }
  
  public KeyMetadata withCustomKeyStoreId(String customKeyStoreId)
  {
    setCustomKeyStoreId(customKeyStoreId);
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
  
  public KeyMetadata withCloudHsmClusterId(String cloudHsmClusterId)
  {
    setCloudHsmClusterId(cloudHsmClusterId);
    return this;
  }
  
  public void setExpirationModel(String expirationModel)
  {
    this.expirationModel = expirationModel;
  }
  
  public String getExpirationModel()
  {
    return expirationModel;
  }
  
  public KeyMetadata withExpirationModel(String expirationModel)
  {
    setExpirationModel(expirationModel);
    return this;
  }
  
  public void setExpirationModel(ExpirationModelType expirationModel)
  {
    withExpirationModel(expirationModel);
  }
  
  public KeyMetadata withExpirationModel(ExpirationModelType expirationModel)
  {
    this.expirationModel = expirationModel.toString();
    return this;
  }
  
  public void setKeyManager(String keyManager)
  {
    this.keyManager = keyManager;
  }
  
  public String getKeyManager()
  {
    return keyManager;
  }
  
  public KeyMetadata withKeyManager(String keyManager)
  {
    setKeyManager(keyManager);
    return this;
  }
  
  public void setKeyManager(KeyManagerType keyManager)
  {
    withKeyManager(keyManager);
  }
  
  public KeyMetadata withKeyManager(KeyManagerType keyManager)
  {
    this.keyManager = keyManager.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAWSAccountId() != null) {
      sb.append("AWSAccountId: ").append(getAWSAccountId()).append(",");
    }
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getCreationDate() != null) {
      sb.append("CreationDate: ").append(getCreationDate()).append(",");
    }
    if (getEnabled() != null) {
      sb.append("Enabled: ").append(getEnabled()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getKeyUsage() != null) {
      sb.append("KeyUsage: ").append(getKeyUsage()).append(",");
    }
    if (getKeyState() != null) {
      sb.append("KeyState: ").append(getKeyState()).append(",");
    }
    if (getDeletionDate() != null) {
      sb.append("DeletionDate: ").append(getDeletionDate()).append(",");
    }
    if (getValidTo() != null) {
      sb.append("ValidTo: ").append(getValidTo()).append(",");
    }
    if (getOrigin() != null) {
      sb.append("Origin: ").append(getOrigin()).append(",");
    }
    if (getCustomKeyStoreId() != null) {
      sb.append("CustomKeyStoreId: ").append(getCustomKeyStoreId()).append(",");
    }
    if (getCloudHsmClusterId() != null) {
      sb.append("CloudHsmClusterId: ").append(getCloudHsmClusterId()).append(",");
    }
    if (getExpirationModel() != null) {
      sb.append("ExpirationModel: ").append(getExpirationModel()).append(",");
    }
    if (getKeyManager() != null) {
      sb.append("KeyManager: ").append(getKeyManager());
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
    if (!(obj instanceof KeyMetadata)) {
      return false;
    }
    KeyMetadata other = (KeyMetadata)obj;
    if (((other.getAWSAccountId() == null ? 1 : 0) ^ (getAWSAccountId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAWSAccountId() != null) && (!other.getAWSAccountId().equals(getAWSAccountId()))) {
      return false;
    }
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getCreationDate() == null ? 1 : 0) ^ (getCreationDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDate() != null) && (!other.getCreationDate().equals(getCreationDate()))) {
      return false;
    }
    if (((other.getEnabled() == null ? 1 : 0) ^ (getEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEnabled() != null) && (!other.getEnabled().equals(getEnabled()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getKeyUsage() == null ? 1 : 0) ^ (getKeyUsage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyUsage() != null) && (!other.getKeyUsage().equals(getKeyUsage()))) {
      return false;
    }
    if (((other.getKeyState() == null ? 1 : 0) ^ (getKeyState() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyState() != null) && (!other.getKeyState().equals(getKeyState()))) {
      return false;
    }
    if (((other.getDeletionDate() == null ? 1 : 0) ^ (getDeletionDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDeletionDate() != null) && (!other.getDeletionDate().equals(getDeletionDate()))) {
      return false;
    }
    if (((other.getValidTo() == null ? 1 : 0) ^ (getValidTo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValidTo() != null) && (!other.getValidTo().equals(getValidTo()))) {
      return false;
    }
    if (((other.getOrigin() == null ? 1 : 0) ^ (getOrigin() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOrigin() != null) && (!other.getOrigin().equals(getOrigin()))) {
      return false;
    }
    if (((other.getCustomKeyStoreId() == null ? 1 : 0) ^ (getCustomKeyStoreId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreId() != null) && (!other.getCustomKeyStoreId().equals(getCustomKeyStoreId()))) {
      return false;
    }
    if (((other.getCloudHsmClusterId() == null ? 1 : 0) ^ (getCloudHsmClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCloudHsmClusterId() != null) && (!other.getCloudHsmClusterId().equals(getCloudHsmClusterId()))) {
      return false;
    }
    if (((other.getExpirationModel() == null ? 1 : 0) ^ (getExpirationModel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpirationModel() != null) && (!other.getExpirationModel().equals(getExpirationModel()))) {
      return false;
    }
    if (((other.getKeyManager() == null ? 1 : 0) ^ (getKeyManager() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyManager() != null) && (!other.getKeyManager().equals(getKeyManager()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAWSAccountId() == null ? 0 : getAWSAccountId().hashCode());
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getCreationDate() == null ? 0 : getCreationDate().hashCode());
    hashCode = 31 * hashCode + (getEnabled() == null ? 0 : getEnabled().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getKeyUsage() == null ? 0 : getKeyUsage().hashCode());
    hashCode = 31 * hashCode + (getKeyState() == null ? 0 : getKeyState().hashCode());
    hashCode = 31 * hashCode + (getDeletionDate() == null ? 0 : getDeletionDate().hashCode());
    hashCode = 31 * hashCode + (getValidTo() == null ? 0 : getValidTo().hashCode());
    hashCode = 31 * hashCode + (getOrigin() == null ? 0 : getOrigin().hashCode());
    hashCode = 31 * hashCode + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    hashCode = 31 * hashCode + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode());
    hashCode = 31 * hashCode + (getExpirationModel() == null ? 0 : getExpirationModel().hashCode());
    hashCode = 31 * hashCode + (getKeyManager() == null ? 0 : getKeyManager().hashCode());
    return hashCode;
  }
  
  public KeyMetadata clone()
  {
    try
    {
      return (KeyMetadata)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    KeyMetadataMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.KeyMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */