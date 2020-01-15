package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$25
  implements Callable<RemoveTagsResult>
{
  AmazonElasticMapReduceAsyncClient$25(AmazonElasticMapReduceAsyncClient this$0, RemoveTagsRequest paramRemoveTagsRequest, AsyncHandler paramAsyncHandler) {}
  
  public RemoveTagsResult call()
    throws Exception
  {
    RemoveTagsResult result = null;
    try
    {
      result = this$0.executeRemoveTags(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */