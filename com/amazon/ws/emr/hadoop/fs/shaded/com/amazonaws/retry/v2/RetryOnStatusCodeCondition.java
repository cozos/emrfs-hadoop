package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RetryOnStatusCodeCondition
  implements RetryCondition
{
  private final List<Integer> statusCodesToRetryOn;
  
  public RetryOnStatusCodeCondition(List<Integer> statusCodesToRetryOn)
  {
    this.statusCodesToRetryOn = new ArrayList((Collection)ValidationUtils.assertNotNull(statusCodesToRetryOn, "statusCodesToRetryOn"));
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    if (context.httpStatusCode() != null) {
      for (Integer statusCode : statusCodesToRetryOn) {
        if (statusCode.equals(context.httpStatusCode())) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryOnStatusCodeCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */