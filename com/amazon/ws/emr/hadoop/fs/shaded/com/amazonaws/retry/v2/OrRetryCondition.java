package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrRetryCondition
  implements RetryCondition
{
  private List<RetryCondition> conditions = new ArrayList();
  
  public OrRetryCondition(RetryCondition... conditions)
  {
    Collections.addAll(this.conditions, conditions);
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    for (RetryCondition retryCondition : conditions) {
      if (retryCondition.shouldRetry(context)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.OrRetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */