package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$23
  implements Callable<PutBlockPublicAccessConfigurationResult>
{
  AmazonElasticMapReduceAsyncClient$23(AmazonElasticMapReduceAsyncClient this$0, PutBlockPublicAccessConfigurationRequest paramPutBlockPublicAccessConfigurationRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutBlockPublicAccessConfigurationResult call()
    throws Exception
  {
    PutBlockPublicAccessConfigurationResult result = null;
    try
    {
      result = this$0.executePutBlockPublicAccessConfiguration(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */