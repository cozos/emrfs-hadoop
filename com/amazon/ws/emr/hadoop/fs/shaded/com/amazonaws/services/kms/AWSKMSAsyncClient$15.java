package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisconnectCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$15
  implements Callable<DisconnectCustomKeyStoreResult>
{
  AWSKMSAsyncClient$15(AWSKMSAsyncClient this$0, DisconnectCustomKeyStoreRequest paramDisconnectCustomKeyStoreRequest, AsyncHandler paramAsyncHandler) {}
  
  public DisconnectCustomKeyStoreResult call()
    throws Exception
  {
    DisconnectCustomKeyStoreResult result = null;
    try
    {
      result = this$0.executeDisconnectCustomKeyStore(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */