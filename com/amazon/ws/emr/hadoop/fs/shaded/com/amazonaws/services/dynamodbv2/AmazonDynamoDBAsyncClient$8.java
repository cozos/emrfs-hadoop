package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$8
  implements Callable<DeleteTableResult>
{
  AmazonDynamoDBAsyncClient$8(AmazonDynamoDBAsyncClient this$0, DeleteTableRequest paramDeleteTableRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteTableResult call()
    throws Exception
  {
    DeleteTableResult result = null;
    try
    {
      result = this$0.executeDeleteTable(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */