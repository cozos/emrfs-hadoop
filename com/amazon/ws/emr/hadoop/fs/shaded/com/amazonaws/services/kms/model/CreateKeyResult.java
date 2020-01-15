package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateKeyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private KeyMetadata keyMetadata;
  
  public void setKeyMetadata(KeyMetadata keyMetadata)
  {
    this.keyMetadata = keyMetadata;
  }
  
  public KeyMetadata getKeyMetadata()
  {
    return keyMetadata;
  }
  
  public CreateKeyResult withKeyMetadata(KeyMetadata keyMetadata)
  {
    setKeyMetadata(keyMetadata);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyMetadata() != null) {
      sb.append("KeyMetadata: ").append(getKeyMetadata());
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
    if (!(obj instanceof CreateKeyResult)) {
      return false;
    }
    CreateKeyResult other = (CreateKeyResult)obj;
    if (((other.getKeyMetadata() == null ? 1 : 0) ^ (getKeyMetadata() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyMetadata() != null) && (!other.getKeyMetadata().equals(getKeyMetadata()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyMetadata() == null ? 0 : getKeyMetadata().hashCode());
    return hashCode;
  }
  
  public CreateKeyResult clone()
  {
    try
    {
      return (CreateKeyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateKeyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */