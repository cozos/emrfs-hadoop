package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.SetQueueAttributesResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$18
  implements Callable<SetQueueAttributesResult>
{
  AmazonSQSAsyncClient$18(AmazonSQSAsyncClient this$0, SetQueueAttributesRequest paramSetQueueAttributesRequest, AsyncHandler paramAsyncHandler) {}
  
  public SetQueueAttributesResult call()
    throws Exception
  {
    SetQueueAttributesResult result = null;
    try
    {
      result = this$0.executeSetQueueAttributes(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */