package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$1
  implements Callable<DeleteAlarmsResult>
{
  AmazonCloudWatchAsyncClient$1(AmazonCloudWatchAsyncClient this$0, DeleteAlarmsRequest paramDeleteAlarmsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteAlarmsResult call()
    throws Exception
  {
    DeleteAlarmsResult result = null;
    try
    {
      result = this$0.executeDeleteAlarms(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */