package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;

@SdkInternalApi
public abstract interface IRequestHandler2
{
  public abstract AmazonWebServiceRequest beforeExecution(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  public abstract AmazonWebServiceRequest beforeMarshalling(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  public abstract void beforeRequest(Request<?> paramRequest);
  
  public abstract void beforeAttempt(HandlerBeforeAttemptContext paramHandlerBeforeAttemptContext);
  
  public abstract HttpResponse beforeUnmarshalling(Request<?> paramRequest, HttpResponse paramHttpResponse);
  
  public abstract void afterAttempt(HandlerAfterAttemptContext paramHandlerAfterAttemptContext);
  
  public abstract void afterResponse(Request<?> paramRequest, Response<?> paramResponse);
  
  public abstract void afterError(Request<?> paramRequest, Response<?> paramResponse, Exception paramException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.IRequestHandler2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */