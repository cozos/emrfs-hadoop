package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RetireGrantRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String grantToken;
  private String keyId;
  private String grantId;
  
  public void setGrantToken(String grantToken)
  {
    this.grantToken = grantToken;
  }
  
  public String getGrantToken()
  {
    return grantToken;
  }
  
  public RetireGrantRequest withGrantToken(String grantToken)
  {
    setGrantToken(grantToken);
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
  
  public RetireGrantRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setGrantId(String grantId)
  {
    this.grantId = grantId;
  }
  
  public String getGrantId()
  {
    return grantId;
  }
  
  public RetireGrantRequest withGrantId(String grantId)
  {
    setGrantId(grantId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGrantToken() != null) {
      sb.append("GrantToken: ").append(getGrantToken()).append(",");
    }
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getGrantId() != null) {
      sb.append("GrantId: ").append(getGrantId());
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
    if (!(obj instanceof RetireGrantRequest)) {
      return false;
    }
    RetireGrantRequest other = (RetireGrantRequest)obj;
    if (((other.getGrantToken() == null ? 1 : 0) ^ (getGrantToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantToken() != null) && (!other.getGrantToken().equals(getGrantToken()))) {
      return false;
    }
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getGrantId() == null ? 1 : 0) ^ (getGrantId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantId() != null) && (!other.getGrantId().equals(getGrantId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGrantToken() == null ? 0 : getGrantToken().hashCode());
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getGrantId() == null ? 0 : getGrantId().hashCode());
    return hashCode;
  }
  
  public RetireGrantRequest clone()
  {
    return (RetireGrantRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RetireGrantRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */