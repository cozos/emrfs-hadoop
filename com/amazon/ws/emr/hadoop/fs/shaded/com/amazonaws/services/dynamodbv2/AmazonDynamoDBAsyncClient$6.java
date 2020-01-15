package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteBackupResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$6
  implements Callable<DeleteBackupResult>
{
  AmazonDynamoDBAsyncClient$6(AmazonDynamoDBAsyncClient this$0, DeleteBackupRequest paramDeleteBackupRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteBackupResult call()
    throws Exception
  {
    DeleteBackupResult result = null;
    try
    {
      result = this$0.executeDeleteBackup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */