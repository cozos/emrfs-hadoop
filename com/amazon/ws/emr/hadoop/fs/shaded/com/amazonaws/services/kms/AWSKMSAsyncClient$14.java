package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRotationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRotationResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$14
  implements Callable<DisableKeyRotationResult>
{
  AWSKMSAsyncClient$14(AWSKMSAsyncClient this$0, DisableKeyRotationRequest paramDisableKeyRotationRequest, AsyncHandler paramAsyncHandler) {}
  
  public DisableKeyRotationResult call()
    throws Exception
  {
    DisableKeyRotationResult result = null;
    try
    {
      result = this$0.executeDisableKeyRotation(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */