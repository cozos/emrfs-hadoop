package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$24
  implements Callable<RemoveAutoScalingPolicyResult>
{
  AmazonElasticMapReduceAsyncClient$24(AmazonElasticMapReduceAsyncClient this$0, RemoveAutoScalingPolicyRequest paramRemoveAutoScalingPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public RemoveAutoScalingPolicyResult call()
    throws Exception
  {
    RemoveAutoScalingPolicyResult result = null;
    try
    {
      result = this$0.executeRemoveAutoScalingPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */