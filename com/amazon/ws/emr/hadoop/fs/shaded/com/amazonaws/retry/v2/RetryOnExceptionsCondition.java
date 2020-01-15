package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RetryOnExceptionsCondition
  implements RetryCondition
{
  private final List<Class<? extends Exception>> exceptionsToRetryOn;
  
  public RetryOnExceptionsCondition(List<Class<? extends Exception>> exceptionsToRetryOn)
  {
    this.exceptionsToRetryOn = new ArrayList((Collection)ValidationUtils.assertNotNull(exceptionsToRetryOn, "exceptionsToRetryOn"));
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    if (context.exception() != null) {
      for (Class<? extends Exception> exceptionClass : exceptionsToRetryOn)
      {
        if (exceptionMatches(context, exceptionClass)) {
          return true;
        }
        if (wrappedCauseMatches(context, exceptionClass)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean exceptionMatches(RetryPolicyContext context, Class<? extends Exception> exceptionClass)
  {
    return context.exception().getClass().equals(exceptionClass);
  }
  
  private boolean wrappedCauseMatches(RetryPolicyContext context, Class<? extends Exception> exceptionClass)
  {
    if (context.exception().getCause() == null) {
      return false;
    }
    return context.exception().getCause().getClass().equals(exceptionClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryOnExceptionsCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */