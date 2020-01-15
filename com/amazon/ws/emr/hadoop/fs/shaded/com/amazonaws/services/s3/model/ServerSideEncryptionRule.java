package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class ServerSideEncryptionRule
  implements Serializable, Cloneable
{
  private ServerSideEncryptionByDefault applyServerSideEncryptionByDefault;
  
  public ServerSideEncryptionByDefault getApplyServerSideEncryptionByDefault()
  {
    return applyServerSideEncryptionByDefault;
  }
  
  public void setApplyServerSideEncryptionByDefault(ServerSideEncryptionByDefault applyServerSideEncryptionByDefault)
  {
    this.applyServerSideEncryptionByDefault = applyServerSideEncryptionByDefault;
  }
  
  public ServerSideEncryptionRule withApplyServerSideEncryptionByDefault(ServerSideEncryptionByDefault applyServerSideEncryptionByDefault)
  {
    setApplyServerSideEncryptionByDefault(applyServerSideEncryptionByDefault);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getApplyServerSideEncryptionByDefault() != null) {
      sb.append("ApplyServerSideEncryptionByDefault: ").append(getApplyServerSideEncryptionByDefault()).append(",");
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
    if (!(obj instanceof ServerSideEncryptionRule)) {
      return false;
    }
    ServerSideEncryptionRule other = (ServerSideEncryptionRule)obj;
    if (((other.getApplyServerSideEncryptionByDefault() == null ? 1 : 0) ^ (getApplyServerSideEncryptionByDefault() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getApplyServerSideEncryptionByDefault() != null) && 
      (!other.getApplyServerSideEncryptionByDefault().equals(getApplyServerSideEncryptionByDefault()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getApplyServerSideEncryptionByDefault() == null ? 0 : getApplyServerSideEncryptionByDefault().hashCode());
    return hashCode;
  }
  
  public ServerSideEncryptionRule clone()
  {
    try
    {
      return (ServerSideEncryptionRule)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */