package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$6
  implements Callable<CreateSecurityConfigurationResult>
{
  AmazonElasticMapReduceAsyncClient$6(AmazonElasticMapReduceAsyncClient this$0, CreateSecurityConfigurationRequest paramCreateSecurityConfigurationRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateSecurityConfigurationResult call()
    throws Exception
  {
    CreateSecurityConfigurationResult result = null;
    try
    {
      result = this$0.executeCreateSecurityConfiguration(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */