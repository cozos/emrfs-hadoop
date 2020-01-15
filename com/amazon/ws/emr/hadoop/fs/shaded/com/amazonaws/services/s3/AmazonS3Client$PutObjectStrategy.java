package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.UploadObjectStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;

class AmazonS3Client$PutObjectStrategy
  implements UploadObjectStrategy<PutObjectRequest, PutObjectResult>
{
  private final String bucketName;
  private final String key;
  
  private AmazonS3Client$PutObjectStrategy(AmazonS3Client paramAmazonS3Client, String bucketName, String key)
  {
    this.bucketName = bucketName;
    this.key = key;
  }
  
  public ObjectMetadata invokeServiceCall(Request<PutObjectRequest> request)
  {
    return (ObjectMetadata)AmazonS3Client.access$300(this$0, request, new S3MetadataResponseHandler(), bucketName, key);
  }
  
  public PutObjectResult createResult(ObjectMetadata metadata, String contentMd5)
  {
    PutObjectResult result = AmazonS3Client.access$400(metadata);
    result.setContentMd5(contentMd5);
    return result;
  }
  
  public String md5ValidationErrorSuffix()
  {
    return ", bucketName: " + bucketName + ", key: " + key;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client.PutObjectStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */