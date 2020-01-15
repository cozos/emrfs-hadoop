package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$13
  implements Callable<DisableKeyResult>
{
  AWSKMSAsyncClient$13(AWSKMSAsyncClient this$0, DisableKeyRequest paramDisableKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DisableKeyResult call()
    throws Exception
  {
    DisableKeyResult result = null;
    try
    {
      result = this$0.executeDisableKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */