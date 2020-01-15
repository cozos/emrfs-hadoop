package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyRotationStatusRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyRotationStatusResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$23
  implements Callable<GetKeyRotationStatusResult>
{
  AWSKMSAsyncClient$23(AWSKMSAsyncClient this$0, GetKeyRotationStatusRequest paramGetKeyRotationStatusRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetKeyRotationStatusResult call()
    throws Exception
  {
    GetKeyRotationStatusResult result = null;
    try
    {
      result = this$0.executeGetKeyRotationStatus(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */