package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;

public abstract class RequestHandler2
  implements IRequestHandler2
{
  public AmazonWebServiceRequest beforeExecution(AmazonWebServiceRequest request)
  {
    return request;
  }
  
  public AmazonWebServiceRequest beforeMarshalling(AmazonWebServiceRequest request)
  {
    return request;
  }
  
  public void beforeRequest(Request<?> request) {}
  
  public void beforeAttempt(HandlerBeforeAttemptContext context) {}
  
  public HttpResponse beforeUnmarshalling(Request<?> request, HttpResponse httpResponse)
  {
    return httpResponse;
  }
  
  public void afterAttempt(HandlerAfterAttemptContext context) {}
  
  public void afterResponse(Request<?> request, Response<?> response) {}
  
  public void afterError(Request<?> request, Response<?> response, Exception e) {}
  
  public static RequestHandler2 adapt(RequestHandler old)
  {
    return new RequestHandler2Adaptor(old);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */