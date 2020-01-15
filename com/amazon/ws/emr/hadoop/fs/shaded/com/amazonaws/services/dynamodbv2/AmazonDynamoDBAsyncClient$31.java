package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$31
  implements Callable<UpdateContinuousBackupsResult>
{
  AmazonDynamoDBAsyncClient$31(AmazonDynamoDBAsyncClient this$0, UpdateContinuousBackupsRequest paramUpdateContinuousBackupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateContinuousBackupsResult call()
    throws Exception
  {
    UpdateContinuousBackupsResult result = null;
    try
    {
      result = this$0.executeUpdateContinuousBackups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.31
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */