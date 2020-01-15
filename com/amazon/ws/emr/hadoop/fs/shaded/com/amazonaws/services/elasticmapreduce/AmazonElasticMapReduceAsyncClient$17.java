package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$17
  implements Callable<ListInstancesResult>
{
  AmazonElasticMapReduceAsyncClient$17(AmazonElasticMapReduceAsyncClient this$0, ListInstancesRequest paramListInstancesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListInstancesResult call()
    throws Exception
  {
    ListInstancesResult result = null;
    try
    {
      result = this$0.executeListInstances(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */