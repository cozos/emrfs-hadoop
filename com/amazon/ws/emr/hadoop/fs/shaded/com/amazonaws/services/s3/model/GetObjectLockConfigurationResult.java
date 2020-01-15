package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public class GetObjectLockConfigurationResult
{
  private ObjectLockConfiguration objectLockConfiguration;
  
  public ObjectLockConfiguration getObjectLockConfiguration()
  {
    return objectLockConfiguration;
  }
  
  public GetObjectLockConfigurationResult withObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration)
  {
    this.objectLockConfiguration = objectLockConfiguration;
    return this;
  }
  
  public void setObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration)
  {
    withObjectLockConfiguration(objectLockConfiguration);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */