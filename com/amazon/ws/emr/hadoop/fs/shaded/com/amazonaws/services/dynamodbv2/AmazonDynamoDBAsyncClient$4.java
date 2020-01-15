package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$4
  implements Callable<CreateGlobalTableResult>
{
  AmazonDynamoDBAsyncClient$4(AmazonDynamoDBAsyncClient this$0, CreateGlobalTableRequest paramCreateGlobalTableRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateGlobalTableResult call()
    throws Exception
  {
    CreateGlobalTableResult result = null;
    try
    {
      result = this$0.executeCreateGlobalTable(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */