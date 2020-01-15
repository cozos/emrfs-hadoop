package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$14
  implements Callable<ReceiveMessageResult>
{
  AmazonSQSAsyncClient$14(AmazonSQSAsyncClient this$0, ReceiveMessageRequest paramReceiveMessageRequest, AsyncHandler paramAsyncHandler) {}
  
  public ReceiveMessageResult call()
    throws Exception
  {
    ReceiveMessageResult result = null;
    try
    {
      result = this$0.executeReceiveMessage(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */