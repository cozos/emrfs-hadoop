package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$22
  implements Callable<PutAutoScalingPolicyResult>
{
  AmazonElasticMapReduceAsyncClient$22(AmazonElasticMapReduceAsyncClient this$0, PutAutoScalingPolicyRequest paramPutAutoScalingPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutAutoScalingPolicyResult call()
    throws Exception
  {
    PutAutoScalingPolicyResult result = null;
    try
    {
      result = this$0.executePutAutoScalingPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */