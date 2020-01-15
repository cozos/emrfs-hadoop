package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$36
  implements Callable<ScheduleKeyDeletionResult>
{
  AWSKMSAsyncClient$36(AWSKMSAsyncClient this$0, ScheduleKeyDeletionRequest paramScheduleKeyDeletionRequest, AsyncHandler paramAsyncHandler) {}
  
  public ScheduleKeyDeletionResult call()
    throws Exception
  {
    ScheduleKeyDeletionResult result = null;
    try
    {
      result = this$0.executeScheduleKeyDeletion(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.36
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */