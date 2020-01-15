package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class GetPublicAccessBlockResult
  implements Serializable, Cloneable
{
  private PublicAccessBlockConfiguration publicAccessBlockConfiguration;
  
  public PublicAccessBlockConfiguration getPublicAccessBlockConfiguration()
  {
    return publicAccessBlockConfiguration;
  }
  
  public void setPublicAccessBlockConfiguration(PublicAccessBlockConfiguration publicAccessBlockConfiguration)
  {
    this.publicAccessBlockConfiguration = publicAccessBlockConfiguration;
  }
  
  public GetPublicAccessBlockResult withPublicAccessBlockConfiguration(PublicAccessBlockConfiguration publicAccessBlockConfiguration)
  {
    setPublicAccessBlockConfiguration(publicAccessBlockConfiguration);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    GetPublicAccessBlockResult that = (GetPublicAccessBlockResult)o;
    
    return publicAccessBlockConfiguration == null ? true : publicAccessBlockConfiguration != null ? publicAccessBlockConfiguration.equals(publicAccessBlockConfiguration) : false;
  }
  
  public int hashCode()
  {
    return publicAccessBlockConfiguration != null ? publicAccessBlockConfiguration.hashCode() : 0;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPublicAccessBlockConfiguration() != null) {
      sb.append("PublicAccessBlockConfiguration: ").append(getPublicAccessBlockConfiguration()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public GetPublicAccessBlockResult clone()
  {
    try
    {
      return (GetPublicAccessBlockResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetPublicAccessBlockResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */