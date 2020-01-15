package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$22
  implements Callable<TagResourceResult>
{
  AmazonCloudWatchAsyncClient$22(AmazonCloudWatchAsyncClient this$0, TagResourceRequest paramTagResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public TagResourceResult call()
    throws Exception
  {
    TagResourceResult result = null;
    try
    {
      result = this$0.executeTagResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */