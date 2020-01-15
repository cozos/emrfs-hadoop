package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$10
  implements Callable<ListDeadLetterSourceQueuesResult>
{
  AmazonSQSAsyncClient$10(AmazonSQSAsyncClient this$0, ListDeadLetterSourceQueuesRequest paramListDeadLetterSourceQueuesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListDeadLetterSourceQueuesResult call()
    throws Exception
  {
    ListDeadLetterSourceQueuesResult result = null;
    try
    {
      result = this$0.executeListDeadLetterSourceQueues(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */