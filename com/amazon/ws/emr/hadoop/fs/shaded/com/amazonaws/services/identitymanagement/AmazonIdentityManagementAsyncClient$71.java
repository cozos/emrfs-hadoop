package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$71
  implements Callable<GetSSHPublicKeyResult>
{
  AmazonIdentityManagementAsyncClient$71(AmazonIdentityManagementAsyncClient this$0, GetSSHPublicKeyRequest paramGetSSHPublicKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetSSHPublicKeyResult call()
    throws Exception
  {
    GetSSHPublicKeyResult result = null;
    try
    {
      result = this$0.executeGetSSHPublicKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.71
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */