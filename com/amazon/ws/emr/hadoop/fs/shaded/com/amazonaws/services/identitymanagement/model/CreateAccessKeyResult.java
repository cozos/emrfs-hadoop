package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateAccessKeyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private AccessKey accessKey;
  
  public void setAccessKey(AccessKey accessKey)
  {
    this.accessKey = accessKey;
  }
  
  public AccessKey getAccessKey()
  {
    return accessKey;
  }
  
  public CreateAccessKeyResult withAccessKey(AccessKey accessKey)
  {
    setAccessKey(accessKey);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccessKey() != null) {
      sb.append("AccessKey: ").append(getAccessKey());
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
    if (!(obj instanceof CreateAccessKeyResult)) {
      return false;
    }
    CreateAccessKeyResult other = (CreateAccessKeyResult)obj;
    if (((other.getAccessKey() == null ? 1 : 0) ^ (getAccessKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessKey() != null) && (!other.getAccessKey().equals(getAccessKey()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAccessKey() == null ? 0 : getAccessKey().hashCode());
    return hashCode;
  }
  
  public CreateAccessKeyResult clone()
  {
    try
    {
      return (CreateAccessKeyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccessKeyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */