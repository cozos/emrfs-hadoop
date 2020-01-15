package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions.Marker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerAfterAttemptContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.ApiCallAttemptMonitoringEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.ApiCallMonitoringEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsClientSideMonitoringMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CollectionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public final class ClientSideMonitoringRequestHandler
  extends RequestHandler2
{
  private static final Log LOG = LogFactory.getLog(ClientSideMonitoringRequestHandler.class);
  private static final String X_AMZN_REQUEST_ID_HEADER_KEY = "x-amzn-RequestId";
  private static final String X_AMZ_REQUEST_ID_HEADER_KEY = "x-amz-request-id";
  private static final String X_AMZ_REQUEST_ID_2_HEADER_KEY = "x-amz-id-2";
  private static final String EXCEPTION_MESSAGE_KEY = "ExceptionMessage";
  private static final String EXCEPTION_KEY = "Exception";
  private static final String CLIENT_ID_KEY = "ClientId";
  private static final String USER_AGENT_KEY = "UserAgent";
  private static final HandlerContextKey<ApiCallAttemptMonitoringEvent> LAST_CALL_ATTEMPT = new HandlerContextKey("LastCallAttemptMonitoringEvent");
  private static final Integer VERSION = Integer.valueOf(1);
  private static final List<String> SECURITY_TOKENS = Arrays.asList(new String[] { "x-amz-security-token", "X-Amz-Security-Token" });
  private static final Map<String, Integer> ENTRY_TO_MAX_SIZE = new ImmutableMapParameter.Builder()
    .put("ClientId", Integer.valueOf(255))
    .put("UserAgent", Integer.valueOf(256))
    .put("ExceptionMessage", Integer.valueOf(512))
    .put("Exception", Integer.valueOf(128)).build();
  private final String clientId;
  private final Collection<MonitoringListener> monitoringListeners;
  
  public ClientSideMonitoringRequestHandler(String clientId, Collection<MonitoringListener> monitoringListeners)
  {
    this.clientId = trimValueIfExceedsMaxLength("ClientId", clientId);
    this.monitoringListeners = monitoringListeners;
  }
  
  public void afterAttempt(HandlerAfterAttemptContext context)
  {
    ApiCallAttemptMonitoringEvent event = generateApiCallAttemptMonitoringEvent(context);
    context.getRequest().addHandlerContext(LAST_CALL_ATTEMPT, event);
    handToMonitoringListeners(event);
  }
  
  public void afterResponse(Request<?> request, Response<?> response)
  {
    ApiCallMonitoringEvent event = generateApiCallMonitoringEvent(request);
    handToMonitoringListeners(event);
  }
  
  public void afterError(Request<?> request, Response<?> response, Exception e)
  {
    ApiCallMonitoringEvent event = generateApiCallMonitoringEvent(request, e);
    handToMonitoringListeners(event);
  }
  
  private ApiCallAttemptMonitoringEvent generateApiCallAttemptMonitoringEvent(HandlerAfterAttemptContext context)
  {
    Request<?> request = context.getRequest();
    AWSRequestMetrics metrics = context.getRequest().getAWSRequestMetrics();
    
    String apiName = (String)request.getHandlerContext(HandlerContextKey.OPERATION_NAME);
    String serviceId = (String)request.getHandlerContext(HandlerContextKey.SERVICE_ID);
    String sessionToken = getSessionToken(request.getHeaders());
    String region = (String)request.getHandlerContext(HandlerContextKey.SIGNING_REGION);
    
    String accessKey = null;
    if (request.getHandlerContext(HandlerContextKey.AWS_CREDENTIALS) != null) {
      accessKey = ((AWSCredentials)request.getHandlerContext(HandlerContextKey.AWS_CREDENTIALS)).getAWSAccessKeyId();
    }
    String fqdn = extractFqdn(request.getEndpoint());
    TimingInfo timingInfo = metrics == null ? null : metrics.getTimingInfo();
    
    Long timestamp = null;
    Long attemptLatency = null;
    if ((timingInfo != null) && (timingInfo.getLastSubMeasurement(AWSRequestMetrics.Field.HttpRequestTime.name()) != null))
    {
      TimingInfo httpRequestTime = timingInfo.getLastSubMeasurement(AWSRequestMetrics.Field.HttpRequestTime.name());
      timestamp = httpRequestTime.getStartEpochTimeMilliIfKnown();
      attemptLatency = convertToLongIfNotNull(httpRequestTime.getTimeTakenMillisIfKnown());
    }
    ApiCallAttemptMonitoringEvent event = new ApiCallAttemptMonitoringEvent().withFqdn(fqdn).withVersion(VERSION).withService(serviceId).withClientId(clientId).withRegion(region).withAccessKey(accessKey).withUserAgent(trimValueIfExceedsMaxLength("UserAgent", getDefaultUserAgent(request))).withTimestamp(timestamp).withAttemptLatency(attemptLatency).withSessionToken(sessionToken).withApi(apiName);
    
    addConditionalFieldsToAttemptEvent(metrics, context, event);
    return event;
  }
  
  private ApiCallMonitoringEvent generateApiCallMonitoringEvent(Request<?> request)
  {
    String apiName = (String)request.getHandlerContext(HandlerContextKey.OPERATION_NAME);
    String serviceId = (String)request.getHandlerContext(HandlerContextKey.SERVICE_ID);
    String region = (String)request.getHandlerContext(HandlerContextKey.SIGNING_REGION);
    ApiCallAttemptMonitoringEvent lastApiCallAttempt = (ApiCallAttemptMonitoringEvent)request.getHandlerContext(LAST_CALL_ATTEMPT);
    
    Long timestamp = null;
    Long latency = null;
    Integer requestCount = Integer.valueOf(0);
    AWSRequestMetrics metrics = request.getAWSRequestMetrics();
    if (metrics != null)
    {
      TimingInfo timingInfo = metrics.getTimingInfo();
      requestCount = Integer.valueOf(timingInfo.getCounter(AWSRequestMetrics.Field.RequestCount.name()) == null ? 0 : timingInfo
        .getCounter(AWSRequestMetrics.Field.RequestCount.name()).intValue());
      
      TimingInfo latencyTimingInfo = timingInfo.getSubMeasurement(AwsClientSideMonitoringMetrics.ApiCallLatency.name());
      if (latencyTimingInfo != null)
      {
        latency = convertToLongIfNotNull(latencyTimingInfo.getTimeTakenMillisIfKnown());
        timestamp = latencyTimingInfo.getStartEpochTimeMilliIfKnown();
      }
    }
    ApiCallMonitoringEvent event = new ApiCallMonitoringEvent().withApi(apiName).withVersion(VERSION).withRegion(region).withService(serviceId).withClientId(clientId).withAttemptCount(requestCount).withLatency(latency).withUserAgent(trimValueIfExceedsMaxLength("UserAgent", getDefaultUserAgent(request))).withTimestamp(timestamp);
    if (lastApiCallAttempt != null) {
      event.withFinalAwsException(lastApiCallAttempt.getAwsException()).withFinalAwsExceptionMessage(lastApiCallAttempt.getAwsExceptionMessage()).withFinalSdkException(lastApiCallAttempt.getSdkException()).withFinalSdkExceptionMessage(lastApiCallAttempt.getSdkExceptionMessage()).withFinalHttpStatusCode(lastApiCallAttempt.getHttpStatusCode());
    }
    return event;
  }
  
  private ApiCallMonitoringEvent generateApiCallMonitoringEvent(Request<?> request, Exception e)
  {
    ApiCallMonitoringEvent event = generateApiCallMonitoringEvent(request);
    AWSRequestMetrics metrics = request.getAWSRequestMetrics();
    if ((e instanceof ClientExecutionTimeoutException)) {
      event.withApiCallTimeout(1);
    }
    if ((metrics != null) && (!CollectionUtils.isNullOrEmpty(metrics.getProperty(AwsClientSideMonitoringMetrics.MaxRetriesExceeded))))
    {
      boolean maxRetriesExceeded = ((Boolean)metrics.getProperty(AwsClientSideMonitoringMetrics.MaxRetriesExceeded).get(0)).booleanValue();
      event.withMaxRetriesExceeded(maxRetriesExceeded ? 1 : 0);
    }
    return event;
  }
  
  private void addConditionalFieldsToAttemptEvent(AWSRequestMetrics metrics, HandlerAfterAttemptContext context, ApiCallAttemptMonitoringEvent event)
  {
    TimingInfo timingInfo = metrics == null ? null : metrics.getTimingInfo();
    Response<?> response = context.getResponse();
    Integer statusCode = null;
    String xAmznRequestId = null;
    String xAmzRequestId = null;
    String xAmzId2 = null;
    Long requestLatency = null;
    
    Map<String, String> responseHeaders = null;
    if ((response != null) && (response.getHttpResponse() != null))
    {
      responseHeaders = response.getHttpResponse().getHeaders();
      statusCode = Integer.valueOf(response.getHttpResponse().getStatusCode());
      requestLatency = calculateRequestLatency(timingInfo);
    }
    else if ((context.getException() instanceof AmazonServiceException))
    {
      responseHeaders = ((AmazonServiceException)context.getException()).getHttpHeaders();
      statusCode = Integer.valueOf(extractHttpStatusCode((AmazonServiceException)context.getException()));
      requestLatency = calculateRequestLatency(timingInfo);
    }
    if (responseHeaders != null)
    {
      xAmznRequestId = (String)responseHeaders.get("x-amzn-RequestId");
      xAmzRequestId = (String)responseHeaders.get("x-amz-request-id");
      xAmzId2 = (String)responseHeaders.get("x-amz-id-2");
    }
    event.withXAmznRequestId(xAmznRequestId).withXAmzRequestId(xAmzRequestId).withXAmzId2(xAmzId2).withHttpStatusCode(statusCode).withRequestLatency(requestLatency);
    addException(context.getException(), event);
  }
  
  private void handToMonitoringListeners(MonitoringEvent event)
  {
    for (MonitoringListener monitoringListener : monitoringListeners) {
      try
      {
        monitoringListener.handleEvent(event);
      }
      catch (Exception exception)
      {
        if (LOG.isDebugEnabled()) {
          LOG.debug(String.format("MonitoringListener: %s failed to handle event", new Object[] { monitoringListener.toString() }), exception);
        }
      }
    }
  }
  
  private String extractFqdn(URI endpoint)
  {
    if (endpoint == null) {
      return null;
    }
    return endpoint.getHost();
  }
  
  private String trimValueIfExceedsMaxLength(String entry, String value)
  {
    if (value == null) {
      return null;
    }
    String result = value;
    Integer maximumSize = (Integer)ENTRY_TO_MAX_SIZE.get(entry);
    if ((maximumSize != null) && (value.length() > maximumSize.intValue())) {
      result = value.substring(0, maximumSize.intValue());
    }
    return result;
  }
  
  private String getDefaultUserAgent(Request<?> request)
  {
    String userAgentMarker = request.getOriginalRequest().getRequestClientOptions().getClientMarker(RequestClientOptions.Marker.USER_AGENT);
    
    String userAgent = ClientConfiguration.DEFAULT_USER_AGENT;
    if (StringUtils.hasValue(userAgentMarker)) {
      userAgent = userAgent + " " + userAgentMarker;
    }
    return userAgent;
  }
  
  private String getSessionToken(Map<String, String> requestHeaders)
  {
    for (String header : SECURITY_TOKENS) {
      if (requestHeaders.get(header) != null) {
        return (String)requestHeaders.get(header);
      }
    }
    return null;
  }
  
  private Long convertToLongIfNotNull(Double number)
  {
    if (number == null) {
      return null;
    }
    return Long.valueOf(number.longValue());
  }
  
  private Long calculateRequestLatency(TimingInfo timingInfo)
  {
    if (timingInfo == null) {
      return null;
    }
    TimingInfo httpClientSendRequestTime = timingInfo.getLastSubMeasurement(AWSRequestMetrics.Field.HttpClientSendRequestTime
      .name());
    TimingInfo httpClientReceiveResponseTime = timingInfo.getLastSubMeasurement(AWSRequestMetrics.Field.HttpClientReceiveResponseTime
      .name());
    if ((httpClientSendRequestTime != null) && (httpClientSendRequestTime.getTimeTakenMillisIfKnown() != null) && (httpClientReceiveResponseTime != null) && 
      (httpClientReceiveResponseTime.getTimeTakenMillisIfKnown() != null)) {
      return Long.valueOf(httpClientSendRequestTime.getTimeTakenMillisIfKnown().longValue() + httpClientReceiveResponseTime
        .getTimeTakenMillisIfKnown().longValue());
    }
    return null;
  }
  
  private void addException(Exception exception, ApiCallAttemptMonitoringEvent event)
  {
    if (exception == null) {
      return;
    }
    if ((exception instanceof AmazonServiceException))
    {
      String errorCode = ((AmazonServiceException)exception).getErrorCode();
      String errorMessage = ((AmazonServiceException)exception).getErrorMessage();
      
      event.withAwsException(trimValueIfExceedsMaxLength("Exception", errorCode));
      event.withAwsExceptionMessage(trimValueIfExceedsMaxLength("ExceptionMessage", errorMessage));
    }
    else
    {
      String exceptionClassName = exception.getClass().getName();
      String exceptionMessage = getRootCauseMessage(exception);
      
      event.withSdkException(trimValueIfExceedsMaxLength("Exception", exceptionClassName));
      event.withSdkExceptionMessage(trimValueIfExceedsMaxLength("ExceptionMessage", exceptionMessage));
    }
  }
  
  private String getRootCauseMessage(Exception exception)
  {
    if (exception.getMessage() != null) {
      return exception.getMessage();
    }
    return Throwables.getRootCause(exception).getMessage();
  }
  
  private int extractHttpStatusCode(AmazonServiceException exception)
  {
    return exception.getStatusCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.ClientSideMonitoringRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */