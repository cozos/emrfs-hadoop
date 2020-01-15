package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$14
  implements Callable<ListDashboardsResult>
{
  AmazonCloudWatchAsyncClient$14(AmazonCloudWatchAsyncClient this$0, ListDashboardsRequest paramListDashboardsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListDashboardsResult call()
    throws Exception
  {
    ListDashboardsResult result = null;
    try
    {
      result = this$0.executeListDashboards(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */