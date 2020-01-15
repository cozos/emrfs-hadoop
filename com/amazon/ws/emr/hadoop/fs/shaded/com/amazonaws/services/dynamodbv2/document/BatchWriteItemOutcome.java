package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;

public class BatchWriteItemOutcome
{
  private final BatchWriteItemResult result;
  
  public BatchWriteItemOutcome(BatchWriteItemResult result)
  {
    if (result == null) {
      throw new IllegalArgumentException();
    }
    this.result = result;
  }
  
  public Map<String, List<WriteRequest>> getUnprocessedItems()
  {
    return result.getUnprocessedItems();
  }
  
  public BatchWriteItemResult getBatchWriteItemResult()
  {
    return result;
  }
  
  public String toString()
  {
    return String.valueOf(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */