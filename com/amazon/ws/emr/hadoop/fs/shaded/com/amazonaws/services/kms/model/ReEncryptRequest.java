package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReEncryptRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private ByteBuffer ciphertextBlob;
  private SdkInternalMap<String, String> sourceEncryptionContext;
  private String destinationKeyId;
  private SdkInternalMap<String, String> destinationEncryptionContext;
  private SdkInternalList<String> grantTokens;
  
  public void setCiphertextBlob(ByteBuffer ciphertextBlob)
  {
    this.ciphertextBlob = ciphertextBlob;
  }
  
  public ByteBuffer getCiphertextBlob()
  {
    return ciphertextBlob;
  }
  
  public ReEncryptRequest withCiphertextBlob(ByteBuffer ciphertextBlob)
  {
    setCiphertextBlob(ciphertextBlob);
    return this;
  }
  
  public Map<String, String> getSourceEncryptionContext()
  {
    if (sourceEncryptionContext == null) {
      sourceEncryptionContext = new SdkInternalMap();
    }
    return sourceEncryptionContext;
  }
  
  public void setSourceEncryptionContext(Map<String, String> sourceEncryptionContext)
  {
    this.sourceEncryptionContext = (sourceEncryptionContext == null ? null : new SdkInternalMap(sourceEncryptionContext));
  }
  
  public ReEncryptRequest withSourceEncryptionContext(Map<String, String> sourceEncryptionContext)
  {
    setSourceEncryptionContext(sourceEncryptionContext);
    return this;
  }
  
  public ReEncryptRequest addSourceEncryptionContextEntry(String key, String value)
  {
    if (null == sourceEncryptionContext) {
      sourceEncryptionContext = new SdkInternalMap();
    }
    if (sourceEncryptionContext.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    sourceEncryptionContext.put(key, value);
    return this;
  }
  
  public ReEncryptRequest clearSourceEncryptionContextEntries()
  {
    sourceEncryptionContext = null;
    return this;
  }
  
  public void setDestinationKeyId(String destinationKeyId)
  {
    this.destinationKeyId = destinationKeyId;
  }
  
  public String getDestinationKeyId()
  {
    return destinationKeyId;
  }
  
  public ReEncryptRequest withDestinationKeyId(String destinationKeyId)
  {
    setDestinationKeyId(destinationKeyId);
    return this;
  }
  
  public Map<String, String> getDestinationEncryptionContext()
  {
    if (destinationEncryptionContext == null) {
      destinationEncryptionContext = new SdkInternalMap();
    }
    return destinationEncryptionContext;
  }
  
  public void setDestinationEncryptionContext(Map<String, String> destinationEncryptionContext)
  {
    this.destinationEncryptionContext = (destinationEncryptionContext == null ? null : new SdkInternalMap(destinationEncryptionContext));
  }
  
  public ReEncryptRequest withDestinationEncryptionContext(Map<String, String> destinationEncryptionContext)
  {
    setDestinationEncryptionContext(destinationEncryptionContext);
    return this;
  }
  
  public ReEncryptRequest addDestinationEncryptionContextEntry(String key, String value)
  {
    if (null == destinationEncryptionContext) {
      destinationEncryptionContext = new SdkInternalMap();
    }
    if (destinationEncryptionContext.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    destinationEncryptionContext.put(key, value);
    return this;
  }
  
  public ReEncryptRequest clearDestinationEncryptionContextEntries()
  {
    destinationEncryptionContext = null;
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
  
  public ReEncryptRequest withGrantTokens(String... grantTokens)
  {
    if (this.grantTokens == null) {
      setGrantTokens(new SdkInternalList(grantTokens.length));
    }
    for (String ele : grantTokens) {
      this.grantTokens.add(ele);
    }
    return this;
  }
  
  public ReEncryptRequest withGrantTokens(Collection<String> grantTokens)
  {
    setGrantTokens(grantTokens);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCiphertextBlob() != null) {
      sb.append("CiphertextBlob: ").append(getCiphertextBlob()).append(",");
    }
    if (getSourceEncryptionContext() != null) {
      sb.append("SourceEncryptionContext: ").append(getSourceEncryptionContext()).append(",");
    }
    if (getDestinationKeyId() != null) {
      sb.append("DestinationKeyId: ").append(getDestinationKeyId()).append(",");
    }
    if (getDestinationEncryptionContext() != null) {
      sb.append("DestinationEncryptionContext: ").append(getDestinationEncryptionContext()).append(",");
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
    if (!(obj instanceof ReEncryptRequest)) {
      return false;
    }
    ReEncryptRequest other = (ReEncryptRequest)obj;
    if (((other.getCiphertextBlob() == null ? 1 : 0) ^ (getCiphertextBlob() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCiphertextBlob() != null) && (!other.getCiphertextBlob().equals(getCiphertextBlob()))) {
      return false;
    }
    if (((other.getSourceEncryptionContext() == null ? 1 : 0) ^ (getSourceEncryptionContext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceEncryptionContext() != null) && (!other.getSourceEncryptionContext().equals(getSourceEncryptionContext()))) {
      return false;
    }
    if (((other.getDestinationKeyId() == null ? 1 : 0) ^ (getDestinationKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDestinationKeyId() != null) && (!other.getDestinationKeyId().equals(getDestinationKeyId()))) {
      return false;
    }
    if (((other.getDestinationEncryptionContext() == null ? 1 : 0) ^ (getDestinationEncryptionContext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDestinationEncryptionContext() != null) && (!other.getDestinationEncryptionContext().equals(getDestinationEncryptionContext()))) {
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
    
    hashCode = 31 * hashCode + (getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode());
    hashCode = 31 * hashCode + (getSourceEncryptionContext() == null ? 0 : getSourceEncryptionContext().hashCode());
    hashCode = 31 * hashCode + (getDestinationKeyId() == null ? 0 : getDestinationKeyId().hashCode());
    hashCode = 31 * hashCode + (getDestinationEncryptionContext() == null ? 0 : getDestinationEncryptionContext().hashCode());
    hashCode = 31 * hashCode + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode());
    return hashCode;
  }
  
  public ReEncryptRequest clone()
  {
    return (ReEncryptRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */