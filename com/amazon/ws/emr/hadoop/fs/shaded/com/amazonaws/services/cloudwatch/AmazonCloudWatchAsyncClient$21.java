package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$21
  implements Callable<SetAlarmStateResult>
{
  AmazonCloudWatchAsyncClient$21(AmazonCloudWatchAsyncClient this$0, SetAlarmStateRequest paramSetAlarmStateRequest, AsyncHandler paramAsyncHandler) {}
  
  public SetAlarmStateResult call()
    throws Exception
  {
    SetAlarmStateResult result = null;
    try
    {
      result = this$0.executeSetAlarmState(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */