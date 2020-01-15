package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import java.util.Map;
import java.util.Random;

public class DynamoDBMapperConfig$DefaultBatchLoadRetryStrategy
  implements DynamoDBMapperConfig.BatchLoadRetryStrategy
{
  public static final DefaultBatchLoadRetryStrategy INSTANCE = new DefaultBatchLoadRetryStrategy();
  private static final int MAX_RETRIES = 5;
  private static final long MAX_BACKOFF_IN_MILLISECONDS = 3000L;
  
  public long getDelayBeforeNextRetry(BatchLoadContext batchLoadContext)
  {
    Map<String, KeysAndAttributes> requestedKeys = batchLoadContext.getBatchGetItemRequest().getRequestItems();
    
    Map<String, KeysAndAttributes> unprocessedKeys = batchLoadContext.getBatchGetItemResult().getUnprocessedKeys();
    
    long delay = 0L;
    if ((unprocessedKeys != null) && (requestedKeys != null) && (unprocessedKeys.size() == requestedKeys.size()))
    {
      Random random = new Random();
      long scaleFactor = 500 + random.nextInt(100);
      int retriesAttempted = batchLoadContext.getRetriesAttempted();
      delay = (Math.pow(2.0D, retriesAttempted) * scaleFactor);
      delay = Math.min(delay, 3000L);
    }
    return delay;
  }
  
  public boolean shouldRetry(BatchLoadContext batchLoadContext)
  {
    Map<String, KeysAndAttributes> unprocessedKeys = batchLoadContext.getBatchGetItemResult().getUnprocessedKeys();
    return (unprocessedKeys != null) && (unprocessedKeys.size() > 0) && (batchLoadContext.getRetriesAttempted() < 5);
  }
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withBatchLoadRetryStrategy(this).build();
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.DefaultBatchLoadRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */