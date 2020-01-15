package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryPolicy;
import java.io.IOException;

@SdkInternalApi
class ContainerCredentialsRetryPolicy
  implements CredentialsEndpointRetryPolicy
{
  private static final int MAX_RETRIES = 5;
  private static ContainerCredentialsRetryPolicy instance;
  
  public static ContainerCredentialsRetryPolicy getInstance()
  {
    if (instance == null) {
      instance = new ContainerCredentialsRetryPolicy();
    }
    return instance;
  }
  
  public boolean shouldRetry(int retriesAttempted, CredentialsEndpointRetryParameters retryParams)
  {
    if (retriesAttempted >= 5) {
      return false;
    }
    Integer statusCode = retryParams.getStatusCode();
    if ((statusCode != null) && (statusCode.intValue() >= 500) && (statusCode.intValue() < 600)) {
      return true;
    }
    if ((retryParams.getException() != null) && ((retryParams.getException() instanceof IOException))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ContainerCredentialsRetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */