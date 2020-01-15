package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateKeyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$6
  implements Callable<CreateKeyResult>
{
  AWSKMSAsyncClient$6(AWSKMSAsyncClient this$0, CreateKeyRequest paramCreateKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateKeyResult call()
    throws Exception
  {
    CreateKeyResult result = null;
    try
    {
      result = this$0.executeCreateKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */