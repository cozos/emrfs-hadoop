package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$32
  implements Callable<PutKeyPolicyResult>
{
  AWSKMSAsyncClient$32(AWSKMSAsyncClient this$0, PutKeyPolicyRequest paramPutKeyPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutKeyPolicyResult call()
    throws Exception
  {
    PutKeyPolicyResult result = null;
    try
    {
      result = this$0.executePutKeyPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.32
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */