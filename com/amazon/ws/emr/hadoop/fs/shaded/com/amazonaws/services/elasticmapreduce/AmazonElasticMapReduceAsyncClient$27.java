package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$27
  implements Callable<SetTerminationProtectionResult>
{
  AmazonElasticMapReduceAsyncClient$27(AmazonElasticMapReduceAsyncClient this$0, SetTerminationProtectionRequest paramSetTerminationProtectionRequest, AsyncHandler paramAsyncHandler) {}
  
  public SetTerminationProtectionResult call()
    throws Exception
  {
    SetTerminationProtectionResult result = null;
    try
    {
      result = this$0.executeSetTerminationProtection(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.27
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */