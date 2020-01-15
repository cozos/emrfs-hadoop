package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteAliasRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String aliasName;
  
  public void setAliasName(String aliasName)
  {
    this.aliasName = aliasName;
  }
  
  public String getAliasName()
  {
    return aliasName;
  }
  
  public DeleteAliasRequest withAliasName(String aliasName)
  {
    setAliasName(aliasName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAliasName() != null) {
      sb.append("AliasName: ").append(getAliasName());
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
    if (!(obj instanceof DeleteAliasRequest)) {
      return false;
    }
    DeleteAliasRequest other = (DeleteAliasRequest)obj;
    if (((other.getAliasName() == null ? 1 : 0) ^ (getAliasName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAliasName() != null) && (!other.getAliasName().equals(getAliasName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAliasName() == null ? 0 : getAliasName().hashCode());
    return hashCode;
  }
  
  public DeleteAliasRequest clone()
  {
    return (DeleteAliasRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteAliasRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */