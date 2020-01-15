package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$21
  implements Callable<ListTagsOfResourceResult>
{
  AmazonDynamoDBAsyncClient$21(AmazonDynamoDBAsyncClient this$0, ListTagsOfResourceRequest paramListTagsOfResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListTagsOfResourceResult call()
    throws Exception
  {
    ListTagsOfResourceResult result = null;
    try
    {
      result = this$0.executeListTagsOfResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */