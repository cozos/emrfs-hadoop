package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$7
  implements Callable<DecryptResult>
{
  AWSKMSAsyncClient$7(AWSKMSAsyncClient this$0, DecryptRequest paramDecryptRequest, AsyncHandler paramAsyncHandler) {}
  
  public DecryptResult call()
    throws Exception
  {
    DecryptResult result = null;
    try
    {
      result = this$0.executeDecrypt(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */