package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;

public class DynamoDBMapper$FailedBatch
{
  private Map<String, List<WriteRequest>> unprocessedItems;
  private Exception exception;
  
  public void setUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems)
  {
    this.unprocessedItems = unprocessedItems;
  }
  
  public Map<String, List<WriteRequest>> getUnprocessedItems()
  {
    return unprocessedItems;
  }
  
  public void setException(Exception exception)
  {
    this.exception = exception;
  }
  
  public Exception getException()
  {
    return exception;
  }
  
  private final boolean isRequestEntityTooLarge()
  {
    return ((exception instanceof AmazonServiceException)) && 
      (RetryUtils.isRequestEntityTooLargeException((AmazonServiceException)exception));
  }
  
  private final boolean isThrottling()
  {
    return ((exception instanceof AmazonServiceException)) && 
      (RetryUtils.isThrottlingException((AmazonServiceException)exception));
  }
  
  private final int size()
  {
    int size = 0;
    for (List<WriteRequest> values : unprocessedItems.values()) {
      size += values.size();
    }
    return size;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.FailedBatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */