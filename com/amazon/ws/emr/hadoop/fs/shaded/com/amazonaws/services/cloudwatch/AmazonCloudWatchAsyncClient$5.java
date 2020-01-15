package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$5
  implements Callable<DescribeAlarmsResult>
{
  AmazonCloudWatchAsyncClient$5(AmazonCloudWatchAsyncClient this$0, DescribeAlarmsRequest paramDescribeAlarmsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeAlarmsResult call()
    throws Exception
  {
    DescribeAlarmsResult result = null;
    try
    {
      result = this$0.executeDescribeAlarms(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */