package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.Date;

public class DescribeSecurityConfigurationResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String name;
  private String securityConfiguration;
  private Date creationDateTime;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public DescribeSecurityConfigurationResult withName(String name)
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
  
  public DescribeSecurityConfigurationResult withSecurityConfiguration(String securityConfiguration)
  {
    setSecurityConfiguration(securityConfiguration);
    return this;
  }
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public DescribeSecurityConfigurationResult withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
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
      sb.append("SecurityConfiguration: ").append(getSecurityConfiguration()).append(",");
    }
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime());
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
    if (!(obj instanceof DescribeSecurityConfigurationResult)) {
      return false;
    }
    DescribeSecurityConfigurationResult other = (DescribeSecurityConfigurationResult)obj;
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
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
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
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    return hashCode;
  }
  
  public DescribeSecurityConfigurationResult clone()
  {
    try
    {
      return (DescribeSecurityConfigurationResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */