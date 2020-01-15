package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$18
  implements Callable<ListSecurityConfigurationsResult>
{
  AmazonElasticMapReduceAsyncClient$18(AmazonElasticMapReduceAsyncClient this$0, ListSecurityConfigurationsRequest paramListSecurityConfigurationsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListSecurityConfigurationsResult call()
    throws Exception
  {
    ListSecurityConfigurationsResult result = null;
    try
    {
      result = this$0.executeListSecurityConfigurations(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */