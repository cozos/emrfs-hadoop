package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;

public abstract interface DynamoDBMapperConfig$BatchWriteRetryStrategy
{
  public abstract int getMaxRetryOnUnprocessedItems(Map<String, List<WriteRequest>> paramMap);
  
  public abstract long getDelayBeforeRetryUnprocessedItems(Map<String, List<WriteRequest>> paramMap, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.BatchWriteRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */