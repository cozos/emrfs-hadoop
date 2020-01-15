package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBStreamsAsyncClient$4
  implements Callable<ListStreamsResult>
{
  AmazonDynamoDBStreamsAsyncClient$4(AmazonDynamoDBStreamsAsyncClient this$0, ListStreamsRequest paramListStreamsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListStreamsResult call()
    throws Exception
  {
    ListStreamsResult result = null;
    try
    {
      result = this$0.executeListStreams(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */