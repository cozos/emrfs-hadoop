package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$36
  implements Callable<UpdateTimeToLiveResult>
{
  AmazonDynamoDBAsyncClient$36(AmazonDynamoDBAsyncClient this$0, UpdateTimeToLiveRequest paramUpdateTimeToLiveRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateTimeToLiveResult call()
    throws Exception
  {
    UpdateTimeToLiveResult result = null;
    try
    {
      result = this$0.executeUpdateTimeToLive(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.36
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */