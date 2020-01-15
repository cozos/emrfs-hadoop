package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$22
  implements Callable<PutItemResult>
{
  AmazonDynamoDBAsyncClient$22(AmazonDynamoDBAsyncClient this$0, PutItemRequest paramPutItemRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutItemResult call()
    throws Exception
  {
    PutItemResult result = null;
    try
    {
      result = this$0.executePutItem(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */