package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$18
  implements Callable<PutDashboardResult>
{
  AmazonCloudWatchAsyncClient$18(AmazonCloudWatchAsyncClient this$0, PutDashboardRequest paramPutDashboardRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutDashboardResult call()
    throws Exception
  {
    PutDashboardResult result = null;
    try
    {
      result = this$0.executePutDashboard(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */