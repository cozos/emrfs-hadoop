package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;
import com.amazonaws.services.sqs.model.PurgeQueueResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$13
  implements Callable<PurgeQueueResult>
{
  AmazonSQSAsyncClient$13(AmazonSQSAsyncClient this$0, PurgeQueueRequest paramPurgeQueueRequest, AsyncHandler paramAsyncHandler) {}
  
  public PurgeQueueResult call()
    throws Exception
  {
    PurgeQueueResult result = null;
    try
    {
      result = this$0.executePurgeQueue(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */