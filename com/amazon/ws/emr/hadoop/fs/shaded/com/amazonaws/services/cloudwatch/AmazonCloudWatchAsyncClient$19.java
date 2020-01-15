package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$19
  implements Callable<PutMetricAlarmResult>
{
  AmazonCloudWatchAsyncClient$19(AmazonCloudWatchAsyncClient this$0, PutMetricAlarmRequest paramPutMetricAlarmRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutMetricAlarmResult call()
    throws Exception
  {
    PutMetricAlarmResult result = null;
    try
    {
      result = this$0.executePutMetricAlarm(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */