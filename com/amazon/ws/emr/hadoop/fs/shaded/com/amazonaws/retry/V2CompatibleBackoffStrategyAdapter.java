package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext.Builder;

@SdkInternalApi
abstract class V2CompatibleBackoffStrategyAdapter
  implements V2CompatibleBackoffStrategy
{
  public long delayBeforeNextRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
  {
    return computeDelayBeforeNextRetry(RetryPolicyContext.builder()
      .originalRequest(originalRequest)
      .exception(exception)
      .retriesAttempted(retriesAttempted)
      .build());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.V2CompatibleBackoffStrategyAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */