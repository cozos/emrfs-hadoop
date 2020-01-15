package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$8
  implements Callable<DescribeClusterResult>
{
  AmazonElasticMapReduceAsyncClient$8(AmazonElasticMapReduceAsyncClient this$0, DescribeClusterRequest paramDescribeClusterRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeClusterResult call()
    throws Exception
  {
    DescribeClusterResult result = null;
    try
    {
      result = this$0.executeDescribeCluster(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */