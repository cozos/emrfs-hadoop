package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

public class ImportKeyMaterialRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private ByteBuffer importToken;
  private ByteBuffer encryptedKeyMaterial;
  private Date validTo;
  private String expirationModel;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public ImportKeyMaterialRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setImportToken(ByteBuffer importToken)
  {
    this.importToken = importToken;
  }
  
  public ByteBuffer getImportToken()
  {
    return importToken;
  }
  
  public ImportKeyMaterialRequest withImportToken(ByteBuffer importToken)
  {
    setImportToken(importToken);
    return this;
  }
  
  public void setEncryptedKeyMaterial(ByteBuffer encryptedKeyMaterial)
  {
    this.encryptedKeyMaterial = encryptedKeyMaterial;
  }
  
  public ByteBuffer getEncryptedKeyMaterial()
  {
    return encryptedKeyMaterial;
  }
  
  public ImportKeyMaterialRequest withEncryptedKeyMaterial(ByteBuffer encryptedKeyMaterial)
  {
    setEncryptedKeyMaterial(encryptedKeyMaterial);
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
  
  public ImportKeyMaterialRequest withValidTo(Date validTo)
  {
    setValidTo(validTo);
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
  
  public ImportKeyMaterialRequest withExpirationModel(String expirationModel)
  {
    setExpirationModel(expirationModel);
    return this;
  }
  
  public void setExpirationModel(ExpirationModelType expirationModel)
  {
    withExpirationModel(expirationModel);
  }
  
  public ImportKeyMaterialRequest withExpirationModel(ExpirationModelType expirationModel)
  {
    this.expirationModel = expirationModel.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getImportToken() != null) {
      sb.append("ImportToken: ").append(getImportToken()).append(",");
    }
    if (getEncryptedKeyMaterial() != null) {
      sb.append("EncryptedKeyMaterial: ").append(getEncryptedKeyMaterial()).append(",");
    }
    if (getValidTo() != null) {
      sb.append("ValidTo: ").append(getValidTo()).append(",");
    }
    if (getExpirationModel() != null) {
      sb.append("ExpirationModel: ").append(getExpirationModel());
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
    if (!(obj instanceof ImportKeyMaterialRequest)) {
      return false;
    }
    ImportKeyMaterialRequest other = (ImportKeyMaterialRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getImportToken() == null ? 1 : 0) ^ (getImportToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getImportToken() != null) && (!other.getImportToken().equals(getImportToken()))) {
      return false;
    }
    if (((other.getEncryptedKeyMaterial() == null ? 1 : 0) ^ (getEncryptedKeyMaterial() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryptedKeyMaterial() != null) && (!other.getEncryptedKeyMaterial().equals(getEncryptedKeyMaterial()))) {
      return false;
    }
    if (((other.getValidTo() == null ? 1 : 0) ^ (getValidTo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValidTo() != null) && (!other.getValidTo().equals(getValidTo()))) {
      return false;
    }
    if (((other.getExpirationModel() == null ? 1 : 0) ^ (getExpirationModel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpirationModel() != null) && (!other.getExpirationModel().equals(getExpirationModel()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getImportToken() == null ? 0 : getImportToken().hashCode());
    hashCode = 31 * hashCode + (getEncryptedKeyMaterial() == null ? 0 : getEncryptedKeyMaterial().hashCode());
    hashCode = 31 * hashCode + (getValidTo() == null ? 0 : getValidTo().hashCode());
    hashCode = 31 * hashCode + (getExpirationModel() == null ? 0 : getExpirationModel().hashCode());
    return hashCode;
  }
  
  public ImportKeyMaterialRequest clone()
  {
    return (ImportKeyMaterialRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ImportKeyMaterialRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */