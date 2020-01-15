package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$1
  implements Callable<BatchGetItemResult>
{
  AmazonDynamoDBAsyncClient$1(AmazonDynamoDBAsyncClient this$0, BatchGetItemRequest paramBatchGetItemRequest, AsyncHandler paramAsyncHandler) {}
  
  public BatchGetItemResult call()
    throws Exception
  {
    BatchGetItemResult result = null;
    try
    {
      result = this$0.executeBatchGetItem(val$finalRequest);
    }
    catch (Exception ex)
    {
      if (val$asyncHandler != null) {
        val$asyncHandler.onError(ex);
      }
      throw ex;
    }
    if (val$asyncHandler != null) {
      val$asyncHandler.onSuccess(val$finalRequest, result);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */