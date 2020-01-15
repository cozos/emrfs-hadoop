package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$133
  implements Callable<UpdateSSHPublicKeyResult>
{
  AmazonIdentityManagementAsyncClient$133(AmazonIdentityManagementAsyncClient this$0, UpdateSSHPublicKeyRequest paramUpdateSSHPublicKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateSSHPublicKeyResult call()
    throws Exception
  {
    UpdateSSHPublicKeyResult result = null;
    try
    {
      result = this$0.executeUpdateSSHPublicKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.133
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */