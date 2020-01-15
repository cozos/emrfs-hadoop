package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal;

public class CredentialsEndpointRetryParameters$Builder
{
  private final Integer statusCode;
  private final Exception exception;
  
  private CredentialsEndpointRetryParameters$Builder()
  {
    statusCode = null;
    exception = null;
  }
  
  private CredentialsEndpointRetryParameters$Builder(Integer statusCode, Exception exception)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryParameters.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */