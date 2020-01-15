package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$15
  implements Callable<ListMetricsResult>
{
  AmazonCloudWatchAsyncClient$15(AmazonCloudWatchAsyncClient this$0, ListMetricsRequest paramListMetricsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListMetricsResult call()
    throws Exception
  {
    ListMetricsResult result = null;
    try
    {
      result = this$0.executeListMetrics(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */