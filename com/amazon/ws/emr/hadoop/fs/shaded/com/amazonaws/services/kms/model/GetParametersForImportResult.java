package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

public class GetParametersForImportResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String keyId;
  private ByteBuffer importToken;
  private ByteBuffer publicKey;
  private Date parametersValidTo;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public GetParametersForImportResult withKeyId(String keyId)
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
  
  public GetParametersForImportResult withImportToken(ByteBuffer importToken)
  {
    setImportToken(importToken);
    return this;
  }
  
  public void setPublicKey(ByteBuffer publicKey)
  {
    this.publicKey = publicKey;
  }
  
  public ByteBuffer getPublicKey()
  {
    return publicKey;
  }
  
  public GetParametersForImportResult withPublicKey(ByteBuffer publicKey)
  {
    setPublicKey(publicKey);
    return this;
  }
  
  public void setParametersValidTo(Date parametersValidTo)
  {
    this.parametersValidTo = parametersValidTo;
  }
  
  public Date getParametersValidTo()
  {
    return parametersValidTo;
  }
  
  public GetParametersForImportResult withParametersValidTo(Date parametersValidTo)
  {
    setParametersValidTo(parametersValidTo);
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
    if (getPublicKey() != null) {
      sb.append("PublicKey: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getParametersValidTo() != null) {
      sb.append("ParametersValidTo: ").append(getParametersValidTo());
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
    if (!(obj instanceof GetParametersForImportResult)) {
      return false;
    }
    GetParametersForImportResult other = (GetParametersForImportResult)obj;
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
    if (((other.getPublicKey() == null ? 1 : 0) ^ (getPublicKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPublicKey() != null) && (!other.getPublicKey().equals(getPublicKey()))) {
      return false;
    }
    if (((other.getParametersValidTo() == null ? 1 : 0) ^ (getParametersValidTo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getParametersValidTo() != null) && (!other.getParametersValidTo().equals(getParametersValidTo()))) {
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
    hashCode = 31 * hashCode + (getPublicKey() == null ? 0 : getPublicKey().hashCode());
    hashCode = 31 * hashCode + (getParametersValidTo() == null ? 0 : getParametersValidTo().hashCode());
    return hashCode;
  }
  
  public GetParametersForImportResult clone()
  {
    try
    {
      return (GetParametersForImportResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */