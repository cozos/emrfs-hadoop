package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies;

@SdkInternalApi
class AmazonDynamoDBClientConfigurationFactory
  extends ClientConfigurationFactory
{
  protected ClientConfiguration getDefaultConfig()
  {
    return super.getDefaultConfig().withRetryPolicy(PredefinedRetryPolicies.DYNAMODB_DEFAULT);
  }
  
  protected ClientConfiguration getInRegionOptimizedConfig()
  {
    return 
      super.getInRegionOptimizedConfig().withSocketTimeout(6000).withRetryPolicy(PredefinedRetryPolicies.DYNAMODB_DEFAULT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientConfigurationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */