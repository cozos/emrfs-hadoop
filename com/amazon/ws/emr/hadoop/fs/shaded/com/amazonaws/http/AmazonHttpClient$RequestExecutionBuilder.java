package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;

public abstract interface AmazonHttpClient$RequestExecutionBuilder
{
  public abstract RequestExecutionBuilder request(Request<?> paramRequest);
  
  public abstract RequestExecutionBuilder errorResponseHandler(HttpResponseHandler<? extends SdkBaseException> paramHttpResponseHandler);
  
  public abstract RequestExecutionBuilder executionContext(ExecutionContext paramExecutionContext);
  
  public abstract RequestExecutionBuilder requestConfig(RequestConfig paramRequestConfig);
  
  public abstract <Output> Response<Output> execute(HttpResponseHandler<Output> paramHttpResponseHandler);
  
  public abstract Response<Void> execute();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.RequestExecutionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */