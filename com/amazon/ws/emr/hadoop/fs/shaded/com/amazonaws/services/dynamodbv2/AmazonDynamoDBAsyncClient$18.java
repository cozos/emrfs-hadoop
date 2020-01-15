package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$18
  implements Callable<ListBackupsResult>
{
  AmazonDynamoDBAsyncClient$18(AmazonDynamoDBAsyncClient this$0, ListBackupsRequest paramListBackupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListBackupsResult call()
    throws Exception
  {
    ListBackupsResult result = null;
    try
    {
      result = this$0.executeListBackups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */