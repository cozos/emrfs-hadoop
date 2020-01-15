package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyPolicyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$22
  implements Callable<GetKeyPolicyResult>
{
  AWSKMSAsyncClient$22(AWSKMSAsyncClient this$0, GetKeyPolicyRequest paramGetKeyPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetKeyPolicyResult call()
    throws Exception
  {
    GetKeyPolicyResult result = null;
    try
    {
      result = this$0.executeGetKeyPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */