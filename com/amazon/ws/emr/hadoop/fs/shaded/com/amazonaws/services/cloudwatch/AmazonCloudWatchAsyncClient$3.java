package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$3
  implements Callable<DeleteDashboardsResult>
{
  AmazonCloudWatchAsyncClient$3(AmazonCloudWatchAsyncClient this$0, DeleteDashboardsRequest paramDeleteDashboardsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteDashboardsResult call()
    throws Exception
  {
    DeleteDashboardsResult result = null;
    try
    {
      result = this$0.executeDeleteDashboards(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */