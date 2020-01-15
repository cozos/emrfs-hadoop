package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$4
  implements Callable<AddTagsResult>
{
  AmazonElasticMapReduceAsyncClient$4(AmazonElasticMapReduceAsyncClient this$0, AddTagsRequest paramAddTagsRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddTagsResult call()
    throws Exception
  {
    AddTagsResult result = null;
    try
    {
      result = this$0.executeAddTags(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */