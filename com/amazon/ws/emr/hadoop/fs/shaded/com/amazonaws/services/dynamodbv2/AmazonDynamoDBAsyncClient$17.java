package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$17
  implements Callable<GetItemResult>
{
  AmazonDynamoDBAsyncClient$17(AmazonDynamoDBAsyncClient this$0, GetItemRequest paramGetItemRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetItemResult call()
    throws Exception
  {
    GetItemResult result = null;
    try
    {
      result = this$0.executeGetItem(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */