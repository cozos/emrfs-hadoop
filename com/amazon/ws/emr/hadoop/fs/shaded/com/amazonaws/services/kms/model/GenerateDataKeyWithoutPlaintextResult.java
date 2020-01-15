package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateDataKeyWithoutPlaintextResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ByteBuffer ciphertextBlob;
  private String keyId;
  
  public void setCiphertextBlob(ByteBuffer ciphertextBlob)
  {
    this.ciphertextBlob = ciphertextBlob;
  }
  
  public ByteBuffer getCiphertextBlob()
  {
    return ciphertextBlob;
  }
  
  public GenerateDataKeyWithoutPlaintextResult withCiphertextBlob(ByteBuffer ciphertextBlob)
  {
    setCiphertextBlob(ciphertextBlob);
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
  
  public GenerateDataKeyWithoutPlaintextResult withKeyId(String keyId)
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
    if (!(obj instanceof GenerateDataKeyWithoutPlaintextResult)) {
      return false;
    }
    GenerateDataKeyWithoutPlaintextResult other = (GenerateDataKeyWithoutPlaintextResult)obj;
    if (((other.getCiphertextBlob() == null ? 1 : 0) ^ (getCiphertextBlob() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCiphertextBlob() != null) && (!other.getCiphertextBlob().equals(getCiphertextBlob()))) {
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
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    return hashCode;
  }
  
  public GenerateDataKeyWithoutPlaintextResult clone()
  {
    try
    {
      return (GenerateDataKeyWithoutPlaintextResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */