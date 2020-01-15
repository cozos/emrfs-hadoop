package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$16
  implements Callable<EnableKeyResult>
{
  AWSKMSAsyncClient$16(AWSKMSAsyncClient this$0, EnableKeyRequest paramEnableKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public EnableKeyResult call()
    throws Exception
  {
    EnableKeyResult result = null;
    try
    {
      result = this$0.executeEnableKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */