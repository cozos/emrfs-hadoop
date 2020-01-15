package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.resources;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource;

public class S3ObjectResource
  extends Resource
{
  public S3ObjectResource(String bucketName, String keyPattern)
  {
    this("aws", bucketName, keyPattern);
  }
  
  public S3ObjectResource(String partitionName, String bucketName, String keyPattern)
  {
    super(String.format("arn:%s:s3:::%s/%s", new Object[] { partitionName, bucketName, keyPattern }));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.resources.S3ObjectResource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */