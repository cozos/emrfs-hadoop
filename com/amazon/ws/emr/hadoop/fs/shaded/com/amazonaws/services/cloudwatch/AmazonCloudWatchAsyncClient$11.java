package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$11
  implements Callable<GetMetricDataResult>
{
  AmazonCloudWatchAsyncClient$11(AmazonCloudWatchAsyncClient this$0, GetMetricDataRequest paramGetMetricDataRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetMetricDataResult call()
    throws Exception
  {
    GetMetricDataResult result = null;
    try
    {
      result = this$0.executeGetMetricData(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */