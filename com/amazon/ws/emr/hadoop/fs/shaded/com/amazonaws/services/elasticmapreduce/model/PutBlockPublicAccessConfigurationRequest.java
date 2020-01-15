package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class PutBlockPublicAccessConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private BlockPublicAccessConfiguration blockPublicAccessConfiguration;
  
  public void setBlockPublicAccessConfiguration(BlockPublicAccessConfiguration blockPublicAccessConfiguration)
  {
    this.blockPublicAccessConfiguration = blockPublicAccessConfiguration;
  }
  
  public BlockPublicAccessConfiguration getBlockPublicAccessConfiguration()
  {
    return blockPublicAccessConfiguration;
  }
  
  public PutBlockPublicAccessConfigurationRequest withBlockPublicAccessConfiguration(BlockPublicAccessConfiguration blockPublicAccessConfiguration)
  {
    setBlockPublicAccessConfiguration(blockPublicAccessConfiguration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBlockPublicAccessConfiguration() != null) {
      sb.append("BlockPublicAccessConfiguration: ").append(getBlockPublicAccessConfiguration());
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
    if (!(obj instanceof PutBlockPublicAccessConfigurationRequest)) {
      return false;
    }
    PutBlockPublicAccessConfigurationRequest other = (PutBlockPublicAccessConfigurationRequest)obj;
    if (((other.getBlockPublicAccessConfiguration() == null ? 1 : 0) ^ (getBlockPublicAccessConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBlockPublicAccessConfiguration() != null) && 
      (!other.getBlockPublicAccessConfiguration().equals(getBlockPublicAccessConfiguration()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBlockPublicAccessConfiguration() == null ? 0 : getBlockPublicAccessConfiguration().hashCode());
    return hashCode;
  }
  
  public PutBlockPublicAccessConfigurationRequest clone()
  {
    return (PutBlockPublicAccessConfigurationRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */