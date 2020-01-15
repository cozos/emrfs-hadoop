package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$40
  implements Callable<UpdateCustomKeyStoreResult>
{
  AWSKMSAsyncClient$40(AWSKMSAsyncClient this$0, UpdateCustomKeyStoreRequest paramUpdateCustomKeyStoreRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateCustomKeyStoreResult call()
    throws Exception
  {
    UpdateCustomKeyStoreResult result = null;
    try
    {
      result = this$0.executeUpdateCustomKeyStore(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.40
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */