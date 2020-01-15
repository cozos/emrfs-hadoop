package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$12
  implements Callable<GetBlockPublicAccessConfigurationResult>
{
  AmazonElasticMapReduceAsyncClient$12(AmazonElasticMapReduceAsyncClient this$0, GetBlockPublicAccessConfigurationRequest paramGetBlockPublicAccessConfigurationRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetBlockPublicAccessConfigurationResult call()
    throws Exception
  {
    GetBlockPublicAccessConfigurationResult result = null;
    try
    {
      result = this$0.executeGetBlockPublicAccessConfiguration(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */