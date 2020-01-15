package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResetServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResetServiceSpecificCredentialResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$114
  implements Callable<ResetServiceSpecificCredentialResult>
{
  AmazonIdentityManagementAsyncClient$114(AmazonIdentityManagementAsyncClient this$0, ResetServiceSpecificCredentialRequest paramResetServiceSpecificCredentialRequest, AsyncHandler paramAsyncHandler) {}
  
  public ResetServiceSpecificCredentialResult call()
    throws Exception
  {
    ResetServiceSpecificCredentialResult result = null;
    try
    {
      result = this$0.executeResetServiceSpecificCredential(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.114
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */