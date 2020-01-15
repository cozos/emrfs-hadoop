package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class BatchLoadContext
{
  private BatchGetItemResult batchGetItemResult;
  private final BatchGetItemRequest batchGetItemRequest;
  private int retriesAttempted;
  
  public BatchLoadContext(BatchGetItemRequest batchGetItemRequest)
  {
    this.batchGetItemRequest = ((BatchGetItemRequest)ValidationUtils.assertNotNull(batchGetItemRequest, "batchGetItemRequest"));
    batchGetItemResult = null;
    retriesAttempted = 0;
  }
  
  public BatchGetItemResult getBatchGetItemResult()
  {
    return batchGetItemResult;
  }
  
  public void setBatchGetItemResult(BatchGetItemResult batchGetItemResult)
  {
    this.batchGetItemResult = batchGetItemResult;
  }
  
  public BatchGetItemRequest getBatchGetItemRequest()
  {
    return batchGetItemRequest;
  }
  
  public int getRetriesAttempted()
  {
    return retriesAttempted;
  }
  
  public void setRetriesAttempted(int retriesAttempted)
  {
    this.retriesAttempted = retriesAttempted;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.BatchLoadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */