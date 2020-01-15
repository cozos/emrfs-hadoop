package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$14
  implements Callable<DescribeLimitsResult>
{
  AmazonDynamoDBAsyncClient$14(AmazonDynamoDBAsyncClient this$0, DescribeLimitsRequest paramDescribeLimitsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeLimitsResult call()
    throws Exception
  {
    DescribeLimitsResult result = null;
    try
    {
      result = this$0.executeDescribeLimits(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */