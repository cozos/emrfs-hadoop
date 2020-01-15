package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$6
  implements Callable<DescribeAlarmsForMetricResult>
{
  AmazonCloudWatchAsyncClient$6(AmazonCloudWatchAsyncClient this$0, DescribeAlarmsForMetricRequest paramDescribeAlarmsForMetricRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeAlarmsForMetricResult call()
    throws Exception
  {
    DescribeAlarmsForMetricResult result = null;
    try
    {
      result = this$0.executeDescribeAlarmsForMetric(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */