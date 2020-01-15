package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collection;

public final class DoesBucketExistCall
  implements S3GenericCall<Boolean>
{
  private final String bucketName;
  
  public DoesBucketExistCall(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public Boolean perform(AmazonS3 amazonS3)
  {
    return Boolean.valueOf(amazonS3.doesBucketExist(bucketName));
  }
  
  public void setCredentialsProvider(AWSCredentialsProvider credentialsProvider) {}
  
  public void enableRequesterPays() {}
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucket(bucketName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.DoesBucketExistCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */