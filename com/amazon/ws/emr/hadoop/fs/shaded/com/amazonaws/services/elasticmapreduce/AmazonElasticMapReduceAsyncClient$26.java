package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$26
  implements Callable<RunJobFlowResult>
{
  AmazonElasticMapReduceAsyncClient$26(AmazonElasticMapReduceAsyncClient this$0, RunJobFlowRequest paramRunJobFlowRequest, AsyncHandler paramAsyncHandler) {}
  
  public RunJobFlowResult call()
    throws Exception
  {
    RunJobFlowResult result = null;
    try
    {
      result = this$0.executeRunJobFlow(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */