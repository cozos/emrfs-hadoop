package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class GetBucketEncryptionResult
  implements Serializable, Cloneable
{
  private ServerSideEncryptionConfiguration serverSideEncryptionConfiguration;
  
  public ServerSideEncryptionConfiguration getServerSideEncryptionConfiguration()
  {
    return serverSideEncryptionConfiguration;
  }
  
  public void setServerSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration)
  {
    this.serverSideEncryptionConfiguration = serverSideEncryptionConfiguration;
  }
  
  public GetBucketEncryptionResult withServerSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration)
  {
    setServerSideEncryptionConfiguration(serverSideEncryptionConfiguration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerSideEncryptionConfiguration() != null) {
      sb.append("ServerSideEncryptionConfiguration: ").append(getServerSideEncryptionConfiguration()).append(",");
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
    if (!(obj instanceof GetBucketEncryptionResult)) {
      return false;
    }
    GetBucketEncryptionResult other = (GetBucketEncryptionResult)obj;
    if (((other.getServerSideEncryptionConfiguration() == null ? 1 : 0) ^ (getServerSideEncryptionConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerSideEncryptionConfiguration() != null) && 
      (!other.getServerSideEncryptionConfiguration().equals(getServerSideEncryptionConfiguration()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServerSideEncryptionConfiguration() == null ? 0 : getServerSideEncryptionConfiguration().hashCode());
    return hashCode;
  }
  
  public GetBucketEncryptionResult clone()
  {
    try
    {
      return (GetBucketEncryptionResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketEncryptionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */