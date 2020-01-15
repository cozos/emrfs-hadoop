package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$24
  implements Callable<RestoreTableFromBackupResult>
{
  AmazonDynamoDBAsyncClient$24(AmazonDynamoDBAsyncClient this$0, RestoreTableFromBackupRequest paramRestoreTableFromBackupRequest, AsyncHandler paramAsyncHandler) {}
  
  public RestoreTableFromBackupResult call()
    throws Exception
  {
    RestoreTableFromBackupResult result = null;
    try
    {
      result = this$0.executeRestoreTableFromBackup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */