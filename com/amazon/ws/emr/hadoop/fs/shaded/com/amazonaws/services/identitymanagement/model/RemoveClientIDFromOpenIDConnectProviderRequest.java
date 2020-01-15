package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RemoveClientIDFromOpenIDConnectProviderRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String openIDConnectProviderArn;
  private String clientID;
  
  public void setOpenIDConnectProviderArn(String openIDConnectProviderArn)
  {
    this.openIDConnectProviderArn = openIDConnectProviderArn;
  }
  
  public String getOpenIDConnectProviderArn()
  {
    return openIDConnectProviderArn;
  }
  
  public RemoveClientIDFromOpenIDConnectProviderRequest withOpenIDConnectProviderArn(String openIDConnectProviderArn)
  {
    setOpenIDConnectProviderArn(openIDConnectProviderArn);
    return this;
  }
  
  public void setClientID(String clientID)
  {
    this.clientID = clientID;
  }
  
  public String getClientID()
  {
    return clientID;
  }
  
  public RemoveClientIDFromOpenIDConnectProviderRequest withClientID(String clientID)
  {
    setClientID(clientID);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getOpenIDConnectProviderArn() != null) {
      sb.append("OpenIDConnectProviderArn: ").append(getOpenIDConnectProviderArn()).append(",");
    }
    if (getClientID() != null) {
      sb.append("ClientID: ").append(getClientID());
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
    if (!(obj instanceof RemoveClientIDFromOpenIDConnectProviderRequest)) {
      return false;
    }
    RemoveClientIDFromOpenIDConnectProviderRequest other = (RemoveClientIDFromOpenIDConnectProviderRequest)obj;
    if (((other.getOpenIDConnectProviderArn() == null ? 1 : 0) ^ (getOpenIDConnectProviderArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOpenIDConnectProviderArn() != null) && (!other.getOpenIDConnectProviderArn().equals(getOpenIDConnectProviderArn()))) {
      return false;
    }
    if (((other.getClientID() == null ? 1 : 0) ^ (getClientID() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClientID() != null) && (!other.getClientID().equals(getClientID()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getOpenIDConnectProviderArn() == null ? 0 : getOpenIDConnectProviderArn().hashCode());
    hashCode = 31 * hashCode + (getClientID() == null ? 0 : getClientID().hashCode());
    return hashCode;
  }
  
  public RemoveClientIDFromOpenIDConnectProviderRequest clone()
  {
    return (RemoveClientIDFromOpenIDConnectProviderRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */