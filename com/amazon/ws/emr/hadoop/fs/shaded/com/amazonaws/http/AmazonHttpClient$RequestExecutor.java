package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions.Marker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResetException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalTime;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWS4Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.CanHandleNullCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerAfterAttemptContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerAfterAttemptContext.HandlerAfterAttemptContextBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerBeforeAttemptContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerBeforeAttemptContext.HandlerBeforeAttemptContextBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.ConnectionManagerAwareHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.ApacheUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.exception.HttpRequestTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.request.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionAbortTrackerTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionTimer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.SdkInterruptedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.HttpRequestAbortTaskTracker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.HttpRequestTimer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CRC32MismatchException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ReleasableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ResettableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkBufferedInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.ClientSideMonitoringRequestHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.ClockSkewAdjuster;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.ClockSkewAdjuster.AdjustmentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.ClockSkewAdjuster.ClockSkewAdjustment;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicyAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthErrorRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthRetryParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsClientSideMonitoringMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CapacityManager;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CollectionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CountingInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.RuntimeHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.UnreliableFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BufferedHttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.RequestAbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnPoolControl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolStats;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazonaws.auth.AWSCredentials;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

class AmazonHttpClient$RequestExecutor<Output>
{
  private final Request<?> request;
  private final RequestConfig requestConfig;
  private final HttpResponseHandler<? extends SdkBaseException> errorResponseHandler;
  private final HttpResponseHandler<Output> responseHandler;
  private final ExecutionContext executionContext;
  private final List<RequestHandler2> requestHandler2s;
  private final AWSRequestMetrics awsRequestMetrics;
  private RequestHandler2 csmRequestHandler;
  
  private AmazonHttpClient$RequestExecutor(Request<?> arg1, RequestConfig request, HttpResponseHandler<? extends SdkBaseException> requestConfig, HttpResponseHandler<Output> errorResponseHandler, ExecutionContext responseHandler, List<RequestHandler2> executionContext)
  {
    this.request = request;
    this.requestConfig = requestConfig;
    this.errorResponseHandler = errorResponseHandler;
    this.responseHandler = responseHandler;
    this.executionContext = executionContext;
    this.requestHandler2s = requestHandler2s;
    awsRequestMetrics = executionContext.getAwsRequestMetrics();
    for (RequestHandler2 requestHandler2 : requestHandler2s) {
      if ((requestHandler2 instanceof ClientSideMonitoringRequestHandler))
      {
        csmRequestHandler = requestHandler2;
        break;
      }
    }
  }
  
  private Response<Output> execute()
  {
    if (executionContext == null) {
      throw new SdkClientException("Internal SDK Error: No execution context parameter specified.");
    }
    try
    {
      return executeWithTimer();
    }
    catch (InterruptedException ie)
    {
      throw handleInterruptedException(ie);
    }
    catch (AbortedException ae)
    {
      throw handleAbortedException(ae);
    }
  }
  
  private Response<Output> executeWithTimer()
    throws InterruptedException
  {
    ClientExecutionAbortTrackerTask clientExecutionTrackerTask = AmazonHttpClient.access$600(this$0).startTimer(getClientExecutionTimeout(requestConfig));
    try
    {
      executionContext.setClientExecutionTrackerTask(clientExecutionTrackerTask);
      return doExecute();
    }
    finally
    {
      executionContext.getClientExecutionTrackerTask().cancelTask();
    }
  }
  
  private Response<Output> doExecute()
    throws InterruptedException
  {
    runBeforeRequestHandlers();
    setSdkTransactionId(request);
    setUserAgent(request);
    
    ProgressListener listener = requestConfig.getProgressListener();
    
    request.getHeaders().putAll(AmazonHttpClient.access$700(this$0).getHeaders());
    request.getHeaders().putAll(requestConfig.getCustomRequestHeaders());
    
    mergeQueryParameters(requestConfig.getCustomQueryParameters());
    Response<Output> response = null;
    InputStream origContent = request.getContent();
    InputStream toBeClosed = beforeRequest();
    
    InputStream notCloseable = toBeClosed == null ? null : ReleasableInputStream.wrap(toBeClosed).disableClose();
    request.setContent(notCloseable);
    try
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.CLIENT_REQUEST_STARTED_EVENT);
      response = executeHelper();
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.CLIENT_REQUEST_SUCCESS_EVENT);
      awsRequestMetrics.endEvent(AwsClientSideMonitoringMetrics.ApiCallLatency);
      awsRequestMetrics.getTimingInfo().endTiming();
      afterResponse(response);
      return response;
    }
    catch (AmazonClientException e)
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.CLIENT_REQUEST_FAILED_EVENT);
      
      awsRequestMetrics.endEvent(AwsClientSideMonitoringMetrics.ApiCallLatency);
      
      afterError(response, e);
      throw e;
    }
    finally
    {
      closeQuietlyForRuntimeExceptions(toBeClosed, AmazonHttpClient.log);
      request.setContent(origContent);
    }
  }
  
  private void closeQuietlyForRuntimeExceptions(Closeable c, Log log)
  {
    try
    {
      IOUtils.closeQuietly(c, log);
    }
    catch (RuntimeException e)
    {
      if (log.isDebugEnabled()) {
        log.debug("Unable to close closeable", e);
      }
    }
  }
  
  private void runBeforeRequestHandlers()
  {
    AWSCredentials credentials = getCredentialsFromContext();
    request.addHandlerContext(HandlerContextKey.AWS_CREDENTIALS, credentials);
    for (RequestHandler2 requestHandler2 : requestHandler2s)
    {
      if ((requestHandler2 instanceof CredentialsRequestHandler)) {
        ((CredentialsRequestHandler)requestHandler2).setCredentials(credentials);
      }
      requestHandler2.beforeRequest(request);
    }
  }
  
  private RuntimeException handleInterruptedException(InterruptedException e)
  {
    if (((e instanceof SdkInterruptedException)) && 
      (((SdkInterruptedException)e).getResponse() != null)) {
      ((SdkInterruptedException)e).getResponse().getHttpResponse().getHttpRequest().abort();
    }
    if (executionContext.getClientExecutionTrackerTask().hasTimeoutExpired())
    {
      Thread.interrupted();
      ClientExecutionTimeoutException exception = new ClientExecutionTimeoutException();
      reportClientExecutionTimeout(exception);
      return exception;
    }
    Thread.currentThread().interrupt();
    return new AbortedException(e);
  }
  
  private RuntimeException handleAbortedException(AbortedException ae)
  {
    if (executionContext.getClientExecutionTrackerTask().hasTimeoutExpired())
    {
      Thread.interrupted();
      ClientExecutionTimeoutException exception = new ClientExecutionTimeoutException();
      reportClientExecutionTimeout(exception);
      return exception;
    }
    Thread.currentThread().interrupt();
    return ae;
  }
  
  private void reportClientExecutionTimeout(ClientExecutionTimeoutException exception)
  {
    if (csmRequestHandler != null) {
      csmRequestHandler.afterError(request, null, exception);
    }
  }
  
  private void checkInterrupted()
    throws InterruptedException
  {
    checkInterrupted(null);
  }
  
  private void checkInterrupted(Response<?> response)
    throws InterruptedException
  {
    if (Thread.interrupted()) {
      throw new SdkInterruptedException(response);
    }
  }
  
  private void mergeQueryParameters(Map<String, List<String>> params)
  {
    Map<String, List<String>> existingParams = request.getParameters();
    for (Map.Entry<String, List<String>> param : params.entrySet())
    {
      String pName = (String)param.getKey();
      List<String> pValues = (List)param.getValue();
      existingParams.put(pName, CollectionUtils.mergeLists((List)existingParams.get(pName), pValues));
    }
  }
  
  private InputStream beforeRequest()
  {
    ProgressListener listener = requestConfig.getProgressListener();
    reportContentLength(listener);
    if (request.getContent() == null) {
      return null;
    }
    InputStream content = monitorStreamProgress(listener, 
      buffer(
      makeResettable(request
      .getContent())));
    if (AmazonHttpClient.access$800() == null) {
      return content;
    }
    return wrapWithUnreliableStream(content);
  }
  
  private void reportContentLength(ProgressListener listener)
  {
    Map<String, String> headers = request.getHeaders();
    String contentLengthStr = (String)headers.get("Content-Length");
    if (contentLengthStr != null) {
      try
      {
        long contentLength = Long.parseLong(contentLengthStr);
        SDKProgressPublisher.publishRequestContentLength(listener, contentLength);
      }
      catch (NumberFormatException e)
      {
        AmazonHttpClient.log.warn("Cannot parse the Content-Length header of the request.");
      }
    }
  }
  
  private InputStream makeResettable(InputStream content)
  {
    if (!content.markSupported()) {
      if ((content instanceof FileInputStream)) {
        try
        {
          return new ResettableInputStream((FileInputStream)content);
        }
        catch (IOException e)
        {
          if (AmazonHttpClient.log.isDebugEnabled()) {
            AmazonHttpClient.log.debug("For the record; ignore otherwise", e);
          }
        }
      }
    }
    return content;
  }
  
  private InputStream buffer(InputStream content)
  {
    if (!content.markSupported()) {
      content = new SdkBufferedInputStream(content);
    }
    return content;
  }
  
  private InputStream monitorStreamProgress(ProgressListener listener, InputStream content)
  {
    return ProgressInputStream.inputStreamForRequest(content, listener);
  }
  
  private InputStream wrapWithUnreliableStream(InputStream content)
  {
    return 
    
      new UnreliableFilterInputStream(content, AmazonHttpClient.access$800().isFakeIOException()).withBytesReadBeforeException(AmazonHttpClient.access$800().getBytesReadBeforeException()).withMaxNumErrors(AmazonHttpClient.access$800().getMaxNumErrors()).withResetIntervalBeforeException(
      AmazonHttpClient.access$800().getResetIntervalBeforeException());
  }
  
  private void afterError(Response<?> response, AmazonClientException e)
    throws InterruptedException
  {
    for (RequestHandler2 handler2 : requestHandler2s)
    {
      handler2.afterError(request, response, e);
      checkInterrupted(response);
    }
  }
  
  private <T> void afterResponse(Response<T> response)
    throws InterruptedException
  {
    for (RequestHandler2 handler2 : requestHandler2s)
    {
      handler2.afterResponse(request, response);
      checkInterrupted(response);
    }
  }
  
  private <T> void beforeAttempt(HandlerBeforeAttemptContext context)
    throws InterruptedException
  {
    for (RequestHandler2 handler2 : requestHandler2s)
    {
      handler2.beforeAttempt(context);
      checkInterrupted();
    }
  }
  
  private <T> void afterAttempt(HandlerAfterAttemptContext context)
    throws InterruptedException
  {
    for (RequestHandler2 handler2 : requestHandler2s)
    {
      handler2.afterAttempt(context);
      checkInterrupted(context.getResponse());
    }
  }
  
  private Response<Output> executeHelper()
    throws InterruptedException
  {
    awsRequestMetrics.addPropertyWith(AWSRequestMetrics.Field.RequestType, requestConfig.getRequestType()).addPropertyWith(AWSRequestMetrics.Field.ServiceName, request.getServiceName()).addPropertyWith(AWSRequestMetrics.Field.ServiceEndpoint, request.getEndpoint());
    
    Map<String, List<String>> originalParameters = new LinkedHashMap(request.getParameters());
    Map<String, String> originalHeaders = new HashMap(request.getHeaders());
    
    RequestExecutor<Output>.ExecOneRequestParams execOneParams = new ExecOneRequestParams(null);
    InputStream originalContent = request.getContent();
    if ((originalContent != null) && (originalContent.markSupported()) && (!(originalContent instanceof BufferedInputStream)))
    {
      int readLimit = requestConfig.getRequestClientOptions().getReadLimit();
      originalContent.mark(readLimit);
    }
    awsRequestMetrics.startEvent(AwsClientSideMonitoringMetrics.ApiCallLatency);
    for (;;)
    {
      checkInterrupted();
      if (((originalContent instanceof BufferedInputStream)) && (originalContent.markSupported()))
      {
        int readLimit = requestConfig.getRequestClientOptions().getReadLimit();
        originalContent.mark(readLimit);
      }
      execOneParams.initPerRetry();
      URI redirectedURI = redirectedURI;
      if (redirectedURI != null)
      {
        String scheme = redirectedURI.getScheme();
        String beforeAuthority = scheme + "://";
        String authority = redirectedURI.getAuthority();
        String path = redirectedURI.getPath();
        
        request.setEndpoint(URI.create(beforeAuthority + authority));
        request.setResourcePath(SdkHttpUtils.urlEncode(path, true));
        awsRequestMetrics.addPropertyWith(AWSRequestMetrics.Field.RedirectLocation, redirectedURI
          .toString());
      }
      if (authRetryParam != null) {
        request.setEndpoint(authRetryParam.getEndpointForRetry());
      }
      awsRequestMetrics.setCounter(AWSRequestMetrics.Field.RequestCount, requestCount);
      if (execOneParams.isRetry())
      {
        request.setParameters(originalParameters);
        request.setHeaders(originalHeaders);
        request.setContent(originalContent);
      }
      Response<Output> response = null;
      Exception savedException = null;
      boolean thrown = false;
      try
      {
        HandlerBeforeAttemptContext beforeAttemptContext = HandlerBeforeAttemptContext.builder().withRequest(request).build();
        
        beforeAttempt(beforeAttemptContext);
        response = executeOneRequest(execOneParams);
        savedException = retriedException;
        if (response != null)
        {
          HttpEntity entity;
          HandlerAfterAttemptContext afterAttemptContext;
          return response;
        }
      }
      catch (IOException ioe)
      {
        HttpEntity entity;
        HandlerAfterAttemptContext afterAttemptContext;
        savedException = ioe;
        handleRetryableException(execOneParams, ioe);
      }
      catch (InterruptedException ie)
      {
        HttpEntity entity;
        HandlerAfterAttemptContext afterAttemptContext;
        savedException = ie;
        thrown = true;
        throw ie;
      }
      catch (RuntimeException e)
      {
        savedException = e;
        thrown = true;
        throw ((RuntimeException)lastReset(captureExceptionMetrics(e)));
      }
      catch (Error e)
      {
        thrown = true;
        throw ((Error)lastReset(captureExceptionMetrics(e)));
      }
      finally
      {
        if (((!leaveHttpConnectionOpen) || (thrown)) && 
          (apacheResponse != null))
        {
          HttpEntity entity = apacheResponse.getEntity();
          if (entity != null) {
            try
            {
              IOUtils.closeQuietly(entity.getContent(), AmazonHttpClient.log);
            }
            catch (IOException e)
            {
              AmazonHttpClient.log.warn("Cannot close the response content.", e);
            }
          }
        }
        HandlerAfterAttemptContext afterAttemptContext = HandlerAfterAttemptContext.builder().withRequest(request).withResponse(response).withException(savedException).build();
        
        afterAttempt(afterAttemptContext);
      }
    }
  }
  
  private void handleRetryableException(RequestExecutor<Output>.ExecOneRequestParams execOneParams, Exception e)
  {
    captureExceptionMetrics(e);
    awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, null);
    SdkClientException sdkClientException;
    SdkClientException sdkClientException;
    if (!(e instanceof SdkClientException)) {
      sdkClientException = new SdkClientException("Unable to execute HTTP request: " + e.getMessage(), e);
    } else {
      sdkClientException = (SdkClientException)e;
    }
    boolean willRetry = shouldRetry(execOneParams, sdkClientException);
    if (AmazonHttpClient.log.isTraceEnabled()) {
      AmazonHttpClient.log.trace(sdkClientException.getMessage() + (willRetry ? " Request will be retried." : ""), e);
    } else if (AmazonHttpClient.log.isDebugEnabled()) {
      AmazonHttpClient.log.trace(sdkClientException.getMessage() + (willRetry ? " Request will be retried." : ""));
    }
    if (!willRetry) {
      throw ((SdkClientException)lastReset(sdkClientException));
    }
    retriedException = sdkClientException;
  }
  
  private <T extends Throwable> T lastReset(T t)
  {
    try
    {
      InputStream content = request.getContent();
      if ((content != null) && 
        (content.markSupported())) {
        content.reset();
      }
    }
    catch (Exception ex)
    {
      AmazonHttpClient.log.debug("FYI: failed to reset content inputstream before throwing up", ex);
    }
    return t;
  }
  
  /* Error */
  private AWSCredentials getCredentialsFromContext()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:executionContext	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/ExecutionContext;
    //   4: invokevirtual 871	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/ExecutionContext:getCredentialsProvider	()Lcom/amazonaws/auth/AWSCredentialsProvider;
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_1
    //   11: ifnull +46 -> 57
    //   14: aload_0
    //   15: getfield 100	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:awsRequestMetrics	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics;
    //   18: getstatic 874	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field:CredentialsRequestTime	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field;
    //   21: invokevirtual 650	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/metrics/MetricType;)V
    //   24: aload_1
    //   25: invokeinterface 879 1 0
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 100	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:awsRequestMetrics	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics;
    //   35: getstatic 874	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field:CredentialsRequestTime	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field;
    //   38: invokevirtual 289	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/metrics/MetricType;)V
    //   41: goto +16 -> 57
    //   44: astore_3
    //   45: aload_0
    //   46: getfield 100	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:awsRequestMetrics	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics;
    //   49: getstatic 874	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field:CredentialsRequestTime	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field;
    //   52: invokevirtual 289	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/metrics/MetricType;)V
    //   55: aload_3
    //   56: athrow
    //   57: aload_2
    //   58: areturn
    // Line number table:
    //   Java source line #1219	-> byte code offset #0
    //   Java source line #1221	-> byte code offset #8
    //   Java source line #1222	-> byte code offset #10
    //   Java source line #1223	-> byte code offset #14
    //   Java source line #1225	-> byte code offset #24
    //   Java source line #1227	-> byte code offset #31
    //   Java source line #1228	-> byte code offset #41
    //   Java source line #1227	-> byte code offset #44
    //   Java source line #1228	-> byte code offset #55
    //   Java source line #1230	-> byte code offset #57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	RequestExecutor<Output>
    //   7	18	1	credentialsProvider	com.amazonaws.auth.AWSCredentialsProvider
    //   9	49	2	credentials	AWSCredentials
    //   44	12	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	31	44	finally
  }
  
  private Response<Output> executeOneRequest(RequestExecutor<Output>.ExecOneRequestParams execOneParams)
    throws IOException, InterruptedException
  {
    if (execOneParams.isRetry()) {
      resetRequestInputStream(request, retriedException);
    }
    checkInterrupted();
    if (AmazonHttpClient.requestLog.isDebugEnabled()) {
      AmazonHttpClient.requestLog.debug((execOneParams.isRetry() ? "Retrying " : "Sending ") + "Request: " + request);
    }
    AWSCredentials credentials = getCredentialsFromContext();
    ProgressListener listener = requestConfig.getProgressListener();
    if (execOneParams.isRetry()) {
      pauseBeforeRetry(execOneParams, listener);
    }
    updateRetryHeaderInfo(request, execOneParams);
    
    execOneParams.newSigner(request, executionContext);
    if ((signer != null) && ((credentials != null) || 
      ((signer instanceof CanHandleNullCredentials))))
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestSigningTime);
      try
      {
        if (AmazonHttpClient.access$1100(this$0) != 0) {
          request.setTimeOffset(AmazonHttpClient.access$1100(this$0));
        }
        signer.sign(request, credentials);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestSigningTime);
      }
    }
    checkInterrupted();
    execOneParams.newApacheRequest(AmazonHttpClient.access$1200(this$0), request, AmazonHttpClient.access$1300(this$0));
    
    captureConnectionPoolMetrics();
    
    HttpClientContext localRequestContext = ApacheUtils.newClientContext(AmazonHttpClient.access$1300(this$0), 
      ImmutableMapParameter.of(AWSRequestMetrics.SIMPLE_NAME, awsRequestMetrics));
    
    execOneParams.resetBeforeHttpRequest();
    SDKProgressPublisher.publishProgress(listener, ProgressEventType.HTTP_REQUEST_STARTED_EVENT);
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.HttpRequestTime);
    awsRequestMetrics.setCounter(AWSRequestMetrics.Field.RetryCapacityConsumed, AmazonHttpClient.access$1400(this$0).consumedCapacity());
    
    executionContext.getClientExecutionTrackerTask().setCurrentHttpRequest(apacheRequest);
    
    HttpRequestAbortTaskTracker requestAbortTaskTracker = AmazonHttpClient.access$1500(this$0).startTimer(apacheRequest, getRequestTimeout(requestConfig));
    try
    {
      apacheResponse = AmazonHttpClient.access$1600(this$0).execute(apacheRequest, localRequestContext);
      if (shouldBufferHttpEntity(responseHandler.needsConnectionLeftOpen(), executionContext, execOneParams, requestAbortTaskTracker)) {
        apacheResponse.setEntity(new BufferedHttpEntity(apacheResponse
          .getEntity()));
      }
    }
    catch (IOException ioe)
    {
      if (executionContext.getClientExecutionTrackerTask().hasTimeoutExpired()) {
        throw new InterruptedException();
      }
      if (requestAbortTaskTracker.httpRequestAborted())
      {
        if ((ioe instanceof RequestAbortedException)) {
          Thread.interrupted();
        }
        throw new HttpRequestTimeoutException(ioe);
      }
      throw ioe;
    }
    finally
    {
      requestAbortTaskTracker.cancelTask();
      awsRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpRequestTime);
    }
    SDKProgressPublisher.publishProgress(listener, ProgressEventType.HTTP_REQUEST_COMPLETED_EVENT);
    StatusLine statusLine = apacheResponse.getStatusLine();
    int statusCode = statusLine == null ? -1 : statusLine.getStatusCode();
    if (ApacheUtils.isRequestSuccessful(apacheResponse))
    {
      awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(statusCode));
      
      leaveHttpConnectionOpen = responseHandler.needsConnectionLeftOpen();
      HttpResponse httpResponse = ApacheUtils.createResponse(request, apacheRequest, apacheResponse, localRequestContext);
      Output response = handleResponse(httpResponse);
      if ((execOneParams.isRetry()) && (executionContext.retryCapacityConsumed())) {
        AmazonHttpClient.access$1400(this$0).release(5);
      } else {
        AmazonHttpClient.access$1400(this$0).release();
      }
      return new Response(response, httpResponse);
    }
    if (AmazonHttpClient.access$1700(apacheResponse))
    {
      Header[] locationHeaders = apacheResponse.getHeaders("location");
      String redirectedLocation = locationHeaders[0].getValue();
      if (AmazonHttpClient.log.isDebugEnabled()) {
        AmazonHttpClient.log.debug("Redirecting to: " + redirectedLocation);
      }
      redirectedURI = URI.create(redirectedLocation);
      awsRequestMetrics.addPropertyWith(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(statusCode))
        .addPropertyWith(AWSRequestMetrics.Field.AWSRequestID, null);
      return null;
    }
    leaveHttpConnectionOpen = errorResponseHandler.needsConnectionLeftOpen();
    SdkBaseException exception = handleErrorResponse(apacheRequest, apacheResponse, localRequestContext);
    
    ClockSkewAdjuster.ClockSkewAdjustment clockSkewAdjustment = AmazonHttpClient.access$1800(this$0).getAdjustment(new ClockSkewAdjuster.AdjustmentRequest().exception(exception)
      .clientRequest(request)
      .serviceResponse(apacheResponse));
    if (clockSkewAdjustment.shouldAdjustForSkew())
    {
      AmazonHttpClient.access$1102(this$0, clockSkewAdjustment.inSeconds());
      request.setTimeOffset(AmazonHttpClient.access$1100(this$0));
      SDKGlobalTime.setGlobalTimeOffset(AmazonHttpClient.access$1100(this$0));
    }
    authRetryParam = null;
    AuthErrorRetryStrategy authRetry = executionContext.getAuthErrorRetryStrategy();
    if ((authRetry != null) && ((exception instanceof AmazonServiceException)))
    {
      HttpResponse httpResponse = ApacheUtils.createResponse(request, apacheRequest, apacheResponse, localRequestContext);
      
      authRetryParam = authRetry.shouldRetryWithAuthParam(request, httpResponse, (AmazonServiceException)exception);
    }
    if ((authRetryParam == null) && (!shouldRetry(execOneParams, exception))) {
      throw exception;
    }
    if (RetryUtils.isThrottlingException(exception)) {
      awsRequestMetrics.incrementCounterWith(AWSRequestMetrics.Field.ThrottleException).addProperty(AWSRequestMetrics.Field.ThrottleException, exception);
    }
    retriedException = exception;
    
    return null;
  }
  
  private void resetRequestInputStream(Request<?> request, SdkBaseException retriedException)
    throws ResetException
  {
    InputStream requestInputStream = request.getContent();
    if ((requestInputStream != null) && 
      (requestInputStream.markSupported())) {
      try
      {
        requestInputStream.reset();
      }
      catch (IOException ex)
      {
        ResetException resetException = new ResetException("The request to the service failed with a retryable reason, but resetting the request input stream has failed. See exception.getExtraInfo or debug-level logging for the original failure that caused this retry.", ex);
        
        resetException.setExtraInfo(retriedException.getMessage());
        throw resetException;
      }
    }
  }
  
  private boolean shouldBufferHttpEntity(boolean needsConnectionLeftOpen, ExecutionContext execContext, RequestExecutor<Output>.ExecOneRequestParams execParams, HttpRequestAbortTaskTracker requestAbortTaskTracker)
  {
    return ((execContext.getClientExecutionTrackerTask().isEnabled()) || 
      (requestAbortTaskTracker.isEnabled())) && (!needsConnectionLeftOpen) && 
      (apacheResponse.getEntity() != null);
  }
  
  private void captureConnectionPoolMetrics()
  {
    if ((awsRequestMetrics.isEnabled()) && 
      ((AmazonHttpClient.access$1600(this$0).getHttpClientConnectionManager() instanceof ConnPoolControl)))
    {
      PoolStats stats = ((ConnPoolControl)AmazonHttpClient.access$1600(this$0).getHttpClientConnectionManager()).getTotalStats();
      
      awsRequestMetrics
        .withCounter(AWSRequestMetrics.Field.HttpClientPoolAvailableCount, stats.getAvailable())
        .withCounter(AWSRequestMetrics.Field.HttpClientPoolLeasedCount, stats.getLeased())
        .withCounter(AWSRequestMetrics.Field.HttpClientPoolPendingCount, stats.getPending());
    }
  }
  
  private <T extends Throwable> T captureExceptionMetrics(T t)
  {
    awsRequestMetrics.incrementCounterWith(AWSRequestMetrics.Field.Exception).addProperty(AWSRequestMetrics.Field.Exception, t);
    if ((t instanceof AmazonServiceException))
    {
      AmazonServiceException ase = (AmazonServiceException)t;
      if (RetryUtils.isThrottlingException(ase)) {
        awsRequestMetrics.incrementCounterWith(AWSRequestMetrics.Field.ThrottleException).addProperty(AWSRequestMetrics.Field.ThrottleException, ase);
      }
    }
    return t;
  }
  
  private void setSdkTransactionId(Request<?> request)
  {
    request.addHeader("amz-sdk-invocation-id", new UUID(
      AmazonHttpClient.access$1900(this$0).nextLong(), AmazonHttpClient.access$1900(this$0).nextLong()).toString());
  }
  
  private void setUserAgent(Request<?> request)
  {
    RequestClientOptions opts = requestConfig.getRequestClientOptions();
    if (opts != null) {
      request.addHeader("User-Agent", 
        RuntimeHttpUtils.getUserAgent(AmazonHttpClient.access$700(this$0), opts.getClientMarker(RequestClientOptions.Marker.USER_AGENT)));
    } else {
      request.addHeader("User-Agent", RuntimeHttpUtils.getUserAgent(AmazonHttpClient.access$700(this$0), null));
    }
  }
  
  private void updateRetryHeaderInfo(Request<?> request, RequestExecutor<Output>.ExecOneRequestParams execOneRequestParams)
  {
    int availableRetryCapacity = AmazonHttpClient.access$1400(this$0).availableCapacity();
    
    String headerValue = String.format("%s/%s/%s", new Object[] {
      Integer.valueOf(requestCount - 1), 
      Long.valueOf(lastBackoffDelay), availableRetryCapacity >= 0 ? 
      
      Integer.valueOf(availableRetryCapacity) : "" });
    
    request.addHeader("amz-sdk-retry", headerValue);
  }
  
  private boolean shouldRetry(RequestExecutor<Output>.ExecOneRequestParams params, SdkBaseException exception)
  {
    int retriesAttempted = requestCount - 1;
    HttpRequestBase method = apacheRequest;
    if ((method instanceof HttpEntityEnclosingRequest))
    {
      HttpEntity entity = ((HttpEntityEnclosingRequest)method).getEntity();
      if ((entity != null) && (!entity.isRepeatable()))
      {
        if (AmazonHttpClient.log.isDebugEnabled()) {
          AmazonHttpClient.log.debug("Entity not repeatable");
        }
        return false;
      }
    }
    RetryPolicyContext context = RetryPolicyContext.builder().request(request).originalRequest(requestConfig.getOriginalRequest()).exception(exception).retriesAttempted(retriesAttempted).httpStatusCode(params.getStatusCode()).build();
    if (!RetryUtils.isThrottlingException(exception))
    {
      if (!AmazonHttpClient.access$1400(this$0).acquire(5))
      {
        awsRequestMetrics.incrementCounter(AWSRequestMetrics.Field.ThrottledRetryCount);
        reportMaxRetriesExceededIfRetryable(context);
        return false;
      }
      executionContext.markRetryCapacityConsumed();
    }
    if (!AmazonHttpClient.access$2100(this$0).shouldRetry(context))
    {
      if (executionContext.retryCapacityConsumed()) {
        AmazonHttpClient.access$1400(this$0).release(5);
      }
      reportMaxRetriesExceededIfRetryable(context);
      return false;
    }
    return true;
  }
  
  private void reportMaxRetriesExceededIfRetryable(RetryPolicyContext context)
  {
    if (((AmazonHttpClient.access$2100(this$0) instanceof RetryPolicyAdapter)) && (((RetryPolicyAdapter)AmazonHttpClient.access$2100(this$0)).isRetryable(context))) {
      awsRequestMetrics.addPropertyWith(AwsClientSideMonitoringMetrics.MaxRetriesExceeded, Boolean.valueOf(true));
    }
  }
  
  private Output handleResponse(HttpResponse httpResponse)
    throws IOException, InterruptedException
  {
    ProgressListener listener = requestConfig.getProgressListener();
    try
    {
      CountingInputStream countingInputStream = null;
      InputStream is = httpResponse.getContent();
      if (is != null)
      {
        if (System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableRuntimeProfiling") != null)
        {
          is = countingInputStream = new CountingInputStream(is);
          httpResponse.setContent(is);
        }
        httpResponse.setContent(ProgressInputStream.inputStreamForResponse(is, listener));
      }
      Map<String, String> headers = httpResponse.getHeaders();
      String s = (String)headers.get("Content-Length");
      if (s != null) {
        try
        {
          long contentLength = Long.parseLong(s);
          SDKProgressPublisher.publishResponseContentLength(listener, contentLength);
        }
        catch (NumberFormatException e)
        {
          AmazonHttpClient.log.warn("Cannot parse the Content-Length header of the response.");
        }
      }
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.HTTP_RESPONSE_STARTED_EVENT);
      try
      {
        awsResponse = responseHandler.handle(beforeUnmarshalling(httpResponse));
      }
      finally
      {
        Output awsResponse;
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
      }
      Output awsResponse;
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.HTTP_RESPONSE_COMPLETED_EVENT);
      if (countingInputStream != null) {
        awsRequestMetrics.setCounter(AWSRequestMetrics.Field.BytesProcessed, countingInputStream.getByteCount());
      }
      return awsResponse;
    }
    catch (CRC32MismatchException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw e;
    }
    catch (AmazonClientException e)
    {
      throw e;
    }
    catch (InterruptedException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      String errorMessage = "Unable to unmarshall response (" + e.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText();
      throw new SdkClientException(errorMessage, e);
    }
  }
  
  private HttpResponse beforeUnmarshalling(HttpResponse origHttpResponse)
  {
    HttpResponse toReturn = origHttpResponse;
    for (RequestHandler2 requestHandler : requestHandler2s) {
      toReturn = requestHandler.beforeUnmarshalling(request, toReturn);
    }
    return toReturn;
  }
  
  private SdkBaseException handleErrorResponse(HttpRequestBase method, com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse apacheHttpResponse, HttpContext context)
    throws IOException, InterruptedException
  {
    StatusLine statusLine = apacheHttpResponse.getStatusLine();
    String reasonPhrase;
    int statusCode;
    String reasonPhrase;
    if (statusLine == null)
    {
      int statusCode = -1;
      reasonPhrase = null;
    }
    else
    {
      statusCode = statusLine.getStatusCode();
      reasonPhrase = statusLine.getReasonPhrase();
    }
    HttpResponse response = ApacheUtils.createResponse(request, method, apacheHttpResponse, context);
    try
    {
      SdkBaseException exception = (SdkBaseException)errorResponseHandler.handle(response);
      if (AmazonHttpClient.requestLog.isDebugEnabled()) {
        AmazonHttpClient.requestLog.debug("Received error response: " + exception);
      }
    }
    catch (InterruptedException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      if ((e instanceof IOException)) {
        throw ((IOException)e);
      }
      String errorMessage = "Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + (statusLine == null ? "None" : Integer.valueOf(statusCode)) + ", Response Text: " + reasonPhrase;
      
      throw new SdkClientException(errorMessage, e);
    }
    SdkBaseException exception;
    exception.fillInStackTrace();
    return exception;
  }
  
  /* Error */
  private void pauseBeforeRetry(RequestExecutor<Output>.ExecOneRequestParams execOneParams, ProgressListener listener)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 1485	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/event/ProgressEventType:CLIENT_REQUEST_RETRY_EVENT	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/event/ProgressEventType;
    //   4: invokestatic 273	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/event/SDKProgressPublisher:publishProgress	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/event/ProgressListener;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/event/ProgressEventType;)Ljava/util/concurrent/Future;
    //   7: pop
    //   8: aload_0
    //   9: getfield 100	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:awsRequestMetrics	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics;
    //   12: getstatic 1488	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field:RetryPauseTime	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field;
    //   15: invokevirtual 650	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/metrics/MetricType;)V
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 1492	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:doPauseBeforeRetry	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor$ExecOneRequestParams;)V
    //   23: aload_0
    //   24: getfield 100	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:awsRequestMetrics	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics;
    //   27: getstatic 1488	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field:RetryPauseTime	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field;
    //   30: invokevirtual 289	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/metrics/MetricType;)V
    //   33: goto +16 -> 49
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 100	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/http/AmazonHttpClient$RequestExecutor:awsRequestMetrics	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics;
    //   41: getstatic 1488	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field:RetryPauseTime	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics$Field;
    //   44: invokevirtual 289	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/metrics/MetricType;)V
    //   47: aload_3
    //   48: athrow
    //   49: return
    // Line number table:
    //   Java source line #1721	-> byte code offset #0
    //   Java source line #1723	-> byte code offset #8
    //   Java source line #1725	-> byte code offset #18
    //   Java source line #1727	-> byte code offset #23
    //   Java source line #1728	-> byte code offset #33
    //   Java source line #1727	-> byte code offset #36
    //   Java source line #1728	-> byte code offset #47
    //   Java source line #1729	-> byte code offset #49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	RequestExecutor<Output>
    //   0	50	1	execOneParams	RequestExecutor<Output>.ExecOneRequestParams
    //   0	50	2	listener	ProgressListener
    //   36	12	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	36	finally
  }
  
  private void doPauseBeforeRetry(RequestExecutor<Output>.ExecOneRequestParams execOneParams)
    throws InterruptedException
  {
    int retriesAttempted = requestCount - 2;
    
    RetryPolicyContext context = RetryPolicyContext.builder().request(request).originalRequest(requestConfig.getOriginalRequest()).retriesAttempted(retriesAttempted).exception(retriedException).build();
    if (context.exception() != null)
    {
      long delay = AmazonHttpClient.access$2100(this$0).computeDelayBeforeNextRetry(context);
      lastBackoffDelay = delay;
      if (AmazonHttpClient.log.isDebugEnabled()) {
        AmazonHttpClient.log.debug("Retriable error detected, will retry in " + delay + "ms, attempt number: " + retriesAttempted);
      }
      Thread.sleep(delay);
    }
  }
  
  private int getRequestTimeout(RequestConfig requestConfig)
  {
    if (requestConfig.getRequestTimeout() != null) {
      return requestConfig.getRequestTimeout().intValue();
    }
    return AmazonHttpClient.access$700(this$0).getRequestTimeout();
  }
  
  private int getClientExecutionTimeout(RequestConfig requestConfig)
  {
    if (requestConfig.getClientExecutionTimeout() != null) {
      return requestConfig.getClientExecutionTimeout().intValue();
    }
    return AmazonHttpClient.access$700(this$0).getClientExecutionTimeout();
  }
  
  private class ExecOneRequestParams
  {
    int requestCount;
    long lastBackoffDelay = 0L;
    SdkBaseException retriedException;
    HttpRequestBase apacheRequest;
    com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse apacheResponse;
    URI redirectedURI;
    AuthRetryParameters authRetryParam;
    boolean leaveHttpConnectionOpen;
    private Signer signer;
    private URI signerURI;
    
    private ExecOneRequestParams() {}
    
    boolean isRetry()
    {
      return (requestCount > 1) || (redirectedURI != null) || (authRetryParam != null);
    }
    
    void initPerRetry()
    {
      requestCount += 1;
      apacheRequest = null;
      apacheResponse = null;
      leaveHttpConnectionOpen = false;
    }
    
    void newSigner(Request<?> request, ExecutionContext execContext)
    {
      SignerProviderContext.Builder signerProviderContext = SignerProviderContext.builder().withRequest(request).withRequestConfig(requestConfig);
      if (authRetryParam != null)
      {
        signerURI = authRetryParam.getEndpointForRetry();
        signer = authRetryParam.getSignerForRetry();
        
        execContext.setSigner(signer);
      }
      else if ((redirectedURI != null) && (!redirectedURI.equals(signerURI)))
      {
        signerURI = redirectedURI;
        signer = execContext.getSigner(signerProviderContext
          .withUri(signerURI)
          .withIsRedirect(true)
          .build());
        if ((signer instanceof AWS4Signer))
        {
          String regionName = ((AWS4Signer)signer).getRegionName();
          if (regionName != null) {
            request.addHandlerContext(HandlerContextKey.SIGNING_REGION, regionName);
          }
        }
      }
      else if (signer == null)
      {
        signerURI = request.getEndpoint();
        
        signer = execContext.getSigner(signerProviderContext.withUri(signerURI).build());
      }
    }
    
    HttpRequestBase newApacheRequest(HttpRequestFactory<HttpRequestBase> httpRequestFactory, Request<?> request, HttpClientSettings options)
      throws IOException
    {
      apacheRequest = ((HttpRequestBase)httpRequestFactory.create(request, options));
      if (redirectedURI != null) {
        apacheRequest.setURI(redirectedURI);
      }
      return apacheRequest;
    }
    
    void resetBeforeHttpRequest()
    {
      retriedException = null;
      authRetryParam = null;
      redirectedURI = null;
    }
    
    private Integer getStatusCode()
    {
      if ((apacheResponse == null) || (apacheResponse.getStatusLine() == null)) {
        return null;
      }
      return Integer.valueOf(apacheResponse.getStatusLine().getStatusCode());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.RequestExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */