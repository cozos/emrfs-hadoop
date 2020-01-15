package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$4
  implements Callable<CreateQueueResult>
{
  AmazonSQSAsyncClient$4(AmazonSQSAsyncClient this$0, CreateQueueRequest paramCreateQueueRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateQueueResult call()
    throws Exception
  {
    CreateQueueResult result = null;
    try
    {
      result = this$0.executeCreateQueue(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */