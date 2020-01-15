package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateGlobalTableResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private GlobalTableDescription globalTableDescription;
  
  public void setGlobalTableDescription(GlobalTableDescription globalTableDescription)
  {
    this.globalTableDescription = globalTableDescription;
  }
  
  public GlobalTableDescription getGlobalTableDescription()
  {
    return globalTableDescription;
  }
  
  public CreateGlobalTableResult withGlobalTableDescription(GlobalTableDescription globalTableDescription)
  {
    setGlobalTableDescription(globalTableDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTableDescription() != null) {
      sb.append("GlobalTableDescription: ").append(getGlobalTableDescription());
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
    if (!(obj instanceof CreateGlobalTableResult)) {
      return false;
    }
    CreateGlobalTableResult other = (CreateGlobalTableResult)obj;
    if (((other.getGlobalTableDescription() == null ? 1 : 0) ^ (getGlobalTableDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableDescription() != null) && (!other.getGlobalTableDescription().equals(getGlobalTableDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTableDescription() == null ? 0 : getGlobalTableDescription().hashCode());
    return hashCode;
  }
  
  public CreateGlobalTableResult clone()
  {
    try
    {
      return (CreateGlobalTableResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */