package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceSpecificCredentialResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$40
  implements Callable<DeleteServiceSpecificCredentialResult>
{
  AmazonIdentityManagementAsyncClient$40(AmazonIdentityManagementAsyncClient this$0, DeleteServiceSpecificCredentialRequest paramDeleteServiceSpecificCredentialRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteServiceSpecificCredentialResult call()
    throws Exception
  {
    DeleteServiceSpecificCredentialResult result = null;
    try
    {
      result = this$0.executeDeleteServiceSpecificCredential(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.40
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */