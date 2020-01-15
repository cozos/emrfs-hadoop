package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$12
  implements Callable<ListQueuesResult>
{
  AmazonSQSAsyncClient$12(AmazonSQSAsyncClient this$0, ListQueuesRequest paramListQueuesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListQueuesResult call()
    throws Exception
  {
    ListQueuesResult result = null;
    try
    {
      result = this$0.executeListQueues(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */