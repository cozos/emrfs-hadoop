package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import java.util.List;
import java.util.Map;

public final class DynamoDBMapper$BatchGetItemException
  extends SdkClientException
{
  private final Map<String, KeysAndAttributes> unprocessedKeys;
  private final Map<String, List<Object>> responses;
  
  public DynamoDBMapper$BatchGetItemException(String message, Map<String, KeysAndAttributes> unprocessedKeys, Map<String, List<Object>> responses)
  {
    super(message);
    this.unprocessedKeys = unprocessedKeys;
    this.responses = responses;
  }
  
  public Map<String, KeysAndAttributes> getUnprocessedKeys()
  {
    return unprocessedKeys;
  }
  
  public Map<String, List<Object>> getResponses()
  {
    return responses;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.BatchGetItemException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */