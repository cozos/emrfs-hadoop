package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$33
  implements Callable<UpdateGlobalTableSettingsResult>
{
  AmazonDynamoDBAsyncClient$33(AmazonDynamoDBAsyncClient this$0, UpdateGlobalTableSettingsRequest paramUpdateGlobalTableSettingsRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateGlobalTableSettingsResult call()
    throws Exception
  {
    UpdateGlobalTableSettingsResult result = null;
    try
    {
      result = this$0.executeUpdateGlobalTableSettings(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.33
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */