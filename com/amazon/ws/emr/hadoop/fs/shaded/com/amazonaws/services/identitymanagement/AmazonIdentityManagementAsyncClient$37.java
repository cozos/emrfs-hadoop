package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$37
  implements Callable<DeleteSSHPublicKeyResult>
{
  AmazonIdentityManagementAsyncClient$37(AmazonIdentityManagementAsyncClient this$0, DeleteSSHPublicKeyRequest paramDeleteSSHPublicKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteSSHPublicKeyResult call()
    throws Exception
  {
    DeleteSSHPublicKeyResult result = null;
    try
    {
      result = this$0.executeDeleteSSHPublicKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.37
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */