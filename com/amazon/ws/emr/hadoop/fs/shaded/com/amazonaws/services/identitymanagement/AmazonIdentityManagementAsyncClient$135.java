package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServiceSpecificCredentialResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$135
  implements Callable<UpdateServiceSpecificCredentialResult>
{
  AmazonIdentityManagementAsyncClient$135(AmazonIdentityManagementAsyncClient this$0, UpdateServiceSpecificCredentialRequest paramUpdateServiceSpecificCredentialRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateServiceSpecificCredentialResult call()
    throws Exception
  {
    UpdateServiceSpecificCredentialResult result = null;
    try
    {
      result = this$0.executeUpdateServiceSpecificCredential(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.135
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */