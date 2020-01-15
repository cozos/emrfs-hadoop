package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$16
  implements Callable<DescribeTimeToLiveResult>
{
  AmazonDynamoDBAsyncClient$16(AmazonDynamoDBAsyncClient this$0, DescribeTimeToLiveRequest paramDescribeTimeToLiveRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeTimeToLiveResult call()
    throws Exception
  {
    DescribeTimeToLiveResult result = null;
    try
    {
      result = this$0.executeDescribeTimeToLive(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */