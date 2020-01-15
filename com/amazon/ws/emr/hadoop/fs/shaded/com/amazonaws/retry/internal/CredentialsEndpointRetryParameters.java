package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public class CredentialsEndpointRetryParameters
{
  private final Integer statusCode;
  private final Exception exception;
  
  private CredentialsEndpointRetryParameters(Builder builder)
  {
    statusCode = statusCode;
    exception = exception;
  }
  
  public Integer getStatusCode()
  {
    return statusCode;
  }
  
  public Exception getException()
  {
    return exception;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static class Builder
  {
    private final Integer statusCode;
    private final Exception exception;
    
    private Builder()
    {
      statusCode = null;
      exception = null;
    }
    
    private Builder(Integer statusCode, Exception exception)
    {
      this.statusCode = statusCode;
      this.exception = exception;
    }
    
    public Builder withStatusCode(Integer statusCode)
    {
      return new Builder(statusCode, exception);
    }
    
    public Builder withException(Exception exception)
    {
      return new Builder(statusCode, exception);
    }
    
    public CredentialsEndpointRetryParameters build()
    {
      return new CredentialsEndpointRetryParameters(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */