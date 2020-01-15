package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$8
  implements Callable<GetQueueAttributesResult>
{
  AmazonSQSAsyncClient$8(AmazonSQSAsyncClient this$0, GetQueueAttributesRequest paramGetQueueAttributesRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetQueueAttributesResult call()
    throws Exception
  {
    GetQueueAttributesResult result = null;
    try
    {
      result = this$0.executeGetQueueAttributes(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */