package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$10
  implements Callable<DescribeContinuousBackupsResult>
{
  AmazonDynamoDBAsyncClient$10(AmazonDynamoDBAsyncClient this$0, DescribeContinuousBackupsRequest paramDescribeContinuousBackupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeContinuousBackupsResult call()
    throws Exception
  {
    DescribeContinuousBackupsResult result = null;
    try
    {
      result = this$0.executeDescribeContinuousBackups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */