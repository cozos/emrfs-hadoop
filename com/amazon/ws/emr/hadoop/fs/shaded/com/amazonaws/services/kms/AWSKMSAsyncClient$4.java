package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$4
  implements Callable<CreateCustomKeyStoreResult>
{
  AWSKMSAsyncClient$4(AWSKMSAsyncClient this$0, CreateCustomKeyStoreRequest paramCreateCustomKeyStoreRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateCustomKeyStoreResult call()
    throws Exception
  {
    CreateCustomKeyStoreResult result = null;
    try
    {
      result = this$0.executeCreateCustomKeyStore(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */