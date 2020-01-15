package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.Serializable;

public class SetBucketReplicationConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketReplicationConfiguration replicationConfiguration;
  private String token;
  
  public SetBucketReplicationConfigurationRequest() {}
  
  public SetBucketReplicationConfigurationRequest(String bucketName, BucketReplicationConfiguration replicationConfiguration)
  {
    this.bucketName = bucketName;
    this.replicationConfiguration = replicationConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketReplicationConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketReplicationConfiguration getReplicationConfiguration()
  {
    return replicationConfiguration;
  }
  
  public void setReplicationConfiguration(BucketReplicationConfiguration replicationConfiguration)
  {
    this.replicationConfiguration = replicationConfiguration;
  }
  
  public SetBucketReplicationConfigurationRequest withReplicationConfiguration(BucketReplicationConfiguration replicationConfiguration)
  {
    setReplicationConfiguration(replicationConfiguration);
    return this;
  }
  
  public void setToken(String token)
  {
    this.token = token;
  }
  
  public SetBucketReplicationConfigurationRequest withToken(String token)
  {
    setToken(token);
    return this;
  }
  
  public String getToken()
  {
    return token;
  }
  
  public String toString()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketReplicationConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */