package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import java.io.File;

public abstract interface AmazonS3Lite
{
  public abstract void abortMultipartUpload(AbortMultipartUploadRequest paramAbortMultipartUploadRequest)
    throws AmazonClientException;
  
  public abstract CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest paramCompleteMultipartUploadRequest)
    throws AmazonClientException;
  
  public abstract CopyObjectResult copyObject(CopyObjectRequest paramCopyObjectRequest)
    throws AmazonClientException;
  
  public abstract CopyPartResult copyPart(CopyPartRequest paramCopyPartRequest)
    throws AmazonClientException;
  
  public abstract Bucket createBucket(CreateBucketRequest paramCreateBucketRequest)
    throws AmazonClientException;
  
  public abstract Bucket createBucket(String paramString)
    throws AmazonClientException;
  
  public abstract Bucket createBucket(String paramString1, String paramString2)
    throws AmazonClientException;
  
  public abstract void deleteObject(String paramString1, String paramString2)
    throws AmazonClientException;
  
  public abstract DeleteObjectsResult deleteObjects(DeleteObjectsRequest paramDeleteObjectsRequest)
    throws AmazonClientException;
  
  public abstract boolean doesBucketExist(String paramString)
    throws AmazonClientException;
  
  public abstract BucketVersioningConfiguration getBucketVersioningConfiguration(String paramString)
    throws AmazonClientException;
  
  public abstract S3Object getObject(GetObjectRequest paramGetObjectRequest)
    throws AmazonClientException;
  
  public abstract S3Object getObject(GetObjectRequest paramGetObjectRequest, boolean paramBoolean)
    throws AmazonClientException;
  
  public abstract S3Object getObject(String paramString1, String paramString2)
    throws AmazonClientException;
  
  public abstract ObjectMetadata getObjectMetadata(GetObjectMetadataRequest paramGetObjectMetadataRequest)
    throws AmazonClientException;
  
  public abstract ObjectMetadata getObjectMetadata(String paramString1, String paramString2)
    throws AmazonClientException;
  
  public abstract InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest paramInitiateMultipartUploadRequest)
    throws AmazonClientException;
  
  public abstract MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest paramListMultipartUploadsRequest)
    throws AmazonClientException;
  
  public abstract ListObjectsV2Result listObjectsV2(ListObjectsV2Request paramListObjectsV2Request)
    throws AmazonClientException;
  
  public abstract PartListing listParts(ListPartsRequest paramListPartsRequest)
    throws AmazonClientException;
  
  public abstract VersionListing listVersions(ListVersionsRequest paramListVersionsRequest)
    throws AmazonClientException;
  
  public abstract PutObjectResult putObject(PutObjectRequest paramPutObjectRequest)
    throws AmazonClientException;
  
  public abstract PutObjectResult putObject(String paramString1, String paramString2, File paramFile)
    throws AmazonClientException;
  
  public abstract void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest paramSetBucketVersioningConfigurationRequest)
    throws AmazonClientException;
  
  public abstract UploadPartResult uploadPart(UploadPartRequest paramUploadPartRequest)
    throws AmazonClientException;
  
  public abstract SelectObjectContentResult selectObjectContent(SelectObjectContentRequest paramSelectObjectContentRequest)
    throws AmazonClientException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */