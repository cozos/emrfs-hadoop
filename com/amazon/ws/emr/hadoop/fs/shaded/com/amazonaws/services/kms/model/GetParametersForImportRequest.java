package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetParametersForImportRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private String wrappingAlgorithm;
  private String wrappingKeySpec;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public GetParametersForImportRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setWrappingAlgorithm(String wrappingAlgorithm)
  {
    this.wrappingAlgorithm = wrappingAlgorithm;
  }
  
  public String getWrappingAlgorithm()
  {
    return wrappingAlgorithm;
  }
  
  public GetParametersForImportRequest withWrappingAlgorithm(String wrappingAlgorithm)
  {
    setWrappingAlgorithm(wrappingAlgorithm);
    return this;
  }
  
  public void setWrappingAlgorithm(AlgorithmSpec wrappingAlgorithm)
  {
    withWrappingAlgorithm(wrappingAlgorithm);
  }
  
  public GetParametersForImportRequest withWrappingAlgorithm(AlgorithmSpec wrappingAlgorithm)
  {
    this.wrappingAlgorithm = wrappingAlgorithm.toString();
    return this;
  }
  
  public void setWrappingKeySpec(String wrappingKeySpec)
  {
    this.wrappingKeySpec = wrappingKeySpec;
  }
  
  public String getWrappingKeySpec()
  {
    return wrappingKeySpec;
  }
  
  public GetParametersForImportRequest withWrappingKeySpec(String wrappingKeySpec)
  {
    setWrappingKeySpec(wrappingKeySpec);
    return this;
  }
  
  public void setWrappingKeySpec(WrappingKeySpec wrappingKeySpec)
  {
    withWrappingKeySpec(wrappingKeySpec);
  }
  
  public GetParametersForImportRequest withWrappingKeySpec(WrappingKeySpec wrappingKeySpec)
  {
    this.wrappingKeySpec = wrappingKeySpec.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getWrappingAlgorithm() != null) {
      sb.append("WrappingAlgorithm: ").append(getWrappingAlgorithm()).append(",");
    }
    if (getWrappingKeySpec() != null) {
      sb.append("WrappingKeySpec: ").append(getWrappingKeySpec());
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
    if (!(obj instanceof GetParametersForImportRequest)) {
      return false;
    }
    GetParametersForImportRequest other = (GetParametersForImportRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getWrappingAlgorithm() == null ? 1 : 0) ^ (getWrappingAlgorithm() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWrappingAlgorithm() != null) && (!other.getWrappingAlgorithm().equals(getWrappingAlgorithm()))) {
      return false;
    }
    if (((other.getWrappingKeySpec() == null ? 1 : 0) ^ (getWrappingKeySpec() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWrappingKeySpec() != null) && (!other.getWrappingKeySpec().equals(getWrappingKeySpec()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getWrappingAlgorithm() == null ? 0 : getWrappingAlgorithm().hashCode());
    hashCode = 31 * hashCode + (getWrappingKeySpec() == null ? 0 : getWrappingKeySpec().hashCode());
    return hashCode;
  }
  
  public GetParametersForImportRequest clone()
  {
    return (GetParametersForImportRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */