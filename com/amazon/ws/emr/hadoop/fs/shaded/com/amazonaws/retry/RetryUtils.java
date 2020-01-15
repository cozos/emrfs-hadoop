package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import java.util.HashSet;
import java.util.Set;

public class RetryUtils
{
  static final Set<String> THROTTLING_ERROR_CODES = new HashSet(9);
  static final Set<String> CLOCK_SKEW_ERROR_CODES = new HashSet(6);
  static final Set<String> RETRYABLE_ERROR_CODES = new HashSet(1);
  static final Set<Integer> RETRYABLE_STATUS_CODES = new HashSet(4);
  
  static
  {
    THROTTLING_ERROR_CODES.add("Throttling");
    THROTTLING_ERROR_CODES.add("ThrottlingException");
    THROTTLING_ERROR_CODES.add("ThrottledException");
    THROTTLING_ERROR_CODES.add("ProvisionedThroughputExceededException");
    THROTTLING_ERROR_CODES.add("SlowDown");
    THROTTLING_ERROR_CODES.add("TooManyRequestsException");
    THROTTLING_ERROR_CODES.add("RequestLimitExceeded");
    THROTTLING_ERROR_CODES.add("BandwidthLimitExceeded");
    THROTTLING_ERROR_CODES.add("RequestThrottled");
    THROTTLING_ERROR_CODES.add("RequestThrottledException");
    
    CLOCK_SKEW_ERROR_CODES.add("RequestTimeTooSkewed");
    CLOCK_SKEW_ERROR_CODES.add("RequestExpired");
    CLOCK_SKEW_ERROR_CODES.add("InvalidSignatureException");
    CLOCK_SKEW_ERROR_CODES.add("SignatureDoesNotMatch");
    CLOCK_SKEW_ERROR_CODES.add("AuthFailure");
    CLOCK_SKEW_ERROR_CODES.add("RequestInTheFuture");
    
    RETRYABLE_ERROR_CODES.add("PriorRequestNotComplete");
    RETRYABLE_ERROR_CODES.add("TransactionInProgressException");
    
    RETRYABLE_STATUS_CODES.add(Integer.valueOf(500));
    RETRYABLE_STATUS_CODES.add(Integer.valueOf(502));
    RETRYABLE_STATUS_CODES.add(Integer.valueOf(503));
    RETRYABLE_STATUS_CODES.add(Integer.valueOf(504));
  }
  
  public static boolean isRetryableServiceException(SdkBaseException exception)
  {
    return (isAse(exception)) && (isRetryableServiceException(toAse(exception)));
  }
  
  public static boolean isRetryableServiceException(AmazonServiceException exception)
  {
    return (RETRYABLE_STATUS_CODES.contains(Integer.valueOf(exception.getStatusCode()))) || 
      (RETRYABLE_ERROR_CODES.contains(exception.getErrorCode()));
  }
  
  public static boolean isThrottlingException(SdkBaseException exception)
  {
    return (isAse(exception)) && (isThrottlingException(toAse(exception)));
  }
  
  public static boolean isThrottlingException(AmazonServiceException exception)
  {
    return (THROTTLING_ERROR_CODES.contains(exception.getErrorCode())) || 
      (exception.getStatusCode() == 429);
  }
  
  public static boolean isRequestEntityTooLargeException(SdkBaseException exception)
  {
    return (isAse(exception)) && (isRequestEntityTooLargeException(toAse(exception)));
  }
  
  public static boolean isRequestEntityTooLargeException(AmazonServiceException exception)
  {
    return exception.getStatusCode() == 413;
  }
  
  public static boolean isClockSkewError(SdkBaseException exception)
  {
    return (isAse(exception)) && (isClockSkewError(toAse(exception)));
  }
  
  public static boolean isClockSkewError(AmazonServiceException exception)
  {
    return CLOCK_SKEW_ERROR_CODES.contains(exception.getErrorCode());
  }
  
  private static boolean isAse(SdkBaseException e)
  {
    return e instanceof AmazonServiceException;
  }
  
  private static AmazonServiceException toAse(SdkBaseException e)
  {
    return (AmazonServiceException)e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */