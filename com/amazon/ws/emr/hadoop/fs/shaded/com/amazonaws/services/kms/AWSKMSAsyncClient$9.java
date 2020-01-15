package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$9
  implements Callable<DeleteCustomKeyStoreResult>
{
  AWSKMSAsyncClient$9(AWSKMSAsyncClient this$0, DeleteCustomKeyStoreRequest paramDeleteCustomKeyStoreRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteCustomKeyStoreResult call()
    throws Exception
  {
    DeleteCustomKeyStoreResult result = null;
    try
    {
      result = this$0.executeDeleteCustomKeyStore(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */