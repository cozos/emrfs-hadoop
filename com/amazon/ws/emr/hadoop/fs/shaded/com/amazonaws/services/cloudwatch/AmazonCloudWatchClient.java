package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.StaxResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AmazonCloudWatchException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ConcurrentModificationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DashboardInvalidInputErrorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DashboardNotFoundErrorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteAlarmsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteAlarmsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteAnomalyDetectorRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteAnomalyDetectorResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteDashboardsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteDashboardsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmHistoryRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmHistoryResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsForMetricRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsForMetricResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAnomalyDetectorsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAnomalyDetectorsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DisableAlarmActionsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DisableAlarmActionsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.EnableAlarmActionsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.EnableAlarmActionsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetDashboardRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetDashboardResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricDataRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricDataResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricStatisticsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricStatisticsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricWidgetImageRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricWidgetImageResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.InternalServiceExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.InvalidFormatExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.InvalidNextTokenExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.InvalidParameterCombinationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.InvalidParameterValueExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListDashboardsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListDashboardsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListMetricsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListMetricsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListTagsForResourceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListTagsForResourceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.MissingRequiredParameterExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutAnomalyDetectorRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutAnomalyDetectorResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutDashboardRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutDashboardResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricAlarmRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricAlarmResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricDataRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricDataResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.SetAlarmStateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.SetAlarmStateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.TagResourceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.TagResourceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.UntagResourceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.UntagResourceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters.AmazonCloudWatchWaiters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

@ThreadSafe
public class AmazonCloudWatchClient
  extends AmazonWebServiceClient
  implements AmazonCloudWatch
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AmazonCloudWatch.class);
  private static final String DEFAULT_SIGNING_NAME = "monitoring";
  private volatile AmazonCloudWatchWaiters waiters;
  protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers = new ArrayList();
  
  @Deprecated
  public AmazonCloudWatchClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonCloudWatchClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AmazonCloudWatchClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonCloudWatchClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AmazonCloudWatchClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonCloudWatchClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonCloudWatchClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AmazonCloudWatchClientBuilder builder()
  {
    return AmazonCloudWatchClientBuilder.standard();
  }
  
  AmazonCloudWatchClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AmazonCloudWatchClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    exceptionUnmarshallers.add(new ConcurrentModificationExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidParameterValueExceptionUnmarshaller());
    exceptionUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidParameterCombinationExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidFormatExceptionUnmarshaller());
    exceptionUnmarshallers.add(new MissingRequiredParameterExceptionUnmarshaller());
    exceptionUnmarshallers.add(new DashboardNotFoundErrorExceptionUnmarshaller());
    exceptionUnmarshallers.add(new DashboardInvalidInputErrorExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InternalServiceExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidNextTokenExceptionUnmarshaller());
    exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
    exceptionUnmarshallers.add(new StandardErrorUnmarshaller(AmazonCloudWatchException.class));
    
    setServiceNameIntern("monitoring");
    setEndpointPrefix("monitoring");
    
    setEndpoint("https://monitoring.us-east-1.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/cloudwatch/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/cloudwatch/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public DeleteAlarmsResult deleteAlarms(DeleteAlarmsRequest request)
  {
    request = (DeleteAlarmsRequest)beforeClientExecution(request);
    return executeDeleteAlarms(request);
  }
  
  @SdkInternalApi
  final DeleteAlarmsResult executeDeleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteAlarmsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteAlarmsRequest> request = null;
    Response<DeleteAlarmsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteAlarmsRequestMarshaller().marshall((DeleteAlarmsRequest)super.beforeMarshalling(deleteAlarmsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteAlarms");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteAlarmsResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteAlarmsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteAnomalyDetectorResult deleteAnomalyDetector(DeleteAnomalyDetectorRequest request)
  {
    request = (DeleteAnomalyDetectorRequest)beforeClientExecution(request);
    return executeDeleteAnomalyDetector(request);
  }
  
  @SdkInternalApi
  final DeleteAnomalyDetectorResult executeDeleteAnomalyDetector(DeleteAnomalyDetectorRequest deleteAnomalyDetectorRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteAnomalyDetectorRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteAnomalyDetectorRequest> request = null;
    Response<DeleteAnomalyDetectorResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteAnomalyDetectorRequestMarshaller().marshall((DeleteAnomalyDetectorRequest)super.beforeMarshalling(deleteAnomalyDetectorRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteAnomalyDetector");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteAnomalyDetectorResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteAnomalyDetectorResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteDashboardsResult deleteDashboards(DeleteDashboardsRequest request)
  {
    request = (DeleteDashboardsRequest)beforeClientExecution(request);
    return executeDeleteDashboards(request);
  }
  
  @SdkInternalApi
  final DeleteDashboardsResult executeDeleteDashboards(DeleteDashboardsRequest deleteDashboardsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteDashboardsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteDashboardsRequest> request = null;
    Response<DeleteDashboardsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteDashboardsRequestMarshaller().marshall((DeleteDashboardsRequest)super.beforeMarshalling(deleteDashboardsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteDashboards");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteDashboardsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteDashboardsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest request)
  {
    request = (DescribeAlarmHistoryRequest)beforeClientExecution(request);
    return executeDescribeAlarmHistory(request);
  }
  
  @SdkInternalApi
  final DescribeAlarmHistoryResult executeDescribeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeAlarmHistoryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeAlarmHistoryRequest> request = null;
    Response<DescribeAlarmHistoryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeAlarmHistoryRequestMarshaller().marshall((DescribeAlarmHistoryRequest)super.beforeMarshalling(describeAlarmHistoryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAlarmHistory");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DescribeAlarmHistoryResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeAlarmHistoryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeAlarmHistoryResult describeAlarmHistory()
  {
    return describeAlarmHistory(new DescribeAlarmHistoryRequest());
  }
  
  public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest request)
  {
    request = (DescribeAlarmsRequest)beforeClientExecution(request);
    return executeDescribeAlarms(request);
  }
  
  @SdkInternalApi
  final DescribeAlarmsResult executeDescribeAlarms(DescribeAlarmsRequest describeAlarmsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeAlarmsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeAlarmsRequest> request = null;
    Response<DescribeAlarmsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeAlarmsRequestMarshaller().marshall((DescribeAlarmsRequest)super.beforeMarshalling(describeAlarmsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAlarms");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DescribeAlarmsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeAlarmsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeAlarmsResult describeAlarms()
  {
    return describeAlarms(new DescribeAlarmsRequest());
  }
  
  public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest request)
  {
    request = (DescribeAlarmsForMetricRequest)beforeClientExecution(request);
    return executeDescribeAlarmsForMetric(request);
  }
  
  @SdkInternalApi
  final DescribeAlarmsForMetricResult executeDescribeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeAlarmsForMetricRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeAlarmsForMetricRequest> request = null;
    Response<DescribeAlarmsForMetricResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeAlarmsForMetricRequestMarshaller().marshall((DescribeAlarmsForMetricRequest)super.beforeMarshalling(describeAlarmsForMetricRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAlarmsForMetric");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DescribeAlarmsForMetricResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeAlarmsForMetricResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeAnomalyDetectorsResult describeAnomalyDetectors(DescribeAnomalyDetectorsRequest request)
  {
    request = (DescribeAnomalyDetectorsRequest)beforeClientExecution(request);
    return executeDescribeAnomalyDetectors(request);
  }
  
  @SdkInternalApi
  final DescribeAnomalyDetectorsResult executeDescribeAnomalyDetectors(DescribeAnomalyDetectorsRequest describeAnomalyDetectorsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeAnomalyDetectorsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeAnomalyDetectorsRequest> request = null;
    Response<DescribeAnomalyDetectorsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeAnomalyDetectorsRequestMarshaller().marshall((DescribeAnomalyDetectorsRequest)super.beforeMarshalling(describeAnomalyDetectorsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAnomalyDetectors");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DescribeAnomalyDetectorsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeAnomalyDetectorsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DisableAlarmActionsResult disableAlarmActions(DisableAlarmActionsRequest request)
  {
    request = (DisableAlarmActionsRequest)beforeClientExecution(request);
    return executeDisableAlarmActions(request);
  }
  
  @SdkInternalApi
  final DisableAlarmActionsResult executeDisableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(disableAlarmActionsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DisableAlarmActionsRequest> request = null;
    Response<DisableAlarmActionsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DisableAlarmActionsRequestMarshaller().marshall((DisableAlarmActionsRequest)super.beforeMarshalling(disableAlarmActionsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableAlarmActions");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DisableAlarmActionsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DisableAlarmActionsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public EnableAlarmActionsResult enableAlarmActions(EnableAlarmActionsRequest request)
  {
    request = (EnableAlarmActionsRequest)beforeClientExecution(request);
    return executeEnableAlarmActions(request);
  }
  
  @SdkInternalApi
  final EnableAlarmActionsResult executeEnableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(enableAlarmActionsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<EnableAlarmActionsRequest> request = null;
    Response<EnableAlarmActionsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new EnableAlarmActionsRequestMarshaller().marshall((EnableAlarmActionsRequest)super.beforeMarshalling(enableAlarmActionsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableAlarmActions");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new EnableAlarmActionsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (EnableAlarmActionsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetDashboardResult getDashboard(GetDashboardRequest request)
  {
    request = (GetDashboardRequest)beforeClientExecution(request);
    return executeGetDashboard(request);
  }
  
  @SdkInternalApi
  final GetDashboardResult executeGetDashboard(GetDashboardRequest getDashboardRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getDashboardRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetDashboardRequest> request = null;
    Response<GetDashboardResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetDashboardRequestMarshaller().marshall((GetDashboardRequest)super.beforeMarshalling(getDashboardRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetDashboard");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetDashboardResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetDashboardResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetMetricDataResult getMetricData(GetMetricDataRequest request)
  {
    request = (GetMetricDataRequest)beforeClientExecution(request);
    return executeGetMetricData(request);
  }
  
  @SdkInternalApi
  final GetMetricDataResult executeGetMetricData(GetMetricDataRequest getMetricDataRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getMetricDataRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetMetricDataRequest> request = null;
    Response<GetMetricDataResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetMetricDataRequestMarshaller().marshall((GetMetricDataRequest)super.beforeMarshalling(getMetricDataRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetMetricData");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetMetricDataResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetMetricDataResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest request)
  {
    request = (GetMetricStatisticsRequest)beforeClientExecution(request);
    return executeGetMetricStatistics(request);
  }
  
  @SdkInternalApi
  final GetMetricStatisticsResult executeGetMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getMetricStatisticsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetMetricStatisticsRequest> request = null;
    Response<GetMetricStatisticsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetMetricStatisticsRequestMarshaller().marshall((GetMetricStatisticsRequest)super.beforeMarshalling(getMetricStatisticsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetMetricStatistics");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetMetricStatisticsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetMetricStatisticsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetMetricWidgetImageResult getMetricWidgetImage(GetMetricWidgetImageRequest request)
  {
    request = (GetMetricWidgetImageRequest)beforeClientExecution(request);
    return executeGetMetricWidgetImage(request);
  }
  
  @SdkInternalApi
  final GetMetricWidgetImageResult executeGetMetricWidgetImage(GetMetricWidgetImageRequest getMetricWidgetImageRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getMetricWidgetImageRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetMetricWidgetImageRequest> request = null;
    Response<GetMetricWidgetImageResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetMetricWidgetImageRequestMarshaller().marshall((GetMetricWidgetImageRequest)super.beforeMarshalling(getMetricWidgetImageRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetMetricWidgetImage");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetMetricWidgetImageResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetMetricWidgetImageResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListDashboardsResult listDashboards(ListDashboardsRequest request)
  {
    request = (ListDashboardsRequest)beforeClientExecution(request);
    return executeListDashboards(request);
  }
  
  @SdkInternalApi
  final ListDashboardsResult executeListDashboards(ListDashboardsRequest listDashboardsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listDashboardsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListDashboardsRequest> request = null;
    Response<ListDashboardsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListDashboardsRequestMarshaller().marshall((ListDashboardsRequest)super.beforeMarshalling(listDashboardsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListDashboards");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListDashboardsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListDashboardsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListMetricsResult listMetrics(ListMetricsRequest request)
  {
    request = (ListMetricsRequest)beforeClientExecution(request);
    return executeListMetrics(request);
  }
  
  @SdkInternalApi
  final ListMetricsResult executeListMetrics(ListMetricsRequest listMetricsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listMetricsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListMetricsRequest> request = null;
    Response<ListMetricsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListMetricsRequestMarshaller().marshall((ListMetricsRequest)super.beforeMarshalling(listMetricsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListMetrics");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListMetricsResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListMetricsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListMetricsResult listMetrics()
  {
    return listMetrics(new ListMetricsRequest());
  }
  
  public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest request)
  {
    request = (ListTagsForResourceRequest)beforeClientExecution(request);
    return executeListTagsForResource(request);
  }
  
  @SdkInternalApi
  final ListTagsForResourceResult executeListTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listTagsForResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListTagsForResourceRequest> request = null;
    Response<ListTagsForResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListTagsForResourceRequestMarshaller().marshall((ListTagsForResourceRequest)super.beforeMarshalling(listTagsForResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListTagsForResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListTagsForResourceResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListTagsForResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutAnomalyDetectorResult putAnomalyDetector(PutAnomalyDetectorRequest request)
  {
    request = (PutAnomalyDetectorRequest)beforeClientExecution(request);
    return executePutAnomalyDetector(request);
  }
  
  @SdkInternalApi
  final PutAnomalyDetectorResult executePutAnomalyDetector(PutAnomalyDetectorRequest putAnomalyDetectorRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putAnomalyDetectorRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutAnomalyDetectorRequest> request = null;
    Response<PutAnomalyDetectorResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutAnomalyDetectorRequestMarshaller().marshall((PutAnomalyDetectorRequest)super.beforeMarshalling(putAnomalyDetectorRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutAnomalyDetector");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutAnomalyDetectorResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutAnomalyDetectorResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutDashboardResult putDashboard(PutDashboardRequest request)
  {
    request = (PutDashboardRequest)beforeClientExecution(request);
    return executePutDashboard(request);
  }
  
  @SdkInternalApi
  final PutDashboardResult executePutDashboard(PutDashboardRequest putDashboardRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putDashboardRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutDashboardRequest> request = null;
    Response<PutDashboardResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutDashboardRequestMarshaller().marshall((PutDashboardRequest)super.beforeMarshalling(putDashboardRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutDashboard");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutDashboardResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutDashboardResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutMetricAlarmResult putMetricAlarm(PutMetricAlarmRequest request)
  {
    request = (PutMetricAlarmRequest)beforeClientExecution(request);
    return executePutMetricAlarm(request);
  }
  
  @SdkInternalApi
  final PutMetricAlarmResult executePutMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putMetricAlarmRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutMetricAlarmRequest> request = null;
    Response<PutMetricAlarmResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutMetricAlarmRequestMarshaller().marshall((PutMetricAlarmRequest)super.beforeMarshalling(putMetricAlarmRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutMetricAlarm");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutMetricAlarmResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutMetricAlarmResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutMetricDataResult putMetricData(PutMetricDataRequest request)
  {
    request = (PutMetricDataRequest)beforeClientExecution(request);
    return executePutMetricData(request);
  }
  
  @SdkInternalApi
  final PutMetricDataResult executePutMetricData(PutMetricDataRequest putMetricDataRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putMetricDataRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutMetricDataRequest> request = null;
    Response<PutMetricDataResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutMetricDataRequestMarshaller().marshall((PutMetricDataRequest)super.beforeMarshalling(putMetricDataRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutMetricData");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutMetricDataResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutMetricDataResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SetAlarmStateResult setAlarmState(SetAlarmStateRequest request)
  {
    request = (SetAlarmStateRequest)beforeClientExecution(request);
    return executeSetAlarmState(request);
  }
  
  @SdkInternalApi
  final SetAlarmStateResult executeSetAlarmState(SetAlarmStateRequest setAlarmStateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(setAlarmStateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SetAlarmStateRequest> request = null;
    Response<SetAlarmStateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SetAlarmStateRequestMarshaller().marshall((SetAlarmStateRequest)super.beforeMarshalling(setAlarmStateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SetAlarmState");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SetAlarmStateResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SetAlarmStateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TagResourceResult tagResource(TagResourceRequest request)
  {
    request = (TagResourceRequest)beforeClientExecution(request);
    return executeTagResource(request);
  }
  
  @SdkInternalApi
  final TagResourceResult executeTagResource(TagResourceRequest tagResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(tagResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TagResourceRequest> request = null;
    Response<TagResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TagResourceRequestMarshaller().marshall((TagResourceRequest)super.beforeMarshalling(tagResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new TagResourceResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (TagResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UntagResourceResult untagResource(UntagResourceRequest request)
  {
    request = (UntagResourceRequest)beforeClientExecution(request);
    return executeUntagResource(request);
  }
  
  @SdkInternalApi
  final UntagResourceResult executeUntagResource(UntagResourceRequest untagResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(untagResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UntagResourceRequest> request = null;
    Response<UntagResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UntagResourceRequestMarshaller().marshall((UntagResourceRequest)super.beforeMarshalling(untagResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "CloudWatch");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UntagResourceResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UntagResourceResult)response.getAwsResponse();
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
    
    DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
  
  public AmazonCloudWatchWaiters waiters()
  {
    if (waiters == null) {
      synchronized (this)
      {
        if (waiters == null) {
          waiters = new AmazonCloudWatchWaiters(this);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */