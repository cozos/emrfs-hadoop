package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketNotificationConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private BucketNotificationConfiguration notificationConfiguration;
  private String bucketName;
  
  @Deprecated
  public SetBucketNotificationConfigurationRequest(BucketNotificationConfiguration bucketNotificationConfiguration, String bucket)
  {
    notificationConfiguration = bucketNotificationConfiguration;
    bucketName = bucket;
  }
  
  public SetBucketNotificationConfigurationRequest(String bucketName, BucketNotificationConfiguration notificationConfiguration)
  {
    this.bucketName = bucketName;
    this.notificationConfiguration = notificationConfiguration;
  }
  
  @Deprecated
  public BucketNotificationConfiguration getBucketNotificationConfiguration()
  {
    return notificationConfiguration;
  }
  
  public BucketNotificationConfiguration getNotificationConfiguration()
  {
    return notificationConfiguration;
  }
  
  @Deprecated
  public void setBucketNotificationConfiguration(BucketNotificationConfiguration bucketNotificationConfiguration)
  {
    notificationConfiguration = bucketNotificationConfiguration;
  }
  
  public void setNotificationConfiguration(BucketNotificationConfiguration notificationConfiguration)
  {
    this.notificationConfiguration = notificationConfiguration;
  }
  
  public SetBucketNotificationConfigurationRequest withNotificationConfiguration(BucketNotificationConfiguration notificationConfiguration)
  {
    setNotificationConfiguration(notificationConfiguration);
    return this;
  }
  
  @Deprecated
  public String getBucket()
  {
    return bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  @Deprecated
  public void setBucket(String bucket)
  {
    bucketName = bucket;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketNotificationConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */