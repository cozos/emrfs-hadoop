package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$20
  implements Callable<ModifyInstanceFleetResult>
{
  AmazonElasticMapReduceAsyncClient$20(AmazonElasticMapReduceAsyncClient this$0, ModifyInstanceFleetRequest paramModifyInstanceFleetRequest, AsyncHandler paramAsyncHandler) {}
  
  public ModifyInstanceFleetResult call()
    throws Exception
  {
    ModifyInstanceFleetResult result = null;
    try
    {
      result = this$0.executeModifyInstanceFleet(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */