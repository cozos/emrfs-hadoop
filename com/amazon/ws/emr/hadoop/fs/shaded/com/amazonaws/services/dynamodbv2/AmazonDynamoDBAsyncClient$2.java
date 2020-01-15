package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$2
  implements Callable<BatchWriteItemResult>
{
  AmazonDynamoDBAsyncClient$2(AmazonDynamoDBAsyncClient this$0, BatchWriteItemRequest paramBatchWriteItemRequest, AsyncHandler paramAsyncHandler) {}
  
  public BatchWriteItemResult call()
    throws Exception
  {
    BatchWriteItemResult result = null;
    try
    {
      result = this$0.executeBatchWriteItem(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */