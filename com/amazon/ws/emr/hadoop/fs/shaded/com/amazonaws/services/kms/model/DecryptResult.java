package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class DecryptResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String keyId;
  private ByteBuffer plaintext;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public DecryptResult withKeyId(String keyId)
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
  
  public DecryptResult withPlaintext(ByteBuffer plaintext)
  {
    setPlaintext(plaintext);
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
      sb.append("Plaintext: ").append("***Sensitive Data Redacted***");
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
    if (!(obj instanceof DecryptResult)) {
      return false;
    }
    DecryptResult other = (DecryptResult)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getPlaintext() == null ? 0 : getPlaintext().hashCode());
    return hashCode;
  }
  
  public DecryptResult clone()
  {
    try
    {
      return (DecryptResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */