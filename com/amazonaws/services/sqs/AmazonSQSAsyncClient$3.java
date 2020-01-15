package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$3
  implements Callable<ChangeMessageVisibilityBatchResult>
{
  AmazonSQSAsyncClient$3(AmazonSQSAsyncClient this$0, ChangeMessageVisibilityBatchRequest paramChangeMessageVisibilityBatchRequest, AsyncHandler paramAsyncHandler) {}
  
  public ChangeMessageVisibilityBatchResult call()
    throws Exception
  {
    ChangeMessageVisibilityBatchResult result = null;
    try
    {
      result = this$0.executeChangeMessageVisibilityBatch(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */