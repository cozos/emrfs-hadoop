package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateAliasRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String aliasName;
  private String targetKeyId;
  
  public void setAliasName(String aliasName)
  {
    this.aliasName = aliasName;
  }
  
  public String getAliasName()
  {
    return aliasName;
  }
  
  public UpdateAliasRequest withAliasName(String aliasName)
  {
    setAliasName(aliasName);
    return this;
  }
  
  public void setTargetKeyId(String targetKeyId)
  {
    this.targetKeyId = targetKeyId;
  }
  
  public String getTargetKeyId()
  {
    return targetKeyId;
  }
  
  public UpdateAliasRequest withTargetKeyId(String targetKeyId)
  {
    setTargetKeyId(targetKeyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAliasName() != null) {
      sb.append("AliasName: ").append(getAliasName()).append(",");
    }
    if (getTargetKeyId() != null) {
      sb.append("TargetKeyId: ").append(getTargetKeyId());
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
    if (!(obj instanceof UpdateAliasRequest)) {
      return false;
    }
    UpdateAliasRequest other = (UpdateAliasRequest)obj;
    if (((other.getAliasName() == null ? 1 : 0) ^ (getAliasName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAliasName() != null) && (!other.getAliasName().equals(getAliasName()))) {
      return false;
    }
    if (((other.getTargetKeyId() == null ? 1 : 0) ^ (getTargetKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetKeyId() != null) && (!other.getTargetKeyId().equals(getTargetKeyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAliasName() == null ? 0 : getAliasName().hashCode());
    hashCode = 31 * hashCode + (getTargetKeyId() == null ? 0 : getTargetKeyId().hashCode());
    return hashCode;
  }
  
  public UpdateAliasRequest clone()
  {
    return (UpdateAliasRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateAliasRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */