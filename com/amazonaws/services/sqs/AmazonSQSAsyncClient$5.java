package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$5
  implements Callable<DeleteMessageResult>
{
  AmazonSQSAsyncClient$5(AmazonSQSAsyncClient this$0, DeleteMessageRequest paramDeleteMessageRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteMessageResult call()
    throws Exception
  {
    DeleteMessageResult result = null;
    try
    {
      result = this$0.executeDeleteMessage(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */