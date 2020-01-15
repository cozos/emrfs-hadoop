package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$30
  implements Callable<UntagResourceResult>
{
  AmazonDynamoDBAsyncClient$30(AmazonDynamoDBAsyncClient this$0, UntagResourceRequest paramUntagResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public UntagResourceResult call()
    throws Exception
  {
    UntagResourceResult result = null;
    try
    {
      result = this$0.executeUntagResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */