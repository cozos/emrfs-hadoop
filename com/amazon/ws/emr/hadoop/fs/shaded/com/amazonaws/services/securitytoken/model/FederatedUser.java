package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class FederatedUser
  implements Serializable, Cloneable
{
  private String federatedUserId;
  private String arn;
  
  public FederatedUser() {}
  
  public FederatedUser(String federatedUserId, String arn)
  {
    setFederatedUserId(federatedUserId);
    setArn(arn);
  }
  
  public void setFederatedUserId(String federatedUserId)
  {
    this.federatedUserId = federatedUserId;
  }
  
  public String getFederatedUserId()
  {
    return federatedUserId;
  }
  
  public FederatedUser withFederatedUserId(String federatedUserId)
  {
    setFederatedUserId(federatedUserId);
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
  
  public FederatedUser withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getFederatedUserId() != null) {
      sb.append("FederatedUserId: ").append(getFederatedUserId()).append(",");
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
    if (!(obj instanceof FederatedUser)) {
      return false;
    }
    FederatedUser other = (FederatedUser)obj;
    if (((other.getFederatedUserId() == null ? 1 : 0) ^ (getFederatedUserId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFederatedUserId() != null) && (!other.getFederatedUserId().equals(getFederatedUserId()))) {
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
    
    hashCode = 31 * hashCode + (getFederatedUserId() == null ? 0 : getFederatedUserId().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    return hashCode;
  }
  
  public FederatedUser clone()
  {
    try
    {
      return (FederatedUser)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.FederatedUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */