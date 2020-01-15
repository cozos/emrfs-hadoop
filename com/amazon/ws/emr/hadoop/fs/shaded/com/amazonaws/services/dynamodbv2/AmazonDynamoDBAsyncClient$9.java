package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$9
  implements Callable<DescribeBackupResult>
{
  AmazonDynamoDBAsyncClient$9(AmazonDynamoDBAsyncClient this$0, DescribeBackupRequest paramDescribeBackupRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeBackupResult call()
    throws Exception
  {
    DescribeBackupResult result = null;
    try
    {
      result = this$0.executeDescribeBackup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */