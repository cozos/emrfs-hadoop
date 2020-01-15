package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$16
  implements Callable<SendMessageResult>
{
  AmazonSQSAsyncClient$16(AmazonSQSAsyncClient this$0, SendMessageRequest paramSendMessageRequest, AsyncHandler paramAsyncHandler) {}
  
  public SendMessageResult call()
    throws Exception
  {
    SendMessageResult result = null;
    try
    {
      result = this$0.executeSendMessage(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */