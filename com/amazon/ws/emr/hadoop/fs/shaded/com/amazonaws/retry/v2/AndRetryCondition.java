package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndRetryCondition
  implements RetryCondition
{
  private List<RetryCondition> conditions = new ArrayList();
  
  public AndRetryCondition(RetryCondition... conditions)
  {
    Collections.addAll(this.conditions, ValidationUtils.assertNotEmpty(conditions, "conditions"));
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    for (RetryCondition retryCondition : conditions) {
      if (!retryCondition.shouldRetry(context)) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.AndRetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */