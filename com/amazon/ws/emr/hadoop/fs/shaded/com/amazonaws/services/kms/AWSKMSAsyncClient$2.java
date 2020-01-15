package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$2
  implements Callable<ConnectCustomKeyStoreResult>
{
  AWSKMSAsyncClient$2(AWSKMSAsyncClient this$0, ConnectCustomKeyStoreRequest paramConnectCustomKeyStoreRequest, AsyncHandler paramAsyncHandler) {}
  
  public ConnectCustomKeyStoreResult call()
    throws Exception
  {
    ConnectCustomKeyStoreResult result = null;
    try
    {
      result = this$0.executeConnectCustomKeyStore(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */