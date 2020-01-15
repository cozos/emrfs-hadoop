package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBStreamsAsyncClient$1
  implements Callable<DescribeStreamResult>
{
  AmazonDynamoDBStreamsAsyncClient$1(AmazonDynamoDBStreamsAsyncClient this$0, DescribeStreamRequest paramDescribeStreamRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeStreamResult call()
    throws Exception
  {
    DescribeStreamResult result = null;
    try
    {
      result = this$0.executeDescribeStream(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */