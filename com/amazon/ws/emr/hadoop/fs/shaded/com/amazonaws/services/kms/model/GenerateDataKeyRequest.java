package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private SdkInternalMap<String, String> encryptionContext;
  private Integer numberOfBytes;
  private String keySpec;
  private SdkInternalList<String> grantTokens;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public GenerateDataKeyRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public Map<String, String> getEncryptionContext()
  {
    if (encryptionContext == null) {
      encryptionContext = new SdkInternalMap();
    }
    return encryptionContext;
  }
  
  public void setEncryptionContext(Map<String, String> encryptionContext)
  {
    this.encryptionContext = (encryptionContext == null ? null : new SdkInternalMap(encryptionContext));
  }
  
  public GenerateDataKeyRequest withEncryptionContext(Map<String, String> encryptionContext)
  {
    setEncryptionContext(encryptionContext);
    return this;
  }
  
  public GenerateDataKeyRequest addEncryptionContextEntry(String key, String value)
  {
    if (null == encryptionContext) {
      encryptionContext = new SdkInternalMap();
    }
    if (encryptionContext.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    encryptionContext.put(key, value);
    return this;
  }
  
  public GenerateDataKeyRequest clearEncryptionContextEntries()
  {
    encryptionContext = null;
    return this;
  }
  
  public void setNumberOfBytes(Integer numberOfBytes)
  {
    this.numberOfBytes = numberOfBytes;
  }
  
  public Integer getNumberOfBytes()
  {
    return numberOfBytes;
  }
  
  public GenerateDataKeyRequest withNumberOfBytes(Integer numberOfBytes)
  {
    setNumberOfBytes(numberOfBytes);
    return this;
  }
  
  public void setKeySpec(String keySpec)
  {
    this.keySpec = keySpec;
  }
  
  public String getKeySpec()
  {
    return keySpec;
  }
  
  public GenerateDataKeyRequest withKeySpec(String keySpec)
  {
    setKeySpec(keySpec);
    return this;
  }
  
  public void setKeySpec(DataKeySpec keySpec)
  {
    withKeySpec(keySpec);
  }
  
  public GenerateDataKeyRequest withKeySpec(DataKeySpec keySpec)
  {
    this.keySpec = keySpec.toString();
    return this;
  }
  
  public List<String> getGrantTokens()
  {
    if (grantTokens == null) {
      grantTokens = new SdkInternalList();
    }
    return grantTokens;
  }
  
  public void setGrantTokens(Collection<String> grantTokens)
  {
    if (grantTokens == null)
    {
      this.grantTokens = null;
      return;
    }
    this.grantTokens = new SdkInternalList(grantTokens);
  }
  
  public GenerateDataKeyRequest withGrantTokens(String... grantTokens)
  {
    if (this.grantTokens == null) {
      setGrantTokens(new SdkInternalList(grantTokens.length));
    }
    for (String ele : grantTokens) {
      this.grantTokens.add(ele);
    }
    return this;
  }
  
  public GenerateDataKeyRequest withGrantTokens(Collection<String> grantTokens)
  {
    setGrantTokens(grantTokens);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getEncryptionContext() != null) {
      sb.append("EncryptionContext: ").append(getEncryptionContext()).append(",");
    }
    if (getNumberOfBytes() != null) {
      sb.append("NumberOfBytes: ").append(getNumberOfBytes()).append(",");
    }
    if (getKeySpec() != null) {
      sb.append("KeySpec: ").append(getKeySpec()).append(",");
    }
    if (getGrantTokens() != null) {
      sb.append("GrantTokens: ").append(getGrantTokens());
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
    if (!(obj instanceof GenerateDataKeyRequest)) {
      return false;
    }
    GenerateDataKeyRequest other = (GenerateDataKeyRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getEncryptionContext() == null ? 1 : 0) ^ (getEncryptionContext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryptionContext() != null) && (!other.getEncryptionContext().equals(getEncryptionContext()))) {
      return false;
    }
    if (((other.getNumberOfBytes() == null ? 1 : 0) ^ (getNumberOfBytes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNumberOfBytes() != null) && (!other.getNumberOfBytes().equals(getNumberOfBytes()))) {
      return false;
    }
    if (((other.getKeySpec() == null ? 1 : 0) ^ (getKeySpec() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeySpec() != null) && (!other.getKeySpec().equals(getKeySpec()))) {
      return false;
    }
    if (((other.getGrantTokens() == null ? 1 : 0) ^ (getGrantTokens() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantTokens() != null) && (!other.getGrantTokens().equals(getGrantTokens()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getEncryptionContext() == null ? 0 : getEncryptionContext().hashCode());
    hashCode = 31 * hashCode + (getNumberOfBytes() == null ? 0 : getNumberOfBytes().hashCode());
    hashCode = 31 * hashCode + (getKeySpec() == null ? 0 : getKeySpec().hashCode());
    hashCode = 31 * hashCode + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode());
    return hashCode;
  }
  
  public GenerateDataKeyRequest clone()
  {
    return (GenerateDataKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */