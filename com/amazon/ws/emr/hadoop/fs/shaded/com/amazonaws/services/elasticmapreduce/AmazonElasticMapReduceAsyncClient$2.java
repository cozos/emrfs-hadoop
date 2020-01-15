package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$2
  implements Callable<AddInstanceGroupsResult>
{
  AmazonElasticMapReduceAsyncClient$2(AmazonElasticMapReduceAsyncClient this$0, AddInstanceGroupsRequest paramAddInstanceGroupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddInstanceGroupsResult call()
    throws Exception
  {
    AddInstanceGroupsResult result = null;
    try
    {
      result = this$0.executeAddInstanceGroups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */