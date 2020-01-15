package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$4
  implements Callable<DescribeAlarmHistoryResult>
{
  AmazonCloudWatchAsyncClient$4(AmazonCloudWatchAsyncClient this$0, DescribeAlarmHistoryRequest paramDescribeAlarmHistoryRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeAlarmHistoryResult call()
    throws Exception
  {
    DescribeAlarmHistoryResult result = null;
    try
    {
      result = this$0.executeDescribeAlarmHistory(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */