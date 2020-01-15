package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.HttpMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
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

public abstract class AbstractAmazonS3
  implements AmazonS3
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setRegion(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region region)
    throws IllegalArgumentException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setS3ClientOptions(S3ClientOptions clientOptions)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void changeObjectStorageClass(String bucketName, String key, StorageClass newStorageClass)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setObjectRedirectLocation(String bucketName, String key, String newRedirectLocation)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ObjectListing listObjects(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return listObjects(new ListObjectsRequest(bucketName, null, null, null, null));
  }
  
  public ObjectListing listObjects(String bucketName, String prefix)
    throws SdkClientException, AmazonServiceException
  {
    return listObjects(new ListObjectsRequest(bucketName, prefix, null, null, null));
  }
  
  public ObjectListing listObjects(ListObjectsRequest listObjectsRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ListObjectsV2Result listObjectsV2(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    ListObjectsV2Request request = new ListObjectsV2Request();
    request.setBucketName(bucketName);
    return listObjectsV2(request);
  }
  
  public ListObjectsV2Result listObjectsV2(String bucketName, String prefix)
    throws SdkClientException, AmazonServiceException
  {
    ListObjectsV2Request request = new ListObjectsV2Request();
    request.setBucketName(bucketName);
    request.setPrefix(prefix);
    return listObjectsV2(request);
  }
  
  public ListObjectsV2Result listObjectsV2(ListObjectsV2Request listObjectsV2Request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ObjectListing listNextBatchOfObjects(ObjectListing previousObjectListing)
    throws SdkClientException, AmazonServiceException
  {
    return listNextBatchOfObjects(new ListNextBatchOfObjectsRequest(previousObjectListing));
  }
  
  public ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest listNextBatchOfObjectsRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public VersionListing listVersions(String bucketName, String prefix)
    throws SdkClientException, AmazonServiceException
  {
    return listVersions(new ListVersionsRequest(bucketName, prefix, null, null, null, null));
  }
  
  public VersionListing listVersions(String bucketName, String prefix, String keyMarker, String versionIdMarker, String delimiter, Integer maxResults)
    throws SdkClientException, AmazonServiceException
  {
    ListVersionsRequest request = new ListVersionsRequest().withBucketName(bucketName).withPrefix(prefix).withDelimiter(delimiter).withKeyMarker(keyMarker).withVersionIdMarker(versionIdMarker).withMaxResults(maxResults);
    return listVersions(request);
  }
  
  public VersionListing listVersions(ListVersionsRequest listVersionsRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public VersionListing listNextBatchOfVersions(VersionListing previousVersionListing)
    throws SdkClientException, AmazonServiceException
  {
    return listNextBatchOfVersions(new ListNextBatchOfVersionsRequest(previousVersionListing));
  }
  
  public VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest listNextBatchOfVersionsRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public Owner getS3AccountOwner()
    throws SdkClientException, AmazonServiceException
  {
    return getS3AccountOwner(new GetS3AccountOwnerRequest());
  }
  
  public Owner getS3AccountOwner(GetS3AccountOwnerRequest getS3AccountOwnerRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public boolean doesBucketExist(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public boolean doesBucketExistV2(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public HeadBucketResult headBucket(HeadBucketRequest headBucketRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public List<Bucket> listBuckets()
    throws SdkClientException, AmazonServiceException
  {
    return listBuckets(new ListBucketsRequest());
  }
  
  public List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public String getBucketLocation(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketLocation(new GetBucketLocationRequest(bucketName));
  }
  
  public String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public Bucket createBucket(CreateBucketRequest createBucketRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public Bucket createBucket(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return createBucket(new CreateBucketRequest(bucketName));
  }
  
  public Bucket createBucket(String bucketName, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region region)
    throws SdkClientException, AmazonServiceException
  {
    return createBucket(new CreateBucketRequest(bucketName, region));
  }
  
  public Bucket createBucket(String bucketName, String region)
    throws SdkClientException, AmazonServiceException
  {
    return createBucket(new CreateBucketRequest(bucketName, region));
  }
  
  public AccessControlList getObjectAcl(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    return getObjectAcl(new GetObjectAclRequest(bucketName, key));
  }
  
  public AccessControlList getObjectAcl(String bucketName, String key, String versionId)
    throws SdkClientException, AmazonServiceException
  {
    return getObjectAcl(new GetObjectAclRequest(bucketName, key, versionId));
  }
  
  public AccessControlList getObjectAcl(GetObjectAclRequest getObjectAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setObjectAcl(String bucketName, String key, AccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAcl(bucketName, key, null, acl);
  }
  
  public void setObjectAcl(String bucketName, String key, CannedAccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAcl(bucketName, key, null, acl);
  }
  
  public void setObjectAcl(String bucketName, String key, String versionId, AccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAcl(new SetObjectAclRequest(bucketName, key, versionId, acl));
  }
  
  public void setObjectAcl(String bucketName, String key, String versionId, CannedAccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAcl(new SetObjectAclRequest(bucketName, key, versionId, acl));
  }
  
  public void setObjectAcl(SetObjectAclRequest setObjectAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public AccessControlList getBucketAcl(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketAcl(new GetBucketAclRequest(bucketName));
  }
  
  public AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketAcl(String bucketName, AccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setBucketAcl(new SetBucketAclRequest(bucketName, acl));
  }
  
  public void setBucketAcl(String bucketName, CannedAccessControlList cannedAcl)
    throws SdkClientException, AmazonServiceException
  {
    setBucketAcl(new SetBucketAclRequest(bucketName, cannedAcl));
  }
  
  public void setBucketAcl(SetBucketAclRequest setBucketAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ObjectMetadata getObjectMetadata(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    return getObjectMetadata(new GetObjectMetadataRequest(bucketName, key));
  }
  
  public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public S3Object getObject(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    return getObject(new GetObjectRequest(bucketName, key));
  }
  
  public S3Object getObject(GetObjectRequest getObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File destinationFile)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public String getObjectAsString(String bucketName, String key)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest objectTaggingRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetObjectTaggingResult setObjectTagging(SetObjectTaggingRequest setObjectTaggingRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucket(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucket(new DeleteBucketRequest(bucketName));
  }
  
  public void deleteBucket(DeleteBucketRequest deleteBucketRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public PutObjectResult putObject(String bucketName, String key, File file)
    throws SdkClientException, AmazonServiceException
  {
    return putObject(new PutObjectRequest(bucketName, key, file)
      .withMetadata(new ObjectMetadata()));
  }
  
  public PutObjectResult putObject(String bucketName, String key, InputStream input, ObjectMetadata metadata)
    throws SdkClientException, AmazonServiceException
  {
    return putObject(new PutObjectRequest(bucketName, key, input, metadata));
  }
  
  public PutObjectResult putObject(PutObjectRequest putObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public PutObjectResult putObject(String bucketName, String key, String content)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey)
    throws SdkClientException, AmazonServiceException
  {
    return copyObject(new CopyObjectRequest(sourceBucketName, sourceKey, destinationBucketName, destinationKey));
  }
  
  public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public CopyPartResult copyPart(CopyPartRequest copyPartRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteObject(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    deleteObject(new DeleteObjectRequest(bucketName, key));
  }
  
  public void deleteObject(DeleteObjectRequest deleteObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteVersion(String bucketName, String key, String versionId)
    throws SdkClientException, AmazonServiceException
  {
    deleteVersion(new DeleteVersionRequest(bucketName, key, versionId));
  }
  
  public void deleteVersion(DeleteVersionRequest deleteVersionRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketLoggingConfiguration getBucketLoggingConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketLoggingConfiguration(new GetBucketLoggingConfigurationRequest(bucketName));
  }
  
  public BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest getBucketLoggingConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketVersioningConfiguration getBucketVersioningConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketVersioningConfiguration(new GetBucketVersioningConfigurationRequest(bucketName));
  }
  
  public BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest getBucketVersioningConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketLifecycleConfiguration getBucketLifecycleConfiguration(String bucketName)
  {
    return getBucketLifecycleConfiguration(new GetBucketLifecycleConfigurationRequest(bucketName));
  }
  
  public BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketLifecycleConfiguration(String bucketName, BucketLifecycleConfiguration bucketLifecycleConfiguration)
  {
    setBucketLifecycleConfiguration(new SetBucketLifecycleConfigurationRequest(bucketName, bucketLifecycleConfiguration));
  }
  
  public void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucketLifecycleConfiguration(String bucketName)
  {
    deleteBucketLifecycleConfiguration(new DeleteBucketLifecycleConfigurationRequest(bucketName));
  }
  
  public void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String bucketName)
  {
    return getBucketCrossOriginConfiguration(new GetBucketCrossOriginConfigurationRequest(bucketName));
  }
  
  public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest getBucketCrossOriginConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketCrossOriginConfiguration(String bucketName, BucketCrossOriginConfiguration bucketCrossOriginConfiguration)
  {
    setBucketCrossOriginConfiguration(new SetBucketCrossOriginConfigurationRequest(bucketName, bucketCrossOriginConfiguration));
  }
  
  public void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucketCrossOriginConfiguration(String bucketName)
  {
    deleteBucketCrossOriginConfiguration(new DeleteBucketCrossOriginConfigurationRequest(bucketName));
  }
  
  public void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketTaggingConfiguration getBucketTaggingConfiguration(String bucketName)
  {
    return getBucketTaggingConfiguration(new GetBucketTaggingConfigurationRequest(bucketName));
  }
  
  public BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest getBucketTaggingConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketTaggingConfiguration(String bucketName, BucketTaggingConfiguration bucketTaggingConfiguration)
  {
    setBucketTaggingConfiguration(new SetBucketTaggingConfigurationRequest(bucketName, bucketTaggingConfiguration));
  }
  
  public void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucketTaggingConfiguration(String bucketName)
  {
    deleteBucketTaggingConfiguration(new DeleteBucketTaggingConfigurationRequest(bucketName));
  }
  
  public void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketNotificationConfiguration getBucketNotificationConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketNotificationConfiguration(new GetBucketNotificationConfigurationRequest(bucketName));
  }
  
  public BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketNotificationConfiguration(String bucketName, BucketNotificationConfiguration bucketNotificationConfiguration)
    throws SdkClientException, AmazonServiceException
  {
    setBucketNotificationConfiguration(new SetBucketNotificationConfigurationRequest(bucketName, bucketNotificationConfiguration));
  }
  
  public void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketWebsiteConfiguration getBucketWebsiteConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketWebsiteConfiguration(new GetBucketWebsiteConfigurationRequest(bucketName));
  }
  
  public BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketWebsiteConfiguration(String bucketName, BucketWebsiteConfiguration configuration)
    throws SdkClientException, AmazonServiceException
  {
    setBucketWebsiteConfiguration(new SetBucketWebsiteConfigurationRequest(bucketName, configuration));
  }
  
  public void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucketWebsiteConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketWebsiteConfiguration(new DeleteBucketWebsiteConfigurationRequest(bucketName));
  }
  
  public void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketPolicy getBucketPolicy(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketPolicy(new GetBucketPolicyRequest(bucketName));
  }
  
  public BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketPolicy(String bucketName, String policyText)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucketPolicy(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketPolicy(new DeleteBucketPolicyRequest(bucketName));
  }
  
  public void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public URL generatePresignedUrl(String bucketName, String key, Date expiration)
    throws SdkClientException
  {
    return generatePresignedUrl(bucketName, key, expiration, HttpMethod.GET);
  }
  
  public URL generatePresignedUrl(String bucketName, String key, Date expiration, HttpMethod method)
    throws SdkClientException
  {
    GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, key, method);
    request.setExpiration(expiration);
    
    return generatePresignedUrl(request);
  }
  
  public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest)
    throws SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public UploadPartResult uploadPart(UploadPartRequest request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public PartListing listParts(ListPartsRequest request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void abortMultipartUpload(AbortMultipartUploadRequest request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest request)
    throws SdkClientException, AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void restoreObject(String bucketName, String key, int expirationInDays)
    throws AmazonServiceException
  {
    restoreObject(new RestoreObjectRequest(bucketName, key, expirationInDays));
  }
  
  public void restoreObject(RestoreObjectRequest request)
    throws AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public RestoreObjectResult restoreObjectV2(RestoreObjectRequest request)
    throws AmazonServiceException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void enableRequesterPays(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void disableRequesterPays(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public boolean isRequesterPaysEnabled(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketReplicationConfiguration(String bucketName, BucketReplicationConfiguration configuration)
    throws AmazonServiceException, SdkClientException
  {
    setBucketReplicationConfiguration(new SetBucketReplicationConfigurationRequest(bucketName, configuration));
  }
  
  public void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest setBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketReplicationConfiguration getBucketReplicationConfiguration(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketReplicationConfiguration(new GetBucketReplicationConfigurationRequest(bucketName));
  }
  
  public BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest getBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void deleteBucketReplicationConfiguration(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    deleteBucketReplicationConfiguration(new DeleteBucketReplicationConfigurationRequest(bucketName));
  }
  
  public void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest request)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public boolean doesObjectExist(String bucketName, String objectName)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public BucketAccelerateConfiguration getBucketAccelerateConfiguration(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketAccelerateConfiguration(new GetBucketAccelerateConfigurationRequest(bucketName));
  }
  
  public BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void setBucketAccelerateConfiguration(String bucketName, BucketAccelerateConfiguration accelerateConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    setBucketAccelerateConfiguration(new SetBucketAccelerateConfigurationRequest(bucketName, accelerateConfiguration));
  }
  
  public void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest setBucketAccelerateConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return deleteBucketMetricsConfiguration(new DeleteBucketMetricsConfigurationRequest(bucketName, id));
  }
  
  public DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketMetricsConfiguration(new GetBucketMetricsConfigurationRequest(bucketName, id));
  }
  
  public GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(String bucketName, MetricsConfiguration metricsConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    return setBucketMetricsConfiguration(new SetBucketMetricsConfigurationRequest(bucketName, metricsConfiguration));
  }
  
  public SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(SetBucketMetricsConfigurationRequest setBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ListBucketMetricsConfigurationsResult listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return deleteBucketAnalyticsConfiguration(new DeleteBucketAnalyticsConfigurationRequest(bucketName, id));
  }
  
  public DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketAnalyticsConfiguration(new GetBucketAnalyticsConfigurationRequest(bucketName, id));
  }
  
  public GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(String bucketName, AnalyticsConfiguration analyticsConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    return setBucketAnalyticsConfiguration(new SetBucketAnalyticsConfigurationRequest(bucketName, analyticsConfiguration));
  }
  
  public SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(SetBucketAnalyticsConfigurationRequest setBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ListBucketAnalyticsConfigurationsResult listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return deleteBucketInventoryConfiguration(new DeleteBucketInventoryConfigurationRequest(bucketName, id));
  }
  
  public DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketInventoryConfiguration(new GetBucketInventoryConfigurationRequest(bucketName, id));
  }
  
  public GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(String bucketName, InventoryConfiguration inventoryConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    return setBucketInventoryConfiguration(new SetBucketInventoryConfigurationRequest(bucketName, inventoryConfiguration));
  }
  
  public SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(SetBucketInventoryConfigurationRequest setBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public ListBucketInventoryConfigurationsResult listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeleteBucketEncryptionResult deleteBucketEncryption(String bucketName)
    throws SdkClientException
  {
    return deleteBucketEncryption(new DeleteBucketEncryptionRequest().withBucketName(bucketName));
  }
  
  public DeleteBucketEncryptionResult deleteBucketEncryption(DeleteBucketEncryptionRequest request)
    throws SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetBucketEncryptionResult getBucketEncryption(String bucketName)
    throws SdkClientException
  {
    return getBucketEncryption(new GetBucketEncryptionRequest().withBucketName(bucketName));
  }
  
  public GetBucketEncryptionResult getBucketEncryption(GetBucketEncryptionRequest request)
    throws SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetBucketEncryptionResult setBucketEncryption(SetBucketEncryptionRequest request)
    throws SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetPublicAccessBlockResult setPublicAccessBlock(SetPublicAccessBlockRequest request)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetPublicAccessBlockResult getPublicAccessBlock(GetPublicAccessBlockRequest request)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public DeletePublicAccessBlockResult deletePublicAccessBlock(DeletePublicAccessBlockRequest request)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetBucketPolicyStatusResult getBucketPolicyStatus(GetBucketPolicyStatusRequest request)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SelectObjectContentResult selectObjectContent(SelectObjectContentRequest selectRequest)
    throws AmazonServiceException, SdkClientException
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetObjectLegalHoldResult setObjectLegalHold(SetObjectLegalHoldRequest setObjectLegalHoldRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetObjectLegalHoldResult getObjectLegalHold(GetObjectLegalHoldRequest getObjectLegalHoldRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetObjectLockConfigurationResult setObjectLockConfiguration(SetObjectLockConfigurationRequest setObjectLockConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetObjectLockConfigurationResult getObjectLockConfiguration(GetObjectLockConfigurationRequest getObjectLockConfigurationRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public SetObjectRetentionResult setObjectRetention(SetObjectRetentionRequest setObjectRetentionRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public GetObjectRetentionResult getObjectRetention(GetObjectRetentionRequest getObjectRetentionRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public PresignedUrlDownloadResult download(PresignedUrlDownloadRequest presignedUrlDownloadRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void download(PresignedUrlDownloadRequest presignedUrlDownloadRequest, File destinationFile)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public PresignedUrlUploadResult upload(PresignedUrlUploadRequest presignedUrlUploadRequest)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region getRegion()
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public String getRegionName()
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public URL getUrl(String bucketName, String key)
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
  
  public AmazonS3Waiters waiters()
  {
    throw new UnsupportedOperationException("Extend AbstractAmazonS3 to provide an implementation");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AbstractAmazonS3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */