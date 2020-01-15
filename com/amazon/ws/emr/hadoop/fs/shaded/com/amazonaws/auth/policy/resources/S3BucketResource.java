package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.resources;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource;

public class S3BucketResource
  extends Resource
{
  public S3BucketResource(String bucketName)
  {
    this("aws", bucketName);
  }
  
  public S3BucketResource(String partitionName, String bucketName)
  {
    super(String.format("arn:%s:s3:::%s", new Object[] { partitionName, bucketName }));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.resources.S3BucketResource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */