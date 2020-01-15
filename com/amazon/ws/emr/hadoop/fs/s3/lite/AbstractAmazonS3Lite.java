package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import java.io.File;

abstract class AbstractAmazonS3Lite
  implements AmazonS3Lite
{
  public Bucket createBucket(String bucketName)
    throws AmazonClientException
  {
    return createBucket(new CreateBucketRequest(bucketName));
  }
  
  public Bucket createBucket(String bucketName, String region)
    throws AmazonClientException
  {
    return createBucket(new CreateBucketRequest(bucketName, region));
  }
  
  public S3Object getObject(String bucketName, String key)
    throws AmazonClientException
  {
    return getObject(new GetObjectRequest(bucketName, key));
  }
  
  public S3Object getObject(GetObjectRequest request)
    throws AmazonClientException
  {
    return getObject(request, false);
  }
  
  public ObjectMetadata getObjectMetadata(String bucketName, String key)
    throws AmazonClientException
  {
    return getObjectMetadata(new GetObjectMetadataRequest(bucketName, key));
  }
  
  public PutObjectResult putObject(String bucketName, String key, File file)
    throws AmazonClientException
  {
    return putObject(new PutObjectRequest(bucketName, key, file));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AbstractAmazonS3Lite
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */