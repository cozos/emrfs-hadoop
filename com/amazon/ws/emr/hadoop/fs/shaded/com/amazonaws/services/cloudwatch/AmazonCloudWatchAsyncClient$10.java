package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$10
  implements Callable<GetDashboardResult>
{
  AmazonCloudWatchAsyncClient$10(AmazonCloudWatchAsyncClient this$0, GetDashboardRequest paramGetDashboardRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetDashboardResult call()
    throws Exception
  {
    GetDashboardResult result = null;
    try
    {
      result = this$0.executeGetDashboard(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */