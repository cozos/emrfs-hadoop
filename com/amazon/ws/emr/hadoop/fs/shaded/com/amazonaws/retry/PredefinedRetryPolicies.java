package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.IOException;

public class PredefinedRetryPolicies
{
  public static final RetryPolicy NO_RETRY_POLICY = new RetryPolicy(RetryPolicy.RetryCondition.NO_RETRY_CONDITION, RetryPolicy.BackoffStrategy.NO_DELAY, 0, false);
  public static final RetryPolicy.RetryCondition DEFAULT_RETRY_CONDITION = new SDKDefaultRetryCondition();
  public static final RetryPolicy.BackoffStrategy DEFAULT_BACKOFF_STRATEGY = new PredefinedBackoffStrategies.SDKDefaultBackoffStrategy();
  public static final V2CompatibleBackoffStrategy DEFAULT_BACKOFF_STRATEGY_V2 = new PredefinedBackoffStrategies.SDKDefaultBackoffStrategy();
  public static final RetryPolicy.BackoffStrategy DYNAMODB_DEFAULT_BACKOFF_STRATEGY = new PredefinedBackoffStrategies.SDKDefaultBackoffStrategy(25, 500, 20000);
  public static final RetryPolicy DEFAULT = getDefaultRetryPolicy();
  public static final RetryPolicy DYNAMODB_DEFAULT = getDynamoDBDefaultRetryPolicy();
  public static final int DEFAULT_MAX_ERROR_RETRY = 3;
  public static final int DYNAMODB_DEFAULT_MAX_ERROR_RETRY = 10;
  
  public static RetryPolicy getDefaultRetryPolicy()
  {
    return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, 3, true);
  }
  
  public static RetryPolicy getDynamoDBDefaultRetryPolicy()
  {
    return new RetryPolicy(DEFAULT_RETRY_CONDITION, DYNAMODB_DEFAULT_BACKOFF_STRATEGY, 10, true);
  }
  
  public static RetryPolicy getDefaultRetryPolicyWithCustomMaxRetries(int maxErrorRetry)
  {
    return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, maxErrorRetry, false);
  }
  
  public static RetryPolicy getDynamoDBDefaultRetryPolicyWithCustomMaxRetries(int maxErrorRetry)
  {
    return new RetryPolicy(DEFAULT_RETRY_CONDITION, DYNAMODB_DEFAULT_BACKOFF_STRATEGY, maxErrorRetry, false);
  }
  
  public static class SDKDefaultRetryCondition
    implements RetryPolicy.RetryCondition
  {
    public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
    {
      if ((exception.getCause() instanceof IOException)) {
        return true;
      }
      if ((exception instanceof AmazonServiceException))
      {
        AmazonServiceException ase = (AmazonServiceException)exception;
        if (RetryUtils.isRetryableServiceException(ase)) {
          return true;
        }
        if (RetryUtils.isThrottlingException(ase)) {
          return true;
        }
        if (RetryUtils.isClockSkewError(ase)) {
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */