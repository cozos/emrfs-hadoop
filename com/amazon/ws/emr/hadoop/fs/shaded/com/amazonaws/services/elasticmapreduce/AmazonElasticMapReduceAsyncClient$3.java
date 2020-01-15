package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$3
  implements Callable<AddJobFlowStepsResult>
{
  AmazonElasticMapReduceAsyncClient$3(AmazonElasticMapReduceAsyncClient this$0, AddJobFlowStepsRequest paramAddJobFlowStepsRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddJobFlowStepsResult call()
    throws Exception
  {
    AddJobFlowStepsResult result = null;
    try
    {
      result = this$0.executeAddJobFlowSteps(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */