package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ThreadSafe
public class StackedRequestHandler
  implements IRequestHandler2
{
  private final List<RequestHandler2> inOrderRequestHandlers;
  private final List<RequestHandler2> reverseOrderRequestHandlers;
  
  public StackedRequestHandler(RequestHandler2... requestHandlers)
  {
    this(Arrays.asList((Object[])ValidationUtils.assertNotNull(requestHandlers, "requestHandlers")));
  }
  
  public StackedRequestHandler(List<RequestHandler2> requestHandlers)
  {
    inOrderRequestHandlers = ((List)ValidationUtils.assertNotNull(requestHandlers, "requestHandlers"));
    reverseOrderRequestHandlers = new ArrayList(requestHandlers);
    Collections.reverse(reverseOrderRequestHandlers);
  }
  
  public AmazonWebServiceRequest beforeExecution(AmazonWebServiceRequest origRequest)
  {
    AmazonWebServiceRequest toReturn = origRequest;
    for (RequestHandler2 handler : inOrderRequestHandlers) {
      toReturn = handler.beforeExecution(toReturn);
    }
    return toReturn;
  }
  
  public AmazonWebServiceRequest beforeMarshalling(AmazonWebServiceRequest origRequest)
  {
    AmazonWebServiceRequest toReturn = origRequest;
    for (RequestHandler2 handler : inOrderRequestHandlers) {
      toReturn = handler.beforeMarshalling(toReturn);
    }
    return toReturn;
  }
  
  public void beforeRequest(Request<?> request)
  {
    for (RequestHandler2 handler : inOrderRequestHandlers) {
      handler.beforeRequest(request);
    }
  }
  
  public void beforeAttempt(HandlerBeforeAttemptContext context)
  {
    for (RequestHandler2 handler : inOrderRequestHandlers) {
      handler.beforeAttempt(context);
    }
  }
  
  public HttpResponse beforeUnmarshalling(Request<?> request, HttpResponse origHttpResponse)
  {
    HttpResponse toReturn = origHttpResponse;
    for (RequestHandler2 handler : reverseOrderRequestHandlers) {
      toReturn = handler.beforeUnmarshalling(request, toReturn);
    }
    return toReturn;
  }
  
  public void afterAttempt(HandlerAfterAttemptContext context)
  {
    for (RequestHandler2 handler : reverseOrderRequestHandlers) {
      handler.afterAttempt(context);
    }
  }
  
  public void afterResponse(Request<?> request, Response<?> response)
  {
    for (RequestHandler2 handler : reverseOrderRequestHandlers) {
      handler.afterResponse(request, response);
    }
  }
  
  public void afterError(Request<?> request, Response<?> response, Exception e)
  {
    for (RequestHandler2 handler : reverseOrderRequestHandlers) {
      handler.afterError(request, response, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.StackedRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */