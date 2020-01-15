package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$28
  implements Callable<TransactGetItemsResult>
{
  AmazonDynamoDBAsyncClient$28(AmazonDynamoDBAsyncClient this$0, TransactGetItemsRequest paramTransactGetItemsRequest, AsyncHandler paramAsyncHandler) {}
  
  public TransactGetItemsResult call()
    throws Exception
  {
    TransactGetItemsResult result = null;
    try
    {
      result = this$0.executeTransactGetItems(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */