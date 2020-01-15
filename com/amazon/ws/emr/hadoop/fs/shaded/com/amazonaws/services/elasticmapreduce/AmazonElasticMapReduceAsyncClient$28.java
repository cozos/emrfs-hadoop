package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$28
  implements Callable<SetVisibleToAllUsersResult>
{
  AmazonElasticMapReduceAsyncClient$28(AmazonElasticMapReduceAsyncClient this$0, SetVisibleToAllUsersRequest paramSetVisibleToAllUsersRequest, AsyncHandler paramAsyncHandler) {}
  
  public SetVisibleToAllUsersResult call()
    throws Exception
  {
    SetVisibleToAllUsersResult result = null;
    try
    {
      result = this$0.executeSetVisibleToAllUsers(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */