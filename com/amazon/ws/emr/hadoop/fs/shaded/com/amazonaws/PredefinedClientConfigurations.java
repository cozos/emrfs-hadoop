package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies;

public class PredefinedClientConfigurations
{
  public static ClientConfiguration defaultConfig()
  {
    return new ClientConfiguration();
  }
  
  public static ClientConfiguration dynamoDefault()
  {
    return new ClientConfiguration().withRetryPolicy(PredefinedRetryPolicies.DYNAMODB_DEFAULT);
  }
  
  public static ClientConfiguration swfDefault()
  {
    return new ClientConfiguration().withMaxConnections(1000).withSocketTimeout(90000);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.PredefinedClientConfigurations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */