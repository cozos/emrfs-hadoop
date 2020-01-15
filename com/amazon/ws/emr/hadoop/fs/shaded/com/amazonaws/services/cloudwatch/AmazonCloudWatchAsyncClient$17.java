package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$17
  implements Callable<PutAnomalyDetectorResult>
{
  AmazonCloudWatchAsyncClient$17(AmazonCloudWatchAsyncClient this$0, PutAnomalyDetectorRequest paramPutAnomalyDetectorRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutAnomalyDetectorResult call()
    throws Exception
  {
    PutAnomalyDetectorResult result = null;
    try
    {
      result = this$0.executePutAnomalyDetector(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */