package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$2
  implements Callable<ChangeMessageVisibilityResult>
{
  AmazonSQSAsyncClient$2(AmazonSQSAsyncClient this$0, ChangeMessageVisibilityRequest paramChangeMessageVisibilityRequest, AsyncHandler paramAsyncHandler) {}
  
  public ChangeMessageVisibilityResult call()
    throws Exception
  {
    ChangeMessageVisibilityResult result = null;
    try
    {
      result = this$0.executeChangeMessageVisibility(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */