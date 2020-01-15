package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DynamoDBMapperConfig$DefaultBatchWriteRetryStrategy
  implements DynamoDBMapperConfig.BatchWriteRetryStrategy
{
  public static final DefaultBatchWriteRetryStrategy INSTANCE = new DefaultBatchWriteRetryStrategy();
  private static final long MAX_BACKOFF_IN_MILLISECONDS = 3000L;
  private static final int DEFAULT_MAX_RETRY = -1;
  private final int maxRetry;
  
  public DynamoDBMapperConfig$DefaultBatchWriteRetryStrategy()
  {
    this(-1);
  }
  
  public DynamoDBMapperConfig$DefaultBatchWriteRetryStrategy(int maxRetry)
  {
    this.maxRetry = maxRetry;
  }
  
  public int getMaxRetryOnUnprocessedItems(Map<String, List<WriteRequest>> batchWriteItemInput)
  {
    return maxRetry;
  }
  
  public long getDelayBeforeRetryUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems, int retriesAttempted)
  {
    if (retriesAttempted < 0) {
      return 0L;
    }
    Random random = new Random();
    long scaleFactor = 1000 + random.nextInt(200);
    long delay = (Math.pow(2.0D, retriesAttempted) * scaleFactor);
    return Math.min(delay, 3000L);
  }
  
  private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withBatchWriteRetryStrategy(this).build();
  
  public final DynamoDBMapperConfig config()
  {
    return config;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.DefaultBatchWriteRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */