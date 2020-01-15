package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$21
  implements Callable<ModifyInstanceGroupsResult>
{
  AmazonElasticMapReduceAsyncClient$21(AmazonElasticMapReduceAsyncClient this$0, ModifyInstanceGroupsRequest paramModifyInstanceGroupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ModifyInstanceGroupsResult call()
    throws Exception
  {
    ModifyInstanceGroupsResult result = null;
    try
    {
      result = this$0.executeModifyInstanceGroups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */