package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class AssumedRoleUser
  implements Serializable, Cloneable
{
  private String assumedRoleId;
  private String arn;
  
  public void setAssumedRoleId(String assumedRoleId)
  {
    this.assumedRoleId = assumedRoleId;
  }
  
  public String getAssumedRoleId()
  {
    return assumedRoleId;
  }
  
  public AssumedRoleUser withAssumedRoleId(String assumedRoleId)
  {
    setAssumedRoleId(assumedRoleId);
    return this;
  }
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public AssumedRoleUser withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAssumedRoleId() != null) {
      sb.append("AssumedRoleId: ").append(getAssumedRoleId()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn());
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
    if (!(obj instanceof AssumedRoleUser)) {
      return false;
    }
    AssumedRoleUser other = (AssumedRoleUser)obj;
    if (((other.getAssumedRoleId() == null ? 1 : 0) ^ (getAssumedRoleId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAssumedRoleId() != null) && (!other.getAssumedRoleId().equals(getAssumedRoleId()))) {
      return false;
    }
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAssumedRoleId() == null ? 0 : getAssumedRoleId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    return hashCode;
  }
  
  public AssumedRoleUser clone()
  {
    try
    {
      return (AssumedRoleUser)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumedRoleUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */