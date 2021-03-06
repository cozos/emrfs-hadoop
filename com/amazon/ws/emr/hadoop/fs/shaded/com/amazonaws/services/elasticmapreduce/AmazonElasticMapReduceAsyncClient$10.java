package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationResult;
import java.util.concurrent.Callable;

class AmazonElasticMapReduceAsyncClient$10
  implements Callable<DescribeSecurityConfigurationResult>
{
  AmazonElasticMapReduceAsyncClient$10(AmazonElasticMapReduceAsyncClient this$0, DescribeSecurityConfigurationRequest paramDescribeSecurityConfigurationRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeSecurityConfigurationResult call()
    throws Exception
  {
    DescribeSecurityConfigurationResult result = null;
    try
    {
      result = this$0.executeDescribeSecurityConfiguration(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */