package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$7
  implements Callable<DeleteQueueResult>
{
  AmazonSQSAsyncClient$7(AmazonSQSAsyncClient this$0, DeleteQueueRequest paramDeleteQueueRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteQueueResult call()
    throws Exception
  {
    DeleteQueueResult result = null;
    try
    {
      result = this$0.executeDeleteQueue(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */