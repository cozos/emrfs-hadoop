package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$12
  implements Callable<DescribeGlobalTableResult>
{
  AmazonDynamoDBAsyncClient$12(AmazonDynamoDBAsyncClient this$0, DescribeGlobalTableRequest paramDescribeGlobalTableRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeGlobalTableResult call()
    throws Exception
  {
    DescribeGlobalTableResult result = null;
    try
    {
      result = this$0.executeDescribeGlobalTable(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */