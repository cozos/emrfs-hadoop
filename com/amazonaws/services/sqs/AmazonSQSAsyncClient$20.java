package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.UntagQueueRequest;
import com.amazonaws.services.sqs.model.UntagQueueResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$20
  implements Callable<UntagQueueResult>
{
  AmazonSQSAsyncClient$20(AmazonSQSAsyncClient this$0, UntagQueueRequest paramUntagQueueRequest, AsyncHandler paramAsyncHandler) {}
  
  public UntagQueueResult call()
    throws Exception
  {
    UntagQueueResult result = null;
    try
    {
      result = this$0.executeUntagQueue(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */