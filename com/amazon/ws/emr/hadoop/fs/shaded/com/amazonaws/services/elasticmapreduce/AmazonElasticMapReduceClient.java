package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AmazonElasticMapReduceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceFleetRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceFleetResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceGroupsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceGroupsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddJobFlowStepsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddJobFlowStepsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddTagsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddTagsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CancelStepsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CancelStepsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CreateSecurityConfigurationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CreateSecurityConfigurationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DeleteSecurityConfigurationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DeleteSecurityConfigurationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeClusterRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeClusterResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeJobFlowsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeJobFlowsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeSecurityConfigurationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeSecurityConfigurationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeStepRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeStepResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.GetBlockPublicAccessConfigurationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.GetBlockPublicAccessConfigurationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InternalServerExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InvalidRequestExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListBootstrapActionsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListBootstrapActionsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListClustersRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListClustersResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstanceFleetsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstanceFleetsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstanceGroupsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstanceGroupsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstancesRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstancesResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListSecurityConfigurationsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListSecurityConfigurationsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListStepsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListStepsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceFleetRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceFleetResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceGroupsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceGroupsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutAutoScalingPolicyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutAutoScalingPolicyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutBlockPublicAccessConfigurationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutBlockPublicAccessConfigurationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveAutoScalingPolicyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveAutoScalingPolicyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveTagsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveTagsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RunJobFlowRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RunJobFlowResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetTerminationProtectionRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetTerminationProtectionResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetVisibleToAllUsersRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetVisibleToAllUsersResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.TerminateJobFlowsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.TerminateJobFlowsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters.AmazonElasticMapReduceWaiters;
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
public class AmazonElasticMapReduceClient
  extends AmazonWebServiceClient
  implements AmazonElasticMapReduce
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AmazonElasticMapReduce.class);
  private static final String DEFAULT_SIGNING_NAME = "elasticmapreduce";
  private volatile AmazonElasticMapReduceWaiters waiters;
  protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  private static final SdkJsonProtocolFactory protocolFactory = new SdkJsonProtocolFactory(new JsonClientMetadata()
  
    .withProtocolVersion("1.1")
    .withSupportsCbor(false)
    .withSupportsIon(false)
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidRequestException").withExceptionUnmarshaller(
    InvalidRequestExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InternalServerException").withExceptionUnmarshaller(
    InternalServerExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InternalServerError").withExceptionUnmarshaller(
    InternalServerErrorExceptionUnmarshaller.getInstance()))
    .withBaseServiceExceptionClass(AmazonElasticMapReduceException.class));
  
  @Deprecated
  public AmazonElasticMapReduceClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonElasticMapReduceClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AmazonElasticMapReduceClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonElasticMapReduceClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AmazonElasticMapReduceClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonElasticMapReduceClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonElasticMapReduceClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AmazonElasticMapReduceClientBuilder builder()
  {
    return AmazonElasticMapReduceClientBuilder.standard();
  }
  
  AmazonElasticMapReduceClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AmazonElasticMapReduceClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    setServiceNameIntern("elasticmapreduce");
    setEndpointPrefix("elasticmapreduce");
    
    setEndpoint("https://elasticmapreduce.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/elasticmapreduce/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/elasticmapreduce/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public AddInstanceFleetResult addInstanceFleet(AddInstanceFleetRequest request)
  {
    request = (AddInstanceFleetRequest)beforeClientExecution(request);
    return executeAddInstanceFleet(request);
  }
  
  @SdkInternalApi
  final AddInstanceFleetResult executeAddInstanceFleet(AddInstanceFleetRequest addInstanceFleetRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addInstanceFleetRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddInstanceFleetRequest> request = null;
    Response<AddInstanceFleetResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddInstanceFleetRequestProtocolMarshaller(protocolFactory).marshall((AddInstanceFleetRequest)super.beforeMarshalling(addInstanceFleetRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddInstanceFleet");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new AddInstanceFleetResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddInstanceFleetResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AddInstanceGroupsResult addInstanceGroups(AddInstanceGroupsRequest request)
  {
    request = (AddInstanceGroupsRequest)beforeClientExecution(request);
    return executeAddInstanceGroups(request);
  }
  
  @SdkInternalApi
  final AddInstanceGroupsResult executeAddInstanceGroups(AddInstanceGroupsRequest addInstanceGroupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addInstanceGroupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddInstanceGroupsRequest> request = null;
    Response<AddInstanceGroupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddInstanceGroupsRequestProtocolMarshaller(protocolFactory).marshall((AddInstanceGroupsRequest)super.beforeMarshalling(addInstanceGroupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddInstanceGroups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new AddInstanceGroupsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddInstanceGroupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AddJobFlowStepsResult addJobFlowSteps(AddJobFlowStepsRequest request)
  {
    request = (AddJobFlowStepsRequest)beforeClientExecution(request);
    return executeAddJobFlowSteps(request);
  }
  
  @SdkInternalApi
  final AddJobFlowStepsResult executeAddJobFlowSteps(AddJobFlowStepsRequest addJobFlowStepsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addJobFlowStepsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddJobFlowStepsRequest> request = null;
    Response<AddJobFlowStepsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddJobFlowStepsRequestProtocolMarshaller(protocolFactory).marshall((AddJobFlowStepsRequest)super.beforeMarshalling(addJobFlowStepsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddJobFlowSteps");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new AddJobFlowStepsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddJobFlowStepsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AddTagsResult addTags(AddTagsRequest request)
  {
    request = (AddTagsRequest)beforeClientExecution(request);
    return executeAddTags(request);
  }
  
  @SdkInternalApi
  final AddTagsResult executeAddTags(AddTagsRequest addTagsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addTagsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddTagsRequest> request = null;
    Response<AddTagsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddTagsRequestProtocolMarshaller(protocolFactory).marshall((AddTagsRequest)super.beforeMarshalling(addTagsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddTags");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new AddTagsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddTagsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CancelStepsResult cancelSteps(CancelStepsRequest request)
  {
    request = (CancelStepsRequest)beforeClientExecution(request);
    return executeCancelSteps(request);
  }
  
  @SdkInternalApi
  final CancelStepsResult executeCancelSteps(CancelStepsRequest cancelStepsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(cancelStepsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CancelStepsRequest> request = null;
    Response<CancelStepsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CancelStepsRequestProtocolMarshaller(protocolFactory).marshall((CancelStepsRequest)super.beforeMarshalling(cancelStepsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelSteps");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CancelStepsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CancelStepsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateSecurityConfigurationResult createSecurityConfiguration(CreateSecurityConfigurationRequest request)
  {
    request = (CreateSecurityConfigurationRequest)beforeClientExecution(request);
    return executeCreateSecurityConfiguration(request);
  }
  
  @SdkInternalApi
  final CreateSecurityConfigurationResult executeCreateSecurityConfiguration(CreateSecurityConfigurationRequest createSecurityConfigurationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createSecurityConfigurationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateSecurityConfigurationRequest> request = null;
    Response<CreateSecurityConfigurationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateSecurityConfigurationRequestProtocolMarshaller(protocolFactory).marshall(
          (CreateSecurityConfigurationRequest)super.beforeMarshalling(createSecurityConfigurationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateSecurityConfiguration");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateSecurityConfigurationResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateSecurityConfigurationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteSecurityConfigurationResult deleteSecurityConfiguration(DeleteSecurityConfigurationRequest request)
  {
    request = (DeleteSecurityConfigurationRequest)beforeClientExecution(request);
    return executeDeleteSecurityConfiguration(request);
  }
  
  @SdkInternalApi
  final DeleteSecurityConfigurationResult executeDeleteSecurityConfiguration(DeleteSecurityConfigurationRequest deleteSecurityConfigurationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteSecurityConfigurationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteSecurityConfigurationRequest> request = null;
    Response<DeleteSecurityConfigurationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteSecurityConfigurationRequestProtocolMarshaller(protocolFactory).marshall(
          (DeleteSecurityConfigurationRequest)super.beforeMarshalling(deleteSecurityConfigurationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSecurityConfiguration");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteSecurityConfigurationResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteSecurityConfigurationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeClusterResult describeCluster(DescribeClusterRequest request)
  {
    request = (DescribeClusterRequest)beforeClientExecution(request);
    return executeDescribeCluster(request);
  }
  
  @SdkInternalApi
  final DescribeClusterResult executeDescribeCluster(DescribeClusterRequest describeClusterRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeClusterRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeClusterRequest> request = null;
    Response<DescribeClusterResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeClusterRequestProtocolMarshaller(protocolFactory).marshall((DescribeClusterRequest)super.beforeMarshalling(describeClusterRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeCluster");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeClusterResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeClusterResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  @Deprecated
  public DescribeJobFlowsResult describeJobFlows(DescribeJobFlowsRequest request)
  {
    request = (DescribeJobFlowsRequest)beforeClientExecution(request);
    return executeDescribeJobFlows(request);
  }
  
  @SdkInternalApi
  final DescribeJobFlowsResult executeDescribeJobFlows(DescribeJobFlowsRequest describeJobFlowsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeJobFlowsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeJobFlowsRequest> request = null;
    Response<DescribeJobFlowsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeJobFlowsRequestProtocolMarshaller(protocolFactory).marshall((DescribeJobFlowsRequest)super.beforeMarshalling(describeJobFlowsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeJobFlows");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeJobFlowsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeJobFlowsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  @Deprecated
  public DescribeJobFlowsResult describeJobFlows()
  {
    return describeJobFlows(new DescribeJobFlowsRequest());
  }
  
  public DescribeSecurityConfigurationResult describeSecurityConfiguration(DescribeSecurityConfigurationRequest request)
  {
    request = (DescribeSecurityConfigurationRequest)beforeClientExecution(request);
    return executeDescribeSecurityConfiguration(request);
  }
  
  @SdkInternalApi
  final DescribeSecurityConfigurationResult executeDescribeSecurityConfiguration(DescribeSecurityConfigurationRequest describeSecurityConfigurationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeSecurityConfigurationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeSecurityConfigurationRequest> request = null;
    Response<DescribeSecurityConfigurationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeSecurityConfigurationRequestProtocolMarshaller(protocolFactory).marshall(
          (DescribeSecurityConfigurationRequest)super.beforeMarshalling(describeSecurityConfigurationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSecurityConfiguration");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeSecurityConfigurationResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeSecurityConfigurationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeStepResult describeStep(DescribeStepRequest request)
  {
    request = (DescribeStepRequest)beforeClientExecution(request);
    return executeDescribeStep(request);
  }
  
  @SdkInternalApi
  final DescribeStepResult executeDescribeStep(DescribeStepRequest describeStepRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeStepRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeStepRequest> request = null;
    Response<DescribeStepResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeStepRequestProtocolMarshaller(protocolFactory).marshall((DescribeStepRequest)super.beforeMarshalling(describeStepRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeStep");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeStepResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeStepResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetBlockPublicAccessConfigurationResult getBlockPublicAccessConfiguration(GetBlockPublicAccessConfigurationRequest request)
  {
    request = (GetBlockPublicAccessConfigurationRequest)beforeClientExecution(request);
    return executeGetBlockPublicAccessConfiguration(request);
  }
  
  @SdkInternalApi
  final GetBlockPublicAccessConfigurationResult executeGetBlockPublicAccessConfiguration(GetBlockPublicAccessConfigurationRequest getBlockPublicAccessConfigurationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getBlockPublicAccessConfigurationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetBlockPublicAccessConfigurationRequest> request = null;
    Response<GetBlockPublicAccessConfigurationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetBlockPublicAccessConfigurationRequestProtocolMarshaller(protocolFactory).marshall(
          (GetBlockPublicAccessConfigurationRequest)super.beforeMarshalling(getBlockPublicAccessConfigurationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetBlockPublicAccessConfiguration");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetBlockPublicAccessConfigurationResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetBlockPublicAccessConfigurationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListBootstrapActionsResult listBootstrapActions(ListBootstrapActionsRequest request)
  {
    request = (ListBootstrapActionsRequest)beforeClientExecution(request);
    return executeListBootstrapActions(request);
  }
  
  @SdkInternalApi
  final ListBootstrapActionsResult executeListBootstrapActions(ListBootstrapActionsRequest listBootstrapActionsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listBootstrapActionsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListBootstrapActionsRequest> request = null;
    Response<ListBootstrapActionsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListBootstrapActionsRequestProtocolMarshaller(protocolFactory).marshall((ListBootstrapActionsRequest)super.beforeMarshalling(listBootstrapActionsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBootstrapActions");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListBootstrapActionsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListBootstrapActionsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListClustersResult listClusters(ListClustersRequest request)
  {
    request = (ListClustersRequest)beforeClientExecution(request);
    return executeListClusters(request);
  }
  
  @SdkInternalApi
  final ListClustersResult executeListClusters(ListClustersRequest listClustersRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listClustersRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListClustersRequest> request = null;
    Response<ListClustersResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListClustersRequestProtocolMarshaller(protocolFactory).marshall((ListClustersRequest)super.beforeMarshalling(listClustersRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListClusters");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListClustersResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListClustersResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListClustersResult listClusters()
  {
    return listClusters(new ListClustersRequest());
  }
  
  public ListInstanceFleetsResult listInstanceFleets(ListInstanceFleetsRequest request)
  {
    request = (ListInstanceFleetsRequest)beforeClientExecution(request);
    return executeListInstanceFleets(request);
  }
  
  @SdkInternalApi
  final ListInstanceFleetsResult executeListInstanceFleets(ListInstanceFleetsRequest listInstanceFleetsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listInstanceFleetsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListInstanceFleetsRequest> request = null;
    Response<ListInstanceFleetsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListInstanceFleetsRequestProtocolMarshaller(protocolFactory).marshall((ListInstanceFleetsRequest)super.beforeMarshalling(listInstanceFleetsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListInstanceFleets");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListInstanceFleetsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListInstanceFleetsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListInstanceGroupsResult listInstanceGroups(ListInstanceGroupsRequest request)
  {
    request = (ListInstanceGroupsRequest)beforeClientExecution(request);
    return executeListInstanceGroups(request);
  }
  
  @SdkInternalApi
  final ListInstanceGroupsResult executeListInstanceGroups(ListInstanceGroupsRequest listInstanceGroupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listInstanceGroupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListInstanceGroupsRequest> request = null;
    Response<ListInstanceGroupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListInstanceGroupsRequestProtocolMarshaller(protocolFactory).marshall((ListInstanceGroupsRequest)super.beforeMarshalling(listInstanceGroupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListInstanceGroups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListInstanceGroupsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListInstanceGroupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListInstancesResult listInstances(ListInstancesRequest request)
  {
    request = (ListInstancesRequest)beforeClientExecution(request);
    return executeListInstances(request);
  }
  
  @SdkInternalApi
  final ListInstancesResult executeListInstances(ListInstancesRequest listInstancesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listInstancesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListInstancesRequest> request = null;
    Response<ListInstancesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListInstancesRequestProtocolMarshaller(protocolFactory).marshall((ListInstancesRequest)super.beforeMarshalling(listInstancesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListInstances");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListInstancesResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListInstancesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListSecurityConfigurationsResult listSecurityConfigurations(ListSecurityConfigurationsRequest request)
  {
    request = (ListSecurityConfigurationsRequest)beforeClientExecution(request);
    return executeListSecurityConfigurations(request);
  }
  
  @SdkInternalApi
  final ListSecurityConfigurationsResult executeListSecurityConfigurations(ListSecurityConfigurationsRequest listSecurityConfigurationsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listSecurityConfigurationsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListSecurityConfigurationsRequest> request = null;
    Response<ListSecurityConfigurationsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListSecurityConfigurationsRequestProtocolMarshaller(protocolFactory).marshall(
          (ListSecurityConfigurationsRequest)super.beforeMarshalling(listSecurityConfigurationsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListSecurityConfigurations");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListSecurityConfigurationsResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListSecurityConfigurationsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListStepsResult listSteps(ListStepsRequest request)
  {
    request = (ListStepsRequest)beforeClientExecution(request);
    return executeListSteps(request);
  }
  
  @SdkInternalApi
  final ListStepsResult executeListSteps(ListStepsRequest listStepsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listStepsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListStepsRequest> request = null;
    Response<ListStepsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListStepsRequestProtocolMarshaller(protocolFactory).marshall((ListStepsRequest)super.beforeMarshalling(listStepsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListSteps");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListStepsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListStepsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ModifyInstanceFleetResult modifyInstanceFleet(ModifyInstanceFleetRequest request)
  {
    request = (ModifyInstanceFleetRequest)beforeClientExecution(request);
    return executeModifyInstanceFleet(request);
  }
  
  @SdkInternalApi
  final ModifyInstanceFleetResult executeModifyInstanceFleet(ModifyInstanceFleetRequest modifyInstanceFleetRequest)
  {
    ExecutionContext executionContext = createExecutionContext(modifyInstanceFleetRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ModifyInstanceFleetRequest> request = null;
    Response<ModifyInstanceFleetResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ModifyInstanceFleetRequestProtocolMarshaller(protocolFactory).marshall((ModifyInstanceFleetRequest)super.beforeMarshalling(modifyInstanceFleetRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyInstanceFleet");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ModifyInstanceFleetResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ModifyInstanceFleetResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ModifyInstanceGroupsResult modifyInstanceGroups(ModifyInstanceGroupsRequest request)
  {
    request = (ModifyInstanceGroupsRequest)beforeClientExecution(request);
    return executeModifyInstanceGroups(request);
  }
  
  @SdkInternalApi
  final ModifyInstanceGroupsResult executeModifyInstanceGroups(ModifyInstanceGroupsRequest modifyInstanceGroupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(modifyInstanceGroupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ModifyInstanceGroupsRequest> request = null;
    Response<ModifyInstanceGroupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ModifyInstanceGroupsRequestProtocolMarshaller(protocolFactory).marshall((ModifyInstanceGroupsRequest)super.beforeMarshalling(modifyInstanceGroupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyInstanceGroups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ModifyInstanceGroupsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ModifyInstanceGroupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ModifyInstanceGroupsResult modifyInstanceGroups()
  {
    return modifyInstanceGroups(new ModifyInstanceGroupsRequest());
  }
  
  public PutAutoScalingPolicyResult putAutoScalingPolicy(PutAutoScalingPolicyRequest request)
  {
    request = (PutAutoScalingPolicyRequest)beforeClientExecution(request);
    return executePutAutoScalingPolicy(request);
  }
  
  @SdkInternalApi
  final PutAutoScalingPolicyResult executePutAutoScalingPolicy(PutAutoScalingPolicyRequest putAutoScalingPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putAutoScalingPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutAutoScalingPolicyRequest> request = null;
    Response<PutAutoScalingPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutAutoScalingPolicyRequestProtocolMarshaller(protocolFactory).marshall((PutAutoScalingPolicyRequest)super.beforeMarshalling(putAutoScalingPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutAutoScalingPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PutAutoScalingPolicyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutAutoScalingPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutBlockPublicAccessConfigurationResult putBlockPublicAccessConfiguration(PutBlockPublicAccessConfigurationRequest request)
  {
    request = (PutBlockPublicAccessConfigurationRequest)beforeClientExecution(request);
    return executePutBlockPublicAccessConfiguration(request);
  }
  
  @SdkInternalApi
  final PutBlockPublicAccessConfigurationResult executePutBlockPublicAccessConfiguration(PutBlockPublicAccessConfigurationRequest putBlockPublicAccessConfigurationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putBlockPublicAccessConfigurationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutBlockPublicAccessConfigurationRequest> request = null;
    Response<PutBlockPublicAccessConfigurationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutBlockPublicAccessConfigurationRequestProtocolMarshaller(protocolFactory).marshall(
          (PutBlockPublicAccessConfigurationRequest)super.beforeMarshalling(putBlockPublicAccessConfigurationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutBlockPublicAccessConfiguration");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PutBlockPublicAccessConfigurationResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutBlockPublicAccessConfigurationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RemoveAutoScalingPolicyResult removeAutoScalingPolicy(RemoveAutoScalingPolicyRequest request)
  {
    request = (RemoveAutoScalingPolicyRequest)beforeClientExecution(request);
    return executeRemoveAutoScalingPolicy(request);
  }
  
  @SdkInternalApi
  final RemoveAutoScalingPolicyResult executeRemoveAutoScalingPolicy(RemoveAutoScalingPolicyRequest removeAutoScalingPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(removeAutoScalingPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RemoveAutoScalingPolicyRequest> request = null;
    Response<RemoveAutoScalingPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RemoveAutoScalingPolicyRequestProtocolMarshaller(protocolFactory).marshall(
          (RemoveAutoScalingPolicyRequest)super.beforeMarshalling(removeAutoScalingPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RemoveAutoScalingPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RemoveAutoScalingPolicyResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RemoveAutoScalingPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RemoveTagsResult removeTags(RemoveTagsRequest request)
  {
    request = (RemoveTagsRequest)beforeClientExecution(request);
    return executeRemoveTags(request);
  }
  
  @SdkInternalApi
  final RemoveTagsResult executeRemoveTags(RemoveTagsRequest removeTagsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(removeTagsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RemoveTagsRequest> request = null;
    Response<RemoveTagsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RemoveTagsRequestProtocolMarshaller(protocolFactory).marshall((RemoveTagsRequest)super.beforeMarshalling(removeTagsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RemoveTags");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RemoveTagsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RemoveTagsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RunJobFlowResult runJobFlow(RunJobFlowRequest request)
  {
    request = (RunJobFlowRequest)beforeClientExecution(request);
    return executeRunJobFlow(request);
  }
  
  @SdkInternalApi
  final RunJobFlowResult executeRunJobFlow(RunJobFlowRequest runJobFlowRequest)
  {
    ExecutionContext executionContext = createExecutionContext(runJobFlowRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RunJobFlowRequest> request = null;
    Response<RunJobFlowResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RunJobFlowRequestProtocolMarshaller(protocolFactory).marshall((RunJobFlowRequest)super.beforeMarshalling(runJobFlowRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RunJobFlow");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RunJobFlowResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RunJobFlowResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SetTerminationProtectionResult setTerminationProtection(SetTerminationProtectionRequest request)
  {
    request = (SetTerminationProtectionRequest)beforeClientExecution(request);
    return executeSetTerminationProtection(request);
  }
  
  @SdkInternalApi
  final SetTerminationProtectionResult executeSetTerminationProtection(SetTerminationProtectionRequest setTerminationProtectionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(setTerminationProtectionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SetTerminationProtectionRequest> request = null;
    Response<SetTerminationProtectionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SetTerminationProtectionRequestProtocolMarshaller(protocolFactory).marshall(
          (SetTerminationProtectionRequest)super.beforeMarshalling(setTerminationProtectionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SetTerminationProtection");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new SetTerminationProtectionResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SetTerminationProtectionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SetVisibleToAllUsersResult setVisibleToAllUsers(SetVisibleToAllUsersRequest request)
  {
    request = (SetVisibleToAllUsersRequest)beforeClientExecution(request);
    return executeSetVisibleToAllUsers(request);
  }
  
  @SdkInternalApi
  final SetVisibleToAllUsersResult executeSetVisibleToAllUsers(SetVisibleToAllUsersRequest setVisibleToAllUsersRequest)
  {
    ExecutionContext executionContext = createExecutionContext(setVisibleToAllUsersRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SetVisibleToAllUsersRequest> request = null;
    Response<SetVisibleToAllUsersResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SetVisibleToAllUsersRequestProtocolMarshaller(protocolFactory).marshall((SetVisibleToAllUsersRequest)super.beforeMarshalling(setVisibleToAllUsersRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SetVisibleToAllUsers");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new SetVisibleToAllUsersResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SetVisibleToAllUsersResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TerminateJobFlowsResult terminateJobFlows(TerminateJobFlowsRequest request)
  {
    request = (TerminateJobFlowsRequest)beforeClientExecution(request);
    return executeTerminateJobFlows(request);
  }
  
  @SdkInternalApi
  final TerminateJobFlowsResult executeTerminateJobFlows(TerminateJobFlowsRequest terminateJobFlowsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(terminateJobFlowsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TerminateJobFlowsRequest> request = null;
    Response<TerminateJobFlowsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TerminateJobFlowsRequestProtocolMarshaller(protocolFactory).marshall((TerminateJobFlowsRequest)super.beforeMarshalling(terminateJobFlowsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EMR");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TerminateJobFlows");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new TerminateJobFlowsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (TerminateJobFlowsResult)response.getAwsResponse();
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
  
  public AmazonElasticMapReduceWaiters waiters()
  {
    if (waiters == null) {
      synchronized (this)
      {
        if (waiters == null) {
          waiters = new AmazonElasticMapReduceWaiters(this);
        }
      }
    }
    return waiters;
  }
  
  public void shutdown()
  {
    super.shutdown();
    if (waiters != null) {
      waiters.shutdown();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */