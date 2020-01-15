package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRotationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRotationResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$17
  implements Callable<EnableKeyRotationResult>
{
  AWSKMSAsyncClient$17(AWSKMSAsyncClient this$0, EnableKeyRotationRequest paramEnableKeyRotationRequest, AsyncHandler paramAsyncHandler) {}
  
  public EnableKeyRotationResult call()
    throws Exception
  {
    EnableKeyRotationResult result = null;
    try
    {
      result = this$0.executeEnableKeyRotation(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */