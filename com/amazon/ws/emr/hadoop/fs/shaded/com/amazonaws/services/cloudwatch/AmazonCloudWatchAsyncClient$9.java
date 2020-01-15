package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$9
  implements Callable<EnableAlarmActionsResult>
{
  AmazonCloudWatchAsyncClient$9(AmazonCloudWatchAsyncClient this$0, EnableAlarmActionsRequest paramEnableAlarmActionsRequest, AsyncHandler paramAsyncHandler) {}
  
  public EnableAlarmActionsResult call()
    throws Exception
  {
    EnableAlarmActionsResult result = null;
    try
    {
      result = this$0.executeEnableAlarmActions(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */