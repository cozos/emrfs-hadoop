package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$8
  implements Callable<DisableAlarmActionsResult>
{
  AmazonCloudWatchAsyncClient$8(AmazonCloudWatchAsyncClient this$0, DisableAlarmActionsRequest paramDisableAlarmActionsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DisableAlarmActionsResult call()
    throws Exception
  {
    DisableAlarmActionsResult result = null;
    try
    {
      result = this$0.executeDisableAlarmActions(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */