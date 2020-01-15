package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@Immutable
public class RetryPolicyContext
{
  private final Object originalRequest;
  private final Request<?> request;
  private final SdkBaseException exception;
  private final int retriesAttempted;
  private final Integer httpStatusCode;
  
  private RetryPolicyContext(Object originalRequest, Request<?> request, SdkBaseException exception, int retriesAttempted, Integer httpStatusCode)
  {
    this.originalRequest = originalRequest;
    this.request = request;
    this.exception = exception;
    this.retriesAttempted = retriesAttempted;
    this.httpStatusCode = httpStatusCode;
  }
  
  public Object originalRequest()
  {
    return originalRequest;
  }
  
  public Request<?> request()
  {
    return request;
  }
  
  public SdkBaseException exception()
  {
    return exception;
  }
  
  public int retriesAttempted()
  {
    return retriesAttempted;
  }
  
  public int totalRequests()
  {
    return retriesAttempted() + 1;
  }
  
  public Integer httpStatusCode()
  {
    return httpStatusCode;
  }
  
  @SdkInternalApi
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  @SdkInternalApi
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */