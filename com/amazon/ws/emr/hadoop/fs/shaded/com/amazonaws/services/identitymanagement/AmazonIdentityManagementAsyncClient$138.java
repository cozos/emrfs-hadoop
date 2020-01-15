package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$138
  implements Callable<UploadSSHPublicKeyResult>
{
  AmazonIdentityManagementAsyncClient$138(AmazonIdentityManagementAsyncClient this$0, UploadSSHPublicKeyRequest paramUploadSSHPublicKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public UploadSSHPublicKeyResult call()
    throws Exception
  {
    UploadSSHPublicKeyResult result = null;
    try
    {
      result = this$0.executeUploadSSHPublicKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.138
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */