package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.AddPermissionResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$1
  implements Callable<AddPermissionResult>
{
  AmazonSQSAsyncClient$1(AmazonSQSAsyncClient this$0, AddPermissionRequest paramAddPermissionRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddPermissionResult call()
    throws Exception
  {
    AddPermissionResult result = null;
    try
    {
      result = this$0.executeAddPermission(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */