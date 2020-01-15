package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$3
  implements Callable<CreateBackupResult>
{
  AmazonDynamoDBAsyncClient$3(AmazonDynamoDBAsyncClient this$0, CreateBackupRequest paramCreateBackupRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateBackupResult call()
    throws Exception
  {
    CreateBackupResult result = null;
    try
    {
      result = this$0.executeCreateBackup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */