package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.StaxResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.sqs.internal.auth.SQSSignerProvider;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.AddPermissionResult;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import com.amazonaws.services.sqs.model.ListQueueTagsRequest;
import com.amazonaws.services.sqs.model.ListQueueTagsResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;
import com.amazonaws.services.sqs.model.PurgeQueueResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.RemovePermissionResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.SetQueueAttributesResult;
import com.amazonaws.services.sqs.model.TagQueueRequest;
import com.amazonaws.services.sqs.model.TagQueueResult;
import com.amazonaws.services.sqs.model.UntagQueueRequest;
import com.amazonaws.services.sqs.model.UntagQueueResult;
import com.amazonaws.services.sqs.model.transform.AddPermissionRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.AddPermissionResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.BatchEntryIdsNotDistinctExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.BatchRequestTooLongExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.CreateQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.CreateQueueResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageBatchRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageBatchResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteQueueResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.EmptyBatchRequestExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueAttributesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueAttributesResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueUrlRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueUrlResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidAttributeNameExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidBatchEntryIdExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidIdFormatExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidMessageContentsExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ListDeadLetterSourceQueuesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ListDeadLetterSourceQueuesResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ListQueueTagsRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ListQueueTagsResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ListQueuesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ListQueuesResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.MessageNotInflightExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.OverLimitExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.PurgeQueueInProgressExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.PurgeQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.PurgeQueueResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.QueueDeletedRecentlyExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.QueueDoesNotExistExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.QueueNameExistsExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ReceiptHandleIsInvalidExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ReceiveMessageRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ReceiveMessageResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.RemovePermissionRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.RemovePermissionResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageBatchRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageBatchResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.SetQueueAttributesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.SetQueueAttributesResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.TagQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.TagQueueResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.TooManyEntriesInBatchRequestExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.UnsupportedOperationExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.UntagQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.UntagQueueResultStaxUnmarshaller;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

@ThreadSafe
public class AmazonSQSClient
  extends AmazonWebServiceClient
  implements AmazonSQS
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AmazonSQS.class);
  private static final String DEFAULT_SIGNING_NAME = "sqs";
  protected static final AmazonSQSClientConfigurationFactory configFactory = new AmazonSQSClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers = new ArrayList();
  
  @Deprecated
  public AmazonSQSClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonSQSClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AmazonSQSClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonSQSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonSQSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AmazonSQSClientBuilder builder()
  {
    return AmazonSQSClientBuilder.standard();
  }
  
  AmazonSQSClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AmazonSQSClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    exceptionUnmarshallers.add(new PurgeQueueInProgressExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidAttributeNameExceptionUnmarshaller());
    exceptionUnmarshallers.add(new BatchEntryIdsNotDistinctExceptionUnmarshaller());
    exceptionUnmarshallers.add(new TooManyEntriesInBatchRequestExceptionUnmarshaller());
    exceptionUnmarshallers.add(new BatchRequestTooLongExceptionUnmarshaller());
    exceptionUnmarshallers.add(new UnsupportedOperationExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidIdFormatExceptionUnmarshaller());
    exceptionUnmarshallers.add(new OverLimitExceptionUnmarshaller());
    exceptionUnmarshallers.add(new QueueDoesNotExistExceptionUnmarshaller());
    exceptionUnmarshallers.add(new QueueNameExistsExceptionUnmarshaller());
    exceptionUnmarshallers.add(new MessageNotInflightExceptionUnmarshaller());
    exceptionUnmarshallers.add(new ReceiptHandleIsInvalidExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidMessageContentsExceptionUnmarshaller());
    exceptionUnmarshallers.add(new QueueDeletedRecentlyExceptionUnmarshaller());
    exceptionUnmarshallers.add(new EmptyBatchRequestExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidBatchEntryIdExceptionUnmarshaller());
    exceptionUnmarshallers.add(new StandardErrorUnmarshaller(AmazonSQSException.class));
    
    setServiceNameIntern("sqs");
    setEndpointPrefix("sqs");
    
    setEndpoint("https://sqs.us-east-1.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/sqs/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/sqs/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public AddPermissionResult addPermission(AddPermissionRequest request)
  {
    request = (AddPermissionRequest)beforeClientExecution(request);
    return executeAddPermission(request);
  }
  
  @SdkInternalApi
  final AddPermissionResult executeAddPermission(AddPermissionRequest addPermissionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addPermissionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddPermissionRequest> request = null;
    Response<AddPermissionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddPermissionRequestMarshaller().marshall((AddPermissionRequest)super.beforeMarshalling(addPermissionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddPermission");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AddPermissionResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddPermissionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AddPermissionResult addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions)
  {
    return addPermission(new AddPermissionRequest().withQueueUrl(queueUrl).withLabel(label).withAWSAccountIds(aWSAccountIds).withActions(actions));
  }
  
  public ChangeMessageVisibilityResult changeMessageVisibility(ChangeMessageVisibilityRequest request)
  {
    request = (ChangeMessageVisibilityRequest)beforeClientExecution(request);
    return executeChangeMessageVisibility(request);
  }
  
  @SdkInternalApi
  final ChangeMessageVisibilityResult executeChangeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest)
  {
    ExecutionContext executionContext = createExecutionContext(changeMessageVisibilityRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ChangeMessageVisibilityRequest> request = null;
    Response<ChangeMessageVisibilityResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ChangeMessageVisibilityRequestMarshaller().marshall((ChangeMessageVisibilityRequest)super.beforeMarshalling(changeMessageVisibilityRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ChangeMessageVisibility");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ChangeMessageVisibilityResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ChangeMessageVisibilityResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ChangeMessageVisibilityResult changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout)
  {
    return changeMessageVisibility(new ChangeMessageVisibilityRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle)
      .withVisibilityTimeout(visibilityTimeout));
  }
  
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest request)
  {
    request = (ChangeMessageVisibilityBatchRequest)beforeClientExecution(request);
    return executeChangeMessageVisibilityBatch(request);
  }
  
  @SdkInternalApi
  final ChangeMessageVisibilityBatchResult executeChangeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest)
  {
    ExecutionContext executionContext = createExecutionContext(changeMessageVisibilityBatchRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ChangeMessageVisibilityBatchRequest> request = null;
    Response<ChangeMessageVisibilityBatchResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ChangeMessageVisibilityBatchRequestMarshaller().marshall((ChangeMessageVisibilityBatchRequest)super.beforeMarshalling(changeMessageVisibilityBatchRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ChangeMessageVisibilityBatch");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ChangeMessageVisibilityBatchResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ChangeMessageVisibilityBatchResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries)
  {
    return changeMessageVisibilityBatch(new ChangeMessageVisibilityBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public CreateQueueResult createQueue(CreateQueueRequest request)
  {
    request = (CreateQueueRequest)beforeClientExecution(request);
    return executeCreateQueue(request);
  }
  
  @SdkInternalApi
  final CreateQueueResult executeCreateQueue(CreateQueueRequest createQueueRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createQueueRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateQueueRequest> request = null;
    Response<CreateQueueResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateQueueRequestMarshaller().marshall((CreateQueueRequest)super.beforeMarshalling(createQueueRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateQueue");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateQueueResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateQueueResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateQueueResult createQueue(String queueName)
  {
    return createQueue(new CreateQueueRequest().withQueueName(queueName));
  }
  
  public DeleteMessageResult deleteMessage(DeleteMessageRequest request)
  {
    request = (DeleteMessageRequest)beforeClientExecution(request);
    return executeDeleteMessage(request);
  }
  
  @SdkInternalApi
  final DeleteMessageResult executeDeleteMessage(DeleteMessageRequest deleteMessageRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteMessageRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteMessageRequest> request = null;
    Response<DeleteMessageResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteMessageRequestMarshaller().marshall((DeleteMessageRequest)super.beforeMarshalling(deleteMessageRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteMessage");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteMessageResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteMessageResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteMessageResult deleteMessage(String queueUrl, String receiptHandle)
  {
    return deleteMessage(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle));
  }
  
  public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest request)
  {
    request = (DeleteMessageBatchRequest)beforeClientExecution(request);
    return executeDeleteMessageBatch(request);
  }
  
  @SdkInternalApi
  final DeleteMessageBatchResult executeDeleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteMessageBatchRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteMessageBatchRequest> request = null;
    Response<DeleteMessageBatchResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteMessageBatchRequestMarshaller().marshall((DeleteMessageBatchRequest)super.beforeMarshalling(deleteMessageBatchRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteMessageBatch");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteMessageBatchResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteMessageBatchResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries)
  {
    return deleteMessageBatch(new DeleteMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public DeleteQueueResult deleteQueue(DeleteQueueRequest request)
  {
    request = (DeleteQueueRequest)beforeClientExecution(request);
    return executeDeleteQueue(request);
  }
  
  @SdkInternalApi
  final DeleteQueueResult executeDeleteQueue(DeleteQueueRequest deleteQueueRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteQueueRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteQueueRequest> request = null;
    Response<DeleteQueueResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteQueueRequestMarshaller().marshall((DeleteQueueRequest)super.beforeMarshalling(deleteQueueRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteQueue");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteQueueResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteQueueResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteQueueResult deleteQueue(String queueUrl)
  {
    return deleteQueue(new DeleteQueueRequest().withQueueUrl(queueUrl));
  }
  
  public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest request)
  {
    request = (GetQueueAttributesRequest)beforeClientExecution(request);
    return executeGetQueueAttributes(request);
  }
  
  @SdkInternalApi
  final GetQueueAttributesResult executeGetQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getQueueAttributesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetQueueAttributesRequest> request = null;
    Response<GetQueueAttributesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetQueueAttributesRequestMarshaller().marshall((GetQueueAttributesRequest)super.beforeMarshalling(getQueueAttributesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetQueueAttributes");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetQueueAttributesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetQueueAttributesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetQueueAttributesResult getQueueAttributes(String queueUrl, List<String> attributeNames)
  {
    return getQueueAttributes(new GetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributeNames(attributeNames));
  }
  
  public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest request)
  {
    request = (GetQueueUrlRequest)beforeClientExecution(request);
    return executeGetQueueUrl(request);
  }
  
  @SdkInternalApi
  final GetQueueUrlResult executeGetQueueUrl(GetQueueUrlRequest getQueueUrlRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getQueueUrlRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetQueueUrlRequest> request = null;
    Response<GetQueueUrlResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetQueueUrlRequestMarshaller().marshall((GetQueueUrlRequest)super.beforeMarshalling(getQueueUrlRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetQueueUrl");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetQueueUrlResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetQueueUrlResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetQueueUrlResult getQueueUrl(String queueName)
  {
    return getQueueUrl(new GetQueueUrlRequest().withQueueName(queueName));
  }
  
  public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest request)
  {
    request = (ListDeadLetterSourceQueuesRequest)beforeClientExecution(request);
    return executeListDeadLetterSourceQueues(request);
  }
  
  @SdkInternalApi
  final ListDeadLetterSourceQueuesResult executeListDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listDeadLetterSourceQueuesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListDeadLetterSourceQueuesRequest> request = null;
    Response<ListDeadLetterSourceQueuesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListDeadLetterSourceQueuesRequestMarshaller().marshall((ListDeadLetterSourceQueuesRequest)super.beforeMarshalling(listDeadLetterSourceQueuesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListDeadLetterSourceQueues");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListDeadLetterSourceQueuesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListDeadLetterSourceQueuesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListQueueTagsResult listQueueTags(ListQueueTagsRequest request)
  {
    request = (ListQueueTagsRequest)beforeClientExecution(request);
    return executeListQueueTags(request);
  }
  
  @SdkInternalApi
  final ListQueueTagsResult executeListQueueTags(ListQueueTagsRequest listQueueTagsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listQueueTagsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListQueueTagsRequest> request = null;
    Response<ListQueueTagsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListQueueTagsRequestMarshaller().marshall((ListQueueTagsRequest)super.beforeMarshalling(listQueueTagsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListQueueTags");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListQueueTagsResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListQueueTagsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListQueueTagsResult listQueueTags(String queueUrl)
  {
    return listQueueTags(new ListQueueTagsRequest().withQueueUrl(queueUrl));
  }
  
  public ListQueuesResult listQueues(ListQueuesRequest request)
  {
    request = (ListQueuesRequest)beforeClientExecution(request);
    return executeListQueues(request);
  }
  
  @SdkInternalApi
  final ListQueuesResult executeListQueues(ListQueuesRequest listQueuesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listQueuesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListQueuesRequest> request = null;
    Response<ListQueuesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListQueuesRequestMarshaller().marshall((ListQueuesRequest)super.beforeMarshalling(listQueuesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListQueues");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListQueuesResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListQueuesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListQueuesResult listQueues()
  {
    return listQueues(new ListQueuesRequest());
  }
  
  public ListQueuesResult listQueues(String queueNamePrefix)
  {
    return listQueues(new ListQueuesRequest().withQueueNamePrefix(queueNamePrefix));
  }
  
  public PurgeQueueResult purgeQueue(PurgeQueueRequest request)
  {
    request = (PurgeQueueRequest)beforeClientExecution(request);
    return executePurgeQueue(request);
  }
  
  @SdkInternalApi
  final PurgeQueueResult executePurgeQueue(PurgeQueueRequest purgeQueueRequest)
  {
    ExecutionContext executionContext = createExecutionContext(purgeQueueRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PurgeQueueRequest> request = null;
    Response<PurgeQueueResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PurgeQueueRequestMarshaller().marshall((PurgeQueueRequest)super.beforeMarshalling(purgeQueueRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PurgeQueue");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PurgeQueueResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PurgeQueueResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ReceiveMessageResult receiveMessage(ReceiveMessageRequest request)
  {
    request = (ReceiveMessageRequest)beforeClientExecution(request);
    return executeReceiveMessage(request);
  }
  
  @SdkInternalApi
  final ReceiveMessageResult executeReceiveMessage(ReceiveMessageRequest receiveMessageRequest)
  {
    ExecutionContext executionContext = createExecutionContext(receiveMessageRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ReceiveMessageRequest> request = null;
    Response<ReceiveMessageResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ReceiveMessageRequestMarshaller().marshall((ReceiveMessageRequest)super.beforeMarshalling(receiveMessageRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReceiveMessage");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ReceiveMessageResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ReceiveMessageResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ReceiveMessageResult receiveMessage(String queueUrl)
  {
    return receiveMessage(new ReceiveMessageRequest().withQueueUrl(queueUrl));
  }
  
  public RemovePermissionResult removePermission(RemovePermissionRequest request)
  {
    request = (RemovePermissionRequest)beforeClientExecution(request);
    return executeRemovePermission(request);
  }
  
  @SdkInternalApi
  final RemovePermissionResult executeRemovePermission(RemovePermissionRequest removePermissionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(removePermissionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RemovePermissionRequest> request = null;
    Response<RemovePermissionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RemovePermissionRequestMarshaller().marshall((RemovePermissionRequest)super.beforeMarshalling(removePermissionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RemovePermission");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new RemovePermissionResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RemovePermissionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RemovePermissionResult removePermission(String queueUrl, String label)
  {
    return removePermission(new RemovePermissionRequest().withQueueUrl(queueUrl).withLabel(label));
  }
  
  public SendMessageResult sendMessage(SendMessageRequest request)
  {
    request = (SendMessageRequest)beforeClientExecution(request);
    return executeSendMessage(request);
  }
  
  @SdkInternalApi
  final SendMessageResult executeSendMessage(SendMessageRequest sendMessageRequest)
  {
    ExecutionContext executionContext = createExecutionContext(sendMessageRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SendMessageRequest> request = null;
    Response<SendMessageResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SendMessageRequestMarshaller().marshall((SendMessageRequest)super.beforeMarshalling(sendMessageRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SendMessage");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SendMessageResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SendMessageResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SendMessageResult sendMessage(String queueUrl, String messageBody)
  {
    return sendMessage(new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(messageBody));
  }
  
  public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest request)
  {
    request = (SendMessageBatchRequest)beforeClientExecution(request);
    return executeSendMessageBatch(request);
  }
  
  @SdkInternalApi
  final SendMessageBatchResult executeSendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest)
  {
    ExecutionContext executionContext = createExecutionContext(sendMessageBatchRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SendMessageBatchRequest> request = null;
    Response<SendMessageBatchResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SendMessageBatchRequestMarshaller().marshall((SendMessageBatchRequest)super.beforeMarshalling(sendMessageBatchRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SendMessageBatch");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SendMessageBatchResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SendMessageBatchResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SendMessageBatchResult sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries)
  {
    return sendMessageBatch(new SendMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public SetQueueAttributesResult setQueueAttributes(SetQueueAttributesRequest request)
  {
    request = (SetQueueAttributesRequest)beforeClientExecution(request);
    return executeSetQueueAttributes(request);
  }
  
  @SdkInternalApi
  final SetQueueAttributesResult executeSetQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(setQueueAttributesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SetQueueAttributesRequest> request = null;
    Response<SetQueueAttributesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SetQueueAttributesRequestMarshaller().marshall((SetQueueAttributesRequest)super.beforeMarshalling(setQueueAttributesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SetQueueAttributes");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SetQueueAttributesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SetQueueAttributesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SetQueueAttributesResult setQueueAttributes(String queueUrl, Map<String, String> attributes)
  {
    return setQueueAttributes(new SetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributes(attributes));
  }
  
  public TagQueueResult tagQueue(TagQueueRequest request)
  {
    request = (TagQueueRequest)beforeClientExecution(request);
    return executeTagQueue(request);
  }
  
  @SdkInternalApi
  final TagQueueResult executeTagQueue(TagQueueRequest tagQueueRequest)
  {
    ExecutionContext executionContext = createExecutionContext(tagQueueRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TagQueueRequest> request = null;
    Response<TagQueueResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TagQueueRequestMarshaller().marshall((TagQueueRequest)super.beforeMarshalling(tagQueueRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagQueue");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new TagQueueResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (TagQueueResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TagQueueResult tagQueue(String queueUrl, Map<String, String> tags)
  {
    return tagQueue(new TagQueueRequest().withQueueUrl(queueUrl).withTags(tags));
  }
  
  public UntagQueueResult untagQueue(UntagQueueRequest request)
  {
    request = (UntagQueueRequest)beforeClientExecution(request);
    return executeUntagQueue(request);
  }
  
  @SdkInternalApi
  final UntagQueueResult executeUntagQueue(UntagQueueRequest untagQueueRequest)
  {
    ExecutionContext executionContext = createExecutionContext(untagQueueRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UntagQueueRequest> request = null;
    Response<UntagQueueResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UntagQueueRequestMarshaller().marshall((UntagQueueRequest)super.beforeMarshalling(untagQueueRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "SQS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagQueue");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UntagQueueResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UntagQueueResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UntagQueueResult untagQueue(String queueUrl, List<String> tagKeys)
  {
    return untagQueue(new UntagQueueRequest().withQueueUrl(queueUrl).withTagKeys(tagKeys));
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    return client.getResponseMetadataForRequest(request);
  }
  
  protected final SignerProvider createSignerProvider(Signer signer)
  {
    return new SQSSignerProvider(this, signer);
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
    
    DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */