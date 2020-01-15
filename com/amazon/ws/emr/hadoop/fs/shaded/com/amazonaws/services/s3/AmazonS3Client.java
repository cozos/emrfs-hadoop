package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException.ErrorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.HttpMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResetException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Presigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.AmazonWebServiceRequestAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DefaultServiceEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.IdentityEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ReleasableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ResettableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ServiceEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.NoOpSignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.AWSS3V4Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.Constants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectTaggingHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DigestValidationInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DualstackEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.GetObjectTaggingResponseHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.HeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.InitiateMultipartUploadHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.InputSubstream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ListPartsHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.MD5DigestCalculatingInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.Mimetypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.MultiFileOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3AbortableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3ErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3ObjectResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3QueryStringSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequestEndpointResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RestoreOutputPathHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3StringResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3V4AuthErrorRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3VersionHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3XmlResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SetObjectTaggingResponseHeaderHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SkipMd5CheckStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.UploadObjectStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.auth.S3SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.metrics.S3ServiceMetric;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GenericBucketRequest;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetRequestPaymentConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetS3AccountOwnerRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grantee;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiFactorAuthentication;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectTagging;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Permission;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PublicAccessBlockConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration.Payer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreRequestType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3AccelerateUnsupported;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3DataSource;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3DataSource.Utils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAwsKeyManagementParamsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSECustomerKeyProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionConfiguration;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetRequestPaymentConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StorageClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.AclXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketNotificationConfigurationStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.GetBucketEncryptionStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.GetBucketPolicyStatusStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.GetPublicAccessBlockStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.HeadBucketResultHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.MultiObjectDeleteXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectLockConfigurationXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectLockLegalHoldXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectLockRetentionXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectTaggingXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.RequestPaymentConfigurationXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.RequestXmlFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.AccessControlListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketAccelerateConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketCrossOriginConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLifecycleConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLocationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLoggingConfigurationnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketReplicationConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketTaggingConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketVersioningConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketWebsiteConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.CompleteMultipartUploadResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.CopyObjectUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteBucketAnalyticsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteBucketEncryptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteBucketInventoryConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteBucketMetricsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteObjectTaggingResponseUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteObjectsResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeletePublicAccessBlockUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetBucketAnalyticsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetBucketInventoryConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetBucketMetricsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetObjectLegalHoldResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetObjectLockConfigurationResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetObjectRetentionResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetObjectTaggingResponseUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.InitiateMultipartUploadResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketAnalyticsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketInventoryConfigurationsUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketMetricsConfigurationsUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketsOwnerUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketsUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListMultipartUploadsResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListObjectsUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListObjectsV2Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListPartsResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.RequestPaymentConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.RestoreObjectResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetBucketAnalyticsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetBucketEncryptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetBucketInventoryConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetBucketMetricsConfigurationUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetObjectLegalHoldResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetObjectLockConfigurationResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetObjectRetentionResultUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetObjectTaggingResponseUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.SetPublicAccessBlockUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.VersionListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.CompleteMultipartUploadHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.CopyObjectResultHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.request.S3HandlerContextKeys;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters.AmazonS3Waiters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base16;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.LengthCheckInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Md5Utils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.RuntimeHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ServiceClientHolderInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentType;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ThreadSafe
public class AmazonS3Client
  extends AmazonWebServiceClient
  implements AmazonS3
{
  public static final String S3_SERVICE_NAME = "s3";
  private static final String S3_SIGNER = "S3SignerType";
  private static final String S3_V4_SIGNER = "AWSS3V4SignerType";
  private static final String SERVICE_ID = "S3";
  protected static final AmazonS3ClientConfigurationFactory configFactory = new AmazonS3ClientConfigurationFactory();
  private static Log log = LogFactory.getLog(AmazonS3Client.class);
  private volatile AmazonS3Waiters waiters;
  protected final AWSCredentialsProvider awsCredentialsProvider;
  
  static
  {
    AwsSdkMetrics.addAll(Arrays.asList(S3ServiceMetric.values()));
    
    SignerFactory.registerSigner("S3SignerType", S3Signer.class);
    SignerFactory.registerSigner("AWSS3V4SignerType", AWSS3V4Signer.class);
  }
  
  protected final S3ErrorResponseHandler errorResponseHandler = new S3ErrorResponseHandler();
  private final S3XmlResponseHandler<Void> voidResponseHandler = new S3XmlResponseHandler(null);
  private static final BucketConfigurationXmlFactory bucketConfigurationXmlFactory = new BucketConfigurationXmlFactory();
  private static final RequestPaymentConfigurationXmlFactory requestPaymentConfigurationXmlFactory = new RequestPaymentConfigurationXmlFactory();
  private volatile S3ClientOptions clientOptions = S3ClientOptions.builder().build();
  private volatile String clientRegion;
  private static final int BUCKET_REGION_CACHE_SIZE = 300;
  private static final Map<String, String> bucketRegionCache = Collections.synchronizedMap(new LinkedHashMap(300, 1.1F, true)
  {
    private static final long serialVersionUID = 23453L;
    
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest)
    {
      return size() > 300;
    }
  });
  private final SkipMd5CheckStrategy skipMd5CheckStrategy;
  
  static Map<String, String> getBucketRegionCache()
  {
    return bucketRegionCache;
  }
  
  private final CompleteMultipartUploadRetryCondition completeMultipartUploadRetryCondition = new CompleteMultipartUploadRetryCondition();
  
  @Deprecated
  public AmazonS3Client()
  {
    this(new S3CredentialsProviderChain());
  }
  
  @Deprecated
  public AmazonS3Client(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonS3Client(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    this(new StaticCredentialsProvider(awsCredentials), clientConfiguration);
  }
  
  @Deprecated
  public AmazonS3Client(AWSCredentialsProvider credentialsProvider)
  {
    this(credentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonS3Client(AWSCredentialsProvider credentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(credentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonS3Client(AWSCredentialsProvider credentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    this(credentialsProvider, clientConfiguration, requestMetricCollector, SkipMd5CheckStrategy.INSTANCE);
  }
  
  @SdkTestInternalApi
  AmazonS3Client(AWSCredentialsProvider credentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector, SkipMd5CheckStrategy skipMd5CheckStrategy)
  {
    super(clientConfiguration, requestMetricCollector, true);
    awsCredentialsProvider = credentialsProvider;
    this.skipMd5CheckStrategy = skipMd5CheckStrategy;
    init();
  }
  
  @Deprecated
  public AmazonS3Client(ClientConfiguration clientConfiguration)
  {
    this(new S3CredentialsProviderChain(), clientConfiguration);
  }
  
  @SdkInternalApi
  AmazonS3Client(AmazonS3ClientParams s3ClientParams)
  {
    super(s3ClientParams.getClientParams());
    awsCredentialsProvider = s3ClientParams.getClientParams().getCredentialsProvider();
    skipMd5CheckStrategy = SkipMd5CheckStrategy.INSTANCE;
    setS3ClientOptions(s3ClientParams.getS3ClientOptions());
    init();
  }
  
  public static AmazonS3ClientBuilder builder()
  {
    return AmazonS3ClientBuilder.standard();
  }
  
  private void init()
  {
    setEndpoint("s3.amazonaws.com");
    
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/request.handlers"));
    
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/request.handler2s"));
    
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  @Deprecated
  public synchronized void setEndpoint(String endpoint)
  {
    if (ServiceUtils.isS3AccelerateEndpoint(endpoint)) {
      throw new IllegalStateException("To enable accelerate mode, please use AmazonS3ClientBuilder.withAccelerateModeEnabled(true)");
    }
    super.setEndpoint(endpoint);
    if (!ServiceUtils.isS3USStandardEndpoint(endpoint)) {
      clientRegion = AwsHostNameUtils.parseRegionName(this.endpoint.getHost(), "s3");
    }
  }
  
  @Deprecated
  public synchronized void setRegion(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region region)
  {
    super.setRegion(region);
    
    clientRegion = region.getName();
  }
  
  public synchronized void setS3ClientOptions(S3ClientOptions clientOptions)
  {
    checkMutability();
    this.clientOptions = new S3ClientOptions(clientOptions);
  }
  
  protected boolean useStrictHostNameVerification()
  {
    return false;
  }
  
  public VersionListing listNextBatchOfVersions(VersionListing previousVersionListing)
    throws SdkClientException, AmazonServiceException
  {
    return listNextBatchOfVersions(new ListNextBatchOfVersionsRequest(previousVersionListing));
  }
  
  public VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest listNextBatchOfVersionsRequest)
  {
    listNextBatchOfVersionsRequest = (ListNextBatchOfVersionsRequest)beforeClientExecution(listNextBatchOfVersionsRequest);
    rejectNull(listNextBatchOfVersionsRequest, "The request object parameter must be specified when listing the next batch of versions in a bucket");
    
    VersionListing previousVersionListing = listNextBatchOfVersionsRequest.getPreviousVersionListing();
    if (!previousVersionListing.isTruncated())
    {
      VersionListing emptyListing = new VersionListing();
      emptyListing.setBucketName(previousVersionListing.getBucketName());
      emptyListing.setDelimiter(previousVersionListing.getDelimiter());
      emptyListing.setKeyMarker(previousVersionListing.getNextKeyMarker());
      emptyListing.setVersionIdMarker(previousVersionListing.getNextVersionIdMarker());
      emptyListing.setMaxKeys(previousVersionListing.getMaxKeys());
      emptyListing.setPrefix(previousVersionListing.getPrefix());
      emptyListing.setEncodingType(previousVersionListing.getEncodingType());
      emptyListing.setTruncated(false);
      
      return emptyListing;
    }
    return listVersions(listNextBatchOfVersionsRequest.toListVersionsRequest());
  }
  
  public VersionListing listVersions(String bucketName, String prefix)
    throws SdkClientException, AmazonServiceException
  {
    return listVersions(new ListVersionsRequest(bucketName, prefix, null, null, null, null));
  }
  
  public VersionListing listVersions(String bucketName, String prefix, String keyMarker, String versionIdMarker, String delimiter, Integer maxKeys)
    throws SdkClientException, AmazonServiceException
  {
    ListVersionsRequest request = new ListVersionsRequest().withBucketName(bucketName).withPrefix(prefix).withDelimiter(delimiter).withKeyMarker(keyMarker).withVersionIdMarker(versionIdMarker).withMaxResults(maxKeys);
    return listVersions(request);
  }
  
  public VersionListing listVersions(ListVersionsRequest listVersionsRequest)
    throws SdkClientException, AmazonServiceException
  {
    listVersionsRequest = (ListVersionsRequest)beforeClientExecution(listVersionsRequest);
    rejectNull(listVersionsRequest.getBucketName(), "The bucket name parameter must be specified when listing versions in a bucket");
    
    boolean shouldSDKDecodeResponse = listVersionsRequest.getEncodingType() == null;
    
    Request<ListVersionsRequest> request = createRequest(listVersionsRequest.getBucketName(), null, listVersionsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListObjectVersions");
    request.addParameter("versions", null);
    
    addParameterIfNotNull(request, "prefix", listVersionsRequest.getPrefix());
    addParameterIfNotNull(request, "key-marker", listVersionsRequest.getKeyMarker());
    addParameterIfNotNull(request, "version-id-marker", listVersionsRequest.getVersionIdMarker());
    addParameterIfNotNull(request, "delimiter", listVersionsRequest.getDelimiter());
    if ((listVersionsRequest.getMaxResults() != null) && (listVersionsRequest.getMaxResults().intValue() >= 0)) {
      request.addParameter("max-keys", listVersionsRequest.getMaxResults().toString());
    }
    request.addParameter("encoding-type", shouldSDKDecodeResponse ? "url" : listVersionsRequest.getEncodingType());
    
    return (VersionListing)invoke(request, new Unmarshallers.VersionListUnmarshaller(shouldSDKDecodeResponse), listVersionsRequest.getBucketName(), null);
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
    listObjectsRequest = (ListObjectsRequest)beforeClientExecution(listObjectsRequest);
    rejectNull(listObjectsRequest.getBucketName(), "The bucket name parameter must be specified when listing objects in a bucket");
    
    boolean shouldSDKDecodeResponse = listObjectsRequest.getEncodingType() == null;
    
    Request<ListObjectsRequest> request = createRequest(listObjectsRequest.getBucketName(), null, listObjectsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListObjects");
    addParameterIfNotNull(request, "prefix", listObjectsRequest.getPrefix());
    addParameterIfNotNull(request, "marker", listObjectsRequest.getMarker());
    addParameterIfNotNull(request, "delimiter", listObjectsRequest.getDelimiter());
    if ((listObjectsRequest.getMaxKeys() != null) && (listObjectsRequest.getMaxKeys().intValue() >= 0)) {
      request.addParameter("max-keys", listObjectsRequest.getMaxKeys().toString());
    }
    request.addParameter("encoding-type", shouldSDKDecodeResponse ? "url" : listObjectsRequest.getEncodingType());
    
    populateRequesterPaysHeader(request, listObjectsRequest.isRequesterPays());
    
    return (ObjectListing)invoke(request, new Unmarshallers.ListObjectsUnmarshaller(shouldSDKDecodeResponse), listObjectsRequest.getBucketName(), null);
  }
  
  public ListObjectsV2Result listObjectsV2(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return listObjectsV2(new ListObjectsV2Request().withBucketName(bucketName));
  }
  
  public ListObjectsV2Result listObjectsV2(String bucketName, String prefix)
    throws SdkClientException, AmazonServiceException
  {
    return listObjectsV2(new ListObjectsV2Request().withBucketName(bucketName).withPrefix(prefix));
  }
  
  public ListObjectsV2Result listObjectsV2(ListObjectsV2Request listObjectsV2Request)
    throws SdkClientException, AmazonServiceException
  {
    listObjectsV2Request = (ListObjectsV2Request)beforeClientExecution(listObjectsV2Request);
    rejectNull(listObjectsV2Request.getBucketName(), "The bucket name parameter must be specified when listing objects in a bucket");
    Request<ListObjectsV2Request> request = createRequest(listObjectsV2Request.getBucketName(), null, listObjectsV2Request, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListObjectsV2");
    
    request.addParameter("list-type", "2");
    
    addParameterIfNotNull(request, "start-after", listObjectsV2Request.getStartAfter());
    addParameterIfNotNull(request, "continuation-token", listObjectsV2Request.getContinuationToken());
    addParameterIfNotNull(request, "delimiter", listObjectsV2Request.getDelimiter());
    addParameterIfNotNull(request, "max-keys", listObjectsV2Request.getMaxKeys());
    addParameterIfNotNull(request, "prefix", listObjectsV2Request.getPrefix());
    addParameterIfNotNull(request, "encoding-type", listObjectsV2Request.getEncodingType());
    request.addParameter("fetch-owner", Boolean.toString(listObjectsV2Request.isFetchOwner()));
    
    populateRequesterPaysHeader(request, listObjectsV2Request.isRequesterPays());
    
    boolean shouldSDKDecodeResponse = "url".equals(listObjectsV2Request.getEncodingType());
    
    return (ListObjectsV2Result)invoke(request, new Unmarshallers.ListObjectsV2Unmarshaller(shouldSDKDecodeResponse), listObjectsV2Request.getBucketName(), null);
  }
  
  public ObjectListing listNextBatchOfObjects(ObjectListing previousObjectListing)
    throws SdkClientException, AmazonServiceException
  {
    return listNextBatchOfObjects(new ListNextBatchOfObjectsRequest(previousObjectListing));
  }
  
  public ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest listNextBatchOfObjectsRequest)
    throws SdkClientException, AmazonServiceException
  {
    listNextBatchOfObjectsRequest = (ListNextBatchOfObjectsRequest)beforeClientExecution(listNextBatchOfObjectsRequest);
    rejectNull(listNextBatchOfObjectsRequest, "The request object parameter must be specified when listing the next batch of objects in a bucket");
    
    ObjectListing previousObjectListing = listNextBatchOfObjectsRequest.getPreviousObjectListing();
    if (!previousObjectListing.isTruncated())
    {
      ObjectListing emptyListing = new ObjectListing();
      emptyListing.setBucketName(previousObjectListing.getBucketName());
      emptyListing.setDelimiter(previousObjectListing.getDelimiter());
      emptyListing.setMarker(previousObjectListing.getNextMarker());
      emptyListing.setMaxKeys(previousObjectListing.getMaxKeys());
      emptyListing.setPrefix(previousObjectListing.getPrefix());
      emptyListing.setEncodingType(previousObjectListing.getEncodingType());
      emptyListing.setTruncated(false);
      
      return emptyListing;
    }
    return listObjects(listNextBatchOfObjectsRequest.toListObjectsRequest());
  }
  
  public Owner getS3AccountOwner()
    throws SdkClientException, AmazonServiceException
  {
    return getS3AccountOwner(new GetS3AccountOwnerRequest());
  }
  
  public Owner getS3AccountOwner(GetS3AccountOwnerRequest getS3AccountOwnerRequest)
    throws SdkClientException, AmazonServiceException
  {
    getS3AccountOwnerRequest = (GetS3AccountOwnerRequest)beforeClientExecution(getS3AccountOwnerRequest);
    rejectNull(getS3AccountOwnerRequest, "The request object parameter getS3AccountOwnerRequest must be specified.");
    Request<GetS3AccountOwnerRequest> request = createRequest(null, null, getS3AccountOwnerRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBuckets");
    return (Owner)invoke(request, new Unmarshallers.ListBucketsOwnerUnmarshaller(), null, null);
  }
  
  public List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest)
    throws SdkClientException, AmazonServiceException
  {
    listBucketsRequest = (ListBucketsRequest)beforeClientExecution(listBucketsRequest);
    rejectNull(listBucketsRequest, "The request object parameter listBucketsRequest must be specified.");
    Request<ListBucketsRequest> request = createRequest(null, null, listBucketsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBuckets");
    return (List)invoke(request, new Unmarshallers.ListBucketsUnmarshaller(), null, null);
  }
  
  public List<Bucket> listBuckets()
    throws SdkClientException, AmazonServiceException
  {
    return listBuckets(new ListBucketsRequest());
  }
  
  public String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketLocationRequest = (GetBucketLocationRequest)beforeClientExecution(getBucketLocationRequest);
    rejectNull(getBucketLocationRequest, "The request parameter must be specified when requesting a bucket's location");
    String bucketName = getBucketLocationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's location");
    
    Request<GetBucketLocationRequest> request = createRequest(bucketName, null, getBucketLocationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketLocation");
    request.addParameter("location", null);
    
    return (String)invoke(request, new Unmarshallers.BucketLocationUnmarshaller(), bucketName, null);
  }
  
  public String getBucketLocation(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketLocation(new GetBucketLocationRequest(bucketName));
  }
  
  public Bucket createBucket(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return createBucket(new CreateBucketRequest(bucketName));
  }
  
  @Deprecated
  public Bucket createBucket(String bucketName, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region region)
    throws SdkClientException, AmazonServiceException
  {
    return createBucket(new CreateBucketRequest(bucketName, region));
  }
  
  @Deprecated
  public Bucket createBucket(String bucketName, String region)
    throws SdkClientException, AmazonServiceException
  {
    return createBucket(new CreateBucketRequest(bucketName, region));
  }
  
  public Bucket createBucket(CreateBucketRequest createBucketRequest)
    throws SdkClientException, AmazonServiceException
  {
    createBucketRequest = (CreateBucketRequest)beforeClientExecution(createBucketRequest);
    rejectNull(createBucketRequest, "The CreateBucketRequest parameter must be specified when creating a bucket");
    
    String bucketName = createBucketRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when creating a bucket");
    bucketName = bucketName.trim();
    
    String requestRegion = createBucketRequest.getRegion();
    URI requestEndpoint = getCreateBucketEndpoint(requestRegion);
    
    BucketNameUtils.validateBucketName(bucketName);
    
    Request<CreateBucketRequest> request = createRequest(bucketName, null, createBucketRequest, HttpMethodName.PUT, requestEndpoint);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateBucket");
    if (createBucketRequest.getAccessControlList() != null) {
      addAclHeaders(request, createBucketRequest.getAccessControlList());
    } else if (createBucketRequest.getCannedAcl() != null) {
      request.addHeader("x-amz-acl", createBucketRequest.getCannedAcl().toString());
    }
    if ((getSignerRegion() != null) && (!getSignerRegion().equals("us-east-1")) && (StringUtils.isNullOrEmpty(requestRegion))) {
      requestRegion = AwsHostNameUtils.parseRegion(requestEndpoint.getHost(), "s3");
    }
    if ((requestRegion != null) && (!StringUtils.upperCase(requestRegion).equals(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region.US_Standard.toString())))
    {
      XmlWriter xml = new XmlWriter();
      xml.start("CreateBucketConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
      xml.start("LocationConstraint").value(requestRegion).end();
      xml.end();
      
      request.setContent(new ByteArrayInputStream(xml.getBytes()));
    }
    if (createBucketRequest.getObjectLockEnabledForBucket()) {
      request.addHeader("x-amz-bucket-object-lock-enabled", "true");
    }
    invoke(request, voidResponseHandler, bucketName, null);
    
    return new Bucket(bucketName);
  }
  
  private URI getCreateBucketEndpoint(String requestRegion)
  {
    if ((requestRegion == null) || (requestRegion.equals(clientRegion)) || (!clientOptions.isForceGlobalBucketAccessEnabled())) {
      return endpoint;
    }
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region targetRegion = com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region.getRegion(Regions.fromName(requestRegion));
    return new DefaultServiceEndpointBuilder(getEndpointPrefix(), clientConfiguration
      .getProtocol().toString()).withRegion(targetRegion)
      .getServiceEndpoint();
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
  {
    getObjectAclRequest = (GetObjectAclRequest)beforeClientExecution(getObjectAclRequest);
    rejectNull(getObjectAclRequest, "The request parameter must be specified when requesting an object's ACL");
    rejectNull(getObjectAclRequest.getBucketName(), "The bucket name parameter must be specified when requesting an object's ACL");
    rejectNull(getObjectAclRequest.getKey(), "The key parameter must be specified when requesting an object's ACL");
    
    return getAcl(getObjectAclRequest.getBucketName(), getObjectAclRequest.getKey(), getObjectAclRequest
      .getVersionId(), getObjectAclRequest.isRequesterPays(), getObjectAclRequest);
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
  
  public void setObjectAcl(String bucketName, String key, String versionId, AccessControlList acl, RequestMetricCollector requestMetricCollector)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAcl(
      (SetObjectAclRequest)new SetObjectAclRequest(bucketName, key, versionId, acl).withRequestMetricCollector(requestMetricCollector));
  }
  
  public void setObjectAcl(String bucketName, String key, String versionId, CannedAccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAcl(new SetObjectAclRequest(bucketName, key, versionId, acl));
  }
  
  public void setObjectAcl(String bucketName, String key, String versionId, CannedAccessControlList acl, RequestMetricCollector requestMetricCollector)
  {
    setObjectAcl(
      (SetObjectAclRequest)new SetObjectAclRequest(bucketName, key, versionId, acl).withRequestMetricCollector(requestMetricCollector));
  }
  
  public void setObjectAcl(SetObjectAclRequest setObjectAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    setObjectAclRequest = (SetObjectAclRequest)beforeClientExecution(setObjectAclRequest);
    rejectNull(setObjectAclRequest, "The request must not be null.");
    
    rejectNull(setObjectAclRequest.getBucketName(), "The bucket name parameter must be specified when setting an object's ACL");
    
    rejectNull(setObjectAclRequest.getKey(), "The key parameter must be specified when setting an object's ACL");
    if ((setObjectAclRequest.getAcl() != null) && (setObjectAclRequest.getCannedAcl() != null)) {
      throw new IllegalArgumentException("Only one of the ACL and CannedACL parameters can be specified, not both.");
    }
    if (setObjectAclRequest.getAcl() != null) {
      setAcl(setObjectAclRequest.getBucketName(), setObjectAclRequest
        .getKey(), setObjectAclRequest
        .getVersionId(), setObjectAclRequest
        .getAcl(), setObjectAclRequest
        .isRequesterPays(), setObjectAclRequest);
    } else if (setObjectAclRequest.getCannedAcl() != null) {
      setAcl(setObjectAclRequest.getBucketName(), setObjectAclRequest
        .getKey(), setObjectAclRequest
        .getVersionId(), setObjectAclRequest
        .getCannedAcl(), setObjectAclRequest
        .isRequesterPays(), setObjectAclRequest);
    } else {
      throw new IllegalArgumentException("At least one of the ACL and CannedACL parameters should be specified");
    }
  }
  
  public AccessControlList getBucketAcl(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketAcl(new GetBucketAclRequest(bucketName));
  }
  
  public AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketAclRequest = (GetBucketAclRequest)beforeClientExecution(getBucketAclRequest);
    String bucketName = getBucketAclRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's ACL");
    
    return getAcl(bucketName, null, null, false, getBucketAclRequest);
  }
  
  public void setBucketAcl(String bucketName, AccessControlList acl)
    throws SdkClientException, AmazonServiceException
  {
    setBucketAcl(new SetBucketAclRequest(bucketName, acl));
  }
  
  public void setBucketAcl(String bucketName, AccessControlList acl, RequestMetricCollector requestMetricCollector)
  {
    SetBucketAclRequest request = (SetBucketAclRequest)new SetBucketAclRequest(bucketName, acl).withRequestMetricCollector(requestMetricCollector);
    setBucketAcl(request);
  }
  
  public void setBucketAcl(String bucketName, CannedAccessControlList cannedAcl)
    throws SdkClientException, AmazonServiceException
  {
    setBucketAcl(new SetBucketAclRequest(bucketName, cannedAcl));
  }
  
  public void setBucketAcl(String bucketName, CannedAccessControlList cannedAcl, RequestMetricCollector requestMetricCollector)
    throws SdkClientException, AmazonServiceException
  {
    SetBucketAclRequest request = (SetBucketAclRequest)new SetBucketAclRequest(bucketName, cannedAcl).withRequestMetricCollector(requestMetricCollector);
    setBucketAcl(request);
  }
  
  public void setBucketAcl(SetBucketAclRequest setBucketAclRequest)
    throws SdkClientException, AmazonServiceException
  {
    setBucketAclRequest = (SetBucketAclRequest)beforeClientExecution(setBucketAclRequest);
    
    String bucketName = setBucketAclRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when setting a bucket's ACL");
    
    AccessControlList acl = setBucketAclRequest.getAcl();
    CannedAccessControlList cannedAcl = setBucketAclRequest.getCannedAcl();
    if ((acl == null) && (cannedAcl == null)) {
      throw new IllegalArgumentException("The ACL parameter must be specified when setting a bucket's ACL");
    }
    if ((acl != null) && (cannedAcl != null)) {
      throw new IllegalArgumentException("Only one of the acl and cannedAcl parameter can be specified, not both.");
    }
    if (acl != null) {
      setAcl(bucketName, null, null, acl, false, setBucketAclRequest);
    } else {
      setAcl(bucketName, null, null, cannedAcl, false, setBucketAclRequest);
    }
  }
  
  public ObjectMetadata getObjectMetadata(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    return getObjectMetadata(new GetObjectMetadataRequest(bucketName, key));
  }
  
  public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest)
    throws SdkClientException, AmazonServiceException
  {
    getObjectMetadataRequest = (GetObjectMetadataRequest)beforeClientExecution(getObjectMetadataRequest);
    rejectNull(getObjectMetadataRequest, "The GetObjectMetadataRequest parameter must be specified when requesting an object's metadata");
    
    String bucketName = getObjectMetadataRequest.getBucketName();
    String key = getObjectMetadataRequest.getKey();
    String versionId = getObjectMetadataRequest.getVersionId();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when requesting an object's metadata");
    rejectNull(key, "The key parameter must be specified when requesting an object's metadata");
    
    Request<GetObjectMetadataRequest> request = createRequest(bucketName, key, getObjectMetadataRequest, HttpMethodName.HEAD);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "HeadObject");
    if (versionId != null) {
      request.addParameter("versionId", versionId);
    }
    populateRequesterPaysHeader(request, getObjectMetadataRequest.isRequesterPays());
    addPartNumberIfNotNull(request, getObjectMetadataRequest.getPartNumber());
    
    populateSSE_C(request, getObjectMetadataRequest.getSSECustomerKey());
    
    return (ObjectMetadata)invoke(request, new S3MetadataResponseHandler(), bucketName, key);
  }
  
  public S3Object getObject(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    return getObject(new GetObjectRequest(bucketName, key));
  }
  
  public boolean doesBucketExist(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    try
    {
      ValidationUtils.assertStringNotEmpty(bucketName, "bucketName");
      headBucket(new HeadBucketRequest(bucketName));
      return true;
    }
    catch (AmazonServiceException ase)
    {
      if ((ase.getStatusCode() == 301) || 
        (ase.getStatusCode() == 403)) {
        return true;
      }
      if (ase.getStatusCode() == 404) {
        return false;
      }
      throw ase;
    }
  }
  
  public boolean doesBucketExistV2(String bucketName)
    throws SdkClientException
  {
    try
    {
      ValidationUtils.assertStringNotEmpty(bucketName, "bucketName");
      getBucketAcl(bucketName);
      return true;
    }
    catch (AmazonServiceException ase)
    {
      if ((ase.getStatusCode() == 301) || ("AccessDenied".equals(ase.getErrorCode()))) {
        return true;
      }
      if (ase.getStatusCode() == 404) {
        return false;
      }
      throw ase;
    }
  }
  
  public boolean doesObjectExist(String bucketName, String objectName)
    throws AmazonServiceException, SdkClientException
  {
    try
    {
      ValidationUtils.assertStringNotEmpty(bucketName, "bucketName");
      ValidationUtils.assertStringNotEmpty(objectName, "objectName");
      getObjectMetadata(bucketName, objectName);
      return true;
    }
    catch (AmazonS3Exception e)
    {
      if (e.getStatusCode() == 404) {
        return false;
      }
      throw e;
    }
  }
  
  public HeadBucketResult headBucket(HeadBucketRequest headBucketRequest)
    throws SdkClientException, AmazonServiceException
  {
    headBucketRequest = (HeadBucketRequest)beforeClientExecution(headBucketRequest);
    String bucketName = headBucketRequest.getBucketName();
    
    rejectNull(bucketName, "The bucketName parameter must be specified.");
    
    Request<HeadBucketRequest> request = createRequest(bucketName, null, headBucketRequest, HttpMethodName.HEAD);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "HeadBucket");
    
    return (HeadBucketResult)invoke(request, new HeadBucketResultHandler(), bucketName, null);
  }
  
  public void changeObjectStorageClass(String bucketName, String key, StorageClass newStorageClass)
    throws SdkClientException, AmazonServiceException
  {
    rejectNull(bucketName, "The bucketName parameter must be specified when changing an object's storage class");
    
    rejectNull(key, "The key parameter must be specified when changing an object's storage class");
    
    rejectNull(newStorageClass, "The newStorageClass parameter must be specified when changing an object's storage class");
    
    copyObject(new CopyObjectRequest(bucketName, key, bucketName, key)
      .withStorageClass(newStorageClass.toString()));
  }
  
  public void setObjectRedirectLocation(String bucketName, String key, String newRedirectLocation)
    throws SdkClientException, AmazonServiceException
  {
    rejectNull(bucketName, "The bucketName parameter must be specified when changing an object's storage class");
    
    rejectNull(key, "The key parameter must be specified when changing an object's storage class");
    
    rejectNull(newRedirectLocation, "The newStorageClass parameter must be specified when changing an object's storage class");
    
    copyObject(new CopyObjectRequest(bucketName, key, bucketName, key)
      .withRedirectLocation(newRedirectLocation));
  }
  
  public S3Object getObject(GetObjectRequest getObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    getObjectRequest = (GetObjectRequest)beforeClientExecution(getObjectRequest);
    ValidationUtils.assertNotNull(getObjectRequest, "GetObjectRequest");
    ValidationUtils.assertStringNotEmpty(getObjectRequest.getBucketName(), "BucketName");
    ValidationUtils.assertStringNotEmpty(getObjectRequest.getKey(), "Key");
    
    Request<GetObjectRequest> request = createRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey(), getObjectRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObject");
    if (getObjectRequest.getVersionId() != null) {
      request.addParameter("versionId", getObjectRequest.getVersionId());
    }
    addPartNumberIfNotNull(request, getObjectRequest.getPartNumber());
    
    long[] range = getObjectRequest.getRange();
    if (range != null) {
      request.addHeader("Range", "bytes=" + Long.toString(range[0]) + "-" + Long.toString(range[1]));
    }
    populateRequesterPaysHeader(request, getObjectRequest.isRequesterPays());
    
    addResponseHeaderParameters(request, getObjectRequest.getResponseHeaders());
    
    addDateHeader(request, "If-Modified-Since", getObjectRequest
      .getModifiedSinceConstraint());
    addDateHeader(request, "If-Unmodified-Since", getObjectRequest
      .getUnmodifiedSinceConstraint());
    addStringListHeader(request, "If-Match", getObjectRequest
      .getMatchingETagConstraints());
    addStringListHeader(request, "If-None-Match", getObjectRequest
      .getNonmatchingETagConstraints());
    
    populateSSE_C(request, getObjectRequest.getSSECustomerKey());
    ProgressListener listener = getObjectRequest.getGeneralProgressListener();
    SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_STARTED_EVENT);
    try
    {
      S3Object s3Object = (S3Object)invoke(request, new S3ObjectResponseHandler(), getObjectRequest
        .getBucketName(), getObjectRequest.getKey());
      
      s3Object.setBucketName(getObjectRequest.getBucketName());
      s3Object.setKey(getObjectRequest.getKey());
      
      boolean skipClientSideValidation = skipMd5CheckStrategy.skipClientSideValidation(getObjectRequest, s3Object
        .getObjectMetadata());
      postProcessS3Object(s3Object, skipClientSideValidation, listener);
      return s3Object;
    }
    catch (AmazonS3Exception ase)
    {
      if ((ase.getStatusCode() == 412) || (ase.getStatusCode() == 304))
      {
        SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_CANCELED_EVENT);
        return null;
      }
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
      throw ase;
    }
  }
  
  private void postProcessS3Object(S3Object s3Object, boolean skipClientSideValidation, ProgressListener listener)
  {
    InputStream is = s3Object.getObjectContent();
    HttpRequestBase httpRequest = s3Object.getObjectContent().getHttpRequest();
    
    is = new ServiceClientHolderInputStream(is, this);
    
    ProgressInputStream progressInputStream = new ProgressInputStream(is, listener)
    {
      protected void onEOF()
      {
        SDKProgressPublisher.publishProgress(getListener(), ProgressEventType.TRANSFER_COMPLETED_EVENT);
      }
    };
    is = progressInputStream;
    if (!skipClientSideValidation)
    {
      byte[] serverSideHash = BinaryUtils.fromHex(s3Object.getObjectMetadata().getETag());
      try
      {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        is = new DigestValidationInputStream(is, digest, serverSideHash);
      }
      catch (NoSuchAlgorithmException e)
      {
        log.warn("No MD5 digest algorithm available.  Unable to calculate checksum and verify data integrity.", e);
      }
    }
    else
    {
      is = new LengthCheckInputStream(is, s3Object.getObjectMetadata().getContentLength(), true);
    }
    S3AbortableInputStream abortableInputStream = new S3AbortableInputStream(is, httpRequest, s3Object.getObjectMetadata().getContentLength());
    s3Object.setObjectContent(new S3ObjectInputStream(abortableInputStream, httpRequest, false));
  }
  
  public ObjectMetadata getObject(final GetObjectRequest getObjectRequest, File destinationFile)
    throws SdkClientException, AmazonServiceException
  {
    rejectNull(destinationFile, "The destination file parameter must be specified when downloading an object directly to a file");
    
    S3Object s3Object = ServiceUtils.retryableDownloadS3ObjectToFile(destinationFile, new ServiceUtils.RetryableS3DownloadTask()
    {
      public S3Object getS3ObjectStream()
      {
        return getObject(getObjectRequest);
      }
      
      public boolean needIntegrityCheck()
      {
        return !skipMd5CheckStrategy.skipClientSideValidationPerRequest(getObjectRequest);
      }
    }, false);
    if (s3Object == null) {
      return null;
    }
    return s3Object.getObjectMetadata();
  }
  
  public String getObjectAsString(String bucketName, String key)
    throws AmazonServiceException, SdkClientException
  {
    rejectNull(bucketName, "Bucket name must be provided");
    rejectNull(key, "Object key must be provided");
    
    S3Object object = getObject(bucketName, key);
    try
    {
      return IOUtils.toString(object.getObjectContent());
    }
    catch (IOException e)
    {
      throw new SdkClientException("Error streaming content from S3 during download", e);
    }
    finally
    {
      IOUtils.closeQuietly(object, log);
    }
  }
  
  public GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest)
  {
    getObjectTaggingRequest = (GetObjectTaggingRequest)beforeClientExecution(getObjectTaggingRequest);
    rejectNull(getObjectTaggingRequest, "The request parameter must be specified when getting the object tags");
    
    String bucketName = ValidationUtils.assertStringNotEmpty(getObjectTaggingRequest.getBucketName(), "BucketName");
    String key = (String)ValidationUtils.assertNotNull(getObjectTaggingRequest.getKey(), "Key");
    
    Request<GetObjectTaggingRequest> request = createRequest(bucketName, key, getObjectTaggingRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObjectTagging");
    request.addParameter("tagging", null);
    addParameterIfNotNull(request, "versionId", getObjectTaggingRequest.getVersionId());
    
    ResponseHeaderHandlerChain<GetObjectTaggingResult> handlerChain = new ResponseHeaderHandlerChain(new Unmarshallers.GetObjectTaggingResponseUnmarshaller(), new HeaderHandler[] { new GetObjectTaggingResponseHeaderHandler() });
    
    return (GetObjectTaggingResult)invoke(request, handlerChain, bucketName, key);
  }
  
  public SetObjectTaggingResult setObjectTagging(SetObjectTaggingRequest setObjectTaggingRequest)
  {
    setObjectTaggingRequest = (SetObjectTaggingRequest)beforeClientExecution(setObjectTaggingRequest);
    rejectNull(setObjectTaggingRequest, "The request parameter must be specified setting the object tags");
    
    String bucketName = ValidationUtils.assertStringNotEmpty(setObjectTaggingRequest.getBucketName(), "BucketName");
    String key = (String)ValidationUtils.assertNotNull(setObjectTaggingRequest.getKey(), "Key");
    ObjectTagging tagging = (ObjectTagging)ValidationUtils.assertNotNull(setObjectTaggingRequest.getTagging(), "ObjectTagging");
    
    Request<SetObjectTaggingRequest> request = createRequest(bucketName, key, setObjectTaggingRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObjectTagging");
    request.addParameter("tagging", null);
    addParameterIfNotNull(request, "versionId", setObjectTaggingRequest.getVersionId());
    byte[] content = new ObjectTaggingXmlFactory().convertToXmlByteArray(tagging);
    setContent(request, content, "application/xml", true);
    
    ResponseHeaderHandlerChain<SetObjectTaggingResult> handlerChain = new ResponseHeaderHandlerChain(new Unmarshallers.SetObjectTaggingResponseUnmarshaller(), new HeaderHandler[] { new SetObjectTaggingResponseHeaderHandler() });
    
    return (SetObjectTaggingResult)invoke(request, handlerChain, bucketName, key);
  }
  
  public DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest)
  {
    deleteObjectTaggingRequest = (DeleteObjectTaggingRequest)beforeClientExecution(deleteObjectTaggingRequest);
    rejectNull(deleteObjectTaggingRequest, "The request parameter must be specified when delete the object tags");
    String bucketName = ValidationUtils.assertStringNotEmpty(deleteObjectTaggingRequest.getBucketName(), "BucketName");
    String key = ValidationUtils.assertStringNotEmpty(deleteObjectTaggingRequest.getKey(), "Key");
    
    Request<DeleteObjectTaggingRequest> request = createRequest(bucketName, key, deleteObjectTaggingRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteObjectTagging");
    request.addParameter("tagging", null);
    addParameterIfNotNull(request, "versionId", deleteObjectTaggingRequest.getVersionId());
    
    ResponseHeaderHandlerChain<DeleteObjectTaggingResult> handlerChain = new ResponseHeaderHandlerChain(new Unmarshallers.DeleteObjectTaggingResponseUnmarshaller(), new HeaderHandler[] { new DeleteObjectTaggingHeaderHandler() });
    
    return (DeleteObjectTaggingResult)invoke(request, handlerChain, bucketName, key);
  }
  
  public void deleteBucket(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucket(new DeleteBucketRequest(bucketName));
  }
  
  public void deleteBucket(DeleteBucketRequest deleteBucketRequest)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketRequest = (DeleteBucketRequest)beforeClientExecution(deleteBucketRequest);
    rejectNull(deleteBucketRequest, "The DeleteBucketRequest parameter must be specified when deleting a bucket");
    
    String bucketName = deleteBucketRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting a bucket");
    
    Request<DeleteBucketRequest> request = createRequest(bucketName, null, deleteBucketRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucket");
    invoke(request, voidResponseHandler, bucketName, null);
    bucketRegionCache.remove(bucketName);
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
    putObjectRequest = (PutObjectRequest)beforeClientExecution(putObjectRequest);
    rejectNull(putObjectRequest, "The PutObjectRequest parameter must be specified when uploading an object");
    File file = putObjectRequest.getFile();
    InputStream isOrig = putObjectRequest.getInputStream();
    String bucketName = putObjectRequest.getBucketName();
    String key = putObjectRequest.getKey();
    ProgressListener listener = putObjectRequest.getGeneralProgressListener();
    rejectNull(bucketName, "The bucket name parameter must be specified when uploading an object");
    rejectNull(key, "The key parameter must be specified when uploading an object");
    
    ObjectMetadata metadata = putObjectRequest.getMetadata();
    if (metadata == null) {
      metadata = new ObjectMetadata();
    }
    Request<PutObjectRequest> request = createRequest(bucketName, key, putObjectRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObject");
    request.addHandlerContext(HandlerContextKey.REQUIRES_LENGTH, Boolean.TRUE);
    request.addHandlerContext(HandlerContextKey.HAS_STREAMING_INPUT, Boolean.TRUE);
    
    Integer bufsize = Constants.getS3StreamBufferSize();
    if (bufsize != null)
    {
      AmazonWebServiceRequest awsreq = request.getOriginalRequest();
      
      awsreq.getRequestClientOptions()
        .setReadLimit(bufsize.intValue());
    }
    if (putObjectRequest.getAccessControlList() != null) {
      addAclHeaders(request, putObjectRequest.getAccessControlList());
    } else if (putObjectRequest.getCannedAcl() != null) {
      request.addHeader("x-amz-acl", putObjectRequest.getCannedAcl().toString());
    }
    if (putObjectRequest.getStorageClass() != null) {
      request.addHeader("x-amz-storage-class", putObjectRequest.getStorageClass());
    }
    if (putObjectRequest.getRedirectLocation() != null) {
      request.addHeader("x-amz-website-redirect-location", putObjectRequest.getRedirectLocation());
    }
    addHeaderIfNotNull(request, "x-amz-tagging", urlEncodeTags(putObjectRequest.getTagging()));
    
    populateRequesterPaysHeader(request, putObjectRequest.isRequesterPays());
    
    populateSSE_C(request, putObjectRequest.getSSECustomerKey());
    
    populateSSE_KMS(request, putObjectRequest
      .getSSEAwsKeyManagementParams());
    
    populateObjectLockHeaders(request, putObjectRequest.getObjectLockMode(), putObjectRequest.getObjectLockRetainUntilDate(), putObjectRequest
      .getObjectLockLegalHoldStatus());
    
    return (PutObjectResult)uploadObject(isOrig, file, metadata, listener, request, putObjectRequest, skipMd5CheckStrategy
      .skipServerSideValidation(putObjectRequest), skipMd5CheckStrategy
      .skipClientSideValidationPerRequest(putObjectRequest), new PutObjectStrategy(bucketName, key, null), true);
  }
  
  private <RequestT, ResponseT> ResponseT uploadObject(InputStream originalStream, File file, ObjectMetadata metadata, ProgressListener listener, Request<RequestT> request, S3DataSource originalRequest, boolean skipServerSideValidation, boolean skipClientSideValidationPerRequest, UploadObjectStrategy<RequestT, ResponseT> uploadStrategy, boolean setContentTypeIfNotProvided)
  {
    InputStream input = getInputStream(originalStream, file, metadata, request, skipServerSideValidation, setContentTypeIfNotProvided);
    
    MD5DigestCalculatingInputStream md5DigestStream = null;
    try
    {
      if ((metadata.getContentMD5() == null) && (!skipClientSideValidationPerRequest)) {
        input = md5DigestStream = new MD5DigestCalculatingInputStream(input);
      }
      populateRequestMetadata(request, metadata);
      request.setContent(input);
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_STARTED_EVENT);
      try
      {
        returnedMetadata = uploadStrategy.invokeServiceCall(request);
      }
      catch (Throwable t)
      {
        ObjectMetadata returnedMetadata;
        SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
        throw Throwables.failure(t);
      }
    }
    finally
    {
      ObjectMetadata returnedMetadata;
      S3DataSource.Utils.cleanupDataSource(originalRequest, file, originalStream, input, log);
    }
    ObjectMetadata returnedMetadata;
    String contentMd5 = metadata.getContentMD5();
    if (md5DigestStream != null) {
      contentMd5 = Base64.encodeAsString(md5DigestStream.getMd5Digest());
    }
    String etag = returnedMetadata.getETag();
    if ((contentMd5 != null) && (!skipMd5CheckStrategy.skipClientSideValidationPerPutResponse(returnedMetadata)))
    {
      byte[] clientSideHash = BinaryUtils.fromBase64(contentMd5);
      byte[] serverSideHash = BinaryUtils.fromHex(etag);
      if (!Arrays.equals(clientSideHash, serverSideHash))
      {
        SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
        
        throw new SdkClientException("Unable to verify integrity of data upload. Client calculated content hash (contentMD5: " + contentMd5 + " in base 64) didn't match hash (etag: " + etag + " in hex) calculated by Amazon S3.  You may need to delete the data stored in Amazon S3. (metadata.contentMD5: " + metadata.getContentMD5() + ", md5DigestStream: " + md5DigestStream + uploadStrategy.md5ValidationErrorSuffix() + ")");
      }
    }
    SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_COMPLETED_EVENT);
    
    return (ResponseT)uploadStrategy.createResult(returnedMetadata, contentMd5);
  }
  
  private InputStream getInputStream(InputStream origStream, File file, ObjectMetadata metadata, Request<?> request, boolean skipServerSideValidation, boolean setContentTypeIfNotProvided)
  {
    InputStream input = origStream;
    if (file == null)
    {
      if (input != null) {
        input = ReleasableInputStream.wrap(input);
      }
    }
    else
    {
      metadata.setContentLength(file.length());
      boolean calculateMD5 = metadata.getContentMD5() == null;
      if ((metadata.getContentType() == null) && (setContentTypeIfNotProvided)) {
        metadata.setContentType(Mimetypes.getInstance().getMimetype(file));
      }
      if ((calculateMD5) && (!skipServerSideValidation)) {
        try
        {
          String contentMd5_b64 = Md5Utils.md5AsBase64(file);
          metadata.setContentMD5(contentMd5_b64);
        }
        catch (Exception e)
        {
          throw new SdkClientException("Unable to calculate MD5 hash: " + e.getMessage(), e);
        }
      }
      input = ResettableInputStream.newResettableInputStream(file, "Unable to find file to upload");
    }
    if ((metadata.getContentType() == null) && (setContentTypeIfNotProvided)) {
      metadata.setContentType("application/octet-stream");
    }
    if ((request.getHeaders().get("x-amz-website-redirect-location") != null) && (input == null)) {
      input = new ByteArrayInputStream(new byte[0]);
    }
    Long contentLength = (Long)metadata.getRawMetadataValue("Content-Length");
    if (contentLength == null)
    {
      log.warn("No content length specified for stream data.  Stream contents will be buffered in memory and could result in out of memory errors.");
    }
    else
    {
      long expectedLength = contentLength.longValue();
      if (expectedLength >= 0L)
      {
        LengthCheckInputStream lcis = new LengthCheckInputStream(input, expectedLength, false);
        
        input = lcis;
      }
    }
    return input;
  }
  
  private static PutObjectResult createPutObjectResult(ObjectMetadata metadata)
  {
    PutObjectResult result = new PutObjectResult();
    result.setVersionId(metadata.getVersionId());
    result.setSSEAlgorithm(metadata.getSSEAlgorithm());
    result.setSSECustomerAlgorithm(metadata.getSSECustomerAlgorithm());
    result.setSSECustomerKeyMd5(metadata.getSSECustomerKeyMd5());
    result.setExpirationTime(metadata.getExpirationTime());
    result.setExpirationTimeRuleId(metadata.getExpirationTimeRuleId());
    result.setETag(metadata.getETag());
    result.setMetadata(metadata);
    result.setRequesterCharged(metadata.isRequesterCharged());
    return result;
  }
  
  private static void addAclHeaders(Request<? extends AmazonWebServiceRequest> request, AccessControlList acl)
  {
    List<Grant> grants = acl.getGrantsAsList();
    Map<Permission, Collection<Grantee>> grantsByPermission = new HashMap();
    for (Object localObject = grants.iterator(); ((Iterator)localObject).hasNext();)
    {
      grant = (Grant)((Iterator)localObject).next();
      if (!grantsByPermission.containsKey(grant.getPermission())) {
        grantsByPermission.put(grant.getPermission(), new LinkedList());
      }
      ((Collection)grantsByPermission.get(grant.getPermission())).add(grant.getGrantee());
    }
    localObject = Permission.values();Grant grant = localObject.length;
    for (Grant localGrant1 = 0; localGrant1 < grant; localGrant1++)
    {
      Permission permission = localObject[localGrant1];
      if (grantsByPermission.containsKey(permission))
      {
        Collection<Grantee> grantees = (Collection)grantsByPermission.get(permission);
        boolean seenOne = false;
        StringBuilder granteeString = new StringBuilder();
        for (Grantee grantee : grantees)
        {
          if (!seenOne) {
            seenOne = true;
          } else {
            granteeString.append(", ");
          }
          granteeString.append(grantee.getTypeIdentifier()).append("=").append("\"").append(grantee.getIdentifier()).append("\"");
        }
        request.addHeader(permission.getHeaderName(), granteeString.toString());
      }
    }
  }
  
  public CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey)
    throws SdkClientException, AmazonServiceException
  {
    return copyObject(new CopyObjectRequest(sourceBucketName, sourceKey, destinationBucketName, destinationKey));
  }
  
  public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    copyObjectRequest = (CopyObjectRequest)beforeClientExecution(copyObjectRequest);
    rejectNull(copyObjectRequest.getSourceBucketName(), "The source bucket name must be specified when copying an object");
    
    rejectNull(copyObjectRequest.getSourceKey(), "The source object key must be specified when copying an object");
    
    rejectNull(copyObjectRequest.getDestinationBucketName(), "The destination bucket name must be specified when copying an object");
    
    rejectNull(copyObjectRequest.getDestinationKey(), "The destination object key must be specified when copying an object");
    
    String destinationKey = copyObjectRequest.getDestinationKey();
    String destinationBucketName = copyObjectRequest.getDestinationBucketName();
    
    Request<CopyObjectRequest> request = createRequest(destinationBucketName, destinationKey, copyObjectRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CopyObject");
    
    populateRequestWithCopyObjectParameters(request, copyObjectRequest);
    
    populateSSE_KMS(request, copyObjectRequest
      .getSSEAwsKeyManagementParams());
    
    populateObjectLockHeaders(request, copyObjectRequest.getObjectLockMode(), copyObjectRequest.getObjectLockRetainUntilDate(), copyObjectRequest
      .getObjectLockLegalHoldStatus());
    
    setZeroContentLength(request);
    XmlResponsesSaxParser.CopyObjectResultHandler copyObjectResultHandler = null;
    try
    {
      ResponseHeaderHandlerChain<XmlResponsesSaxParser.CopyObjectResultHandler> handler = new ResponseHeaderHandlerChain(new Unmarshallers.CopyObjectUnmarshaller(), new HeaderHandler[] { new ServerSideEncryptionHeaderHandler(), new S3VersionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3RequesterChargedHeaderHandler() });
      
      copyObjectResultHandler = (XmlResponsesSaxParser.CopyObjectResultHandler)invoke(request, handler, destinationBucketName, destinationKey);
    }
    catch (AmazonS3Exception ase)
    {
      if (ase.getStatusCode() == 412) {
        return null;
      }
      throw ase;
    }
    if (copyObjectResultHandler.getErrorCode() != null)
    {
      String errorCode = copyObjectResultHandler.getErrorCode();
      String errorMessage = copyObjectResultHandler.getErrorMessage();
      String requestId = copyObjectResultHandler.getErrorRequestId();
      String hostId = copyObjectResultHandler.getErrorHostId();
      
      AmazonS3Exception ase = new AmazonS3Exception(errorMessage);
      ase.setErrorCode(errorCode);
      ase.setErrorType(AmazonServiceException.ErrorType.Service);
      ase.setRequestId(requestId);
      ase.setExtendedRequestId(hostId);
      ase.setServiceName(request.getServiceName());
      ase.setStatusCode(200);
      
      throw ase;
    }
    CopyObjectResult copyObjectResult = new CopyObjectResult();
    copyObjectResult.setETag(copyObjectResultHandler.getETag());
    copyObjectResult.setLastModifiedDate(copyObjectResultHandler.getLastModified());
    copyObjectResult.setVersionId(copyObjectResultHandler.getVersionId());
    copyObjectResult.setSSEAlgorithm(copyObjectResultHandler.getSSEAlgorithm());
    copyObjectResult.setSSECustomerAlgorithm(copyObjectResultHandler.getSSECustomerAlgorithm());
    copyObjectResult.setSSECustomerKeyMd5(copyObjectResultHandler.getSSECustomerKeyMd5());
    copyObjectResult.setExpirationTime(copyObjectResultHandler.getExpirationTime());
    copyObjectResult.setExpirationTimeRuleId(copyObjectResultHandler.getExpirationTimeRuleId());
    copyObjectResult.setRequesterCharged(copyObjectResultHandler.isRequesterCharged());
    
    return copyObjectResult;
  }
  
  public CopyPartResult copyPart(CopyPartRequest copyPartRequest)
  {
    copyPartRequest = (CopyPartRequest)beforeClientExecution(copyPartRequest);
    rejectNull(copyPartRequest.getSourceBucketName(), "The source bucket name must be specified when copying a part");
    
    rejectNull(copyPartRequest.getSourceKey(), "The source object key must be specified when copying a part");
    
    rejectNull(copyPartRequest.getDestinationBucketName(), "The destination bucket name must be specified when copying a part");
    
    rejectNull(copyPartRequest.getUploadId(), "The upload id must be specified when copying a part");
    
    rejectNull(copyPartRequest.getDestinationKey(), "The destination object key must be specified when copying a part");
    
    rejectNull(Integer.valueOf(copyPartRequest.getPartNumber()), "The part number must be specified when copying a part");
    
    String destinationKey = copyPartRequest.getDestinationKey();
    String destinationBucketName = copyPartRequest.getDestinationBucketName();
    
    Request<CopyPartRequest> request = createRequest(destinationBucketName, destinationKey, copyPartRequest, HttpMethodName.PUT);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UploadPartCopy");
    
    populateRequestWithCopyPartParameters(request, copyPartRequest);
    
    request.addParameter("uploadId", copyPartRequest.getUploadId());
    request.addParameter("partNumber", Integer.toString(copyPartRequest.getPartNumber()));
    
    populateRequesterPaysHeader(request, copyPartRequest.isRequesterPays());
    
    setZeroContentLength(request);
    XmlResponsesSaxParser.CopyObjectResultHandler copyObjectResultHandler = null;
    try
    {
      ResponseHeaderHandlerChain<XmlResponsesSaxParser.CopyObjectResultHandler> handler = new ResponseHeaderHandlerChain(new Unmarshallers.CopyObjectUnmarshaller(), new HeaderHandler[] { new ServerSideEncryptionHeaderHandler(), new S3VersionHeaderHandler() });
      
      copyObjectResultHandler = (XmlResponsesSaxParser.CopyObjectResultHandler)invoke(request, handler, destinationBucketName, destinationKey);
    }
    catch (AmazonS3Exception ase)
    {
      if (ase.getStatusCode() == 412) {
        return null;
      }
      throw ase;
    }
    if (copyObjectResultHandler.getErrorCode() != null)
    {
      String errorCode = copyObjectResultHandler.getErrorCode();
      String errorMessage = copyObjectResultHandler.getErrorMessage();
      String requestId = copyObjectResultHandler.getErrorRequestId();
      String hostId = copyObjectResultHandler.getErrorHostId();
      
      AmazonS3Exception ase = new AmazonS3Exception(errorMessage);
      ase.setErrorCode(errorCode);
      ase.setErrorType(AmazonServiceException.ErrorType.Service);
      ase.setRequestId(requestId);
      ase.setExtendedRequestId(hostId);
      ase.setServiceName(request.getServiceName());
      ase.setStatusCode(200);
      
      throw ase;
    }
    CopyPartResult copyPartResult = new CopyPartResult();
    copyPartResult.setETag(copyObjectResultHandler.getETag());
    copyPartResult.setPartNumber(copyPartRequest.getPartNumber());
    copyPartResult.setLastModifiedDate(copyObjectResultHandler.getLastModified());
    copyPartResult.setVersionId(copyObjectResultHandler.getVersionId());
    copyPartResult.setSSEAlgorithm(copyObjectResultHandler.getSSEAlgorithm());
    copyPartResult.setSSECustomerAlgorithm(copyObjectResultHandler.getSSECustomerAlgorithm());
    copyPartResult.setSSECustomerKeyMd5(copyObjectResultHandler.getSSECustomerKeyMd5());
    
    return copyPartResult;
  }
  
  public void deleteObject(String bucketName, String key)
    throws SdkClientException, AmazonServiceException
  {
    deleteObject(new DeleteObjectRequest(bucketName, key));
  }
  
  public void deleteObject(DeleteObjectRequest deleteObjectRequest)
    throws SdkClientException, AmazonServiceException
  {
    deleteObjectRequest = (DeleteObjectRequest)beforeClientExecution(deleteObjectRequest);
    rejectNull(deleteObjectRequest, "The delete object request must be specified when deleting an object");
    
    rejectNull(deleteObjectRequest.getBucketName(), "The bucket name must be specified when deleting an object");
    rejectNull(deleteObjectRequest.getKey(), "The key must be specified when deleting an object");
    
    Request<DeleteObjectRequest> request = createRequest(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey(), deleteObjectRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteObject");
    
    invoke(request, voidResponseHandler, deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey());
  }
  
  public DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest)
  {
    deleteObjectsRequest = (DeleteObjectsRequest)beforeClientExecution(deleteObjectsRequest);
    Request<DeleteObjectsRequest> request = createRequest(deleteObjectsRequest.getBucketName(), null, deleteObjectsRequest, HttpMethodName.POST);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteObjects");
    request.addParameter("delete", null);
    if (deleteObjectsRequest.getBypassGovernanceRetention()) {
      request.addHeader("x-amz-bypass-governance-retention", "true");
    }
    if (deleteObjectsRequest.getMfa() != null) {
      populateRequestWithMfaDetails(request, deleteObjectsRequest.getMfa());
    }
    populateRequesterPaysHeader(request, deleteObjectsRequest.isRequesterPays());
    
    byte[] content = new MultiObjectDeleteXmlFactory().convertToXmlByteArray(deleteObjectsRequest);
    request.addHeader("Content-Length", String.valueOf(content.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(content));
    try
    {
      byte[] md5 = Md5Utils.computeMD5Hash(content);
      String md5Base64 = BinaryUtils.toBase64(md5);
      request.addHeader("Content-MD5", md5Base64);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Couldn't compute md5 sum", e);
    }
    ResponseHeaderHandlerChain<DeleteObjectsResponse> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.DeleteObjectsResultUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler() });
    
    DeleteObjectsResponse response = (DeleteObjectsResponse)invoke(request, responseHandler, deleteObjectsRequest.getBucketName(), null);
    if (!response.getErrors().isEmpty())
    {
      Map<String, String> headers = responseHandler.getResponseHeaders();
      
      MultiObjectDeleteException ex = new MultiObjectDeleteException(response.getErrors(), response.getDeletedObjects());
      
      ex.setStatusCode(200);
      ex.setRequestId((String)headers.get("x-amz-request-id"));
      ex.setExtendedRequestId((String)headers.get("x-amz-id-2"));
      ex.setCloudFrontId((String)headers.get("X-Amz-Cf-Id"));
      
      throw ex;
    }
    DeleteObjectsResult result = new DeleteObjectsResult(response.getDeletedObjects(), response.isRequesterCharged());
    
    return result;
  }
  
  public void deleteVersion(String bucketName, String key, String versionId)
    throws SdkClientException, AmazonServiceException
  {
    deleteVersion(new DeleteVersionRequest(bucketName, key, versionId));
  }
  
  public void deleteVersion(DeleteVersionRequest deleteVersionRequest)
    throws SdkClientException, AmazonServiceException
  {
    deleteVersionRequest = (DeleteVersionRequest)beforeClientExecution(deleteVersionRequest);
    rejectNull(deleteVersionRequest, "The delete version request object must be specified when deleting a version");
    
    String bucketName = deleteVersionRequest.getBucketName();
    String key = deleteVersionRequest.getKey();
    String versionId = deleteVersionRequest.getVersionId();
    
    rejectNull(bucketName, "The bucket name must be specified when deleting a version");
    rejectNull(key, "The key must be specified when deleting a version");
    rejectNull(versionId, "The version ID must be specified when deleting a version");
    
    Request<DeleteVersionRequest> request = createRequest(bucketName, key, deleteVersionRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteObject");
    if (versionId != null) {
      request.addParameter("versionId", versionId);
    }
    if (deleteVersionRequest.getMfa() != null) {
      populateRequestWithMfaDetails(request, deleteVersionRequest.getMfa());
    }
    if (deleteVersionRequest.getBypassGovernanceRetention()) {
      request.addHeader("x-amz-bypass-governance-retention", "true");
    }
    invoke(request, voidResponseHandler, bucketName, key);
  }
  
  public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    setBucketVersioningConfigurationRequest = (SetBucketVersioningConfigurationRequest)beforeClientExecution(setBucketVersioningConfigurationRequest);
    rejectNull(setBucketVersioningConfigurationRequest, "The SetBucketVersioningConfigurationRequest object must be specified when setting versioning configuration");
    
    String bucketName = setBucketVersioningConfigurationRequest.getBucketName();
    BucketVersioningConfiguration versioningConfiguration = setBucketVersioningConfigurationRequest.getVersioningConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting versioning configuration");
    
    rejectNull(versioningConfiguration, "The bucket versioning parameter must be specified when setting versioning configuration");
    if (versioningConfiguration.isMfaDeleteEnabled() != null) {
      rejectNull(setBucketVersioningConfigurationRequest.getMfa(), "The MFA parameter must be specified when changing MFA Delete status in the versioning configuration");
    }
    Request<SetBucketVersioningConfigurationRequest> request = createRequest(bucketName, null, setBucketVersioningConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketVersioning");
    request.addParameter("versioning", null);
    if ((versioningConfiguration.isMfaDeleteEnabled() != null) && 
      (setBucketVersioningConfigurationRequest.getMfa() != null)) {
      populateRequestWithMfaDetails(request, setBucketVersioningConfigurationRequest.getMfa());
    }
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(versioningConfiguration);
    request.setContent(new ByteArrayInputStream(bytes));
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketVersioningConfiguration getBucketVersioningConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketVersioningConfiguration(new GetBucketVersioningConfigurationRequest(bucketName));
  }
  
  public BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest getBucketVersioningConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketVersioningConfigurationRequest = (GetBucketVersioningConfigurationRequest)beforeClientExecution(getBucketVersioningConfigurationRequest);
    rejectNull(getBucketVersioningConfigurationRequest, "The request object parameter getBucketVersioningConfigurationRequest must be specified.");
    String bucketName = getBucketVersioningConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when querying versioning configuration");
    
    Request<GetBucketVersioningConfigurationRequest> request = createRequest(bucketName, null, getBucketVersioningConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketVersioning");
    request.addParameter("versioning", null);
    
    return (BucketVersioningConfiguration)invoke(request, new Unmarshallers.BucketVersioningConfigurationUnmarshaller(), bucketName, null);
  }
  
  public BucketWebsiteConfiguration getBucketWebsiteConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketWebsiteConfiguration(new GetBucketWebsiteConfigurationRequest(bucketName));
  }
  
  public BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketWebsiteConfigurationRequest = (GetBucketWebsiteConfigurationRequest)beforeClientExecution(getBucketWebsiteConfigurationRequest);
    rejectNull(getBucketWebsiteConfigurationRequest, "The request object parameter getBucketWebsiteConfigurationRequest must be specified.");
    String bucketName = getBucketWebsiteConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's website configuration");
    
    Request<GetBucketWebsiteConfigurationRequest> request = createRequest(bucketName, null, getBucketWebsiteConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketWebsite");
    request.addParameter("website", null);
    request.addHeader("Content-Type", "application/xml");
    try
    {
      return (BucketWebsiteConfiguration)invoke(request, new Unmarshallers.BucketWebsiteConfigurationUnmarshaller(), bucketName, null);
    }
    catch (AmazonServiceException ase)
    {
      if (ase.getStatusCode() == 404) {
        return null;
      }
      throw ase;
    }
  }
  
  public BucketLifecycleConfiguration getBucketLifecycleConfiguration(String bucketName)
  {
    return getBucketLifecycleConfiguration(new GetBucketLifecycleConfigurationRequest(bucketName));
  }
  
  public BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest)
  {
    getBucketLifecycleConfigurationRequest = (GetBucketLifecycleConfigurationRequest)beforeClientExecution(getBucketLifecycleConfigurationRequest);
    rejectNull(getBucketLifecycleConfigurationRequest, "The request object pamameter getBucketLifecycleConfigurationRequest must be specified.");
    String bucketName = getBucketLifecycleConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name must be specifed when retrieving the bucket lifecycle configuration.");
    
    Request<GetBucketLifecycleConfigurationRequest> request = createRequest(bucketName, null, getBucketLifecycleConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketLifecycleConfiguration");
    request.addParameter("lifecycle", null);
    try
    {
      return (BucketLifecycleConfiguration)invoke(request, new Unmarshallers.BucketLifecycleConfigurationUnmarshaller(), bucketName, null);
    }
    catch (AmazonServiceException ase)
    {
      switch (ase.getStatusCode())
      {
      case 404: 
        return null;
      }
    }
    throw ase;
  }
  
  public void setBucketLifecycleConfiguration(String bucketName, BucketLifecycleConfiguration bucketLifecycleConfiguration)
  {
    setBucketLifecycleConfiguration(new SetBucketLifecycleConfigurationRequest(bucketName, bucketLifecycleConfiguration));
  }
  
  public void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest)
  {
    setBucketLifecycleConfigurationRequest = (SetBucketLifecycleConfigurationRequest)beforeClientExecution(setBucketLifecycleConfigurationRequest);
    rejectNull(setBucketLifecycleConfigurationRequest, "The set bucket lifecycle configuration request object must be specified.");
    
    String bucketName = setBucketLifecycleConfigurationRequest.getBucketName();
    BucketLifecycleConfiguration bucketLifecycleConfiguration = setBucketLifecycleConfigurationRequest.getLifecycleConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting bucket lifecycle configuration.");
    
    rejectNull(bucketLifecycleConfiguration, "The lifecycle configuration parameter must be specified when setting bucket lifecycle configuration.");
    
    Request<SetBucketLifecycleConfigurationRequest> request = createRequest(bucketName, null, setBucketLifecycleConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketLifecycleConfiguration");
    request.addParameter("lifecycle", null);
    
    byte[] content = new BucketConfigurationXmlFactory().convertToXmlByteArray(bucketLifecycleConfiguration);
    request.addHeader("Content-Length", String.valueOf(content.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(content));
    try
    {
      byte[] md5 = Md5Utils.computeMD5Hash(content);
      String md5Base64 = BinaryUtils.toBase64(md5);
      request.addHeader("Content-MD5", md5Base64);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Couldn't compute md5 sum", e);
    }
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void deleteBucketLifecycleConfiguration(String bucketName)
  {
    deleteBucketLifecycleConfiguration(new DeleteBucketLifecycleConfigurationRequest(bucketName));
  }
  
  public void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest)
  {
    deleteBucketLifecycleConfigurationRequest = (DeleteBucketLifecycleConfigurationRequest)beforeClientExecution(deleteBucketLifecycleConfigurationRequest);
    rejectNull(deleteBucketLifecycleConfigurationRequest, "The delete bucket lifecycle configuration request object must be specified.");
    
    String bucketName = deleteBucketLifecycleConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting bucket lifecycle configuration.");
    
    Request<DeleteBucketLifecycleConfigurationRequest> request = createRequest(bucketName, null, deleteBucketLifecycleConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketLifecycle");
    request.addParameter("lifecycle", null);
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String bucketName)
  {
    return getBucketCrossOriginConfiguration(new GetBucketCrossOriginConfigurationRequest(bucketName));
  }
  
  public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest getBucketCrossOriginConfigurationRequest)
  {
    getBucketCrossOriginConfigurationRequest = (GetBucketCrossOriginConfigurationRequest)beforeClientExecution(getBucketCrossOriginConfigurationRequest);
    rejectNull(getBucketCrossOriginConfigurationRequest, "The request object parameter getBucketCrossOriginConfigurationRequest must be specified.");
    String bucketName = getBucketCrossOriginConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name must be specified when retrieving the bucket cross origin configuration.");
    
    Request<GetBucketCrossOriginConfigurationRequest> request = createRequest(bucketName, null, getBucketCrossOriginConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketCors");
    request.addParameter("cors", null);
    try
    {
      return (BucketCrossOriginConfiguration)invoke(request, new Unmarshallers.BucketCrossOriginConfigurationUnmarshaller(), bucketName, null);
    }
    catch (AmazonServiceException ase)
    {
      switch (ase.getStatusCode())
      {
      case 404: 
        return null;
      }
    }
    throw ase;
  }
  
  public void setBucketCrossOriginConfiguration(String bucketName, BucketCrossOriginConfiguration bucketCrossOriginConfiguration)
  {
    setBucketCrossOriginConfiguration(new SetBucketCrossOriginConfigurationRequest(bucketName, bucketCrossOriginConfiguration));
  }
  
  public void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest)
  {
    setBucketCrossOriginConfigurationRequest = (SetBucketCrossOriginConfigurationRequest)beforeClientExecution(setBucketCrossOriginConfigurationRequest);
    rejectNull(setBucketCrossOriginConfigurationRequest, "The set bucket cross origin configuration request object must be specified.");
    
    String bucketName = setBucketCrossOriginConfigurationRequest.getBucketName();
    BucketCrossOriginConfiguration bucketCrossOriginConfiguration = setBucketCrossOriginConfigurationRequest.getCrossOriginConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting bucket cross origin configuration.");
    
    rejectNull(bucketCrossOriginConfiguration, "The cross origin configuration parameter must be specified when setting bucket cross origin configuration.");
    
    Request<SetBucketCrossOriginConfigurationRequest> request = createRequest(bucketName, null, setBucketCrossOriginConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketCors");
    request.addParameter("cors", null);
    
    byte[] content = new BucketConfigurationXmlFactory().convertToXmlByteArray(bucketCrossOriginConfiguration);
    request.addHeader("Content-Length", String.valueOf(content.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(content));
    try
    {
      byte[] md5 = Md5Utils.computeMD5Hash(content);
      String md5Base64 = BinaryUtils.toBase64(md5);
      request.addHeader("Content-MD5", md5Base64);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Couldn't compute md5 sum", e);
    }
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void deleteBucketCrossOriginConfiguration(String bucketName)
  {
    deleteBucketCrossOriginConfiguration(new DeleteBucketCrossOriginConfigurationRequest(bucketName));
  }
  
  public void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest)
  {
    deleteBucketCrossOriginConfigurationRequest = (DeleteBucketCrossOriginConfigurationRequest)beforeClientExecution(deleteBucketCrossOriginConfigurationRequest);
    rejectNull(deleteBucketCrossOriginConfigurationRequest, "The delete bucket cross origin configuration request object must be specified.");
    
    String bucketName = deleteBucketCrossOriginConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting bucket cross origin configuration.");
    
    Request<DeleteBucketCrossOriginConfigurationRequest> request = createRequest(bucketName, null, deleteBucketCrossOriginConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketCors");
    request.addParameter("cors", null);
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketTaggingConfiguration getBucketTaggingConfiguration(String bucketName)
  {
    return getBucketTaggingConfiguration(new GetBucketTaggingConfigurationRequest(bucketName));
  }
  
  public BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest getBucketTaggingConfigurationRequest)
  {
    getBucketTaggingConfigurationRequest = (GetBucketTaggingConfigurationRequest)beforeClientExecution(getBucketTaggingConfigurationRequest);
    rejectNull(getBucketTaggingConfigurationRequest, "The request object parameter getBucketTaggingConfigurationRequest must be specifed.");
    String bucketName = getBucketTaggingConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name must be specified when retrieving the bucket tagging configuration.");
    
    Request<GetBucketTaggingConfigurationRequest> request = createRequest(bucketName, null, getBucketTaggingConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketTagging");
    request.addParameter("tagging", null);
    try
    {
      return (BucketTaggingConfiguration)invoke(request, new Unmarshallers.BucketTaggingConfigurationUnmarshaller(), bucketName, null);
    }
    catch (AmazonServiceException ase)
    {
      switch (ase.getStatusCode())
      {
      case 404: 
        return null;
      }
    }
    throw ase;
  }
  
  public void setBucketTaggingConfiguration(String bucketName, BucketTaggingConfiguration bucketTaggingConfiguration)
  {
    setBucketTaggingConfiguration(new SetBucketTaggingConfigurationRequest(bucketName, bucketTaggingConfiguration));
  }
  
  public void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest)
  {
    setBucketTaggingConfigurationRequest = (SetBucketTaggingConfigurationRequest)beforeClientExecution(setBucketTaggingConfigurationRequest);
    rejectNull(setBucketTaggingConfigurationRequest, "The set bucket tagging configuration request object must be specified.");
    
    String bucketName = setBucketTaggingConfigurationRequest.getBucketName();
    BucketTaggingConfiguration bucketTaggingConfiguration = setBucketTaggingConfigurationRequest.getTaggingConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting bucket tagging configuration.");
    
    rejectNull(bucketTaggingConfiguration, "The tagging configuration parameter must be specified when setting bucket tagging configuration.");
    
    Request<SetBucketTaggingConfigurationRequest> request = createRequest(bucketName, null, setBucketTaggingConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketTagging");
    request.addParameter("tagging", null);
    
    byte[] content = new BucketConfigurationXmlFactory().convertToXmlByteArray(bucketTaggingConfiguration);
    request.addHeader("Content-Length", String.valueOf(content.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(content));
    try
    {
      byte[] md5 = Md5Utils.computeMD5Hash(content);
      String md5Base64 = BinaryUtils.toBase64(md5);
      request.addHeader("Content-MD5", md5Base64);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Couldn't compute md5 sum", e);
    }
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void deleteBucketTaggingConfiguration(String bucketName)
  {
    deleteBucketTaggingConfiguration(new DeleteBucketTaggingConfigurationRequest(bucketName));
  }
  
  public void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest)
  {
    deleteBucketTaggingConfigurationRequest = (DeleteBucketTaggingConfigurationRequest)beforeClientExecution(deleteBucketTaggingConfigurationRequest);
    rejectNull(deleteBucketTaggingConfigurationRequest, "The delete bucket tagging configuration request object must be specified.");
    
    String bucketName = deleteBucketTaggingConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting bucket tagging configuration.");
    
    Request<DeleteBucketTaggingConfigurationRequest> request = createRequest(bucketName, null, deleteBucketTaggingConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketTagging");
    request.addParameter("tagging", null);
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void setBucketWebsiteConfiguration(String bucketName, BucketWebsiteConfiguration configuration)
    throws SdkClientException, AmazonServiceException
  {
    setBucketWebsiteConfiguration(new SetBucketWebsiteConfigurationRequest(bucketName, configuration));
  }
  
  public void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    setBucketWebsiteConfigurationRequest = (SetBucketWebsiteConfigurationRequest)beforeClientExecution(setBucketWebsiteConfigurationRequest);
    String bucketName = setBucketWebsiteConfigurationRequest.getBucketName();
    BucketWebsiteConfiguration configuration = setBucketWebsiteConfigurationRequest.getConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting a bucket's website configuration");
    
    rejectNull(configuration, "The bucket website configuration parameter must be specified when setting a bucket's website configuration");
    if (configuration.getRedirectAllRequestsTo() == null) {
      rejectNull(configuration.getIndexDocumentSuffix(), "The bucket website configuration parameter must specify the index document suffix when setting a bucket's website configuration");
    }
    Request<SetBucketWebsiteConfigurationRequest> request = createRequest(bucketName, null, setBucketWebsiteConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketWebsite");
    request.addParameter("website", null);
    request.addHeader("Content-Type", "application/xml");
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(configuration);
    request.setContent(new ByteArrayInputStream(bytes));
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void deleteBucketWebsiteConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketWebsiteConfiguration(new DeleteBucketWebsiteConfigurationRequest(bucketName));
  }
  
  public void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketWebsiteConfigurationRequest = (DeleteBucketWebsiteConfigurationRequest)beforeClientExecution(deleteBucketWebsiteConfigurationRequest);
    String bucketName = deleteBucketWebsiteConfigurationRequest.getBucketName();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting a bucket's website configuration");
    
    Request<DeleteBucketWebsiteConfigurationRequest> request = createRequest(bucketName, null, deleteBucketWebsiteConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketWebsite");
    request.addParameter("website", null);
    request.addHeader("Content-Type", "application/xml");
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void setBucketNotificationConfiguration(String bucketName, BucketNotificationConfiguration bucketNotificationConfiguration)
    throws SdkClientException, AmazonServiceException
  {
    setBucketNotificationConfiguration(new SetBucketNotificationConfigurationRequest(bucketName, bucketNotificationConfiguration));
  }
  
  public void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    setBucketNotificationConfigurationRequest = (SetBucketNotificationConfigurationRequest)beforeClientExecution(setBucketNotificationConfigurationRequest);
    rejectNull(setBucketNotificationConfigurationRequest, "The set bucket notification configuration request object must be specified.");
    
    String bucketName = setBucketNotificationConfigurationRequest.getBucketName();
    BucketNotificationConfiguration bucketNotificationConfiguration = setBucketNotificationConfigurationRequest.getNotificationConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting bucket notification configuration.");
    
    rejectNull(bucketNotificationConfiguration, "The notification configuration parameter must be specified when setting bucket notification configuration.");
    
    Request<SetBucketNotificationConfigurationRequest> request = createRequest(bucketName, null, setBucketNotificationConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketNotificationConfiguration");
    request.addParameter("notification", null);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(bucketNotificationConfiguration);
    request.setContent(new ByteArrayInputStream(bytes));
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketNotificationConfiguration getBucketNotificationConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketNotificationConfiguration(new GetBucketNotificationConfigurationRequest(bucketName));
  }
  
  public BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketNotificationConfigurationRequest = (GetBucketNotificationConfigurationRequest)beforeClientExecution(getBucketNotificationConfigurationRequest);
    rejectNull(getBucketNotificationConfigurationRequest, "The bucket request parameter must be specified when querying notification configuration");
    
    String bucketName = getBucketNotificationConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket request must specify a bucket name when querying notification configuration");
    
    Request<GetBucketNotificationConfigurationRequest> request = createRequest(bucketName, null, getBucketNotificationConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketNotificationConfiguration");
    request.addParameter("notification", null);
    
    return (BucketNotificationConfiguration)invoke(request, BucketNotificationConfigurationStaxUnmarshaller.getInstance(), bucketName, null);
  }
  
  public BucketLoggingConfiguration getBucketLoggingConfiguration(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketLoggingConfiguration(new GetBucketLoggingConfigurationRequest(bucketName));
  }
  
  public BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest getBucketLoggingConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketLoggingConfigurationRequest = (GetBucketLoggingConfigurationRequest)beforeClientExecution(getBucketLoggingConfigurationRequest);
    rejectNull(getBucketLoggingConfigurationRequest, "The request object parameter getBucketLoggingConfigurationRequest must be specifed.");
    String bucketName = getBucketLoggingConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when requesting a bucket's logging status");
    
    Request<GetBucketLoggingConfigurationRequest> request = createRequest(bucketName, null, getBucketLoggingConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketLogging");
    request.addParameter("logging", null);
    
    return (BucketLoggingConfiguration)invoke(request, new Unmarshallers.BucketLoggingConfigurationnmarshaller(), bucketName, null);
  }
  
  public void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest)
    throws SdkClientException, AmazonServiceException
  {
    setBucketLoggingConfigurationRequest = (SetBucketLoggingConfigurationRequest)beforeClientExecution(setBucketLoggingConfigurationRequest);
    rejectNull(setBucketLoggingConfigurationRequest, "The set bucket logging configuration request object must be specified when enabling server access logging");
    
    String bucketName = setBucketLoggingConfigurationRequest.getBucketName();
    BucketLoggingConfiguration loggingConfiguration = setBucketLoggingConfigurationRequest.getLoggingConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when enabling server access logging");
    
    rejectNull(loggingConfiguration, "The logging configuration parameter must be specified when enabling server access logging");
    
    Request<SetBucketLoggingConfigurationRequest> request = createRequest(bucketName, null, setBucketLoggingConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketLogging");
    request.addParameter("logging", null);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(loggingConfiguration);
    request.setContent(new ByteArrayInputStream(bytes));
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketAccelerateConfiguration getBucketAccelerateConfiguration(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketAccelerateConfiguration(new GetBucketAccelerateConfigurationRequest(bucketName));
  }
  
  public BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    getBucketAccelerateConfigurationRequest = (GetBucketAccelerateConfigurationRequest)beforeClientExecution(getBucketAccelerateConfigurationRequest);
    rejectNull(getBucketAccelerateConfigurationRequest, "getBucketAccelerateConfigurationRequest must be specified.");
    String bucketName = getBucketAccelerateConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when querying accelerate configuration");
    
    Request<GetBucketAccelerateConfigurationRequest> request = createRequest(bucketName, null, getBucketAccelerateConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketAccelerateConfiguration");
    request.addParameter("accelerate", null);
    
    return (BucketAccelerateConfiguration)invoke(request, new Unmarshallers.BucketAccelerateConfigurationUnmarshaller(), bucketName, null);
  }
  
  public void setBucketAccelerateConfiguration(String bucketName, BucketAccelerateConfiguration accelerateConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    setBucketAccelerateConfiguration(new SetBucketAccelerateConfigurationRequest(bucketName, accelerateConfiguration));
  }
  
  public void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest setBucketAccelerateConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    setBucketAccelerateConfigurationRequest = (SetBucketAccelerateConfigurationRequest)beforeClientExecution(setBucketAccelerateConfigurationRequest);
    
    rejectNull(setBucketAccelerateConfigurationRequest, "setBucketAccelerateConfigurationRequest must be specified");
    
    String bucketName = setBucketAccelerateConfigurationRequest.getBucketName();
    BucketAccelerateConfiguration accelerateConfiguration = setBucketAccelerateConfigurationRequest.getAccelerateConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting accelerate configuration.");
    
    rejectNull(accelerateConfiguration, "The bucket accelerate configuration parameter must be specified.");
    
    rejectNull(accelerateConfiguration.getStatus(), "The status parameter must be specified when updating bucket accelerate configuration.");
    
    Request<SetBucketAccelerateConfigurationRequest> request = createRequest(bucketName, null, setBucketAccelerateConfigurationRequest, HttpMethodName.PUT);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketAccelerateConfiguration");
    request.addParameter("accelerate", null);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(accelerateConfiguration);
    request.setContent(new ByteArrayInputStream(bytes));
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketPolicy getBucketPolicy(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    return getBucketPolicy(new GetBucketPolicyRequest(bucketName));
  }
  
  public void deleteBucketPolicy(String bucketName)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketPolicy(new DeleteBucketPolicyRequest(bucketName));
  }
  
  public BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException
  {
    getBucketPolicyRequest = (GetBucketPolicyRequest)beforeClientExecution(getBucketPolicyRequest);
    rejectNull(getBucketPolicyRequest, "The request object must be specified when getting a bucket policy");
    
    String bucketName = getBucketPolicyRequest.getBucketName();
    rejectNull(bucketName, "The bucket name must be specified when getting a bucket policy");
    
    Request<GetBucketPolicyRequest> request = createRequest(bucketName, null, getBucketPolicyRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketPolicy");
    request.addParameter("policy", null);
    
    BucketPolicy result = new BucketPolicy();
    try
    {
      String policyText = (String)invoke(request, new S3StringResponseHandler(), bucketName, null);
      result.setPolicyText(policyText);
      return result;
    }
    catch (AmazonServiceException ase)
    {
      if (ase.getErrorCode().equals("NoSuchBucketPolicy")) {
        return result;
      }
      throw ase;
    }
  }
  
  public void setBucketPolicy(String bucketName, String policyText)
    throws SdkClientException, AmazonServiceException
  {
    setBucketPolicy(new SetBucketPolicyRequest(bucketName, policyText));
  }
  
  public void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException
  {
    setBucketPolicyRequest = (SetBucketPolicyRequest)beforeClientExecution(setBucketPolicyRequest);
    rejectNull(setBucketPolicyRequest, "The request object must be specified when setting a bucket policy");
    
    String bucketName = setBucketPolicyRequest.getBucketName();
    String policyText = setBucketPolicyRequest.getPolicyText();
    
    rejectNull(bucketName, "The bucket name must be specified when setting a bucket policy");
    
    rejectNull(policyText, "The policy text must be specified when setting a bucket policy");
    
    Request<SetBucketPolicyRequest> request = createRequest(bucketName, null, setBucketPolicyRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketPolicy");
    request.addParameter("policy", null);
    request.setContent(new ByteArrayInputStream(ServiceUtils.toByteArray(policyText)));
    if ((setBucketPolicyRequest.getConfirmRemoveSelfBucketAccess() != null) && 
      (setBucketPolicyRequest.getConfirmRemoveSelfBucketAccess().booleanValue())) {
      request.addHeader("x-amz-confirm-remove-self-bucket-access", "true");
    }
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest)
    throws SdkClientException, AmazonServiceException
  {
    deleteBucketPolicyRequest = (DeleteBucketPolicyRequest)beforeClientExecution(deleteBucketPolicyRequest);
    rejectNull(deleteBucketPolicyRequest, "The request object must be specified when deleting a bucket policy");
    
    String bucketName = deleteBucketPolicyRequest.getBucketName();
    rejectNull(bucketName, "The bucket name must be specified when deleting a bucket policy");
    
    Request<DeleteBucketPolicyRequest> request = createRequest(bucketName, null, deleteBucketPolicyRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketPolicy");
    request.addParameter("policy", null);
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public DeleteBucketEncryptionResult deleteBucketEncryption(String bucketName)
    throws SdkClientException
  {
    return deleteBucketEncryption(new DeleteBucketEncryptionRequest().withBucketName(bucketName));
  }
  
  public DeleteBucketEncryptionResult deleteBucketEncryption(DeleteBucketEncryptionRequest deleteBucketEncryptionRequest)
    throws SdkClientException
  {
    deleteBucketEncryptionRequest = (DeleteBucketEncryptionRequest)beforeClientExecution(deleteBucketEncryptionRequest);
    rejectNull(deleteBucketEncryptionRequest, "The request object must be specified when deleting a bucket encryption configuration");
    
    String bucketName = deleteBucketEncryptionRequest.getBucketName();
    rejectNull(bucketName, "The bucket name must be specified when deleting a bucket encryption configuration");
    
    Request<DeleteBucketEncryptionRequest> request = createRequest(bucketName, null, deleteBucketEncryptionRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketEncryption");
    request.addParameter("encryption", null);
    
    return (DeleteBucketEncryptionResult)invoke(request, new Unmarshallers.DeleteBucketEncryptionUnmarshaller(), bucketName, null);
  }
  
  public GetBucketEncryptionResult getBucketEncryption(String bucketName)
    throws SdkClientException
  {
    return getBucketEncryption(new GetBucketEncryptionRequest().withBucketName(bucketName));
  }
  
  public GetBucketEncryptionResult getBucketEncryption(GetBucketEncryptionRequest getBucketEncryptionRequest)
    throws SdkClientException
  {
    getBucketEncryptionRequest = (GetBucketEncryptionRequest)beforeClientExecution(getBucketEncryptionRequest);
    rejectNull(getBucketEncryptionRequest, "The bucket request parameter must be specified when querying encryption configuration");
    
    String bucketName = getBucketEncryptionRequest.getBucketName();
    rejectNull(bucketName, "The bucket request must specify a bucket name when querying encryption configuration");
    
    Request<GetBucketEncryptionRequest> request = createRequest(bucketName, null, getBucketEncryptionRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketEncryption");
    request.addParameter("encryption", null);
    
    return (GetBucketEncryptionResult)invoke(request, GetBucketEncryptionStaxUnmarshaller.getInstance(), bucketName, null);
  }
  
  public SetBucketEncryptionResult setBucketEncryption(SetBucketEncryptionRequest setBucketEncryptionRequest)
    throws AmazonServiceException, SdkClientException
  {
    setBucketEncryptionRequest = (SetBucketEncryptionRequest)beforeClientExecution(setBucketEncryptionRequest);
    rejectNull(setBucketEncryptionRequest, "The request object must be specified.");
    
    String bucketName = setBucketEncryptionRequest.getBucketName();
    ServerSideEncryptionConfiguration sseConfig = setBucketEncryptionRequest.getServerSideEncryptionConfiguration();
    rejectNull(bucketName, "The bucket name parameter must be specified when setting bucket encryption configuration.");
    
    rejectNull(sseConfig, "The SSE configuration parameter must be specified when setting bucket encryption configuration.");
    
    Request<SetBucketEncryptionRequest> request = createRequest(bucketName, null, setBucketEncryptionRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketEncryption");
    request.addParameter("encryption", null);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(sseConfig);
    request.setContent(new ByteArrayInputStream(bytes));
    
    return (SetBucketEncryptionResult)invoke(request, new Unmarshallers.SetBucketEncryptionUnmarshaller(), bucketName, null);
  }
  
  public SetPublicAccessBlockResult setPublicAccessBlock(SetPublicAccessBlockRequest setPublicAccessBlockRequest)
  {
    setPublicAccessBlockRequest = (SetPublicAccessBlockRequest)beforeClientExecution(setPublicAccessBlockRequest);
    rejectNull(setPublicAccessBlockRequest, "The request object must be specified.");
    
    String bucketName = setPublicAccessBlockRequest.getBucketName();
    PublicAccessBlockConfiguration config = setPublicAccessBlockRequest.getPublicAccessBlockConfiguration();
    rejectNull(bucketName, "The bucket name parameter must be specified when setting public block configuration.");
    
    rejectNull(config, "The PublicAccessBlockConfiguration parameter must be specified when setting public block");
    
    Request<SetPublicAccessBlockRequest> request = createRequest(bucketName, null, setPublicAccessBlockRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutPublicAccessBlock");
    request.addParameter("publicAccessBlock", null);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(config);
    request.setContent(new ByteArrayInputStream(bytes));
    
    return (SetPublicAccessBlockResult)invoke(request, new Unmarshallers.SetPublicAccessBlockUnmarshaller(), bucketName, null);
  }
  
  public GetPublicAccessBlockResult getPublicAccessBlock(GetPublicAccessBlockRequest getPublicAccessBlockRequest)
  {
    getPublicAccessBlockRequest = (GetPublicAccessBlockRequest)beforeClientExecution(getPublicAccessBlockRequest);
    rejectNull(getPublicAccessBlockRequest, "The request object must be specified.");
    
    String bucketName = getPublicAccessBlockRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when getting public block configuration.");
    
    Request<GetPublicAccessBlockRequest> request = createRequest(bucketName, null, getPublicAccessBlockRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetPublicAccessBlock");
    request.addParameter("publicAccessBlock", null);
    
    return (GetPublicAccessBlockResult)invoke(request, GetPublicAccessBlockStaxUnmarshaller.getInstance(), bucketName, null);
  }
  
  public DeletePublicAccessBlockResult deletePublicAccessBlock(DeletePublicAccessBlockRequest deletePublicAccessBlockRequest)
  {
    deletePublicAccessBlockRequest = (DeletePublicAccessBlockRequest)beforeClientExecution(deletePublicAccessBlockRequest);
    rejectNull(deletePublicAccessBlockRequest, "The request object must be specified.");
    
    String bucketName = deletePublicAccessBlockRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting public block configuration.");
    
    Request<DeletePublicAccessBlockRequest> request = createRequest(bucketName, null, deletePublicAccessBlockRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeletePublicAccessBlock");
    request.addParameter("publicAccessBlock", null);
    
    return (DeletePublicAccessBlockResult)invoke(request, new Unmarshallers.DeletePublicAccessBlockUnmarshaller(), bucketName, null);
  }
  
  public GetBucketPolicyStatusResult getBucketPolicyStatus(GetBucketPolicyStatusRequest getBucketPolicyStatusRequest)
  {
    getBucketPolicyStatusRequest = (GetBucketPolicyStatusRequest)beforeClientExecution(getBucketPolicyStatusRequest);
    rejectNull(getBucketPolicyStatusRequest, "The request object must be specified.");
    
    String bucketName = getBucketPolicyStatusRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when getting bucket policy status");
    
    Request<GetBucketPolicyStatusRequest> request = createRequest(bucketName, null, getBucketPolicyStatusRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketPolicyStatus");
    request.addParameter("policyStatus", null);
    
    return (GetBucketPolicyStatusResult)invoke(request, GetBucketPolicyStatusStaxUnmarshaller.getInstance(), bucketName, null);
  }
  
  public SelectObjectContentResult selectObjectContent(SelectObjectContentRequest selectRequest)
    throws AmazonServiceException, SdkClientException
  {
    selectRequest = (SelectObjectContentRequest)beforeClientExecution(selectRequest);
    rejectNull(selectRequest, "The request parameter must be specified");
    
    rejectNull(selectRequest.getBucketName(), "The bucket name parameter must be specified when selecting object content.");
    rejectNull(selectRequest.getKey(), "The key parameter must be specified when selecting object content.");
    
    Request<SelectObjectContentRequest> request = createRequest(selectRequest.getBucketName(), selectRequest.getKey(), selectRequest, HttpMethodName.POST);
    request.addParameter("select", null);
    request.addParameter("select-type", "2");
    
    populateSSE_C(request, selectRequest.getSSECustomerKey());
    
    setContent(request, RequestXmlFactory.convertToXmlByteArray(selectRequest), ContentType.APPLICATION_XML.toString(), true);
    
    S3Object result = (S3Object)invoke(request, new S3ObjectResponseHandler(), selectRequest.getBucketName(), selectRequest.getKey());
    
    SdkFilterInputStream resultStream = new ServiceClientHolderInputStream(result.getObjectContent(), this);
    
    return new SelectObjectContentResult().withPayload(new SelectObjectContentEventStream(resultStream));
  }
  
  public SetObjectLegalHoldResult setObjectLegalHold(SetObjectLegalHoldRequest setObjectLegalHoldRequest)
  {
    setObjectLegalHoldRequest = (SetObjectLegalHoldRequest)beforeClientExecution(setObjectLegalHoldRequest);
    rejectNull(setObjectLegalHoldRequest, "The request parameter must be specified");
    
    String bucketName = setObjectLegalHoldRequest.getBucketName();
    String key = setObjectLegalHoldRequest.getKey();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting the object legal hold.");
    rejectNull(key, "The key parameter must be specified when setting the object legal hold.");
    
    Request<SetObjectLegalHoldRequest> request = createRequest(bucketName, key, setObjectLegalHoldRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObjectLegalHold");
    setContent(request, new ObjectLockLegalHoldXmlFactory().convertToXmlByteArray(setObjectLegalHoldRequest.getLegalHold()), ContentType.APPLICATION_XML
      .toString(), true);
    request.addParameter("legal-hold", null);
    
    addParameterIfNotNull(request, "versionId", setObjectLegalHoldRequest.getVersionId());
    populateRequesterPaysHeader(request, setObjectLegalHoldRequest.isRequesterPays());
    
    ResponseHeaderHandlerChain<SetObjectLegalHoldResult> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.SetObjectLegalHoldResultUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler() });
    
    return (SetObjectLegalHoldResult)invoke(request, responseHandler, bucketName, key);
  }
  
  public GetObjectLegalHoldResult getObjectLegalHold(GetObjectLegalHoldRequest getObjectLegalHoldRequest)
  {
    getObjectLegalHoldRequest = (GetObjectLegalHoldRequest)beforeClientExecution(getObjectLegalHoldRequest);
    rejectNull(getObjectLegalHoldRequest, "The request parameter must be specified");
    
    String bucketName = getObjectLegalHoldRequest.getBucketName();
    String key = getObjectLegalHoldRequest.getKey();
    rejectNull(bucketName, "The bucket name parameter must be specified when getting the object legal hold.");
    rejectNull(key, "The key parameter must be specified when getting the object legal hold.");
    
    Request<GetObjectLegalHoldRequest> request = createRequest(bucketName, key, getObjectLegalHoldRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObjectLegalHold");
    request.addParameter("legal-hold", null);
    addParameterIfNotNull(request, "versionId", getObjectLegalHoldRequest.getVersionId());
    populateRequesterPaysHeader(request, getObjectLegalHoldRequest.isRequesterPays());
    
    return (GetObjectLegalHoldResult)invoke(request, new Unmarshallers.GetObjectLegalHoldResultUnmarshaller(), bucketName, key);
  }
  
  public SetObjectLockConfigurationResult setObjectLockConfiguration(SetObjectLockConfigurationRequest setObjectLockConfigurationRequest)
  {
    setObjectLockConfigurationRequest = (SetObjectLockConfigurationRequest)beforeClientExecution(setObjectLockConfigurationRequest);
    rejectNull(setObjectLockConfigurationRequest, "The request parameter must be specified");
    
    String bucketName = setObjectLockConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when setting the object lock configuration");
    
    Request<SetObjectLockConfigurationRequest> request = createRequest(bucketName, null, setObjectLockConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObjectLockConfiguration");
    request.addParameter("object-lock", null);
    
    addHeaderIfNotNull(request, "x-amz-bucket-object-lock-token", setObjectLockConfigurationRequest.getToken());
    populateRequesterPaysHeader(request, setObjectLockConfigurationRequest.isRequesterPays());
    
    setContent(request, new ObjectLockConfigurationXmlFactory().convertToXmlByteArray(setObjectLockConfigurationRequest.getObjectLockConfiguration()), ContentType.APPLICATION_XML
      .toString(), true);
    
    ResponseHeaderHandlerChain<SetObjectLockConfigurationResult> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.SetObjectLockConfigurationResultUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler() });
    
    return (SetObjectLockConfigurationResult)invoke(request, responseHandler, bucketName, null);
  }
  
  public GetObjectLockConfigurationResult getObjectLockConfiguration(GetObjectLockConfigurationRequest getObjectLockConfigurationRequest)
  {
    getObjectLockConfigurationRequest = (GetObjectLockConfigurationRequest)beforeClientExecution(getObjectLockConfigurationRequest);
    rejectNull(getObjectLockConfigurationRequest, "The request parameter must be specified");
    
    String bucketName = getObjectLockConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when getting the object lock configuration");
    
    Request<GetObjectLockConfigurationRequest> request = createRequest(bucketName, null, getObjectLockConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObjectLockConfiguration");
    request.addParameter("object-lock", null);
    
    return (GetObjectLockConfigurationResult)invoke(request, new Unmarshallers.GetObjectLockConfigurationResultUnmarshaller(), bucketName, null);
  }
  
  public SetObjectRetentionResult setObjectRetention(SetObjectRetentionRequest setObjectRetentionRequest)
  {
    setObjectRetentionRequest = (SetObjectRetentionRequest)beforeClientExecution(setObjectRetentionRequest);
    rejectNull(setObjectRetentionRequest, "The request parameter must be specified");
    
    String bucketName = setObjectRetentionRequest.getBucketName();
    String key = setObjectRetentionRequest.getKey();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting the object retention.");
    rejectNull(key, "The key parameter must be specified when setting the object retention.");
    
    Request<SetObjectRetentionRequest> request = createRequest(bucketName, key, setObjectRetentionRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObjectRetention");
    request.addParameter("retention", null);
    if (setObjectRetentionRequest.getBypassGovernanceRetention()) {
      request.addHeader("x-amz-bypass-governance-retention", "true");
    }
    addParameterIfNotNull(request, "versionId", setObjectRetentionRequest.getVersionId());
    populateRequesterPaysHeader(request, setObjectRetentionRequest.isRequesterPays());
    
    setContent(request, new ObjectLockRetentionXmlFactory().convertToXmlByteArray(setObjectRetentionRequest.getRetention()), ContentType.APPLICATION_XML
      .toString(), true);
    
    ResponseHeaderHandlerChain<SetObjectRetentionResult> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.SetObjectRetentionResultUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler() });
    
    return (SetObjectRetentionResult)invoke(request, responseHandler, bucketName, key);
  }
  
  public GetObjectRetentionResult getObjectRetention(GetObjectRetentionRequest getObjectRetentionRequest)
  {
    getObjectRetentionRequest = (GetObjectRetentionRequest)beforeClientExecution(getObjectRetentionRequest);
    rejectNull(getObjectRetentionRequest, "The request parameter must be specified");
    
    String bucketName = getObjectRetentionRequest.getBucketName();
    String key = getObjectRetentionRequest.getKey();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when getting the object retention.");
    rejectNull(key, "The key parameter must be specified when getting the object retention.");
    
    Request<GetObjectRetentionRequest> request = createRequest(bucketName, key, getObjectRetentionRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObjectRetention");
    request.addParameter("retention", null);
    
    addParameterIfNotNull(request, "versionId", getObjectRetentionRequest.getVersionId());
    
    populateRequesterPaysHeader(request, getObjectRetentionRequest.isRequesterPays());
    
    return (GetObjectRetentionResult)invoke(request, new Unmarshallers.GetObjectRetentionResultUnmarshaller(), bucketName, key);
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
  
  public URL generatePresignedUrl(GeneratePresignedUrlRequest req)
  {
    rejectNull(req, "The request parameter must be specified when generating a pre-signed URL");
    
    req.rejectIllegalArguments();
    
    String bucketName = req.getBucketName();
    String key = req.getKey();
    if (req.getExpiration() == null) {
      req.setExpiration(new Date(
        System.currentTimeMillis() + 900000L));
    }
    HttpMethodName httpMethod = HttpMethodName.valueOf(req.getMethod().toString());
    
    Request<GeneratePresignedUrlRequest> request = createRequest(bucketName, key, req, httpMethod);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GeneratePresignedUrl");
    
    addParameterIfNotNull(request, "versionId", req.getVersionId());
    if (req.isZeroByteContent()) {
      request.setContent(new ByteArrayInputStream(new byte[0]));
    }
    for (Iterator localIterator = req.getRequestParameters().entrySet().iterator(); localIterator.hasNext();)
    {
      entry = (Map.Entry)localIterator.next();
      request.addParameter((String)entry.getKey(), (String)entry.getValue());
    }
    Map.Entry<String, String> entry;
    addHeaderIfNotNull(request, "Content-Type", req.getContentType());
    addHeaderIfNotNull(request, "Content-MD5", req.getContentMd5());
    
    populateSSE_C(request, req.getSSECustomerKey());
    
    addHeaderIfNotNull(request, "x-amz-server-side-encryption", req
      .getSSEAlgorithm());
    
    addHeaderIfNotNull(request, "x-amz-server-side-encryption-aws-kms-key-id", req
      .getKmsCmkId());
    
    Object customHeaders = req.getCustomRequestHeaders();
    if (customHeaders != null) {
      for (Map.Entry<String, String> e : ((Map)customHeaders).entrySet()) {
        request.addHeader((String)e.getKey(), (String)e.getValue());
      }
    }
    addResponseHeaderParameters(request, req.getResponseHeaders());
    
    Signer signer = createSigner(request, bucketName, key);
    if ((signer instanceof Presigner)) {
      ((Presigner)signer).presignRequest(request, 
      
        CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider).getCredentials(), req
        .getExpiration());
    } else {
      presignRequest(request, req
      
        .getMethod(), bucketName, key, req
        
        .getExpiration(), null);
    }
    return ServiceUtils.convertRequestToUrl(request, true, false);
  }
  
  public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest)
    throws SdkClientException, AmazonServiceException
  {
    abortMultipartUploadRequest = (AbortMultipartUploadRequest)beforeClientExecution(abortMultipartUploadRequest);
    rejectNull(abortMultipartUploadRequest, "The request parameter must be specified when aborting a multipart upload");
    
    rejectNull(abortMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when aborting a multipart upload");
    
    rejectNull(abortMultipartUploadRequest.getKey(), "The key parameter must be specified when aborting a multipart upload");
    
    rejectNull(abortMultipartUploadRequest.getUploadId(), "The upload ID parameter must be specified when aborting a multipart upload");
    
    String bucketName = abortMultipartUploadRequest.getBucketName();
    String key = abortMultipartUploadRequest.getKey();
    
    Request<AbortMultipartUploadRequest> request = createRequest(bucketName, key, abortMultipartUploadRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AbortMultipartUpload");
    request.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
    populateRequesterPaysHeader(request, abortMultipartUploadRequest.isRequesterPays());
    
    invoke(request, voidResponseHandler, bucketName, key);
  }
  
  public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest)
    throws SdkClientException, AmazonServiceException
  {
    completeMultipartUploadRequest = (CompleteMultipartUploadRequest)beforeClientExecution(completeMultipartUploadRequest);
    rejectNull(completeMultipartUploadRequest, "The request parameter must be specified when completing a multipart upload");
    
    String bucketName = completeMultipartUploadRequest.getBucketName();
    String key = completeMultipartUploadRequest.getKey();
    String uploadId = completeMultipartUploadRequest.getUploadId();
    rejectNull(bucketName, "The bucket name parameter must be specified when completing a multipart upload");
    
    rejectNull(key, "The key parameter must be specified when completing a multipart upload");
    
    rejectNull(uploadId, "The upload ID parameter must be specified when completing a multipart upload");
    
    rejectNull(completeMultipartUploadRequest.getPartETags(), "The part ETags parameter must be specified when completing a multipart upload");
    
    int retries = 0;
    XmlResponsesSaxParser.CompleteMultipartUploadHandler handler;
    do
    {
      Request<CompleteMultipartUploadRequest> request = createRequest(bucketName, key, completeMultipartUploadRequest, HttpMethodName.POST);
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CompleteMultipartUpload");
      request.addParameter("uploadId", uploadId);
      
      populateRequesterPaysHeader(request, completeMultipartUploadRequest.isRequesterPays());
      
      byte[] xml = RequestXmlFactory.convertToXmlByteArray(completeMultipartUploadRequest.getPartETags());
      request.addHeader("Content-Type", "application/xml");
      request.addHeader("Content-Length", String.valueOf(xml.length));
      
      request.setContent(new ByteArrayInputStream(xml));
      
      ResponseHeaderHandlerChain<XmlResponsesSaxParser.CompleteMultipartUploadHandler> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.CompleteMultipartUploadResultUnmarshaller(), new HeaderHandler[] { new ServerSideEncryptionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3VersionHeaderHandler(), new S3RequesterChargedHeaderHandler() });
      
      handler = (XmlResponsesSaxParser.CompleteMultipartUploadHandler)invoke(request, responseHandler, bucketName, key);
      if (handler.getCompleteMultipartUploadResult() != null) {
        return handler.getCompleteMultipartUploadResult();
      }
    } while (shouldRetryCompleteMultipartUpload(completeMultipartUploadRequest, handler
      .getAmazonS3Exception(), retries++));
    throw handler.getAmazonS3Exception();
  }
  
  private boolean shouldRetryCompleteMultipartUpload(AmazonWebServiceRequest originalRequest, AmazonS3Exception exception, int retriesAttempted)
  {
    RetryPolicy retryPolicy = clientConfiguration.getRetryPolicy();
    if ((retryPolicy == null) || (retryPolicy.getRetryCondition() == null)) {
      return false;
    }
    if (retryPolicy == PredefinedRetryPolicies.NO_RETRY_POLICY) {
      return false;
    }
    return 
      completeMultipartUploadRetryCondition.shouldRetry(originalRequest, exception, retriesAttempted);
  }
  
  public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest)
    throws SdkClientException, AmazonServiceException
  {
    initiateMultipartUploadRequest = (InitiateMultipartUploadRequest)beforeClientExecution(initiateMultipartUploadRequest);
    rejectNull(initiateMultipartUploadRequest, "The request parameter must be specified when initiating a multipart upload");
    
    rejectNull(initiateMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when initiating a multipart upload");
    
    rejectNull(initiateMultipartUploadRequest.getKey(), "The key parameter must be specified when initiating a multipart upload");
    
    Request<InitiateMultipartUploadRequest> request = createRequest(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), initiateMultipartUploadRequest, HttpMethodName.POST);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateMultipartUpload");
    request.addParameter("uploads", null);
    if (initiateMultipartUploadRequest.getStorageClass() != null) {
      request.addHeader("x-amz-storage-class", initiateMultipartUploadRequest.getStorageClass().toString());
    }
    if (initiateMultipartUploadRequest.getRedirectLocation() != null) {
      request.addHeader("x-amz-website-redirect-location", initiateMultipartUploadRequest.getRedirectLocation());
    }
    if (initiateMultipartUploadRequest.getAccessControlList() != null) {
      addAclHeaders(request, initiateMultipartUploadRequest.getAccessControlList());
    } else if (initiateMultipartUploadRequest.getCannedACL() != null) {
      request.addHeader("x-amz-acl", initiateMultipartUploadRequest.getCannedACL().toString());
    }
    if (objectMetadata != null) {
      populateRequestMetadata(request, objectMetadata);
    }
    populateRequesterPaysHeader(request, initiateMultipartUploadRequest.isRequesterPays());
    
    populateSSE_C(request, initiateMultipartUploadRequest.getSSECustomerKey());
    
    populateSSE_KMS(request, initiateMultipartUploadRequest
      .getSSEAwsKeyManagementParams());
    
    addHeaderIfNotNull(request, "x-amz-tagging", urlEncodeTags(initiateMultipartUploadRequest.getTagging()));
    
    populateObjectLockHeaders(request, initiateMultipartUploadRequest.getObjectLockMode(), initiateMultipartUploadRequest.getObjectLockRetainUntilDate(), initiateMultipartUploadRequest
      .getObjectLockLegalHoldStatus());
    
    setZeroContentLength(request);
    
    request.setContent(new ByteArrayInputStream(new byte[0]));
    
    ResponseHeaderHandlerChain<InitiateMultipartUploadResult> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.InitiateMultipartUploadResultUnmarshaller(), new HeaderHandler[] { new ServerSideEncryptionHeaderHandler(), new S3RequesterChargedHeaderHandler(), new InitiateMultipartUploadHeaderHandler() });
    
    return (InitiateMultipartUploadResult)invoke(request, responseHandler, initiateMultipartUploadRequest
      .getBucketName(), initiateMultipartUploadRequest.getKey());
  }
  
  public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest)
    throws SdkClientException, AmazonServiceException
  {
    listMultipartUploadsRequest = (ListMultipartUploadsRequest)beforeClientExecution(listMultipartUploadsRequest);
    rejectNull(listMultipartUploadsRequest, "The request parameter must be specified when listing multipart uploads");
    
    rejectNull(listMultipartUploadsRequest.getBucketName(), "The bucket name parameter must be specified when listing multipart uploads");
    
    Request<ListMultipartUploadsRequest> request = createRequest(listMultipartUploadsRequest.getBucketName(), null, listMultipartUploadsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListMultipartUploads");
    request.addParameter("uploads", null);
    if (listMultipartUploadsRequest.getKeyMarker() != null) {
      request.addParameter("key-marker", listMultipartUploadsRequest.getKeyMarker());
    }
    if (listMultipartUploadsRequest.getMaxUploads() != null) {
      request.addParameter("max-uploads", listMultipartUploadsRequest.getMaxUploads().toString());
    }
    if (listMultipartUploadsRequest.getUploadIdMarker() != null) {
      request.addParameter("upload-id-marker", listMultipartUploadsRequest.getUploadIdMarker());
    }
    if (listMultipartUploadsRequest.getDelimiter() != null) {
      request.addParameter("delimiter", listMultipartUploadsRequest.getDelimiter());
    }
    if (listMultipartUploadsRequest.getPrefix() != null) {
      request.addParameter("prefix", listMultipartUploadsRequest.getPrefix());
    }
    if (listMultipartUploadsRequest.getEncodingType() != null) {
      request.addParameter("encoding-type", listMultipartUploadsRequest.getEncodingType());
    }
    return (MultipartUploadListing)invoke(request, new Unmarshallers.ListMultipartUploadsResultUnmarshaller(), listMultipartUploadsRequest.getBucketName(), null);
  }
  
  public PartListing listParts(ListPartsRequest listPartsRequest)
    throws SdkClientException, AmazonServiceException
  {
    listPartsRequest = (ListPartsRequest)beforeClientExecution(listPartsRequest);
    rejectNull(listPartsRequest, "The request parameter must be specified when listing parts");
    
    rejectNull(listPartsRequest.getBucketName(), "The bucket name parameter must be specified when listing parts");
    
    rejectNull(listPartsRequest.getKey(), "The key parameter must be specified when listing parts");
    
    rejectNull(listPartsRequest.getUploadId(), "The upload ID parameter must be specified when listing parts");
    
    Request<ListPartsRequest> request = createRequest(listPartsRequest.getBucketName(), listPartsRequest.getKey(), listPartsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListParts");
    request.addParameter("uploadId", listPartsRequest.getUploadId());
    if (listPartsRequest.getMaxParts() != null) {
      request.addParameter("max-parts", listPartsRequest.getMaxParts().toString());
    }
    if (listPartsRequest.getPartNumberMarker() != null) {
      request.addParameter("part-number-marker", listPartsRequest.getPartNumberMarker().toString());
    }
    if (listPartsRequest.getEncodingType() != null) {
      request.addParameter("encoding-type", listPartsRequest.getEncodingType());
    }
    populateRequesterPaysHeader(request, listPartsRequest.isRequesterPays());
    
    ResponseHeaderHandlerChain<PartListing> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.ListPartsResultUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler(), new ListPartsHeaderHandler() });
    
    return (PartListing)invoke(request, responseHandler, listPartsRequest.getBucketName(), listPartsRequest.getKey());
  }
  
  public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest)
    throws SdkClientException, AmazonServiceException
  {
    uploadPartRequest = (UploadPartRequest)beforeClientExecution(uploadPartRequest);
    rejectNull(uploadPartRequest, "The request parameter must be specified when uploading a part");
    
    File fileOrig = uploadPartRequest.getFile();
    InputStream isOrig = uploadPartRequest.getInputStream();
    String bucketName = uploadPartRequest.getBucketName();
    String key = uploadPartRequest.getKey();
    String uploadId = uploadPartRequest.getUploadId();
    int partNumber = uploadPartRequest.getPartNumber();
    long partSize = uploadPartRequest.getPartSize();
    rejectNull(bucketName, "The bucket name parameter must be specified when uploading a part");
    
    rejectNull(key, "The key parameter must be specified when uploading a part");
    
    rejectNull(uploadId, "The upload ID parameter must be specified when uploading a part");
    
    Request<UploadPartRequest> request = createRequest(bucketName, key, uploadPartRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UploadPart");
    request.addHandlerContext(HandlerContextKey.REQUIRES_LENGTH, Boolean.TRUE);
    request.addHandlerContext(HandlerContextKey.HAS_STREAMING_INPUT, Boolean.TRUE);
    
    request.addParameter("uploadId", uploadId);
    request.addParameter("partNumber", Integer.toString(partNumber));
    
    ObjectMetadata objectMetadata = uploadPartRequest.getObjectMetadata();
    if (objectMetadata != null) {
      populateRequestMetadata(request, objectMetadata);
    }
    addHeaderIfNotNull(request, "Content-MD5", uploadPartRequest.getMd5Digest());
    request.addHeader("Content-Length", Long.toString(partSize));
    
    populateRequesterPaysHeader(request, uploadPartRequest.isRequesterPays());
    
    populateSSE_C(request, uploadPartRequest.getSSECustomerKey());
    InputStream isCurr = isOrig;
    try
    {
      if (fileOrig == null)
      {
        if (isOrig == null) {
          throw new IllegalArgumentException("A File or InputStream must be specified when uploading part");
        }
        isCurr = ReleasableInputStream.wrap(isCurr);
        
        Integer bufsize = Constants.getS3StreamBufferSize();
        if (bufsize != null)
        {
          AmazonWebServiceRequest awsreq = request.getOriginalRequest();
          
          awsreq.getRequestClientOptions()
            .setReadLimit(bufsize.intValue());
        }
      }
      else
      {
        try
        {
          isCurr = new ResettableInputStream(fileOrig);
        }
        catch (IOException e)
        {
          throw new IllegalArgumentException("Failed to open file " + fileOrig, e);
        }
      }
      isCurr = new InputSubstream(isCurr, uploadPartRequest.getFileOffset(), partSize, uploadPartRequest.isLastPart());
      MD5DigestCalculatingInputStream md5DigestStream = null;
      if ((uploadPartRequest.getMd5Digest() == null) && 
        (!skipMd5CheckStrategy.skipClientSideValidationPerRequest(uploadPartRequest))) {
        isCurr = md5DigestStream = new MD5DigestCalculatingInputStream(isCurr);
      }
      ProgressListener listener = uploadPartRequest.getGeneralProgressListener();
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_PART_STARTED_EVENT);
      return doUploadPart(bucketName, key, uploadId, partNumber, partSize, request, isCurr, md5DigestStream, listener);
    }
    finally
    {
      S3DataSource.Utils.cleanupDataSource(uploadPartRequest, fileOrig, isOrig, isCurr, log);
    }
  }
  
  private UploadPartResult doUploadPart(String bucketName, String key, String uploadId, int partNumber, long partSize, Request<UploadPartRequest> request, InputStream inputStream, MD5DigestCalculatingInputStream md5DigestStream, ProgressListener listener)
  {
    try
    {
      request.setContent(inputStream);
      ObjectMetadata metadata = (ObjectMetadata)invoke(request, new S3MetadataResponseHandler(), bucketName, key);
      String etag = metadata.getETag();
      if ((md5DigestStream != null) && 
        (!skipMd5CheckStrategy.skipClientSideValidationPerUploadPartResponse(metadata)))
      {
        byte[] clientSideHash = md5DigestStream.getMd5Digest();
        byte[] serverSideHash = BinaryUtils.fromHex(etag);
        if (!Arrays.equals(clientSideHash, serverSideHash))
        {
          String info = "bucketName: " + bucketName + ", key: " + key + ", uploadId: " + uploadId + ", partNumber: " + partNumber + ", partSize: " + partSize;
          
          throw new SdkClientException("Unable to verify integrity of data upload.  Client calculated content hash (contentMD5: " + Base16.encodeAsString(clientSideHash) + " in hex) didn't match hash (etag: " + etag + " in hex) calculated by Amazon S3.  You may need to delete the data stored in Amazon S3. (" + info + ")");
        }
      }
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_PART_COMPLETED_EVENT);
      UploadPartResult result = new UploadPartResult();
      result.setETag(etag);
      result.setPartNumber(partNumber);
      result.setSSEAlgorithm(metadata.getSSEAlgorithm());
      result.setSSECustomerAlgorithm(metadata.getSSECustomerAlgorithm());
      result.setSSECustomerKeyMd5(metadata.getSSECustomerKeyMd5());
      result.setRequesterCharged(metadata.isRequesterCharged());
      return result;
    }
    catch (Throwable t)
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_PART_FAILED_EVENT);
      
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_PART_COMPLETED_EVENT);
      throw Throwables.failure(t);
    }
  }
  
  public S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    return (S3ResponseMetadata)client.getResponseMetadataForRequest(request);
  }
  
  public void restoreObject(RestoreObjectRequest restoreObjectRequest)
    throws AmazonServiceException
  {
    restoreObjectV2(restoreObjectRequest);
  }
  
  public RestoreObjectResult restoreObjectV2(RestoreObjectRequest restoreObjectRequest)
    throws AmazonServiceException
  {
    restoreObjectRequest = (RestoreObjectRequest)beforeClientExecution(restoreObjectRequest);
    String bucketName = restoreObjectRequest.getBucketName();
    String key = restoreObjectRequest.getKey();
    int expirationInDays = restoreObjectRequest.getExpirationInDays();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when restoring a glacier object");
    rejectNull(key, "The key parameter must be specified when restoring a glacier object");
    if (restoreObjectRequest.getOutputLocation() != null)
    {
      rejectNull(restoreObjectRequest.getType(), "The restore request type must be specified with restores that specify OutputLocation");
      if (RestoreRequestType.SELECT.toString().equals(restoreObjectRequest.getType())) {
        rejectNull(restoreObjectRequest.getSelectParameters(), "The select parameters must be specified when restoring a glacier object with SELECT restore request type");
      }
    }
    else if (expirationInDays == -1)
    {
      throw new IllegalArgumentException("The expiration in days parameter must be specified when restoring a glacier object without OutputLocation");
    }
    Request<RestoreObjectRequest> request = createRestoreObjectRequest(restoreObjectRequest);
    
    ResponseHeaderHandlerChain<RestoreObjectResult> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.RestoreObjectResultUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler(), new S3RestoreOutputPathHeaderHandler() });
    
    return (RestoreObjectResult)invoke(request, responseHandler, bucketName, key);
  }
  
  public void restoreObject(String bucketName, String key, int expirationInDays)
    throws AmazonServiceException
  {
    restoreObject(new RestoreObjectRequest(bucketName, key, expirationInDays));
  }
  
  public PutObjectResult putObject(String bucketName, String key, String content)
    throws AmazonServiceException, SdkClientException
  {
    rejectNull(bucketName, "Bucket name must be provided");
    rejectNull(key, "Object key must be provided");
    rejectNull(content, "String content must be provided");
    
    byte[] contentBytes = content.getBytes(StringUtils.UTF8);
    
    InputStream is = new ByteArrayInputStream(contentBytes);
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentType("text/plain");
    metadata.setContentLength(contentBytes.length);
    
    return putObject(new PutObjectRequest(bucketName, key, is, metadata));
  }
  
  private void rejectNull(Object parameterValue, String errorMessage)
  {
    if (parameterValue == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
  
  private AccessControlList getAcl(String bucketName, String key, String versionId, boolean isRequesterPays, AmazonWebServiceRequest originalRequest)
  {
    if (originalRequest == null) {
      originalRequest = new GenericBucketRequest(bucketName);
    }
    Request<AmazonWebServiceRequest> request = createRequest(bucketName, key, originalRequest, HttpMethodName.GET);
    if ((bucketName != null) && (key != null)) {
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObjectAcl");
    } else if (bucketName != null) {
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketAcl");
    }
    request.addParameter("acl", null);
    if (versionId != null) {
      request.addParameter("versionId", versionId);
    }
    populateRequesterPaysHeader(request, isRequesterPays);
    
    ResponseHeaderHandlerChain<AccessControlList> responseHandler = new ResponseHeaderHandlerChain(new Unmarshallers.AccessControlListUnmarshaller(), new HeaderHandler[] { new S3RequesterChargedHeaderHandler() });
    
    return (AccessControlList)invoke(request, responseHandler, bucketName, key);
  }
  
  private void setAcl(String bucketName, String key, String versionId, CannedAccessControlList cannedAcl, boolean isRequesterPays, AmazonWebServiceRequest originalRequest)
  {
    if (originalRequest == null) {
      originalRequest = new GenericBucketRequest(bucketName);
    }
    Request<AmazonWebServiceRequest> request = createRequest(bucketName, key, originalRequest, HttpMethodName.PUT);
    if ((bucketName != null) && (key != null)) {
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObjectAcl");
    } else if (bucketName != null) {
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketAcl");
    }
    request.addParameter("acl", null);
    request.addHeader("x-amz-acl", cannedAcl.toString());
    if (versionId != null) {
      request.addParameter("versionId", versionId);
    }
    populateRequesterPaysHeader(request, isRequesterPays);
    
    invoke(request, voidResponseHandler, bucketName, key);
  }
  
  private void setAcl(String bucketName, String key, String versionId, AccessControlList acl, boolean isRequesterPays, AmazonWebServiceRequest originalRequest)
  {
    if (originalRequest == null) {
      originalRequest = new GenericBucketRequest(bucketName);
    }
    Request<AmazonWebServiceRequest> request = createRequest(bucketName, key, originalRequest, HttpMethodName.PUT);
    if ((bucketName != null) && (key != null)) {
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObjectAcl");
    } else if (bucketName != null) {
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketAcl");
    }
    request.addParameter("acl", null);
    if (versionId != null) {
      request.addParameter("versionId", versionId);
    }
    populateRequesterPaysHeader(request, isRequesterPays);
    
    byte[] aclAsXml = new AclXmlFactory().convertToXmlByteArray(acl);
    request.addHeader("Content-Type", "application/xml");
    request.addHeader("Content-Length", String.valueOf(aclAsXml.length));
    request.setContent(new ByteArrayInputStream(aclAsXml));
    
    invoke(request, voidResponseHandler, bucketName, key);
  }
  
  protected Signer createSigner(Request<?> request, String bucketName, String key)
  {
    return createSigner(request, bucketName, key, false);
  }
  
  protected Signer createSigner(Request<?> request, String bucketName, String key, boolean isAdditionalHeadRequestToFindRegion)
  {
    URI uri = clientOptions.isAccelerateModeEnabled() ? endpoint : request.getEndpoint();
    Signer signer = getSignerByURI(uri);
    if (!isSignerOverridden())
    {
      if (((signer instanceof AWSS3V4Signer)) && (bucketRegionShouldBeCached(request)))
      {
        String region = (String)bucketRegionCache.get(bucketName);
        if (region != null)
        {
          request.addHandlerContext(HandlerContextKey.SIGNING_REGION, region);
          resolveRequestEndpoint(request, bucketName, key, RuntimeHttpUtils.toUri(RegionUtils.getRegion(region).getServiceEndpoint("s3"), clientConfiguration));
          return updateSigV4SignerWithRegion((AWSS3V4Signer)signer, region);
        }
        if ((request.getOriginalRequest() instanceof GeneratePresignedUrlRequest))
        {
          String signerRegion = getSignerRegion();
          if (signerRegion == null) {
            return createSigV2Signer(request, bucketName, key);
          }
          return updateSigV4SignerWithRegion((AWSS3V4Signer)signer, signerRegion);
        }
        if (isAdditionalHeadRequestToFindRegion) {
          return updateSigV4SignerWithRegion((AWSS3V4Signer)signer, "us-east-1");
        }
      }
      String regionOverride = getSignerRegionOverride();
      if (regionOverride != null) {
        return updateSigV4SignerWithRegion(new AWSS3V4Signer(), regionOverride);
      }
    }
    if ((signer instanceof S3Signer)) {
      return createSigV2Signer(request, bucketName, key);
    }
    return signer;
  }
  
  private S3Signer createSigV2Signer(Request<?> request, String bucketName, String key)
  {
    String resourcePath = "/" + (bucketName != null ? bucketName + "/" : "") + (key != null ? key : "");
    
    return new S3Signer(request.getHttpMethod().toString(), resourcePath);
  }
  
  private AWSS3V4Signer updateSigV4SignerWithRegion(AWSS3V4Signer v4Signer, String region)
  {
    v4Signer.setServiceName(getServiceNameIntern());
    v4Signer.setRegionName(region);
    return v4Signer;
  }
  
  private String getSignerRegion()
  {
    String region = getSignerRegionOverride();
    if (region == null) {
      region = clientRegion;
    }
    return region;
  }
  
  private boolean isSignerOverridden()
  {
    return (clientConfiguration != null) && 
      (clientConfiguration.getSignerOverride() != null);
  }
  
  private boolean noExplicitRegionProvided(Request<?> request)
  {
    return (isStandardEndpoint(request.getEndpoint())) && 
      (getSignerRegion() == null);
  }
  
  private boolean isStandardEndpoint(URI endpoint)
  {
    return endpoint.getHost().endsWith("s3.amazonaws.com");
  }
  
  protected <T> void presignRequest(Request<T> request, HttpMethod methodName, String bucketName, String key, Date expiration, String subResource)
  {
    beforeRequest(request);
    
    String resourcePath = "/" + (bucketName != null ? bucketName + "/" : "") + (key != null ? SdkHttpUtils.urlEncode(key, true) : "") + (subResource != null ? "?" + subResource : "");
    
    resourcePath = resourcePath.replaceAll("(?<=/)/", "%2F");
    
    new S3QueryStringSigner(methodName.toString(), resourcePath, expiration)
      .sign(request, CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider).getCredentials());
    if (request.getHeaders().containsKey("x-amz-security-token"))
    {
      String value = (String)request.getHeaders().get("x-amz-security-token");
      request.addParameter("x-amz-security-token", value);
      request.getHeaders().remove("x-amz-security-token");
    }
  }
  
  private <T> void beforeRequest(Request<T> request)
  {
    if (requestHandler2s != null) {
      for (RequestHandler2 requestHandler2 : requestHandler2s) {
        requestHandler2.beforeRequest(request);
      }
    }
  }
  
  protected static void populateRequestMetadata(Request<?> request, ObjectMetadata metadata)
  {
    Map<String, Object> rawMetadata = metadata.getRawMetadata();
    if (rawMetadata != null) {
      for (Map.Entry<String, Object> entry : rawMetadata.entrySet()) {
        request.addHeader((String)entry.getKey(), entry.getValue().toString());
      }
    }
    Date httpExpiresDate = metadata.getHttpExpiresDate();
    if (httpExpiresDate != null) {
      request.addHeader("Expires", DateUtils.formatRFC822Date(httpExpiresDate));
    }
    Map<String, String> userMetadata = metadata.getUserMetadata();
    if (userMetadata != null) {
      for (Map.Entry<String, String> entry : userMetadata.entrySet())
      {
        String key = (String)entry.getKey();
        String value = (String)entry.getValue();
        if (key != null) {
          key = key.trim();
        }
        if (value != null) {
          value = value.trim();
        }
        request.addHeader("x-amz-meta-" + key, value);
      }
    }
  }
  
  protected static void populateRequesterPaysHeader(Request<?> request, boolean isRequesterPays)
  {
    if (isRequesterPays) {
      request.addHeader("x-amz-request-payer", "requester");
    }
  }
  
  private void populateRequestWithMfaDetails(Request<?> request, MultiFactorAuthentication mfa)
  {
    if (mfa == null) {
      return;
    }
    String endpoint = request.getEndpoint().toString();
    if (endpoint.startsWith("http://"))
    {
      String httpsEndpoint = endpoint.replace("http://", "https://");
      request.setEndpoint(URI.create(httpsEndpoint));
      log.info("Overriding current endpoint to use HTTPS as required by S3 for requests containing an MFA header");
    }
    request.addHeader("x-amz-mfa", mfa
      .getDeviceSerialNumber() + " " + mfa.getToken());
  }
  
  private void populateRequestWithCopyObjectParameters(Request<? extends AmazonWebServiceRequest> request, CopyObjectRequest copyObjectRequest)
  {
    String copySourceHeader = "/" + SdkHttpUtils.urlEncode(copyObjectRequest.getSourceBucketName(), true) + "/" + SdkHttpUtils.urlEncode(copyObjectRequest.getSourceKey(), true);
    if (copyObjectRequest.getSourceVersionId() != null) {
      copySourceHeader = copySourceHeader + "?versionId=" + copyObjectRequest.getSourceVersionId();
    }
    request.addHeader("x-amz-copy-source", copySourceHeader);
    
    addDateHeader(request, "x-amz-copy-source-if-modified-since", copyObjectRequest
      .getModifiedSinceConstraint());
    addDateHeader(request, "x-amz-copy-source-if-unmodified-since", copyObjectRequest
      .getUnmodifiedSinceConstraint());
    
    addStringListHeader(request, "x-amz-copy-source-if-match", copyObjectRequest
      .getMatchingETagConstraints());
    addStringListHeader(request, "x-amz-copy-source-if-none-match", copyObjectRequest
      .getNonmatchingETagConstraints());
    if (copyObjectRequest.getAccessControlList() != null) {
      addAclHeaders(request, copyObjectRequest.getAccessControlList());
    } else if (copyObjectRequest.getCannedAccessControlList() != null) {
      request.addHeader("x-amz-acl", copyObjectRequest
        .getCannedAccessControlList().toString());
    }
    if (copyObjectRequest.getStorageClass() != null) {
      request.addHeader("x-amz-storage-class", copyObjectRequest.getStorageClass());
    }
    if (copyObjectRequest.getRedirectLocation() != null) {
      request.addHeader("x-amz-website-redirect-location", copyObjectRequest.getRedirectLocation());
    }
    populateRequesterPaysHeader(request, copyObjectRequest.isRequesterPays());
    
    ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
    if (copyObjectRequest.getMetadataDirective() != null) {
      request.addHeader("x-amz-metadata-directive", copyObjectRequest.getMetadataDirective());
    } else if (newObjectMetadata != null) {
      request.addHeader("x-amz-metadata-directive", "REPLACE");
    }
    if (newObjectMetadata != null) {
      populateRequestMetadata(request, newObjectMetadata);
    }
    ObjectTagging newObjectTagging = copyObjectRequest.getNewObjectTagging();
    if (newObjectTagging != null)
    {
      request.addHeader("x-amz-tagging-directive", "REPLACE");
      request.addHeader("x-amz-tagging", urlEncodeTags(newObjectTagging));
    }
    populateSourceSSE_C(request, copyObjectRequest.getSourceSSECustomerKey());
    populateSSE_C(request, copyObjectRequest.getDestinationSSECustomerKey());
  }
  
  private static void populateRequestWithCopyPartParameters(Request<?> request, CopyPartRequest copyPartRequest)
  {
    String copySourceHeader = "/" + SdkHttpUtils.urlEncode(copyPartRequest.getSourceBucketName(), true) + "/" + SdkHttpUtils.urlEncode(copyPartRequest.getSourceKey(), true);
    if (copyPartRequest.getSourceVersionId() != null) {
      copySourceHeader = copySourceHeader + "?versionId=" + copyPartRequest.getSourceVersionId();
    }
    request.addHeader("x-amz-copy-source", copySourceHeader);
    
    addDateHeader(request, "x-amz-copy-source-if-modified-since", copyPartRequest
      .getModifiedSinceConstraint());
    addDateHeader(request, "x-amz-copy-source-if-unmodified-since", copyPartRequest
      .getUnmodifiedSinceConstraint());
    
    addStringListHeader(request, "x-amz-copy-source-if-match", copyPartRequest
      .getMatchingETagConstraints());
    addStringListHeader(request, "x-amz-copy-source-if-none-match", copyPartRequest
      .getNonmatchingETagConstraints());
    if ((copyPartRequest.getFirstByte() != null) && (copyPartRequest.getLastByte() != null))
    {
      String range = "bytes=" + copyPartRequest.getFirstByte() + "-" + copyPartRequest.getLastByte();
      request.addHeader("x-amz-copy-source-range", range);
    }
    populateSourceSSE_C(request, copyPartRequest.getSourceSSECustomerKey());
    populateSSE_C(request, copyPartRequest.getDestinationSSECustomerKey());
  }
  
  private static void populateSSE_C(Request<?> request, SSECustomerKey sseKey)
  {
    if (sseKey == null) {
      return;
    }
    addHeaderIfNotNull(request, "x-amz-server-side-encryption-customer-algorithm", sseKey
      .getAlgorithm());
    addHeaderIfNotNull(request, "x-amz-server-side-encryption-customer-key", sseKey
      .getKey());
    addHeaderIfNotNull(request, "x-amz-server-side-encryption-customer-key-MD5", sseKey
      .getMd5());
    if ((sseKey.getKey() != null) && 
      (sseKey.getMd5() == null))
    {
      String encryptionKey_b64 = sseKey.getKey();
      byte[] encryptionKey = Base64.decode(encryptionKey_b64);
      request.addHeader("x-amz-server-side-encryption-customer-key-MD5", 
        Md5Utils.md5AsBase64(encryptionKey));
    }
  }
  
  private static void populateSourceSSE_C(Request<?> request, SSECustomerKey sseKey)
  {
    if (sseKey == null) {
      return;
    }
    addHeaderIfNotNull(request, "x-amz-copy-source-server-side-encryption-customer-algorithm", sseKey
      .getAlgorithm());
    addHeaderIfNotNull(request, "x-amz-copy-source-server-side-encryption-customer-key", sseKey
      .getKey());
    addHeaderIfNotNull(request, "x-amz-copy-source-server-side-encryption-customer-key-MD5", sseKey
      .getMd5());
    if ((sseKey.getKey() != null) && 
      (sseKey.getMd5() == null))
    {
      String encryptionKey_b64 = sseKey.getKey();
      byte[] encryptionKey = Base64.decode(encryptionKey_b64);
      request.addHeader("x-amz-copy-source-server-side-encryption-customer-key-MD5", 
        Md5Utils.md5AsBase64(encryptionKey));
    }
  }
  
  private static void populateSSE_KMS(Request<?> request, SSEAwsKeyManagementParams sseParams)
  {
    if (sseParams != null)
    {
      addHeaderIfNotNull(request, "x-amz-server-side-encryption", sseParams
        .getEncryption());
      addHeaderIfNotNull(request, "x-amz-server-side-encryption-aws-kms-key-id", sseParams
      
        .getAwsKmsKeyId());
      addHeaderIfNotNull(request, "x-amz-server-side-encryption-context", sseParams.getAwsKmsEncryptionContext());
    }
  }
  
  private void addPartNumberIfNotNull(Request<?> request, Integer partNumber)
  {
    if (partNumber != null) {
      request.addParameter("partNumber", partNumber.toString());
    }
  }
  
  private static void addHeaderIfNotNull(Request<?> request, String header, String value)
  {
    if (value != null) {
      request.addHeader(header, value);
    }
  }
  
  private static void addParameterIfNotNull(Request<?> request, String paramName, Integer paramValue)
  {
    if (paramValue != null) {
      addParameterIfNotNull(request, paramName, paramValue.toString());
    }
  }
  
  private static void addParameterIfNotNull(Request<?> request, String paramName, String paramValue)
  {
    if (paramValue != null) {
      request.addParameter(paramName, paramValue);
    }
  }
  
  private static void addDateHeader(Request<?> request, String header, Date value)
  {
    if (value != null) {
      request.addHeader(header, ServiceUtils.formatRfc822Date(value));
    }
  }
  
  private static void addStringListHeader(Request<?> request, String header, List<String> values)
  {
    if ((values != null) && (!values.isEmpty())) {
      request.addHeader(header, ServiceUtils.join(values));
    }
  }
  
  private static void addResponseHeaderParameters(Request<?> request, ResponseHeaderOverrides responseHeaders)
  {
    if (responseHeaders != null)
    {
      if (responseHeaders.getCacheControl() != null) {
        request.addParameter("response-cache-control", responseHeaders.getCacheControl());
      }
      if (responseHeaders.getContentDisposition() != null) {
        request.addParameter("response-content-disposition", responseHeaders
          .getContentDisposition());
      }
      if (responseHeaders.getContentEncoding() != null) {
        request.addParameter("response-content-encoding", responseHeaders
          .getContentEncoding());
      }
      if (responseHeaders.getContentLanguage() != null) {
        request.addParameter("response-content-language", responseHeaders
          .getContentLanguage());
      }
      if (responseHeaders.getContentType() != null) {
        request.addParameter("response-content-type", responseHeaders.getContentType());
      }
      if (responseHeaders.getExpires() != null) {
        request.addParameter("response-expires", responseHeaders.getExpires());
      }
    }
  }
  
  public String getResourceUrl(String bucketName, String key)
  {
    try
    {
      return getUrl(bucketName, key).toString();
    }
    catch (Exception e) {}
    return null;
  }
  
  public URL getUrl(String bucketName, String key)
  {
    Request<?> request = new DefaultRequest("Amazon S3");
    resolveRequestEndpoint(request, bucketName, key, endpoint);
    return ServiceUtils.convertRequestToUrl(request, false, false);
  }
  
  public synchronized com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region getRegion()
  {
    String authority = endpoint.getAuthority();
    if ("s3.amazonaws.com".equals(authority)) {
      return com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region.US_Standard;
    }
    Matcher m = com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region.S3_REGIONAL_ENDPOINT_PATTERN.matcher(authority);
    if (m.matches()) {
      return com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region.fromValue(m.group(1));
    }
    throw new IllegalStateException("S3 client with invalid S3 endpoint configured: " + authority);
  }
  
  public String getRegionName()
  {
    String authority = endpoint.getAuthority();
    if ("s3.amazonaws.com".equals(authority)) {
      return "us-east-1";
    }
    Matcher m = com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region.S3_REGIONAL_ENDPOINT_PATTERN.matcher(authority);
    try
    {
      m.matches();
      return RegionUtils.getRegion(m.group(1)).getName();
    }
    catch (Exception e)
    {
      throw new IllegalStateException("No valid region has been specified. Unable to return region name", e);
    }
  }
  
  protected <X extends AmazonWebServiceRequest> Request<X> createRequest(String bucketName, String key, X originalRequest, HttpMethodName httpMethod)
  {
    return createRequest(bucketName, key, originalRequest, httpMethod, endpoint);
  }
  
  protected <X extends AmazonWebServiceRequest> Request<X> createRequest(String bucketName, String key, X originalRequest, HttpMethodName httpMethod, URI endpoint)
  {
    if ((clientOptions.isAccelerateModeEnabled()) && (!(originalRequest instanceof S3AccelerateUnsupported))) {
      if (clientOptions.isDualstackEnabled()) {
        endpoint = RuntimeHttpUtils.toUri("s3-accelerate.dualstack.amazonaws.com", clientConfiguration);
      } else {
        endpoint = RuntimeHttpUtils.toUri("s3-accelerate.amazonaws.com", clientConfiguration);
      }
    }
    Request<X> request = new DefaultRequest(originalRequest, "Amazon S3");
    request.setHttpMethod(httpMethod);
    request.addHandlerContext(S3HandlerContextKeys.IS_CHUNKED_ENCODING_DISABLED, 
      Boolean.valueOf(clientOptions.isChunkedEncodingDisabled()));
    request.addHandlerContext(S3HandlerContextKeys.IS_PAYLOAD_SIGNING_ENABLED, 
      Boolean.valueOf(clientOptions.isPayloadSigningEnabled()));
    resolveRequestEndpoint(request, bucketName, key, endpoint);
    request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
    request.addHandlerContext(HandlerContextKey.SERVICE_ID, "S3");
    return request;
  }
  
  private void resolveRequestEndpoint(Request<?> request, String bucketName, String key, URI endpoint)
  {
    ServiceEndpointBuilder builder = getBuilder(endpoint, endpoint.getScheme(), false);
    buildEndpointResolver(builder, bucketName, key).resolveRequestEndpoint(request);
  }
  
  private S3RequestEndpointResolver buildDefaultEndpointResolver(String protocol, String bucketName, String key)
  {
    ServiceEndpointBuilder builder = getBuilder(endpoint, protocol, true);
    return new S3RequestEndpointResolver(builder, clientOptions.isPathStyleAccess(), bucketName, key);
  }
  
  private ServiceEndpointBuilder getBuilder(URI endpoint, String protocol, boolean useDefaultBuilder)
  {
    if ((clientOptions.isDualstackEnabled()) && (!clientOptions.isAccelerateModeEnabled())) {
      return new DualstackEndpointBuilder(getServiceNameIntern(), protocol, getRegion().toAWSRegion());
    }
    if (useDefaultBuilder) {
      return new DefaultServiceEndpointBuilder(getServiceName(), protocol);
    }
    return new IdentityEndpointBuilder(endpoint);
  }
  
  public PresignedUrlDownloadResult download(PresignedUrlDownloadRequest presignedUrlDownloadRequest)
    throws SdkClientException
  {
    ValidationUtils.assertNotNull(presignedUrlDownloadRequest.getPresignedUrl(), "Presigned URL");
    ProgressListener listener = presignedUrlDownloadRequest.getGeneralProgressListener();
    
    Request<PresignedUrlDownloadRequest> request = createRequestForPresignedUrl(presignedUrlDownloadRequest, HttpMethodName.GET, presignedUrlDownloadRequest
      .getPresignedUrl());
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetObject");
    
    long[] range = presignedUrlDownloadRequest.getRange();
    if (range != null) {
      request.addHeader("Range", "bytes=" + Long.toString(range[0]) + "-" + Long.toString(range[1]));
    }
    try
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_STARTED_EVENT);
      
      S3Object s3Object = (S3Object)client.execute(request, new S3ObjectResponseHandler(), errorResponseHandler, createExecutionContext(AmazonWebServiceRequest.NOOP, new NoOpSignerProvider()), requestConfigWithSkipAppendUriPath(request)).getAwsResponse();
      
      boolean skipClientSideValidation = skipMd5CheckStrategy.skipClientSideValidation(presignedUrlDownloadRequest, s3Object
        .getObjectMetadata());
      postProcessS3Object(s3Object, skipClientSideValidation, listener);
      
      return new PresignedUrlDownloadResult().withS3Object(s3Object);
    }
    catch (AmazonS3Exception ase)
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
      throw ase;
    }
  }
  
  public void download(final PresignedUrlDownloadRequest presignedUrlDownloadRequest, File destinationFile)
    throws SdkClientException
  {
    ValidationUtils.assertNotNull(destinationFile, "Destination file");
    
    ServiceUtils.retryableDownloadS3ObjectToFile(destinationFile, new ServiceUtils.RetryableS3DownloadTask()
    {
      public S3Object getS3ObjectStream()
      {
        return download(presignedUrlDownloadRequest).getS3Object();
      }
      
      public boolean needIntegrityCheck()
      {
        return !skipMd5CheckStrategy.skipClientSideValidationPerRequest(presignedUrlDownloadRequest);
      }
    }, false);
  }
  
  public PresignedUrlUploadResult upload(PresignedUrlUploadRequest presignedUrlUploadRequest)
  {
    presignedUrlUploadRequest = (PresignedUrlUploadRequest)beforeClientExecution(presignedUrlUploadRequest);
    rejectNull(presignedUrlUploadRequest, "The PresignedUrlUploadRequest object cannot be null");
    rejectNull(presignedUrlUploadRequest.getPresignedUrl(), "Presigned URL");
    
    File file = presignedUrlUploadRequest.getFile();
    InputStream isOrig = presignedUrlUploadRequest.getInputStream();
    ProgressListener listener = presignedUrlUploadRequest.getGeneralProgressListener();
    
    ObjectMetadata metadata = presignedUrlUploadRequest.getMetadata();
    if (metadata == null) {
      metadata = new ObjectMetadata();
    }
    Request<PresignedUrlUploadRequest> request = createRequestForPresignedUrl(presignedUrlUploadRequest, presignedUrlUploadRequest
      .getHttpMethodName(), presignedUrlUploadRequest
      .getPresignedUrl());
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutObject");
    
    Integer bufsize = Constants.getS3StreamBufferSize();
    if (bufsize != null)
    {
      AmazonWebServiceRequest awsreq = request.getOriginalRequest();
      
      awsreq.getRequestClientOptions()
        .setReadLimit(bufsize.intValue());
    }
    return (PresignedUrlUploadResult)uploadObject(isOrig, file, metadata, listener, request, presignedUrlUploadRequest, true, skipMd5CheckStrategy
    
      .skipClientSideValidationPerRequest(presignedUrlUploadRequest), new PresignedUrlUploadStrategy(presignedUrlUploadRequest
      .getPresignedUrl(), null), 
      !isSigV2PresignedUrl(presignedUrlUploadRequest.getPresignedUrl()));
  }
  
  private RequestConfig requestConfigWithSkipAppendUriPath(Request request)
  {
    RequestConfig config = new AmazonWebServiceRequestAdapter(request.getOriginalRequest());
    config.getRequestClientOptions().setSkipAppendUriPath(true);
    return config;
  }
  
  private <X extends AmazonWebServiceRequest> Request<X> createRequestForPresignedUrl(X originalRequest, HttpMethodName httpMethod, URL endpoint)
  {
    Request<X> request = new DefaultRequest(originalRequest, "Amazon S3");
    request.setHttpMethod(httpMethod);
    try
    {
      request.setEndpoint(endpoint.toURI());
    }
    catch (URISyntaxException e)
    {
      throw new SdkClientException(e);
    }
    if (originalRequest.getCustomRequestHeaders() != null) {
      for (Map.Entry<String, String> entry : originalRequest.getCustomRequestHeaders().entrySet()) {
        request.addHeader((String)entry.getKey(), (String)entry.getValue());
      }
    }
    if ((request.getHeaders().get("Content-Type") == null) && (isSigV2PresignedUrl(endpoint))) {
      request.addHeader("Content-Type", "");
    }
    request.addHandlerContext(S3HandlerContextKeys.IS_CHUNKED_ENCODING_DISABLED, 
      Boolean.valueOf(clientOptions.isChunkedEncodingDisabled()));
    request.addHandlerContext(S3HandlerContextKeys.IS_PAYLOAD_SIGNING_ENABLED, 
      Boolean.valueOf(clientOptions.isPayloadSigningEnabled()));
    request.addHandlerContext(HandlerContextKey.SERVICE_ID, "S3");
    
    return request;
  }
  
  private boolean isSigV2PresignedUrl(URL presignedUrl)
  {
    String url = presignedUrl.toString();
    return (url.contains("AWSAccessKeyId=")) && (!presignedUrl.toString().contains("X-Amz-Algorithm=AWS4-HMAC-SHA256"));
  }
  
  private S3RequestEndpointResolver buildEndpointResolver(ServiceEndpointBuilder serviceEndpointBuilder, String bucketName, String key)
  {
    return new S3RequestEndpointResolver(serviceEndpointBuilder, clientOptions.isPathStyleAccess(), bucketName, key);
  }
  
  protected final SignerProvider createSignerProvider(Signer signer)
  {
    return new S3SignerProvider(this, signer);
  }
  
  private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, InputStream> unmarshaller, String bucketName, String key)
  {
    return (X)invoke(request, new S3XmlResponseHandler(unmarshaller), bucketName, key);
  }
  
  private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, String bucket, String key)
  {
    return (X)invoke(request, responseHandler, bucket, key, false);
  }
  
  private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, String bucket, String key, boolean isAdditionalHeadRequestToFindRegion)
  {
    AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
    checkHttps(originalRequest);
    S3SignerProvider signerProvider = new S3SignerProvider(this, getSigner());
    ExecutionContext executionContext = createExecutionContext(originalRequest, signerProvider);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    
    request.setAWSRequestMetrics(awsRequestMetrics);
    
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Response<X> response = null;
    try
    {
      request.setTimeOffset(timeOffset);
      if (!request.getHeaders().containsKey("Content-Type")) {
        request.addHeader("Content-Type", "application/octet-stream");
      }
      if ((!isAdditionalHeadRequestToFindRegion) && (shouldPerformHeadRequestToFindRegion(request, bucket))) {
        fetchRegionFromCache(bucket);
      }
      Signer signer = createSigner(request, bucket, key, isAdditionalHeadRequestToFindRegion);
      signerProvider.setSigner(signer);
      if ((isSignerOverridden()) && (!(signer instanceof AWSS3V4Signer))) {
        executionContext.setAuthErrorRetryStrategy(new S3V4AuthErrorRetryStrategy(
          buildDefaultEndpointResolver(getProtocol(request), bucket, key)));
      }
      executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));
      
      validateRequestBeforeTransmit(request);
      response = client.execute(request, responseHandler, errorResponseHandler, executionContext);
      
      return (X)response.getAwsResponse();
    }
    catch (ResetException ex)
    {
      ex.setExtraInfo("If the request involves an input stream, the maximum stream buffer size can be configured via request.getRequestClientOptions().setReadLimit(int)");
      throw ex;
    }
    catch (AmazonS3Exception ase)
    {
      if ((ase.getStatusCode() == 301) && 
        (ase.getAdditionalDetails() != null))
      {
        String region = (String)ase.getAdditionalDetails().get("x-amz-bucket-region");
        bucketRegionCache.put(bucket, region);
        ase.setErrorMessage("The bucket is in this region: " + region + ". Please use this region to retry the request");
      }
      throw ase;
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  private void validateRequestBeforeTransmit(Request<?> request)
  {
    boolean implicitCrossRegionForbidden = areImplicitGlobalClientsDisabled();
    boolean explicitCrossRegionEnabled = clientOptions.isForceGlobalBucketAccessEnabled();
    if ((noExplicitRegionProvided(request)) && (implicitCrossRegionForbidden) && (!explicitCrossRegionEnabled))
    {
      String error = String.format("While the %s system property is enabled, Amazon S3 clients cannot be used without first configuring a region or explicitly enabling global bucket access discovery in the S3 client builder.", new Object[] { "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disableImplicitGlobalClients" });
      
      throw new IllegalStateException(error);
    }
  }
  
  private boolean areImplicitGlobalClientsDisabled()
  {
    String setting = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disableImplicitGlobalClients");
    return (setting != null) && (!setting.equals("false"));
  }
  
  private boolean shouldPerformHeadRequestToFindRegion(Request<?> request, String bucket)
  {
    return (bucket != null) && 
      (!(request.getOriginalRequest() instanceof CreateBucketRequest)) && 
      (bucketRegionShouldBeCached(request));
  }
  
  private boolean bucketRegionShouldBeCached(Request<?> request)
  {
    return (clientOptions.isForceGlobalBucketAccessEnabled()) || (noExplicitRegionProvided(request));
  }
  
  public void enableRequesterPays(String bucketName)
  {
    RequestPaymentConfiguration configuration = new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.Requester);
    
    setBucketRequestPayment(new SetRequestPaymentConfigurationRequest(bucketName, configuration));
  }
  
  public void disableRequesterPays(String bucketName)
  {
    RequestPaymentConfiguration configuration = new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.BucketOwner);
    
    setBucketRequestPayment(new SetRequestPaymentConfigurationRequest(bucketName, configuration));
  }
  
  public boolean isRequesterPaysEnabled(String bucketName)
  {
    RequestPaymentConfiguration configuration = getBucketRequestPayment(new GetRequestPaymentConfigurationRequest(bucketName));
    
    return configuration.getPayer() == RequestPaymentConfiguration.Payer.Requester;
  }
  
  private void setBucketRequestPayment(SetRequestPaymentConfigurationRequest setRequestPaymentConfigurationRequest)
  {
    String bucketName = setRequestPaymentConfigurationRequest.getBucketName();
    
    RequestPaymentConfiguration configuration = setRequestPaymentConfigurationRequest.getConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified while setting the Requester Pays.");
    
    rejectNull(configuration, "The request payment configuration parameter must be specified when setting the Requester Pays.");
    
    Request<SetRequestPaymentConfigurationRequest> request = createRequest(bucketName, null, setRequestPaymentConfigurationRequest, HttpMethodName.PUT);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketRequestPayment");
    request.addParameter("requestPayment", null);
    request.addHeader("Content-Type", "application/xml");
    
    byte[] bytes = requestPaymentConfigurationXmlFactory.convertToXmlByteArray(configuration);
    request.setContent(new ByteArrayInputStream(bytes));
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  private RequestPaymentConfiguration getBucketRequestPayment(GetRequestPaymentConfigurationRequest getRequestPaymentConfigurationRequest)
  {
    String bucketName = getRequestPaymentConfigurationRequest.getBucketName();
    
    rejectNull(bucketName, "The bucket name parameter must be specified while getting the Request Payment Configuration.");
    
    Request<GetRequestPaymentConfigurationRequest> request = createRequest(bucketName, null, getRequestPaymentConfigurationRequest, HttpMethodName.GET);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketRequestPayment");
    request.addParameter("requestPayment", null);
    request.addHeader("Content-Type", "application/xml");
    
    return (RequestPaymentConfiguration)invoke(request, new Unmarshallers.RequestPaymentConfigurationUnmarshaller(), bucketName, null);
  }
  
  private void setZeroContentLength(Request<?> req)
  {
    req.addHeader("Content-Length", String.valueOf(0));
  }
  
  private void checkHttps(AmazonWebServiceRequest req)
  {
    if ((req instanceof SSECustomerKeyProvider))
    {
      SSECustomerKeyProvider p = (SSECustomerKeyProvider)req;
      if (p.getSSECustomerKey() != null) {
        assertHttps();
      }
    }
    else if ((req instanceof CopyObjectRequest))
    {
      CopyObjectRequest cor = (CopyObjectRequest)req;
      if ((cor.getSourceSSECustomerKey() != null) || 
        (cor.getDestinationSSECustomerKey() != null)) {
        assertHttps();
      }
    }
    else if ((req instanceof CopyPartRequest))
    {
      CopyPartRequest cpr = (CopyPartRequest)req;
      if ((cpr.getSourceSSECustomerKey() != null) || 
        (cpr.getDestinationSSECustomerKey() != null)) {
        assertHttps();
      }
    }
    if ((req instanceof SSEAwsKeyManagementParamsProvider))
    {
      SSEAwsKeyManagementParamsProvider p = (SSEAwsKeyManagementParamsProvider)req;
      if (p.getSSEAwsKeyManagementParams() != null) {
        assertHttps();
      }
    }
  }
  
  private void assertHttps()
  {
    URI endpoint = this.endpoint;
    String scheme = endpoint == null ? null : endpoint.getScheme();
    if (!Protocol.HTTPS.toString().equalsIgnoreCase(scheme)) {
      throw new IllegalArgumentException("HTTPS must be used when sending customer encryption keys (SSE-C) to S3, in order to protect your encryption keys.");
    }
  }
  
  synchronized URI getEndpoint()
  {
    return endpoint;
  }
  
  private static String getProtocol(Request<?> request)
  {
    if ((request == null) || (request.getEndpoint() == null)) {
      return null;
    }
    return request.getEndpoint().getScheme();
  }
  
  protected final InitiateMultipartUploadRequest newInitiateMultipartUploadRequest(UploadObjectRequest req)
  {
    return 
    
      (InitiateMultipartUploadRequest)new InitiateMultipartUploadRequest(req.getBucketName(), req.getKey(), req.getMetadata()).withRedirectLocation(req.getRedirectLocation()).withSSEAwsKeyManagementParams(req.getSSEAwsKeyManagementParams()).withSSECustomerKey(req.getSSECustomerKey()).withStorageClass(req.getStorageClass()).withAccessControlList(req.getAccessControlList()).withCannedACL(req.getCannedAcl()).withGeneralProgressListener(req.getGeneralProgressListener()).withRequestMetricCollector(req.getRequestMetricCollector());
  }
  
  private void putLocalObject(UploadObjectRequest reqIn, OutputStream os)
    throws IOException
  {
    UploadObjectRequest req = reqIn.clone();
    
    File fileOrig = req.getFile();
    InputStream isOrig = req.getInputStream();
    if (isOrig == null)
    {
      if (fileOrig == null) {
        throw new IllegalArgumentException("Either a file lor input stream must be specified");
      }
      req.setInputStream(new FileInputStream(fileOrig));
      req.setFile(null);
    }
    try
    {
      IOUtils.copy(req.getInputStream(), os);
    }
    finally
    {
      S3DataSource.Utils.cleanupDataSource(req, fileOrig, isOrig, req
        .getInputStream(), log);
      IOUtils.closeQuietly(os, log);
    }
  }
  
  CompleteMultipartUploadResult uploadObject(UploadObjectRequest req)
    throws IOException, InterruptedException, ExecutionException
  {
    ExecutorService es = req.getExecutorService();
    boolean defaultExecutorService = es == null;
    if (es == null) {
      es = Executors.newFixedThreadPool(clientConfiguration.getMaxConnections());
    }
    UploadObjectObserver observer = req.getUploadObjectObserver();
    if (observer == null) {
      observer = new UploadObjectObserver();
    }
    observer.init(req, this, this, es);
    
    observer.onUploadInitiation(req);
    List<PartETag> partETags = new ArrayList();
    MultiFileOutputStream mfos = req.getMultiFileOutputStream();
    if (mfos == null) {
      mfos = new MultiFileOutputStream();
    }
    try
    {
      mfos.init(observer, req.getPartSize(), req.getDiskLimit());
      
      putLocalObject(req, mfos);
      for (Future<UploadPartResult> future : observer.getFutures())
      {
        UploadPartResult partResult = (UploadPartResult)future.get();
        partETags.add(new PartETag(partResult.getPartNumber(), partResult.getETag()));
      }
    }
    finally
    {
      if (defaultExecutorService) {
        es.shutdownNow();
      }
      mfos.cleanup();
    }
    return observer.onCompletion(partETags);
  }
  
  public void setBucketReplicationConfiguration(String bucketName, BucketReplicationConfiguration configuration)
    throws AmazonServiceException, SdkClientException
  {
    setBucketReplicationConfiguration(new SetBucketReplicationConfigurationRequest(bucketName, configuration));
  }
  
  public void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest setBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    setBucketReplicationConfigurationRequest = (SetBucketReplicationConfigurationRequest)beforeClientExecution(setBucketReplicationConfigurationRequest);
    rejectNull(setBucketReplicationConfigurationRequest, "The set bucket replication configuration request object must be specified.");
    
    String bucketName = setBucketReplicationConfigurationRequest.getBucketName();
    
    BucketReplicationConfiguration bucketReplicationConfiguration = setBucketReplicationConfigurationRequest.getReplicationConfiguration();
    
    rejectNull(bucketName, "The bucket name parameter must be specified when setting replication configuration.");
    
    rejectNull(bucketReplicationConfiguration, "The replication configuration parameter must be specified when setting replication configuration.");
    
    Request<SetBucketReplicationConfigurationRequest> request = createRequest(bucketName, null, setBucketReplicationConfigurationRequest, HttpMethodName.PUT);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketReplication");
    request.addParameter("replication", null);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(bucketReplicationConfiguration);
    
    addHeaderIfNotNull(request, "x-amz-bucket-object-lock-token", setBucketReplicationConfigurationRequest.getToken());
    request.addHeader("Content-Length", String.valueOf(bytes.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(bytes));
    try
    {
      request.addHeader("Content-MD5", 
        BinaryUtils.toBase64(Md5Utils.computeMD5Hash(bytes)));
    }
    catch (Exception e)
    {
      throw new SdkClientException("Not able to compute MD5 of the replication rule configuration. Exception Message : " + e.getMessage(), e);
    }
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public BucketReplicationConfiguration getBucketReplicationConfiguration(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketReplicationConfiguration(new GetBucketReplicationConfigurationRequest(bucketName));
  }
  
  public BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest getBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    getBucketReplicationConfigurationRequest = (GetBucketReplicationConfigurationRequest)beforeClientExecution(getBucketReplicationConfigurationRequest);
    rejectNull(getBucketReplicationConfigurationRequest, "The bucket request parameter must be specified when retrieving replication configuration");
    
    String bucketName = getBucketReplicationConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket request must specify a bucket name when retrieving replication configuration");
    
    Request<GetBucketReplicationConfigurationRequest> request = createRequest(bucketName, null, getBucketReplicationConfigurationRequest, HttpMethodName.GET);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketReplication");
    request.addParameter("replication", null);
    
    return (BucketReplicationConfiguration)invoke(request, new Unmarshallers.BucketReplicationConfigurationUnmarshaller(), bucketName, null);
  }
  
  public void deleteBucketReplicationConfiguration(String bucketName)
    throws AmazonServiceException, SdkClientException
  {
    deleteBucketReplicationConfiguration(new DeleteBucketReplicationConfigurationRequest(bucketName));
  }
  
  public void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest deleteBucketReplicationConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    deleteBucketReplicationConfigurationRequest = (DeleteBucketReplicationConfigurationRequest)beforeClientExecution(deleteBucketReplicationConfigurationRequest);
    String bucketName = deleteBucketReplicationConfigurationRequest.getBucketName();
    rejectNull(bucketName, "The bucket name parameter must be specified when deleting replication configuration");
    
    Request<DeleteBucketReplicationConfigurationRequest> request = createRequest(bucketName, null, deleteBucketReplicationConfigurationRequest, HttpMethodName.DELETE);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketReplication");
    request.addParameter("replication", null);
    
    invoke(request, voidResponseHandler, bucketName, null);
  }
  
  public DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return deleteBucketMetricsConfiguration(new DeleteBucketMetricsConfigurationRequest(bucketName, id));
  }
  
  public DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    deleteBucketMetricsConfigurationRequest = (DeleteBucketMetricsConfigurationRequest)beforeClientExecution(deleteBucketMetricsConfigurationRequest);
    rejectNull(deleteBucketMetricsConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(deleteBucketMetricsConfigurationRequest.getBucketName(), "BucketName");
    String id = ValidationUtils.assertStringNotEmpty(deleteBucketMetricsConfigurationRequest.getId(), "Metrics Id");
    
    Request<DeleteBucketMetricsConfigurationRequest> request = createRequest(bucketName, null, deleteBucketMetricsConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketMetricsConfiguration");
    request.addParameter("metrics", null);
    request.addParameter("id", id);
    
    return (DeleteBucketMetricsConfigurationResult)invoke(request, new Unmarshallers.DeleteBucketMetricsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketMetricsConfiguration(new GetBucketMetricsConfigurationRequest(bucketName, id));
  }
  
  public GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    getBucketMetricsConfigurationRequest = (GetBucketMetricsConfigurationRequest)beforeClientExecution(getBucketMetricsConfigurationRequest);
    rejectNull(getBucketMetricsConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(getBucketMetricsConfigurationRequest.getBucketName(), "BucketName");
    String id = ValidationUtils.assertStringNotEmpty(getBucketMetricsConfigurationRequest.getId(), "Metrics Id");
    
    Request<GetBucketMetricsConfigurationRequest> request = createRequest(bucketName, null, getBucketMetricsConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketMetricsConfiguration");
    request.addParameter("metrics", null);
    request.addParameter("id", id);
    
    return (GetBucketMetricsConfigurationResult)invoke(request, new Unmarshallers.GetBucketMetricsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(String bucketName, MetricsConfiguration metricsConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    return setBucketMetricsConfiguration(new SetBucketMetricsConfigurationRequest(bucketName, metricsConfiguration));
  }
  
  public SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(SetBucketMetricsConfigurationRequest setBucketMetricsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    setBucketMetricsConfigurationRequest = (SetBucketMetricsConfigurationRequest)beforeClientExecution(setBucketMetricsConfigurationRequest);
    new SetBucketMetricsConfigurationRequest();
    rejectNull(setBucketMetricsConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(setBucketMetricsConfigurationRequest.getBucketName(), "BucketName");
    MetricsConfiguration metricsConfiguration = (MetricsConfiguration)ValidationUtils.assertNotNull(setBucketMetricsConfigurationRequest
      .getMetricsConfiguration(), "Metrics Configuration");
    String id = (String)ValidationUtils.assertNotNull(metricsConfiguration.getId(), "Metrics Id");
    
    Request<SetBucketMetricsConfigurationRequest> request = createRequest(bucketName, null, setBucketMetricsConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketMetricsConfiguration");
    request.addParameter("metrics", null);
    request.addParameter("id", id);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(metricsConfiguration);
    request.addHeader("Content-Length", String.valueOf(bytes.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(bytes));
    
    return (SetBucketMetricsConfigurationResult)invoke(request, new Unmarshallers.SetBucketMetricsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public ListBucketMetricsConfigurationsResult listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest)
    throws AmazonServiceException, SdkClientException
  {
    listBucketMetricsConfigurationsRequest = (ListBucketMetricsConfigurationsRequest)beforeClientExecution(listBucketMetricsConfigurationsRequest);
    rejectNull(listBucketMetricsConfigurationsRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(listBucketMetricsConfigurationsRequest.getBucketName(), "BucketName");
    
    Request<ListBucketMetricsConfigurationsRequest> request = createRequest(bucketName, null, listBucketMetricsConfigurationsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBucketMetricsConfigurations");
    request.addParameter("metrics", null);
    addParameterIfNotNull(request, "continuation-token", listBucketMetricsConfigurationsRequest.getContinuationToken());
    
    return (ListBucketMetricsConfigurationsResult)invoke(request, new Unmarshallers.ListBucketMetricsConfigurationsUnmarshaller(), bucketName, null);
  }
  
  public DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return deleteBucketAnalyticsConfiguration(new DeleteBucketAnalyticsConfigurationRequest(bucketName, id));
  }
  
  public DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    deleteBucketAnalyticsConfigurationRequest = (DeleteBucketAnalyticsConfigurationRequest)beforeClientExecution(deleteBucketAnalyticsConfigurationRequest);
    rejectNull(deleteBucketAnalyticsConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(deleteBucketAnalyticsConfigurationRequest
      .getBucketName(), "BucketName");
    String id = ValidationUtils.assertStringNotEmpty(deleteBucketAnalyticsConfigurationRequest
      .getId(), "Analytics Id");
    
    Request<DeleteBucketAnalyticsConfigurationRequest> request = createRequest(bucketName, null, deleteBucketAnalyticsConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketAnalyticsConfiguration");
    request.addParameter("analytics", null);
    request.addParameter("id", id);
    
    return (DeleteBucketAnalyticsConfigurationResult)invoke(request, new Unmarshallers.DeleteBucketAnalyticsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketAnalyticsConfiguration(new GetBucketAnalyticsConfigurationRequest(bucketName, id));
  }
  
  public GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    getBucketAnalyticsConfigurationRequest = (GetBucketAnalyticsConfigurationRequest)beforeClientExecution(getBucketAnalyticsConfigurationRequest);
    
    rejectNull(getBucketAnalyticsConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(getBucketAnalyticsConfigurationRequest
      .getBucketName(), "BucketName");
    String id = ValidationUtils.assertStringNotEmpty(getBucketAnalyticsConfigurationRequest
      .getId(), "Analytics Id");
    
    Request<GetBucketAnalyticsConfigurationRequest> request = createRequest(bucketName, null, getBucketAnalyticsConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketAnalyticsConfiguration");
    request.addParameter("analytics", null);
    request.addParameter("id", id);
    
    return (GetBucketAnalyticsConfigurationResult)invoke(request, new Unmarshallers.GetBucketAnalyticsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(String bucketName, AnalyticsConfiguration analyticsConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    return setBucketAnalyticsConfiguration(new SetBucketAnalyticsConfigurationRequest(bucketName, analyticsConfiguration));
  }
  
  public SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(SetBucketAnalyticsConfigurationRequest setBucketAnalyticsConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    setBucketAnalyticsConfigurationRequest = (SetBucketAnalyticsConfigurationRequest)beforeClientExecution(setBucketAnalyticsConfigurationRequest);
    rejectNull(setBucketAnalyticsConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(setBucketAnalyticsConfigurationRequest
      .getBucketName(), "BucketName");
    AnalyticsConfiguration analyticsConfiguration = (AnalyticsConfiguration)ValidationUtils.assertNotNull(setBucketAnalyticsConfigurationRequest
      .getAnalyticsConfiguration(), "Analytics Configuration");
    String id = (String)ValidationUtils.assertNotNull(analyticsConfiguration.getId(), "Analytics Id");
    
    Request<SetBucketAnalyticsConfigurationRequest> request = createRequest(bucketName, null, setBucketAnalyticsConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketAnalyticsConfiguration");
    request.addParameter("analytics", null);
    request.addParameter("id", id);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(analyticsConfiguration);
    request.addHeader("Content-Length", String.valueOf(bytes.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(bytes));
    
    return (SetBucketAnalyticsConfigurationResult)invoke(request, new Unmarshallers.SetBucketAnalyticsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public ListBucketAnalyticsConfigurationsResult listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest)
    throws AmazonServiceException, SdkClientException
  {
    listBucketAnalyticsConfigurationsRequest = (ListBucketAnalyticsConfigurationsRequest)beforeClientExecution(listBucketAnalyticsConfigurationsRequest);
    rejectNull(listBucketAnalyticsConfigurationsRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(listBucketAnalyticsConfigurationsRequest
      .getBucketName(), "BucketName");
    
    Request<ListBucketAnalyticsConfigurationsRequest> request = createRequest(bucketName, null, listBucketAnalyticsConfigurationsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBucketAnalyticsConfigurations");
    request.addParameter("analytics", null);
    addParameterIfNotNull(request, "continuation-token", listBucketAnalyticsConfigurationsRequest.getContinuationToken());
    
    return (ListBucketAnalyticsConfigurationsResult)invoke(request, new Unmarshallers.ListBucketAnalyticsConfigurationUnmarshaller(), bucketName, null);
  }
  
  public DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return deleteBucketInventoryConfiguration(new DeleteBucketInventoryConfigurationRequest(bucketName, id));
  }
  
  public DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    deleteBucketInventoryConfigurationRequest = (DeleteBucketInventoryConfigurationRequest)beforeClientExecution(deleteBucketInventoryConfigurationRequest);
    rejectNull(deleteBucketInventoryConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(deleteBucketInventoryConfigurationRequest.getBucketName(), "BucketName");
    String id = ValidationUtils.assertStringNotEmpty(deleteBucketInventoryConfigurationRequest.getId(), "Inventory id");
    
    Request<DeleteBucketInventoryConfigurationRequest> request = createRequest(bucketName, null, deleteBucketInventoryConfigurationRequest, HttpMethodName.DELETE);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBucketInventoryConfiguration");
    request.addParameter("inventory", null);
    request.addParameter("id", id);
    
    return (DeleteBucketInventoryConfigurationResult)invoke(request, new Unmarshallers.DeleteBucketInventoryConfigurationUnmarshaller(), bucketName, null);
  }
  
  public GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(String bucketName, String id)
    throws AmazonServiceException, SdkClientException
  {
    return getBucketInventoryConfiguration(new GetBucketInventoryConfigurationRequest(bucketName, id));
  }
  
  public GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    getBucketInventoryConfigurationRequest = (GetBucketInventoryConfigurationRequest)beforeClientExecution(getBucketInventoryConfigurationRequest);
    rejectNull(getBucketInventoryConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(getBucketInventoryConfigurationRequest.getBucketName(), "BucketName");
    String id = ValidationUtils.assertStringNotEmpty(getBucketInventoryConfigurationRequest.getId(), "Inventory id");
    
    Request<GetBucketInventoryConfigurationRequest> request = createRequest(bucketName, null, getBucketInventoryConfigurationRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBucketInventoryConfiguration");
    request.addParameter("inventory", null);
    request.addParameter("id", id);
    
    return (GetBucketInventoryConfigurationResult)invoke(request, new Unmarshallers.GetBucketInventoryConfigurationUnmarshaller(), bucketName, null);
  }
  
  public SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(String bucketName, InventoryConfiguration inventoryConfiguration)
    throws AmazonServiceException, SdkClientException
  {
    return setBucketInventoryConfiguration(new SetBucketInventoryConfigurationRequest(bucketName, inventoryConfiguration));
  }
  
  public SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(SetBucketInventoryConfigurationRequest setBucketInventoryConfigurationRequest)
    throws AmazonServiceException, SdkClientException
  {
    setBucketInventoryConfigurationRequest = (SetBucketInventoryConfigurationRequest)beforeClientExecution(setBucketInventoryConfigurationRequest);
    rejectNull(setBucketInventoryConfigurationRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(setBucketInventoryConfigurationRequest.getBucketName(), "BucketName");
    InventoryConfiguration inventoryConfiguration = (InventoryConfiguration)ValidationUtils.assertNotNull(setBucketInventoryConfigurationRequest.getInventoryConfiguration(), "InventoryConfiguration");
    
    String id = (String)ValidationUtils.assertNotNull(inventoryConfiguration.getId(), "Inventory id");
    
    Request<SetBucketInventoryConfigurationRequest> request = createRequest(bucketName, null, setBucketInventoryConfigurationRequest, HttpMethodName.PUT);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBucketInventoryConfiguration");
    request.addParameter("inventory", null);
    request.addParameter("id", id);
    
    byte[] bytes = bucketConfigurationXmlFactory.convertToXmlByteArray(inventoryConfiguration);
    request.addHeader("Content-Length", String.valueOf(bytes.length));
    request.addHeader("Content-Type", "application/xml");
    request.setContent(new ByteArrayInputStream(bytes));
    
    return (SetBucketInventoryConfigurationResult)invoke(request, new Unmarshallers.SetBucketInventoryConfigurationUnmarshaller(), bucketName, null);
  }
  
  public ListBucketInventoryConfigurationsResult listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest)
    throws AmazonServiceException, SdkClientException
  {
    listBucketInventoryConfigurationsRequest = (ListBucketInventoryConfigurationsRequest)beforeClientExecution(listBucketInventoryConfigurationsRequest);
    rejectNull(listBucketInventoryConfigurationsRequest, "The request cannot be null");
    String bucketName = ValidationUtils.assertStringNotEmpty(listBucketInventoryConfigurationsRequest.getBucketName(), "BucketName");
    
    Request<ListBucketInventoryConfigurationsRequest> request = createRequest(bucketName, null, listBucketInventoryConfigurationsRequest, HttpMethodName.GET);
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBucketInventoryConfigurations");
    request.addParameter("inventory", null);
    addParameterIfNotNull(request, "continuation-token", listBucketInventoryConfigurationsRequest.getContinuationToken());
    
    return (ListBucketInventoryConfigurationsResult)invoke(request, new Unmarshallers.ListBucketInventoryConfigurationsUnmarshaller(), bucketName, null);
  }
  
  URI resolveServiceEndpoint(String bucketName)
  {
    if ((getSignerRegion() != null) || (isSignerOverridden())) {
      return endpoint;
    }
    String regionStr = fetchRegionFromCache(bucketName);
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region region = RegionUtils.getRegion(regionStr);
    if (region == null) {
      log.warn("Region information for " + regionStr + " is not available. Please upgrade to latest version of AWS Java SDK");
    }
    return region != null ? 
      RuntimeHttpUtils.toUri(region.getServiceEndpoint("s3"), clientConfiguration) : endpoint;
  }
  
  private String fetchRegionFromCache(String bucketName)
  {
    String bucketRegion = (String)bucketRegionCache.get(bucketName);
    if (bucketRegion == null)
    {
      if (log.isDebugEnabled()) {
        log.debug("Bucket region cache doesn't have an entry for " + bucketName + ". Trying to get bucket region from Amazon S3.");
      }
      bucketRegion = getBucketRegionViaHeadRequest(bucketName);
      if (bucketRegion != null) {
        bucketRegionCache.put(bucketName, bucketRegion);
      }
    }
    if (log.isDebugEnabled()) {
      log.debug("Region for " + bucketName + " is " + bucketRegion);
    }
    return bucketRegion;
  }
  
  private String getBucketRegionViaHeadRequest(String bucketName)
  {
    String bucketRegion = null;
    try
    {
      Request<HeadBucketRequest> request = createRequest(bucketName, null, new HeadBucketRequest(bucketName), HttpMethodName.HEAD);
      
      request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "HeadBucket");
      
      HeadBucketResult result = (HeadBucketResult)invoke(request, new HeadBucketResultHandler(), bucketName, null, true);
      bucketRegion = result.getBucketRegion();
    }
    catch (AmazonS3Exception exception)
    {
      if (exception.getAdditionalDetails() != null) {
        bucketRegion = (String)exception.getAdditionalDetails().get("x-amz-bucket-region");
      }
    }
    if ((bucketRegion == null) && (log.isDebugEnabled())) {
      log.debug("Not able to derive region of the " + bucketName + " from the HEAD Bucket requests.");
    }
    return bucketRegion;
  }
  
  public AmazonS3Waiters waiters()
  {
    if (waiters == null) {
      synchronized (this)
      {
        if (waiters == null) {
          waiters = new AmazonS3Waiters(this);
        }
      }
    }
    return waiters;
  }
  
  private String urlEncodeTags(ObjectTagging tagging)
  {
    if ((tagging == null) || (tagging.getTagSet() == null)) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    
    Iterator<Tag> tagIter = tagging.getTagSet().iterator();
    while (tagIter.hasNext())
    {
      Tag tag = (Tag)tagIter.next();
      sb.append(SdkHttpUtils.urlEncode(tag.getKey(), false)).append('=').append(SdkHttpUtils.urlEncode(tag.getValue(), false));
      if (tagIter.hasNext()) {
        sb.append("&");
      }
    }
    return sb.toString();
  }
  
  private void setContent(Request<?> request, byte[] content, String contentType, boolean setMd5)
  {
    request.setContent(new ByteArrayInputStream(content));
    request.addHeader("Content-Length", Integer.toString(content.length));
    request.addHeader("Content-Type", contentType);
    if (setMd5) {
      try
      {
        byte[] md5 = Md5Utils.computeMD5Hash(content);
        String md5Base64 = BinaryUtils.toBase64(md5);
        request.addHeader("Content-MD5", md5Base64);
      }
      catch (Exception e)
      {
        throw new AmazonClientException("Couldn't compute md5 sum", e);
      }
    }
  }
  
  private Request<RestoreObjectRequest> createRestoreObjectRequest(RestoreObjectRequest restoreObjectRequest)
  {
    String bucketName = restoreObjectRequest.getBucketName();
    String key = restoreObjectRequest.getKey();
    String versionId = restoreObjectRequest.getVersionId();
    
    Request<RestoreObjectRequest> request = createRequest(bucketName, key, restoreObjectRequest, HttpMethodName.POST);
    
    request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RestoreObject");
    request.addParameter("restore", null);
    if (versionId != null) {
      request.addParameter("versionId", versionId);
    }
    populateRequesterPaysHeader(request, restoreObjectRequest.isRequesterPays());
    byte[] content = RequestXmlFactory.convertToXmlByteArray(restoreObjectRequest);
    setContent(request, content, "application/xml", true);
    return request;
  }
  
  private static void populateObjectLockHeaders(Request<?> request, String mode, Date retainUntil, String status)
  {
    addHeaderIfNotNull(request, "x-amz-object-lock-mode", mode);
    if (retainUntil != null) {
      request.addHeader("x-amz-object-lock-retain-until-date", ServiceUtils.formatIso8601Date(retainUntil));
    }
    addHeaderIfNotNull(request, "x-amz-object-lock-legal-hold", status);
  }
  
  private class PutObjectStrategy
    implements UploadObjectStrategy<PutObjectRequest, PutObjectResult>
  {
    private final String bucketName;
    private final String key;
    
    private PutObjectStrategy(String bucketName, String key)
    {
      this.bucketName = bucketName;
      this.key = key;
    }
    
    public ObjectMetadata invokeServiceCall(Request<PutObjectRequest> request)
    {
      return (ObjectMetadata)AmazonS3Client.this.invoke(request, new S3MetadataResponseHandler(), bucketName, key);
    }
    
    public PutObjectResult createResult(ObjectMetadata metadata, String contentMd5)
    {
      PutObjectResult result = AmazonS3Client.createPutObjectResult(metadata);
      result.setContentMd5(contentMd5);
      return result;
    }
    
    public String md5ValidationErrorSuffix()
    {
      return ", bucketName: " + bucketName + ", key: " + key;
    }
  }
  
  private class PresignedUrlUploadStrategy
    implements UploadObjectStrategy<PresignedUrlUploadRequest, PresignedUrlUploadResult>
  {
    private final URL url;
    
    private PresignedUrlUploadStrategy(URL url)
    {
      this.url = url;
    }
    
    public ObjectMetadata invokeServiceCall(Request<PresignedUrlUploadRequest> request)
    {
      return 
      
        (ObjectMetadata)client.execute(request, new S3MetadataResponseHandler(), errorResponseHandler, createExecutionContext(AmazonWebServiceRequest.NOOP, new NoOpSignerProvider()), AmazonS3Client.this.requestConfigWithSkipAppendUriPath(request)).getAwsResponse();
    }
    
    public PresignedUrlUploadResult createResult(ObjectMetadata metadata, String contentMd5)
    {
      return AmazonS3Client.this.createPresignedUrlUploadResult(metadata, contentMd5);
    }
    
    public String md5ValidationErrorSuffix()
    {
      return ", object presigned url: " + url;
    }
  }
  
  private PresignedUrlUploadResult createPresignedUrlUploadResult(ObjectMetadata metadata, String contentMd5)
  {
    PresignedUrlUploadResult result = new PresignedUrlUploadResult();
    result.setMetadata(metadata);
    result.setContentMd5(contentMd5);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */