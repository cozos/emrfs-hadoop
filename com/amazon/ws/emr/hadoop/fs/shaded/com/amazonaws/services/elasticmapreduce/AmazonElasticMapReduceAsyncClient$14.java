package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$14
  implements Callable<ListClustersResult>
{
  AmazonElasticMapReduceAsyncClient$14(AmazonElasticMapReduceAsyncClient this$0, ListClustersRequest paramListClustersRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListClustersResult call()
    throws Exception
  {
    ListClustersResult result = null;
    try
    {
      result = this$0.executeListClusters(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */