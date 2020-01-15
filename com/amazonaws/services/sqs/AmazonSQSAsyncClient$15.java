package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.RemovePermissionResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$15
  implements Callable<RemovePermissionResult>
{
  AmazonSQSAsyncClient$15(AmazonSQSAsyncClient this$0, RemovePermissionRequest paramRemovePermissionRequest, AsyncHandler paramAsyncHandler) {}
  
  public RemovePermissionResult call()
    throws Exception
  {
    RemovePermissionResult result = null;
    try
    {
      result = this$0.executeRemovePermission(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */