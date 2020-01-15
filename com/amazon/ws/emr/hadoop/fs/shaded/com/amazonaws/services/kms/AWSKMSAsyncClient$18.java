package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$18
  implements Callable<EncryptResult>
{
  AWSKMSAsyncClient$18(AWSKMSAsyncClient this$0, EncryptRequest paramEncryptRequest, AsyncHandler paramAsyncHandler) {}
  
  public EncryptResult call()
    throws Exception
  {
    EncryptResult result = null;
    try
    {
      result = this$0.executeEncrypt(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */