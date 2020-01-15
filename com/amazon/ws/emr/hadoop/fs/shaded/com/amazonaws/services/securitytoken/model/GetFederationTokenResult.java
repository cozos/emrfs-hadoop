package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetFederationTokenResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Credentials credentials;
  private FederatedUser federatedUser;
  private Integer packedPolicySize;
  
  public void setCredentials(Credentials credentials)
  {
    this.credentials = credentials;
  }
  
  public Credentials getCredentials()
  {
    return credentials;
  }
  
  public GetFederationTokenResult withCredentials(Credentials credentials)
  {
    setCredentials(credentials);
    return this;
  }
  
  public void setFederatedUser(FederatedUser federatedUser)
  {
    this.federatedUser = federatedUser;
  }
  
  public FederatedUser getFederatedUser()
  {
    return federatedUser;
  }
  
  public GetFederationTokenResult withFederatedUser(FederatedUser federatedUser)
  {
    setFederatedUser(federatedUser);
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
  
  public GetFederationTokenResult withPackedPolicySize(Integer packedPolicySize)
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
    if (getFederatedUser() != null) {
      sb.append("FederatedUser: ").append(getFederatedUser()).append(",");
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
    if (!(obj instanceof GetFederationTokenResult)) {
      return false;
    }
    GetFederationTokenResult other = (GetFederationTokenResult)obj;
    if (((other.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCredentials() != null) && (!other.getCredentials().equals(getCredentials()))) {
      return false;
    }
    if (((other.getFederatedUser() == null ? 1 : 0) ^ (getFederatedUser() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFederatedUser() != null) && (!other.getFederatedUser().equals(getFederatedUser()))) {
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
    hashCode = 31 * hashCode + (getFederatedUser() == null ? 0 : getFederatedUser().hashCode());
    hashCode = 31 * hashCode + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode());
    return hashCode;
  }
  
  public GetFederationTokenResult clone()
  {
    try
    {
      return (GetFederationTokenResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */