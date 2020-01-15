package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public abstract interface DynamoDBMapperConfig$BatchLoadRetryStrategy
{
  public abstract boolean shouldRetry(BatchLoadContext paramBatchLoadContext);
  
  public abstract long getDelayBeforeNextRetry(BatchLoadContext paramBatchLoadContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.BatchLoadRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */