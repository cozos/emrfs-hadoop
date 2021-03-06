package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$32
  implements Callable<UpdateGlobalTableResult>
{
  AmazonDynamoDBAsyncClient$32(AmazonDynamoDBAsyncClient this$0, UpdateGlobalTableRequest paramUpdateGlobalTableRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateGlobalTableResult call()
    throws Exception
  {
    UpdateGlobalTableResult result = null;
    try
    {
      result = this$0.executeUpdateGlobalTable(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.32
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */