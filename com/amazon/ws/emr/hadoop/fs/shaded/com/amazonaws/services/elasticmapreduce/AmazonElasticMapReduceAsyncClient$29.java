package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$29
  implements Callable<TerminateJobFlowsResult>
{
  AmazonElasticMapReduceAsyncClient$29(AmazonElasticMapReduceAsyncClient this$0, TerminateJobFlowsRequest paramTerminateJobFlowsRequest, AsyncHandler paramAsyncHandler) {}
  
  public TerminateJobFlowsResult call()
    throws Exception
  {
    TerminateJobFlowsResult result = null;
    try
    {
      result = this$0.executeTerminateJobFlows(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */