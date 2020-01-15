package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateSecurityConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String name;
  private String securityConfiguration;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CreateSecurityConfigurationRequest withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setSecurityConfiguration(String securityConfiguration)
  {
    this.securityConfiguration = securityConfiguration;
  }
  
  public String getSecurityConfiguration()
  {
    return securityConfiguration;
  }
  
  public CreateSecurityConfigurationRequest withSecurityConfiguration(String securityConfiguration)
  {
    setSecurityConfiguration(securityConfiguration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getSecurityConfiguration() != null) {
      sb.append("SecurityConfiguration: ").append(getSecurityConfiguration());
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
    if (!(obj instanceof CreateSecurityConfigurationRequest)) {
      return false;
    }
    CreateSecurityConfigurationRequest other = (CreateSecurityConfigurationRequest)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getSecurityConfiguration() == null ? 1 : 0) ^ (getSecurityConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSecurityConfiguration() != null) && (!other.getSecurityConfiguration().equals(getSecurityConfiguration()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getSecurityConfiguration() == null ? 0 : getSecurityConfiguration().hashCode());
    return hashCode;
  }
  
  public CreateSecurityConfigurationRequest clone()
  {
    return (CreateSecurityConfigurationRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */