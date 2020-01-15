package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$20
  implements Callable<PutMetricDataResult>
{
  AmazonCloudWatchAsyncClient$20(AmazonCloudWatchAsyncClient this$0, PutMetricDataRequest paramPutMetricDataRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutMetricDataResult call()
    throws Exception
  {
    PutMetricDataResult result = null;
    try
    {
      result = this$0.executePutMetricData(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */