package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketEncryptionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String bucketName;
  private ServerSideEncryptionConfiguration serverSideEncryptionConfiguration;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketEncryptionRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public ServerSideEncryptionConfiguration getServerSideEncryptionConfiguration()
  {
    return serverSideEncryptionConfiguration;
  }
  
  public void setServerSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration)
  {
    this.serverSideEncryptionConfiguration = serverSideEncryptionConfiguration;
  }
  
  public SetBucketEncryptionRequest withServerSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration)
  {
    setServerSideEncryptionConfiguration(serverSideEncryptionConfiguration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBucketName() != null) {
      sb.append("BucketName: ").append(getBucketName()).append(",");
    }
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
    if (!(obj instanceof SetBucketEncryptionRequest)) {
      return false;
    }
    SetBucketEncryptionRequest other = (SetBucketEncryptionRequest)obj;
    if (((other.getBucketName() == null ? 1 : 0) ^ (getBucketName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBucketName() != null) && (!other.getBucketName().equals(getBucketName()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getBucketName() == null ? 0 : getBucketName().hashCode());
    
    hashCode = 31 * hashCode + (getServerSideEncryptionConfiguration() == null ? 0 : getServerSideEncryptionConfiguration().hashCode());
    return hashCode;
  }
  
  public SetBucketEncryptionRequest clone()
  {
    return (SetBucketEncryptionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketEncryptionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */