package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBStreamsAsyncClient$2
  implements Callable<GetRecordsResult>
{
  AmazonDynamoDBStreamsAsyncClient$2(AmazonDynamoDBStreamsAsyncClient this$0, GetRecordsRequest paramGetRecordsRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetRecordsResult call()
    throws Exception
  {
    GetRecordsResult result = null;
    try
    {
      result = this$0.executeGetRecords(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */