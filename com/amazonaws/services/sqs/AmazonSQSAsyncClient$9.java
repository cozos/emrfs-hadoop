package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$9
  implements Callable<GetQueueUrlResult>
{
  AmazonSQSAsyncClient$9(AmazonSQSAsyncClient this$0, GetQueueUrlRequest paramGetQueueUrlRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetQueueUrlResult call()
    throws Exception
  {
    GetQueueUrlResult result = null;
    try
    {
      result = this$0.executeGetQueueUrl(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */