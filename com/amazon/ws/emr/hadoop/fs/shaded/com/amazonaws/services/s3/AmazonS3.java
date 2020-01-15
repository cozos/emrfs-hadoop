package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.HttpMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketCrossOriginConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketEncryptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketLifecycleConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketReplicationConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketTaggingConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketWebsiteConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectTaggingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeletePublicAccessBlockRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeletePublicAccessBlockResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAccelerateConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAclRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketCrossOriginConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketEncryptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketLifecycleConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketLoggingConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketMetricsConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketNotificationConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketPolicyStatusRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketPolicyStatusResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketReplicationConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketTaggingConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketVersioningConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketWebsiteConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectAclRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetPublicAccessBlockRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetPublicAccessBlockResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetS3AccountOwnerRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListNextBatchOfObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListNextBatchOfVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAclRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketCrossOriginConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketEncryptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketInventoryConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketLifecycleConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketMetricsConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketReplicationConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketTaggingConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectAclRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLegalHoldRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLockConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectRetentionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectRetentionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectTaggingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetPublicAccessBlockRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetPublicAccessBlockResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StorageClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters.AmazonS3Waiters;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

public abstract interface AmazonS3
  extends S3DirectSpi
{
  public static final String ENDPOINT_PREFIX = "s3";
  
  public abstract void setEndpoint(String paramString);
  
  public abstract void setRegion(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region paramRegion)
    throws IllegalArgumentException;
  
  public abstract void setS3ClientOptions(S3ClientOptions paramS3ClientOptions);
  
  @Deprecated
  public abstract void changeObjectStorageClass(String paramString1, String paramString2, StorageClass paramStorageClass)
    throws SdkClientException, AmazonServiceException;
  
  @Deprecated
  public abstract void setObjectRedirectLocation(String paramString1, String paramString2, String paramString3)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectListing listObjects(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectListing listObjects(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectListing listObjects(ListObjectsRequest paramListObjectsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ListObjectsV2Result listObjectsV2(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ListObjectsV2Result listObjectsV2(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ListObjectsV2Result listObjectsV2(ListObjectsV2Request paramListObjectsV2Request)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectListing listNextBatchOfObjects(ObjectListing paramObjectListing)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest paramListNextBatchOfObjectsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract VersionListing listVersions(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract VersionListing listNextBatchOfVersions(VersionListing paramVersionListing)
    throws SdkClientException, AmazonServiceException;
  
  public abstract VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest paramListNextBatchOfVersionsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract VersionListing listVersions(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Integer paramInteger)
    throws SdkClientException, AmazonServiceException;
  
  public abstract VersionListing listVersions(ListVersionsRequest paramListVersionsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract Owner getS3AccountOwner()
    throws SdkClientException, AmazonServiceException;
  
  public abstract Owner getS3AccountOwner(GetS3AccountOwnerRequest paramGetS3AccountOwnerRequest)
    throws SdkClientException, AmazonServiceException;
  
  @Deprecated
  public abstract boolean doesBucketExist(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract boolean doesBucketExistV2(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract HeadBucketResult headBucket(HeadBucketRequest paramHeadBucketRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract List<Bucket> listBuckets()
    throws SdkClientException, AmazonServiceException;
  
  public abstract List<Bucket> listBuckets(ListBucketsRequest paramListBucketsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract String getBucketLocation(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract String getBucketLocation(GetBucketLocationRequest paramGetBucketLocationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract Bucket createBucket(CreateBucketRequest paramCreateBucketRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract Bucket createBucket(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  @Deprecated
  public abstract Bucket createBucket(String paramString, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region paramRegion)
    throws SdkClientException, AmazonServiceException;
  
  @Deprecated
  public abstract Bucket createBucket(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract AccessControlList getObjectAcl(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract AccessControlList getObjectAcl(String paramString1, String paramString2, String paramString3)
    throws SdkClientException, AmazonServiceException;
  
  public abstract AccessControlList getObjectAcl(GetObjectAclRequest paramGetObjectAclRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setObjectAcl(String paramString1, String paramString2, AccessControlList paramAccessControlList)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setObjectAcl(String paramString1, String paramString2, CannedAccessControlList paramCannedAccessControlList)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setObjectAcl(String paramString1, String paramString2, String paramString3, AccessControlList paramAccessControlList)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setObjectAcl(String paramString1, String paramString2, String paramString3, CannedAccessControlList paramCannedAccessControlList)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setObjectAcl(SetObjectAclRequest paramSetObjectAclRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract AccessControlList getBucketAcl(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketAcl(SetBucketAclRequest paramSetBucketAclRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract AccessControlList getBucketAcl(GetBucketAclRequest paramGetBucketAclRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketAcl(String paramString, AccessControlList paramAccessControlList)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketAcl(String paramString, CannedAccessControlList paramCannedAccessControlList)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectMetadata getObjectMetadata(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectMetadata getObjectMetadata(GetObjectMetadataRequest paramGetObjectMetadataRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract S3Object getObject(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract S3Object getObject(GetObjectRequest paramGetObjectRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract ObjectMetadata getObject(GetObjectRequest paramGetObjectRequest, File paramFile)
    throws SdkClientException, AmazonServiceException;
  
  public abstract String getObjectAsString(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest paramGetObjectTaggingRequest);
  
  public abstract SetObjectTaggingResult setObjectTagging(SetObjectTaggingRequest paramSetObjectTaggingRequest);
  
  public abstract DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest paramDeleteObjectTaggingRequest);
  
  public abstract void deleteBucket(DeleteBucketRequest paramDeleteBucketRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteBucket(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract PutObjectResult putObject(PutObjectRequest paramPutObjectRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract PutObjectResult putObject(String paramString1, String paramString2, File paramFile)
    throws SdkClientException, AmazonServiceException;
  
  public abstract PutObjectResult putObject(String paramString1, String paramString2, InputStream paramInputStream, ObjectMetadata paramObjectMetadata)
    throws SdkClientException, AmazonServiceException;
  
  public abstract PutObjectResult putObject(String paramString1, String paramString2, String paramString3)
    throws AmazonServiceException, SdkClientException;
  
  public abstract CopyObjectResult copyObject(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SdkClientException, AmazonServiceException;
  
  public abstract CopyObjectResult copyObject(CopyObjectRequest paramCopyObjectRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract CopyPartResult copyPart(CopyPartRequest paramCopyPartRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteObject(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteObject(DeleteObjectRequest paramDeleteObjectRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract DeleteObjectsResult deleteObjects(DeleteObjectsRequest paramDeleteObjectsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteVersion(String paramString1, String paramString2, String paramString3)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteVersion(DeleteVersionRequest paramDeleteVersionRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketLoggingConfiguration getBucketLoggingConfiguration(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest paramGetBucketLoggingConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest paramSetBucketLoggingConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketVersioningConfiguration getBucketVersioningConfiguration(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest paramGetBucketVersioningConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest paramSetBucketVersioningConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketLifecycleConfiguration getBucketLifecycleConfiguration(String paramString);
  
  public abstract BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest paramGetBucketLifecycleConfigurationRequest);
  
  public abstract void setBucketLifecycleConfiguration(String paramString, BucketLifecycleConfiguration paramBucketLifecycleConfiguration);
  
  public abstract void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest paramSetBucketLifecycleConfigurationRequest);
  
  public abstract void deleteBucketLifecycleConfiguration(String paramString);
  
  public abstract void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest paramDeleteBucketLifecycleConfigurationRequest);
  
  public abstract BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String paramString);
  
  public abstract BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest paramGetBucketCrossOriginConfigurationRequest);
  
  public abstract void setBucketCrossOriginConfiguration(String paramString, BucketCrossOriginConfiguration paramBucketCrossOriginConfiguration);
  
  public abstract void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest paramSetBucketCrossOriginConfigurationRequest);
  
  public abstract void deleteBucketCrossOriginConfiguration(String paramString);
  
  public abstract void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest paramDeleteBucketCrossOriginConfigurationRequest);
  
  public abstract BucketTaggingConfiguration getBucketTaggingConfiguration(String paramString);
  
  public abstract BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest paramGetBucketTaggingConfigurationRequest);
  
  public abstract void setBucketTaggingConfiguration(String paramString, BucketTaggingConfiguration paramBucketTaggingConfiguration);
  
  public abstract void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest paramSetBucketTaggingConfigurationRequest);
  
  public abstract void deleteBucketTaggingConfiguration(String paramString);
  
  public abstract void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest paramDeleteBucketTaggingConfigurationRequest);
  
  public abstract BucketNotificationConfiguration getBucketNotificationConfiguration(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest paramGetBucketNotificationConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest paramSetBucketNotificationConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketNotificationConfiguration(String paramString, BucketNotificationConfiguration paramBucketNotificationConfiguration)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketWebsiteConfiguration getBucketWebsiteConfiguration(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest paramGetBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketWebsiteConfiguration(String paramString, BucketWebsiteConfiguration paramBucketWebsiteConfiguration)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest paramSetBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteBucketWebsiteConfiguration(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest paramDeleteBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketPolicy getBucketPolicy(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract BucketPolicy getBucketPolicy(GetBucketPolicyRequest paramGetBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketPolicy(String paramString1, String paramString2)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void setBucketPolicy(SetBucketPolicyRequest paramSetBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteBucketPolicy(String paramString)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void deleteBucketPolicy(DeleteBucketPolicyRequest paramDeleteBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract URL generatePresignedUrl(String paramString1, String paramString2, Date paramDate)
    throws SdkClientException;
  
  public abstract URL generatePresignedUrl(String paramString1, String paramString2, Date paramDate, HttpMethod paramHttpMethod)
    throws SdkClientException;
  
  public abstract URL generatePresignedUrl(GeneratePresignedUrlRequest paramGeneratePresignedUrlRequest)
    throws SdkClientException;
  
  public abstract InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest paramInitiateMultipartUploadRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract UploadPartResult uploadPart(UploadPartRequest paramUploadPartRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract PartListing listParts(ListPartsRequest paramListPartsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract void abortMultipartUpload(AbortMultipartUploadRequest paramAbortMultipartUploadRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest paramCompleteMultipartUploadRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest paramListMultipartUploadsRequest)
    throws SdkClientException, AmazonServiceException;
  
  public abstract S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  @Deprecated
  public abstract void restoreObject(RestoreObjectRequest paramRestoreObjectRequest)
    throws AmazonServiceException;
  
  public abstract RestoreObjectResult restoreObjectV2(RestoreObjectRequest paramRestoreObjectRequest)
    throws AmazonServiceException;
  
  @Deprecated
  public abstract void restoreObject(String paramString1, String paramString2, int paramInt)
    throws AmazonServiceException;
  
  public abstract void enableRequesterPays(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void disableRequesterPays(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract boolean isRequesterPaysEnabled(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void setBucketReplicationConfiguration(String paramString, BucketReplicationConfiguration paramBucketReplicationConfiguration)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest paramSetBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract BucketReplicationConfiguration getBucketReplicationConfiguration(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest paramGetBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void deleteBucketReplicationConfiguration(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest paramDeleteBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract boolean doesObjectExist(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract BucketAccelerateConfiguration getBucketAccelerateConfiguration(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest paramGetBucketAccelerateConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void setBucketAccelerateConfiguration(String paramString, BucketAccelerateConfiguration paramBucketAccelerateConfiguration)
    throws AmazonServiceException, SdkClientException;
  
  public abstract void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest paramSetBucketAccelerateConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest paramDeleteBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest paramGetBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(String paramString, MetricsConfiguration paramMetricsConfiguration)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(SetBucketMetricsConfigurationRequest paramSetBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract ListBucketMetricsConfigurationsResult listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest paramListBucketMetricsConfigurationsRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest paramDeleteBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest paramGetBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(String paramString, AnalyticsConfiguration paramAnalyticsConfiguration)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(SetBucketAnalyticsConfigurationRequest paramSetBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract ListBucketAnalyticsConfigurationsResult listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest paramListBucketAnalyticsConfigurationsRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest paramDeleteBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(String paramString1, String paramString2)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest paramGetBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(String paramString, InventoryConfiguration paramInventoryConfiguration)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(SetBucketInventoryConfigurationRequest paramSetBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract ListBucketInventoryConfigurationsResult listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest paramListBucketInventoryConfigurationsRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketEncryptionResult deleteBucketEncryption(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract DeleteBucketEncryptionResult deleteBucketEncryption(DeleteBucketEncryptionRequest paramDeleteBucketEncryptionRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketEncryptionResult getBucketEncryption(String paramString)
    throws AmazonServiceException, SdkClientException;
  
  public abstract GetBucketEncryptionResult getBucketEncryption(GetBucketEncryptionRequest paramGetBucketEncryptionRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetBucketEncryptionResult setBucketEncryption(SetBucketEncryptionRequest paramSetBucketEncryptionRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetPublicAccessBlockResult setPublicAccessBlock(SetPublicAccessBlockRequest paramSetPublicAccessBlockRequest);
  
  public abstract GetPublicAccessBlockResult getPublicAccessBlock(GetPublicAccessBlockRequest paramGetPublicAccessBlockRequest);
  
  public abstract DeletePublicAccessBlockResult deletePublicAccessBlock(DeletePublicAccessBlockRequest paramDeletePublicAccessBlockRequest);
  
  public abstract GetBucketPolicyStatusResult getBucketPolicyStatus(GetBucketPolicyStatusRequest paramGetBucketPolicyStatusRequest);
  
  public abstract SelectObjectContentResult selectObjectContent(SelectObjectContentRequest paramSelectObjectContentRequest)
    throws AmazonServiceException, SdkClientException;
  
  public abstract SetObjectLegalHoldResult setObjectLegalHold(SetObjectLegalHoldRequest paramSetObjectLegalHoldRequest);
  
  public abstract GetObjectLegalHoldResult getObjectLegalHold(GetObjectLegalHoldRequest paramGetObjectLegalHoldRequest);
  
  public abstract SetObjectLockConfigurationResult setObjectLockConfiguration(SetObjectLockConfigurationRequest paramSetObjectLockConfigurationRequest);
  
  public abstract GetObjectLockConfigurationResult getObjectLockConfiguration(GetObjectLockConfigurationRequest paramGetObjectLockConfigurationRequest);
  
  public abstract SetObjectRetentionResult setObjectRetention(SetObjectRetentionRequest paramSetObjectRetentionRequest);
  
  public abstract GetObjectRetentionResult getObjectRetention(GetObjectRetentionRequest paramGetObjectRetentionRequest);
  
  public abstract PresignedUrlDownloadResult download(PresignedUrlDownloadRequest paramPresignedUrlDownloadRequest);
  
  public abstract void download(PresignedUrlDownloadRequest paramPresignedUrlDownloadRequest, File paramFile);
  
  public abstract PresignedUrlUploadResult upload(PresignedUrlUploadRequest paramPresignedUrlUploadRequest);
  
  public abstract void shutdown();
  
  public abstract com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region getRegion();
  
  public abstract String getRegionName();
  
  public abstract URL getUrl(String paramString1, String paramString2);
  
  public abstract AmazonS3Waiters waiters();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */