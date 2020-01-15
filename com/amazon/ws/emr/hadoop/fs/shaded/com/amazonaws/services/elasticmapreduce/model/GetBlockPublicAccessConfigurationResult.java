package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetBlockPublicAccessConfigurationResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private BlockPublicAccessConfiguration blockPublicAccessConfiguration;
  private BlockPublicAccessConfigurationMetadata blockPublicAccessConfigurationMetadata;
  
  public void setBlockPublicAccessConfiguration(BlockPublicAccessConfiguration blockPublicAccessConfiguration)
  {
    this.blockPublicAccessConfiguration = blockPublicAccessConfiguration;
  }
  
  public BlockPublicAccessConfiguration getBlockPublicAccessConfiguration()
  {
    return blockPublicAccessConfiguration;
  }
  
  public GetBlockPublicAccessConfigurationResult withBlockPublicAccessConfiguration(BlockPublicAccessConfiguration blockPublicAccessConfiguration)
  {
    setBlockPublicAccessConfiguration(blockPublicAccessConfiguration);
    return this;
  }
  
  public void setBlockPublicAccessConfigurationMetadata(BlockPublicAccessConfigurationMetadata blockPublicAccessConfigurationMetadata)
  {
    this.blockPublicAccessConfigurationMetadata = blockPublicAccessConfigurationMetadata;
  }
  
  public BlockPublicAccessConfigurationMetadata getBlockPublicAccessConfigurationMetadata()
  {
    return blockPublicAccessConfigurationMetadata;
  }
  
  public GetBlockPublicAccessConfigurationResult withBlockPublicAccessConfigurationMetadata(BlockPublicAccessConfigurationMetadata blockPublicAccessConfigurationMetadata)
  {
    setBlockPublicAccessConfigurationMetadata(blockPublicAccessConfigurationMetadata);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBlockPublicAccessConfiguration() != null) {
      sb.append("BlockPublicAccessConfiguration: ").append(getBlockPublicAccessConfiguration()).append(",");
    }
    if (getBlockPublicAccessConfigurationMetadata() != null) {
      sb.append("BlockPublicAccessConfigurationMetadata: ").append(getBlockPublicAccessConfigurationMetadata());
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
    if (!(obj instanceof GetBlockPublicAccessConfigurationResult)) {
      return false;
    }
    GetBlockPublicAccessConfigurationResult other = (GetBlockPublicAccessConfigurationResult)obj;
    if (((other.getBlockPublicAccessConfiguration() == null ? 1 : 0) ^ (getBlockPublicAccessConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBlockPublicAccessConfiguration() != null) && 
      (!other.getBlockPublicAccessConfiguration().equals(getBlockPublicAccessConfiguration()))) {
      return false;
    }
    if (((other.getBlockPublicAccessConfigurationMetadata() == null ? 1 : 0) ^ (getBlockPublicAccessConfigurationMetadata() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBlockPublicAccessConfigurationMetadata() != null) && 
      (!other.getBlockPublicAccessConfigurationMetadata().equals(getBlockPublicAccessConfigurationMetadata()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBlockPublicAccessConfiguration() == null ? 0 : getBlockPublicAccessConfiguration().hashCode());
    hashCode = 31 * hashCode + (getBlockPublicAccessConfigurationMetadata() == null ? 0 : getBlockPublicAccessConfigurationMetadata().hashCode());
    return hashCode;
  }
  
  public GetBlockPublicAccessConfigurationResult clone()
  {
    try
    {
      return (GetBlockPublicAccessConfigurationResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */