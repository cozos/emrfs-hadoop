package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$13
  implements Callable<ListBootstrapActionsResult>
{
  AmazonElasticMapReduceAsyncClient$13(AmazonElasticMapReduceAsyncClient this$0, ListBootstrapActionsRequest paramListBootstrapActionsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListBootstrapActionsResult call()
    throws Exception
  {
    ListBootstrapActionsResult result = null;
    try
    {
      result = this$0.executeListBootstrapActions(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */