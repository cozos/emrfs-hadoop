package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.response;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.SdkHttpMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.MetadataCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.Map;

public class AwsResponseHandlerAdapter<T>
  implements HttpResponseHandler<T>
{
  private static final Log requestIdLog = LogFactory.getLog("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.requestId");
  private static final Log requestLog = AmazonHttpClient.requestLog;
  private final HttpResponseHandler<AmazonWebServiceResponse<T>> delegate;
  private final Request<?> request;
  private final AWSRequestMetrics awsRequestMetrics;
  private final MetadataCache responseMetadataCache;
  
  public AwsResponseHandlerAdapter(HttpResponseHandler<AmazonWebServiceResponse<T>> delegate, Request<?> request, AWSRequestMetrics awsRequestMetrics, MetadataCache responseMetadataCache)
  {
    this.delegate = delegate;
    this.request = request;
    this.awsRequestMetrics = awsRequestMetrics;
    this.responseMetadataCache = responseMetadataCache;
  }
  
  public T handle(HttpResponse response)
    throws Exception
  {
    AmazonWebServiceResponse<T> awsResponse = (AmazonWebServiceResponse)delegate.handle(response);
    if (awsResponse == null) {
      throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + response.getStatusCode() + ", Response Text: " + response.getStatusText());
    }
    AmazonWebServiceRequest userRequest = request.getOriginalRequest();
    if (userRequest.getCloneRoot() != null) {
      userRequest = userRequest.getCloneRoot();
    }
    responseMetadataCache.add(userRequest, awsResponse.getResponseMetadata());
    String awsRequestId = awsResponse.getRequestId();
    if (requestLog.isDebugEnabled()) {
      requestLog.debug("Received successful response: " + response.getStatusCode() + ", AWS Request ID: " + awsRequestId);
    }
    if (!logHeaderRequestId(response)) {
      logResponseRequestId(awsRequestId);
    }
    logExtendedRequestId(response);
    
    awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, awsRequestId);
    return (T)fillInResponseMetadata(awsResponse, response);
  }
  
  private <T> T fillInResponseMetadata(AmazonWebServiceResponse<T> awsResponse, HttpResponse httpResponse)
  {
    T result = awsResponse.getResult();
    if ((result instanceof AmazonWebServiceResult)) {
      ((AmazonWebServiceResult)result).setSdkResponseMetadata(awsResponse.getResponseMetadata()).setSdkHttpMetadata(SdkHttpMetadata.from(httpResponse));
    }
    return result;
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return delegate.needsConnectionLeftOpen();
  }
  
  private boolean logHeaderRequestId(HttpResponse response)
  {
    String reqIdHeader = (String)response.getHeaders().get("x-amzn-RequestId");
    boolean isHeaderReqIdAvail = reqIdHeader != null;
    if ((requestIdLog.isDebugEnabled()) || (requestLog.isDebugEnabled()))
    {
      String msg = "x-amzn-RequestId: " + (isHeaderReqIdAvail ? reqIdHeader : "not available");
      if (requestIdLog.isDebugEnabled()) {
        requestIdLog.debug(msg);
      } else {
        requestLog.debug(msg);
      }
    }
    return isHeaderReqIdAvail;
  }
  
  private void logResponseRequestId(String awsRequestId)
  {
    if ((requestIdLog.isDebugEnabled()) || (requestLog.isDebugEnabled()))
    {
      String msg = "AWS Request ID: " + (awsRequestId == null ? "not available" : awsRequestId);
      if (requestIdLog.isDebugEnabled()) {
        requestIdLog.debug(msg);
      } else {
        requestLog.debug(msg);
      }
    }
  }
  
  private void logExtendedRequestId(HttpResponse response)
  {
    String reqId = (String)response.getHeaders().get("x-amz-id-2");
    if ((reqId != null) && ((requestIdLog.isDebugEnabled()) || (requestLog.isDebugEnabled())))
    {
      String msg = "AWS Extended Request ID: " + reqId;
      if (requestIdLog.isDebugEnabled()) {
        requestIdLog.debug(msg);
      } else {
        requestLog.debug(msg);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.response.AwsResponseHandlerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */