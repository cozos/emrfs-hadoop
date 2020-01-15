package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;

final class AmazonS3EncryptionClient$S3DirectImpl
  extends S3Direct
{
  private AmazonS3EncryptionClient$S3DirectImpl(AmazonS3EncryptionClient paramAmazonS3EncryptionClient) {}
  
  public PutObjectResult putObject(PutObjectRequest req)
  {
    return AmazonS3EncryptionClient.access$101(this$0, req);
  }
  
  public S3Object getObject(GetObjectRequest req)
  {
    return AmazonS3EncryptionClient.access$201(this$0, req);
  }
  
  public ObjectMetadata getObject(GetObjectRequest req, File dest)
  {
    return AmazonS3EncryptionClient.access$301(this$0, req, dest);
  }
  
  public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest req)
  {
    return AmazonS3EncryptionClient.access$401(this$0, req);
  }
  
  public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest req)
  {
    return AmazonS3EncryptionClient.access$501(this$0, req);
  }
  
  public UploadPartResult uploadPart(UploadPartRequest req)
    throws SdkClientException, AmazonServiceException
  {
    return AmazonS3EncryptionClient.access$601(this$0, req);
  }
  
  public CopyPartResult copyPart(CopyPartRequest req)
  {
    return AmazonS3EncryptionClient.access$701(this$0, req);
  }
  
  public void abortMultipartUpload(AbortMultipartUploadRequest req)
  {
    AmazonS3EncryptionClient.access$801(this$0, req);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient.S3DirectImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */