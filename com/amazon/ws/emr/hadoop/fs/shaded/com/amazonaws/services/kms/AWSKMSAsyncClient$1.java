package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CancelKeyDeletionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CancelKeyDeletionResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$1
  implements Callable<CancelKeyDeletionResult>
{
  AWSKMSAsyncClient$1(AWSKMSAsyncClient this$0, CancelKeyDeletionRequest paramCancelKeyDeletionRequest, AsyncHandler paramAsyncHandler) {}
  
  public CancelKeyDeletionResult call()
    throws Exception
  {
    CancelKeyDeletionResult result = null;
    try
    {
      result = this$0.executeCancelKeyDeletion(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */