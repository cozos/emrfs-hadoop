package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.TagQueueRequest;
import com.amazonaws.services.sqs.model.TagQueueResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$19
  implements Callable<TagQueueResult>
{
  AmazonSQSAsyncClient$19(AmazonSQSAsyncClient this$0, TagQueueRequest paramTagQueueRequest, AsyncHandler paramAsyncHandler) {}
  
  public TagQueueResult call()
    throws Exception
  {
    TagQueueResult result = null;
    try
    {
      result = this$0.executeTagQueue(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */