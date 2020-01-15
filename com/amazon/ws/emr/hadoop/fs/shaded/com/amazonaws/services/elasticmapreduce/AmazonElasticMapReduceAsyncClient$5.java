package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$5
  implements Callable<CancelStepsResult>
{
  AmazonElasticMapReduceAsyncClient$5(AmazonElasticMapReduceAsyncClient this$0, CancelStepsRequest paramCancelStepsRequest, AsyncHandler paramAsyncHandler) {}
  
  public CancelStepsResult call()
    throws Exception
  {
    CancelStepsResult result = null;
    try
    {
      result = this$0.executeCancelSteps(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */