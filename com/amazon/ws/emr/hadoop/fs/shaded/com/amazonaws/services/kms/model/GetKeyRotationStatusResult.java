package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetKeyRotationStatusResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Boolean keyRotationEnabled;
  
  public void setKeyRotationEnabled(Boolean keyRotationEnabled)
  {
    this.keyRotationEnabled = keyRotationEnabled;
  }
  
  public Boolean getKeyRotationEnabled()
  {
    return keyRotationEnabled;
  }
  
  public GetKeyRotationStatusResult withKeyRotationEnabled(Boolean keyRotationEnabled)
  {
    setKeyRotationEnabled(keyRotationEnabled);
    return this;
  }
  
  public Boolean isKeyRotationEnabled()
  {
    return keyRotationEnabled;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyRotationEnabled() != null) {
      sb.append("KeyRotationEnabled: ").append(getKeyRotationEnabled());
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
    if (!(obj instanceof GetKeyRotationStatusResult)) {
      return false;
    }
    GetKeyRotationStatusResult other = (GetKeyRotationStatusResult)obj;
    if (((other.getKeyRotationEnabled() == null ? 1 : 0) ^ (getKeyRotationEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyRotationEnabled() != null) && (!other.getKeyRotationEnabled().equals(getKeyRotationEnabled()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyRotationEnabled() == null ? 0 : getKeyRotationEnabled().hashCode());
    return hashCode;
  }
  
  public GetKeyRotationStatusResult clone()
  {
    try
    {
      return (GetKeyRotationStatusResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyRotationStatusResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */