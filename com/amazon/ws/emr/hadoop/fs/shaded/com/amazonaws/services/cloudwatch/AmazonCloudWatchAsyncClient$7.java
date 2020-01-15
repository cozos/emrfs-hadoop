package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$7
  implements Callable<DescribeAnomalyDetectorsResult>
{
  AmazonCloudWatchAsyncClient$7(AmazonCloudWatchAsyncClient this$0, DescribeAnomalyDetectorsRequest paramDescribeAnomalyDetectorsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeAnomalyDetectorsResult call()
    throws Exception
  {
    DescribeAnomalyDetectorsResult result = null;
    try
    {
      result = this$0.executeDescribeAnomalyDetectors(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */