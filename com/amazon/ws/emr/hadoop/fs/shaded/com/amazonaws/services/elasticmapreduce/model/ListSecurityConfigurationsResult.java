package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListSecurityConfigurationsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<SecurityConfigurationSummary> securityConfigurations;
  private String marker;
  
  public List<SecurityConfigurationSummary> getSecurityConfigurations()
  {
    if (securityConfigurations == null) {
      securityConfigurations = new SdkInternalList();
    }
    return securityConfigurations;
  }
  
  public void setSecurityConfigurations(Collection<SecurityConfigurationSummary> securityConfigurations)
  {
    if (securityConfigurations == null)
    {
      this.securityConfigurations = null;
      return;
    }
    this.securityConfigurations = new SdkInternalList(securityConfigurations);
  }
  
  public ListSecurityConfigurationsResult withSecurityConfigurations(SecurityConfigurationSummary... securityConfigurations)
  {
    if (this.securityConfigurations == null) {
      setSecurityConfigurations(new SdkInternalList(securityConfigurations.length));
    }
    for (SecurityConfigurationSummary ele : securityConfigurations) {
      this.securityConfigurations.add(ele);
    }
    return this;
  }
  
  public ListSecurityConfigurationsResult withSecurityConfigurations(Collection<SecurityConfigurationSummary> securityConfigurations)
  {
    setSecurityConfigurations(securityConfigurations);
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListSecurityConfigurationsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSecurityConfigurations() != null) {
      sb.append("SecurityConfigurations: ").append(getSecurityConfigurations()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof ListSecurityConfigurationsResult)) {
      return false;
    }
    ListSecurityConfigurationsResult other = (ListSecurityConfigurationsResult)obj;
    if (((other.getSecurityConfigurations() == null ? 1 : 0) ^ (getSecurityConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSecurityConfigurations() != null) && (!other.getSecurityConfigurations().equals(getSecurityConfigurations()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSecurityConfigurations() == null ? 0 : getSecurityConfigurations().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListSecurityConfigurationsResult clone()
  {
    try
    {
      return (ListSecurityConfigurationsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */