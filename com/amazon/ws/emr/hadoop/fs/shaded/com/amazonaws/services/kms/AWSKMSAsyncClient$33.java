package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$33
  implements Callable<ReEncryptResult>
{
  AWSKMSAsyncClient$33(AWSKMSAsyncClient this$0, ReEncryptRequest paramReEncryptRequest, AsyncHandler paramAsyncHandler) {}
  
  public ReEncryptResult call()
    throws Exception
  {
    ReEncryptResult result = null;
    try
    {
      result = this$0.executeReEncrypt(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.33
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */