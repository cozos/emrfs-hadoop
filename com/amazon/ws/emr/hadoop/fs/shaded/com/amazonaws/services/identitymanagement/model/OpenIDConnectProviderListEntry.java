package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class OpenIDConnectProviderListEntry
  implements Serializable, Cloneable
{
  private String arn;
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public OpenIDConnectProviderListEntry withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof OpenIDConnectProviderListEntry)) {
      return false;
    }
    OpenIDConnectProviderListEntry other = (OpenIDConnectProviderListEntry)obj;
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
    
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    return hashCode;
  }
  
  public OpenIDConnectProviderListEntry clone()
  {
    try
    {
      return (OpenIDConnectProviderListEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.OpenIDConnectProviderListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */