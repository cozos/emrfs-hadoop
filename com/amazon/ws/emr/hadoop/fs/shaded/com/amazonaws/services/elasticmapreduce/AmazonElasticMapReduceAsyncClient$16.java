package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$16
  implements Callable<ListInstanceGroupsResult>
{
  AmazonElasticMapReduceAsyncClient$16(AmazonElasticMapReduceAsyncClient this$0, ListInstanceGroupsRequest paramListInstanceGroupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListInstanceGroupsResult call()
    throws Exception
  {
    ListInstanceGroupsResult result = null;
    try
    {
      result = this$0.executeListInstanceGroups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */