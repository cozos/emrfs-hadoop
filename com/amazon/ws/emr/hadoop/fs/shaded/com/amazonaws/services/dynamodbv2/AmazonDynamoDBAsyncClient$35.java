package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$35
  implements Callable<UpdateTableResult>
{
  AmazonDynamoDBAsyncClient$35(AmazonDynamoDBAsyncClient this$0, UpdateTableRequest paramUpdateTableRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateTableResult call()
    throws Exception
  {
    UpdateTableResult result = null;
    try
    {
      result = this$0.executeUpdateTable(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.35
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */