package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$19
  implements Callable<ListStepsResult>
{
  AmazonElasticMapReduceAsyncClient$19(AmazonElasticMapReduceAsyncClient this$0, ListStepsRequest paramListStepsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListStepsResult call()
    throws Exception
  {
    ListStepsResult result = null;
    try
    {
      result = this$0.executeListSteps(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */