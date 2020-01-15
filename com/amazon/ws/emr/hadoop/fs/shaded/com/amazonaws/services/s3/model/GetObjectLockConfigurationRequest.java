package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetObjectLockConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucket;
  
  public String getBucketName()
  {
    return bucket;
  }
  
  public GetObjectLockConfigurationRequest withBucketName(String bucket)
  {
    this.bucket = bucket;
    return this;
  }
  
  public void setBucketName(String bucket)
  {
    withBucketName(bucket);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */