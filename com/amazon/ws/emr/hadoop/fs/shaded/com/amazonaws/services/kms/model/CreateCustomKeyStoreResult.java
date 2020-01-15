package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateCustomKeyStoreResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String customKeyStoreId;
  
  public void setCustomKeyStoreId(String customKeyStoreId)
  {
    this.customKeyStoreId = customKeyStoreId;
  }
  
  public String getCustomKeyStoreId()
  {
    return customKeyStoreId;
  }
  
  public CreateCustomKeyStoreResult withCustomKeyStoreId(String customKeyStoreId)
  {
    setCustomKeyStoreId(customKeyStoreId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCustomKeyStoreId() != null) {
      sb.append("CustomKeyStoreId: ").append(getCustomKeyStoreId());
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
    if (!(obj instanceof CreateCustomKeyStoreResult)) {
      return false;
    }
    CreateCustomKeyStoreResult other = (CreateCustomKeyStoreResult)obj;
    if (((other.getCustomKeyStoreId() == null ? 1 : 0) ^ (getCustomKeyStoreId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreId() != null) && (!other.getCustomKeyStoreId().equals(getCustomKeyStoreId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    return hashCode;
  }
  
  public CreateCustomKeyStoreResult clone()
  {
    try
    {
      return (CreateCustomKeyStoreResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */