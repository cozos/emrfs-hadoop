package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$1
  implements Callable<AddInstanceFleetResult>
{
  AmazonElasticMapReduceAsyncClient$1(AmazonElasticMapReduceAsyncClient this$0, AddInstanceFleetRequest paramAddInstanceFleetRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddInstanceFleetResult call()
    throws Exception
  {
    AddInstanceFleetResult result = null;
    try
    {
      result = this$0.executeAddInstanceFleet(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */