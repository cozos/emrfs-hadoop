package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public class RetryPolicyContext$Builder
{
  private Object originalRequest;
  private Request<?> request;
  private SdkBaseException exception;
  private int retriesAttempted;
  private Integer httpStatusCode;
  
  public Builder originalRequest(Object originalRequest)
  {
    this.originalRequest = originalRequest;
    return this;
  }
  
  public Builder request(Request<?> request)
  {
    this.request = request;
    return this;
  }
  
  public Builder exception(SdkBaseException exception)
  {
    this.exception = exception;
    return this;
  }
  
  public Builder retriesAttempted(int retriesAttempted)
  {
    this.retriesAttempted = retriesAttempted;
    return this;
  }
  
  public Builder httpStatusCode(Integer httpStatusCode)
  {
    this.httpStatusCode = httpStatusCode;
    return this;
  }
  
  public RetryPolicyContext build()
  {
    return new RetryPolicyContext(originalRequest, request, exception, retriesAttempted, httpStatusCode, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */