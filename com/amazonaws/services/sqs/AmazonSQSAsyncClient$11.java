package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.ListQueueTagsRequest;
import com.amazonaws.services.sqs.model.ListQueueTagsResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$11
  implements Callable<ListQueueTagsResult>
{
  AmazonSQSAsyncClient$11(AmazonSQSAsyncClient this$0, ListQueueTagsRequest paramListQueueTagsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListQueueTagsResult call()
    throws Exception
  {
    ListQueueTagsResult result = null;
    try
    {
      result = this$0.executeListQueueTags(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */