package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetSecurityTokenServicePreferencesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String globalEndpointTokenVersion;
  
  public void setGlobalEndpointTokenVersion(String globalEndpointTokenVersion)
  {
    this.globalEndpointTokenVersion = globalEndpointTokenVersion;
  }
  
  public String getGlobalEndpointTokenVersion()
  {
    return globalEndpointTokenVersion;
  }
  
  public SetSecurityTokenServicePreferencesRequest withGlobalEndpointTokenVersion(String globalEndpointTokenVersion)
  {
    setGlobalEndpointTokenVersion(globalEndpointTokenVersion);
    return this;
  }
  
  public SetSecurityTokenServicePreferencesRequest withGlobalEndpointTokenVersion(GlobalEndpointTokenVersion globalEndpointTokenVersion)
  {
    this.globalEndpointTokenVersion = globalEndpointTokenVersion.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalEndpointTokenVersion() != null) {
      sb.append("GlobalEndpointTokenVersion: ").append(getGlobalEndpointTokenVersion());
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
    if (!(obj instanceof SetSecurityTokenServicePreferencesRequest)) {
      return false;
    }
    SetSecurityTokenServicePreferencesRequest other = (SetSecurityTokenServicePreferencesRequest)obj;
    if (((other.getGlobalEndpointTokenVersion() == null ? 1 : 0) ^ (getGlobalEndpointTokenVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalEndpointTokenVersion() != null) && (!other.getGlobalEndpointTokenVersion().equals(getGlobalEndpointTokenVersion()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalEndpointTokenVersion() == null ? 0 : getGlobalEndpointTokenVersion().hashCode());
    return hashCode;
  }
  
  public SetSecurityTokenServicePreferencesRequest clone()
  {
    return (SetSecurityTokenServicePreferencesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetSecurityTokenServicePreferencesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */