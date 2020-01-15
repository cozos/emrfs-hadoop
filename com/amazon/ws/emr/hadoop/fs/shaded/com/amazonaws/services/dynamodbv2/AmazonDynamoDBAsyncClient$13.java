package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$13
  implements Callable<DescribeGlobalTableSettingsResult>
{
  AmazonDynamoDBAsyncClient$13(AmazonDynamoDBAsyncClient this$0, DescribeGlobalTableSettingsRequest paramDescribeGlobalTableSettingsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeGlobalTableSettingsResult call()
    throws Exception
  {
    DescribeGlobalTableSettingsResult result = null;
    try
    {
      result = this$0.executeDescribeGlobalTableSettings(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */