package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class ReEncryptResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ByteBuffer ciphertextBlob;
  private String sourceKeyId;
  private String keyId;
  
  public void setCiphertextBlob(ByteBuffer ciphertextBlob)
  {
    this.ciphertextBlob = ciphertextBlob;
  }
  
  public ByteBuffer getCiphertextBlob()
  {
    return ciphertextBlob;
  }
  
  public ReEncryptResult withCiphertextBlob(ByteBuffer ciphertextBlob)
  {
    setCiphertextBlob(ciphertextBlob);
    return this;
  }
  
  public void setSourceKeyId(String sourceKeyId)
  {
    this.sourceKeyId = sourceKeyId;
  }
  
  public String getSourceKeyId()
  {
    return sourceKeyId;
  }
  
  public ReEncryptResult withSourceKeyId(String sourceKeyId)
  {
    setSourceKeyId(sourceKeyId);
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
  
  public ReEncryptResult withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCiphertextBlob() != null) {
      sb.append("CiphertextBlob: ").append(getCiphertextBlob()).append(",");
    }
    if (getSourceKeyId() != null) {
      sb.append("SourceKeyId: ").append(getSourceKeyId()).append(",");
    }
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId());
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
    if (!(obj instanceof ReEncryptResult)) {
      return false;
    }
    ReEncryptResult other = (ReEncryptResult)obj;
    if (((other.getCiphertextBlob() == null ? 1 : 0) ^ (getCiphertextBlob() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCiphertextBlob() != null) && (!other.getCiphertextBlob().equals(getCiphertextBlob()))) {
      return false;
    }
    if (((other.getSourceKeyId() == null ? 1 : 0) ^ (getSourceKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceKeyId() != null) && (!other.getSourceKeyId().equals(getSourceKeyId()))) {
      return false;
    }
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode());
    hashCode = 31 * hashCode + (getSourceKeyId() == null ? 0 : getSourceKeyId().hashCode());
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    return hashCode;
  }
  
  public ReEncryptResult clone()
  {
    try
    {
      return (ReEncryptResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */