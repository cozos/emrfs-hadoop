package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$9
  implements Callable<DescribeJobFlowsResult>
{
  AmazonElasticMapReduceAsyncClient$9(AmazonElasticMapReduceAsyncClient this$0, DescribeJobFlowsRequest paramDescribeJobFlowsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeJobFlowsResult call()
    throws Exception
  {
    DescribeJobFlowsResult result = null;
    try
    {
      result = this$0.executeDescribeJobFlows(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */