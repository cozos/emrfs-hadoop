package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$13
  implements Callable<GetMetricWidgetImageResult>
{
  AmazonCloudWatchAsyncClient$13(AmazonCloudWatchAsyncClient this$0, GetMetricWidgetImageRequest paramGetMetricWidgetImageRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetMetricWidgetImageResult call()
    throws Exception
  {
    GetMetricWidgetImageResult result = null;
    try
    {
      result = this$0.executeGetMetricWidgetImage(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */