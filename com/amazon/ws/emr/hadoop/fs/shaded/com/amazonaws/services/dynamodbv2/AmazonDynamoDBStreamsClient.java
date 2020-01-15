package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonClientMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorShapeMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonOperationMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonProtocolFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeStreamRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeStreamResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ExpiredIteratorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetRecordsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetRecordsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetShardIteratorRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetShardIteratorResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListStreamsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListStreamsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TrimmedDataAccessExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.List;

@ThreadSafe
public class AmazonDynamoDBStreamsClient
  extends AmazonWebServiceClient
  implements AmazonDynamoDBStreams
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AmazonDynamoDBStreams.class);
  private static final String DEFAULT_SIGNING_NAME = "dynamodb";
  protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  private static final SdkJsonProtocolFactory protocolFactory = new SdkJsonProtocolFactory(new JsonClientMetadata()
  
    .withProtocolVersion("1.0")
    .withSupportsCbor(false)
    .withSupportsIon(false)
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TrimmedDataAccessException").withExceptionUnmarshaller(
    TrimmedDataAccessExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ResourceNotFoundException").withExceptionUnmarshaller(
    ResourceNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ExpiredIteratorException").withExceptionUnmarshaller(
    ExpiredIteratorExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InternalServerError").withExceptionUnmarshaller(
    InternalServerErrorExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("LimitExceededException").withExceptionUnmarshaller(
    LimitExceededExceptionUnmarshaller.getInstance()))
    .withBaseServiceExceptionClass(AmazonDynamoDBException.class));
  
  @Deprecated
  public AmazonDynamoDBStreamsClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AmazonDynamoDBStreamsClientBuilder builder()
  {
    return AmazonDynamoDBStreamsClientBuilder.standard();
  }
  
  AmazonDynamoDBStreamsClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AmazonDynamoDBStreamsClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    setServiceNameIntern("dynamodb");
    setEndpointPrefix("streams.dynamodb");
    
    setEndpoint("https://streams.dynamodb.us-east-1.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/dynamodbv2/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/dynamodbv2/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public DescribeStreamResult describeStream(DescribeStreamRequest request)
  {
    request = (DescribeStreamRequest)beforeClientExecution(request);
    return executeDescribeStream(request);
  }
  
  @SdkInternalApi
  final DescribeStreamResult executeDescribeStream(DescribeStreamRequest describeStreamRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeStreamRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeStreamRequest> request = null;
    Response<DescribeStreamResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeStreamRequestProtocolMarshaller(protocolFactory).marshall((DescribeStreamRequest)super.beforeMarshalling(describeStreamRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB Streams");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeStream");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeStreamResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeStreamResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetRecordsResult getRecords(GetRecordsRequest request)
  {
    request = (GetRecordsRequest)beforeClientExecution(request);
    return executeGetRecords(request);
  }
  
  @SdkInternalApi
  final GetRecordsResult executeGetRecords(GetRecordsRequest getRecordsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getRecordsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetRecordsRequest> request = null;
    Response<GetRecordsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetRecordsRequestProtocolMarshaller(protocolFactory).marshall((GetRecordsRequest)super.beforeMarshalling(getRecordsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB Streams");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetRecords");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetRecordsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetRecordsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetShardIteratorResult getShardIterator(GetShardIteratorRequest request)
  {
    request = (GetShardIteratorRequest)beforeClientExecution(request);
    return executeGetShardIterator(request);
  }
  
  @SdkInternalApi
  final GetShardIteratorResult executeGetShardIterator(GetShardIteratorRequest getShardIteratorRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getShardIteratorRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetShardIteratorRequest> request = null;
    Response<GetShardIteratorResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetShardIteratorRequestProtocolMarshaller(protocolFactory).marshall((GetShardIteratorRequest)super.beforeMarshalling(getShardIteratorRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB Streams");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetShardIterator");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetShardIteratorResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetShardIteratorResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListStreamsResult listStreams(ListStreamsRequest request)
  {
    request = (ListStreamsRequest)beforeClientExecution(request);
    return executeListStreams(request);
  }
  
  @SdkInternalApi
  final ListStreamsResult executeListStreams(ListStreamsRequest listStreamsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listStreamsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListStreamsRequest> request = null;
    Response<ListStreamsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListStreamsRequestProtocolMarshaller(protocolFactory).marshall((ListStreamsRequest)super.beforeMarshalling(listStreamsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB Streams");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListStreams");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListStreamsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListStreamsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    return client.getResponseMetadataForRequest(request);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext)
  {
    return invoke(request, responseHandler, executionContext, null, null);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext, URI cachedEndpoint, URI uriFromEndpointTrait)
  {
    executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));
    
    return doInvoke(request, responseHandler, executionContext, cachedEndpoint, uriFromEndpointTrait);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext)
  {
    return doInvoke(request, responseHandler, executionContext, null, null);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext, URI discoveredEndpoint, URI uriFromEndpointTrait)
  {
    if (discoveredEndpoint != null)
    {
      request.setEndpoint(discoveredEndpoint);
      request.getOriginalRequest().getRequestClientOptions().appendUserAgent("endpoint-discovery");
    }
    else if (uriFromEndpointTrait != null)
    {
      request.setEndpoint(uriFromEndpointTrait);
    }
    else
    {
      request.setEndpoint(endpoint);
    }
    request.setTimeOffset(timeOffset);
    
    HttpResponseHandler<AmazonServiceException> errorResponseHandler = protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata());
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
  
  @SdkInternalApi
  static SdkJsonProtocolFactory getProtocolFactory()
  {
    return protocolFactory;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */