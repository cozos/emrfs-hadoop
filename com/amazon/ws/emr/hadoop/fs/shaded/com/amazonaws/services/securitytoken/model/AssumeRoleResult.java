package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class AssumeRoleResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Credentials credentials;
  private AssumedRoleUser assumedRoleUser;
  private Integer packedPolicySize;
  
  public void setCredentials(Credentials credentials)
  {
    this.credentials = credentials;
  }
  
  public Credentials getCredentials()
  {
    return credentials;
  }
  
  public AssumeRoleResult withCredentials(Credentials credentials)
  {
    setCredentials(credentials);
    return this;
  }
  
  public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser)
  {
    this.assumedRoleUser = assumedRoleUser;
  }
  
  public AssumedRoleUser getAssumedRoleUser()
  {
    return assumedRoleUser;
  }
  
  public AssumeRoleResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser)
  {
    setAssumedRoleUser(assumedRoleUser);
    return this;
  }
  
  public void setPackedPolicySize(Integer packedPolicySize)
  {
    this.packedPolicySize = packedPolicySize;
  }
  
  public Integer getPackedPolicySize()
  {
    return packedPolicySize;
  }
  
  public AssumeRoleResult withPackedPolicySize(Integer packedPolicySize)
  {
    setPackedPolicySize(packedPolicySize);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCredentials() != null) {
      sb.append("Credentials: ").append(getCredentials()).append(",");
    }
    if (getAssumedRoleUser() != null) {
      sb.append("AssumedRoleUser: ").append(getAssumedRoleUser()).append(",");
    }
    if (getPackedPolicySize() != null) {
      sb.append("PackedPolicySize: ").append(getPackedPolicySize());
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
    if (!(obj instanceof AssumeRoleResult)) {
      return false;
    }
    AssumeRoleResult other = (AssumeRoleResult)obj;
    if (((other.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCredentials() != null) && (!other.getCredentials().equals(getCredentials()))) {
      return false;
    }
    if (((other.getAssumedRoleUser() == null ? 1 : 0) ^ (getAssumedRoleUser() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAssumedRoleUser() != null) && (!other.getAssumedRoleUser().equals(getAssumedRoleUser()))) {
      return false;
    }
    if (((other.getPackedPolicySize() == null ? 1 : 0) ^ (getPackedPolicySize() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPackedPolicySize() != null) && (!other.getPackedPolicySize().equals(getPackedPolicySize()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCredentials() == null ? 0 : getCredentials().hashCode());
    hashCode = 31 * hashCode + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode());
    hashCode = 31 * hashCode + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode());
    return hashCode;
  }
  
  public AssumeRoleResult clone()
  {
    try
    {
      return (AssumeRoleResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */