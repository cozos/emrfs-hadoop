package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$29
  implements Callable<TransactWriteItemsResult>
{
  AmazonDynamoDBAsyncClient$29(AmazonDynamoDBAsyncClient this$0, TransactWriteItemsRequest paramTransactWriteItemsRequest, AsyncHandler paramAsyncHandler) {}
  
  public TransactWriteItemsResult call()
    throws Exception
  {
    TransactWriteItemsResult result = null;
    try
    {
      result = this$0.executeTransactWriteItems(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */