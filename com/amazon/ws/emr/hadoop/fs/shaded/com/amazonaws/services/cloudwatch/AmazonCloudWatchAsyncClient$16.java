package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceResult;
import java.util.concurrent.Callable;

class AmazonCloudWatchAsyncClient$16
  implements Callable<ListTagsForResourceResult>
{
  AmazonCloudWatchAsyncClient$16(AmazonCloudWatchAsyncClient this$0, ListTagsForResourceRequest paramListTagsForResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListTagsForResourceResult call()
    throws Exception
  {
    ListTagsForResourceResult result = null;
    try
    {
      result = this$0.executeListTagsForResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */