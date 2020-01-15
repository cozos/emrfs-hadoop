package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface CredentialsEndpointRetryPolicy
{
  public static final CredentialsEndpointRetryPolicy NO_RETRY = new CredentialsEndpointRetryPolicy()
  {
    public boolean shouldRetry(int retriesAttempted, CredentialsEndpointRetryParameters retryParams)
    {
      return false;
    }
  };
  
  public abstract boolean shouldRetry(int paramInt, CredentialsEndpointRetryParameters paramCredentialsEndpointRetryParameters);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */