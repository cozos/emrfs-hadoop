package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.resources;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource;

public class SQSQueueResource
  extends Resource
{
  public SQSQueueResource(String accountId, String queueName)
  {
    super("/" + formatAccountId(accountId) + "/" + queueName);
  }
  
  private static String formatAccountId(String accountId)
  {
    if (accountId == null) {
      throw new IllegalArgumentException("Account ID cannot be null");
    }
    return accountId.trim().replaceAll("-", "");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.resources.SQSQueueResource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */