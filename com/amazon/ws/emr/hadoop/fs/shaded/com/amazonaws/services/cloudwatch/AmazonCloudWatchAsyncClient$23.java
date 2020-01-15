package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$23
  implements Callable<UntagResourceResult>
{
  AmazonCloudWatchAsyncClient$23(AmazonCloudWatchAsyncClient this$0, UntagResourceRequest paramUntagResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public UntagResourceResult call()
    throws Exception
  {
    UntagResourceResult result = null;
    try
    {
      result = this$0.executeUntagResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */