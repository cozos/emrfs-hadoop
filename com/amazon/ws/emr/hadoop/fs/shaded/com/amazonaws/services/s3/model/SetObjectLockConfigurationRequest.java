package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetObjectLockConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucket;
  private ObjectLockConfiguration objectLockConfiguration;
  private boolean isRequesterPays;
  private String token;
  
  public String getBucketName()
  {
    return bucket;
  }
  
  public SetObjectLockConfigurationRequest withBucketName(String bucket)
  {
    this.bucket = bucket;
    return this;
  }
  
  public void setBucketName(String bucket)
  {
    withBucketName(bucket);
  }
  
  public ObjectLockConfiguration getObjectLockConfiguration()
  {
    return objectLockConfiguration;
  }
  
  public SetObjectLockConfigurationRequest withObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration)
  {
    this.objectLockConfiguration = objectLockConfiguration;
    return this;
  }
  
  public void setObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration)
  {
    withObjectLockConfiguration(objectLockConfiguration);
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public SetObjectLockConfigurationRequest withRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
    return this;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public String getToken()
  {
    return token;
  }
  
  public SetObjectLockConfigurationRequest withToken(String token)
  {
    this.token = token;
    return this;
  }
  
  public void setToken(String token)
  {
    withToken(token);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLockConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */