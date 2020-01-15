package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class DynamoDBMapperConfig$NoRetryBatchLoadRetryStrategy
  implements DynamoDBMapperConfig.BatchLoadRetryStrategy
{
  public static final NoRetryBatchLoadRetryStrategy INSTANCE = new NoRetryBatchLoadRetryStrategy();
  
  public boolean shouldRetry(BatchLoadContext batchLoadContext)
  {
    return false;
  }
  
  public long getDelayBeforeNextRetry(BatchLoadContext batchLoadContext)
  {
    return -1L;
  }
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withBatchLoadRetryStrategy(this).build();
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.NoRetryBatchLoadRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */