package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Encryption
  implements Serializable, Cloneable
{
  private String encryptionType;
  private String kmsKeyId;
  private String kmsContext;
  
  public String getEncryptionType()
  {
    return encryptionType;
  }
  
  public void setEncryptionType(String encryptionType)
  {
    this.encryptionType = encryptionType;
  }
  
  public Encryption withEncryptionType(String encryptionType)
  {
    setEncryptionType(encryptionType);
    return this;
  }
  
  public Encryption withEncryptionType(SSEAlgorithm encryptionType)
  {
    setEncryptionType(encryptionType == null ? null : encryptionType.toString());
    return this;
  }
  
  public String getKmsKeyId()
  {
    return kmsKeyId;
  }
  
  public void setKmsKeyId(String kmsKeyId)
  {
    this.kmsKeyId = kmsKeyId;
  }
  
  public Encryption withKmsKeyId(String kmsKeyId)
  {
    setKmsKeyId(kmsKeyId);
    return this;
  }
  
  public String getKmsContext()
  {
    return kmsContext;
  }
  
  public void setKmsContext(String kmsContext)
  {
    this.kmsContext = kmsContext;
  }
  
  public Encryption withKmsContext(String kmsContext)
  {
    setKmsContext(kmsContext);
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof Encryption))) {
      return false;
    }
    Encryption other = (Encryption)obj;
    if (((other.getKmsContext() == null ? 1 : 0) ^ (getKmsContext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKmsContext() != null) && (!other.getKmsContext().equals(getKmsContext()))) {
      return false;
    }
    if (((other.getKmsKeyId() == null ? 1 : 0) ^ (getKmsKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKmsKeyId() != null) && (!other.getKmsKeyId().equals(getKmsKeyId()))) {
      return false;
    }
    if (((other.getEncryptionType() == null ? 1 : 0) ^ (getEncryptionType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryptionType() != null) && (!other.getEncryptionType().equals(getEncryptionType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKmsKeyId() == null ? 0 : getKmsKeyId().hashCode());
    hashCode = 31 * hashCode + (getKmsContext() == null ? 0 : getKmsContext().hashCode());
    hashCode = 31 * hashCode + (getEncryptionType() == null ? 0 : getEncryptionType().hashCode());
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKmsContext() != null) {
      sb.append("KmsContext: ").append(getKmsContext()).append(",");
    }
    if (getKmsKeyId() != null) {
      sb.append("KmsKeyId: ").append(getKmsKeyId()).append(",");
    }
    if (getEncryptionType() != null) {
      sb.append("EncryptionType: ").append(getEncryptionType());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public Encryption clone()
  {
    try
    {
      return (Encryption)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Encryption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */