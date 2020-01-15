package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

@SdkInternalApi
public class RetryPolicyAdapter
  implements com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicy
{
  private final RetryPolicy legacyRetryPolicy;
  private final ClientConfiguration clientConfiguration;
  
  public RetryPolicyAdapter(RetryPolicy legacyRetryPolicy, ClientConfiguration clientConfiguration)
  {
    this.legacyRetryPolicy = ((RetryPolicy)ValidationUtils.assertNotNull(legacyRetryPolicy, "legacyRetryPolicy"));
    this.clientConfiguration = ((ClientConfiguration)ValidationUtils.assertNotNull(clientConfiguration, "clientConfiguration"));
  }
  
  public long computeDelayBeforeNextRetry(RetryPolicyContext context)
  {
    return legacyRetryPolicy.getBackoffStrategy().delayBeforeNextRetry(
      (AmazonWebServiceRequest)context.originalRequest(), 
      (AmazonClientException)context.exception(), context
      .retriesAttempted());
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    return (!maxRetriesExceeded(context)) && (isRetryable(context));
  }
  
  public boolean isRetryable(RetryPolicyContext context)
  {
    return legacyRetryPolicy.getRetryCondition().shouldRetry(
      (AmazonWebServiceRequest)context.originalRequest(), 
      (AmazonClientException)context.exception(), context
      .retriesAttempted());
  }
  
  public RetryPolicy getLegacyRetryPolicy()
  {
    return legacyRetryPolicy;
  }
  
  private int getMaxErrorRetry()
  {
    if ((legacyRetryPolicy.isMaxErrorRetryInClientConfigHonored()) && (clientConfiguration.getMaxErrorRetry() >= 0)) {
      return clientConfiguration.getMaxErrorRetry();
    }
    return legacyRetryPolicy.getMaxErrorRetry();
  }
  
  public boolean maxRetriesExceeded(RetryPolicyContext context)
  {
    return context.retriesAttempted() >= getMaxErrorRetry();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicyAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */