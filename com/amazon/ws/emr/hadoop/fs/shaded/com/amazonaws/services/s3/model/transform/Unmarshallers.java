package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeletePublicAccessBlockResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectRetentionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetPublicAccessBlockResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.List;

public class Unmarshallers
{
  public static final class ListBucketsUnmarshaller
    implements Unmarshaller<List<Bucket>, InputStream>
  {
    public List<Bucket> unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListMyBucketsResponse(in).getBuckets();
    }
  }
  
  public static final class ListBucketsOwnerUnmarshaller
    implements Unmarshaller<Owner, InputStream>
  {
    public Owner unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListMyBucketsResponse(in).getOwner();
    }
  }
  
  public static final class ListObjectsUnmarshaller
    implements Unmarshaller<ObjectListing, InputStream>
  {
    private final boolean shouldSDKDecodeResponse;
    
    public ListObjectsUnmarshaller(boolean shouldSDKDecodeResponse)
    {
      this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
    }
    
    public ObjectListing unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListBucketObjectsResponse(in, shouldSDKDecodeResponse).getObjectListing();
    }
  }
  
  public static final class ListObjectsV2Unmarshaller
    implements Unmarshaller<ListObjectsV2Result, InputStream>
  {
    private final boolean shouldSDKDecodeResponse;
    
    public ListObjectsV2Unmarshaller(boolean shouldSDKDecodeResponse)
    {
      this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
    }
    
    public ListObjectsV2Result unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListObjectsV2Response(in, shouldSDKDecodeResponse).getResult();
    }
  }
  
  public static final class VersionListUnmarshaller
    implements Unmarshaller<VersionListing, InputStream>
  {
    private final boolean shouldSDKDecodeResponse;
    
    public VersionListUnmarshaller(boolean shouldSDKDecodeResponse)
    {
      this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
    }
    
    public VersionListing unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListVersionsResponse(in, shouldSDKDecodeResponse).getListing();
    }
  }
  
  public static final class AccessControlListUnmarshaller
    implements Unmarshaller<AccessControlList, InputStream>
  {
    public AccessControlList unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseAccessControlListResponse(in).getAccessControlList();
    }
  }
  
  public static final class BucketLoggingConfigurationnmarshaller
    implements Unmarshaller<BucketLoggingConfiguration, InputStream>
  {
    public BucketLoggingConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseLoggingStatusResponse(in).getBucketLoggingConfiguration();
    }
  }
  
  public static final class BucketLocationUnmarshaller
    implements Unmarshaller<String, InputStream>
  {
    public String unmarshall(InputStream in)
      throws Exception
    {
      String location = new XmlResponsesSaxParser().parseBucketLocationResponse(in);
      if (location == null) {
        location = "US";
      }
      return location;
    }
  }
  
  public static final class BucketVersioningConfigurationUnmarshaller
    implements Unmarshaller<BucketVersioningConfiguration, InputStream>
  {
    public BucketVersioningConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseVersioningConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class BucketWebsiteConfigurationUnmarshaller
    implements Unmarshaller<BucketWebsiteConfiguration, InputStream>
  {
    public BucketWebsiteConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseWebsiteConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class BucketReplicationConfigurationUnmarshaller
    implements Unmarshaller<BucketReplicationConfiguration, InputStream>
  {
    public BucketReplicationConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseReplicationConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class BucketTaggingConfigurationUnmarshaller
    implements Unmarshaller<BucketTaggingConfiguration, InputStream>
  {
    public BucketTaggingConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseTaggingConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class BucketAccelerateConfigurationUnmarshaller
    implements Unmarshaller<BucketAccelerateConfiguration, InputStream>
  {
    public BucketAccelerateConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseAccelerateConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class DeleteBucketEncryptionUnmarshaller
    implements Unmarshaller<DeleteBucketEncryptionResult, InputStream>
  {
    public DeleteBucketEncryptionResult unmarshall(InputStream in)
    {
      return new DeleteBucketEncryptionResult();
    }
  }
  
  public static final class SetBucketEncryptionUnmarshaller
    implements Unmarshaller<SetBucketEncryptionResult, InputStream>
  {
    public SetBucketEncryptionResult unmarshall(InputStream in)
    {
      return new SetBucketEncryptionResult();
    }
  }
  
  public static final class SetPublicAccessBlockUnmarshaller
    implements Unmarshaller<SetPublicAccessBlockResult, InputStream>
  {
    public SetPublicAccessBlockResult unmarshall(InputStream in)
    {
      return new SetPublicAccessBlockResult();
    }
  }
  
  public static final class DeletePublicAccessBlockUnmarshaller
    implements Unmarshaller<DeletePublicAccessBlockResult, InputStream>
  {
    public DeletePublicAccessBlockResult unmarshall(InputStream in)
    {
      return new DeletePublicAccessBlockResult();
    }
  }
  
  public static final class InputStreamUnmarshaller
    implements Unmarshaller<InputStream, InputStream>
  {
    public InputStream unmarshall(InputStream in)
      throws Exception
    {
      return in;
    }
  }
  
  public static final class CopyObjectUnmarshaller
    implements Unmarshaller<XmlResponsesSaxParser.CopyObjectResultHandler, InputStream>
  {
    public XmlResponsesSaxParser.CopyObjectResultHandler unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseCopyObjectResponse(in);
    }
  }
  
  public static final class CompleteMultipartUploadResultUnmarshaller
    implements Unmarshaller<XmlResponsesSaxParser.CompleteMultipartUploadHandler, InputStream>
  {
    public XmlResponsesSaxParser.CompleteMultipartUploadHandler unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseCompleteMultipartUploadResponse(in);
    }
  }
  
  public static final class InitiateMultipartUploadResultUnmarshaller
    implements Unmarshaller<InitiateMultipartUploadResult, InputStream>
  {
    public InitiateMultipartUploadResult unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseInitiateMultipartUploadResponse(in).getInitiateMultipartUploadResult();
    }
  }
  
  public static final class ListMultipartUploadsResultUnmarshaller
    implements Unmarshaller<MultipartUploadListing, InputStream>
  {
    public MultipartUploadListing unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListMultipartUploadsResponse(in).getListMultipartUploadsResult();
    }
  }
  
  public static final class ListPartsResultUnmarshaller
    implements Unmarshaller<PartListing, InputStream>
  {
    public PartListing unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseListPartsResponse(in).getListPartsResult();
    }
  }
  
  public static final class DeleteObjectsResultUnmarshaller
    implements Unmarshaller<DeleteObjectsResponse, InputStream>
  {
    public DeleteObjectsResponse unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseDeletedObjectsResult(in).getDeleteObjectResult();
    }
  }
  
  public static final class BucketLifecycleConfigurationUnmarshaller
    implements Unmarshaller<BucketLifecycleConfiguration, InputStream>
  {
    public BucketLifecycleConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseBucketLifecycleConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class BucketCrossOriginConfigurationUnmarshaller
    implements Unmarshaller<BucketCrossOriginConfiguration, InputStream>
  {
    public BucketCrossOriginConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseBucketCrossOriginConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class RequestPaymentConfigurationUnmarshaller
    implements Unmarshaller<RequestPaymentConfiguration, InputStream>
  {
    public RequestPaymentConfiguration unmarshall(InputStream in)
      throws Exception
    {
      return 
        new XmlResponsesSaxParser().parseRequestPaymentConfigurationResponse(in).getConfiguration();
    }
  }
  
  public static final class GetObjectTaggingResponseUnmarshaller
    implements Unmarshaller<GetObjectTaggingResult, InputStream>
  {
    public GetObjectTaggingResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseObjectTaggingResponse(in).getResult();
    }
  }
  
  public static final class SetObjectTaggingResponseUnmarshaller
    implements Unmarshaller<SetObjectTaggingResult, InputStream>
  {
    public SetObjectTaggingResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetObjectTaggingResult();
    }
  }
  
  public static final class DeleteObjectTaggingResponseUnmarshaller
    implements Unmarshaller<DeleteObjectTaggingResult, InputStream>
  {
    public DeleteObjectTaggingResult unmarshall(InputStream in)
      throws Exception
    {
      return new DeleteObjectTaggingResult();
    }
  }
  
  public static final class GetBucketAnalyticsConfigurationUnmarshaller
    implements Unmarshaller<GetBucketAnalyticsConfigurationResult, InputStream>
  {
    public GetBucketAnalyticsConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseGetBucketAnalyticsConfigurationResponse(in).getResult();
    }
  }
  
  public static final class ListBucketAnalyticsConfigurationUnmarshaller
    implements Unmarshaller<ListBucketAnalyticsConfigurationsResult, InputStream>
  {
    public ListBucketAnalyticsConfigurationsResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseListBucketAnalyticsConfigurationResponse(in).getResult();
    }
  }
  
  public static final class DeleteBucketAnalyticsConfigurationUnmarshaller
    implements Unmarshaller<DeleteBucketAnalyticsConfigurationResult, InputStream>
  {
    public DeleteBucketAnalyticsConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new DeleteBucketAnalyticsConfigurationResult();
    }
  }
  
  public static final class SetBucketAnalyticsConfigurationUnmarshaller
    implements Unmarshaller<SetBucketAnalyticsConfigurationResult, InputStream>
  {
    public SetBucketAnalyticsConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetBucketAnalyticsConfigurationResult();
    }
  }
  
  public static final class GetBucketMetricsConfigurationUnmarshaller
    implements Unmarshaller<GetBucketMetricsConfigurationResult, InputStream>
  {
    public GetBucketMetricsConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseGetBucketMetricsConfigurationResponse(in).getResult();
    }
  }
  
  public static final class ListBucketMetricsConfigurationsUnmarshaller
    implements Unmarshaller<ListBucketMetricsConfigurationsResult, InputStream>
  {
    public ListBucketMetricsConfigurationsResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseListBucketMetricsConfigurationsResponse(in).getResult();
    }
  }
  
  public static final class DeleteBucketMetricsConfigurationUnmarshaller
    implements Unmarshaller<DeleteBucketMetricsConfigurationResult, InputStream>
  {
    public DeleteBucketMetricsConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new DeleteBucketMetricsConfigurationResult();
    }
  }
  
  public static final class SetBucketMetricsConfigurationUnmarshaller
    implements Unmarshaller<SetBucketMetricsConfigurationResult, InputStream>
  {
    public SetBucketMetricsConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetBucketMetricsConfigurationResult();
    }
  }
  
  public static final class GetBucketInventoryConfigurationUnmarshaller
    implements Unmarshaller<GetBucketInventoryConfigurationResult, InputStream>
  {
    public GetBucketInventoryConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseGetBucketInventoryConfigurationResponse(in).getResult();
    }
  }
  
  public static final class ListBucketInventoryConfigurationsUnmarshaller
    implements Unmarshaller<ListBucketInventoryConfigurationsResult, InputStream>
  {
    public ListBucketInventoryConfigurationsResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseBucketListInventoryConfigurationsResponse(in).getResult();
    }
  }
  
  public static final class DeleteBucketInventoryConfigurationUnmarshaller
    implements Unmarshaller<DeleteBucketInventoryConfigurationResult, InputStream>
  {
    public DeleteBucketInventoryConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new DeleteBucketInventoryConfigurationResult();
    }
  }
  
  public static final class SetBucketInventoryConfigurationUnmarshaller
    implements Unmarshaller<SetBucketInventoryConfigurationResult, InputStream>
  {
    public SetBucketInventoryConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetBucketInventoryConfigurationResult();
    }
  }
  
  public static final class RestoreObjectResultUnmarshaller
    implements Unmarshaller<RestoreObjectResult, InputStream>
  {
    public RestoreObjectResult unmarshall(InputStream in)
    {
      return new RestoreObjectResult();
    }
  }
  
  public static final class GetObjectLegalHoldResultUnmarshaller
    implements Unmarshaller<GetObjectLegalHoldResult, InputStream>
  {
    public GetObjectLegalHoldResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseGetObjectLegalHoldResponse(in).getResult();
    }
  }
  
  public static final class SetObjectLockConfigurationResultUnmarshaller
    implements Unmarshaller<SetObjectLockConfigurationResult, InputStream>
  {
    public SetObjectLockConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetObjectLockConfigurationResult();
    }
  }
  
  public static final class SetObjectLegalHoldResultUnmarshaller
    implements Unmarshaller<SetObjectLegalHoldResult, InputStream>
  {
    public SetObjectLegalHoldResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetObjectLegalHoldResult();
    }
  }
  
  public static final class GetObjectLockConfigurationResultUnmarshaller
    implements Unmarshaller<GetObjectLockConfigurationResult, InputStream>
  {
    public GetObjectLockConfigurationResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseGetObjectLockConfigurationResponse(in).getResult();
    }
  }
  
  public static final class SetObjectRetentionResultUnmarshaller
    implements Unmarshaller<SetObjectRetentionResult, InputStream>
  {
    public SetObjectRetentionResult unmarshall(InputStream in)
      throws Exception
    {
      return new SetObjectRetentionResult();
    }
  }
  
  public static final class GetObjectRetentionResultUnmarshaller
    implements Unmarshaller<GetObjectRetentionResult, InputStream>
  {
    public GetObjectRetentionResult unmarshall(InputStream in)
      throws Exception
    {
      return new XmlResponsesSaxParser().parseGetObjectRetentionResponse(in).getResult();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */