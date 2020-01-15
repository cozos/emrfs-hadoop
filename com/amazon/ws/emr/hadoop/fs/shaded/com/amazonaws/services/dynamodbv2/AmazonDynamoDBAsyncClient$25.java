package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$25
  implements Callable<RestoreTableToPointInTimeResult>
{
  AmazonDynamoDBAsyncClient$25(AmazonDynamoDBAsyncClient this$0, RestoreTableToPointInTimeRequest paramRestoreTableToPointInTimeRequest, AsyncHandler paramAsyncHandler) {}
  
  public RestoreTableToPointInTimeResult call()
    throws Exception
  {
    RestoreTableToPointInTimeResult result = null;
    try
    {
      result = this$0.executeRestoreTableToPointInTime(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */