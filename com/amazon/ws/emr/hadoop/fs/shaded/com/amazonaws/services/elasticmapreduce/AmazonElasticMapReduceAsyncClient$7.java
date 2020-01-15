package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$7
  implements Callable<DeleteSecurityConfigurationResult>
{
  AmazonElasticMapReduceAsyncClient$7(AmazonElasticMapReduceAsyncClient this$0, DeleteSecurityConfigurationRequest paramDeleteSecurityConfigurationRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteSecurityConfigurationResult call()
    throws Exception
  {
    DeleteSecurityConfigurationResult result = null;
    try
    {
      result = this$0.executeDeleteSecurityConfiguration(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */