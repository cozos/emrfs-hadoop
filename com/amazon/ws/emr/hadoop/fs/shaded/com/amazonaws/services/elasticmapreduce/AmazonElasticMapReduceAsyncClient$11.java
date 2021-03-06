package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$11
  implements Callable<DescribeStepResult>
{
  AmazonElasticMapReduceAsyncClient$11(AmazonElasticMapReduceAsyncClient this$0, DescribeStepRequest paramDescribeStepRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeStepResult call()
    throws Exception
  {
    DescribeStepResult result = null;
    try
    {
      result = this$0.executeDescribeStep(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */