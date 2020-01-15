package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$15
  implements Callable<ListInstanceFleetsResult>
{
  AmazonElasticMapReduceAsyncClient$15(AmazonElasticMapReduceAsyncClient this$0, ListInstanceFleetsRequest paramListInstanceFleetsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListInstanceFleetsResult call()
    throws Exception
  {
    ListInstanceFleetsResult result = null;
    try
    {
      result = this$0.executeListInstanceFleets(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */