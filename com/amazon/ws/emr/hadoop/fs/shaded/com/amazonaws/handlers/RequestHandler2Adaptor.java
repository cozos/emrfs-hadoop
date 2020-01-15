package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;

final class RequestHandler2Adaptor
  extends RequestHandler2
{
  private final RequestHandler old;
  
  RequestHandler2Adaptor(RequestHandler old)
  {
    if (old == null) {
      throw new IllegalArgumentException();
    }
    this.old = old;
  }
  
  public void beforeRequest(Request<?> request)
  {
    old.beforeRequest(request);
  }
  
  public void afterResponse(Request<?> request, Response<?> response)
  {
    AWSRequestMetrics awsRequestMetrics = request == null ? null : request.getAWSRequestMetrics();
    
    Object awsResponse = response == null ? null : response.getAwsResponse();
    
    TimingInfo timingInfo = awsRequestMetrics == null ? null : awsRequestMetrics.getTimingInfo();
    old.afterResponse(request, awsResponse, timingInfo);
  }
  
  public void afterError(Request<?> request, Response<?> response, Exception e)
  {
    old.afterError(request, e);
  }
  
  public int hashCode()
  {
    return old.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof RequestHandler2Adaptor)) {
      return false;
    }
    RequestHandler2Adaptor that = (RequestHandler2Adaptor)o;
    return old.equals(old);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2Adaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */