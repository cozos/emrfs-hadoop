package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.RequestExecutionBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.List;

@Immutable
@ThreadSafe
@SdkProtectedApi
public class ClientHandlerImpl
  extends ClientHandler
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private final SignerProvider signerProvider;
  private final URI endpoint;
  private final List<RequestHandler2> requestHandler2s;
  private final RequestMetricCollector clientLevelMetricCollector;
  private final AmazonHttpClient client;
  
  public ClientHandlerImpl(ClientHandlerParams handlerParams)
  {
    signerProvider = handlerParams.getClientParams().getSignerProvider();
    endpoint = handlerParams.getClientParams().getEndpoint();
    awsCredentialsProvider = handlerParams.getClientParams().getCredentialsProvider();
    requestHandler2s = handlerParams.getClientParams().getRequestHandlers();
    clientLevelMetricCollector = handlerParams.getClientParams().getRequestMetricCollector();
    client = buildHttpClient(handlerParams);
  }
  
  private AmazonHttpClient buildHttpClient(ClientHandlerParams handlerParams)
  {
    AwsSyncClientParams clientParams = handlerParams.getClientParams();
    return AmazonHttpClient.builder()
      .clientConfiguration(clientParams.getClientConfiguration())
      .retryPolicy(clientParams.getRetryPolicy())
      .requestMetricCollector(clientParams.getRequestMetricCollector())
      .useBrowserCompatibleHostNameVerifier(handlerParams.isDisableStrictHostnameVerification())
      .build();
  }
  
  public <Input, Output> Output execute(ClientExecutionParams<Input, Output> executionParams)
  {
    Input input = executionParams.getInput();
    ExecutionContext executionContext = createExecutionContext(executionParams
      .getRequestConfig());
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<Input> request = null;
    Response<Output> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = (Request)executionParams.getMarshaller().marshall(input);
        request.setAWSRequestMetrics(awsRequestMetrics);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      response = invoke(request, executionParams
        .getRequestConfig(), executionContext, executionParams
        
        .getResponseHandler(), executionParams
        .getErrorResponseHandler());
      
      return (Output)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, executionParams
        .getRequestConfig(), request, response);
    }
  }
  
  public void shutdown()
  {
    client.shutdown();
  }
  
  private ExecutionContext createExecutionContext(RequestConfig requestConfig)
  {
    boolean isMetricsEnabled = isRequestMetricsEnabled(requestConfig);
    return ExecutionContext.builder()
      .withRequestHandler2s(requestHandler2s)
      .withUseRequestMetrics(isMetricsEnabled)
      .withSignerProvider(signerProvider)
      .build();
  }
  
  private boolean isRequestMetricsEnabled(RequestConfig requestConfig)
  {
    return (hasRequestMetricsCollector(requestConfig)) || (isRMCEnabledAtClientOrSdkLevel());
  }
  
  private boolean hasRequestMetricsCollector(RequestConfig requestConfig)
  {
    return (requestConfig.getRequestMetricsCollector() != null) && 
      (requestConfig.getRequestMetricsCollector().isEnabled());
  }
  
  private boolean isRMCEnabledAtClientOrSdkLevel()
  {
    RequestMetricCollector collector = requestMetricCollector();
    return (collector != null) && (collector.isEnabled());
  }
  
  private RequestMetricCollector requestMetricCollector()
  {
    return clientLevelMetricCollector != null ? clientLevelMetricCollector : 
      AwsSdkMetrics.getRequestMetricCollector();
  }
  
  protected final <T extends AmazonWebServiceRequest> T beforeMarshalling(T request)
  {
    T local = request;
    for (RequestHandler2 handler : requestHandler2s) {
      local = handler.beforeMarshalling(local);
    }
    return local;
  }
  
  private <Output, Input> Response<Output> invoke(Request<Input> request, RequestConfig requestConfig, ExecutionContext executionContext, HttpResponseHandler<Output> responseHandler, HttpResponseHandler<? extends SdkBaseException> errorResponseHandler)
  {
    executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(requestConfig, awsCredentialsProvider));
    
    return doInvoke(request, requestConfig, executionContext, responseHandler, errorResponseHandler);
  }
  
  private <Output, Input> Response<Output> doInvoke(Request<Input> request, RequestConfig requestConfig, ExecutionContext executionContext, HttpResponseHandler<Output> responseHandler, HttpResponseHandler<? extends SdkBaseException> errorResponseHandler)
  {
    request.setEndpoint(endpoint);
    return client.requestExecutionBuilder()
      .request(request)
      .requestConfig(requestConfig)
      .executionContext(executionContext)
      .errorResponseHandler(errorResponseHandler)
      .execute(responseHandler);
  }
  
  private void endClientExecution(AWSRequestMetrics awsRequestMetrics, RequestConfig requestConfig, Request<?> request, Response<?> response)
  {
    if (request != null)
    {
      awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
      awsRequestMetrics.getTimingInfo().endTiming();
      RequestMetricCollector metricCollector = findRequestMetricCollector(requestConfig);
      metricCollector.collectMetrics(request, response);
      awsRequestMetrics.log();
    }
  }
  
  private RequestMetricCollector findRequestMetricCollector(RequestConfig requestConfig)
  {
    RequestMetricCollector reqLevelMetricsCollector = requestConfig.getRequestMetricsCollector();
    if (reqLevelMetricsCollector != null) {
      return reqLevelMetricsCollector;
    }
    if (clientLevelMetricCollector != null) {
      return clientLevelMetricCollector;
    }
    return AwsSdkMetrics.getRequestMetricCollector();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.ClientHandlerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */