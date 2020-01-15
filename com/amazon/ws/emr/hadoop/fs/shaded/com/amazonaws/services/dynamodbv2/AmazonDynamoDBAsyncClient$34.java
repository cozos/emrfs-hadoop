package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$34
  implements Callable<UpdateItemResult>
{
  AmazonDynamoDBAsyncClient$34(AmazonDynamoDBAsyncClient this$0, UpdateItemRequest paramUpdateItemRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateItemResult call()
    throws Exception
  {
    UpdateItemResult result = null;
    try
    {
      result = this$0.executeUpdateItem(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.34
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */