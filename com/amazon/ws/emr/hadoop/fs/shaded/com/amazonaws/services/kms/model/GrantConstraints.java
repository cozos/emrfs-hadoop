package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GrantConstraintsMarshaller;
import java.io.Serializable;
import java.util.Map;

public class GrantConstraints
  implements Serializable, Cloneable, StructuredPojo
{
  private SdkInternalMap<String, String> encryptionContextSubset;
  private SdkInternalMap<String, String> encryptionContextEquals;
  
  public Map<String, String> getEncryptionContextSubset()
  {
    if (encryptionContextSubset == null) {
      encryptionContextSubset = new SdkInternalMap();
    }
    return encryptionContextSubset;
  }
  
  public void setEncryptionContextSubset(Map<String, String> encryptionContextSubset)
  {
    this.encryptionContextSubset = (encryptionContextSubset == null ? null : new SdkInternalMap(encryptionContextSubset));
  }
  
  public GrantConstraints withEncryptionContextSubset(Map<String, String> encryptionContextSubset)
  {
    setEncryptionContextSubset(encryptionContextSubset);
    return this;
  }
  
  public GrantConstraints addEncryptionContextSubsetEntry(String key, String value)
  {
    if (null == encryptionContextSubset) {
      encryptionContextSubset = new SdkInternalMap();
    }
    if (encryptionContextSubset.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    encryptionContextSubset.put(key, value);
    return this;
  }
  
  public GrantConstraints clearEncryptionContextSubsetEntries()
  {
    encryptionContextSubset = null;
    return this;
  }
  
  public Map<String, String> getEncryptionContextEquals()
  {
    if (encryptionContextEquals == null) {
      encryptionContextEquals = new SdkInternalMap();
    }
    return encryptionContextEquals;
  }
  
  public void setEncryptionContextEquals(Map<String, String> encryptionContextEquals)
  {
    this.encryptionContextEquals = (encryptionContextEquals == null ? null : new SdkInternalMap(encryptionContextEquals));
  }
  
  public GrantConstraints withEncryptionContextEquals(Map<String, String> encryptionContextEquals)
  {
    setEncryptionContextEquals(encryptionContextEquals);
    return this;
  }
  
  public GrantConstraints addEncryptionContextEqualsEntry(String key, String value)
  {
    if (null == encryptionContextEquals) {
      encryptionContextEquals = new SdkInternalMap();
    }
    if (encryptionContextEquals.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    encryptionContextEquals.put(key, value);
    return this;
  }
  
  public GrantConstraints clearEncryptionContextEqualsEntries()
  {
    encryptionContextEquals = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEncryptionContextSubset() != null) {
      sb.append("EncryptionContextSubset: ").append(getEncryptionContextSubset()).append(",");
    }
    if (getEncryptionContextEquals() != null) {
      sb.append("EncryptionContextEquals: ").append(getEncryptionContextEquals());
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
    if (!(obj instanceof GrantConstraints)) {
      return false;
    }
    GrantConstraints other = (GrantConstraints)obj;
    if (((other.getEncryptionContextSubset() == null ? 1 : 0) ^ (getEncryptionContextSubset() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryptionContextSubset() != null) && (!other.getEncryptionContextSubset().equals(getEncryptionContextSubset()))) {
      return false;
    }
    if (((other.getEncryptionContextEquals() == null ? 1 : 0) ^ (getEncryptionContextEquals() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryptionContextEquals() != null) && (!other.getEncryptionContextEquals().equals(getEncryptionContextEquals()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEncryptionContextSubset() == null ? 0 : getEncryptionContextSubset().hashCode());
    hashCode = 31 * hashCode + (getEncryptionContextEquals() == null ? 0 : getEncryptionContextEquals().hashCode());
    return hashCode;
  }
  
  public GrantConstraints clone()
  {
    try
    {
      return (GrantConstraints)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    GrantConstraintsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GrantConstraints
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */