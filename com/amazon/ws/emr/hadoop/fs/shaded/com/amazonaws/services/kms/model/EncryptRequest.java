package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EncryptRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private ByteBuffer plaintext;
  private SdkInternalMap<String, String> encryptionContext;
  private SdkInternalList<String> grantTokens;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public EncryptRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setPlaintext(ByteBuffer plaintext)
  {
    this.plaintext = plaintext;
  }
  
  public ByteBuffer getPlaintext()
  {
    return plaintext;
  }
  
  public EncryptRequest withPlaintext(ByteBuffer plaintext)
  {
    setPlaintext(plaintext);
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
  
  public EncryptRequest withEncryptionContext(Map<String, String> encryptionContext)
  {
    setEncryptionContext(encryptionContext);
    return this;
  }
  
  public EncryptRequest addEncryptionContextEntry(String key, String value)
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
  
  public EncryptRequest clearEncryptionContextEntries()
  {
    encryptionContext = null;
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
  
  public EncryptRequest withGrantTokens(String... grantTokens)
  {
    if (this.grantTokens == null) {
      setGrantTokens(new SdkInternalList(grantTokens.length));
    }
    for (String ele : grantTokens) {
      this.grantTokens.add(ele);
    }
    return this;
  }
  
  public EncryptRequest withGrantTokens(Collection<String> grantTokens)
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
    if (getPlaintext() != null) {
      sb.append("Plaintext: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getEncryptionContext() != null) {
      sb.append("EncryptionContext: ").append(getEncryptionContext()).append(",");
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
    if (!(obj instanceof EncryptRequest)) {
      return false;
    }
    EncryptRequest other = (EncryptRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getPlaintext() == null ? 1 : 0) ^ (getPlaintext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPlaintext() != null) && (!other.getPlaintext().equals(getPlaintext()))) {
      return false;
    }
    if (((other.getEncryptionContext() == null ? 1 : 0) ^ (getEncryptionContext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryptionContext() != null) && (!other.getEncryptionContext().equals(getEncryptionContext()))) {
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
    hashCode = 31 * hashCode + (getPlaintext() == null ? 0 : getPlaintext().hashCode());
    hashCode = 31 * hashCode + (getEncryptionContext() == null ? 0 : getEncryptionContext().hashCode());
    hashCode = 31 * hashCode + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode());
    return hashCode;
  }
  
  public EncryptRequest clone()
  {
    return (EncryptRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */