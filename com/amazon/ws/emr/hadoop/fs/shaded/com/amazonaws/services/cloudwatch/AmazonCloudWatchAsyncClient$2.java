package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$2
  implements Callable<DeleteAnomalyDetectorResult>
{
  AmazonCloudWatchAsyncClient$2(AmazonCloudWatchAsyncClient this$0, DeleteAnomalyDetectorRequest paramDeleteAnomalyDetectorRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteAnomalyDetectorResult call()
    throws Exception
  {
    DeleteAnomalyDetectorResult result = null;
    try
    {
      result = this$0.executeDeleteAnomalyDetector(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */