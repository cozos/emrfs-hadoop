package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlTranslation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.NoncurrentVersionTransition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Rule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Transition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule.AllowedMethods;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DefaultRetention;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteMarkerReplication;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GroupGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockLegalHold;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRetention;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Permission;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RedirectRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration.Payer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SourceSelectionCriteria;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SseKmsEncryptedObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TagSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlResponsesSaxParser
{
  private static final Log log = LogFactory.getLog(XmlResponsesSaxParser.class);
  private XMLReader xr = null;
  private boolean sanitizeXmlDocument = true;
  
  public XmlResponsesSaxParser()
    throws SdkClientException
  {
    try
    {
      xr = XMLReaderFactory.createXMLReader();
      disableExternalResourceFetching(xr);
    }
    catch (SAXException e)
    {
      throw new SdkClientException("Couldn't initialize a SAX driver to create an XMLReader", e);
    }
  }
  
  protected void parseXmlInputStream(DefaultHandler handler, InputStream inputStream)
    throws IOException
  {
    try
    {
      if (log.isDebugEnabled()) {
        log.debug("Parsing XML response document with handler: " + handler.getClass());
      }
      BufferedReader breader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
      
      xr.setContentHandler(handler);
      xr.setErrorHandler(handler);
      xr.parse(new InputSource(breader));
    }
    catch (IOException e)
    {
      throw e;
    }
    catch (Throwable t)
    {
      try
      {
        inputStream.close();
      }
      catch (IOException e)
      {
        if (log.isErrorEnabled()) {
          log.error("Unable to close response InputStream up after XML parse failure", e);
        }
      }
      throw new SdkClientException("Failed to parse XML document with handler " + handler.getClass(), t);
    }
  }
  
  protected InputStream sanitizeXmlDocument(DefaultHandler handler, InputStream inputStream)
    throws IOException
  {
    if (!sanitizeXmlDocument) {
      return inputStream;
    }
    if (log.isDebugEnabled()) {
      log.debug("Sanitizing XML document destined for handler " + handler.getClass());
    }
    InputStream sanitizedInputStream = null;
    try
    {
      StringBuilder listingDocBuffer = new StringBuilder();
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
      
      char[] buf = new char[' '];
      int read = -1;
      while ((read = br.read(buf)) != -1) {
        listingDocBuffer.append(buf, 0, read);
      }
      br.close();
      
      String listingDoc = listingDocBuffer.toString().replaceAll("\r", "&#013;");
      
      sanitizedInputStream = new ByteArrayInputStream(listingDoc.getBytes(StringUtils.UTF8));
    }
    catch (IOException e)
    {
      throw e;
    }
    catch (Throwable t)
    {
      try
      {
        inputStream.close();
      }
      catch (IOException e)
      {
        if (log.isErrorEnabled()) {
          log.error("Unable to close response InputStream after failure sanitizing XML document", e);
        }
      }
      throw new SdkClientException("Failed to sanitize XML document destined for handler " + handler.getClass(), t);
    }
    return sanitizedInputStream;
  }
  
  private void disableExternalResourceFetching(XMLReader reader)
    throws SAXNotRecognizedException, SAXNotSupportedException
  {
    reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
    reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
  }
  
  private static String checkForEmptyString(String s)
  {
    if (s == null) {
      return null;
    }
    if (s.length() == 0) {
      return null;
    }
    return s;
  }
  
  private static int parseInt(String s)
  {
    try
    {
      return Integer.parseInt(s);
    }
    catch (NumberFormatException nfe)
    {
      log.error("Unable to parse integer value '" + s + "'", nfe);
    }
    return -1;
  }
  
  private static long parseLong(String s)
  {
    try
    {
      return Long.parseLong(s);
    }
    catch (NumberFormatException nfe)
    {
      log.error("Unable to parse long value '" + s + "'", nfe);
    }
    return -1L;
  }
  
  private static String decodeIfSpecified(String value, boolean decode)
  {
    return decode ? SdkHttpUtils.urlDecode(value) : value;
  }
  
  public ListBucketHandler parseListBucketObjectsResponse(InputStream inputStream, boolean shouldSDKDecodeResponse)
    throws IOException
  {
    ListBucketHandler handler = new ListBucketHandler(shouldSDKDecodeResponse);
    parseXmlInputStream(handler, sanitizeXmlDocument(handler, inputStream));
    
    return handler;
  }
  
  public ListObjectsV2Handler parseListObjectsV2Response(InputStream inputStream, boolean shouldSDKDecodeResponse)
    throws IOException
  {
    ListObjectsV2Handler handler = new ListObjectsV2Handler(shouldSDKDecodeResponse);
    parseXmlInputStream(handler, sanitizeXmlDocument(handler, inputStream));
    
    return handler;
  }
  
  public ListVersionsHandler parseListVersionsResponse(InputStream inputStream, boolean shouldSDKDecodeResponse)
    throws IOException
  {
    ListVersionsHandler handler = new ListVersionsHandler(shouldSDKDecodeResponse);
    parseXmlInputStream(handler, sanitizeXmlDocument(handler, inputStream));
    return handler;
  }
  
  public ListAllMyBucketsHandler parseListMyBucketsResponse(InputStream inputStream)
    throws IOException
  {
    ListAllMyBucketsHandler handler = new ListAllMyBucketsHandler();
    parseXmlInputStream(handler, sanitizeXmlDocument(handler, inputStream));
    return handler;
  }
  
  public AccessControlListHandler parseAccessControlListResponse(InputStream inputStream)
    throws IOException
  {
    AccessControlListHandler handler = new AccessControlListHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketLoggingConfigurationHandler parseLoggingStatusResponse(InputStream inputStream)
    throws IOException
  {
    BucketLoggingConfigurationHandler handler = new BucketLoggingConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketLifecycleConfigurationHandler parseBucketLifecycleConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketLifecycleConfigurationHandler handler = new BucketLifecycleConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketCrossOriginConfigurationHandler parseBucketCrossOriginConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketCrossOriginConfigurationHandler handler = new BucketCrossOriginConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public String parseBucketLocationResponse(InputStream inputStream)
    throws IOException
  {
    BucketLocationHandler handler = new BucketLocationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler.getLocation();
  }
  
  public BucketVersioningConfigurationHandler parseVersioningConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketVersioningConfigurationHandler handler = new BucketVersioningConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketWebsiteConfigurationHandler parseWebsiteConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketWebsiteConfigurationHandler handler = new BucketWebsiteConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketReplicationConfigurationHandler parseReplicationConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketReplicationConfigurationHandler handler = new BucketReplicationConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketTaggingConfigurationHandler parseTaggingConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketTaggingConfigurationHandler handler = new BucketTaggingConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public BucketAccelerateConfigurationHandler parseAccelerateConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    BucketAccelerateConfigurationHandler handler = new BucketAccelerateConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public DeleteObjectsHandler parseDeletedObjectsResult(InputStream inputStream)
    throws IOException
  {
    DeleteObjectsHandler handler = new DeleteObjectsHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public CopyObjectResultHandler parseCopyObjectResponse(InputStream inputStream)
    throws IOException
  {
    CopyObjectResultHandler handler = new CopyObjectResultHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public CompleteMultipartUploadHandler parseCompleteMultipartUploadResponse(InputStream inputStream)
    throws IOException
  {
    CompleteMultipartUploadHandler handler = new CompleteMultipartUploadHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public InitiateMultipartUploadHandler parseInitiateMultipartUploadResponse(InputStream inputStream)
    throws IOException
  {
    InitiateMultipartUploadHandler handler = new InitiateMultipartUploadHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public ListMultipartUploadsHandler parseListMultipartUploadsResponse(InputStream inputStream)
    throws IOException
  {
    ListMultipartUploadsHandler handler = new ListMultipartUploadsHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public ListPartsHandler parseListPartsResponse(InputStream inputStream)
    throws IOException
  {
    ListPartsHandler handler = new ListPartsHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetObjectTaggingHandler parseObjectTaggingResponse(InputStream inputStream)
    throws IOException
  {
    GetObjectTaggingHandler handler = new GetObjectTaggingHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetBucketMetricsConfigurationHandler parseGetBucketMetricsConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    GetBucketMetricsConfigurationHandler handler = new GetBucketMetricsConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public ListBucketMetricsConfigurationsHandler parseListBucketMetricsConfigurationsResponse(InputStream inputStream)
    throws IOException
  {
    ListBucketMetricsConfigurationsHandler handler = new ListBucketMetricsConfigurationsHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetBucketAnalyticsConfigurationHandler parseGetBucketAnalyticsConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    GetBucketAnalyticsConfigurationHandler handler = new GetBucketAnalyticsConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public ListBucketAnalyticsConfigurationHandler parseListBucketAnalyticsConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    ListBucketAnalyticsConfigurationHandler handler = new ListBucketAnalyticsConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetBucketInventoryConfigurationHandler parseGetBucketInventoryConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    GetBucketInventoryConfigurationHandler handler = new GetBucketInventoryConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public ListBucketInventoryConfigurationsHandler parseBucketListInventoryConfigurationsResponse(InputStream inputStream)
    throws IOException
  {
    ListBucketInventoryConfigurationsHandler handler = new ListBucketInventoryConfigurationsHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public RequestPaymentConfigurationHandler parseRequestPaymentConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    RequestPaymentConfigurationHandler handler = new RequestPaymentConfigurationHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetObjectLegalHoldResponseHandler parseGetObjectLegalHoldResponse(InputStream inputStream)
    throws IOException
  {
    GetObjectLegalHoldResponseHandler handler = new GetObjectLegalHoldResponseHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetObjectLockConfigurationResponseHandler parseGetObjectLockConfigurationResponse(InputStream inputStream)
    throws IOException
  {
    GetObjectLockConfigurationResponseHandler handler = new GetObjectLockConfigurationResponseHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public GetObjectRetentionResponseHandler parseGetObjectRetentionResponse(InputStream inputStream)
    throws IOException
  {
    GetObjectRetentionResponseHandler handler = new GetObjectRetentionResponseHandler();
    parseXmlInputStream(handler, inputStream);
    return handler;
  }
  
  public static class ListBucketHandler
    extends AbstractHandler
  {
    private final ObjectListing objectListing = new ObjectListing();
    private final boolean shouldSDKDecodeResponse;
    private S3ObjectSummary currentObject = null;
    private Owner currentOwner = null;
    private String lastKey = null;
    
    public ListBucketHandler(boolean shouldSDKDecodeResponse)
    {
      this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
    }
    
    public ObjectListing getObjectListing()
    {
      return objectListing;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListBucketResult" }))
      {
        if (name.equals("Contents"))
        {
          currentObject = new S3ObjectSummary();
          currentObject.setBucketName(objectListing.getBucketName());
        }
      }
      else if ((in(new String[] { "ListBucketResult", "Contents" })) && 
        (name.equals("Owner"))) {
        currentOwner = new Owner();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (atTopLevel())
      {
        if (name.equals("ListBucketResult")) {
          if ((objectListing.isTruncated()) && 
            (objectListing.getNextMarker() == null))
          {
            String nextMarker = null;
            if (!objectListing.getObjectSummaries().isEmpty()) {
              nextMarker = ((S3ObjectSummary)objectListing.getObjectSummaries().get(objectListing.getObjectSummaries().size() - 1)).getKey();
            } else if (!objectListing.getCommonPrefixes().isEmpty()) {
              nextMarker = (String)objectListing.getCommonPrefixes().get(objectListing.getCommonPrefixes().size() - 1);
            } else {
              XmlResponsesSaxParser.log.error("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
            }
            objectListing.setNextMarker(nextMarker);
          }
        }
      }
      else if (in(new String[] { "ListBucketResult" }))
      {
        if (name.equals("Name"))
        {
          objectListing.setBucketName(getText());
          if (XmlResponsesSaxParser.log.isDebugEnabled()) {
            XmlResponsesSaxParser.log.debug("Examining listing for bucket: " + objectListing
              .getBucketName());
          }
        }
        else if (name.equals("Prefix"))
        {
          objectListing.setPrefix(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("Marker"))
        {
          objectListing.setMarker(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("NextMarker"))
        {
          objectListing.setNextMarker(XmlResponsesSaxParser.decodeIfSpecified(
            getText(), shouldSDKDecodeResponse));
        }
        else if (name.equals("MaxKeys"))
        {
          objectListing.setMaxKeys(XmlResponsesSaxParser.parseInt(getText()));
        }
        else if (name.equals("Delimiter"))
        {
          objectListing.setDelimiter(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("EncodingType"))
        {
          objectListing.setEncodingType(shouldSDKDecodeResponse ? null : 
            XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("IsTruncated"))
        {
          String isTruncatedStr = StringUtils.lowerCase(getText());
          if (isTruncatedStr.startsWith("false")) {
            objectListing.setTruncated(false);
          } else if (isTruncatedStr.startsWith("true")) {
            objectListing.setTruncated(true);
          } else {
            throw new IllegalStateException("Invalid value for IsTruncated field: " + isTruncatedStr);
          }
        }
        else if (name.equals("Contents"))
        {
          objectListing.getObjectSummaries().add(currentObject);
          currentObject = null;
        }
      }
      else if (in(new String[] { "ListBucketResult", "Contents" }))
      {
        if (name.equals("Key"))
        {
          lastKey = getText();
          currentObject.setKey(XmlResponsesSaxParser.decodeIfSpecified(lastKey, shouldSDKDecodeResponse));
        }
        else if (name.equals("LastModified"))
        {
          currentObject.setLastModified(
            ServiceUtils.parseIso8601Date(getText()));
        }
        else if (name.equals("ETag"))
        {
          currentObject.setETag(
            ServiceUtils.removeQuotes(getText()));
        }
        else if (name.equals("Size"))
        {
          currentObject.setSize(XmlResponsesSaxParser.parseLong(getText()));
        }
        else if (name.equals("StorageClass"))
        {
          currentObject.setStorageClass(getText());
        }
        else if (name.equals("Owner"))
        {
          currentObject.setOwner(currentOwner);
          currentOwner = null;
        }
      }
      else if (in(new String[] { "ListBucketResult", "Contents", "Owner" }))
      {
        if (name.equals("ID")) {
          currentOwner.setId(getText());
        } else if (name.equals("DisplayName")) {
          currentOwner.setDisplayName(getText());
        }
      }
      else if ((in(new String[] { "ListBucketResult", "CommonPrefixes" })) && 
        (name.equals("Prefix"))) {
        objectListing.getCommonPrefixes().add(XmlResponsesSaxParser.decodeIfSpecified(getText(), shouldSDKDecodeResponse));
      }
    }
  }
  
  public static class ListObjectsV2Handler
    extends AbstractHandler
  {
    private final ListObjectsV2Result result = new ListObjectsV2Result();
    private final boolean shouldSDKDecodeResponse;
    private S3ObjectSummary currentObject = null;
    private Owner currentOwner = null;
    private String lastKey = null;
    
    public ListObjectsV2Handler(boolean shouldSDKDecodeResponse)
    {
      this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
    }
    
    public ListObjectsV2Result getResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListBucketResult" }))
      {
        if (name.equals("Contents"))
        {
          currentObject = new S3ObjectSummary();
          currentObject.setBucketName(result.getBucketName());
        }
      }
      else if ((in(new String[] { "ListBucketResult", "Contents" })) && 
        (name.equals("Owner"))) {
        currentOwner = new Owner();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (atTopLevel())
      {
        if (name.equals("ListBucketResult")) {
          if ((result.isTruncated()) && 
            (result.getNextContinuationToken() == null))
          {
            String nextContinuationToken = null;
            if (!result.getObjectSummaries().isEmpty()) {
              nextContinuationToken = ((S3ObjectSummary)result.getObjectSummaries().get(result.getObjectSummaries().size() - 1)).getKey();
            } else {
              XmlResponsesSaxParser.log.error("S3 response indicates truncated results, but contains no object summaries.");
            }
            result.setNextContinuationToken(nextContinuationToken);
          }
        }
      }
      else if (in(new String[] { "ListBucketResult" }))
      {
        if (name.equals("Name"))
        {
          result.setBucketName(getText());
          if (XmlResponsesSaxParser.log.isDebugEnabled()) {
            XmlResponsesSaxParser.log.debug("Examining listing for bucket: " + result
              .getBucketName());
          }
        }
        else if (name.equals("Prefix"))
        {
          result.setPrefix(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("MaxKeys"))
        {
          result.setMaxKeys(XmlResponsesSaxParser.parseInt(getText()));
        }
        else if (name.equals("NextContinuationToken"))
        {
          result.setNextContinuationToken(getText());
        }
        else if (name.equals("ContinuationToken"))
        {
          result.setContinuationToken(getText());
        }
        else if (name.equals("StartAfter"))
        {
          result.setStartAfter(XmlResponsesSaxParser.decodeIfSpecified(
            getText(), shouldSDKDecodeResponse));
        }
        else if (name.equals("KeyCount"))
        {
          result.setKeyCount(XmlResponsesSaxParser.parseInt(getText()));
        }
        else if (name.equals("Delimiter"))
        {
          result.setDelimiter(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("EncodingType"))
        {
          result.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("IsTruncated"))
        {
          String isTruncatedStr = StringUtils.lowerCase(getText());
          if (isTruncatedStr.startsWith("false")) {
            result.setTruncated(false);
          } else if (isTruncatedStr.startsWith("true")) {
            result.setTruncated(true);
          } else {
            throw new IllegalStateException("Invalid value for IsTruncated field: " + isTruncatedStr);
          }
        }
        else if (name.equals("Contents"))
        {
          result.getObjectSummaries().add(currentObject);
          currentObject = null;
        }
      }
      else if (in(new String[] { "ListBucketResult", "Contents" }))
      {
        if (name.equals("Key"))
        {
          lastKey = getText();
          currentObject.setKey(XmlResponsesSaxParser.decodeIfSpecified(lastKey, shouldSDKDecodeResponse));
        }
        else if (name.equals("LastModified"))
        {
          currentObject.setLastModified(
            ServiceUtils.parseIso8601Date(getText()));
        }
        else if (name.equals("ETag"))
        {
          currentObject.setETag(
            ServiceUtils.removeQuotes(getText()));
        }
        else if (name.equals("Size"))
        {
          currentObject.setSize(XmlResponsesSaxParser.parseLong(getText()));
        }
        else if (name.equals("StorageClass"))
        {
          currentObject.setStorageClass(getText());
        }
        else if (name.equals("Owner"))
        {
          currentObject.setOwner(currentOwner);
          currentOwner = null;
        }
      }
      else if (in(new String[] { "ListBucketResult", "Contents", "Owner" }))
      {
        if (name.equals("ID")) {
          currentOwner.setId(getText());
        } else if (name.equals("DisplayName")) {
          currentOwner.setDisplayName(getText());
        }
      }
      else if ((in(new String[] { "ListBucketResult", "CommonPrefixes" })) && 
        (name.equals("Prefix"))) {
        result.getCommonPrefixes().add(XmlResponsesSaxParser.decodeIfSpecified(getText(), shouldSDKDecodeResponse));
      }
    }
  }
  
  public static class ListAllMyBucketsHandler
    extends AbstractHandler
  {
    private final List<Bucket> buckets = new ArrayList();
    private Owner bucketsOwner = null;
    private Bucket currentBucket = null;
    
    public List<Bucket> getBuckets()
    {
      return buckets;
    }
    
    public Owner getOwner()
    {
      return bucketsOwner;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListAllMyBucketsResult" }))
      {
        if (name.equals("Owner")) {
          bucketsOwner = new Owner();
        }
      }
      else if ((in(new String[] { "ListAllMyBucketsResult", "Buckets" })) && 
        (name.equals("Bucket")))
      {
        currentBucket = new Bucket();
        currentBucket.setOwner(bucketsOwner);
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListAllMyBucketsResult", "Owner" }))
      {
        if (name.equals("ID")) {
          bucketsOwner.setId(getText());
        } else if (name.equals("DisplayName")) {
          bucketsOwner.setDisplayName(getText());
        }
      }
      else if (in(new String[] { "ListAllMyBucketsResult", "Buckets" }))
      {
        if (name.equals("Bucket"))
        {
          buckets.add(currentBucket);
          currentBucket = null;
        }
      }
      else if (in(new String[] { "ListAllMyBucketsResult", "Buckets", "Bucket" })) {
        if (name.equals("Name"))
        {
          currentBucket.setName(getText());
        }
        else if (name.equals("CreationDate"))
        {
          Date creationDate = DateUtils.parseISO8601Date(getText());
          currentBucket.setCreationDate(creationDate);
        }
      }
    }
  }
  
  public static class AccessControlListHandler
    extends AbstractHandler
  {
    private final AccessControlList accessControlList = new AccessControlList();
    private Grantee currentGrantee = null;
    private Permission currentPermission = null;
    
    public AccessControlList getAccessControlList()
    {
      return accessControlList;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "AccessControlPolicy" }))
      {
        if (name.equals("Owner")) {
          accessControlList.setOwner(new Owner());
        }
      }
      else if ((in(new String[] { "AccessControlPolicy", "AccessControlList", "Grant" })) && 
        (name.equals("Grantee")))
      {
        String type = XmlResponsesSaxParser.findAttributeValue("xsi:type", attrs);
        if ("AmazonCustomerByEmail".equals(type)) {
          currentGrantee = new EmailAddressGrantee(null);
        } else if ("CanonicalUser".equals(type)) {
          currentGrantee = new CanonicalGrantee(null);
        } else if (!"Group".equals(type)) {}
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "AccessControlPolicy", "Owner" }))
      {
        if (name.equals("ID")) {
          accessControlList.getOwner().setId(getText());
        } else if (name.equals("DisplayName")) {
          accessControlList.getOwner().setDisplayName(getText());
        }
      }
      else if (in(new String[] { "AccessControlPolicy", "AccessControlList" }))
      {
        if (name.equals("Grant"))
        {
          accessControlList.grantPermission(currentGrantee, currentPermission);
          
          currentGrantee = null;
          currentPermission = null;
        }
      }
      else if (in(new String[] { "AccessControlPolicy", "AccessControlList", "Grant" }))
      {
        if (name.equals("Permission")) {
          currentPermission = Permission.parsePermission(getText());
        }
      }
      else if (in(new String[] { "AccessControlPolicy", "AccessControlList", "Grant", "Grantee" })) {
        if (name.equals("ID")) {
          currentGrantee.setIdentifier(getText());
        } else if (name.equals("EmailAddress")) {
          currentGrantee.setIdentifier(getText());
        } else if (name.equals("URI")) {
          currentGrantee = GroupGrantee.parseGroupGrantee(getText());
        } else if (name.equals("DisplayName")) {
          ((CanonicalGrantee)currentGrantee).setDisplayName(getText());
        }
      }
    }
  }
  
  public static class BucketLoggingConfigurationHandler
    extends AbstractHandler
  {
    private final BucketLoggingConfiguration bucketLoggingConfiguration = new BucketLoggingConfiguration();
    
    public BucketLoggingConfiguration getBucketLoggingConfiguration()
    {
      return bucketLoggingConfiguration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "BucketLoggingStatus", "LoggingEnabled" })) {
        if (name.equals("TargetBucket")) {
          bucketLoggingConfiguration.setDestinationBucketName(getText());
        } else if (name.equals("TargetPrefix")) {
          bucketLoggingConfiguration.setLogFilePrefix(getText());
        }
      }
    }
  }
  
  public static class BucketLocationHandler
    extends AbstractHandler
  {
    private String location = null;
    
    public String getLocation()
    {
      return location;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if ((atTopLevel()) && 
        (name.equals("LocationConstraint")))
      {
        String elementText = getText();
        if (elementText.length() == 0) {
          location = null;
        } else {
          location = elementText;
        }
      }
    }
  }
  
  public static class CopyObjectResultHandler
    extends AbstractSSEHandler
    implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult
  {
    private final CopyObjectResult result = new CopyObjectResult();
    private String errorCode = null;
    private String errorMessage = null;
    private String errorRequestId = null;
    private String errorHostId = null;
    private boolean receivedErrorResponse = false;
    
    protected ServerSideEncryptionResult sseResult()
    {
      return result;
    }
    
    public Date getLastModified()
    {
      return result.getLastModifiedDate();
    }
    
    public String getVersionId()
    {
      return result.getVersionId();
    }
    
    public void setVersionId(String versionId)
    {
      result.setVersionId(versionId);
    }
    
    public Date getExpirationTime()
    {
      return result.getExpirationTime();
    }
    
    public void setExpirationTime(Date expirationTime)
    {
      result.setExpirationTime(expirationTime);
    }
    
    public String getExpirationTimeRuleId()
    {
      return result.getExpirationTimeRuleId();
    }
    
    public void setExpirationTimeRuleId(String expirationTimeRuleId)
    {
      result.setExpirationTimeRuleId(expirationTimeRuleId);
    }
    
    public String getETag()
    {
      return result.getETag();
    }
    
    public String getErrorCode()
    {
      return errorCode;
    }
    
    public String getErrorHostId()
    {
      return errorHostId;
    }
    
    public String getErrorMessage()
    {
      return errorMessage;
    }
    
    public String getErrorRequestId()
    {
      return errorRequestId;
    }
    
    public boolean isErrorResponse()
    {
      return receivedErrorResponse;
    }
    
    public boolean isRequesterCharged()
    {
      return result.isRequesterCharged();
    }
    
    public void setRequesterCharged(boolean isRequesterCharged)
    {
      result.setRequesterCharged(isRequesterCharged);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (atTopLevel()) {
        if ((name.equals("CopyObjectResult")) || (name.equals("CopyPartResult"))) {
          receivedErrorResponse = false;
        } else if (name.equals("Error")) {
          receivedErrorResponse = true;
        }
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (!in(new String[] { "CopyObjectResult" }))
      {
        if (!in(new String[] { "CopyPartResult" })) {}
      }
      else
      {
        if (name.equals("LastModified"))
        {
          result.setLastModifiedDate(ServiceUtils.parseIso8601Date(getText())); return;
        }
        if (!name.equals("ETag")) {
          return;
        }
        result.setETag(ServiceUtils.removeQuotes(getText())); return;
      }
      if (in(new String[] { "Error" })) {
        if (name.equals("Code")) {
          errorCode = getText();
        } else if (name.equals("Message")) {
          errorMessage = getText();
        } else if (name.equals("RequestId")) {
          errorRequestId = getText();
        } else if (name.equals("HostId")) {
          errorHostId = getText();
        }
      }
    }
  }
  
  public static class RequestPaymentConfigurationHandler
    extends AbstractHandler
  {
    private String payer = null;
    
    public RequestPaymentConfiguration getConfiguration()
    {
      return new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.valueOf(payer));
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if ((in(new String[] { "RequestPaymentConfiguration" })) && 
        (name.equals("Payer"))) {
        payer = getText();
      }
    }
  }
  
  public static class ListVersionsHandler
    extends AbstractHandler
  {
    private final VersionListing versionListing = new VersionListing();
    private final boolean shouldSDKDecodeResponse;
    private S3VersionSummary currentVersionSummary;
    private Owner currentOwner;
    
    public ListVersionsHandler(boolean shouldSDKDecodeResponse)
    {
      this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
    }
    
    public VersionListing getListing()
    {
      return versionListing;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListVersionsResult" }))
      {
        if (name.equals("Version"))
        {
          currentVersionSummary = new S3VersionSummary();
          currentVersionSummary.setBucketName(versionListing
            .getBucketName());
        }
        else if (name.equals("DeleteMarker"))
        {
          currentVersionSummary = new S3VersionSummary();
          currentVersionSummary.setBucketName(versionListing
            .getBucketName());
          currentVersionSummary.setIsDeleteMarker(true);
        }
      }
      else if (!in(new String[] { "ListVersionsResult", "Version" }))
      {
        if (!in(new String[] { "ListVersionsResult", "DeleteMarker" })) {}
      }
      else if (name.equals("Owner")) {
        currentOwner = new Owner();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListVersionsResult" }))
      {
        if (name.equals("Name"))
        {
          versionListing.setBucketName(getText());
        }
        else if (name.equals("Prefix"))
        {
          versionListing.setPrefix(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("KeyMarker"))
        {
          versionListing.setKeyMarker(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("VersionIdMarker"))
        {
          versionListing.setVersionIdMarker(XmlResponsesSaxParser.checkForEmptyString(
            getText()));
        }
        else if (name.equals("MaxKeys"))
        {
          versionListing.setMaxKeys(Integer.parseInt(getText()));
        }
        else if (name.equals("Delimiter"))
        {
          versionListing.setDelimiter(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("EncodingType"))
        {
          versionListing.setEncodingType(shouldSDKDecodeResponse ? null : 
            XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("NextKeyMarker"))
        {
          versionListing.setNextKeyMarker(XmlResponsesSaxParser.decodeIfSpecified(
            XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
        }
        else if (name.equals("NextVersionIdMarker"))
        {
          versionListing.setNextVersionIdMarker(getText());
        }
        else if (name.equals("IsTruncated"))
        {
          versionListing.setTruncated("true".equals(getText()));
        }
        else if ((name.equals("Version")) || 
          (name.equals("DeleteMarker")))
        {
          versionListing.getVersionSummaries().add(currentVersionSummary);
          
          currentVersionSummary = null;
        }
      }
      else if (in(new String[] { "ListVersionsResult", "CommonPrefixes" }))
      {
        if (name.equals("Prefix"))
        {
          String commonPrefix = XmlResponsesSaxParser.checkForEmptyString(getText());
          versionListing.getCommonPrefixes()
            .add(shouldSDKDecodeResponse ? 
            SdkHttpUtils.urlDecode(commonPrefix) : commonPrefix);
        }
      }
      else
      {
        if (!in(new String[] { "ListVersionsResult", "Version" }))
        {
          if (!in(new String[] { "ListVersionsResult", "DeleteMarker" })) {}
        }
        else
        {
          if (name.equals("Key"))
          {
            currentVersionSummary.setKey(XmlResponsesSaxParser.decodeIfSpecified(getText(), shouldSDKDecodeResponse)); return;
          }
          if (name.equals("VersionId"))
          {
            currentVersionSummary.setVersionId(getText()); return;
          }
          if (name.equals("IsLatest"))
          {
            currentVersionSummary.setIsLatest("true".equals(getText())); return;
          }
          if (name.equals("LastModified"))
          {
            currentVersionSummary.setLastModified(
              ServiceUtils.parseIso8601Date(getText())); return;
          }
          if (name.equals("ETag"))
          {
            currentVersionSummary.setETag(
              ServiceUtils.removeQuotes(getText())); return;
          }
          if (name.equals("Size"))
          {
            currentVersionSummary.setSize(Long.parseLong(getText())); return;
          }
          if (name.equals("Owner"))
          {
            currentVersionSummary.setOwner(currentOwner);
            currentOwner = null; return;
          }
          if (!name.equals("StorageClass")) {
            return;
          }
          currentVersionSummary.setStorageClass(getText()); return;
        }
        if (!in(new String[] { "ListVersionsResult", "Version", "Owner" }))
        {
          if (!in(new String[] { "ListVersionsResult", "DeleteMarker", "Owner" })) {}
        }
        else if (name.equals("ID")) {
          currentOwner.setId(getText());
        } else if (name.equals("DisplayName")) {
          currentOwner.setDisplayName(getText());
        }
      }
    }
  }
  
  public static class BucketWebsiteConfigurationHandler
    extends AbstractHandler
  {
    private final BucketWebsiteConfiguration configuration = new BucketWebsiteConfiguration(null);
    private RoutingRuleCondition currentCondition = null;
    private RedirectRule currentRedirectRule = null;
    private RoutingRule currentRoutingRule = null;
    
    public BucketWebsiteConfiguration getConfiguration()
    {
      return configuration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "WebsiteConfiguration" }))
      {
        if (name.equals("RedirectAllRequestsTo")) {
          currentRedirectRule = new RedirectRule();
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "RoutingRules" }))
      {
        if (name.equals("RoutingRule")) {
          currentRoutingRule = new RoutingRule();
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule" })) {
        if (name.equals("Condition")) {
          currentCondition = new RoutingRuleCondition();
        } else if (name.equals("Redirect")) {
          currentRedirectRule = new RedirectRule();
        }
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "WebsiteConfiguration" }))
      {
        if (name.equals("RedirectAllRequestsTo"))
        {
          configuration.setRedirectAllRequestsTo(currentRedirectRule);
          currentRedirectRule = null;
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "IndexDocument" }))
      {
        if (name.equals("Suffix")) {
          configuration.setIndexDocumentSuffix(getText());
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "ErrorDocument" }))
      {
        if (name.equals("Key")) {
          configuration.setErrorDocument(getText());
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "RoutingRules" }))
      {
        if (name.equals("RoutingRule"))
        {
          configuration.getRoutingRules().add(currentRoutingRule);
          currentRoutingRule = null;
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule" }))
      {
        if (name.equals("Condition"))
        {
          currentRoutingRule.setCondition(currentCondition);
          currentCondition = null;
        }
        else if (name.equals("Redirect"))
        {
          currentRoutingRule.setRedirect(currentRedirectRule);
          currentRedirectRule = null;
        }
      }
      else if (in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition" }))
      {
        if (name.equals("KeyPrefixEquals")) {
          currentCondition.setKeyPrefixEquals(getText());
        } else if (name.equals("HttpErrorCodeReturnedEquals")) {
          currentCondition.setHttpErrorCodeReturnedEquals(getText());
        }
      }
      else if (!in(new String[] { "WebsiteConfiguration", "RedirectAllRequestsTo" }))
      {
        if (!in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect" })) {}
      }
      else if (name.equals("Protocol")) {
        currentRedirectRule.setProtocol(getText());
      } else if (name.equals("HostName")) {
        currentRedirectRule.setHostName(getText());
      } else if (name.equals("ReplaceKeyPrefixWith")) {
        currentRedirectRule.setReplaceKeyPrefixWith(getText());
      } else if (name.equals("ReplaceKeyWith")) {
        currentRedirectRule.setReplaceKeyWith(getText());
      } else if (name.equals("HttpRedirectCode")) {
        currentRedirectRule.setHttpRedirectCode(getText());
      }
    }
  }
  
  public static class BucketVersioningConfigurationHandler
    extends AbstractHandler
  {
    private final BucketVersioningConfiguration configuration = new BucketVersioningConfiguration();
    
    public BucketVersioningConfiguration getConfiguration()
    {
      return configuration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "VersioningConfiguration" })) {
        if (name.equals("Status"))
        {
          configuration.setStatus(getText());
        }
        else if (name.equals("MfaDelete"))
        {
          String mfaDeleteStatus = getText();
          if (mfaDeleteStatus.equals("Disabled")) {
            configuration.setMfaDeleteEnabled(Boolean.valueOf(false));
          } else if (mfaDeleteStatus.equals("Enabled")) {
            configuration.setMfaDeleteEnabled(Boolean.valueOf(true));
          } else {
            configuration.setMfaDeleteEnabled(null);
          }
        }
      }
    }
  }
  
  public static class BucketAccelerateConfigurationHandler
    extends AbstractHandler
  {
    private final BucketAccelerateConfiguration configuration = new BucketAccelerateConfiguration((String)null);
    
    public BucketAccelerateConfiguration getConfiguration()
    {
      return configuration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if ((in(new String[] { "AccelerateConfiguration" })) && 
        (name.equals("Status"))) {
        configuration.setStatus(getText());
      }
    }
  }
  
  public static class CompleteMultipartUploadHandler
    extends AbstractSSEHandler
    implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult
  {
    private CompleteMultipartUploadResult result;
    private AmazonS3Exception ase;
    private String hostId;
    private String requestId;
    private String errorCode;
    
    protected ServerSideEncryptionResult sseResult()
    {
      return result;
    }
    
    public Date getExpirationTime()
    {
      return result == null ? null : result.getExpirationTime();
    }
    
    public void setExpirationTime(Date expirationTime)
    {
      if (result != null) {
        result.setExpirationTime(expirationTime);
      }
    }
    
    public String getExpirationTimeRuleId()
    {
      return result == null ? null : result.getExpirationTimeRuleId();
    }
    
    public void setExpirationTimeRuleId(String expirationTimeRuleId)
    {
      if (result != null) {
        result.setExpirationTimeRuleId(expirationTimeRuleId);
      }
    }
    
    public void setVersionId(String versionId)
    {
      if (result != null) {
        result.setVersionId(versionId);
      }
    }
    
    public String getVersionId()
    {
      return result == null ? null : result.getVersionId();
    }
    
    public boolean isRequesterCharged()
    {
      return result == null ? false : result.isRequesterCharged();
    }
    
    public void setRequesterCharged(boolean isRequesterCharged)
    {
      if (result != null) {
        result.setRequesterCharged(isRequesterCharged);
      }
    }
    
    public CompleteMultipartUploadResult getCompleteMultipartUploadResult()
    {
      return result;
    }
    
    public AmazonS3Exception getAmazonS3Exception()
    {
      return ase;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if ((atTopLevel()) && 
        (name.equals("CompleteMultipartUploadResult"))) {
        result = new CompleteMultipartUploadResult();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (atTopLevel())
      {
        if ((name.equals("Error")) && 
          (ase != null))
        {
          ase.setErrorCode(errorCode);
          ase.setRequestId(requestId);
          ase.setExtendedRequestId(hostId);
        }
      }
      else if (in(new String[] { "CompleteMultipartUploadResult" }))
      {
        if (name.equals("Location")) {
          result.setLocation(getText());
        } else if (name.equals("Bucket")) {
          result.setBucketName(getText());
        } else if (name.equals("Key")) {
          result.setKey(getText());
        } else if (name.equals("ETag")) {
          result.setETag(ServiceUtils.removeQuotes(getText()));
        }
      }
      else if (in(new String[] { "Error" })) {
        if (name.equals("Code")) {
          errorCode = getText();
        } else if (name.equals("Message")) {
          ase = new AmazonS3Exception(getText());
        } else if (name.equals("RequestId")) {
          requestId = getText();
        } else if (name.equals("HostId")) {
          hostId = getText();
        }
      }
    }
  }
  
  public static class InitiateMultipartUploadHandler
    extends AbstractHandler
  {
    private final InitiateMultipartUploadResult result = new InitiateMultipartUploadResult();
    
    public InitiateMultipartUploadResult getInitiateMultipartUploadResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "InitiateMultipartUploadResult" })) {
        if (name.equals("Bucket")) {
          result.setBucketName(getText());
        } else if (name.equals("Key")) {
          result.setKey(getText());
        } else if (name.equals("UploadId")) {
          result.setUploadId(getText());
        }
      }
    }
  }
  
  public static class ListMultipartUploadsHandler
    extends AbstractHandler
  {
    private final MultipartUploadListing result = new MultipartUploadListing();
    private MultipartUpload currentMultipartUpload;
    private Owner currentOwner;
    
    public MultipartUploadListing getListMultipartUploadsResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListMultipartUploadsResult" }))
      {
        if (name.equals("Upload")) {
          currentMultipartUpload = new MultipartUpload();
        }
      }
      else if ((in(new String[] { "ListMultipartUploadsResult", "Upload" })) && (
        (name.equals("Owner")) || (name.equals("Initiator")))) {
        currentOwner = new Owner();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListMultipartUploadsResult" }))
      {
        if (name.equals("Bucket"))
        {
          result.setBucketName(getText());
        }
        else if (name.equals("KeyMarker"))
        {
          result.setKeyMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("Delimiter"))
        {
          result.setDelimiter(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("Prefix"))
        {
          result.setPrefix(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("UploadIdMarker"))
        {
          result.setUploadIdMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("NextKeyMarker"))
        {
          result.setNextKeyMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("NextUploadIdMarker"))
        {
          result.setNextUploadIdMarker(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("MaxUploads"))
        {
          result.setMaxUploads(Integer.parseInt(getText()));
        }
        else if (name.equals("EncodingType"))
        {
          result.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("IsTruncated"))
        {
          result.setTruncated(Boolean.parseBoolean(getText()));
        }
        else if (name.equals("Upload"))
        {
          result.getMultipartUploads().add(currentMultipartUpload);
          currentMultipartUpload = null;
        }
      }
      else if (in(new String[] { "ListMultipartUploadsResult", "CommonPrefixes" }))
      {
        if (name.equals("Prefix")) {
          result.getCommonPrefixes().add(getText());
        }
      }
      else if (in(new String[] { "ListMultipartUploadsResult", "Upload" }))
      {
        if (name.equals("Key"))
        {
          currentMultipartUpload.setKey(getText());
        }
        else if (name.equals("UploadId"))
        {
          currentMultipartUpload.setUploadId(getText());
        }
        else if (name.equals("Owner"))
        {
          currentMultipartUpload.setOwner(currentOwner);
          currentOwner = null;
        }
        else if (name.equals("Initiator"))
        {
          currentMultipartUpload.setInitiator(currentOwner);
          currentOwner = null;
        }
        else if (name.equals("StorageClass"))
        {
          currentMultipartUpload.setStorageClass(getText());
        }
        else if (name.equals("Initiated"))
        {
          currentMultipartUpload.setInitiated(
            ServiceUtils.parseIso8601Date(getText()));
        }
      }
      else if (!in(new String[] { "ListMultipartUploadsResult", "Upload", "Owner" }))
      {
        if (!in(new String[] { "ListMultipartUploadsResult", "Upload", "Initiator" })) {}
      }
      else if (name.equals("ID")) {
        currentOwner.setId(XmlResponsesSaxParser.checkForEmptyString(getText()));
      } else if (name.equals("DisplayName")) {
        currentOwner.setDisplayName(XmlResponsesSaxParser.checkForEmptyString(getText()));
      }
    }
  }
  
  public static class ListPartsHandler
    extends AbstractHandler
  {
    private final PartListing result = new PartListing();
    private PartSummary currentPart;
    private Owner currentOwner;
    
    public PartListing getListPartsResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListPartsResult" })) {
        if (name.equals("Part")) {
          currentPart = new PartSummary();
        } else if ((name.equals("Owner")) || (name.equals("Initiator"))) {
          currentOwner = new Owner();
        }
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListPartsResult" }))
      {
        if (name.equals("Bucket"))
        {
          result.setBucketName(getText());
        }
        else if (name.equals("Key"))
        {
          result.setKey(getText());
        }
        else if (name.equals("UploadId"))
        {
          result.setUploadId(getText());
        }
        else if (name.equals("Owner"))
        {
          result.setOwner(currentOwner);
          currentOwner = null;
        }
        else if (name.equals("Initiator"))
        {
          result.setInitiator(currentOwner);
          currentOwner = null;
        }
        else if (name.equals("StorageClass"))
        {
          result.setStorageClass(getText());
        }
        else if (name.equals("PartNumberMarker"))
        {
          result.setPartNumberMarker(parseInteger(getText()).intValue());
        }
        else if (name.equals("NextPartNumberMarker"))
        {
          result.setNextPartNumberMarker(parseInteger(getText()).intValue());
        }
        else if (name.equals("MaxParts"))
        {
          result.setMaxParts(parseInteger(getText()).intValue());
        }
        else if (name.equals("EncodingType"))
        {
          result.setEncodingType(XmlResponsesSaxParser.checkForEmptyString(getText()));
        }
        else if (name.equals("IsTruncated"))
        {
          result.setTruncated(Boolean.parseBoolean(getText()));
        }
        else if (name.equals("Part"))
        {
          result.getParts().add(currentPart);
          currentPart = null;
        }
      }
      else if (in(new String[] { "ListPartsResult", "Part" }))
      {
        if (name.equals("PartNumber")) {
          currentPart.setPartNumber(Integer.parseInt(getText()));
        } else if (name.equals("LastModified")) {
          currentPart.setLastModified(
            ServiceUtils.parseIso8601Date(getText()));
        } else if (name.equals("ETag")) {
          currentPart.setETag(ServiceUtils.removeQuotes(getText()));
        } else if (name.equals("Size")) {
          currentPart.setSize(Long.parseLong(getText()));
        }
      }
      else if (!in(new String[] { "ListPartsResult", "Owner" }))
      {
        if (!in(new String[] { "ListPartsResult", "Initiator" })) {}
      }
      else if (name.equals("ID")) {
        currentOwner.setId(XmlResponsesSaxParser.checkForEmptyString(getText()));
      } else if (name.equals("DisplayName")) {
        currentOwner.setDisplayName(XmlResponsesSaxParser.checkForEmptyString(getText()));
      }
    }
    
    private Integer parseInteger(String text)
    {
      text = XmlResponsesSaxParser.checkForEmptyString(getText());
      if (text == null) {
        return null;
      }
      return Integer.valueOf(Integer.parseInt(text));
    }
  }
  
  public static class BucketReplicationConfigurationHandler
    extends AbstractHandler
  {
    private final BucketReplicationConfiguration bucketReplicationConfiguration = new BucketReplicationConfiguration();
    private String currentRuleId;
    private ReplicationRule currentRule;
    private ReplicationFilter currentFilter;
    private List<ReplicationFilterPredicate> andOperandsList;
    private String currentTagKey;
    private String currentTagValue;
    private DeleteMarkerReplication deleteMarkerReplication;
    private ReplicationDestinationConfig destinationConfig;
    private AccessControlTranslation accessControlTranslation;
    private EncryptionConfiguration encryptionConfiguration;
    private SourceSelectionCriteria sourceSelectionCriteria;
    private SseKmsEncryptedObjects sseKmsEncryptedObjects;
    private static final String REPLICATION_CONFIG = "ReplicationConfiguration";
    private static final String ROLE = "Role";
    private static final String RULE = "Rule";
    private static final String DESTINATION = "Destination";
    private static final String ID = "ID";
    private static final String PREFIX = "Prefix";
    private static final String FILTER = "Filter";
    private static final String AND = "And";
    private static final String TAG = "Tag";
    private static final String TAG_KEY = "Key";
    private static final String TAG_VALUE = "Value";
    private static final String DELETE_MARKER_REPLICATION = "DeleteMarkerReplication";
    private static final String PRIORITY = "Priority";
    private static final String STATUS = "Status";
    private static final String BUCKET = "Bucket";
    private static final String STORAGECLASS = "StorageClass";
    private static final String ACCOUNT = "Account";
    private static final String ACCESS_CONTROL_TRANSLATION = "AccessControlTranslation";
    private static final String OWNER = "Owner";
    private static final String ENCRYPTION_CONFIGURATION = "EncryptionConfiguration";
    private static final String REPLICA_KMS_KEY_ID = "ReplicaKmsKeyID";
    private static final String SOURCE_SELECTION_CRITERIA = "SourceSelectionCriteria";
    private static final String SSE_KMS_ENCRYPTED_OBJECTS = "SseKmsEncryptedObjects";
    
    public BucketReplicationConfiguration getConfiguration()
    {
      return bucketReplicationConfiguration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ReplicationConfiguration" }))
      {
        if (name.equals("Rule")) {
          currentRule = new ReplicationRule();
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule" }))
      {
        if (name.equals("Destination")) {
          destinationConfig = new ReplicationDestinationConfig();
        } else if (name.equals("SourceSelectionCriteria")) {
          sourceSelectionCriteria = new SourceSelectionCriteria();
        } else if (name.equals("DeleteMarkerReplication")) {
          deleteMarkerReplication = new DeleteMarkerReplication();
        } else if (name.equals("Filter")) {
          currentFilter = new ReplicationFilter();
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Destination" }))
      {
        if (name.equals("AccessControlTranslation")) {
          accessControlTranslation = new AccessControlTranslation();
        } else if (name.equals("EncryptionConfiguration")) {
          encryptionConfiguration = new EncryptionConfiguration();
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "SourceSelectionCriteria" }))
      {
        if (name.equals("SseKmsEncryptedObjects")) {
          sseKmsEncryptedObjects = new SseKmsEncryptedObjects();
        }
      }
      else if ((in(new String[] { "ReplicationConfiguration", "Rule", "Filter" })) && 
        (name.equals("And"))) {
        andOperandsList = new ArrayList();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ReplicationConfiguration" }))
      {
        if (name.equals("Rule"))
        {
          bucketReplicationConfiguration.addRule(currentRuleId, currentRule);
          
          currentRule = null;
          currentRuleId = null;
          deleteMarkerReplication = null;
          destinationConfig = null;
          sseKmsEncryptedObjects = null;
          accessControlTranslation = null;
          encryptionConfiguration = null;
        }
        else if (name.equals("Role"))
        {
          bucketReplicationConfiguration.setRoleARN(getText());
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule" }))
      {
        if (name.equals("ID"))
        {
          currentRuleId = getText();
        }
        else if (name.equals("Prefix"))
        {
          currentRule.setPrefix(getText());
        }
        else if (name.equals("Priority"))
        {
          currentRule.setPriority(Integer.valueOf(getText()));
        }
        else if (name.equals("DeleteMarkerReplication"))
        {
          currentRule.setDeleteMarkerReplication(deleteMarkerReplication);
        }
        else if (name.equals("SourceSelectionCriteria"))
        {
          currentRule.setSourceSelectionCriteria(sourceSelectionCriteria);
        }
        else if (name.equals("Filter"))
        {
          currentRule.setFilter(currentFilter);
          currentFilter = null;
        }
        else if (name.equals("Status"))
        {
          currentRule.setStatus(getText());
        }
        else if (name.equals("Destination"))
        {
          currentRule.setDestinationConfig(destinationConfig);
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter" }))
      {
        if (name.equals("Prefix"))
        {
          currentFilter.setPredicate(new ReplicationPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          currentFilter.setPredicate(new ReplicationTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
        else if (name.equals("And"))
        {
          currentFilter.setPredicate(new ReplicationAndOperator(andOperandsList));
          andOperandsList = null;
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter", "And" }))
      {
        if (name.equals("Prefix"))
        {
          andOperandsList.add(new ReplicationPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          andOperandsList.add(new ReplicationTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter", "And", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "SourceSelectionCriteria" }))
      {
        if (name.equals("SseKmsEncryptedObjects")) {
          sourceSelectionCriteria.setSseKmsEncryptedObjects(sseKmsEncryptedObjects);
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "SourceSelectionCriteria", "SseKmsEncryptedObjects" }))
      {
        if (name.equals("Status")) {
          sseKmsEncryptedObjects.setStatus(getText());
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "DeleteMarkerReplication" }))
      {
        if (name.equals("Status")) {
          deleteMarkerReplication.setStatus(getText());
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Destination" }))
      {
        if (name.equals("Bucket")) {
          destinationConfig.setBucketARN(getText());
        } else if (name.equals("StorageClass")) {
          destinationConfig.setStorageClass(getText());
        } else if (name.equals("Account")) {
          destinationConfig.setAccount(getText());
        } else if (name.equals("AccessControlTranslation")) {
          destinationConfig.setAccessControlTranslation(accessControlTranslation);
        } else if (name.equals("EncryptionConfiguration")) {
          destinationConfig.setEncryptionConfiguration(encryptionConfiguration);
        }
      }
      else if (in(new String[] { "ReplicationConfiguration", "Rule", "Destination", "AccessControlTranslation" }))
      {
        if (name.equals("Owner")) {
          accessControlTranslation.setOwner(getText());
        }
      }
      else if ((in(new String[] { "ReplicationConfiguration", "Rule", "Destination", "EncryptionConfiguration" })) && 
        (name.equals("ReplicaKmsKeyID"))) {
        encryptionConfiguration.setReplicaKmsKeyID(getText());
      }
    }
  }
  
  public static class BucketTaggingConfigurationHandler
    extends AbstractHandler
  {
    private final BucketTaggingConfiguration configuration = new BucketTaggingConfiguration();
    private Map<String, String> currentTagSet;
    private String currentTagKey;
    private String currentTagValue;
    
    public BucketTaggingConfiguration getConfiguration()
    {
      return configuration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if ((in(new String[] { "Tagging" })) && 
        (name.equals("TagSet"))) {
        currentTagSet = new LinkedHashMap();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "Tagging" }))
      {
        if (name.equals("TagSet"))
        {
          configuration.getAllTagSets().add(new TagSet(currentTagSet));
          currentTagSet = null;
        }
      }
      else if (in(new String[] { "Tagging", "TagSet" }))
      {
        if (name.equals("Tag"))
        {
          if ((currentTagKey != null) && (currentTagValue != null)) {
            currentTagSet.put(currentTagKey, currentTagValue);
          }
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "Tagging", "TagSet", "Tag" })) {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
    }
  }
  
  public static class GetObjectTaggingHandler
    extends AbstractHandler
  {
    private GetObjectTaggingResult getObjectTaggingResult;
    private List<Tag> tagSet;
    private String currentTagValue;
    private String currentTagKey;
    
    public GetObjectTaggingResult getResult()
    {
      return getObjectTaggingResult;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if ((in(new String[] { "Tagging" })) && 
        (name.equals("TagSet"))) {
        tagSet = new ArrayList();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if ((in(new String[] { "Tagging" })) && 
        (name.equals("TagSet")))
      {
        getObjectTaggingResult = new GetObjectTaggingResult(tagSet);
        tagSet = null;
      }
      if (in(new String[] { "Tagging", "TagSet" }))
      {
        if (name.equals("Tag"))
        {
          tagSet.add(new Tag(currentTagKey, currentTagValue));
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "Tagging", "TagSet", "Tag" })) {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
    }
  }
  
  public static class DeleteObjectsHandler
    extends AbstractHandler
  {
    private final DeleteObjectsResponse response = new DeleteObjectsResponse();
    private DeleteObjectsResult.DeletedObject currentDeletedObject = null;
    private MultiObjectDeleteException.DeleteError currentError = null;
    
    public DeleteObjectsResponse getDeleteObjectResult()
    {
      return response;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "DeleteResult" })) {
        if (name.equals("Deleted")) {
          currentDeletedObject = new DeleteObjectsResult.DeletedObject();
        } else if (name.equals("Error")) {
          currentError = new MultiObjectDeleteException.DeleteError();
        }
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "DeleteResult" }))
      {
        if (name.equals("Deleted"))
        {
          response.getDeletedObjects().add(currentDeletedObject);
          currentDeletedObject = null;
        }
        else if (name.equals("Error"))
        {
          response.getErrors().add(currentError);
          currentError = null;
        }
      }
      else if (in(new String[] { "DeleteResult", "Deleted" }))
      {
        if (name.equals("Key")) {
          currentDeletedObject.setKey(getText());
        } else if (name.equals("VersionId")) {
          currentDeletedObject.setVersionId(getText());
        } else if (name.equals("DeleteMarker")) {
          currentDeletedObject.setDeleteMarker(
            getText().equals("true"));
        } else if (name.equals("DeleteMarkerVersionId")) {
          currentDeletedObject.setDeleteMarkerVersionId(getText());
        }
      }
      else if (in(new String[] { "DeleteResult", "Error" })) {
        if (name.equals("Key")) {
          currentError.setKey(getText());
        } else if (name.equals("VersionId")) {
          currentError.setVersionId(getText());
        } else if (name.equals("Code")) {
          currentError.setCode(getText());
        } else if (name.equals("Message")) {
          currentError.setMessage(getText());
        }
      }
    }
  }
  
  public static class BucketLifecycleConfigurationHandler
    extends AbstractHandler
  {
    private final BucketLifecycleConfiguration configuration = new BucketLifecycleConfiguration(new ArrayList());
    private BucketLifecycleConfiguration.Rule currentRule;
    private BucketLifecycleConfiguration.Transition currentTransition;
    private BucketLifecycleConfiguration.NoncurrentVersionTransition currentNcvTransition;
    private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
    private LifecycleFilter currentFilter;
    private List<LifecycleFilterPredicate> andOperandsList;
    private String currentTagKey;
    private String currentTagValue;
    
    public BucketLifecycleConfiguration getConfiguration()
    {
      return configuration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "LifecycleConfiguration" }))
      {
        if (name.equals("Rule")) {
          currentRule = new BucketLifecycleConfiguration.Rule();
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule" }))
      {
        if (name.equals("Transition")) {
          currentTransition = new BucketLifecycleConfiguration.Transition();
        } else if (name.equals("NoncurrentVersionTransition")) {
          currentNcvTransition = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
        } else if (name.equals("AbortIncompleteMultipartUpload")) {
          abortIncompleteMultipartUpload = new AbortIncompleteMultipartUpload();
        } else if (name.equals("Filter")) {
          currentFilter = new LifecycleFilter();
        }
      }
      else if ((in(new String[] { "LifecycleConfiguration", "Rule", "Filter" })) && 
        (name.equals("And"))) {
        andOperandsList = new ArrayList();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "LifecycleConfiguration" }))
      {
        if (name.equals("Rule"))
        {
          configuration.getRules().add(currentRule);
          currentRule = null;
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule" }))
      {
        if (name.equals("ID"))
        {
          currentRule.setId(getText());
        }
        else if (name.equals("Prefix"))
        {
          currentRule.setPrefix(getText());
        }
        else if (name.equals("Status"))
        {
          currentRule.setStatus(getText());
        }
        else if (name.equals("Transition"))
        {
          currentRule.addTransition(currentTransition);
          currentTransition = null;
        }
        else if (name.equals("NoncurrentVersionTransition"))
        {
          currentRule.addNoncurrentVersionTransition(currentNcvTransition);
          
          currentNcvTransition = null;
        }
        else if (name.equals("AbortIncompleteMultipartUpload"))
        {
          currentRule.setAbortIncompleteMultipartUpload(abortIncompleteMultipartUpload);
          abortIncompleteMultipartUpload = null;
        }
        else if (name.equals("Filter"))
        {
          currentRule.setFilter(currentFilter);
          currentFilter = null;
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "Expiration" }))
      {
        if (name.equals("Date")) {
          currentRule.setExpirationDate(ServiceUtils.parseIso8601Date(getText()));
        } else if (name.equals("Days")) {
          currentRule.setExpirationInDays(Integer.parseInt(getText()));
        } else if ((name.equals("ExpiredObjectDeleteMarker")) && 
          ("true".equals(getText()))) {
          currentRule.setExpiredObjectDeleteMarker(true);
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "Transition" }))
      {
        if (name.equals("StorageClass")) {
          currentTransition.setStorageClass(getText());
        } else if (name.equals("Date")) {
          currentTransition.setDate(
            ServiceUtils.parseIso8601Date(getText()));
        } else if (name.equals("Days")) {
          currentTransition.setDays(Integer.parseInt(getText()));
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration" }))
      {
        if (name.equals("NoncurrentDays")) {
          currentRule.setNoncurrentVersionExpirationInDays(
            Integer.parseInt(getText()));
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "NoncurrentVersionTransition" }))
      {
        if (name.equals("StorageClass")) {
          currentNcvTransition.setStorageClass(getText());
        } else if (name.equals("NoncurrentDays")) {
          currentNcvTransition.setDays(Integer.parseInt(getText()));
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload" }))
      {
        if (name.equals("DaysAfterInitiation")) {
          abortIncompleteMultipartUpload.setDaysAfterInitiation(Integer.parseInt(getText()));
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter" }))
      {
        if (name.equals("Prefix"))
        {
          currentFilter.setPredicate(new LifecyclePrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          currentFilter.setPredicate(new LifecycleTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
        else if (name.equals("And"))
        {
          currentFilter.setPredicate(new LifecycleAndOperator(andOperandsList));
          andOperandsList = null;
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter", "And" }))
      {
        if (name.equals("Prefix"))
        {
          andOperandsList.add(new LifecyclePrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          andOperandsList.add(new LifecycleTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter", "And", "Tag" })) {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
    }
  }
  
  public static class BucketCrossOriginConfigurationHandler
    extends AbstractHandler
  {
    private final BucketCrossOriginConfiguration configuration = new BucketCrossOriginConfiguration(new ArrayList());
    private CORSRule currentRule;
    private List<CORSRule.AllowedMethods> allowedMethods = null;
    private List<String> allowedOrigins = null;
    private List<String> exposedHeaders = null;
    private List<String> allowedHeaders = null;
    
    public BucketCrossOriginConfiguration getConfiguration()
    {
      return configuration;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "CORSConfiguration" }))
      {
        if (name.equals("CORSRule")) {
          currentRule = new CORSRule();
        }
      }
      else if (in(new String[] { "CORSConfiguration", "CORSRule" })) {
        if (name.equals("AllowedOrigin"))
        {
          if (allowedOrigins == null) {
            allowedOrigins = new ArrayList();
          }
        }
        else if (name.equals("AllowedMethod"))
        {
          if (allowedMethods == null) {
            allowedMethods = new ArrayList();
          }
        }
        else if (name.equals("ExposeHeader"))
        {
          if (exposedHeaders == null) {
            exposedHeaders = new ArrayList();
          }
        }
        else if ((name.equals("AllowedHeader")) && 
          (allowedHeaders == null)) {
          allowedHeaders = new LinkedList();
        }
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "CORSConfiguration" }))
      {
        if (name.equals("CORSRule"))
        {
          currentRule.setAllowedHeaders(allowedHeaders);
          currentRule.setAllowedMethods(allowedMethods);
          currentRule.setAllowedOrigins(allowedOrigins);
          currentRule.setExposedHeaders(exposedHeaders);
          allowedHeaders = null;
          allowedMethods = null;
          allowedOrigins = null;
          exposedHeaders = null;
          
          configuration.getRules().add(currentRule);
          currentRule = null;
        }
      }
      else if (in(new String[] { "CORSConfiguration", "CORSRule" })) {
        if (name.equals("ID")) {
          currentRule.setId(getText());
        } else if (name.equals("AllowedOrigin")) {
          allowedOrigins.add(getText());
        } else if (name.equals("AllowedMethod")) {
          allowedMethods.add(CORSRule.AllowedMethods.fromValue(getText()));
        } else if (name.equals("MaxAgeSeconds")) {
          currentRule.setMaxAgeSeconds(Integer.parseInt(getText()));
        } else if (name.equals("ExposeHeader")) {
          exposedHeaders.add(getText());
        } else if (name.equals("AllowedHeader")) {
          allowedHeaders.add(getText());
        }
      }
    }
  }
  
  public static class GetBucketMetricsConfigurationHandler
    extends AbstractHandler
  {
    private final MetricsConfiguration configuration = new MetricsConfiguration();
    private MetricsFilter filter;
    private List<MetricsFilterPredicate> andOperandsList;
    private String currentTagKey;
    private String currentTagValue;
    
    public GetBucketMetricsConfigurationResult getResult()
    {
      return new GetBucketMetricsConfigurationResult().withMetricsConfiguration(configuration);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "MetricsConfiguration" }))
      {
        if (name.equals("Filter")) {
          filter = new MetricsFilter();
        }
      }
      else if ((in(new String[] { "MetricsConfiguration", "Filter" })) && 
        (name.equals("And"))) {
        andOperandsList = new ArrayList();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "MetricsConfiguration" }))
      {
        if (name.equals("Id"))
        {
          configuration.setId(getText());
        }
        else if (name.equals("Filter"))
        {
          configuration.setFilter(filter);
          filter = null;
        }
      }
      else if (in(new String[] { "MetricsConfiguration", "Filter" }))
      {
        if (name.equals("Prefix"))
        {
          filter.setPredicate(new MetricsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          filter.setPredicate(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
        else if (name.equals("And"))
        {
          filter.setPredicate(new MetricsAndOperator(andOperandsList));
          andOperandsList = null;
        }
      }
      else if (in(new String[] { "MetricsConfiguration", "Filter", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "MetricsConfiguration", "Filter", "And" }))
      {
        if (name.equals("Prefix"))
        {
          andOperandsList.add(new MetricsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          andOperandsList.add(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "MetricsConfiguration", "Filter", "And", "Tag" })) {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
    }
  }
  
  public static class ListBucketMetricsConfigurationsHandler
    extends AbstractHandler
  {
    private final ListBucketMetricsConfigurationsResult result = new ListBucketMetricsConfigurationsResult();
    private MetricsConfiguration currentConfiguration;
    private MetricsFilter currentFilter;
    private List<MetricsFilterPredicate> andOperandsList;
    private String currentTagKey;
    private String currentTagValue;
    
    public ListBucketMetricsConfigurationsResult getResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListMetricsConfigurationsResult" }))
      {
        if (name.equals("MetricsConfiguration")) {
          currentConfiguration = new MetricsConfiguration();
        }
      }
      else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration" }))
      {
        if (name.equals("Filter")) {
          currentFilter = new MetricsFilter();
        }
      }
      else if ((in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter" })) && 
        (name.equals("And"))) {
        andOperandsList = new ArrayList();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListMetricsConfigurationsResult" }))
      {
        if (name.equals("MetricsConfiguration"))
        {
          if (result.getMetricsConfigurationList() == null) {
            result.setMetricsConfigurationList(new ArrayList());
          }
          result.getMetricsConfigurationList().add(currentConfiguration);
          currentConfiguration = null;
        }
        else if (name.equals("IsTruncated"))
        {
          result.setTruncated("true".equals(getText()));
        }
        else if (name.equals("ContinuationToken"))
        {
          result.setContinuationToken(getText());
        }
        else if (name.equals("NextContinuationToken"))
        {
          result.setNextContinuationToken(getText());
        }
      }
      else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration" }))
      {
        if (name.equals("Id"))
        {
          currentConfiguration.setId(getText());
        }
        else if (name.equals("Filter"))
        {
          currentConfiguration.setFilter(currentFilter);
          currentFilter = null;
        }
      }
      else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter" }))
      {
        if (name.equals("Prefix"))
        {
          currentFilter.setPredicate(new MetricsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          currentFilter.setPredicate(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
        else if (name.equals("And"))
        {
          currentFilter.setPredicate(new MetricsAndOperator(andOperandsList));
          andOperandsList = null;
        }
      }
      else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And" }))
      {
        if (name.equals("Prefix"))
        {
          andOperandsList.add(new MetricsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          andOperandsList.add(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag" })) {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
    }
  }
  
  public static class GetBucketAnalyticsConfigurationHandler
    extends AbstractHandler
  {
    private final AnalyticsConfiguration configuration = new AnalyticsConfiguration();
    private AnalyticsFilter filter;
    private List<AnalyticsFilterPredicate> andOperandsList;
    private StorageClassAnalysis storageClassAnalysis;
    private StorageClassAnalysisDataExport dataExport;
    private AnalyticsExportDestination destination;
    private AnalyticsS3BucketDestination s3BucketDestination;
    private String currentTagKey;
    private String currentTagValue;
    
    public GetBucketAnalyticsConfigurationResult getResult()
    {
      return new GetBucketAnalyticsConfigurationResult().withAnalyticsConfiguration(configuration);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "AnalyticsConfiguration" }))
      {
        if (name.equals("Filter")) {
          filter = new AnalyticsFilter();
        } else if (name.equals("StorageClassAnalysis")) {
          storageClassAnalysis = new StorageClassAnalysis();
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "Filter" }))
      {
        if (name.equals("And")) {
          andOperandsList = new ArrayList();
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis" }))
      {
        if (name.equals("DataExport")) {
          dataExport = new StorageClassAnalysisDataExport();
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport" }))
      {
        if (name.equals("Destination")) {
          destination = new AnalyticsExportDestination();
        }
      }
      else if ((in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination" })) && 
        (name.equals("S3BucketDestination"))) {
        s3BucketDestination = new AnalyticsS3BucketDestination();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "AnalyticsConfiguration" }))
      {
        if (name.equals("Id")) {
          configuration.setId(getText());
        } else if (name.equals("Filter")) {
          configuration.setFilter(filter);
        } else if (name.equals("StorageClassAnalysis")) {
          configuration.setStorageClassAnalysis(storageClassAnalysis);
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "Filter" }))
      {
        if (name.equals("Prefix"))
        {
          filter.setPredicate(new AnalyticsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          filter.setPredicate(new AnalyticsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
        else if (name.equals("And"))
        {
          filter.setPredicate(new AnalyticsAndOperator(andOperandsList));
          andOperandsList = null;
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "Filter", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "Filter", "And" }))
      {
        if (name.equals("Prefix"))
        {
          andOperandsList.add(new AnalyticsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          andOperandsList.add(new AnalyticsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "Filter", "And", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis" }))
      {
        if (name.equals("DataExport")) {
          storageClassAnalysis.setDataExport(dataExport);
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport" }))
      {
        if (name.equals("OutputSchemaVersion")) {
          dataExport.setOutputSchemaVersion(getText());
        } else if (name.equals("Destination")) {
          dataExport.setDestination(destination);
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination" }))
      {
        if (name.equals("S3BucketDestination")) {
          destination.setS3BucketDestination(s3BucketDestination);
        }
      }
      else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination" })) {
        if (name.equals("Format")) {
          s3BucketDestination.setFormat(getText());
        } else if (name.equals("BucketAccountId")) {
          s3BucketDestination.setBucketAccountId(getText());
        } else if (name.equals("Bucket")) {
          s3BucketDestination.setBucketArn(getText());
        } else if (name.equals("Prefix")) {
          s3BucketDestination.setPrefix(getText());
        }
      }
    }
  }
  
  public static class ListBucketAnalyticsConfigurationHandler
    extends AbstractHandler
  {
    private final ListBucketAnalyticsConfigurationsResult result = new ListBucketAnalyticsConfigurationsResult();
    private AnalyticsConfiguration currentConfiguration;
    private AnalyticsFilter currentFilter;
    private List<AnalyticsFilterPredicate> andOperandsList;
    private StorageClassAnalysis storageClassAnalysis;
    private StorageClassAnalysisDataExport dataExport;
    private AnalyticsExportDestination destination;
    private AnalyticsS3BucketDestination s3BucketDestination;
    private String currentTagKey;
    private String currentTagValue;
    
    public ListBucketAnalyticsConfigurationsResult getResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListBucketAnalyticsConfigurationsResult" }))
      {
        if (name.equals("AnalyticsConfiguration")) {
          currentConfiguration = new AnalyticsConfiguration();
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration" }))
      {
        if (name.equals("Filter")) {
          currentFilter = new AnalyticsFilter();
        } else if (name.equals("StorageClassAnalysis")) {
          storageClassAnalysis = new StorageClassAnalysis();
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter" }))
      {
        if (name.equals("And")) {
          andOperandsList = new ArrayList();
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis" }))
      {
        if (name.equals("DataExport")) {
          dataExport = new StorageClassAnalysisDataExport();
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport" }))
      {
        if (name.equals("Destination")) {
          destination = new AnalyticsExportDestination();
        }
      }
      else if ((in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination" })) && 
        (name.equals("S3BucketDestination"))) {
        s3BucketDestination = new AnalyticsS3BucketDestination();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListBucketAnalyticsConfigurationsResult" }))
      {
        if (name.equals("AnalyticsConfiguration"))
        {
          if (result.getAnalyticsConfigurationList() == null) {
            result.setAnalyticsConfigurationList(new ArrayList());
          }
          result.getAnalyticsConfigurationList().add(currentConfiguration);
          currentConfiguration = null;
        }
        else if (name.equals("IsTruncated"))
        {
          result.setTruncated("true".equals(getText()));
        }
        else if (name.equals("ContinuationToken"))
        {
          result.setContinuationToken(getText());
        }
        else if (name.equals("NextContinuationToken"))
        {
          result.setNextContinuationToken(getText());
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration" }))
      {
        if (name.equals("Id")) {
          currentConfiguration.setId(getText());
        } else if (name.equals("Filter")) {
          currentConfiguration.setFilter(currentFilter);
        } else if (name.equals("StorageClassAnalysis")) {
          currentConfiguration.setStorageClassAnalysis(storageClassAnalysis);
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter" }))
      {
        if (name.equals("Prefix"))
        {
          currentFilter.setPredicate(new AnalyticsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          currentFilter.setPredicate(new AnalyticsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
        else if (name.equals("And"))
        {
          currentFilter.setPredicate(new AnalyticsAndOperator(andOperandsList));
          andOperandsList = null;
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And" }))
      {
        if (name.equals("Prefix"))
        {
          andOperandsList.add(new AnalyticsPrefixPredicate(getText()));
        }
        else if (name.equals("Tag"))
        {
          andOperandsList.add(new AnalyticsTagPredicate(new Tag(currentTagKey, currentTagValue)));
          currentTagKey = null;
          currentTagValue = null;
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And", "Tag" }))
      {
        if (name.equals("Key")) {
          currentTagKey = getText();
        } else if (name.equals("Value")) {
          currentTagValue = getText();
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis" }))
      {
        if (name.equals("DataExport")) {
          storageClassAnalysis.setDataExport(dataExport);
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport" }))
      {
        if (name.equals("OutputSchemaVersion")) {
          dataExport.setOutputSchemaVersion(getText());
        } else if (name.equals("Destination")) {
          dataExport.setDestination(destination);
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination" }))
      {
        if (name.equals("S3BucketDestination")) {
          destination.setS3BucketDestination(s3BucketDestination);
        }
      }
      else if (in(new String[] { "ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination" })) {
        if (name.equals("Format")) {
          s3BucketDestination.setFormat(getText());
        } else if (name.equals("BucketAccountId")) {
          s3BucketDestination.setBucketAccountId(getText());
        } else if (name.equals("Bucket")) {
          s3BucketDestination.setBucketArn(getText());
        } else if (name.equals("Prefix")) {
          s3BucketDestination.setPrefix(getText());
        }
      }
    }
  }
  
  public static class GetBucketInventoryConfigurationHandler
    extends AbstractHandler
  {
    public static final String SSE_S3 = "SSE-S3";
    public static final String SSE_KMS = "SSE-KMS";
    private final GetBucketInventoryConfigurationResult result = new GetBucketInventoryConfigurationResult();
    private final InventoryConfiguration configuration = new InventoryConfiguration();
    private List<String> optionalFields;
    private InventoryDestination inventoryDestination;
    private InventoryFilter filter;
    private InventoryS3BucketDestination s3BucketDestination;
    private InventorySchedule inventorySchedule;
    
    public GetBucketInventoryConfigurationResult getResult()
    {
      return result.withInventoryConfiguration(configuration);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "InventoryConfiguration" }))
      {
        if (name.equals("Destination")) {
          inventoryDestination = new InventoryDestination();
        } else if (name.equals("Filter")) {
          filter = new InventoryFilter();
        } else if (name.equals("Schedule")) {
          inventorySchedule = new InventorySchedule();
        } else if (name.equals("OptionalFields")) {
          optionalFields = new ArrayList();
        }
      }
      else if ((in(new String[] { "InventoryConfiguration", "Destination" })) && 
        (name.equals("S3BucketDestination"))) {
        s3BucketDestination = new InventoryS3BucketDestination();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "InventoryConfiguration" }))
      {
        if (name.equals("Id"))
        {
          configuration.setId(getText());
        }
        else if (name.equals("Destination"))
        {
          configuration.setDestination(inventoryDestination);
          inventoryDestination = null;
        }
        else if (name.equals("IsEnabled"))
        {
          configuration.setEnabled(Boolean.valueOf("true".equals(getText())));
        }
        else if (name.equals("Filter"))
        {
          configuration.setInventoryFilter(filter);
          filter = null;
        }
        else if (name.equals("IncludedObjectVersions"))
        {
          configuration.setIncludedObjectVersions(getText());
        }
        else if (name.equals("Schedule"))
        {
          configuration.setSchedule(inventorySchedule);
          inventorySchedule = null;
        }
        else if (name.equals("OptionalFields"))
        {
          configuration.setOptionalFields(optionalFields);
          optionalFields = null;
        }
      }
      else if (in(new String[] { "InventoryConfiguration", "Destination" }))
      {
        if (name.equals("S3BucketDestination"))
        {
          inventoryDestination.setS3BucketDestination(s3BucketDestination);
          s3BucketDestination = null;
        }
      }
      else if (in(new String[] { "InventoryConfiguration", "Destination", "S3BucketDestination" }))
      {
        if (name.equals("AccountId")) {
          s3BucketDestination.setAccountId(getText());
        } else if (name.equals("Bucket")) {
          s3BucketDestination.setBucketArn(getText());
        } else if (name.equals("Format")) {
          s3BucketDestination.setFormat(getText());
        } else if (name.equals("Prefix")) {
          s3BucketDestination.setPrefix(getText());
        }
      }
      else if (in(new String[] { "InventoryConfiguration", "Destination", "S3BucketDestination", "Encryption" }))
      {
        if (name.equals("SSE-S3"))
        {
          s3BucketDestination.setEncryption(new ServerSideEncryptionS3());
        }
        else if (name.equals("SSE-KMS"))
        {
          ServerSideEncryptionKMS kmsEncryption = new ServerSideEncryptionKMS().withKeyId(getText());
          s3BucketDestination.setEncryption(kmsEncryption);
        }
      }
      else if (in(new String[] { "InventoryConfiguration", "Filter" }))
      {
        if (name.equals("Prefix")) {
          filter.setPredicate(new InventoryPrefixPredicate(getText()));
        }
      }
      else if (in(new String[] { "InventoryConfiguration", "Schedule" }))
      {
        if (name.equals("Frequency")) {
          inventorySchedule.setFrequency(getText());
        }
      }
      else if ((in(new String[] { "InventoryConfiguration", "OptionalFields" })) && 
        (name.equals("Field"))) {
        optionalFields.add(getText());
      }
    }
  }
  
  public static class ListBucketInventoryConfigurationsHandler
    extends AbstractHandler
  {
    private final ListBucketInventoryConfigurationsResult result = new ListBucketInventoryConfigurationsResult();
    private InventoryConfiguration currentConfiguration;
    private List<String> currentOptionalFieldsList;
    private InventoryDestination currentDestination;
    private InventoryFilter currentFilter;
    private InventoryS3BucketDestination currentS3BucketDestination;
    private InventorySchedule currentSchedule;
    
    public ListBucketInventoryConfigurationsResult getResult()
    {
      return result;
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ListInventoryConfigurationsResult" }))
      {
        if (name.equals("InventoryConfiguration")) {
          currentConfiguration = new InventoryConfiguration();
        }
      }
      else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration" }))
      {
        if (name.equals("Destination")) {
          currentDestination = new InventoryDestination();
        } else if (name.equals("Filter")) {
          currentFilter = new InventoryFilter();
        } else if (name.equals("Schedule")) {
          currentSchedule = new InventorySchedule();
        } else if (name.equals("OptionalFields")) {
          currentOptionalFieldsList = new ArrayList();
        }
      }
      else if ((in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination" })) && 
        (name.equals("S3BucketDestination"))) {
        currentS3BucketDestination = new InventoryS3BucketDestination();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ListInventoryConfigurationsResult" }))
      {
        if (name.equals("InventoryConfiguration"))
        {
          if (result.getInventoryConfigurationList() == null) {
            result.setInventoryConfigurationList(new ArrayList());
          }
          result.getInventoryConfigurationList().add(currentConfiguration);
          currentConfiguration = null;
        }
        else if (name.equals("IsTruncated"))
        {
          result.setTruncated("true".equals(getText()));
        }
        else if (name.equals("ContinuationToken"))
        {
          result.setContinuationToken(getText());
        }
        else if (name.equals("NextContinuationToken"))
        {
          result.setNextContinuationToken(getText());
        }
      }
      else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration" }))
      {
        if (name.equals("Id"))
        {
          currentConfiguration.setId(getText());
        }
        else if (name.equals("Destination"))
        {
          currentConfiguration.setDestination(currentDestination);
          currentDestination = null;
        }
        else if (name.equals("IsEnabled"))
        {
          currentConfiguration.setEnabled(Boolean.valueOf("true".equals(getText())));
        }
        else if (name.equals("Filter"))
        {
          currentConfiguration.setInventoryFilter(currentFilter);
          currentFilter = null;
        }
        else if (name.equals("IncludedObjectVersions"))
        {
          currentConfiguration.setIncludedObjectVersions(getText());
        }
        else if (name.equals("Schedule"))
        {
          currentConfiguration.setSchedule(currentSchedule);
          currentSchedule = null;
        }
        else if (name.equals("OptionalFields"))
        {
          currentConfiguration.setOptionalFields(currentOptionalFieldsList);
          currentOptionalFieldsList = null;
        }
      }
      else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination" }))
      {
        if (name.equals("S3BucketDestination"))
        {
          currentDestination.setS3BucketDestination(currentS3BucketDestination);
          currentS3BucketDestination = null;
        }
      }
      else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination" }))
      {
        if (name.equals("AccountId")) {
          currentS3BucketDestination.setAccountId(getText());
        } else if (name.equals("Bucket")) {
          currentS3BucketDestination.setBucketArn(getText());
        } else if (name.equals("Format")) {
          currentS3BucketDestination.setFormat(getText());
        } else if (name.equals("Prefix")) {
          currentS3BucketDestination.setPrefix(getText());
        }
      }
      else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter" }))
      {
        if (name.equals("Prefix")) {
          currentFilter.setPredicate(new InventoryPrefixPredicate(getText()));
        }
      }
      else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Schedule" }))
      {
        if (name.equals("Frequency")) {
          currentSchedule.setFrequency(getText());
        }
      }
      else if ((in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields" })) && 
        (name.equals("Field"))) {
        currentOptionalFieldsList.add(getText());
      }
    }
  }
  
  public static class GetObjectLegalHoldResponseHandler
    extends AbstractHandler
  {
    private GetObjectLegalHoldResult getObjectLegalHoldResult = new GetObjectLegalHoldResult();
    private ObjectLockLegalHold legalHold = new ObjectLockLegalHold();
    
    public GetObjectLegalHoldResult getResult()
    {
      return getObjectLegalHoldResult.withLegalHold(legalHold);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if ((in(new String[] { "LegalHold" })) && 
        ("Status".equals(name))) {
        legalHold.setStatus(getText());
      }
    }
  }
  
  public static class GetObjectLockConfigurationResponseHandler
    extends AbstractHandler
  {
    private GetObjectLockConfigurationResult result = new GetObjectLockConfigurationResult();
    private ObjectLockConfiguration objectLockConfiguration = new ObjectLockConfiguration();
    private ObjectLockRule rule;
    private DefaultRetention defaultRetention;
    
    public GetObjectLockConfigurationResult getResult()
    {
      return result.withObjectLockConfiguration(objectLockConfiguration);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs)
    {
      if (in(new String[] { "ObjectLockConfiguration" }))
      {
        if ("Rule".equals(name)) {
          rule = new ObjectLockRule();
        }
      }
      else if ((in(new String[] { "ObjectLockConfiguration", "Rule" })) && 
        ("DefaultRetention".equals(name))) {
        defaultRetention = new DefaultRetention();
      }
    }
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "ObjectLockConfiguration" }))
      {
        if ("ObjectLockEnabled".equals(name)) {
          objectLockConfiguration.setObjectLockEnabled(getText());
        } else if ("Rule".equals(name)) {
          objectLockConfiguration.setRule(rule);
        }
      }
      else if (in(new String[] { "ObjectLockConfiguration", "Rule" }))
      {
        if ("DefaultRetention".equals(name)) {
          rule.setDefaultRetention(defaultRetention);
        }
      }
      else if (in(new String[] { "ObjectLockConfiguration", "Rule", "DefaultRetention" })) {
        if ("Mode".equals(name)) {
          defaultRetention.setMode(getText());
        } else if ("Days".equals(name)) {
          defaultRetention.setDays(Integer.valueOf(Integer.parseInt(getText())));
        } else if ("Years".equals(name)) {
          defaultRetention.setYears(Integer.valueOf(Integer.parseInt(getText())));
        }
      }
    }
  }
  
  public static class GetObjectRetentionResponseHandler
    extends AbstractHandler
  {
    private GetObjectRetentionResult result = new GetObjectRetentionResult();
    private ObjectLockRetention retention = new ObjectLockRetention();
    
    public GetObjectRetentionResult getResult()
    {
      return result.withRetention(retention);
    }
    
    protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
    
    protected void doEndElement(String uri, String name, String qName)
    {
      if (in(new String[] { "Retention" })) {
        if ("Mode".equals(name)) {
          retention.setMode(getText());
        } else if ("RetainUntilDate".equals(name)) {
          retention.setRetainUntilDate(ServiceUtils.parseIso8601Date(getText()));
        }
      }
    }
  }
  
  private static String findAttributeValue(String qnameToFind, Attributes attrs)
  {
    for (int i = 0; i < attrs.getLength(); i++)
    {
      String qname = attrs.getQName(i);
      if (qname.trim().equalsIgnoreCase(qnameToFind.trim())) {
        return attrs.getValue(i);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */